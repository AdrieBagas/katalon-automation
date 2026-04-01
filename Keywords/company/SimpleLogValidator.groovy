package company

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

public class SimpleLogValidator {

	/**
	 * Verifikasi Log dengan opsi parameter opsional.
	 * Jika parameter diisi null atau "", kolom tersebut akan di-skip (tidak diperiksa).
	 */
	@Keyword
	def verifyLog(String expAction = null, String expField = null, String expOld = null, String expNew = null, int rowIndex = 0) {

		// --- KONFIGURASI SELECTOR DINAMIS ---
		String rowPath = "//div[@data-ts-name='dialog-changelog']//tr[@data-p-index='${rowIndex}']"

		KeywordUtil.logInfo("Memverifikasi Log pada Baris Index: " + rowIndex)

		// Tentukan kolom mana untuk data apa (target ke td -> span)
		String xpathAction = rowPath + "/td[@data-ts-column-field='action']/span"
		String xpathField  = rowPath + "/td[@data-ts-column-field='field']/span"
		String xpathOld    = rowPath + "/td[@data-ts-column-field='oldValue']/span"
		String xpathNew    = rowPath + "/td[@data-ts-column-field='newValue']/span"

		// --- EKSEKUSI ---
		// Jika expAction null/kosong, checkItem tidak akan melakukan apa-apa
		checkItem(xpathAction, expAction, "Action (Baris ${rowIndex})")
		checkItem(xpathField,  expField,  "Field (Baris ${rowIndex})")
		checkItem(xpathOld,    expOld,    "Old Value (Baris ${rowIndex})")
		checkItem(xpathNew,    expNew,    "New Value (Baris ${rowIndex})")
	}

	// Fungsi helper untuk validasi
	private void checkItem(String xpath, String expected, String colName) {
		// Logika Utama: Hanya lanjut jika 'expected' memiliki isi
		if (expected != null && expected != "") {

			TestObject dynamicObject = new TestObject()
			dynamicObject.addProperty("xpath", ConditionType.EQUALS, xpath)

			try {
				WebUI.waitForElementVisible(dynamicObject, 10)
				String actual = WebUI.getText(dynamicObject).trim()

				if (!actual.contains(expected)) {
					KeywordUtil.markFailed("GAGAL [${colName}]: Harapan mengandung '${expected}', Aktual '${actual}'")
				} else {
					KeywordUtil.markPassed("OK [${colName}]: Sesuai (Actual '${actual}' contains '${expected}').")
				}
			} catch (Exception e) {
				KeywordUtil.markFailed("ERROR [${colName}]: Element tidak ditemukan. XPath: " + xpath)
			}
		} else {
			// Opsional: Memberi tahu di log bahwa kolom ini dilewati
			KeywordUtil.logInfo("SKIP [${colName}]: Nilai harapan kosong atau tidak diisi.")
		}
	}

	@Keyword
	def validateLogHeader(int divIndex, String expectedHeader) {
		WebDriver driver = DriverFactory.getWebDriver()

		// Membentuk XPath sesuai pola: div[index]//span
		String dynamicXpath = "//div[@data-pc-name='timeline']/div[${divIndex}]/div[@data-pc-section='content']//span"


		try {
			// Mengambil text dari elemen span tersebut
			String fullText = driver.findElement(By.xpath(dynamicXpath)).getText().trim()

			if (fullText.isEmpty()) {
				KeywordUtil.markWarning("Teks pada div[${divIndex}] kosong.")
				return
			}

			// Memisahkan Header (teks pertama) dan Body (sisanya)
			// Limit 2 artinya hanya memecah pada spasi pertama yang ditemukan
			String[] splitText = fullText.split("\\s+", 2)
			String actualHeader = splitText[0]
			String bodyLog = (splitText.length > 1) ? splitText[1] : "[Tidak ada teks tambahan]"

			// Proses Validasi Header
			if (actualHeader.equalsIgnoreCase(expectedHeader)) {
				KeywordUtil.markPassed("VALIDASI BERHASIL: Index ${divIndex} memiliki Header '${actualHeader}'")
			} else {
				KeywordUtil.markFailed("VALIDASI GAGAL: Index ${divIndex} Header-nya adalah '${actualHeader}', tapi diharapkan '${expectedHeader}'")
			}

			// Print sisa log ke Console
			println "--------------------------------------------"
			println "INDEX DIV: ${divIndex}"
			println "HEADER   : ${actualHeader}"
			println "CONTENT  : ${bodyLog}"
			println "--------------------------------------------"
		} catch (Exception e) {
			KeywordUtil.markFailed("Gagal menemukan elemen dengan XPath: ${dynamicXpath}. Error: " + e.message)
		}
	}

	@Keyword
	def verifyLastRowVisible(String Name, int timeout = 5) {
		// XPath dinamis untuk baris terakhir yang mengandung teks spesifik
		String xpath = "(//tr[.//span[contains(., '${Name}')]])[last()]"

		TestObject lastRow = new TestObject("lastRow_" + Name)
		lastRow.addProperty("xpath", ConditionType.EQUALS, xpath)

		// Melakukan verifikasi visibilitas
		boolean isVisible = WebUI.waitForElementVisible(lastRow, timeout)

		if (isVisible) {
			WebUI.scrollToElement(lastRow, 2)
			KeywordUtil.markPassed("Sukses: Baris terakhir dengan teks '${Name}' terlihat di tabel.")
			return true
		} else {
			KeywordUtil.markFailed("Gagal: Baris terakhir dengan teks '${Name}' tidak ditemukan setelah menunggu ${timeout} detik.")
			return false
		}
	}
}


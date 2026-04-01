package company

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import java.time.Duration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import internal.GlobalVariable

public class GeneralHelper {
	@Keyword
	def uploadFileInProject(TestObject to, String relativePath) {
		String fullPath = RunConfiguration.getProjectDir() + "/" + relativePath
		WebUI.uploadFile(to, fullPath)
		//WebUI.click(findTestObject('login session object/Button - Apply'))
	}

	// Untuk cek icon disposable group
	@Keyword
	def checkDisposableIcon(String groupName) {
		String xpath = "//ul[@role='group']//span[text()='${groupName}']/following-sibling::i"

		TestObject disposableIcon = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(disposableIcon, 5)
		WebUI.verifyElementVisible(disposableIcon)
		KeywordUtil.logInfo("Icon terlihat: " + groupName)
	}
}

public class DateAndElementHelper {

	/**
	 * Menghitung tanggal, lalu klik elemen <li> yang memiliki aria-label sesuai tanggal tersebut
	 * @param indexValue Pilihan urutan format (1-5) sesuai gambar
	 * @return String tanggal yang diklik
	 */
	@Keyword
	def selectDate(String indexValue) {

		// 1. Definisikan pola berdasarkan urutan di gambar
		String[] patterns = [
			"dd/MM/yy",
			// Index 1: 15/01/26
			"M/dd/yy",
			// Index 2: 1/15/26
			"dd MMM yy",
			// Index 3: 15 Jan 26
			"EEE, dd MMM yy",
			// Index 4: Thu, 15 Jan 26
			"EEE, dd MMM yyyy"      // Index 5: Thu, 15 Jan 2026
		]

		int arrayIdx = Integer.parseInt(indexValue) - 1
		String selectedPattern = patterns[arrayIdx]

		// 2. Generate string tanggal hari ini (Misal: Thu, 15 Jan 2026)
		LocalDate today = LocalDate.now()
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(selectedPattern, Locale.ENGLISH)
		String formattedDate = today.format(formatter)

		// 3. Buat XPath dinamis menggunakan aria-label
		// XPath: //li[@aria-label='Thu, 15 Jan 2026']
		String dynamicXPath = "//li[@aria-label='" + formattedDate + "']"

		TestObject dynamicObject = new TestObject("dynamicDateOption")
		dynamicObject.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		// 4. Aksi Klik
		WebUI.waitForElementVisible(dynamicObject, 5) // Menunggu munculnya dropdown
		WebUI.click(dynamicObject)

		WebUI.comment("Berhasil klik elemen dengan aria-label: " + formattedDate)

		return formattedDate
	}
}

public class AliasStructureHelper {

	// XPath list utama
	private static final String LIST_XPATH = "//ul[@id='draggable-list']"
	private static final String PREVIEW_XPATH = "//div[text()='Preview:']/following-sibling::div"

	@Keyword
	def verifyPreviewCode(String initialValue, String separatorValue) {

		// Mapping Alias berdasarkan atribut 'name' yang ada di elemen <li>
		Map<String, String> aliasMap = [
			"Asset Name"     : "003",
			"Category"       : "CAT1",
			"Group"          : "ASD",
			"Purchase Date"  : "0225",
			"Asset Increment": "0001"
		]

		try {
			KeywordUtil.logInfo("--- START VALIDASI VIA ATRIBUT ---")

			TestObject dynamicList = new TestObject().addProperty("xpath", ConditionType.EQUALS, LIST_XPATH)
			WebElement ulElement = WebUI.findWebElement(dynamicList, 10)

			// Ambil semua elemen <li> secara langsung
			List<WebElement> rows = ulElement.findElements(By.tagName("li"))
			List<String> constructedParts = new ArrayList<>()

			KeywordUtil.logInfo("Mendeteksi ${rows.size()} elemen dalam list.")

			for (int i = 1; i <= rows.size(); i++) {
				// 1. XPath untuk baris <li> saat ini
				String rowXpath = "(${LIST_XPATH}/li)[${i}]"
				TestObject rowObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, rowXpath)

				// 2. Ambil atribut 'name' dari elemen <li>
				String itemName = WebUI.getAttribute(rowObj, "name")

				// 3. Cek apakah checkbox di dalam baris ini dicentang
				String checkboxXpath = "${rowXpath}//input[@type='checkbox']"
				TestObject cbObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, checkboxXpath)
				boolean isChecked = WebUI.verifyElementChecked(cbObject, 1, FailureHandling.OPTIONAL)

				if (isChecked) {
					if (itemName == null || itemName.isEmpty()) {
						KeywordUtil.markWarning("Baris ${i} tercentang tapi atribut 'name' KOSONG.")
						continue
					}

					String valueToAdd = ""
					if (itemName.equalsIgnoreCase("Initial")) {
						valueToAdd = initialValue
					} else if (aliasMap.containsKey(itemName)) {
						valueToAdd = aliasMap.get(itemName)
					}

					if (!valueToAdd.isEmpty()) {
						constructedParts.add(valueToAdd)
						KeywordUtil.logInfo("Baris ${i} [${itemName}]: TERCENTANG -> Nilai: ${valueToAdd}")
					} else {
						KeywordUtil.markWarning("Baris ${i} [${itemName}]: Tercentang tapi tidak ada di Mapping Alias.")
					}
				} else {
					KeywordUtil.logInfo("Baris ${i} [${itemName}]: Tidak tercentang (Dilewati).")
				}
			}

			// 4. Gabungkan dan Bandingkan
			String expectedCode = constructedParts.join(separatorValue)

			TestObject previewObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, PREVIEW_XPATH)
			WebUI.waitForElementVisible(previewObj, 5)
			String actualCode = WebUI.getText(previewObj).trim()

			KeywordUtil.logInfo("Hasil Akhir - Expected: ${expectedCode} | Actual: ${actualCode}")

			if (actualCode.equals(expectedCode)) {
				KeywordUtil.markPassed("PASSED: Preview sesuai urutan atribut dan checkbox.")
			} else {
				KeywordUtil.markFailed("FAILED: Preview tidak cocok! Cek urutan atau mapping alias.")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("ERROR: Gagal saat mengambil atribut. Pesan: " + e.getMessage())
		}
	}
}
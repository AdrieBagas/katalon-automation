package company

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

public class AssetListValidator {

	/**
	 * Verifikasi Asset Row dengan dukungan status koneksi Tag.
	 */
	@Keyword
	def verifyAssetRow(
			String expName = null,
			String expTagType = null,
			Map<String, String> extraFields = [:],
			int rowIndex = 0,
			boolean isTagConnected = true
	) {

		KeywordUtil.logInfo("=== VERIFIKASI BARIS INDEX: ${rowIndex} (Tag Connected: ${isTagConnected}) ===")
		String rowPath = "//tr[@data-p-index='${rowIndex}']"

		// --- 1. VERIFIKASI FIELD UTAMA (NAME) ---
		if (expName != null) {
			String xpathName = rowPath + "//td[@data-ts-column-field='name']//span"
			// Gunakan ignoreCase = true di sini
			checkText(xpathName, expName, "Name", true)
		}

		// --- 2. VERIFIKASI TAG ICONS ---
		if (expTagType != null) {
			String xpathIconRfid = rowPath + "//td[contains(@class, 'col-tag')]//i[contains(@class, 'rfid-icon')]"
			String xpathIconQr   = rowPath + "//td[contains(@class, 'col-tag')]//i[contains(@class, 'qr-icon')]"
			verifyTagIcons(xpathIconRfid, xpathIconQr, expTagType, isTagConnected)
		}

		// --- 3. VERIFIKASI FIELD DINAMIS ---
		extraFields.each { fieldKey, expectedValue ->
			if (expectedValue != null) {
				verifyFlexibleField(rowPath, fieldKey, expectedValue)
			}
		}

		KeywordUtil.logInfo("=== SELESAI VERIFIKASI ===")
	}

	// --- HELPER LOGIC ---

	private void verifyTagIcons(String rfidXpath, String qrXpath, String expectedType, boolean isConnected) {
		String activeClassMarker = "text-primary"

		boolean isRfidVisuallyActive = isIconActive(rfidXpath, activeClassMarker)
		boolean isQrVisuallyActive   = isIconActive(qrXpath, activeClassMarker)

		boolean expectRfidActive = false
		boolean expectQrActive   = false

		// Memastikan input expectedType di-handle secara Case-Insensitive
		String type = expectedType?.toUpperCase()

		if (type == "RFID") {
			expectRfidActive = isConnected
		} else if (type == "QR") {
			expectQrActive   = isConnected
		} else if (type == "BOTH") {
			expectRfidActive = isConnected
			expectQrActive   = isConnected
		}

		boolean rfidMatch = (isRfidVisuallyActive == expectRfidActive)
		boolean qrMatch   = (isQrVisuallyActive == expectQrActive)

		if (rfidMatch && qrMatch) {
			KeywordUtil.markPassed("OK [Tag]: Tipe '${type}' (Connected:${isConnected}) Sesuai.")
		} else {
			KeywordUtil.markFailed("""GAGAL [Tag]: 
				Ekspektasi Tipe: ${type} (Connected: ${isConnected}) -> Harapan [RFID:${expectRfidActive}, QR:${expectQrActive}]
				Aktual Visual -> [RFID:${isRfidVisuallyActive}, QR:${isQrVisuallyActive}]""")
		}
	}

	private void verifyFlexibleField(String rowPath, String fieldKey, String expectedValue) {
		String actualText = getFlexibleText(rowPath, fieldKey)

		// Menggunakan perbandingan Case-Insensitive (Abaikan huruf besar/kecil)
		if (actualText.equalsIgnoreCase(expectedValue)) {
			KeywordUtil.markPassed("OK [${fieldKey}]: Sesuai '${actualText}'")
		} else {
			KeywordUtil.markFailed("GAGAL [${fieldKey}]: Harapan '${expectedValue}', Aktual '${actualText}'")
		}
	}

	private void checkText(String xpath, String expected, String colName, boolean useContains) {
		TestObject to = createDynamicObject(xpath)
		try {
			WebUI.waitForElementVisible(to, 3)
			String actual = WebUI.getText(to).trim()

			// Implementasi Case-Insensitive (Konversi keduanya ke LowerCase)
			boolean isPassed = useContains ?
					actual.toLowerCase().contains(expected?.toLowerCase()) :
					actual.equalsIgnoreCase(expected)

			if (isPassed) {
				KeywordUtil.markPassed("OK [${colName}]: Sesuai.")
			} else {
				KeywordUtil.markFailed("GAGAL [${colName}]: Harapan '${expected}', Aktual '${actual}'")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("ERROR [${colName}]: Element tidak ditemukan -> " + xpath)
		}
	}

	private boolean isIconActive(String xpath, String activeMarker) {
		TestObject to = createDynamicObject(xpath)
		try {
			String classValue = WebUI.getAttribute(to, "class")
			return classValue != null && classValue.contains(activeMarker)
		} catch (Exception e) {
			return false
		}
	}

	private TestObject createDynamicObject(String xpath) {
		TestObject to = new TestObject()
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		return to
	}

	private String getFlexibleText(String rowPath, String fieldKey) {
		String xpathBadge = rowPath + "//td[@data-ts-column-field='${fieldKey}']/span/span"
		String xpathText  = rowPath + "//td[@data-ts-column-field='${fieldKey}']/span"

		TestObject objBadge = createDynamicObject(xpathBadge)
		TestObject objText  = createDynamicObject(xpathText)

		try {
			// Cek apakah data dibungkus badge (span di dalam span)
			if (WebUI.verifyElementVisible(objBadge, FailureHandling.OPTIONAL)) {
				return WebUI.getText(objBadge).trim()
			} else if (WebUI.verifyElementVisible(objText, FailureHandling.OPTIONAL)) {
				return WebUI.getText(objText).trim()
			}
			return ""
		} catch (Exception e) {
			return ""
		}
	}

	/**
	 * KEYWORD: VERIFIKASI BANYAK KOLOM SEKALIGUS (BULK CHECK)
	 */
	@Keyword
	def verifySpecificRowData(Map<String, String> expectedDataMap, int rowIndex = 0) {
		KeywordUtil.logInfo("=== MULAI BULK CHECK BARIS KE-${rowIndex} ===")
		String rowPath = "//tr[@data-p-index='${rowIndex}']"
		boolean allColumnsPassed = true

		expectedDataMap.each { colField, expectedVal ->
			String actualText = getFlexibleText(rowPath, colField)

			// Gunakan equalsIgnoreCase agar 'aktif' == 'Aktif' == 'AKTIF'
			if (actualText.equalsIgnoreCase(expectedVal)) {
				KeywordUtil.markPassed("OK [${colField}]: Sesuai '${actualText}'")
			} else {
				KeywordUtil.markFailed("GAGAL [${colField}]: Harapan '${expectedVal}', Aktual '${actualText}'")
				allColumnsPassed = false
			}
		}

		if (!allColumnsPassed) {
			KeywordUtil.markFailed("=== BULK CHECK BARIS ${rowIndex} ADA YANG GAGAL ===")
		}
	}
}
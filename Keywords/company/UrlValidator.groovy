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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable // Wajib import ini untuk akses GlobalVariable

public class UrlValidator {

	/**
	 * Mengecek URL. Jika salah, otomatis navigasi ke GlobalVariable.URL + endpoint.
	 * @param endpoint String path URL (contoh: 'dashboard' atau '/login')
	 */
	@Keyword
	def verifyUrl(String endpoint) {

		// 1. Ambil URL saat ini
		String actualUrl = WebUI.getUrl()

		// 2. Cek apakah URL saat ini mengandung endpoint yang diharapkan
		// Kita pakai contains agar fleksibel (misal ada query param)
		if (actualUrl.contains(endpoint)) {

			KeywordUtil.markPassed("VALIDASI SUKSES: User sudah berada di halaman yang benar (" + endpoint + ")")
		} else {

			// --- STEP PERBAIKAN (RECOVERY) ---

			// 3. Susun URL Target (Global Var + Endpoint)
			// Logika replaceAll ini untuk mencegah double slash (misal: domain.com//dashboard)
			String baseUrl = GlobalVariable.UrlFam.toString().replaceAll("/+\$", "")
			String cleanEndpoint = endpoint.replaceAll("^/+", "")
			String targetUrl = baseUrl + "/" + cleanEndpoint

			KeywordUtil.logInfo("URL MISMATCH: Saat ini di '${actualUrl}'. Mencoba navigasi paksa ke: ${targetUrl}")

			// 4. Lakukan Navigasi
			WebUI.navigateToUrl(targetUrl)
			WebUI.delay(10) // Tunggu loading selesai (maks 10 detik)

			// 5. Validasi Ulang (Pastikan navigasi berhasil)
			String newUrl = WebUI.getUrl()
			if (newUrl.contains(endpoint)) {
				KeywordUtil.markPassed("RECOVERY SUKSES: Berhasil pindah ke halaman " + endpoint)
			} else {
				// Jika sudah dinavigasi tapi masih salah (misal redirect balik ke login karena sesi habis)
				KeywordUtil.markFailed("RECOVERY GAGAL: Sudah navigasi ke '${targetUrl}' tapi URL akhir adalah '${newUrl}'")
			}
		}
	}
}
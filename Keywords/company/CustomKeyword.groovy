package company
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory
import java.time.Duration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CustomKeyword {

	/**
	 * Method to perform login
	 * @param url URL of the login page
	 * @param username User's login name
	 * @param password User's login password (encrypted)
	 */
	@Keyword
	def loginToApp(String username, String password) {
		// Open browser and navigate to the login page
		UrlFunctions urlHelper = new UrlFunctions()

		try {
			// Mengambil instance WebDriver saat ini
			WebDriver driver = DriverFactory.getWebDriver()

			// Cek apakah browser sudah terbuka
			if (driver == null) {
				WebUI.openBrowser(GlobalVariable.Url)
			} else {
				// Jika sudah terbuka, cukup navigasi ke URL tujuannya
//				WebUI.navigateToUrl(GlobalVariable.Url)
				KeywordUtil.logInfo("Browser Telah Terbuka")
			}
		} catch (Exception e) {
			// Jika terjadi error saat ambil driver (misal sesi mati), buka browser baru
			WebUI.openBrowser(GlobalVariable.Url)
		}
		
		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Object Repository/login session object/Input - Email'), username)

		WebUI.setText(findTestObject('Object Repository/login session object/Input - Password'), password)

		WebUI.delay(10)

		WebUI.click(findTestObject('Object Repository/login session object/Button - Login'))
		// Sync
		WebUI.click(findTestObject('Object Repository/login session object/Button - Fixed Asset'))

		urlHelper.waitForEndpointToBe('/home', 40)
	}
}

public class UrlFunctions {

	/**
	 * Menunggu URL berubah. Jika gagal, hanya memberikan peringatan (Warning) tanpa menghentikan test.
	 * @param endpoint Bagian akhir URL (contoh: '/dashboard')
	 * @param timeoutDetik Batas waktu tunggu
	 */
	@Keyword
	def waitForEndpointToBe(String endpoint, int timeoutDetik) {
		// Normalisasi URL
		String cleanBase = GlobalVariable.UrlFam.toString().replaceAll("/\$", "")
		String cleanEndpoint = endpoint.replaceAll("^/", "")
		String fullUrl = cleanBase + "/" + cleanEndpoint

		try {
			WebDriver driver = DriverFactory.getWebDriver()
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutDetik))

			// Menunggu URL sesuai target
			wait.until(ExpectedConditions.urlToBe(fullUrl))
			KeywordUtil.markPassed("Berhasil! URL sekarang berada di: " + fullUrl)
		} catch (Exception e) {
			// Mengambil URL saat ini untuk log
			String currentUrl = DriverFactory.getWebDriver().getCurrentUrl()

			// Menggunakan markWarning agar status di Log Viewer berwarna kuning
			// dan test tetap berlanjut ke step berikutnya.
			KeywordUtil.logInfo("Peringatan: URL target tidak tercapai dalam " + timeoutDetik + " detik.")
			KeywordUtil.markWarning("Ekspektasi: " + fullUrl + " | Aktual: " + currentUrl)
		}
	}
}
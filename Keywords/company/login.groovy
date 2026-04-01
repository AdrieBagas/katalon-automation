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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

class login {

	/**
	 * Method to perform login dengan pengecekan status browser
	 */
	@Keyword
	def loginToApp(String url, String username, String password) {

		try {
			// Mengambil instance WebDriver saat ini
			WebDriver driver = DriverFactory.getWebDriver()

			// Cek apakah browser sudah terbuka
			if (driver == null) {
				WebUI.openBrowser(url)
			} else {
				// Jika sudah terbuka, cukup navigasi ke URL tujuannya
				WebUI.navigateToUrl(url)
			}
		} catch (Exception e) {
			// Jika terjadi error saat ambil driver (misal sesi mati), buka browser baru
			WebUI.openBrowser(url)
		}

		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('login session object/Input - Email'), username)

		WebUI.setText(findTestObject('login session object/Input - Password'), password)

		WebUI.click(findTestObject('login session object/Button - Login'))

		WebUI.delay(5) // Kurangi delay jika tidak sangat diperlukan untuk stabilitas
	}
}
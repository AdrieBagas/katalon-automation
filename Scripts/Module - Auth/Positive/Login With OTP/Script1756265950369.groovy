import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.Url)

WebUI.click(findTestObject('login session object/Button - Login With OTP'))

WebUI.setText(findTestObject('login session object/Input - Email'), '')

WebUI.click(findTestObject('login session object/Button - Request OTP'))

WebUI.newTab('mailnesia.com')

WebUI.setText(findTestObject('Object - Custom Field/input - mailnesia'), GlobalVariable.mailnesiaemail)

WebUI.click(findTestObject('Object - Custom Field/button - submit'))

WebUI.click(findTestObject('Object - Custom Field/email - OTP'))

codeotp = WebUI.getText(findTestObject('Object - Custom Field/code - OTP'))

WebUI.switchToWindowIndex(0)

WebUI.delay(3)

for (int i = 0; i < codeotp.length(); i++) {
    // Ambil karakter berdasarkan posisinya saat ini
    String huruf = codeotp[i]

    // Tentukan indeks untuk XPath. XPath index dimulai dari 1, sedangkan loop index (i) dimulai dari 0.
    // Jadi, kita perlu menambahkan 1.
    int otpIndex = i + 1

    println("Mengisi kotak ke-$otpIndex dengan karakter '$huruf'")

    // Buat Test Object dinamis dengan memberikan nilai untuk variabel 'index'
    TestObject inputOtpSaatIni = findTestObject("login session object/Input - OTP $otpIndex")

    // Gunakan setText untuk mengisi setiap kotak input. Ini lebih stabil untuk OTP.
    WebUI.setText(inputOtpSaatIni, huruf.toString())
}


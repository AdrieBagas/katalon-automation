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

CustomKeywords.'company.UrlValidator.verifyUrl'('/settings/user')

WebUI.click(findTestObject('Object - User/Button - titik tiga'))

WebUI.click(findTestObject('Object - User/Action - Detail'))

if (WebUI.verifyElementChecked(findTestObject('Object - User/Checkbox - Swith Active User'), 1)) {
    WebUI.uncheck(findTestObject('Object - User/Switch - active user detail'))

    WebUI.waitForElementNotVisible(findTestObject('Object - User/Toast - Success'), 3)
}

WebUI.check(findTestObject('Object - User/Switch - active user detail'))

WebUI.waitForElementVisible(findTestObject('Object - User/Toast - Success'), 1)

WebUI.verifyElementText(findTestObject('Object - User/Toast - Success'), 'Success, user has been activated.')

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Active Status', 'Inactive', 'Active', 0)


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

CustomKeywords.'company.CustomKeyword.loginToApp'(GlobalVariable.EmailManajer, GlobalVariable.Password)

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/borrow/transaction')

WebUI.click(findTestObject('Object - Borrow/Button - Borrow Request'))

WebUI.click(findTestObject('Object - Borrow/Action - Handover'))

WebUI.click(findTestObject('Object - Borrow/Button - Verify Asset'))

WebUI.click(findTestObject('Object - Borrow/Button - Scan RFID'))

WebUI.delay(5)

WebUI.click(findTestObject('Object - Borrow/Button - Next'))

WebUI.click(findTestObject('login session object/Button - Profile'))

WebUI.click(findTestObject('login session object/Action - Logout'))

CustomKeywords.'company.login.loginToApp'('dev-app.tagsamurai.com', 'qa-023@mailnesia.com', 'Gaadaobatnya1@')

WebUI.click(findTestObject('login session object/Button - Profile'))

WebUI.click(findTestObject('login session object/Action - My Asset'))

WebUI.click(findTestObject('login session object/Task - My Asset Borrow'))

WebUI.click(findTestObject('Object - Borrow/Button - Action'))

WebUI.click(findTestObject('Object - Borrow/Action - Confirm Handover'))

WebUI.check(findTestObject('Object - Borrow/Checkbox - Asset to Borrow'))

WebUI.click(findTestObject('Object - Borrow/Button - Confirm'))

WebUI.verifyElementText(findTestObject('Object - Borrow/Toast - Success'), 'Success, asset handover has been confirmed.')

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/borrow/transaction')

WebUI.click(findTestObject('Object - Borrow/Button - Borrow Request'))

WebUI.click(findTestObject('Object - Borrow/Action - Handover'))

WebUI.verifyElementText(findTestObject('Object - Borrow/Toast - Success'), 'Success, Asset has been handed over.')

WebUI.click(findTestObject('Object - Borrow/Tab - borrowed'))

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Borrowed'], 0)


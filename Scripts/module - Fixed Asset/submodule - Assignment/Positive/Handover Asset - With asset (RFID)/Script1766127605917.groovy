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

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/assignment/transaction')

WebUI.click(findTestObject('Object - Assignment/Button - Action'))

WebUI.click(findTestObject('Object - Assignment/Action - Handover'))

WebUI.click(findTestObject('Object - Borrow/Button - Verify Asset'))

WebUI.click(findTestObject('Object - Borrow/Button - Scan RFID'))

WebUI.delay(5)

WebUI.click(findTestObject('Object - Assignment/Button - Next'))

WebUI.click(findTestObject('login session object/Button - Profile'))

WebUI.click(findTestObject('login session object/Action - Logout'))

CustomKeywords.'company.CustomKeyword.loginToApp'(GlobalVariable.EmailBasic, GlobalVariable.Password)

WebUI.click(findTestObject('login session object/Button - Profile'))

WebUI.click(findTestObject('login session object/Action - My Asset'))

WebUI.click(findTestObject('Object - Assignment/Action - Confirm Handover'))

WebUI.check(findTestObject('Object - Assignment/Checkbox - Asset to Assign'))

WebUI.click(findTestObject('Object - Borrow/Button - Confirm'))

WebUI.click(findTestObject('Object - Borrow/Button - Continue'))

WebUI.verifyElementText(findTestObject('Object - Borrow/Toast - Success'), 'Success, asset handover has been confirmed.')

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/assignment/transaction')

WebUI.click(findTestObject('Object - Assignment/Button - Action'))

WebUI.click(findTestObject('Object - Assignment/Action - Handover'))

WebUI.verifyElementText(findTestObject('Object - Assignment/Toast - Success'), 'Success, asset  has been handed over.')

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Assigned'], 0)


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

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/transfer/transaction')

WebUI.click(findTestObject('Object - Transfer/Button - Transfer'))

WebUI.click(findTestObject('Object - Transfer/Button - Asset'))

WebUI.check(findTestObject('Object - Transfer/Checkbox - Asset to Transfer'))

WebUI.click(findTestObject('Object - Transfer/Button - Select'))

WebUI.click(findTestObject('Object - Transfer/Button - Select group'))

WebUI.click(findTestObject('Object - Transfer/List - Group No Approver 2'))

WebUI.click(findTestObject('Object - Transfer/Button - Select'))

WebUI.click(findTestObject('Object - Transfer/Button - Submit'))

WebUI.waitForElementVisible(findTestObject('Object - Transfer/Toast - Success'), 5)

WebUI.verifyElementText(findTestObject('Object - Transfer/Toast - Success'), 'Success, transfer request has been submitted.')

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Waiting for Handover'], 0)


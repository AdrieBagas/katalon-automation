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

CustomKeywords.'company.UrlValidator.verifyUrl'('/approval/transfer')

WebUI.click(findTestObject('Object - Transfer/Button - Action'))

WebUI.click(findTestObject('Object - Transfer/Action - Approval'))

WebUI.check(findTestObject('Object - Transfer/Switch - Approval'))

WebUI.setText(findTestObject('Object - Transfer/Input - Note'), 'Dipindahkan')

WebUI.click(findTestObject('Object - Transfer/Button - Submit'))

WebUI.click(findTestObject('Object - Transfer/Button Confirm - Submit'))

WebUI.verifyElementText(findTestObject('Object - Transfer/Toast - Success'), 'Success, approval has been submitted.')

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/transfer/transaction')

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Waiting for Handover'], 0)


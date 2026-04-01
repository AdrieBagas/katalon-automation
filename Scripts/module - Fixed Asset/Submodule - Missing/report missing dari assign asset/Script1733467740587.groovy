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

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/div_Fixed Asset'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/div_Assignment'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/button_Fri, Dec 06, 2024, 020951 PM_button-_753924'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/a_Report Missing'))

WebUI.setText(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/textarea__resize-none min-h-67px min-h-78px_00da71'), 'hilang')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/button_Report'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/div_Missing'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/button_Fri, Dec 06, 2024, 021021 PM_button-_f3c9b8'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/a_Mark as Found'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/div_Assignment'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/button_Fri, Dec 06, 2024, 020951 PM_button-_753924'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/a_Confirmation'))

WebUI.click(findTestObject('Page_(9) Fixed Asset - TAG SAMURAI/span_Select Action'))

WebUI.click(findTestObject('Object Repository/Object - Missing/Page_(9) Fixed Asset - TAG SAMURAI/li_Back to assigned asset'))

WebUI.click(findTestObject('null'))


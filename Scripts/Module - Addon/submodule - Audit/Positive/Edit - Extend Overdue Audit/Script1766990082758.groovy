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

WebUI.click(findTestObject('Object - Audit/Tab - Task'))

WebUI.click(findTestObject('Object - Audit/Button - Navigate Page', [('page') : '2']))

CustomKeywords.'company.SpecificElipsis.chooseSpesificTask'(GlobalVariable.defaultTaskName)

WebUI.click(findTestObject('Object - Audit/List - Elipsis Update'))

WebUI.check(findTestObject('Object - Audit/Radio Button - Extend Audit'))

WebUI.setText(findTestObject('Object - Audit/Input - Audit Duration'), '3')

WebUI.setText(findTestObject('Object - Audit/Input - Note'), GlobalVariable.generatedNameWithoutChar)

WebUI.click(findTestObject('Object - Audit/Button - Submit in Main Page'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Audit/Toast - Success'), 'Success, audit submission has been updated.')

WebUI.click(findTestObject('Object - Audit/Button - Elipsis Table', [('taskName') : 'test-baru']))

WebUI.click(findTestObject('Object - Audit/List - Elipsis Detail'))

WebUI.click(findTestObject('Object - Audit/Button - Event Log'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Verify - Text in Log', [('textLog') : 'Audit extended']), FailureHandling.STOP_ON_FAILURE)


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

WebUI.click(findTestObject('Object - Maintenance Routine/Tab - Operations'))

WebUI.click(findTestObject('Object - Maintenance Routine/Badge - Indicator'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Template'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Template Name'), 'Testing Template Single Value')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Select Category in Dialog'))

CustomKeywords.'company.EntitySelector.selectCategoryInDialog'(GlobalVariable.defaultCategory)

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Select'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Template Description'), GlobalVariable.generatedName)

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Indicator'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Indicator Name'), 'Servis')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Single Value'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Value Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Number'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Measurement'), 'Suhu')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Save'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Submit'))

WebUI.verifyElementVisible(findTestObject('Object - Maintenance Routine/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Maintenance Routine/Toast - Success'), 'Success, template has been created.')


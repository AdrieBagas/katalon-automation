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

WebUI.click(findTestObject('Object - Missing/Tab - Reported'))

WebUI.click(findTestObject('Object - Missing/Checkbox - Check All Data Table'))

WebUI.click(findTestObject('Object - Missing/Button - Bulk Action'))

WebUI.click(findTestObject('Object - Missing/List Elipsis - Report Disposal'))

WebUI.click(findTestObject('Object - Missing/Checkbox - Check All Data Table'))

WebUI.click(findTestObject('Object - Missing/Button - Bulk Action'))

WebUI.click(findTestObject('Object - Missing/List Elipsis - Note'))

WebUI.setText(findTestObject('Object - Missing/Input - Note in Bulk Action'), GlobalVariable.generatedOver30Name)

WebUI.click(findTestObject('Object - Missing/Button - Apply in Bulk Action'))

WebUI.click(findTestObject('Object - Missing/Button - Submit in Main Page'))

WebUI.verifyElementVisible(findTestObject('Object - Missing/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Missing/Toast - Success'), 'Success, disposal report has been submitted.')


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

CustomKeywords.'company.SpecificElipsis.chooseSpesificTask'(GlobalVariable.defaultTaskName)

WebUI.click(findTestObject('Object - Audit/List - Elipsis Detail'))

WebUI.click(findTestObject('Object - Audit/Button - Audit QR'))

WebUI.click(findTestObject('Object - Audit/Button - Select Group in Dialog'))

WebUI.click(findTestObject('Object - Audit/Button - Select Group in List', [('groupName') : 'Test Audit']))

WebUI.click(findTestObject('Object - Audit/Button - Select'))

WebUI.click(findTestObject('Object - Audit/Button - Start Audit'))

WebUI.click(findTestObject('Object - Audit/Button - Sync'))

WebUI.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object - Audit/Button - Close Dialog'))

WebUI.click(findTestObject('Object - Audit/Button - Update'))

WebUI.click(findTestObject('Object - Audit/Button - Scan QR'))

WebUI.click(findTestObject('Object - Audit/Dropdown - Option Condition in Dialog'))

WebUI.click(findTestObject('Object - Audit/List - Dropdown Asset found, normal condition'))

WebUI.setText(findTestObject('Object - Audit/Input - Note'), GlobalVariable.generatedOver30Name)

WebUI.click(findTestObject('Object - Audit/Button - Submit in Main Page'))

WebUI.click(findTestObject('Object - Audit/Tab - Audited'))

WebUI.click(findTestObject('Object - Audit/Button - Elipsis Table Auditable Assets', [('name') : 'AssetAditQR - 1469']))

WebUI.click(findTestObject('Object - Audit/List - Elipsis Edit Condition'))

WebUI.click(findTestObject('Object - Audit/Button - QR Verification'))

WebUI.click(findTestObject('Object - Audit/Dropdown - Option Condition in Dialog'))

WebUI.click(findTestObject('Object - Audit/List - Dropdown Asset found, normal condition'))

WebUI.setText(findTestObject('Object - Audit/Input - Note'), GlobalVariable.generatedOver30Name)

WebUI.click(findTestObject('Object - Audit/Button - Save'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Audit/Toast - Success'), 'Success, audit condition has been edited.')

WebUI.click(findTestObject('Object - Audit/Button - Finish'))

WebUI.click(findTestObject('Object - Audit/Button - Finish in Dialog'))


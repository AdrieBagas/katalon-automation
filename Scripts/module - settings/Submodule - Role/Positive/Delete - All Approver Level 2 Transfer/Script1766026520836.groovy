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

WebUI.click(findTestObject('Object - Settings - Role/Tab - Transfer'))

'Always include the \'groupName\' variable to target the XPath.'
WebUI.click(findTestObject('Object - Settings - Role/Button - Select Group', [('groupName') : 'Test Role']))

WebUI.click(findTestObject('Object - Settings - Role/Button - Delete All Approver Level 2'))

WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Confirmation Dialog - Remove User'))

WebUI.click(findTestObject('Object - Settings - Role/Button - Remove in Dialog'))

WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Settings - Role/Toast - Success'), 'Success, level 2 approver has been removed.')

WebUI.click(findTestObject('Object - Settings - Role/Button - Changelog Addon Role'))

'Always include the \'action\' and \'userName\' variable to target the XPath.'
WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Verify Data Table - Changelog', [('action') : 'Remove'
            , ('userName') : '-']))

WebUI.click(findTestObject('Object - Settings - Role/Button - Close Dialog'))


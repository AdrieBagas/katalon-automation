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

CustomKeywords.'company.SpecificElipsis.chooseSpesificUserName'(GlobalVariable.defaultUserName)

WebUI.click(findTestObject('Object - Settings - Role/Button - Detail From Elipsis'))

WebUI.click(findTestObject('Object - Settings - Role/Button - Tab Group Role in Detail User'))

WebUI.click(findTestObject('Object - Settings - Role/Button - Switch Activate Role in Detail User', [('role') : 'Manage purchase information']))

WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Dialog - Activated Role from Detail User'))

WebUI.click(findTestObject('Object - Settings - Role/Button - Confirmation Activate in Dialog'))

WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Settings - Role/Toast - Success'), 'Success, role has been activated.')

WebUI.click(findTestObject('Object - Settings - Role/Button - Changelog Group Role in Detail User'))

WebUI.verifyElementVisible(findTestObject('Object - Settings - Role/Verify Data Table - Changelog in Detail User', [('action') : 'Assign']))

WebUI.click(findTestObject('Object - Settings - Role/Button - Close Dialog'))

WebUI.back()


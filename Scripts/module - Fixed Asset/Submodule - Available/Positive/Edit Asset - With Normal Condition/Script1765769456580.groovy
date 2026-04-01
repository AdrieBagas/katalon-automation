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

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/available')

WebUI.click(findTestObject('Object - Available/Button - Action Asset'))

WebUI.click(findTestObject('Object - Available/Action - Edit'))

WebUI.verifyElementVisible(findTestObject('Object - Available/Section - Dialog Form'))

WebUI.click(findTestObject('Object - Available/Field - Brand'))

WebUI.click(findTestObject('Object - Available/List - Another Brand'))

WebUI.click(findTestObject('Object - Available/Field - Model'))

WebUI.click(findTestObject('Object - Available/List - Another Model'))

WebUI.click(findTestObject('Object - Available/Button - Save'))

WebUI.verifyElementText(findTestObject('Object - Available/Toast - Success'), 'Success, asset has been edited')

WebUI.click(findTestObject('Object - Available/Button - Changelog'))

WebUI.delay(1)

WebUI.takeAreaScreenshot(null)


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

WebUI.click(findTestObject('Object - Available/Button - Register'))

CustomKeywords.'company.UrlValidator.verifyUrl'('/assets/available/register-asset')

WebUI.click(findTestObject('Object - Available/Button - Select Group'))

WebUI.click(findTestObject('Object - Available/List - Group'))

WebUI.click(findTestObject('Object - Available/Button - Select'))

WebUI.click(findTestObject('Object - Available/Button - Select Category'))

WebUI.click(findTestObject('Object - Available/List - Category'))

WebUI.click(findTestObject('Object - Available/Button - Select'))

WebUI.click(findTestObject('Object - Available/Input - Asset Name'))

WebUI.click(findTestObject('Object - Available/List - Asset RFID'))

WebUI.click(findTestObject('Object - Available/Input - Brand'))

WebUI.click(findTestObject('Object - Available/List - Brand'))

WebUI.click(findTestObject('Object - Available/Input - Model and Type'))

WebUI.click(findTestObject('Object - Available/List - Model and Type'))

WebUI.setText(findTestObject('Object - Available/Input - Quantity'), '1')

CustomKeywords.'company.GeneralHelper.uploadFileInProject'(findTestObject('Object - Available/Input - Asset Photo'), 'Image Files/Screenshot 2025-12-11 112028.png')

WebUI.click(findTestObject('Object - Available/Button - Pair Tag'))

WebUI.click(findTestObject('Object - Available/Title - Asset Pair'))

WebUI.click(findTestObject('Object - Available/Button - Cancel Pair TAG'))

WebUI.verifyElementVisible(findTestObject('Object - Available/DIalog - Confirm'))

WebUI.click(findTestObject('Object - Available/Button - Continue'))

WebUI.verifyElementVisible(findTestObject('Object - Available/Button - Pair Tag'))


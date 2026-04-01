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

WebUI.navigateToUrl('https://mailnesia.com/')

WebUI.setText(findTestObject('Object - Custom Field/input - mailnesia'), GlobalVariable.mailnesiaemail)

WebUI.click(findTestObject('Object - Custom Field/button - submit'))

WebUI.click(findTestObject('Object - Custom Field/email - OTP'))

WebUI.click(findTestObject('Object - Custom Field/Button - Exit'))

WebUI.setText(findTestObject('login session object/Input - Password'), 'Gaadaobatnya1@')

WebUI.setText(findTestObject('login session object/Input - Password'), '')

WebUI.click(findTestObject('Object Repository/New Folder/button - save new password'))

WebUI.verifyElementVisible(findTestObject('login session object/Validator Message - Password must different with old password'))


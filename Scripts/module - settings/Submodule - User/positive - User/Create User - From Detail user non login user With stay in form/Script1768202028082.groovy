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

CustomKeywords.'company.UrlValidator.verifyUrl'('/settings/user')

WebUI.click(findTestObject('Object - User/Button - titik tiga'))

WebUI.click(findTestObject('Object - User/Action - Detail'))

WebUI.click(findTestObject('Object - User/Tab - Non Login User'))

WebUI.click(findTestObject('Object - User/Button - User'))

CustomKeywords.'company.GeneralHelper.uploadFileInProject'(findTestObject('Object - User/Input - Profile Picture'), 'Image Files/Screenshot 2025-12-11 112028.png')

WebUI.click(findTestObject('Object - User/Button - Apply'))

WebUI.setText(findTestObject('Object - User/Input - First Name'), 'Default')

WebUI.setText(findTestObject('Object - User/Input - Last Name'), 'Stay')

WebUI.click(findTestObject('Object - User/Select - Position'))

WebUI.click(findTestObject(null))

WebUI.click(findTestObject('Object - User/Select - Division'))

WebUI.click(findTestObject(null))

WebUI.setText(findTestObject('Object - User/Input - Employee ID'), GlobalVariable.generatedCodeName)

WebUI.setText(findTestObject('Object - User/Input - Phone Number'), '88182887211')

WebUI.check(findTestObject('Object - User/Checkbox - Stay'))

WebUI.click(findTestObject('Object - User/Button - Submit'))

WebUI.click(findTestObject('Object - User/Button - Create'))

WebUI.waitForElementVisible(findTestObject('Object - User/Toast - Success'), 1)

WebUI.verifyElementText(findTestObject('Object - User/Toast - Success'), 'Success, user has been created.')

WebUI.verifyElementVisible(findTestObject('Object - User/DIalog - Create non login user'))

WebUI.click(findTestObject('Object - User/Button - Close'))

WebUI.click(findTestObject('Object - User/Button - Change Log non login user'))

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Create', 'Name', '-', 'Default Stay', 0)


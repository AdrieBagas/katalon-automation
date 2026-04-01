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

WebUI.click(findTestObject('Object - Import/Menu Tab - User'))

WebUI.click(findTestObject('Object - Import/Single Action Button - First Row'))

WebUI.click(findTestObject('Object - Import/Action - Edit'))

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'First Name']), 'Darren')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Last Name']), 'Donovan')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Position']), 'Position 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Division']), 'Division 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Phone']), '+62 823458153')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Employee ID']), 'DD-0010')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Access']), 'Fixed Asset, Global Settings')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Email']), 'dardon@email.com')

WebUI.click(findTestObject('Object - Import/Button - Save'))

WebUI.verifyElementText(findTestObject('Object - Import/Toast - Success'), 'Success, data has been saved.')


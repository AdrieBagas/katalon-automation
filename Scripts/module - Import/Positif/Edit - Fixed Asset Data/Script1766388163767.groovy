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

WebUI.click(findTestObject('Object - Import/Menu Tab - Fixed Asset'))

WebUI.click(findTestObject('Object - Import/Single Action Button - First Row'))

WebUI.click(findTestObject('Object - Import/Action - Edit'))

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Group']), 'Group ABCD')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Group Code']), 'ABCD')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Category']), 'Category ABCD')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Category Code']), 'ABCD')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Currency']), 'IDR')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Purchase Cost']), '500000')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Tangible Asset Group']), 
    'Tangible Asset 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Useful Life (Year)']), 
    '100')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Purchase Date']), '2024-03-27')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Asset Name']), 'Asset Name 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Asset Name Code']), 
    'AS01')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Qty']), '5')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Alias Name']), 'Alias Name 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Brand']), 'Brand 1')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Model/Type']), 'Brand 1, Brand 2')

WebUI.setText(findTestObject('Object - Import/Textbox - Dynamic Editable Textbox', [('col_name') : 'Measurement']), 'Piecez')

WebUI.click(findTestObject('Object - Import/Button - Save'))

WebUI.verifyElementText(findTestObject('Object - Import/Toast - Success'), 'Success, data has been saved.')


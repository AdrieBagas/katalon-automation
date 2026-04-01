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

CustomKeywords.'company.UrlValidator.verifyUrl'('/addon/maintenance-routine/task')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Action'))

WebUI.click(findTestObject('Object - Maintenance Routine/Action - Detail'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Scan RFID'))

WebUI.delay(10)

WebUI.verifyElementVisible(findTestObject('Object - Maintenance Routine/Badge - Verified'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Maintenance Data'), 'Normal')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Indicator type select'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Value Standard'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Indicator Min range'), '2')

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Indicator Max range'), '4')

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Third Party'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Third Party'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Default Service Center'))

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Additonal Cost'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Total Price'), '1000000')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Currency'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Reference Price'), '60')

CustomKeywords.'company.GeneralHelper.uploadFileInProject'(findTestObject('Object - Maintenance Routine/Input - File Additional Cost'), 
    'Image Files/email-test.xlsx')

CustomKeywords.'company.GeneralHelper.uploadFileInProject'(findTestObject('Object - Maintenance Routine/Input - Image Maintenance'), 
    'Image Files/Screenshot 2025-12-11 112028.png')

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Note'), 'default note')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Submit'))

WebUI.verifyElementText(findTestObject('Object - Maintenance Routine/Toast - Success'), 'Success, maintenance routine form has been submitted.')

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Waiting For Review'], 0)


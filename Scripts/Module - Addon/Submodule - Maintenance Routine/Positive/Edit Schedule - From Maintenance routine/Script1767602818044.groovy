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

CustomKeywords.'company.UrlValidator.verifyUrl'('/addon/maintenance-routine/schedule')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Action'))

WebUI.click(findTestObject('Object - Maintenance Routine/Action - Edit Schedule'))

WebUI.clearText(findTestObject('Object - Maintenance Routine/Input - Task Name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Task Name'), 'Edited Maintenance')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Frequecy'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Weekly'))

WebUI.clearText(findTestObject('Object - Maintenance Routine/Input - Duration'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Duration'), '6')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Delete'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Confirm Delete'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Indicator'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Task Name'), 'Sub Indicator')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Single Value'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Value Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Text'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Measurement'), 'Default')

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Mandatory'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Save'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Assign'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - User Total Control'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Select'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Save'))

WebUI.verifyElementText(findTestObject('Object - Maintenance Routine/Toast - Success'), 'Success, schedule has been edited.')

CustomKeywords.'company.SimpleLogValidator.verifyLog'('edit', 'Task Name', 'Default Maintenance', 'Edited Maintenance', 
    5)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Frequency', 'Daily', 'Weekly', 4)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Duration', '1', '6', 3)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Staff', '-', 'User Total Control', 0)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Indicator', 'Default Indicator', '-', 2)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Indicator', '-', 'Sub Indicator', 1)

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Active Asset', 'Active', 'Inactive', 0)


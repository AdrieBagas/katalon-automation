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

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Schedule'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Task Name'), 'Default Maintenance')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Date'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Next Minute'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Frequecy'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Once'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Duration'), '1')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Indicator'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Task Name'), 'Selection Indicator')

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Selection'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Measurement'), 'Default')

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Selection value 1'), '')

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Selection value 2'), '')

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Have standard value'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Standard Type'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Standard Value'))

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Mandatory'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Save'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Add Asset Name'))

WebUI.check(findTestObject('Object - Maintenance Routine/Checkbox - Asset to maintenance'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Select'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Assign'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - User Staff'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Select'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Submit'))

WebUI.verifyElementVisible(findTestObject('Object - Maintenance Routine/Validator Message - Selection value empty'))


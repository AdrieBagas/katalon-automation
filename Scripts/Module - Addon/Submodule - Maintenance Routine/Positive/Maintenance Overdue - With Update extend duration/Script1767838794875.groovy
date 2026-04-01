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

WebUI.click(findTestObject('Object - Maintenance Routine/Action - Update'))

WebUI.click(findTestObject('Object - Maintenance Routine/Input - Select Action'))

WebUI.click(findTestObject('Object - Maintenance Routine/List - Extend Duration'))

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Duration'), '1')

WebUI.setText(findTestObject('Object - Maintenance Routine/Input - Note'), 'Tambah Durasi')

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Submit'))

WebUI.click(findTestObject('Object - Maintenance Routine/Button - Confirm Submit'))

WebUI.verifyElementText(findTestObject('Object - Maintenance Routine/Toast - Success'), 'Success, maintenance update has been submitted.')

CustomKeywords.'company.AssetListValidator.verifySpecificRowData'([('status') : 'Under Maintenance'], 0)


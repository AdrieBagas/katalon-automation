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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging-console.tagsamurai.com/')

WebUI.setText(findTestObject('null'), 'sidqihqc@mailnesia.com')

WebUI.setEncryptedText(findTestObject('null'), '8+VvZnBZfpfG5HxfHfyGjg==')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

not_run: WebUI.comment('POSITIVE')

WebUI.click(findTestObject('null'))

'Pair RFID & QR'
WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(10)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.verifyElementText(findTestObject('null'), 
    'Success, TAGs have been paired.')

WebUI.click(findTestObject('null'))

'Unpair RFID & QR (unpair by RFID)'
WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.verifyElementText(findTestObject('null'), 
    'Success, TAGs have been unpaired.')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(10)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.verifyElementText(findTestObject('null'), 
    'Success, TAGs have been paired.')

WebUI.click(findTestObject('null'))

'Unpair RFID & QR (unpair by QR)'
WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.verifyElementText(findTestObject('null'), 
    'Success, TAGs have been unpaired.')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(10)

WebUI.click(findTestObject('null'))

'Remove  RFID & QR pair (Remove by QR)'
WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(10)

WebUI.click(findTestObject('null'))

'Remove  RFID & QR pair (Remove by RFID)'
WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('null'))

not_run: WebUI.comment('NEGATIVE')

WebUI.click(findTestObject('null'))

WebUI.delay(5)

'Pair RFID & QR (yang sudah pair ke asset lain) '
WebUI.verifyElementText(findTestObject('null'), 
    'Error, this TAG is already paired to an asset.')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(5)

'Pair RFID (yang sudah pair ke asset lain) & QR'
WebUI.verifyElementText(findTestObject('null'), 
    'Error, this TAG is already paired to an asset.')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))


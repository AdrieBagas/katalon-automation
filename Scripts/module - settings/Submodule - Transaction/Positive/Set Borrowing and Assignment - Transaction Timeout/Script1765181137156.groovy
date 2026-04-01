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

CustomKeywords.'company.UrlValidator.verifyUrl'('/settings/transaction/transfer', true)

value = WebUI.getAttribute(findTestObject('object - transaction/Input - Transaction Timeout'), 'aria-valuenow')

WebUI.sendKeys(findTestObject('object - transaction/Input - Transaction Timeout'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE))

WebUI.setText(findTestObject('object - transaction/Input - Transaction Timeout'), editedTime)

WebUI.click(findTestObject('object - transaction/Button - Save'))

WebUI.waitForElementVisible(findTestObject('object - transaction/Toast - Success'), 1)

WebUI.verifyElementText(findTestObject('Object - Assets/Toast - Success'), 'Success, changes has been saved.')

WebUI.click(findTestObject('object - transaction/Button - Change log'))

CustomKeywords.'company.SimpleLogValidator.verifyLog'('Edit', 'Transaction Timeout', value + 'Day(s)', editedTime + 'Day(s)', 
    0)


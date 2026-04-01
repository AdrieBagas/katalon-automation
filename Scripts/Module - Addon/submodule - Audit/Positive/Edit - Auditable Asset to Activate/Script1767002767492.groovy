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

WebUI.click(findTestObject('Object - Audit/Tab - Auditable Asset'))

WebUI.click(findTestObject('Object - Audit/Button - Search'))

WebUI.setText(findTestObject('Object - Audit/Input - Search'), GlobalVariable.defaultAssetName)

WebUI.sendKeys(findTestObject('Object - Audit/Input - Search'), Keys.chord(Keys.ENTER))

CustomKeywords.'company.SpecificElipsis.chooseSpesificAsset'(GlobalVariable.defaultAssetName)

WebUI.click(findTestObject('Object - Audit/List - Elipsis Detail'))

WebUI.click(findTestObject('Object - Audit/Button - Switch All Task(s) in Detail Asset'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Toast - Success'))

WebUI.verifyElementText(findTestObject('Object - Audit/Toast - Success'), 'Success, asset(s) has been activated.')

WebUI.waitForElementNotVisible(findTestObject('Object - Audit/Toast - Success'), 5)

WebUI.click(findTestObject('Object - Audit/Button - Close Dialog'))


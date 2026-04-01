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

CustomKeywords.'company.CustomKeyword.loginToApp'(GlobalVariable.EmailBasic, GlobalVariable.Password)

WebUI.click(findTestObject('Object - Audit/Sidebar Menu - Addon'))

WebUI.click(findTestObject('Object - Audit/Sidebar Sub Menu - Audit'))

WebUI.click(findTestObject('Object - Audit/Tab - Task'))

CustomKeywords.'company.SpecificElipsis.chooseSpesificTask'(GlobalVariable.defaultTaskName)

WebUI.verifyElementVisible(findTestObject('Object - Audit/List - Elipsis Detail'))

WebUI.verifyElementNotVisible(findTestObject('Object - Audit/List - Elipsis Delete'))

WebUI.click(findTestObject('Object - Audit/Tab - Schedule'))

CustomKeywords.'company.SpecificElipsis.chooseSpesificTask'(GlobalVariable.defaultTaskName)

WebUI.verifyElementVisible(findTestObject('Object - Audit/List - Elipsis Detail'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Button - Single Action Edit Schedule'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Button - Single Action Delete'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Button - Single Action Inactivate'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Sidebar Menu - Report Log'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object - Audit/Sidebar Menu - Report Log'))

WebUI.verifyElementVisible(findTestObject('Object - Audit/Sidebar Sub Menu - Report'))

WebUI.click(findTestObject('Object - Audit/Sidebar Sub Menu - Report'))


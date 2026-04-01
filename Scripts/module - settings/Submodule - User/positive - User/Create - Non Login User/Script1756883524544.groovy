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

WebUI.click(findTestObject('Object Repository/Object - User/Button - titik tiga'))

WebUI.click(findTestObject('Object Repository/Object - User/Menu - Detail'))

WebUI.click(findTestObject('Object Repository/Object - User/Tab - Non Login User'))

WebUI.click(findTestObject('Object Repository/Object - User/Button - User'))

WebUI.click(findTestObject('Object Repository/Object - User/Input - First Name'))

WebUI.click(findTestObject('Object Repository/Object - User/Input - Last Name'))

WebUI.click(findTestObject('Object Repository/Object - User/Select - Position'))

WebUI.click(findTestObject('Object Repository/Object - User/Select - Division'))

WebUI.click(findTestObject('Object Repository/Object - User/Input - Employee ID'))

WebUI.click(findTestObject('Object Repository/Object - User/Input - Phone Number'))

WebUI.click(findTestObject('Object Repository/Object - User/Checkbox - Temporary user'))

WebUI.click(findTestObject('Object Repository/Object - User/Input - Date'))

WebUI.click(findTestObject('Object Repository/Object - User/Button - Clear Field'))

WebUI.click(findTestObject('Object Repository/Object - User/Button - Image Profile'))

WebUI.click(findTestObject('Object Repository/Object - User/Button - Submit'))

WebUI.click(findTestObject('Object Repository/Object - User/Validator Message - First name empty'))

WebUI.click(findTestObject('Object Repository/Object - User/Validator Message - Last Name empty'))

WebUI.click(findTestObject('Object Repository/Object - User/Validator Message - Pick a division'))

WebUI.click(findTestObject('Object Repository/Object - User/Validator Message - Phone number empty'))

WebUI.click(findTestObject('Object Repository/Object - User/Button - Close'))


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

CustomKeywords.'company.CustomKeyword.loginToApp'(GlobalVariable.EmailApprover, GlobalVariable.Password)

CustomKeywords.'company.UrlValidator.verifyUrl'('/approval/assignment/active')

WebUI.click(findTestObject('Object - Borrow/Button - Action'))

WebUI.click(findTestObject('Object - Borrow/Action - Approval'))

WebUI.check(findTestObject('Object - Borrow/Switch - Approval'))

WebUI.setText(findTestObject('Object - Borrow/Input - Duration'), '1')

WebUI.setText(findTestObject('Object - Borrow/Input - Note'), 'Disetujui dengan waktu yang ditentukan')

WebUI.click(findTestObject('Object - Borrow/Button - Submit'))

WebUI.click(findTestObject('Object - Borrow/Button - Update Data'))


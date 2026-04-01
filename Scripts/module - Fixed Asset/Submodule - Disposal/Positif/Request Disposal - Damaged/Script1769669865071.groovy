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

WebUI.click(findTestObject('Object - Disposal/Badge - Damaged'))

CustomKeywords.'company.SpecificElipsis.chooseSpesificAsset'(assetName)

WebUI.click(findTestObject('Object - Disposal/Elipsis List - Request Disposal'))

WebUI.click(findTestObject('Object - Disposal/Dropdown - Disposal Method'))

WebUI.click(findTestObject('Object - Disposal/Dropdown List - Donate'))

WebUI.setText(findTestObject('Object - Disposal/Input - Organization or Company'), 'Organization 1')

WebUI.setText(findTestObject('Object - Disposal/Input - Additional Note'), 'Noteeeee')

WebUI.click(findTestObject('Object - Disposal/Button - Submit'))

WebUI.verifyElementText(findTestObject('Object - Disposal/Toast - Success'), 'Success, disposal request has been submitted.')


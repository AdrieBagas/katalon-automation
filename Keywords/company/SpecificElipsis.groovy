package company

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

class SpecificElipsis {

	@Keyword
	def chooseSpesificAsset(String assetName) {

		String dynamicXPath = "//tr[.//span[contains(., '${assetName}')]]//button"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}

	@Keyword
	def chooseSpesificTask(String taskName) {

		String dynamicXPath = "//tr[.//span[text()='${taskName}']]//button"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}

	@Keyword
	def chooseSpesificUserName(String userName) {

		String dynamicXPath = "//tr[.//span[contains(., '${userName}')]]//button"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}

	@Keyword
	def clickGroupSidebarElipsis(String groupName) {

		String dynamicXPath = "//span[text()='${groupName}']/following-sibling::button[@data-ts-section='tree-node-menu-toggler']"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}

	@Keyword
	def clickCategorySidebarElipsis(String categoryName) {

		String dynamicXPath = "//span[text()='${categoryName}']/following-sibling::button[@data-ts-section='tree-node-menu-toggler']"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}

	@Keyword
	def chooseSpecificAsset(String assetName) {

		String dynamicXPath = "//tr[.//span[normalize-space(.) = '${assetName}']]//button"

		TestObject btnEllipsis = new TestObject("dynamicEllipsis")
		btnEllipsis.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)

		WebUI.waitForElementVisible(btnEllipsis, 3)
		WebUI.click(btnEllipsis)
	}
}

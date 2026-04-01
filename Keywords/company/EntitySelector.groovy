package company

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class EntitySelector {

	// Untuk memilih user tertentu ketika ada checkbox dalam sebuah tabel
	@Keyword
	def selectUserInTable(String userName) {
		String xpath = "//tr[@data-pc-section='bodyrow'][.//span[text()='${userName}']]"

		TestObject userObj = new TestObject("dynamicUser").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(userObj, 5)
		WebUI.click(userObj)
		KeywordUtil.logInfo("User terpilih: " + userName)
	}

	// Untuk memilih user tertentu ketika ada dropdown dalam sebuah tabel (disini untuk memilih user berdasarkan role)
	@Keyword
	def selectUserInDropdown(String userName) {
		String xpath = "//li[@role='option']//span[contains(.,'${userName}')]/preceding-sibling::div//input"

		TestObject userObj = new TestObject("dynamicUser").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(userObj, 5)
		WebUI.click(userObj)
		KeywordUtil.logInfo("User terpilih: " + userName)
	}

	// Untuk memilih grup yang ada di sidebar sebelah kanan
	@Keyword
	def selectGroupInSidebar(String groupName) {
		String xpath = "//li[@role = 'treeitem' and @data-pc-section = 'subgroup'][.//span[text()='${groupName}']]"

		TestObject groupObj = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(groupObj, 5)
		WebUI.click(groupObj)
		KeywordUtil.logInfo("Group terpilih: " + groupName)
	}

	// Untuk memilih grup yang ada di dialog (checkbox)
	@Keyword
	def selectGroupInDialog(String groupName) {
		String xpath = "//li[@role='treeitem']//span[contains(.,'${groupName}')]/preceding-sibling::div[@data-pc-extend='checkbox']"

		TestObject groupObj = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(groupObj, 5)
		WebUI.check(groupObj)
		KeywordUtil.logInfo("Group terpilih: " + groupName)
	}

	// Untuk memilih grup yang ada di dialog (text)
	@Keyword
	def selectGroupInDialogWithText(String groupName) {
		String xpath = "//li[@role='treeitem']//span[contains(.,'${groupName}')]/ancestor::div[1]"

		TestObject groupObj = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(groupObj, 5)
		WebUI.check(groupObj)
		KeywordUtil.logInfo("Group terpilih: " + groupName)
	}

	// Untuk memilih badge yang berisi user tertentu di beberapa role
	@Keyword
	def selectSpecificUserBadge(String role, String userName) {
		String xpath = "//div[@data-ts-name='manage-authorized-user'][.//span[text()='$role ']]/descendant::span[text()='userName']/following-sibling::button[@data-ts-section='badge-remove']"

		TestObject userBadgeObj = new TestObject("dynamicBadge").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(userBadgeObj, 5)
		WebUI.click(userBadgeObj)
	}

	// Untuk memiliki chevrolet button (>) yang letaknya di sebelah kiri dari span nama object
	@Keyword
	def selectChevronButton(String objectName) {
		String xpath = "//span[span[(text()='${objectName}')]]/preceding-sibling::button[@data-pc-section='toggler']"

		TestObject chevButton = new TestObject("dynamicBadge").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(chevButton, 5)
		WebUI.click(chevButton)
	}

	// untuk klik radio button yang terletak di sebelah nama object (Misalnya disposal policy di Setting > Group)
	@Keyword
	def selectRadioButton(String objectName) {
		String xpath = "//td[.//span[text()='${objectName}']]/preceding-sibling::td/div/input[@role='switch']"

		TestObject radioButton = new TestObject("dynamicBadge").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(radioButton, 5)
		WebUI.click(radioButton)
	}

	// Klik tooltip changelog diatas data table berdasarkan dari aria label dari button Create Data yang ada disebelah kanannya
	@Keyword
	def selectChangelogTooltip(String createButtonLabel) {
		String xpath = "//button[@aria-label='${createButtonLabel}']/preceding::div[1]//button[last()]"

		TestObject changelogButton = new TestObject("dynamicBadge").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(changelogButton, 5)
		WebUI.click(changelogButton)
	}

	// Untuk memilih category yang ada di dialog (Ignore sidebar)
	@Keyword
	def selectCategoryInDialog(String categoryName) {
		String xpath = "//div[@role='dialog']//li[@role='treeitem']//span[contains(.,'${categoryName}')]"

		TestObject categoryObj = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(categoryObj, 5)
		WebUI.click(categoryObj)
		KeywordUtil.logInfo("Category terpilih: " + categoryName)
	}

	// Untuk memilih salah elemen dalam dropdown list menggunakan aria-label
	@Keyword
	def selectElementinDropdown(String elementLabel) {
		String xpath = "//ul[@aria-label='Option List']//li[contains(@aria-label, '${elementLabel}')]"

		TestObject optionListItem = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(optionListItem, 5)
		WebUI.click(optionListItem)
		KeywordUtil.logInfo("Elemen Option List terpilih: " + optionListItem)
	}

	// Mengambil elemen checkbox yang ada pada bagian paling kiri tabel, gunakan data pada td disebelah kanan checkbox terkait
	@Keyword
	def selectCheckboxinTable(String elementName) {
		String xpath = "//table/tbody//td[contains(., '${elementName}')]/preceding-sibling::td//input"

		TestObject optionListItem = new TestObject("dynamicGroup").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(optionListItem, 5)
		WebUI.click(optionListItem)
		KeywordUtil.logInfo("Elemen checkbox terpilih: " + optionListItem)
	}

	// Memilih tanggal tertentu seperti di audit
	@Keyword
	def selectSpecificDate(String date) {
		String xpath = "//td//span[text()='${date}' and not(@aria-disabled='true')]"

		TestObject dateObj = new TestObject("dynamicDate").addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementVisible(dateObj, 5)
		WebUI.click(dateObj)
		KeywordUtil.logInfo("Tanggal terpilih: " + dateObj)
	}
}


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class CrudSetupListener {
	
	// Flag untuk menandai apakah kita sedang berjalan di dalam konteks Test Suite
	static boolean isRunningFromSuite = false
	
	@BeforeTestSuite
	def setupCrudData(TestSuiteContext testSuiteContext) {
		// Set flag menjadi true karena Test Suite dimulai
		isRunningFromSuite = true
		
		generateCommonData("Suite")
		println "======================================================"
		println "RUNNING FROM TEST SUITE: Data di-generate sekali untuk semua TC."
		println "======================================================"
	}
	
	@BeforeTestCase // PENTING: Anda lupa menambahkan anotasi ini
	def setupNameData(TestCaseContext testCaseContext) {
		// Jika TIDAK berjalan dari suite (artinya running satuan/individual)
		if (!isRunningFromSuite) {
			generateCommonData("Individual Test Case")
			println "======================================================"
			println "RUNNING INDIVIDUAL: Data di-generate khusus untuk TC ini."
			println "======================================================"
		} else {
			// Jika dari suite, kita abaikan generate ulang agar data tetap konsisten
			println "SKIP GENERATE: Menggunakan data dari Test Suite Setup."
		}
	}
	
	def generateCommonData(String source) {
		
		String randomName = CustomKeywords.'company.RandomGenerator.generateRandomText'(10, 'ALPHANUMERIC')
		String randomNameWithoutChar = CustomKeywords.'company.RandomGenerator.generateRandomText'(10, 'ALPHANUMERIC')
		String randomCodeName = CustomKeywords.'company.RandomGenerator.generateRandomText'(4, 'ALPHANUMERIC')
		String randomEditedName = CustomKeywords.'company.RandomGenerator.generateRandomText'(10, 'ALPHANUMERIC')
		String randomOver30Name = CustomKeywords.'company.RandomGenerator.generateRandomText'(30, 'ALPHANUMERIC')
		String randomOver60Name = CustomKeywords.'company.RandomGenerator.generateRandomText'(60, 'ALPHANUMERIC')
		String randomOver120Name = CustomKeywords.'company.RandomGenerator.generateRandomText'(120, 'ALPHANUMERIC')
		
		// Simpan hasil generate ke Global Variable yang sudah dibuat di Langkah 1
		GlobalVariable.generatedName = "Data-" + randomName
		GlobalVariable.generatedNameWithoutChar = "TES" + randomNameWithoutChar
		GlobalVariable.generatedCodeName = randomCodeName.toUpperCase()
		GlobalVariable.generatedEditedName = "Data-" + randomEditedName
		GlobalVariable.generatedOver30Name = "Data-" + randomOver30Name
		GlobalVariable.generatedOver60Name = "Data-" + randomOver60Name
		GlobalVariable.generatedOver120Name = "Tes" + randomOver120Name
	}
}
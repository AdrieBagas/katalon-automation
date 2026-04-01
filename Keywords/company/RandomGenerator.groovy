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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang3.RandomStringUtils

import internal.GlobalVariable

public class RandomGenerator {

	/**
	 * Menghasilkan string acak berdasarkan tipe dan panjang yang ditentukan.
	 * @param length (Integer) - Jumlah karakter yang ingin dihasilkan.
	 * @param type (String) - Tipe string: 'ALPHANUMERIC', 'ALPHABETIC', 'NUMERIC'.
	 * @return (String) String acak yang telah dihasilkan.
	 */
	@Keyword
	def generateRandomText(int length, String type) {
		String generatedString = null

		// Menggunakan switch-case untuk menentukan tipe string yang akan dibuat
		switch (type.toUpperCase()) {
			case "ALPHANUMERIC":
			// Menghasilkan string acak yang terdiri dari huruf dan angka
				generatedString = RandomStringUtils.randomAlphanumeric(length)
				break

			case "ALPHABETIC":
			// Menghasilkan string acak yang hanya terdiri dari huruf
				generatedString = RandomStringUtils.randomAlphabetic(length)
				break

			case "NUMERIC":
			// Menghasilkan string acak yang hanya terdiri dari angka
				generatedString = RandomStringUtils.randomNumeric(length)
				break

			default:
			// Pesan error jika tipe yang dimasukkan tidak valid
				println "Tipe random tidak valid. Gunakan 'ALPHANUMERIC', 'ALPHABETIC', atau 'NUMERIC'."
				break
		}

		return generatedString
	}

	/**
	 * Menghasilkan email acak dengan format "testuser_{random_string}@maildomain.com"
	 * @param length (Integer) - Panjang string acak untuk bagian username email.
	 * @param domain (String) - (Opsional) Nama domain untuk email, defaultnya 'maildomain.com'.
	 * @return (String) Email acak yang unik.
	 */
	@Keyword
	def generateRandomEmail(int length, String domain = 'maildomain.com') {
		String randomUser = RandomStringUtils.randomAlphanumeric(length).toLowerCase()
		return "testuser_" + randomUser + "@" + domain
	}
}

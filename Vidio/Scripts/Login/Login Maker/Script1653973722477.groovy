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
import com.kms.katalon.keyword.excel.ExcelKeywords

def workBook = ExcelKeywords.getWorkbook( GlobalVariable.dirProject + "\\DataSet\\" + GlobalVariable.dataInsert)

def sheet = ExcelKeywords.getExcelSheet(workBook,'Login')

String username = ExcelKeywords.getCellValueByAddress(sheet, 'A' + GlobalVariable.row)

String password = ExcelKeywords.getCellValueByAddress(sheet, 'B' + GlobalVariable.row)

WebUI.comment('Username : ' + username + ' , Password : ' + password)

WebUI.click(findTestObject('Login/a_Masuk'))
WebUI.setText(findTestObject('Login/input_username'), username)
WebUI.setText(findTestObject('Login/input_password'), password)

WebUI.takeFullPageScreenshotAsCheckpoint((((GlobalVariable.dirProject + "\\Screenshots\\" + GlobalVariable.todayDate) + '/') + GlobalVariable.nowTime + '/') + 'halaman login_login.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

WebUI.click(findTestObject('Login/button_Masuk'))
WebUI.delay(2)
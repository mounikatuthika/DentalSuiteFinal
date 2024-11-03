package PageElements;

import Utilities.WaitHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class LogingPageElements {

    public static WebDriver driver;
    public WaitHelper wait;
    public LogingPageElements(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WaitHelper(driver);
    }
   @FindBy (id = "c_30a0vjp3gdjm2gbrj4k")
    WebElement fullpasscode;
    //@FindBy(id = "otp_0_30a0vjp3gdjm2gbrj4k")
    @FindBy(xpath = "//*[contains (@class,'key otp-input')][1]")
    WebElement firstpasscode;
    @FindBy(xpath = "//*[contains (@class,'key otp-input')][2]")
    WebElement secondpasscode;

    @FindBy(xpath = "//*[contains (@class,'key otp-input')][3]")
    WebElement thirdpasscode;

    @FindBy(xpath = "//*[contains (@class,'key otp-input')][4]")
    WebElement fourthpasscode;
    @FindBy(xpath = "//*[text()=' Login']")
    WebElement loginbutton;

//    public void enterpasscode(String pc){
//        wait.waitforElement(fullpasscode,30);
//        fullpasscode.sendKeys(pc);
//    }
    public void firnum(String num1){
        wait.waitforElement(firstpasscode,30);
        firstpasscode.sendKeys(num1);
    }
    public void secnum(String num2){
        wait.waitforElement(secondpasscode,30);
        secondpasscode.sendKeys(num2);
    }
    public void thirnum(String num3){
        wait.waitforElement(thirdpasscode,30);
        thirdpasscode.sendKeys(num3);
    }
    public void fournum(String num4){
        wait.waitforElement(fourthpasscode,30);
        fourthpasscode.sendKeys(num4);
    }
    public void login(){
        wait.waitforElement(loginbutton,30);
        loginbutton.click();
    }
    //excel reading
    public void Excelreading(String filepath, int rowIndex) throws IOException {
        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Passcode");
        String passcode = sheet.getRow(rowIndex).getCell(1).getStringCellValue(); // Adjusting to read from the specified row
        // Validate passcode length
        if (passcode.length() != 4) {
            throw new IllegalArgumentException("Passcode must be exactly 4 digits for row " + rowIndex);
        }

        // Send each digit to its corresponding web element
        sendDigitToElement(firstpasscode, passcode.charAt(0));
        sendDigitToElement(secondpasscode, passcode.charAt(1));
        sendDigitToElement(thirdpasscode, passcode.charAt(2));
        sendDigitToElement(fourthpasscode, passcode.charAt(3));

        // Close the workbook
        workbook.close();
        file.close();
    }

    private void sendDigitToElement(WebElement element, char digit) {
        wait.waitforElement(element, 30); // Make sure the element is ready for interaction
        element.sendKeys(String.valueOf(digit)); // Send the digit
    }
}






package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class Reusable {

    public static WebDriver driver;

    WaitHelper wait=new WaitHelper(driver);
    //method for datepicker
    public void calander(WebElement calicon, WebElement calarrow, List<WebElement> Yearlist, List<WebElement> monthlist,List<WebElement> datelist,String year,String month,String date) {
        wait.waitforElement(calicon,30);
       // wait.waitforElementclick(calicon);
       //Actions act =new Actions(driver);
       // wait.waitele(4000);
        //act.moveToElement(calicon).click().perform();
        calicon.click();
        wait.waitforElement(calarrow, 30);
        calarrow.click();
        wait.waitForElements(Yearlist, 30);
        for (int i = 0; i < Yearlist.size(); i++) {
            if (Yearlist.get(i).getText().equalsIgnoreCase(year)) {
                Yearlist.get(i).click();
                break;
            }
        }
        wait.waitele(8000);

        wait.waitForElements(monthlist, 30);
       //wait.waitForOverlayToDisappear(monthlist,30);
       // System.out.println(monthlist);
        for (int j = 0; j < monthlist.size(); j++) {
            //System.out.println(monthlist.get(j).getText());
            if (monthlist.get(j).getText().contains(month)) {
                //wait.waitele(5000);
                monthlist.get(j).click();
                break;
            }
        }
        wait.waitForElements(datelist, 40);
        for (int k = 0; k < datelist.size(); k++) {
            if (datelist.get(k).getText().equalsIgnoreCase(date)) {
                datelist.get(k).click();
                break;
            }
        }

    }
    //Method for dropdown selection
    public void dropdown(List<WebElement> list,String Visibletext) {
        wait.waitForElements(list, 50);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(Visibletext)) {
                list.get(i).click();
                break;
            }
        }
    }
    //File upload sendkeys method
    public void fileupload(WebElement element,String path){
        element.sendKeys(path); //if html has type=file we can use this method

    }
    public void fileupload2(WebElement element1,WebElement element2,String path) throws AWTException {
        wait.waitforElement(element1,30);
        element1.click();
        wait.waitele(4000);
        wait.waitforElement(element2,30);
        element2.click();
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();",element2);
        Robot rb=new Robot();
        rb.delay(3000);
        //copy path
        StringSelection ss=new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        //paste the path
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        //Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        wait.waitele(4000);


    }
}


//public void startDate(String year,String month,String date) {
//        wait.waitforElement(startCaland, 30);
//        startCaland.click();
//        wait.waitforElement(datearrow, 30);
//        datearrow.click();
//        wait.waitForElements(yearslist,30);
//        for(int i=0;i<yearslist.size();i++)
//        {
//            if(yearslist.get(i).getText().equalsIgnoreCase(year)){
//                yearslist.get(i).click();
//                break;
//            }
//        }
//        wait.waitForElements(monthlist,30);
//        for(int j=0;j<monthlist.size();j++){
//            if(monthlist.get(j).getText().equalsIgnoreCase(month)){
//                monthlist.get(j).click();
//                break;
//            }
//        }
//        wait.waitForElements(datelist,30);
//        for(int k=0;k<datelist.size();k++){
//            if(datelist.get(k).getText().equalsIgnoreCase(date)){
//                datelist.get(k).click();
//                break;
//            }
//        }
//
//  }


//    public void AssignedTask(String Visibletext) {
//        wait.waitForElements(listitems, 30);
//        for (int i = 0; i < listitems.size(); i++) {
//            if (listitems.get(i).getText().equalsIgnoreCase(Visibletext)) {
//                listitems.get(i).click();
//                break;
//            }
//        }


//  }
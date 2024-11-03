package PageElements;

import Utilities.Reusable;
import Utilities.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.security.cert.X509Certificate;
import java.time.Year;
import java.util.List;

public class TaskManagementElements {
    public static WebDriver driver;
    public WaitHelper wait;
    public Reusable reusable=new Reusable();

    public TaskManagementElements(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
        wait = new WaitHelper(driver);
    }

    @FindBy(xpath = "//*[text()='Task Management ']")
    WebElement Taskmgmt;

    @FindBy(xpath = "//*[text()='Task Management ']/../../../../..//li//span")
    List<WebElement> listitems;
    @FindBy(xpath = "//*[text()=' Add ']")
    WebElement add;
    @FindBy(xpath = "//*[@placeholder='Enter Task title']")
    WebElement title;
    @FindBy(xpath = "//*[text()=' Select ']")
    WebElement select;
    @FindBy(xpath = "//*[@placeholder='Enter to search by name']")
    WebElement search;
    @FindBy(xpath = "//mat-button-toggle-group[@role=\"group\"]//p[@class='heading']")
    List<WebElement> assigneelist;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement assigneesave;
    @FindBy(xpath = "(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[1]")
    WebElement startCaland;
    @FindBy(css = "[class='mat-calendar-arrow']")
    WebElement datearrow;
    @FindBy(css = "[class^='mat-calendar-body-cell-content']")
    List<WebElement> yearslist;
    @FindBy(xpath = "//tbody[@role='grid']//tr//td//div[1]")
    List<WebElement> monthlist;
    @FindBy(css = "[class^='mat-calendar-body-cell-content ']")
    List<WebElement> datelist;
    @FindBy(xpath = "(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[2]")
    WebElement duecal;
    @FindBy(css="[class='mat-calendar-arrow']")
    WebElement duearrow;
    @FindBy(css = "[class*='mat-calendar-body-cell-content mat-focus-indicator']")
    List<WebElement> dueyearslist;
    @FindBy(xpath ="//tbody[@role='grid']//tr//td//div[1]")
    List<WebElement> duemonthlist;
    @FindBy(css = "[class='mat-calendar-body-cell-content mat-focus-indicator']")
    List<WebElement> duedatelist;
    @FindBy(xpath = "(//*[contains(@class,'mat-select-arrow ng-tns')])[2]")
    WebElement prioritydpdown;
    @FindBy(css = "[class='mat-option-text']")
    List<WebElement> prioritylist;
    @FindBy(css = "[class^='mat-input-element mat-form-field-autofill-control cdk-textarea-autosize ng-tns']")
    WebElement descr;
    @FindBy(xpath = "//*[text()=' Save ']")
    WebElement Saveb;
    @FindBy(xpath = "//*[text()='Task added successfully']")
    WebElement successmessage;
    @FindBy(css = "[class='upload-icon']")
    WebElement uploadfile;
    @FindBy(xpath = "//div[@class='uploader-sec']")
    WebElement uplodfilepath;
    @FindBy(xpath = "//*[@type='button']//span[normalize-space()='Save']")
    WebElement filesave;
    @FindBy(xpath = "(//*[@class='logout-btn'])[2]")
    WebElement logout;
    @FindBy(css="[class='notification-img']")
    WebElement notificationicon;
    @FindBy(xpath = "//*[@class='ps-content']//*[@class='notification-list media ng-star-inserted']//p[contains (text(),'task')]")
    List<WebElement> notificationlist;
    @FindBy(xpath = "(//*[text()=' more_horiz '])[1]")
    WebElement morebutton;
    @FindBy(xpath = "//*[text()=' Reassign ']")
    WebElement reassign;
    @FindBy(xpath = "//*[@placeholder='Enter Comment']")
    WebElement comment;
    @FindBy(xpath ="(//*[@class='more-icon'])[1]")
WebElement more;
    @FindBy(xpath = "//*[text()=' Accept ']")
    WebElement accept;
    @FindBy(xpath = "//*[@class='mat-button-wrapper']//span[text()='Yes']")
    WebElement acceptyes;
    @FindBy(xpath = "//*[@placeholder='Your message goes here ...']")
    WebElement tasktext;
    @FindBy(xpath = "//*[text()=' Move To In Progress ']")
    WebElement inprogress;
    @FindBy(xpath="//*[text()=' more_horiz ']")
    WebElement inprogressmore;
    @FindBy(xpath = "//*[text()=' View And Comment ']")
    WebElement viewandcomment;
    @FindBy(xpath = "//*[text()=' Move To Finished ']")
    WebElement finished;
    @FindBy(xpath = "//*[contains(@class,'task-card , card cdk-drag ng-tns')]")
    WebElement doneverification;
    @FindBy(xpath = "//*[text()='My Tasks ']")
    WebElement mytask;

    public void Taskmg() throws InterruptedException {
        Thread.sleep(6000);
        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to the element
        js.executeScript("arguments[0].scrollIntoView();", Taskmgmt);

        wait.waitforElement(Taskmgmt, 30);
        Taskmgmt.click();
    }
    public void AssignedTask(String Visibletext) throws InterruptedException {
        Thread.sleep(6000);

        reusable.dropdown(listitems,Visibletext);
    }

    public void addbutt() {
        wait.waitforElement(add, 30);
        add.click();
    }

    public void Tasktitle(String text) {
        wait.waitforElement(title, 30);
        title.sendKeys(text);
    }

    public void Assignname(String text, String Vtext) throws InterruptedException {
        wait.waitforElement(select, 30);
        select.click();
        wait.waitforElement(search, 30);
        search.sendKeys(text);
        Thread.sleep(10000);
        wait.waitForElements(assigneelist, 30);
        for (int i = 0; i < assigneelist.size(); i++) {
            if (assigneelist.get(i).getText().equalsIgnoreCase(Vtext)) {
                assigneelist.get(i).click();
                break;
            }
        }
        wait.waitforElement(assigneesave, 30);
        assigneesave.click();
        wait.waitele(5000);

    }
   public  void startdate(String year,String month,String date) throws InterruptedException {
        Thread.sleep(6000);
        reusable.calander(startCaland,datearrow,yearslist,monthlist,datelist, year,month,date);
   }
   public void duedate(String Dyear,String Dmonth,String Ddate){
      // JavascriptExecutor js = (JavascriptExecutor) driver;
       // First, scroll to the bottom of the page
      // js.executeScript("window.scrollBy(0,500)");
      // js.executeScript("arguments[0].scrollIntoView();", duecal);
       wait.waitele(6000);
        reusable.calander(duecal,duearrow,dueyearslist,duemonthlist,duedatelist,Dyear,Dmonth,Ddate);
   }
   public void setpriority(String Visibletxt) throws InterruptedException {
        Thread.sleep(6000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       // First, scroll to the bottom of the page
       js.executeScript("window.scrollBy(0,500)");
       // Scroll to the element
        Thread.sleep(3000);
       js.executeScript("window.scrollBy(0,500)");
       js.executeScript("arguments[0].scrollIntoView();", prioritydpdown);
        wait.waitforElement(prioritydpdown,30);
        prioritydpdown.click();
        reusable.dropdown(prioritylist,Visibletxt);
   }
   public void descrtext(String Dtext){

        wait.waitforElement(descr,30);
        descr.sendKeys(Dtext);
   }
    public void fileupload(String path) throws AWTException {
        reusable.fileupload2(uploadfile,uplodfilepath,path);
        wait.waitele(5000);
        filesave.click();

    }
   public void assignesave(){
        wait.waitforElement(Saveb,30);
        Saveb.click();
   }
   public String Tasksuccess(){
        wait.waitforElement(successmessage,30);
       String message= successmessage.getText();

   return message;
   }
public void logoutApp(){
        wait.waitforElement(logout,30);
        logout.click();
        wait.waitele(6000);
        logout.click();
}
    public void Mytask(String Visibletext) throws InterruptedException {
        Thread.sleep(6000);

        reusable.dropdown(listitems,Visibletext);
    }
    public void notificationclick(){
        wait.waitele(6000);
        wait.waitforElement(notificationicon,30);
        notificationicon.click();
    }
    public void notificationlistclick(String title){

//        wait.waitForElements(notificationlist,30);
        wait.waitele(6000);
        for (int i = 0; i < notificationlist.size(); i++) {
            if (notificationlist.get(i).getText().contains(title)) {
                notificationlist.get(i).click();
                break;
            }
        }
    }
    public void Reassign(String vtext,String comments) throws InterruptedException {
        wait.waitforElement(morebutton,30);
        morebutton.click();
        wait.waitforElement(reassign,30);
        reassign.click();
        wait.waitforElement(select, 30);
        select.click();
        wait.waitele(6000);
        wait.waitForElements(assigneelist, 30);
        for (int i = 0; i < assigneelist.size(); i++) {
            if (assigneelist.get(i).getText().equalsIgnoreCase(vtext)) {
                assigneelist.get(i).click();
                break;
            }
        }
        wait.waitforElement(assigneesave, 30);
        assigneesave.click();
        wait.waitele(5000);
        wait.waitforElement(comment,30);
        comment.sendKeys(comments);
        wait.waitforElement(Saveb,30);
        Saveb.click();
        wait.waitele(3000);

    }
    public void acceptreq(){
        wait.waitforElement(more,30);
        more.click();
        wait.waitforElement(accept,30);
        accept.click();
        wait.waitforElement(acceptyes,30);
        acceptyes.click();
        wait.waitele(3000);

    }
    public void MovetoInprogress(String inprogresstext){
        wait.waitforElement(tasktext,30);
        tasktext.sendKeys(inprogresstext);
        wait.waitforElement(inprogress,30);
        inprogress.click();
        wait.waitele(3000);
    }
     public void MovetoFinished(String finishedtext){
        wait.waitforElement(inprogressmore,30);
        inprogressmore.click();
        wait.waitforElement(viewandcomment,30);
        viewandcomment.click();
        wait.waitforElement(tasktext,30);
        tasktext.sendKeys(finishedtext);
        wait.waitforElement(finished,30);
        finished.click();
        wait.waitele(3000);
     }
     public void Doneverification(String text){
        wait.waitforElement(doneverification,30);
        doneverification.getText().equalsIgnoreCase(text);
     }
    public void Mytask(){
        wait.waitele(6000);
        mytask.click();
    }
    public void RAssignname(String text, String Vtext,String comment1) throws InterruptedException {
        wait.waitforElement(morebutton,30);
        morebutton.click();
        wait.waitforElement(reassign,30);
        reassign.click();
        wait.waitforElement(select, 30);
        select.click();
        wait.waitele(6000);
        wait.waitforElement(search, 30);
        search.sendKeys(text);
        Thread.sleep(10000);
        wait.waitForElements(assigneelist, 30);
        for (int i = 0; i < assigneelist.size(); i++) {
            if (assigneelist.get(i).getText().equalsIgnoreCase(Vtext)) {
                assigneelist.get(i).click();
                break;
            }
        }
        wait.waitforElement(assigneesave, 30);
        assigneesave.click();
        wait.waitele(5000);
        comment.sendKeys(comment1);
        wait.waitforElement(Saveb,30);
        Saveb.click();
        wait.waitele(3000);

    }

}

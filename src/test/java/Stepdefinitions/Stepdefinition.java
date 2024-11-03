package Stepdefinitions;

import Base.BaseClass;
import PageElements.LogingPageElements;
import PageElements.TaskManagementElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Stepdefinition extends BaseClass {

@Before
    public void setup() throws IOException {
        logger= LogManager.getLogger(Stepdefinition.class);
        // Reading properties
        configprop=new Properties();
        FileInputStream configpropfile=new FileInputStream("C:\\Users\\MounikaTuthika-Kairo\\IdeaProjects\\DentalSuite (3)\\DentalSuiteFinal\\src\\main\\resources\\Config.properties");
        configprop.load(configpropfile);
        //String br="chrome";
        String br=configprop.getProperty("browser");
        if(br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(br.equals("edge")) {
            driver = new EdgeDriver();
        }
        else if(br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("invalid browser");
        }
        lp=new LogingPageElements(driver);
    }
    @Given("I launch the browser")
    public void i_launch_the_browser() {

     logger.info("#######Browser launch######");
     driver.manage().window().maximize();
    }
    @When("Open the url")
    public void open_the_url() throws IOException {
        logger.info("#######Opening url######");
        String url=configprop.getProperty("url");
        System.out.println("url====="+url);
        driver.get(url);
    }
    @When("Enter the valid credentials")
    public void enter_the_valid_credentials() {

        logger.info("#######Entering the passcode######");
        String P1=configprop.getProperty("Passcode1stpin");
        String P2=configprop.getProperty("Passcode2ndpin");
        String P3=configprop.getProperty("Passcode3rdpin");
        String P4=configprop.getProperty("Passcode4thpin");
        lp.firnum(P1);
        lp.secnum(P2);
        lp.thirnum(P3);
        lp.fournum(P4);
    }


    @When("click on login button")
    public void click_on_login_button() {
        logger.info("#######Click on login button######");
        lp.login();
    }
    @Then("I should see the page title {string}")
    public void i_should_see_the_page_title(String exptitle) throws InterruptedException {
       logger.info("Title validation");
       Thread.sleep(3000);
        String Actitle=driver.getTitle();
        Assert.assertEquals(exptitle,Actitle);
        System.out.println("Actual title$$$$$$$$"+Actitle);

    }

    ///Task assigned steps
    @When("Click on Task managhement")
    public void click_on_task_managhement() throws InterruptedException {
        Tm=new TaskManagementElements(driver);
        logger.info("click on Takmanagenment tab");
        Tm.Taskmg();
    }
    @When("go to assined tasks")
    public void go_to_assined_tasks() throws InterruptedException {
        logger.info("select assigned task");
    Tm.AssignedTask("Assigned Task");
    }
    @When("add a new task")
    public void add_a_new_task() {

        logger.info("click on add button to create new task");
    Tm.addbutt();
    }
    @When("I enter the task title {string}")
    public void i_enter_the_task_title(String tasktitle) {
        Tm.Tasktitle(tasktitle);
    }
    @When("I search for the user {string} and select the user {string}")
    public void i_search_for_the_user_and_select_the_user(String search, String select) throws InterruptedException {
        Tm.Assignname(search,select);
        Tm.assignesave();
    }

    @When("I set the start date to {string} {string} {string}")
    public void i_set_the_start_date_to(String syear, String smonth, String sdate) throws InterruptedException {
        Tm.startdate(syear, smonth, sdate);
    }
    @When("I set the due date to {string} {string}{string}")
    public void i_set_the_due_date_to(String dyear, String dmonth, String ddate) {
        Tm.duedate(dyear,dmonth,ddate);
    }
    @When("I set the priority to {string}")
    public void i_set_the_priority_to(String priority) throws InterruptedException {
       Tm.setpriority(priority);
    }
    @When("I enter the description {string}")
    public void i_enter_the_description(String description) {
       Tm.descrtext(description);
    }
    @When("I attach the file {string}")
    public void i_attach_the_file(String path) throws AWTException {
      Tm.fileupload(path);
    }

   @When("Enter the task details")
    public void enter_the_task_details() throws InterruptedException, AWTException {
        logger.info("Fill all the required details");
     Tm.Tasktitle("rootcanel sitting1");
       Tm.Assignname("lakshmi","LakshmiPM Boini");
        Tm.startdate("2024","OCT","30");
        Tm.duedate("2024","OCT","31");
       Tm.setpriority("High");
       Thread.sleep(6000);
        Tm.descrtext("Dental checkup");
        Tm.fileupload("C:\\Users\\MounikaTuthika-Kairo\\Documents\\fileupload.xlsx");

    }
    @When("click on save button")
    public void click_on_save_button() {
        logger.info("save and assign the task");
        Tm.assignesave();
    }
    @Then("verify task created successfully or not")
    public void verify_task_created_successfully_or_not() {
        logger.info("verifying task added successfully message");
        String text=Tm.Tasksuccess();
        Assert.assertEquals("Task Added Successfully",text);
    }
   /*@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}


package Stepdefinitions;

import Base.BaseClass;
import PageElements.LogingPageElements;
import PageElements.TaskManagementElements;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Stepdefintions2 extends BaseClass {
    @Before
    public void setup() throws IOException {
        logger= LogManager.getLogger(Stepdefintions2.class);
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

    @Given("I enter the valid passcode for the admin user")
    public void i_enter_the_valid_passcode_for_the_admin_user() throws IOException {
        logger.info("#######Enter passcode for khaja amin user######");
        lp.Excelreading("C:\\Users\\MounikaTuthika-Kairo\\IdeaProjects\\DentalSuite (3)\\DentalSuiteFinal\\src\\main\\resources\\Testdata\\Testdata.xlsx",1);

    }
    @Given("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        logger.info("#######Click on login button######");
        lp.login();
        Thread.sleep(10000);
    }

    @When("I click on Task Management")
    public void i_click_on_task_management() throws InterruptedException {
        logger.info("#######Click on Task management in dashboard menu######");
        Tm=new TaskManagementElements(driver);
        logger.info("click on Takmanagenment tab");
        Tm.Taskmg();
    }
    @When("I click on Assigned Tasks")
    public void i_click_on_assigned_tasks() throws InterruptedException {
        logger.info("#######Click on Assigned tasks######");
        logger.info("select assigned task");
        Tm.AssignedTask("Assigned Task");
    }
    @When("I click on the add button to add a new task")
    public void i_click_on_the_add_button_to_add_a_new_task() {
        logger.info("click on add button to create new task");
        Tm.addbutt();
    }
    @When("I enter the task details as follows:")
    public void i_enter_the_task_details_as_follows(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        logger.info("#####Entering all the task details######");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Tm.Tasktitle(data.get(0).get("TaskTitle"));
        Tm.Assignname(data.get(0).get("SearchUser"),data.get(0).get("SelectUser"));
        Tm.startdate(data.get(0).get("StartDateYeear"),data.get(0).get("StartDateMonth"),data.get(0).get("StartDatedate"));
        Tm.duedate(data.get(0).get("DueDateYear"),data.get(0).get("DueDateMonth"),data.get(0).get("DueDatedate"));
        Tm.setpriority(data.get(0).get("Priority"));
        Tm.descrtext(data.get(0).get("Description"));

    }
    @When("I click on the save button")
    public void i_click_on_the_save_button() {
        logger.info("save and assign the task");
        Tm.assignesave();
    }
    @Then("I verify the task is created successfully")
    public void i_verify_the_task_is_created_successfully() {
        logger.info("verifying task added successfully message");
        String text=Tm.Tasksuccess();
        Assert.assertEquals("Task Added Successfully",text);
    }
    @And("Admin user logout of the application")
    public void adminUserLogoutOfTheApplication() {
        logger.info("#######logout as khaja admin user######");
        Tm.logoutApp();
    }
    @Then("I enter the valid passcode for the Practice Manager")
    public void i_enter_the_valid_passcode_for_the_practice_manager() throws InterruptedException, IOException {
        logger.info("#######Login as practice manager khaja alpha pm######");
        lp.Excelreading("C:\\Users\\MounikaTuthika-Kairo\\IdeaProjects\\DentalSuite (3)\\DentalSuiteFinal\\src\\main\\resources\\Testdata\\Testdata.xlsx",2);
        lp.login();
        Thread.sleep(10000);
    }
    @And("Practice Manager click on notification list")
    public void practiceManagerClickOnNotificationList() {
        logger.info("#######when user clicks on notifications######");
         Tm.notificationclick();
    }
    @And("verify the admin assigned task is present in my task list with the title {string}")
    public void verifyTheAdminAssignedTaskIsPresentInMyTaskListWithTheTitle(String title) {
        logger.info("#######Click on created task notification######");
        Tm.notificationlistclick(title);
    }

    @And("click on My Tasks")
    public void clickOnMyTasks() throws InterruptedException {
        logger.info("#######Click on my task tab######");
        logger.info("click on my tasks");
        Tm.Mytask();
    }

    @And("I reassign the task to {string}and add comments to the task as {string} from pending list")
    public void iReassignTheTaskToAndAddCommentsToTheTaskAsFromPendingList(String assignename, String comments) throws InterruptedException {
        logger.info("#######Reassign the task to alphapmalpa another practice manager######");
        Tm.RAssignname("alpha",assignename,comments);


    }

    @And("Practice Manager logout of the application")
    public void practiceManagerLogoutOfTheApplication() {
        logger.info("#######logout as practice manager user######");
        Tm.logoutApp();
    }
    @And("admin user click on notification list")
    public void adminUserClickOnNotificationList() {
        logger.info("#######Click on notifications######");

        Tm.notificationclick();
    }

    @And("verify the Practice manager reassigned task is present in notification list with the title {string}")
    public void verifyThePracticeManagerReassignedTaskIsPresentInNotificationListWithTheTitle(String title) {
        logger.info("#######Click on reassigned task notification######");
        Tm.notificationlistclick(title);

    }
    @Then("I accept the request")
    public void i_accept_the_request() {
        logger.info("#######Accept the reassign request######");
        Tm.acceptreq();


    }

    @Then("I enter the valid passcode for the 2nd Practice Manager")
    public void i_enter_the_valid_passcode_for_the_2nd_practice_manager() throws IOException, InterruptedException {
        logger.info("#######Login as a 2nd practice manage alphapm alpha######");
        lp.Excelreading("C:\\Users\\MounikaTuthika-Kairo\\IdeaProjects\\DentalSuite (3)\\DentalSuiteFinal\\src\\main\\resources\\Testdata\\Testdata.xlsx",3);
        lp.login();
        Thread.sleep(10000);

    }
    @And("second Practice Manager click on notification list")
    public void secondPracticeManagerClickOnNotificationList() {
        logger.info("#######Click on notification list######");

        Tm.notificationclick();
    }

    @Then("I verify the practice manager reassigned task is present in my task list with the title {string}")
    public void iVerifyThePracticeManagerReassignedTaskIsPresentInMyTaskListWithTheTitle(String title) {
        logger.info("#######Click on assigned task notification######");
        Tm.notificationlistclick(title);
    }


    @Then("I add the comment {string} and move to In Progress")
    public void i_add_the_comment_and_move_to_in_progress(String inprogresscomm) {
        logger.info("#######Move the task to in progress######");
        Tm.MovetoInprogress(inprogresscomm);

    }
    @Then("I add the comment {string} and move to finished")
    public void i_add_the_comment_and_move_to_finished(String donecomm) {
        logger.info("#######Move the task to finished status######");

        Tm.MovetoFinished(donecomm);
    }
    @Then("I verify the admin assigned task is present in my task list with the title {string} in the finished list")
    public void i_verify_the_admin_assigned_task_is_present_in_my_task_list_with_the_title_in_the_finished_list(String Vtext) {
        logger.info("#######Verify whether task is finished or not######");
        Tm.Doneverification(Vtext);
    }



}

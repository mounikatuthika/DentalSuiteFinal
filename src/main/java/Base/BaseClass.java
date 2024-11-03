package Base;

import PageElements.LogingPageElements;
import PageElements.TaskManagementElements;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public LogingPageElements lp;
    public Logger logger;
    public TaskManagementElements Tm;
    public Properties configprop;
}

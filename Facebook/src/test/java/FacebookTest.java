import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class FacebookTest {




    public static void main(String[] args) throws InterruptedException, IOException {

//Creating reference of Webdriver Interface
    WebDriver driver;

//Declare Facebook Credentials
        String user="username";
        String pass="password";


//

//Creating an instance of chrome level class to disable browser level notifications
        ChromeOptions coptions = new ChromeOptions();
        coptions.addArguments("--disable-notifications");

// Telling Selenium to find Chrome Driver
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver");

// Initialize browser
        driver = new ChromeDriver(coptions);

// Launch Facebook
        driver.get("http://facebook.com/");

//Wait
        Thread.sleep(1000);

//Maximize Window
        driver.manage().window().maximize();

//Wait
        Thread.sleep(2000);

//Enter Username
        WebElement userTextField = By.id("email").findElement(driver);
        userTextField.sendKeys(user);

//Wait
        Thread.sleep(2000);

//Enter Password
        WebElement PassTextField = driver.findElement(By.id("pass"));
        PassTextField.sendKeys(pass);

//Wait
        Thread.sleep(2000);

//Click on Login button
        driver.findElement(By.id("loginbutton")).click();

//Wait
        Thread.sleep(3000);
        System.out.println("logged in successfully");







// open post box
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pipptul6 a5q79mjw']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pipptul6 a5q79mjw']")));
        driver.findElement(By.xpath("//div[@class='pipptul6 a5q79mjw']")).click();

// post message
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@contenteditable='true']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']")));
        driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys("Hello World");

// onclick post
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Post')]"))).click();


// Take Screenshot for Evidence
        File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Save the screenshot in the given path by the name FbStatus.png
        FileUtils.copyFile(srce, new File("./src/main/resources/screenshot/FbStatus.png"));




//Wait
        Thread.sleep(2000);

//Click on Account Settings
        WebElement AccSettings = driver.findElement(By.xpath("//body/div[@id='mount_0_0']/div/div/div/div[4]/div[1]/span[1]/div[1]"));
        AccSettings.click();


//Click on Log out button
        WebElement logout = driver.findElement(By.xpath("//html//body"));
        System.out.println("log out successfully");




//Wait
        Thread.sleep(2000);

// Close the browser
        driver.quit();

    }

}


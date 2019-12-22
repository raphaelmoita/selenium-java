package org.moita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.moita.Config.*;

public class App {

    public static void main(String[] args)
    {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments(LANG_ES);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.cssSelector("button[aria-label=\"Sign in\"]"));

        username.sendKeys(Config.USERNAME);
        password.sendKeys(Config.PASSWORD);
        button.click();

        WebElement profile = driver.findElement(By.cssSelector("div[data-control-name=\"identity_welcome_message\"]"));
        System.out.println("Hello " + profile.getText());
        driver.close();

    }
}

package com.project.locationweb;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class LocationwebApplicationTests {

    @Test
    public void automaticInputCreateLocation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/show-create");

        driver.findElement(By.name("name")).sendKeys("Matija");
        Thread.sleep(400);

        driver.findElement(By.name("country")).sendKeys("Serbia");
        Thread.sleep(400);

        driver.findElement(By.name("postNumber")).sendKeys("69");
        Thread.sleep(400);

        WebElement type= driver.findElement(By.id("urban"));
        type.click();
        Thread.sleep(400);

        driver.findElement(By.name("email")).sendKeys("springbootpeacock@gmail.com");
        Thread.sleep(400);

        WebElement submit= driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();

        WebElement viewAll= driver.findElement(By.linkText("View All"));
        viewAll.click();

        String expectedTitle = "Display Locations";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);


        driver.quit();
        automaticDisplayLocations();
    }
    @Test
    public void automaticDisplayLocations() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/display-locations");

        driver.findElement(By.name("name")).sendKeys("c");
        Thread.sleep(2000);

        WebElement submitSearchByCountry= driver.findElement(By.xpath("//input[@value='Search']"));
        submitSearchByCountry.click();
        Thread.sleep(400);
    }
}

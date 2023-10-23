package ru.neteology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll(){
WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEash(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("- - disable-dev-shm-usage");
        options.addArguments("- -sandbox");
        options.addArguments("- -headless");
        driver = new ChromeDriver(options);
        driver.get("http//localhost:9999");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTestSomething(){
        throw new UnsupportedOperationException();
    }
}

package ru.neteology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEash(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http//localhost:9999");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
        driver = null;
    }
    @Test
    public void shouldTestSomething(){
        driver.findElement(By.cssSelector("[data-test-id='name') input")).sendKeys("Иванов Иван");
        driver.findElement(By.cssSelector("[data-test-id='phone') input")).sendKeys("+79139130099");
        driver.findElement(By.cssSelector("[data-test-id='agreement')")).click();
        driver.findElement(By.cssSelector("[data-test-id='button.button')")).click();
        var actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals("ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее времяю", actualText);
    }
}

package com.sofka.demoblaze;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class DemoblazePurchaseTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void compraExitosaConDosProductos() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.demoblaze.com/");

        agregarProducto(wait, "Samsung galaxy s6");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("nava"))).click();

        agregarProducto(wait, "Nokia lumia 1520");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

        WebElement producto1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(),'Samsung galaxy s6')]")
        ));

        WebElement producto2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(),'Nokia lumia 1520')]")
        ));

        assertTrue(producto1.isDisplayed());
        assertTrue(producto2.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Place Order')]")
        )).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
                .sendKeys("Michelle Estefania");

        driver.findElement(By.id("country")).sendKeys("Ecuador");
        driver.findElement(By.id("city")).sendKeys("Quito");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("06");
        driver.findElement(By.id("year")).sendKeys("2026");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Purchase')]")
        )).click();

        WebElement mensajeCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")
        ));

        assertTrue(mensajeCompra.isDisplayed());

        System.out.println("PRUEBA EXITOSA. Chrome permanecerá abierto durante 30 segundos.");

        Thread.sleep(30000);
    }

    private void agregarProducto(WebDriverWait wait, String nombreProducto) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(nombreProducto))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Add to cart')]")
        )).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
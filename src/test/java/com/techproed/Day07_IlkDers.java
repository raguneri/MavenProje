package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("samsung headphones"+ Keys.ENTER);
        WebElement yazi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println(yazi.getText());
        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());
        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());
        //<span class="a-size-medium a-color-base a-text-normal" dir="auto">Başlık</span>
        List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        // 0. indexten başlıyor.
        for (WebElement w : listem){
            System.out.println(w.getText());
        }

    }
}

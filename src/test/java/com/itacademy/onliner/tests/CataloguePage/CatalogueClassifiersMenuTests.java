package com.itacademy.onliner.tests.CataloguePage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.itacademy.onliner.Constant.*;
import static com.itacademy.onliner.DriverCreator.setChromeDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogueClassifiersMenuTests {

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры", "Бытовая техника", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда"})
    void testClassifierMenuContainsClassifierHeaders(String classifierName) {
        WebDriver driver = setChromeDriver();
        String homePageUrl = ONLINER_HOME_PAGE;
        driver.get(homePageUrl);
        driver.navigate().to(homePageUrl);
        driver.findElement(By.xpath(CATALOGUE_LINK)).click();
        WebElement classifierMenu = driver.findElement(By.xpath(CLASSIFIER_MENU));
        assertThat(classifierMenu.getText().contains(classifierName));
        driver.quit();
    }
}


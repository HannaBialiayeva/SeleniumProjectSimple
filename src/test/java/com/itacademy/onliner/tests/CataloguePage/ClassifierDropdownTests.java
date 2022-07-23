package com.itacademy.onliner.tests.CataloguePage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.itacademy.onliner.Constant.CATALOGUE_LINK;
import static com.itacademy.onliner.DriverCreator.setChromeDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class ClassifierDropdownTests {

    public static String CLASSIFIER_COMPUTER_AND_NETS ="//*[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), 'Компьютеры')]";

    @ParameterizedTest
    @ValueSource(strings = {"Ноутбуки,компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование"})
    void testDropdownIsShownByClickOnClassifierLinkAndContainsCategoryHeaders(String categoryName) {
        WebDriver driver = setChromeDriver();
        String homePageUrl = "https://www.onliner.by/";
        driver.get(homePageUrl);
        driver.navigate().to(homePageUrl);
        driver.findElement(By.xpath(CATALOGUE_LINK)).click();
        WebElement classifier = driver.findElement(By.xpath(CLASSIFIER_COMPUTER_AND_NETS));
        classifier.click();
        assertThat(classifier.getText().contains(categoryName));
        driver.quit();
    }
}
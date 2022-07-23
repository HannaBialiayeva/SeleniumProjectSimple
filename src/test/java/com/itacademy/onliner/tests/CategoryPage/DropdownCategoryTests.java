package com.itacademy.onliner.tests.CategoryPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.itacademy.onliner.Constant.CATALOGUE_LINK;
import static com.itacademy.onliner.Constant.ONLINER_HOME_PAGE;
import static com.itacademy.onliner.DriverCreator.setChromeDriver;
import static com.itacademy.onliner.tests.CataloguePage.ClassifierDropdownTests.CLASSIFIER_COMPUTER_AND_NETS;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DropdownCategoryTests {

    public static String CATEGORY_GEARS = "//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')]";
    public static String LIST_OF_GEARS = "//div[@class='catalog-navigation-list__dropdown']";
    public static String PRODUCT_DATA_PATTERN = "//span[@class= 'catalog-navigation-list__dropdown-title' and contains(text(), '%s')]/following-sibling::*";

    @Test
    void testProductsListIsShownByClickOnCategoryLinkAndContainsNameOfProduct() {
        WebDriver driver = setChromeDriver();
        String homePageUrl = ONLINER_HOME_PAGE;
        driver.get(homePageUrl);
        driver.navigate().to(homePageUrl);
        driver.findElement(By.xpath(CATALOGUE_LINK)).click();
        WebElement classifier = driver.findElement(By.xpath(CLASSIFIER_COMPUTER_AND_NETS));
        classifier.click();
        WebElement categoryOfProducts = driver.findElement(By.xpath(CATEGORY_GEARS));
        categoryOfProducts.click();
        List<WebElement> products = driver.findElements(By.xpath(LIST_OF_GEARS));
        for (WebElement productName : products) {
            boolean isProductNamePresented = productName.getText().isEmpty();
            assertThat(isProductNamePresented).as("Product Title isn't presented").isTrue();
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"Видеокарты",
            "Процессоры", "Материнские платы",
            "Оперативная память", "Системы охлаждения",
            "SSD", "Жесткие диски", "Корпуса", "Звуковые карты",
            "Сетевые адаптеры", "Оптические приводы",
            "ТВ-тюнеры и карты видеозахвата", "Аксессуары для майнинга"})
    void testProductsListIsShownByClickOnCategoryLinkAndContainsCostAndCountOfProducts(String productName) {
        WebDriver driver = setChromeDriver();
        String homePageUrl = "https://www.onliner.by/";
        driver.get(homePageUrl);
        driver.navigate().to(homePageUrl);
        driver.findElement(By.xpath(CATALOGUE_LINK)).click();
        WebElement classifier = driver.findElement(By.xpath(CLASSIFIER_COMPUTER_AND_NETS));
        classifier.click();
        WebElement categoryOfProducts = driver.findElement(By.xpath(CATEGORY_GEARS));
        categoryOfProducts.click();
        List<WebElement> productDescriptions = driver.findElements(By.xpath(format(PRODUCT_DATA_PATTERN, productName)));
        for (WebElement productData : productDescriptions) {
            boolean isProductCostPresented = productData.getText().contains("от");
            assertThat(isProductCostPresented).as("Product Cost isn't presented").isTrue();
            boolean isProductCountPresented = productData.getText().contains("товар");
            assertThat(isProductCountPresented).as("Product Count isn't presented").isTrue();
        }
        driver.quit();
    }
}

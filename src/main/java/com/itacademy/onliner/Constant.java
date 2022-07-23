package com.itacademy.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.itacademy.onliner.DriverCreator.setChromeDriver;


public class Constant {

    public static final String CATALOGUE_LINK = "//span[@class='b-main-navigation__text' and contains(text(), 'Каталог')]";
    public static final String CLASSIFIER_MENU = "//span[@class='catalog-navigation-classifier__item-title-wrapper']";
    public static final String ONLINER_HOME_PAGE = "https://www.onliner.by/";


}

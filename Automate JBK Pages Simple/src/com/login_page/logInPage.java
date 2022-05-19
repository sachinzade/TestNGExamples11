package com.login_page;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class logInPage 
{
	WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	}

	@Test(dataProvider = "dp")
	public void logInTest(String uname, String pass) 
	{
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		WebElement userImg = driver.findElement(By.xpath("//img[@class='img-circle']"));
		boolean img = userImg.isDisplayed();
		Assert.assertTrue(img);
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.close();
	}

	@DataProvider
	public Object[][] dp() throws Exception 
	{
		FileInputStream fis = new FileInputStream("loginTestData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getRows();
		int col = sh.getColumns();
		String[][]arrData = new String [rows-1][col];
		for(int i = 1; i < rows; i++)
		{
			for(int j = 0; j < col; j++)
			{
				Cell cell = sh.getCell(j, i);
				String data = cell.getContents();
				arrData[i-1][j] = data;
			}
		}
		return arrData;
	}
}

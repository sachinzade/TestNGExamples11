package com.register_page;

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

public class RegistrationPageTest {
  
	WebDriver driver = null;
  @BeforeMethod
  public void beforeMethod() 
  {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
  }
  
  @Test(dataProvider = "registerData")
  public void registrationTest(String name, String mob, String email, String pass) 
	{
		driver.findElement(By.partialLinkText("Register a new membership")).click();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		String act = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String exp = "User registered successfully.";
		Assert.assertEquals(act, exp);

		driver.navigate().back();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		WebElement userImg = driver.findElement(By.xpath("//img[@class='img-circle']"));
		boolean img = userImg.isDisplayed();
		Assert.assertTrue(img);
		driver.findElement(By.partialLinkText("LOGOUT")).click();
		String act1 = driver.findElement(By.xpath("//p[text()='Logout successfully']")).getText();
		String exp1 = "Logout successfully";
		Assert.assertEquals(act1, exp1);
		
	 }

/*  @AfterMethod
  public void afterMethod() 
	{
		driver.navigate().back();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		WebElement userImg = driver.findElement(By.xpath("//img[@class='img-circle']"));
		boolean img = userImg.isDisplayed();
		Assert.assertTrue(img);
		driver.findElement(By.partialLinkText("LOGOUT")).click();
		String act = driver.findElement(By.xpath("//p[text()='Logout successfully']")).getText();
		String exp = "";
		
	}*/
  
  /*@Test(dependsOnMethods="registrationTest")
  public void login()
	{
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		WebElement userImg = driver.findElement(By.xpath("//img[@class='img-circle']"));
		boolean img = userImg.isDisplayed();
		Assert.assertTrue(img);
	}*/


  @DataProvider
  public Object[][] registerData() throws Exception 
	{

		FileInputStream fis = new FileInputStream("loginTestData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rows = sh.getRows();
		int col = sh.getColumns();
		String arrData[][] = new String[rows-1][col];
		for (int i = 1; i < rows; i++) 
		{
			for (int j = 0; j < col; j++) 
			{
				Cell cell = sh.getCell(j, i);
				String data = cell.getContents();
				arrData[i-1][j] = data;
			}
		}
		return arrData;
	}
  
/*  @DataProvider
  public Object[][] log() throws Exception 
	{

		FileInputStream fis = new FileInputStream("loginTestData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet3");
		int rows = sh.getRows();
		int col = sh.getColumns();
		String arrData[][] = new String[rows-1][col];
		for (int i = 1; i < rows; i++) 
		{
			for (int j = 0; j < col; j++) 
			{
				Cell cell = sh.getCell(j, i);
				String data = cell.getContents();
				arrData[i-1][j] = data;
			}
		}
		return arrData;
	}*/

}

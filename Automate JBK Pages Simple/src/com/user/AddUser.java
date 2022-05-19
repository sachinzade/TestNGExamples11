package com.user;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AddUser {
	
  @Test(dataProvider="user")
  public void addUserTest(String uname, String mobile, String email, String course, String gender, String state, String pass, String frdMobil)
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/add_user.html");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("course")).sendKeys(course);

		if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.id("Male")).click();
		} else if (gender.equalsIgnoreCase("female")) {
			driver.findElement(By.id("Female")).click();
		}

		WebElement e1 = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s = new Select(e1);
		s.selectByVisibleText(state);

		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@placeholder='FriendMobile']")).sendKeys(frdMobil);
		driver.findElement(By.id("submit")).click();

		String act = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String exp = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(act, exp);
  
		driver.close();
  }
  
  @DataProvider
  public Object[][] user() throws Exception 
	{

		FileInputStream fis = new FileInputStream("loginTestData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet4");
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
}

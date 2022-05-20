package com.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestDropDownList {
  @Test
  public void testDropDown() 
  {
	  
	  System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/add_user.html");
	  WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
	  Select s = new Select(element);
	  List <WebElement> list = s.getOptions();
	  int count = 0;
	  String []values = {"Maharashtra", "Delhi", "HP", "Punjab"};
	  for (WebElement opt : list) 
	  {
		for (int i = 0; i < values.length; i++) 
		{
			if(opt.getText().equals(values[i]))
			{
				System.out.println(opt.getText());
				count++;
			}
		}
	  }
	  if(count == values.length)
	  {
		  System.out.println("**Values are matched");
	  }
	  else
	  {
		  System.out.println("**Values aren't matched");
	  }
	  driver.close();
  }
  
}

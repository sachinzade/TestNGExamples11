package com.dashboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckCourses {
	
	WebDriver driver = null;
  @Test
  public void coursesTest() throws Exception 
  {
	  System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/dashboard.html");
	  driver.manage().window().maximize();
	  String mainWin = driver.getWindowHandle();
	  List<WebElement> list = driver.findElements(By.partialLinkText("More"));
	  int size = list.size();
	 /* for(int i = 0; i<4; i++ )
	  {
		  list.get(i).click();
	  }*/
	  for (WebElement element : list) 
	  {
		element.click();
	  }
	  driver.switchTo().window(mainWin);
	  Set<String> childs = driver.getWindowHandles();
	  /*Iterator<String> itr = childs.iterator();
	  while(itr.hasNext())
	  {
		  String cWins = itr.next();
		  System.out.println(cWins);
		  if(!mainWin.equals(childs))
		  {
			  driver.switchTo().window(cWins);
		  }
	  }*/
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  ArrayList<String> al = new ArrayList<>(childs);
	  driver.switchTo().window(al.get(0));
	  String url0 = driver.getCurrentUrl();
	  System.out.println("url0" + url0);
	  if(url0.contains("dashboard"))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		System.out.println("Fail");  
	  }
	  driver.close();
	  
	  driver.switchTo().window(al.get(1));
	  String url1 = driver.getCurrentUrl();
	  System.out.println("url1" + url1);
	  if(url1.contains("php"))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		System.out.println("Fail");  
	  }
	  driver.close();
	  
	  driver.switchTo().window(al.get(2));
	  String url2 = driver.getCurrentUrl();
	  System.out.println("url2" + url2);
	  if(url2.contains("python-syllabus"))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		System.out.println("Fail");  
	  }
	  driver.close();
	  
	  driver.switchTo().window(al.get(3));
	  String url3 = driver.getCurrentUrl();
	  System.out.println("url3" + url3);
	  if(url3.contains("java-j2ee-syllabus"))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		System.out.println("Fail");  
	  }
	  driver.close();
	  
	  driver.switchTo().window(al.get(4));
	  String url4 = driver.getCurrentUrl();
	  System.out.println("url4" + url4);
	  if(url4.contains("selenium-testing-syllabus"))
	  {
		  System.out.println("pass");
	  }
	  else
	  {
		System.out.println("Fail");  
	  }
	  driver.close();
	 
	  
  }
  
  
}

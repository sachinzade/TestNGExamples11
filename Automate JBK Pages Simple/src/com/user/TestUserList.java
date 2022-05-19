package com.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUserList {

	WebDriver driver = null;

	@BeforeTest
	  public void beforetest() 
	  {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///D:/SELENIUM%20+%20TESTING/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/users.html");
	  }

	@Test
	public void testUser1() 
	{
		System.out.println("\nFOR THE USER 1 ==>\n");
		for(int i = 1; i <= 8; i++)
		{
		String act =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td["+ i +"]")).getText();
		//System.out.println(act);
		if(act.equals("1"))
		{
			System.out.println("Sr.No. Of User : Pass ");
		}
		else if(act.equals("Kiran"))
		{
			System.out.println("Username : pass");
		}
		else if(act.equals("kiran@gmail.com"))
		{
			if (act.contains("gmail.com")) 
			{
				System.out.println("Email  : pass");
			} 
			else 
			{
				System.out.println("Email  : fail");
			}
		}
		else if(act.equals("9898989898"))
		{
			 if (act.length() == 10) 
			 {
				System.out.println("Mobile : pass");
			 }
			 else
			 {
				 System.out.println("Mobile : fail");
			 }
		}
		else if(act.equals("Java/J2EE"))
		{
			System.out.println("Course : pass");
		}
		else if(act.equals("Male"))
		{
			System.out.println("Gender : pass");
		}
		else if(act.equals("Maharashtra"))
		{
			System.out.println("state  : pass");
		}
		else if(act.equals("Delete"))
		{
			System.out.println("Action : pass");
		}
		else
		{
			System.out.println("Because of some Fields of table Failed this Massage is showing");
		}
		}
	}
	
	@Test
	public void testUser2() 
	{
		System.out.println("\nFOR THE USER 2 ==>\n");
		for(int i = 1; i <= 8; i++)
		{
		String act =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[3]/td["+ i +"]")).getText();
		//System.out.println(act);
		if(act.equals("2"))
		{
			System.out.println("Sr.No. Of User : Pass ");
		}
		else if(act.equals("Sagar"))
		{
			System.out.println("Username : pass");
		}
		else if(act.equals("sagar@javabykiran.com"))
		{
				/*
				 * String[] z= act.split("@");//splits the string based on
				 * whitespace for (String string : z) { System.out.print(string
				 * + " ");
				 */
				if (act.contains("gmail.com")) 
				{
					System.out.println("Email  : pass");
				} 
				else 
				{
					System.out.println("Email  : fail");
				}
		}
		else if(act.equals("999999999"))
		{
			 if (act.length() == 10) 
			 {
				System.out.println("Mobile : pass");
			 }
			 else
			 {
				 System.out.println("Mobile : fail");
			 }
		}
		else if(act.equals("Selenium"))
		{
			System.out.println("Course : pass");
		}
		else if(act.equals("Male"))
		{
			System.out.println("Gender : pass");
		}
		else if(act.equals("Punjab"))
		{
			System.out.println("state  : pass");
		}
		else if(act.equals("Delete"))
		{
			System.out.println("Action : pass");
		}
		else
		{
			System.out.println("Because of some Fields of table Failed this Massage is showing");
		}
		}
	}

	@Test
	public void testUser3() 
	{
		System.out.println("\nFOR THE USER 3 ==>\n");
		for(int i = 1; i <= 8; i++)
		{
		String act =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[4]/td["+ i +"]")).getText();
		//System.out.println(act);
		if(act.equals("3"))
		{
			System.out.println("Sr.No. Of User : Pass ");
		}
		else if(act.equals("Monica"))
		{
			System.out.println("Username : pass");
		}
		else if(act.equals("monica@gmail.com"))
		{
			if (act.contains("gmail.com")) 
			{
				System.out.println("Email  : pass");
			} 
			else 
			{
				System.out.println("Email  : fail");
			}
		}
		else if(act.equals("1111111111"))
		{
			 if (act.length() == 10) 
			 {
				System.out.println("Mobile : pass");
			 }
			 else
			 {
				 System.out.println("Mobile : fail");
			 }
		}
		else if(act.equals("Python"))
		{
			System.out.println("Course : pass");
		}
		else if(act.equals("Female"))
		{
			System.out.println("Gender : pass");
		}
		else if(act.equals("Maharashtra"))
		{
			System.out.println("state  : pass");
		}
		else if(act.equals("Delete"))
		{
			System.out.println("Action : pass");
		}
		else
		{
			System.out.println("Because of some Fields of table Failed this Massage is showing");
		}
		}
	}

	@Test
	public void testUser4() 
	{
		System.out.println("\nFOR THE USER 4 ==>\n");
		for(int i = 1; i <= 8; i++)
		{
		String act =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[5]/td["+ i +"]")).getText();
		//System.out.println(act);
		if(act.equals("4"))
		{
			System.out.println("Sr.No. Of User : Pass ");
		}
		else if(act.equals("Kimaya"))
		{
			System.out.println("Username : pass");
		}
		else if(act.equals("kimaya@gmail.com"))
		{
			if (act.contains("gmail.com")) 
			{
				System.out.println("Email  : pass");
			} 
			else 
			{
				System.out.println("Email  : fail");
			}
		}
		else if(act.equals("999999999"))
		{
			 if (act.length() == 10) 
			 {
				System.out.println("Mobile : pass");
			 }
			 else
			 {
				 System.out.println("Mobile : fail");
			 }
		}
		else if(act.equals("PHP"))
		{
			System.out.println("Course : pass");
		}
		else if(act.equals("Female"))
		{
			System.out.println("Gender : pass");
		}
		else if(act.equals("Punjab"))
		{
			System.out.println("state  : pass");
		}
		else if(act.equals("Delete"))
		{
			System.out.println("Action : pass");
		}
		else
		{
			System.out.println("Because of some Fields of table Failed this Massage is showing");
		}
		}
	}
}

package com.snapdeal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class loginpage {
	
	WebDriver driver;
	By uname=By.name("username");
By pword=By.name("password");
By submitbutton=By.xpath("//button[@type='submit']");
By dashboard=By.xpath("//h6[text()='Dashboard']");
public loginpage(WebDriver driver2) {
	this.driver=driver2;
	// TODO Auto-generated constructor stub
}
public void enterusername(String username)
{
	driver.findElement(uname).sendKeys(username);
}
public void enterpassword(String password)
{
	driver.findElement(pword).sendKeys(password);
}
 
public void clickonsubmit()
{
	driver.findElement(submitbutton).click();
}
 
public boolean dashboarddisplayed()
{
	return driver.findElement(dashboard).isDisplayed();
}
 
}
 
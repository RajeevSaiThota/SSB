package com.techouts.sslweb.webelement.ops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.util.PathProvider;

public class HacConnection {
	
	public static WebElement username;
	public static WebElement password;
	public static WebElement query;
		public static void hac(WebDriver driver,String mobileNumber){
			
			driver.get(PathProvider.getSslBaseURL()+"/hac");
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(10);
			username=driver.findElement(By.name("j_username"));
			username.clear();
			username.sendKeys("manikantha.maddila");
			password=driver.findElement(By.name("j_password"));
			password.sendKeys("Mani2394");
			driver.findElement(By.xpath("//button[@class='button']")).click();
			WebElementOperationsWeb.park(10);
			WebElementOperationsWeb.mouseOver(driver, driver.findElement(By.id("console")));
			driver.findElement(By.xpath("//a[contains(.,'flexibleSearch')]")).click();
			
			query=driver.findElement(By.xpath("(//div[@class='CodeMirror-scroll'])[1]"));
			WebElementOperationsWeb.doubleClick(driver, query);
			//query.click();
			//query.click();
			WebElementOperationsWeb.sendKeys(driver, query, "select {otp} from{userotp} where {mobile}='8099194419'");
			//query.sendKeys("select {otp} from{userotp} where {mobile}='8099194419'");
	        driver.findElement(By.xpath("(//button[@class='buttonSubmit'])[1]")).click();
	        driver.findElement(By.xpath("//li[@aria-controls='tabs-3']")).click();
	        String otp=WebElementOperationsWeb.getText(driver, driver.findElement(By.xpath("//tr[@role='row']/td")));
	        System.out.println(otp);
		}
		
		
}

package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import com.google.firebase.database.ServerValue;

import java.io.IOException;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;



import java.util.ArrayList;


import java.awt.AWTException;




public class OpenWebsite   {
	ArrayList<String> links=new ArrayList<String>();


	public  OpenWebsite () throws AWTException {

	}



	public static void main(String[] args) throws URISyntaxException, IOException {
		BuildAndRun.main(args);
	}




	public static void sleep(int x) {
		try{
			Thread.sleep(x*1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void appJoinGroup() {//Open website and run the app
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://web.whatsapp.com/");
		String nameWindoew=driver.getWindowHandle();

		sleep(25);
		for (int i = links.size()-1; i >=0 ; i--) {


			if(!nameWindoew.equals(driver.getWindowHandle().toString())) {
				driver.switchTo().window(nameWindoew);
				sleep(2);

			}
			driver.get(links.get(i));

			sleep(1);


			try {
				driver.findElement(By.className("_whatsapp_www__block_action")).click();

			}
			catch(Exception e) {

			}


			sleep(1);
			try {
				driver.findElement(By.xpath("//*[@id=\"fallback_block\"]/div/div/a")).click();

			}
			catch(Exception e) {
				try {
					driver.findElement(By.linkText("استخدام واتساب ويب")).click();
				}
				catch(Exception e1) {

				}
			}		

			sleep(5);
			try {

				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/span[2]/div[1]/div/div/div/div/div/div[2]/div[2]")).click();
			}
			catch(Exception e) {
			}	

			sleep(1);
			if(i==0)i=links.size();

		}

	}
}

package googlesearchpage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class verifytitle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/ss/home.html");
		Thread.sleep(3000);
		String t= driver.findElement(By.id("someid")).getText();
		System.out.println("text is"+t);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("facebook");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='tads']/div/div/div/div[1]/a/div[1]")).click();
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String prntwnd=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Cookie Policy']")).click();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		Set<String>winds=driver.getWindowHandles();
		Iterator<String> it= winds.iterator();
		while(it.hasNext()){
			for(int i=0;i<winds.size();i++){
				System.out.println(winds.size());
				String ChildWindow=it.next();
				if(i==0 & !prntwnd.equals(ChildWindow)){
			driver.switchTo().window(ChildWindow);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div/div/div[1]/div[2]/div/ul/li[1]/a")));
			driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[1]/div[2]/div/ul/li[2]/a")).click();
				}
				else if (i==1 & !prntwnd.equals(ChildWindow)){
					driver.switchTo().window(ChildWindow);
					System.out.println(driver.getTitle());
					driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[1]/div[2]/div/ul/li[2]/a")).click();
				}
					
			}
			
		}
		Set<String>windss=driver.getWindowHandles();
		Iterator<String> its= windss.iterator();
		while(its.hasNext()){
			for(int j=0;j<windss.size();j++){
				System.out.println(windss.size());
				String ChildsWindow=its.next();
				if(j==2 & !prntwnd.equals(ChildsWindow)){
			driver.switchTo().window(ChildsWindow);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Surath");
				}
				
					
			}
			
		}
		driver.switchTo().window(prntwnd);
		driver.findElement(By.name("reg_email__")).sendKeys("SurathECE");
	
	}

}

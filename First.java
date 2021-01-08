package selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class First {

	public static void main(String[] args) {
		System.out.println("assingnment");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.navigate().to("http://book.theautomatedtester.co.uk/");
		driver.manage().window().maximize();
		Testing test=new Testing();
		driver.findElement(test.chapter1).click();
		WebElement radio=driver.findElement(test.radio);
		radio.click();
		WebElement dropdowm=driver.findElement(test.dropdown);
		driver.findElement(test.dropdown).click();
		Select sel=new Select(dropdowm);
		sel.selectByVisibleText("Selenium IDE");
		dropdowm.click();
		WebElement loadtext=driver.findElement(By.xpath("//input[@id='secondajaxbutton']"));
		loadtext.click();
		WebElement check=driver.findElement(test.check);
		check.click();
		String oldwindow=driver.getWindowHandle();
		driver.findElement(test.anotherwindow).click();
		Set<String> handles=driver.getWindowHandles();
		for(String newwindow:handles) {
			driver.switchTo().window(newwindow);
		}
		driver.findElement(By.xpath("//p[@id='closepopup']")).click();
		driver.switchTo().window(oldwindow);
		//driver.get("http://book.theautomatedtester.co.uk/chapter4");
		//driver.navigate().back();
		driver.findElement(test.verify).click();
		if(driver.findElement(test.verify).isEnabled())
		{
			driver.findElement(test.verify).click();
			System.out.println("click");
		}else
		{
			System.out.println("not click");
		}
		driver.findElement(test.home).click();
		driver.findElement(test.chapter4).click();
		driver.findElement(test.textbox1).click();
		driver.findElement(test.textbox1).sendKeys("assignment");
		WebElement dropdown1=driver.findElement(test.dropdown1);
		driver.findElement(test.dropdown1).click();
		Select se=new Select(dropdown1);
		se.selectByVisibleText("Selenium RC");
		dropdown1.click();
		driver.findElement(test.textbox2).click();
		driver.findElement(test.textbox2).sendKeys("abcd");
		driver.findElement(test.bidbox).click();
		driver.switchTo().alert().accept();
		driver.findElement(test.bidbox).sendKeys("50");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		WebElement hover=driver.findElement(test.hover);
		act.moveToElement(hover).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		driver.navigate().back();
		
		
		
		
		


	}

}

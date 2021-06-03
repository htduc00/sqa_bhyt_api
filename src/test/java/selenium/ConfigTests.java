package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Transactional
public class ConfigTests extends TestDriver{
	ChromeDriver driver = getDriver();
	
	public void passLogin() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test
	public void test_config_page() {
		driver.get("http://localhost:3000/config");
		passLogin();
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Cau Hinh");
	}
	@Test
	public void test_update_salary_success() {
		driver.get("http://localhost:3000/config");
		passLogin();
		driver.findElement(By.id("slspan1")).click();
		boolean staleElement0 = true;
		while(staleElement0){
			  try{
				  driver.findElement(By.id("edit0")).click();
			     staleElement0 = false;

			  } catch(ElementNotInteractableException e){
			    staleElement0 = true;
			  }
		}
		WebElement cost =  driver.findElement(By.id("cost0"));
		cost.clear();
		cost.sendKeys("1590000");
		driver.findElement(By.id("save0")).click();
		String message = driver.findElement(By.className("nfc-message")).getText();
		driver.close();
		assertEquals(message, "Lưu thành công");
	}
	@Test
	public void test_update_salary_fail() {
		driver.get("http://localhost:3000/config");
		passLogin();
		driver.findElement(By.id("slspan1")).click();
		boolean staleElement0 = true;
		while(staleElement0){
			  try{
				  driver.findElement(By.id("edit0")).click();
			     staleElement0 = false;

			  } catch(ElementNotInteractableException e){
			    staleElement0 = true;
			  }
		}
		WebElement cost =  driver.findElement(By.id("cost0"));
		cost.clear();
		cost.sendKeys("0");
		driver.findElement(By.id("save0")).click();
		String message = driver.findElement(By.className("nfc-message")).getText();
		driver.close();
		assertEquals(message, "Tiền lương phải nguyên và lớn hơn 0");
	}
	@Test
	public void test_update_payment_success() {
		driver.get("http://localhost:3000/config");
		passLogin();
		driver.findElement(By.id("slspan2")).click();
		boolean staleElement0 = true;
		while(staleElement0){
			  try{
				  driver.findElement(By.id("edit1")).click();
			     staleElement0 = false;

			  } catch(ElementNotInteractableException e){
			    staleElement0 = true;
			  }
		}
		WebElement cost =  driver.findElement(By.id("cost1"));
		cost.clear();
		cost.sendKeys("4.5");
		driver.findElement(By.id("save1")).click();
		String message = driver.findElement(By.className("nfc-message")).getText();
		driver.close();
		assertEquals(message, "Lưu thành công");
	}
	@Test
	public void test_update_payment_fail() {
		driver.get("http://localhost:3000/config");
		passLogin();
		driver.findElement(By.id("slspan2")).click();
		boolean staleElement0 = true;
		while(staleElement0){
			  try{
				  driver.findElement(By.id("edit1")).click();
			     staleElement0 = false;

			  } catch(ElementNotInteractableException e){
			    staleElement0 = true;
			  }
		}
		WebElement cost =  driver.findElement(By.id("cost1"));
		cost.clear();
		cost.sendKeys("101");
		driver.findElement(By.id("save1")).click();
		String message = driver.findElement(By.className("nfc-message")).getText();
		driver.close();
		assertEquals(message, "Mức đóng không hợp lệ, mức đóng phải thuộc 0.0 -> 100.0");
	}
	
}

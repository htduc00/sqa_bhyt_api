package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListTests extends TestDriver{
	ChromeDriver driver = getDriver();
	
	public void passLogin() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test
	public void test_home_page() {
		driver.get("http://localhost:3000");
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Home");
	}
	
	@Test
	public void test_ds_tham_gia() {
		driver.get("http://localhost:3000/list");
		passLogin();
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Danh Sach Tham Gia");
	}
	
	@Test
	//case 1: thanhpho = 0, quan = 0, phuong = 0
	public void test_loc_danh_sach_tham_gia_case1(){
		driver.get("http://localhost:3000/list");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select quan = new Select(driver.findElement(By.id("quan")));
		Select phuong = new Select(driver.findElement(By.id("phuong")));
		thanhpho.selectByIndex(0);
		quan.selectByIndex(0);
		phuong.selectByIndex(0);
		driver.findElement(By.id("btLoc")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "ABC");
	}
	@Test
	//case 2: thanhpho != 0, quan = 0, phuong = 0
	public void test_loc_danh_sach_tham_gia_case2() {
		driver.get("http://localhost:3000/list");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select quan = new Select(driver.findElement(By.id("quan")));
		Select phuong = new Select(driver.findElement(By.id("phuong")));
		thanhpho.selectByIndex(1);
		quan.selectByIndex(0);
		phuong.selectByIndex(0);
		driver.findElement(By.id("btLoc")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "ABC");
	}
	@Test
	//case 3: thanhpho != 0, quan != 0, phuong = 0
	public void test_loc_danh_sach_tham_gia_case3() {
		driver.get("http://localhost:3000/list");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select quan = new Select(driver.findElement(By.id("quan")));
		Select phuong = new Select(driver.findElement(By.id("phuong")));
		thanhpho.selectByIndex(1);
		quan.selectByIndex(1);
		phuong.selectByIndex(0);
		driver.findElement(By.id("btLoc")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "ABC");
	}
	@Test
	//case 4: thanhpho != 0, quan != 0, phuong != 0
	public void test_loc_danh_sach_tham_gia_case4() {
		driver.get("http://localhost:3000/list");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select quan = new Select(driver.findElement(By.id("quan")));
		Select phuong = new Select(driver.findElement(By.id("phuong")));
		thanhpho.selectByIndex(1);
		quan.selectByIndex(1);
		phuong.selectByIndex(1);
		driver.findElement(By.id("btLoc")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "ABC");
	}
	
	@Test
	public void test_search_by_name() {
		driver.get("http://localhost:3000/list");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select quan = new Select(driver.findElement(By.id("quan")));
		Select phuong = new Select(driver.findElement(By.id("phuong")));
		thanhpho.selectByIndex(1);
		quan.selectByIndex(1);
		phuong.selectByIndex(1);
		driver.findElement(By.id("btLoc")).click();
		Select search_option = new Select(driver.findElement(By.id("search_option")));
		WebElement search = driver.findElement(By.id("search"));
		search_option.selectByIndex(1);
		search.sendKeys("H");
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slName1")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Hoàng Trung Đức");
	}
}

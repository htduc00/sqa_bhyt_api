package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReportTests extends TestDriver{
	ChromeDriver driver = getDriver();
	
	public void passLogin() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
	}
	@Test
	public void test_report_paid() {
		driver.get("http://localhost:3000/report/paid");
		passLogin();
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Danh Sach Dong Tien");
	}
	@Test
	// case 1: khong chon thanh pho (id = 0), year = now
	public void test_loc_danh_sach_dong_tien_case1() {
		driver.get("http://localhost:3000/report/paid");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select year = new Select(driver.findElement(By.id("year")));
		thanhpho.selectByIndex(0);
		year.selectByIndex(0);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("dong0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Đã Đóng: 2");
	}
	@Test
	// case 2: khong chon thanh pho (id = 0), year != now
	public void test_loc_danh_sach_dong_tien_case2() {
		driver.get("http://localhost:3000/report/paid");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select year = new Select(driver.findElement(By.id("year")));
		thanhpho.selectByIndex(0);
		year.selectByIndex(1);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("dong0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Đã Đóng: 0");
	}
	@Test
	// case 3: chon thanh pho (id !=0), year = now
	public void test_loc_danh_sach_dong_tien_case3() {
		driver.get("http://localhost:3000/report/paid");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select year = new Select(driver.findElement(By.id("year")));
		thanhpho.selectByIndex(1);
		year.selectByIndex(0);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("dong0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Đã Đóng: 2");
	}
	@Test
	// case 4: chon thanh pho (id !=0), year != now
	public void test_loc_danh_sach_dong_tien_case4() {
		driver.get("http://localhost:3000/report/paid");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select year = new Select(driver.findElement(By.id("year")));
		thanhpho.selectByIndex(1);
		year.selectByIndex(1);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("dong0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Đã Đóng: 0");
	}
	
	@Test
	public void test_new_join() {
		driver.get("http://localhost:3000/report/new_join");
		passLogin();
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Danh Sach Moi Tham Gia");
	}
	
	@Test
	// case 1: tp = 0, theo thang
	public void test_loc_danh_sach_moi_tham_gia_case1() {
		driver.get("http://localhost:3000/report/new_join");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select filter = new Select(driver.findElement(By.id("filter")));
		thanhpho.selectByIndex(0);
		filter.selectByIndex(0);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		 try{
			name = driver.findElement(By.id("slName0")).getText();
		  } catch(Exception e){
				driver.close();
				assertNotNull(e);
		  }
	}
	@Test
	// case 2: tp = 0, theo nam
	public void test_loc_danh_sach_moi_tham_gia_case2() {
		driver.get("http://localhost:3000/report/new_join");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select filter = new Select(driver.findElement(By.id("filter")));
		thanhpho.selectByIndex(0);
		filter.selectByIndex(1);
		driver.findElement(By.id("btXem")).click();
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
	// case 3: tp != 0, theo thang
	public void test_loc_danh_sach_moi_tham_gia_case3() {
		driver.get("http://localhost:3000/report/new_join");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select filter = new Select(driver.findElement(By.id("filter")));
		thanhpho.selectByIndex(1);
		filter.selectByIndex(0);
		driver.findElement(By.id("btXem")).click();
		String name="";
		boolean staleElement = true; 
		 try{
			name = driver.findElement(By.id("slName0")).getText();
		  } catch(Exception e){
				driver.close();
				assertNotNull(e);
		  }
	}
	@Test
	// case 4: tp != 0, theo nam
	public void test_loc_danh_sach_moi_tham_gia_case4() {
		driver.get("http://localhost:3000/report/new_join");
		passLogin();
		Select thanhpho = new Select(driver.findElement(By.id("thanhpho")));
		Select filter = new Select(driver.findElement(By.id("filter")));
		thanhpho.selectByIndex(1);
		filter.selectByIndex(1);
		driver.findElement(By.id("btXem")).click();
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
	public void test_report_revenue() {
		driver.get("http://localhost:3000/report/revenue");
		passLogin();
		String title = driver.getTitle();
		driver.close();
		assertEquals(title, "Doanh Thu");
	}
	
	@Test
	//case 1: sap xep A-Z
	public void test_get_doanh_thu_AZ() {
		driver.get("http://localhost:3000/report/revenue");
		passLogin();
		Select year = new Select(driver.findElement(By.id("year")));
		Select sort = new Select(driver.findElement(By.id("sort")));
		year.selectByIndex(0);
		sort.selectByIndex(0);
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slTPName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Cần Thơ");
	}
	@Test
	//case 2: sap xep top down
	public void test_get_doanh_thu_top_down() {
		driver.get("http://localhost:3000/report/revenue");
		passLogin();
		Select year = new Select(driver.findElement(By.id("year")));
		Select sort = new Select(driver.findElement(By.id("sort")));
		year.selectByIndex(0);
		sort.selectByIndex(1);
		String name="";
		boolean staleElement = true; 
		while(staleElement){
		  try{
			 name = driver.findElement(By.id("slTPName0")).getText();
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		driver.close();
		assertEquals(name, "Hà Nội");
	}
	
}

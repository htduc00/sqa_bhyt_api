package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		return new ChromeDriver();
	}
}

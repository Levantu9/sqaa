package loginn;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	WebDriver driver;
	WebElement element;
	String url = "http://localhost:8080/qld/gddangnhap.jsp";
	int i = 0;
	String result = "";

	private ListTestCaseLogin listTestCase = new ListTestCaseLogin();

	private void loadTestcase() {
		Gson gson = new Gson();
		try {
			listTestCase = gson.fromJson(
					new FileReader(new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/testcaselogin.json")),
					ListTestCaseLogin.class);
		} catch (Exception e) {
			System.out.println("loi doc file " + e.getMessage());
		}
	}

			

	@Test(priority = 0)
	private void Testcase1() {
		try {
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys(listTestCase.getList().get(i).getUser());
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys(listTestCase.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (!loginSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Trang chu quan ly";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n ---------------------------------------------------------------------- \n ";
					assertEquals(mm, tt);
				}
			}

		} catch (Exception e) {
		}
		i++;
	}
	
	
	
	@Test(priority = 1)
	private void Testcase2() {
		try {
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys(listTestCase.getList().get(i).getUser());
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys(listTestCase.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (!loginSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Trang chu quan ly";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n ---------------------------------------------------------------------- \n";
					assertEquals(mm, tt);
				} 
			}

		} catch (Exception e) {
		}
		i++;
	}
	
	
	
	@Test(priority = 2)
	private void Testcase3() {
		try {
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys(listTestCase.getList().get(i).getUser());
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys(listTestCase.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (!loginSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Trang chu quan ly";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n ----------------------------------------------------------------------\n";
					assertEquals(mm, tt);
				} 
			}

		} catch (Exception e) {
		}
		i++;
	}
	
	
	
	@Test(priority = 3)
	private void Testcase4() {
		try {
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys(listTestCase.getList().get(i).getUser());
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys(listTestCase.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (!loginSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Trang chu quan ly";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n ---------------------------------------------------------------------- \n";
					assertEquals(mm, tt);
				} 
			}

		} catch (Exception e) {
		}
		i++;
	}
	
	
	
	@Test(priority = 4)
	private void Testcase5() {
		try {
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys(listTestCase.getList().get(i).getUser());
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys(listTestCase.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (!loginSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Trang chu quan ly";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Ket qua mong muon: "  + mm + "\n";
                result += "ket qua thuc te: "  + tt + "\n";      
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n ---------------------------------------------------------------------- \n";
					assertEquals(mm, tt);
				} 
			}

		} catch (Exception e) {
		}
		i++;
	}
	
	

	@BeforeClass
	private void suiteSetup() {
		WebDriverManager.chromedriver().setup();
		loadTestcase();
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
		}
	}

	@AfterClass
	private void afterClass() {
		driver.close();
		driver.quit();
		writeResult(result);
	}

	private void writeResult(String result) {
		File file = new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/resulttestlogin.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.println(result);
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.print("Loi ghi file " + e.getMessage());
		}
	}

	private static boolean loginSuccess(WebDriver webDriver) {
		try {
			if (webDriver.findElement(By.id("message")) != null)
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}

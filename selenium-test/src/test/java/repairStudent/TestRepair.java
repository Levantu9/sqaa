package repairStudent;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginn.ListTestCaseLogin;

public class TestRepair {
	WebDriver driver;
	WebElement element;
	
	WebDriver driver1;
	WebElement element1;
	String url = "http://localhost:8080/qld/gddangnhap.jsp";
	int i = -1;
	String result = "";

	private ListTestcaseRepair listTestCase = new ListTestcaseRepair();

	private void loadTestcase() {
		Gson gson = new Gson();
		try {
			listTestCase = gson.fromJson(
					new FileReader(new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/listtestcaserepairstudent.json")),
					ListTestcaseRepair.class);
		} catch (Exception e) {
			System.out.println("loi doc file " + e.getMessage());
		}
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
			element = driver.findElement(By.id("tendangnhap"));
			element.sendKeys("lva");
			Thread.sleep(1000);
			element = driver.findElement(By.id("matkhau"));
			element.sendKeys("1");
			Thread.sleep(1000);
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1000);
			element = driver.findElement(By.id("quanlytaikhoan"));
			element.click();
			Thread.sleep(1000);
			element = driver.findElement(By.id("buttontimkiem"));
			element.click();
			Thread.sleep(1000);
			element = driver.findElement(By.id("sua"));
			element.click();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
	
	@Test(priority = 1)
	public void Testcase1() {
		i+=1;
		try {
			
			element = driver.findElement(By.id("name"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getName());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1500);
			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = "Quan ly user";
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";  
                element = driver.findElement(By.id("sua"));
    			element.click();
    			Thread.sleep(1000);
                assertEquals(mm,tt);
                System.out.println(i);
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
	}
	
	
	@Test(priority = 2)
	public void Testcase2() {
		i+=1;
		try {
			element = driver.findElement(By.id("name"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getName());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();

			Thread.sleep(1000);

			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = listTestCase.getList().get(i).getMessage();
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Ket qua mong muon: "  + mm + "\n";	
                result += "Ket qua thuc te: "  + tt + "\n";   

                element = driver.findElement(By.id("sua"));
    			element.click();
    			Thread.sleep(1000);
                assertEquals(mm,tt);
			} else {
				element = driver.findElement(By.id("message"));
				if (element.getCssValue("display").equals("block")) {
					String tt = element.getText();
					String mm = listTestCase.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					result += "Ket qua mong muon: " + mm + "\n";
					result += "Ket qua thuc te: " + tt
							+ "\n --------------------------------------------------------------------- \n ";
					assertEquals(mm, tt);

					 element = driver.findElement(By.id("sua"));
		    			element.click();
		    			Thread.sleep(1000);
				}	
			}

		} catch (Exception e) {
		}
	}
	
	
	
	@Test(priority = 3)
	public void Testcase3() {
		i+=1;
		try {
			
			element = driver.findElement(By.id("sdt"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getPhone());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1000);
			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = listTestCase.getList().get(i).getMessage();
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Ket qua mong muon: "  + mm + "\n";
                result += "Ket qua thuc te: "  + tt + "\n";      
                element = driver.findElement(By.id("sua"));
    			element.click();
    			Thread.sleep(1000);
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
	}
	
	
	
	@Test(priority = 4)
	public void Testcase4() {
		i+=1;
		try {
			
			element = driver.findElement(By.id("email"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getEmail());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1000);
			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = listTestCase.getList().get(i).getMessage();
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                element = driver.findElement(By.id("sua"));
    			element.click();
    			Thread.sleep(1000);
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
	}
	
	@Test(priority = 5)
	public void Testcase5() {
		i+=1;
		try {
				
			element = driver.findElement(By.id("email"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getEmail());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1000);
			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = listTestCase.getList().get(i).getMessage();
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Kết quả mong muốn: "  + mm + "\n";
                result += "Kết quả thực tế: "  + tt + "\n";      
                element = driver.findElement(By.id("sua"));
    			element.click();
    			Thread.sleep(1000);
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
	}
	
	
	@Test(priority = 6)
	public void Testcase6() {
		i+=1;
		try {
			
			element = driver.findElement(By.id("email"));
			element.clear();
			element.sendKeys(listTestCase.getList().get(i).getEmail());
			Thread.sleep(1000);			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(1000);
			if (repairSuccess(driver)) {
				String tt = driver.getTitle();
				String mm = listTestCase.getList().get(i).getMessage();
                result += "Testcase" + (i + 1) + ": " + "\n";
                result += "Ket qua mong muon: "  + mm + "\n";
                result += "Ket qua thuc te: "  + tt + "\n";      
                WebElement element1 = driver.findElement(By.id("sua"));
    			element1.click();
    			Thread.sleep(1000);
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
	}
	
	
	
	
	@AfterClass
	private void afterClass() {
		driver.close();
		driver.quit();
		writeResult(result);
	}
	
	
	
	private static boolean repairSuccess(WebDriver driver) {
		try {
			if (driver.getTitle().equals("Quan ly user"))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false; 
	}
	
	private void writeResult(String result) {
		File file = new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/resulttestrepair.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.println(result);
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.print("Loi ghi file " + e.getMessage());
		}
	}
}

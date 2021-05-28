package testAddstudent;

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

public class TestAddStudent {
	WebDriver driver;
	WebElement element;
	String url = "http://localhost:8080/qld/gddangnhap.jsp";
	int i = -1;
	String result = "";
	
	private ListTestcaseAddStudent listTestCaseAddStudent = new ListTestcaseAddStudent();
	private void loadTestcase() {
		Gson gson = new Gson();
		try {
			listTestCaseAddStudent = gson.fromJson(
					new FileReader(new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/listtestcaseaddstudentt.json")),
					ListTestcaseAddStudent.class);
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
			Thread.sleep(2000);
			element = driver.findElement(By.id("quanlytaikhoan"));
			element.click();
			Thread.sleep(2000);
			element = driver.findElement(By.id("them"));
			element.click();
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}
	
	
	@Test(priority = 1)
	public void Testcase1() {
		i+=1;
		try {
			
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
					result += "Testcase " + (i + 1) + ": " + "\n";
					System.out.println(tt);
					System.out.println(mm);
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
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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
	
	
	@Test(priority = 3)
	public void Testcase3() {
		i+=1;
		try {
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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
	
	
	@Test(priority =  4)
	public void Testcase4() {
		i+=1;
		try {
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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
	
	@Test(priority = 7)
	public void Testcase7() {
		i+=1;
		try {
			loadTestcase();
			element = driver.findElement(By.id("name"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getName());
			Thread.sleep(1000);
			element = driver.findElement(By.id("ign"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getIng());
			Thread.sleep(1000);
			element = driver.findElement(By.id("password"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPassword());
			Thread.sleep(1000);
			element = driver.findElement(By.id("sdt"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getPhone());
			Thread.sleep(1000);
			element = driver.findElement(By.id("email"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getEmail());
			Thread.sleep(1000);
			element = driver.findElement(By.id("vaitro"));
			element.sendKeys(listTestCaseAddStudent.getList().get(i).getRole());
			Thread.sleep(1000);
			
			element = driver.findElement(By.id("button"));
			element.click();
			Thread.sleep(3000);
			if (addSuccess(driver)) {
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
					String mm = listTestCaseAddStudent.getList().get(i).getMessage();
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

	private void writeResult(String result) {
		File file = new File("C:/Users/Admin/Documents/DamBaoChatLuongPhanMem/resulttestaddstudent.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.println(result);
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.print("Loi ghi file " + e.getMessage());
		}
	}
	private static boolean addSuccess(WebDriver driver) {
		try {
			if (driver.getTitle().equals("Trang chu quan ly"))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}

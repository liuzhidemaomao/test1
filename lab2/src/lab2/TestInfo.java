package lab2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestInfo {
	private WebDriver driver;
	private String baseUrl;
	
	private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private InputStream stream = null;
	Workbook wb;
	
	@Before
	public void setUp() throws Exception{
		String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		stream = new FileInputStream("C:\\Users\\DELL\\Desktop\\»Ìº˛≤‚ ‘√˚µ•.xlsx");
		try {
			wb = new XSSFWorkbook(stream);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
		for(int i = 2; i < sheet.getPhysicalNumberOfRows(); i++)
		{
			Row row = sheet.getRow(i);
			int maxCells = row.getLastCellNum();
			ArrayList<String> sList = new ArrayList<String>();
			Cell cell = null;
			for(int j=1; j < maxCells; j++)
			{
				cell = row.getCell(j);
				if(cell == null)
					continue;
				cell.setCellType(CellType.STRING);
				sList.add(cell.getStringCellValue());
				
			}
			//System.out.print(sList);
			list.add(sList);
		}
	}
	
	@Test
	public void TestInformation() {
		driver.get(baseUrl + '/');
		for (int i = 0; i < list.size(); i++) {
			WebElement webElement = driver.findElement(By.name("id"));
			webElement.click();
			driver.findElement(By.name("id")).clear();
			String id = list.get(i).get(0);
			String passwd = id.substring(4);
			driver.findElement(By.name("id")).sendKeys(id);
			WebElement webElement2 = driver.findElement(By.name("password"));
			webElement2.click();
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(passwd);
			driver.findElement(By.id("btn_login")).click();
			String idString = driver.findElement(By.id("student-id")).getText();
			String passwordString = driver.findElement(By.id("student-name")).getText();
			String gitUrlString = driver.findElement(By.id("student-git")).getText();
			ArrayList<String> teStrings = new ArrayList<String>();
			teStrings.add(idString);
			teStrings.add(passwordString);
			teStrings.add(gitUrlString);
			assertEquals(list.get(i), teStrings);
			
			driver.findElement(By.id("btn_logout")).click();
			driver.findElement(By.id("btn_return")).click();
		}
	}
	
}

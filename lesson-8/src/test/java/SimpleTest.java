/**
 * Created by Jacek on 2015-08-01.
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SimpleTest {

    private static WebDriver driver;

    private static final String URL = "http://localhost:8080/registrationform/";
	private String genEmail(Integer len)
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < len; i++) 
		{
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString() +"@gmail.com";
	}
	
    @Before
    public void openBrowser(){
        driver = new FirefoxDriver();
		//driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void shouldShowWrongAnswerPopupWhenAsnwerIsIncorrect(){

        driver.get(URL);
        String title = driver.getTitle();
		String email = genEmail(10);
        assertEquals("Rule Financial Registration Form", title);

        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys("Pan");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Bomblinski");
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("repeatEmail")).sendKeys(email);
		
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[6]/div/table/tbody/tr[1]/td/table/tbody/tr/td[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='gwt-uid-25']")).click();
		driver.findElement(By.xpath(".//*[@id='gwt-uid-26']")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]/button")).click();
		assertTrue(driver.findElement(By.xpath("html/body/div[5]")).isDisplayed());	
    }
	
	@Test
    public void shouldShowRightAnswerPopupWhenAsnwerCorrect(){
        driver.get(URL);
        String title = driver.getTitle();
		String email = genEmail(10);
        assertEquals("Rule Financial Registration Form", title);

        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys("Pan");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Bomblinski");
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("repeatEmail")).sendKeys(email);
		
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[6]/div/table/tbody/tr[1]/td/table/tbody/tr/td[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='gwt-uid-25']")).click();
		driver.findElement(By.xpath(".//*[@id='gwt-uid-26']")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]/button")).click();
		assertTrue(driver.findElement(By.xpath("html/body/div[5]/div/div")).isDisplayed());	

    }
	
	@Test
    public void shouldShowRightAnswerPopupWhenAsnwerCorrect(){

        driver.get(URL);
        String title = driver.getTitle();
		String email = genEmail(10);
        assertEquals("Rule Financial Registration Form", title);

		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("repeatEmail")).sendKeys(email+"bla");
		
		assertTrue(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[5]/div/div")).isDisplayed())

    }
	
    @After
    public void closeBrowser(){
        driver.quit();
    }
}

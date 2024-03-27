package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.TimeoutException;

public class BasePage {
	public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    static{
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }        

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.close();
    }

    private WebElement Find(String locator){
    	WebElement ele = null;
    	try {
    		ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));	
    	}catch(TimeoutException  ex) {
    		//System.out.println(ex.getMessage());
    		System.out.println("WebElement :"+locator+" Not found");
    		//throw ex;
    	}
        return ele;
    }
    

    public void clickElementBasePage(String locator){
        Find(locator).click();
    }
    
    
    
    public void findValidElementContains(String word, String locator) {
    	String FindWord = Find(locator).getText();
    	//System.out.println("UNO"+FindWord+" - "+word);
    	Assert.assertTrue(FindWord.contains(word));
    }
    
    

    public void write(String keyToSend,String locator) {
    	Find(locator).clear();
        Find(locator).sendKeys(keyToSend);
        Find(locator).sendKeys(Keys.ENTER);
    }

    
    public void findValidMove(String locator) {
    	WebElement ele = Find(locator);
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();	
    }
    
    public String findValidElement(String locator) {
    	String FindWord = Find(locator).getText();
    	//System.out.println("La palabra :"+word +" - "+FindWord);
    	//Assert.assertTrue(FindWord.contains(word));
    	//Assert.assertEquals(word, FindWord);
    	return FindWord;
    }
    
    public int findValidElements(String locator) {
    	Find(locator);
    	List<WebElement> lista = driver.findElements(By.xpath(locator));
    	return lista.size();
    }
    
    public int findValidElementsBasePage2(String locator) {
    	Find(locator);
    	List<WebElement> lista = driver.findElements(By.xpath(locator));
    	return lista.size();
    } 
    
     
}

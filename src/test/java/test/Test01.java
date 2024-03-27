package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import pages.MainPageLiverpool;

@Test(groups={"sanity","regression"})
public class Test01 {
	MainPageLiverpool mainPage = new MainPageLiverpool();
	private String word1 = "playstation";
	private String searchBar = "//input[@id='mainSearchbar']";
	private String consola = "//h5[@class='card-title a-card-description'][contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'consola')]";
	private String playstation5 = "//h5[@class='card-title a-card-description'][contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'playstation 5')]";
	private String description = "Control gamepad Sony inalámbrica para Playstation 5";
	private String cantidad = "$7,195";
	private String descriptionTest = "//h1[@class='a-product__information--title']";
	private String cantidadTest = "//p[contains(@class,'a-product__paragraphDiscountPrice m-0 d-inline ')]";
	
	@BeforeTest
	public void setUpTest() {
		mainPage.navigateToLiverpool();
		
	}
	
	@Test
	public void test01() throws InterruptedException {
		mainPage.clickInsertEnter(word1,searchBar);
		int valConsola = mainPage.findElements(consola);
		Assert.assertTrue(valConsola>0);
		int valPlaystation = mainPage.findElements(playstation5);
		Assert.assertTrue(valPlaystation>0);
		mainPage.clickElement(playstation5);
		Thread.sleep(5000);
		String descriptionFound = mainPage.findElement(descriptionTest);
		Assert.assertEquals(descriptionFound, description);
		String candidadFound = mainPage.findElement(cantidadTest);
		Assert.assertTrue(candidadFound.contains(cantidad));
		
	}
	
	@AfterTest
	public void tearDownTest() {
		mainPage.closeBrowser();
		
	}
}

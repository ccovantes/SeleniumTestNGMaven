package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MainPageLiverpool;

@Test(groups= {"smoke","regression"})
public class Test02 {
	MainPageLiverpool mainPage = new MainPageLiverpool();
	private String wordTV = "smart tv";
	private String searchBar = "//input[@id='mainSearchbar']";
	private String wordSize = "Tamaño";
	private String wordPrice = "Precios";
	private String labelSize = "//label[@title='Tamaño'][contains(.,'Tamaño')]";
	private String labelPrice = "//label[@title='Precios'][contains(.,'Precios')]"; 
	private String SeeMoreLink = "(//a[contains(@class,'a-link__viewMore')])[2]";
	private String check55 = "//input[contains(@id,'variants.normalizedSize-55 pulgadas')]";
	private String radio10 = "//input[contains(@id,'variants.prices.sortPrice-10000-700000')]";
	private String productText = "Productos";
	private String labelProduct = "//p[@class='a-plp-results-title'][contains(.,'233 Productos')]";
	private String information = "//li[@class='m-product__card card-masonry a']";
	private String cantidad = "//p[@class='a-plp-results-title']";
	private String brandRadioSony = "//input[@id='brand-SONY']";
	
	@BeforeTest
	public void setUpTest() {
		mainPage.navigateToLiverpool();	
	}
	
	@Test
	public void test01() throws InterruptedException {
		mainPage.clickInsertEnter(wordTV,searchBar);
		//String findSize = mainPage.findElement(labelSize);
		//Assert.assertEquals(findSize, wordSize);
		String findPrice = mainPage.findElement(labelPrice);
		Assert.assertEquals(wordPrice, findPrice);
		mainPage.clickElement(SeeMoreLink);
		mainPage.clickElement(check55);
		Thread.sleep(5000);
		mainPage.clickElement(radio10);
		//System.out.println("Radio boton 10");
		Thread.sleep(5000);
		mainPage.clickElement(brandRadioSony);
		int count = mainPage.findElements(information);
		Assert.assertTrue(count>0);
	}
	
	@AfterTest
	public void tearDownTest() {
		mainPage.closeBrowser();
		
	}
}

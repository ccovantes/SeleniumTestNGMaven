package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MainPageLiverpool;

@Test(groups = {"regression"})
public class Test03 {
	MainPageLiverpool mainPage = new MainPageLiverpool();
	String categoryLink = "//span[@class='a-header__strongLink nav-desktop-menu-action pr-3 pb-3'][contains(.,'Categorías')]";
	String bellesaLik = "//span[@class='t-titleCategory'][contains(.,'Belleza')]";
	String PerfumeMan = "//a[contains(.,'Perfumes Hombre')]";
	String seeMoreLink = "//a[contains(@id,'Marcas')]";
	String DiorCheck = "//input[contains(@id,'brand-DIOR')]";
	String description = "//h5[@class='card-title a-card-description']";
	String cantidad = "//p[@class='a-plp-results-title']";
	
	@BeforeTest
	public void setUpTest() throws InterruptedException {
		mainPage.navigateToLiverpool();	
		
	}
	
	@Test
	public void test01() throws InterruptedException {
		mainPage.clickElement(categoryLink);
		mainPage.moveToMouseOver(bellesaLik);
		mainPage.clickElement(PerfumeMan);
		mainPage.clickElement(seeMoreLink);
		mainPage.clickElement(DiorCheck);
		Thread.sleep(5000);
		int totalDescription = mainPage.findValidElements(description);
		Assert.assertTrue(totalDescription>0);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		mainPage.closeBrowser();
		
	}
}

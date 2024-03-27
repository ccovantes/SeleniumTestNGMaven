package pages;

public class MainPageLiverpool extends BasePage{
	
	public MainPageLiverpool(){
        super(driver);
    }

    public void navigateToLiverpool(){
        navigateTo("https://www.liverpool.com.mx/tienda/home");
    }
    
    public void moveToMouseOver(String element) {
    	findValidMove(element);
    }
    
    public String findElement(String element) {
    	return findValidElement(element);
    }
     
    public int findElements(String element) {
    	return findValidElements(element);
    }
    
    
    
    public void clickInsertEnter(String word,String element) {
    	//clickElement(searchBar);
    	write(word,element);	
    }
    
    public void clickElement(String element) {
    	clickElementBasePage(element);
    }
    
    
    
    

}

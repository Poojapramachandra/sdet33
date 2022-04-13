package SeleniumFrameworkWithTestNg;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.CreateProductPage;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreatingNewProduct;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;
import com.crm.autodesk.seleniumframework.ObjectRepository.ProductInfromation;

import GenericUtility.BaseClass;
@Listeners(GenericUtility.ListenersImplementaionClass.class)

public class CreateProductTest extends BaseClass {
	@Test
	public void CreatePro() throws Throwable{
		
		String productName=elib.getDataFromExcel("sheet1", 1, 6)+jlib.getRandomNumber();

		HomePage Homepage = new HomePage(driver);
		Homepage.Products();
		 
		CreateProductPage page = new CreateProductPage(driver);
		page.CreateProductIcon();
		Assert.fail();
		
		CreatingNewProduct createproduct = new CreatingNewProduct(driver);
		createproduct.ProductNameTextField(productName);
		
		
		ProductInfromation productInfo = new ProductInfromation(driver);
		String Actualresult = productInfo.productInformationLink();
		
		Assert.assertEquals(Actualresult.contains(productName), true);
		
	}

}

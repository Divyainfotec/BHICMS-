package com.bhicmspkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.LoggerHelper;

public class CompanyPage {
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptExecutor e ;
	Config con=new Config(pr);
	private final Logger logger=LoggerHelper.getLogger(CompanyPage.class);
	public CompanyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='Company']")public WebElement companyname;
	@FindBy(xpath="//*[@class='createcomp btn btn-primary']")public WebElement settingsaddcmpny;
	@FindBy(xpath="//input[@id='Company_name']")public WebElement companynme;
	@FindBy(xpath="//input[@id='Company_pincode']")public WebElement cmpnypincode;
	@FindBy(xpath="//input[@id='Company_phone']")public WebElement companyphone;
	@FindBy(xpath="//input[@id='Company_email_id']")public WebElement companyemailid;
	@FindBy(xpath="//input[@id='Company_company_gstnum']")public WebElement companygst;
	@FindBy(xpath="//input[@id='Company_company_tolerance']")public WebElement companytolerance;
	@FindBy(xpath="//input[@id='Company_subcontractor_limit']")public WebElement companysubcntrlimit;
	@FindBy(xpath="//input[@id='Company_company_popermission']")public WebElement compnypopermission;
	@FindBy(xpath="//input[@id='Company_purchase_amount']")public WebElement companypurchaseamnt;
	@FindBy(xpath="//input[@id='Company_expenses_email']")public WebElement compnyexpenseemail;
	@FindBy(xpath="//input[@id='Company_expenses_percentage']")public WebElement companyexpensepercentage;
	@FindBy(xpath="//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='divya']")public WebElement subcntremail;
	@FindBy(xpath="']")public WebElement subcntr2;
	@FindBy(xpath="//*[@id='Company_description']")public WebElement compnydescr;
	@FindBy(xpath="//*[@id='Company_address']")public WebElement compnyaddress;
	
	@FindBy(xpath="//*[@class='btn btn-info createcomp_btn']")public WebElement invoiceemailnot;
	@FindBy(xpath="//*[@class='btn btn-info createcomp_btn']")public WebElement compnycreatebtn;
	
	
	public void clickcompany()
	{
		this.companyname.click();
		logger.info("--------------user click company-------------------");
	}
	public void clickaddcompany() throws InterruptedException
	{
		WebElement elem=this.settingsaddcmpny;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		this.settingsaddcmpny.click();
		Thread.sleep(2000);
		logger.info("--------------user click add company-------------------");
	}
	public void typecompanynme(String cmpname)
	{
		
		this.companynme.sendKeys(cmpname);
		logger.info("-----------type company name---------------");
	}
	public void typecmpnypincode(String cmppincode)
	{
		this.cmpnypincode.sendKeys(cmppincode);
		logger.info("---------type company code----------------");
	}
	public void typecmpnyphone(String cmpphone)
	{
		this.companyphone.sendKeys(cmpphone);
		logger.info("---------type company phone----------------");
	}
	public void typecmpnyemail(String cmpnyemail)
	{
		this.companyemailid.sendKeys(cmpnyemail);
		logger.info("---------type company email----------------");
	}
	public void typecmpnyGSTno(String cmpnygstno)
	{
		this.companygst.sendKeys(cmpnygstno);
		logger.info("---------type company GST no----------------");
	}
	public void typecmpnytolerance(String cmpnytolerance)
	{
		this.companytolerance.sendKeys(cmpnytolerance);
		logger.info("---------type company tolerance----------------");
	}
	public void typesubcntrpaylmt(String subcntrpaylmt)
	{
		this.companysubcntrlimit.sendKeys(subcntrpaylmt);
		logger.info("---------type sub contractor payment limit----------------");
	}
	public void clickcmpnypopermission()
	{
		WebElement elem=this.compnypopermission;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		//this.compnypopermission.click();;
		logger.info("---------click PO Permission---------------");
	}
	public void typecmppurchseamnt(String cmppurchseamnt)
	{
		this.companysubcntrlimit.sendKeys(cmppurchseamnt);
		logger.info("---------type company purchase amount----------------");
	}
	public void clicksubcntremailnotification()
	{
	    //con=new Config(pr);
		//*[@id='Clients_company_id']//li//label[contains(text(),"BHICompany")]
		String subcntremailnot=con.Getcompanyusername();
		
		//-------------------------------------
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()="+subcntremailnot+"]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       //Checking whether first attempt to check the check box worked
		        
		        if (!chkbox.isSelected()) {
		        	chkbox.click();
		        }
		    }
		logger.info("-----------click subcontractor email notification user----------------");
	 
	}
	public void clickPOemailnotification()
	{
		 con=new Config(pr);
		//*[@id='Clients_company_id']//li//label[contains(text(),"BHICompany")]
		String poemailnot=con.Getcompanyusername();
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_po_email_userid']//li//label[text()=poemailnot]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       // Checking whether first attempt to check the check box worked
		       // if (!chkbox.isSelected()) {
		        	chkbox.click();
		       // }
		    }
		logger.info("-----------click user fro PO email notification ----------------");
	}
	public void typedescription(String cmpnydesc)
	{
		this.compnydescr.sendKeys(cmpnydesc);
		logger.info("------type company description-------------------");
	}
	public void typecmpnyaddress(String cmpnyaddr)
	{
		this.compnyaddress.sendKeys(cmpnyaddr);
		logger.info("------type company address-------------------");
	}
	public void clickinvoiceemailnot()
	{
		con=new Config(pr);
		String invoiceemailnot=con.Getcompanyusername();
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_invoice_email_userid']//li//label[text()=invoiceemailnot]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		         	chkbox.click();
		     
		    }
		logger.info("-----------click user fro PO email notification ----------------");
	}
	public void clickcmpnycreatebtn()
	{
		WebElement elem=this.compnycreatebtn;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		
		logger.info("------click company create button---------------");
	}
	public String getlastcmpnyname()
	 {
		 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 int cmpcnt=elem.size();
		 String companyname=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[2]")).getText();
		 return companyname;
	 }
}

package com.bhicmspkg.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GenericHelper {
private static final Logger log = LoggerHelper.getLogger(GenericHelper.class);
	
	public String readValueFromElement(WebElement element) {

		if (null == element){
			log.info("weblement is null");
			return null;
		}

		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			return null;
		}

		if (!displayed){
			return null;
		}
		String text = element.getText();
		log.info("weblement valus is.."+text);
		return text;
	}
	

	public String readValueFromInput(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		String value = element.getAttribute("value");
		log.info("weblement valus is.."+value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return true;
		} catch (Exception e) {
			log.info(e);
			Reporter.log(e.fillInStackTrace().toString());
			return false;
		}
	}
	
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return false;
		} catch (Exception e) {
			log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			return true;
		}
	}
	
	protected String getDisplayText(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		return element.getText();
	}
	

	public static synchronized String getElementText( WebElement element) {
		if (null == element) {
			log.info("weblement is null");
			return null;
		}
		String elementText = null;
		try {
			elementText = element.getText();
		} catch (Exception ex) {
			log.info("Element not found " + ex);
			Reporter.log(ex.fillInStackTrace().toString());
		}
		return elementText;
	}
	public void typevalueinsearch(WebElement elem,String value) 
	{
		elem.sendKeys(value);
		elem.sendKeys(Keys.ENTER);
	}
	//check whether attribute exist/not
		public boolean isAttribtuePresent(WebElement element, String attribute) {
		    Boolean result = false;
		    try {
		        String value = element.getAttribute(attribute);
		        if (value != null){
		            result = true;
		        }
		    } catch (Exception e) {}

		    return result;
		}
	
}

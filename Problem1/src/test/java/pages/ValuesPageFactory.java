package pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class ValuesPageFactory {
	
	WebDriver driver;
	ArrayList<Double> currencyVal = new ArrayList<Double>();
	double totalBal = 0;
	double sum = 0;
	
	@FindBy(xpath="//contains(@id,'lbl_val')")
	List<WebElement> values;
	
	@FindBy(xpath="//contains(@id,'txt_val')")
	List<WebElement> currecyValues;
	
	@FindBy(id="lbl_ttl_val")
	WebElement totalValue;
	
	@FindBy(id="txt_ttl_val")
	WebElement totalBalance;
	
	public ValuesPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void readingValues()
	{
		for(WebElement val: values)
		{
			currencyVal.add(Double.valueOf(val.getText().replace("$", "").replaceAll(",", "")));
		}
	}
	
	public void countValues()
	{
		int value = values.size();
		int currencyvalue = currecyValues.size();
		Assert.assertEquals(value, currencyvalue);
	}
	
	public void checkingValuesGreaterThanZero()
	{		
		for(Double curr : currencyVal)
		{
			if(curr > 0)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	}
	
	public void checkingTotalBalance()
	{
		totalBal = Double.valueOf(totalBalance.getText().replace("$", "").replaceAll(",", ""));
		for(Double curr : currencyVal)
		{
			sum += curr;
		}
		
		if(totalBal == sum)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public void checkingCurrencyFormatter()
	{
		for(int i=0;i<currencyVal.size();i++)
		{
			Locale usd = new Locale("en","US");
			NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(usd);
			if(currecyValues.get(i).equals(defaultFormat.format(currencyVal.get(i))))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	}
}

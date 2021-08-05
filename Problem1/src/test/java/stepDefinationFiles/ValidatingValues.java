package stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ValuesPageFactory;

public class ValidatingValues extends TestRunner {
	
	ValuesPageFactory values = new ValuesPageFactory(driver);
	
	@Given("Reading all the values in the screen")
	public void reading_all_the_values_in_the_screen() {
		
		values.readingValues();	    
	}

	@And("verify the right count of values appear on the screen")
	public void verify_the_right_count_of_values_appear_on_the_screen() {
		
		values.countValues();
	    
	}

	@And("verify the values on the screen are greater than zero")
	public void verify_the_values_on_the_screen_are_greater_than_zero() {
		
		values.checkingValuesGreaterThanZero();
	    
	}

	@And("verify the total balance is correct based on the values listed on the screen")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() {
	    
		values.checkingTotalBalance();
	}

	@And("verify the values are formatted as currencies")
	public void verify_the_values_are_formatted_as_currencies() {
		
		values.checkingCurrencyFormatter();
	    
	}

	@And("verify the total balance matches the sum of the values")
	public void verify_the_total_balance_matches_the_sum_of_the_values() {
		
		values.checkingTotalBalance();
	    
	}

}

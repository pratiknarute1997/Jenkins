package Parameterization;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utility.Excel;
import utility.UtilityClass;
import utility.Wait;

public class Lead 
{
	WebDriver driver;
	WebDriverWait w;
	SoftAssert a;
	Actions A;
	JavascriptExecutor j ;
	String modeOfInterest;
	
	public Lead(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		w = new  WebDriverWait(driver, Duration.ofSeconds(30));
		a = new SoftAssert();
		A = new Actions(driver);
		j =  (JavascriptExecutor)driver;
	}
	public void notConnected_Icon()
	{
		A.moveToElement(notConnected_Icon).click().build().perform();
	}
//===============================================================================================================================================================

	// Project dropdown
	@FindBy (xpath = "//mat-select[@formcontrolname='project_id']") private WebElement projectDropdown;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-One 104')]") private WebElement ProjectDropdown_AutomationProject1;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-Two 104')]") private WebElement ProjectDropdown_AutomationProject2;
//===============================================================================================================================================================

	// Area of interest
	@FindBy (xpath = "//mat-select[@formcontrolname='area_of_interest']") private WebElement areaOfInterest;
	@FindBy (xpath = "//mat-option//span[contains(text(), 'Automation 1BHK property 104')]") private WebElement areaOfInterest_Automation_1BHK_Property;
	@FindBy (xpath = "//mat-option//span[contains(text(), 'Automation 2BHK property 104')]") private WebElement areaOfInterest_Automation_2BHK_Property;
//===============================================================================================================================================================

	//Lead Source
	@FindBy (xpath = "//mat-select[@formcontrolname='lead_source']") private WebElement leadSource_Dropdown;
	@FindBy (xpath = "//span [contains (text(),'Automation_Reference 104' )]") private WebElement leadSource_Dropdown_Automation_Reference;
//	@FindBy (xpath = "(//span [contains (text(),'Automation_Reference' )])") private WebElement leadSource_Dropdown_Walkin;
//	@FindBy (xpath = "(//span [contains (text(),'Automation_Reference' )])") private WebElement leadSource_Dropdown_PrintMedia;
	@FindBy (xpath = "(//span [contains (text(),'Automation_Direct' )])") private WebElement leadSource_Dropdown_Direct;
//	@FindBy (xpath = "(//span [contains (text(),'Automation_Reference' )])") private WebElement leadSource_Dropdown_Others;
//===============================================================================================================================================================

	//pofession dropdown list
	@FindBy (xpath = "//mat-option//span [contains (text(),'AutomationProfession Doctor' )]") private WebElement professionDropdown_Doctor;
//===============================================================================================================================================================

	//Mobile no  start with 104
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForHotCategory;
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForWarmCategory;
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForColdCategory;
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForNotInterested;
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForNotConnected;
	@FindBy (xpath = "//tbody//a[contains(text(), '104')]") private WebElement phoneNoForNotMatched;
//===============================================================================================================================================================

	//edit lead of hot lead start with 104
	@FindBy (xpath = "//tbody//a[contains(text(),'104')] / parent :: td / following-sibling :: td //div //button")private WebElement editButton_HotLead;
//===============================================================================================================================================================

//===============================================================================================================================================================
	@FindBy (xpath = "//div[text()=' Leads ']") private WebElement leadsIcon;	
	@FindBy (xpath = "//a[text()='Active Leads'] / parent :: li") private WebElement activeLeadIcon;
	@FindBy (xpath = "//a[text()=' A+(Hot) ']") private WebElement AHot_Icon;
	@FindBy (xpath = "//a[text()=' A(Warm) ']") private WebElement AWarm_Icon;
	@FindBy (xpath = "//a[text()=' B+(Cold) ']") private WebElement BCold_Icon;
	@FindBy (xpath = "//a[@href='/lead/lead?todayfollowup=2023-01-27']") private WebElement todaysFollowUp_Icon;
	@FindBy (xpath = "//a[text()=' Not Connected ']") private WebElement notConnected_Icon;
	
	@FindBy (xpath = "//a[text()='Deactive Leads']") private WebElement deactiveLead_Icon;
	@FindBy (xpath = "//a[text()=' Deactive By Employee ']") private WebElement deactiveByEmployee_Icon;
	@FindBy (xpath = "//a[text()=' Not Interested ']") private WebElement notInterested_Icon;
	@FindBy (xpath = "//a[text()=' Not Match ']")private WebElement NotMatch_Icon;
	
	@FindBy (xpath = "//a[text()='Booked Leads']") private WebElement bookedLead_Icon;
	@FindBy (xpath = "//a[text()='PreBooking Pending']") private WebElement prebookingPending_Icon;
	
	@FindBy (xpath = "//button[text()=' New Lead ']") private WebElement newLeadButton;

	
	@FindBy (xpath = "//mat-panel-title[text()=' Add More Details '] / parent :: span")private WebElement addMoreDetails_Box;
	@FindBy (xpath = "//input[@formcontrolname='cre_user_name']") private WebElement assignUserName;
	@FindBy (xpath = "//span[contains(text(), 'self(Logged In)')]") private WebElement selfAssignedCheckbox;
	@FindBy (xpath = "//button[@class='mat-focus-indicator mat-button mat-button-base ng-star-inserted']") private WebElement submitButton_PopUp;
	
	@FindBy (xpath = "//input[@formcontrolname='temp_name']") private WebElement name;
	@FindBy (xpath = "//input[@formcontrolname='phone']") private  WebElement phone;
	@FindBy (xpath = "//input[@formcontrolname='alternate_contact_no']") private WebElement alternatePhone;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='contactability']") private WebElement contactabilityDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Conversation ']") private WebElement contactabilityDropdown_Conversion;
	@FindBy (xpath = "//mat-option//span[text()='Not Connected']") private WebElement contactabilityDropdown_NotConnected;
	@FindBy (xpath = "//mat-option//span[text()='Not Matched']") private WebElement contactabilityDropdown_NotMatched;
	
	@FindBy (xpath = "//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input") private WebElement modeOfInterestCheckbox;
	@FindBy (xpath = "//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input /parent :: span / parent :: label / parent :: mat-checkbox")private WebElement selectModeOfInterestCheckbox;
	@FindBy (xpath = "//mat-option//span[text()='Interested']") private WebElement modeOfInterestDropdown_Interested;
	@FindBy (xpath = "//mat-option//span[text()='Not Interested']") private WebElement modeOfInterestDropdown_NotInterested;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='profession_id']") private WebElement professionDropdown;
	@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //input[@formcontrolname='name']")private WebElement professionName;
	@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //textarea[@formcontrolname='description']")private WebElement professionDescription;
	@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div  //mat-icon[text()='close']")WebElement professionCloseIcon;
	@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //button[text()=' Submit ']")private WebElement professionSubmitButton;
	
	@FindBy (xpath = "//mat-icon[text()='add_circle']") private WebElement addProfessionIcon;
	@FindBy (xpath = "//textarea[@formcontrolname='address']") private WebElement address;
	@FindBy (xpath = "//input[@formcontrolname='postal_code']") private WebElement pinCode;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='area']") private WebElement areaDropdown;
	@FindBy (xpath = "//mat-option//span[text()=' K.V.Nagar Barshi S.O ']") private WebElement areaDropdown_KV_Nagar;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='city']") private WebElement cityDropdown;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='living_mode']") private WebElement livingModeDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Own House']") private WebElement livingModeDropdown_OwnHouse;
	@FindBy (xpath = "//mat-option//span[text()='Rented']") private WebElement livingModeDropdown_Rented;
	@FindBy (xpath = "//mat-option//span[text()='Family Property']") private WebElement livingModeDropdown_FamilyProperty;

	@FindBy (xpath = "//mat-select[@formcontrolname='status']") private WebElement statusDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Lead ']") private WebElement statusDropdown_Lead;
	@FindBy (xpath = "//mat-option//span[text()='Call ']") private WebElement statusDropdown_Call;
	@FindBy (xpath = "//mat-option//span[text()='Meet ']") private WebElement statusDropdown_Meet;
	@FindBy (xpath = "//mat-option//span[text()='Visit ']") private WebElement statusDropdown_Visit;
	

	
	@FindBy (xpath = "//mat-select[@formcontrolname='buying_purpose']") private WebElement buyingPurposeDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Personal']") private WebElement buyingPurposeDropdown_Personal;
	@FindBy (xpath = "//mat-option//span[text()='Investment']") private WebElement buyingPurposeDropdown_Investment;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='required_plot_size']") private WebElement plotSizeDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Below 600 sqft']") private WebElement plotSizeDropdown_Below_600_sqft;
	@FindBy (xpath = "//mat-option//span[text()='600-800 sqft']") private WebElement plotSizeDropdown_600_800_sqft;
	@FindBy (xpath = "//mat-option//span[text()='800-1000 sqft']") private WebElement plotSizeDropdown_800_1000_sqft;
	@FindBy (xpath = "//mat-option//span[text()='1000-1250 sqft']") private WebElement plotSizeDropdown_1000_1200_sqft;
	@FindBy (xpath = "//mat-option//span[text()='1250-1500 sqft']") private WebElement plotSizeDropdown_1250_1500_sqft;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='budget']") private WebElement budgetDropdown;
	@FindBy (xpath = "//mat-option//span[text()='under 5 lakh']") private WebElement budgetDropdown_Under_5_Lakh;
	@FindBy (xpath = "//mat-option//span[text()='5-7 lakh']") private WebElement budgetDropdown_5_7_Lakh;
	@FindBy (xpath = "//mat-option//span[text()='7-10 lakh']") private WebElement budgetDropdown_7_10_Lakh;
	@FindBy (xpath = "//mat-option//span[text()='10-12 lakh']") private WebElement budgetDropdown_10_12_Lakh;
	@FindBy (xpath = "//mat-option//span[text()='12-15 lakh']") private WebElement budgetDropdown_12_15_Lakh;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='category']") private WebElement categoryDropdown;
	@FindBy (xpath = "//mat-option//*[text()='A+(Hot)']") private WebElement category_Hot_A;
	@FindBy (xpath = "//mat-option//*[text()='A(Warm)']") private WebElement category_warm_A;
	@FindBy (xpath = "//mat-option//*[text()='B+(Cold)']") private WebElement category_cold_B;
	
	@FindBy (xpath = "//input[@formcontrolname='follow_up_date']") private WebElement Calender_follow_up_date;
	@FindBy (xpath = "//span[contains(text(), '2023')] / parent :: span / parent :: button") private WebElement calenderButton;
	@FindBy (xpath = "//table//div[text()=' 2023 ']") private WebElement calender_Year_2023;
	@FindBy (xpath = "//table//div[text()=' FEB ']") private WebElement calender_Month_FEB;
	@FindBy (xpath = "//table//div[text()=' MAR ']") private WebElement calender_Month_MAR;
	@FindBy (xpath = "//table//div[text()=' 28 ']") private WebElement calender_Date_28;
	

		
	@FindBy (xpath = "//textarea[@formcontrolname='remark']") private WebElement remark;
	@FindBy (xpath = "//button//span[text()=' Submit ']") private WebElement submitButton;
	@FindBy (xpath = "//span[text()=' Update '] / parent :: button")private WebElement updateButton;





    @FindBy (xpath = "//mat-panel-title)[1]") private WebElement companyData_Box;
	@FindBy (xpath = "(//mat-expansion-panel-header)[2]") private WebElement leadPersonalData_Box;
	@FindBy (xpath = "(//mat-panel-title)[3]") private WebElement leadRequirement_Box;
	
	@FindBy (xpath = "//div[text()=' Message: Profession Already Exists. ']")private WebElement errorMessage_DuplicateProfession;
	
	

	public void createLeadProfession() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000); A.moveToElement(leadsIcon).click(leadsIcon).build().perform();
		Thread.sleep(2000);A.moveToElement(activeLeadIcon).click().build().perform();
		Thread.sleep(2000);j.executeScript("window.scrollBy(1000,-1000)", "");
		Thread.sleep(2000); newLeadButton.click();
		Wait.explicitWait(addMoreDetails_Box, 10, driver);
		addMoreDetails_Box.click();
		addProfessionIcon.click();
		professionName.sendKeys(Excel.importDataFromExcel("Leads", 2, 11));
		professionDescription.sendKeys(Excel.importDataFromExcel("Leads", 2, 12));
		professionSubmitButton.click();
	}
	
	public void createLeads() throws InterruptedException, EncryptedDocumentException, IOException
	{	
		Thread.sleep(3000); A.moveToElement(leadsIcon).click().build().perform();
		Thread.sleep(1000);A.moveToElement(activeLeadIcon).click().build().perform();
		Thread.sleep(2000);j.executeScript("window.scrollBy(1000,-1000)", "");
		
		for (int lead=1; lead<=18; lead++)
		{
			System.out.println("Start to create lead: ("+Excel.importDataFromExcel("leads", lead, 0)+") under "+Excel.importDataFromExcel("leads", lead, 3));
			Thread.sleep(2000);driver.navigate().refresh();
			Thread.sleep(1000); j.executeScript("window.scrollBy(1000,-1000)", "");
			Thread.sleep(2000); newLeadButton.click();
			Wait.explicitWait(projectDropdown, 10, driver);
			projectDropdown.click(); 
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'"+Excel.importDataFromExcel("Leads", lead, 3)+"')]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(), '"+Excel.importDataFromExcel("Leads", lead, 4)+"')]")).click();
			submitButton_PopUp.click();
			
			name.sendKeys(Excel.importDataFromExcel("leads", lead, 0));
			phone.sendKeys(UtilityClass.getRandomIntegers(8));
			
			contactabilityDropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'"+Excel.importDataFromExcel("Leads", lead, 5)+"')]")).click();
			
			if (Excel.importDataFromExcel("Leads", lead, 5).contains("Conversation"))
			{
				this.modeOfInterest=Excel.importDataFromExcel("Leads", lead, 6);
				if (this.modeOfInterest.contentEquals("Interested"))
				{
					selectModeOfInterestCheckbox.click();
					
					categoryDropdown.click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//mat-option//span[contains(text(), '"+Excel.importDataFromExcel("Leads", lead, 7)+"')]")).click();
					
					Calender_follow_up_date.click();
					calenderButton.click();
					utility.Calender.CustomizeCalenderYear(driver, "2024");
					utility.Calender.CustomizeCalenderMonth(driver, "SEP");
					utility.Calender.CustomizeCalenderDay(driver, "30");
					
					remark.sendKeys(UtilityClass.getRandomString(25));
					
					Thread.sleep(2000); j.executeScript("window.scrollBy(1000,1000)", "");
					Thread.sleep(2000); alternatePhone.sendKeys(UtilityClass.getRandomIntegers(8));	
							
					professionDropdown.click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//mat-option//span[contains(text(), '"+Excel.importDataFromExcel("Leads", lead, 11)+"')]")).click();
					
					Wait.explicitWait(plotSizeDropdown, 10, driver);
					plotSizeDropdown.click();
					Thread.sleep(1000); 
					List<WebElement> listElements=driver.findElements(By.xpath("//mat-option//span"));
					Random random = new Random();
					int randomNumber=random.nextInt(listElements.size()-1);
					listElements.get(randomNumber+1).click();
					listElements.clear();
					
					Wait.explicitWait(budgetDropdown, 10, driver);
					budgetDropdown.click();
					Thread.sleep(1000);
					listElements=driver.findElements(By.xpath("//mat-option//span"));
				    randomNumber=random.nextInt(listElements.size()-1);
					listElements.get(randomNumber+1).click();
					listElements.clear();
					
					leadSource_Dropdown.click();
					Thread.sleep(1000);
					listElements=driver.findElements(By.xpath("//mat-option//span"));
				    randomNumber=random.nextInt(listElements.size()-1);
					WebElement list_LeadSource=listElements.get(randomNumber+1);
					Wait.explicitWait(list_LeadSource, 10, driver);
					list_LeadSource.click();
					listElements.clear();
					
					Wait.explicitWait(livingModeDropdown, 10, driver);
					livingModeDropdown.click(); 
					Thread.sleep(1000); 
					listElements=driver.findElements(By.xpath("//mat-option//span"));
				    randomNumber=random.nextInt(listElements.size()-1);
					listElements.get(randomNumber+1).click();
					listElements.clear();
					
					areaOfInterest.click();
					Thread.sleep(1000);
					listElements=driver.findElements(By.xpath("//mat-option//span"));
				    randomNumber=random.nextInt(listElements.size()-1);
					WebElement AreaInterest=listElements.get(randomNumber);
					Wait.explicitWait(AreaInterest, 10, driver);
					A.scrollToElement(AreaInterest).moveToElement(AreaInterest).click(AreaInterest).build().perform();
					listElements.clear();
					
					Wait.explicitWait(leadSource_Dropdown, 10, driver);
					A.moveToElement(leadSource_Dropdown).click().build().perform();
					
					pinCode.sendKeys("413411");	
					address.sendKeys(Excel.importDataFromExcel("Leads", lead, 18));
					
					areaDropdown.click();
					Thread.sleep(1000);	areaDropdown_KV_Nagar.click();	
						
				}	
			}
						
			j.executeScript("arguments[0].scrollIntoView(true)", submitButton);
			submitButton.click();
			a.assertAll();
			System.out.println("==========================================================================");			
						
		}
	}
}

	
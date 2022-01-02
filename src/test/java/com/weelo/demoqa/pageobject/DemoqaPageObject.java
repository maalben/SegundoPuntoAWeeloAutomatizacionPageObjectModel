package com.weelo.demoqa.pageobject;

import com.weelo.demoqa.models.RegisterDataModels;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static com.weelo.demoqa.utilities.Utilities.*;

@DefaultUrl("https://demoqa.com/automation-practice-form")
public class DemoqaPageObject extends PageObject {

    WebDriverWait wait;

    @FindBy(id = "firstName")
    public WebElementFacade firstName;

    @FindBy(id = "lastName")
    public WebElementFacade lastName;

    @FindBy(id = "userEmail")
    public WebElementFacade userEmail;

    @FindBy(xpath = "//div[@id='genterWrapper']/div[2]/div")
    public List<WebElement> listGender;

    @FindBy(id = "userNumber")
    public WebElementFacade userNumber;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']")
    public WebElementFacade txtCalendar;

    @FindBy(id = "uploadPicture")
    public WebElementFacade uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElementFacade currentAddressUser;

    @FindBy(id = "submit")
    public WebElementFacade submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElementFacade titlePageValidation;

    public void sendFirstName(String name){
        firstName.sendKeys(name);
    }

    public void sendLastName(String last) {
        lastName.sendKeys(last);
    }

    public void sendEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void chooseGender(String gender) {
        selectRadio(listGender, gender);
    }

    public void sendMobileNumber(String mobileNumber) {
        userNumber.sendKeys(mobileNumber);
    }

    public void chooseDateBirth(String dateBirth) {
        txtCalendar.click();
        selectDate(this.getDriver(), dateBirth);
    }

    public void sendSubjects(String subjects) {
        selectSubjects(this.getDriver().findElement(By.id("subjectsInput")), subjects);
    }

    public void chooseHobbies(String hobbies) {
        selectCheckBox(this.getDriver(), hobbies, ",", "//div[@id='hobbiesWrapper']/div[2]/div");
    }

    public void choosePicture(String file) {
        final String filePath = "/src/test/resources/image/"+file;
        selectFile(uploadPicture, filePath);
    }

    public void sendCurrentAddress(String currentAddress) {
        currentAddressUser.sendKeys(currentAddress);
    }

    public void chooseState(String state) {
        selectElementList(this.getDriver(), "react-select-3-input", state);
    }

    public void chooseCity(String city) {
        selectElementList(this.getDriver(), "react-select-4-input", city);
    }

    public void validateMessageSuccess(String expected) {
        assertEquals(expected, titlePageValidation.getText());
    }

    public void validateDataConfirmation(List<RegisterDataModels> data) {
        String relativeRute = "//div[@class='modal-content']//table/tbody";
        assertEquals(data.get(0).getFirstName() + " " + data.get(0).getLastName(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[1]/td[2]")).getText());
        assertEquals(data.get(0).getEmail(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[2]/td[2]")).getText());
        assertEquals(data.get(0).getGender(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[3]/td[2]")).getText());
        assertEquals(data.get(0).getMobileNumber(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[4]/td[2]")).getText());
        assertEquals(dateValidation(data.get(0).getDateBirth()),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[5]/td[2]")).getText());
        assertEquals(data.get(0).getSubjects(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[6]/td[2]")).getText());
        assertEquals(data.get(0).getHobbies(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[7]/td[2]")).getText());
        assertEquals(data.get(0).getFile(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[8]/td[2]")).getText());
        assertEquals(data.get(0).getCurrentAddress(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[9]/td[2]")).getText());
        assertEquals(data.get(0).getState() + " " + data.get(0).getCity(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[10]/td[2]")).getText());
    }

    public void confirmSendForm() {
        submit.click();
    }

    public void verifyFieldRequired(List<RegisterDataModels> data) {
        String relativeRute = "//div[@class='modal-content']//table/tbody";
        assertEquals(data.get(0).getFirstName() + " " + data.get(0).getLastName(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[1]/td[2]")).getText());
        assertEquals(data.get(0).getGender(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[3]/td[2]")).getText());
        assertEquals(data.get(0).getMobileNumber(),
                this.getDriver().findElement(By.xpath(relativeRute+"/tr[4]/td[2]")).getText());
    }

    public void upPage() {
        moveScreen(this.getDriver(), "up");
    }

    public void verifyFieldsRequiredBorderRed(String borderColor) {
        wait = new WebDriverWait(this.getDriver(), 30);
        waitOwn(1);
        assertEquals(borderColor, firstName.getCssValue("border-top-color"));
        assertEquals(borderColor, lastName.getCssValue("border-top-color"));
        assertEquals(borderColor, this.getDriver().findElement(By.xpath("//label[@for='gender-radio-1']")).getCssValue("color"));
        assertEquals(borderColor, this.getDriver().findElement(By.xpath("//label[@for='gender-radio-2']")).getCssValue("color"));
        assertEquals(borderColor, this.getDriver().findElement(By.xpath("//label[@for='gender-radio-3']")).getCssValue("color"));
        assertEquals(borderColor, userNumber.getCssValue("border-top-color"));
    }

    public void downPage() {
        moveScreen(this.getDriver(), "down");
    }
}
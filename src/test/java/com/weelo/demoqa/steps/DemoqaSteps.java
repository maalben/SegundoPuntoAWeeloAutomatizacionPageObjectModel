package com.weelo.demoqa.steps;

import com.weelo.demoqa.models.RegisterDataModels;
import com.weelo.demoqa.pageobject.DemoqaPageObject;
import net.thucydides.core.annotations.Step;
import java.util.List;

public class DemoqaSteps {

    DemoqaPageObject demoqaPageObject;
    private List<RegisterDataModels> data;

    @Step
    public void openBrowser(){
        demoqaPageObject.open();
    }

    @Step
    public void dataLoad(List<RegisterDataModels> data){
        this.data = data;
    }

    @Step
    public void writeName() {
        demoqaPageObject.sendFirstName(data.get(0).getFirstName());
    }

    @Step
    public void writeLastName() {
        demoqaPageObject.sendLastName(data.get(0).getLastName());
    }

    @Step
    public void writeEmail() {
        demoqaPageObject.sendEmail(data.get(0).getEmail());
    }

    @Step
    public void genderSelect() {
        demoqaPageObject.chooseGender(data.get(0).getGender());
    }

    @Step
    public void writeMobileNumber() {
        demoqaPageObject.sendMobileNumber(data.get(0).getMobileNumber());
    }

    @Step
    public void DateBirthSelect() {
        demoqaPageObject.chooseDateBirth(data.get(0).getDateBirth());
    }

    @Step
    public void writeSubject() {
        demoqaPageObject.sendSubjects(data.get(0).getSubjects());
    }

    @Step
    public void hobbiesSelect() {
        demoqaPageObject.chooseHobbies(data.get(0).getHobbies());
    }

    @Step
    public void pictureSelect() {
        demoqaPageObject.choosePicture(data.get(0).getFile());
    }

    @Step
    public void writeCurrentAddress() {
        demoqaPageObject.sendCurrentAddress(data.get(0).getCurrentAddress());
    }

    @Step
    public void stateSelect() {
        demoqaPageObject.chooseState(data.get(0).getState());
    }

    @Step
    public void citySelect() {
        demoqaPageObject.chooseCity(data.get(0).getCity());
    }

    @Step
    public void getMessageValidation() {
        demoqaPageObject.validateMessageSuccess(data.get(0).getExpected());
    }

    @Step
    public void validationValuesScreenConfirmation() {
        demoqaPageObject.validateDataConfirmation(data);
    }

    @Step
    public void pressButtonConfirmation() {
        demoqaPageObject.confirmSendForm();
    }

    @Step
    public void verificationFieldsRequired() {
        demoqaPageObject.verifyFieldRequired(data);
    }

    @Step
    public void movePageUp() {
        demoqaPageObject.upPage();
    }

    @Step
    public void verifyNoSendForm() {
        demoqaPageObject.verifyFieldsRequiredBorderRed(data.get(0).getExpected());
    }

    @Step
    public void movePageDown() {
        demoqaPageObject.downPage();
    }
}
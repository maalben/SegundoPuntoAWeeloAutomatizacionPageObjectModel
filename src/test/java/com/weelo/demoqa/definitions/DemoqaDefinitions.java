package com.weelo.demoqa.definitions;

import com.weelo.demoqa.models.RegisterDataModels;
import com.weelo.demoqa.steps.DemoqaSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class DemoqaDefinitions {

    @Steps
    public DemoqaSteps start;

    @Given("Yo Ingreso a la plataforma de registro estudiante demoqa")
    public void yoIngresoALaPlataformaDeRegistroEstudianteDemoqa() {
        start.openBrowser();
    }

    @Given("Yo cargo los datos para la prueba")
    public void yoCargoLosDatosParaLaPrueba(List<RegisterDataModels> data) {
        start.dataLoad(data);
    }

    @When("^Yo ingreso el nombre$")
    public void yoIngresoElNombre() {
        start.writeName();
    }


    @When("^Yo ingreso el apellido$")
    public void yoIngresoElApellido() {
        start.writeLastName();
    }

    @When("^Yo ingreso el email$")
    public void yoIngresoElEmail() {
        start.writeEmail();
    }

    @When("^Yo escojo el genero$")
    public void yoEscojoElGenero() {
        start.genderSelect();
    }

    @When("^Yo ingreso el numero de celular$")
    public void yoIngresoElNumeroDeCelular() {
        start.writeMobileNumber();
    }

    @When("^Yo selecciono la fecha de nacimiento$")
    public void yoSeleccionoLaFechaDeNacimiento() {
        start.DateBirthSelect();
    }

    @When("^Yo ingreso el o los asuntos$")
    public void yoIngresoElOLosAsuntos() {
        start.writeSubject();
    }

    @When("^Yo selecciono el o los hobbies$")
    public void yoSeleccionoElOLosHobbies() {
        start.hobbiesSelect();
    }

    @When("^Yo selecciono una foto$")
    public void yoSeleccionoUnaFoto() {
        start.pictureSelect();
    }

    @When("^Yo ingreso la direccion actual$")
    public void yoIngresoLaDireccionActual() {
        start.writeCurrentAddress();
    }

    @When("^Yo selecciono el estado$")
    public void yoSeleccionoElEstado() {
        start.stateSelect();
    }

    @When("^Yo selecciono la ciudad$")
    public void yoSeleccionoLaCiudad() {
        start.citySelect();
    }

    @Then("^Yo verifico que se muestre el mensaje esperado$")
    public void yoVerificoQueSeMuestreElMensajeEsperado() {
        start.getMessageValidation();
    }

    @Then("^Yo verifico los datos en la ventana de confirmacion$")
    public void yoVerificoLosDatosEnLaVentanaDeConfirmacion() {
        start.validationValuesScreenConfirmation();
    }

    @When("^Yo  presiono el boton de submit$")
    public void yoPresionoElBotonDeSubmit() {
        start.pressButtonConfirmation();
    }

    @Then("^Yo verifico los datos obligatorios en la ventana de confirmacion$")
    public void yoVerificoLosDatosObligatoriosEnLaVentanaDeConfirmacion() {
        start.verificationFieldsRequired();
    }

    @Given("^Yo muevo la pagina hacia abajo$")
    public void yoMuevoLaPaginaHaciaAbajo() {
        start.movePageUp();
    }

    @Given("^Yo muevo la pagina hacia arriba$")
    public void yoMuevoLaPaginaHaciaArriba() {
        start.movePageDown();
    }

    @Then("^Yo deberia ver que se muestren los campos obligatorios de color rojo$")
    public void yoDeberiaVerQueSeMuestrenLosCamposObligatoriosDeColorRojo() {
        start.verifyNoSendForm();
    }

}

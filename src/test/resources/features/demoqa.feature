Feature: Formulario de registro de estudiante en demoqa.com

  Description:
  Yo como automatizador de pruebas
  Necesito automatizar el flujo de registro de estudiante
  Para validar funcionalidad exitosa

  Background:
    Given Yo Ingreso a la plataforma de registro estudiante demoqa


  @CP001
  Scenario Outline: Validar diligenciamiento exitoso de campos del formulario
    And Yo cargo los datos para la prueba
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      | <firstName>  | <lastName>  | <email>  |   <gender>  | <mobileNumber>  | <dateBirth> | <subjects>  |<hobbies>| <file>  |<currentAddress>  | <state> |  <city> |   <expected>  |
    When Yo ingreso el nombre
    And Yo ingreso el apellido
    And Yo ingreso el email
    And Yo escojo el genero
    And Yo ingreso el numero de celular
    And Yo muevo la pagina hacia abajo
    And Yo selecciono la fecha de nacimiento
    And Yo ingreso el o los asuntos
    And Yo selecciono el o los hobbies
    And Yo selecciono una foto
    And Yo ingreso la direccion actual
    And Yo selecciono el estado
    And Yo selecciono la ciudad
    And Yo  presiono el boton de submit
    Then Yo verifico que se muestre el mensaje esperado

    Examples:
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|


  @CP002
  Scenario Outline: Validar diligenciamiento exitoso de formulario y datos en ventana de confirmacion
    And Yo cargo los datos para la prueba
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      | <firstName>  | <lastName>  | <email>  |   <gender>  | <mobileNumber>  | <dateBirth> | <subjects>  |<hobbies>| <file>  |<currentAddress>  | <state> |  <city> |   <expected>  |
    When Yo ingreso el nombre
    And Yo ingreso el apellido
    And Yo ingreso el email
    And Yo escojo el genero
    And Yo ingreso el numero de celular
    And Yo muevo la pagina hacia abajo
    And Yo selecciono la fecha de nacimiento
    And Yo ingreso el o los asuntos
    And Yo selecciono el o los hobbies
    And Yo selecciono una foto
    And Yo ingreso la direccion actual
    And Yo selecciono el estado
    And Yo selecciono la ciudad
    And Yo  presiono el boton de submit
    Then Yo verifico que se muestre el mensaje esperado
    And Yo verifico los datos en la ventana de confirmacion

    Examples:
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|


  @CP003
  Scenario Outline: Validar diligenciamiento exitoso de formulario completar campos obligatorios
    And Yo cargo los datos para la prueba
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      | <firstName>  | <lastName>  | <email>  |   <gender>  | <mobileNumber>  | <dateBirth> | <subjects>  |<hobbies>| <file>  |<currentAddress>  | <state> |  <city> |   <expected>  |
    When Yo ingreso el nombre
    And Yo ingreso el apellido
    And Yo escojo el genero
    And Yo ingreso el numero de celular
    And Yo muevo la pagina hacia abajo
    And Yo  presiono el boton de submit
    Then Yo verifico que se muestre el mensaje esperado
    And Yo verifico los datos obligatorios en la ventana de confirmacion

    Examples:
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |Thanks for submitting the form|


  @CP004
  Scenario Outline: Validar diligenciamiento de formulario si falta completar campos obligatorios
    And Yo cargo los datos para la prueba
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      | <firstName>  | <lastName>  | <email>  |   <gender>  | <mobileNumber>  | <dateBirth> | <subjects>  |<hobbies>| <file>  |<currentAddress>  | <state> |  <city> |   <expected>  |
    And Yo ingreso el email
    And Yo muevo la pagina hacia abajo
    And Yo selecciono la fecha de nacimiento
    And Yo ingreso el o los asuntos
    And Yo selecciono el o los hobbies
    And Yo selecciono una foto
    And Yo ingreso la direccion actual
    And Yo selecciono el estado
    And Yo selecciono la ciudad
    And Yo  presiono el boton de submit
    And Yo muevo la pagina hacia arriba
    Then Yo deberia ver que se muestren los campos obligatorios de color rojo

    Examples:
      | firstName  | lastName  | email  |   gender  | mobileNumber  | dateBirth | subjects  | hobbies | file|currentAddress  | state |  city |   expected  |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@2
   |Pedro   |Pablo   |pedro@correo.com   |Male   |3121234567   |30-04-2010   |Physics, Maths, Hindi   |Sports, Music   |original.png   |Calle 32 #12-12 Las Brisas – Medellin   |Haryana   |Karnal   |rgba(220, 53, 69, 1)|

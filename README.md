## Simple HTTP Service (M13)

<p align="right">
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/spring-long.svg" title="spring-long" alt="spring-long" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/java.svg" title="java" alt="java" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/mysql.svg" title="mysql" alt="mysql" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/javascript.svg" title="javascript" alt="javascript" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/jquery.svg" title="jquery" alt="jquery" height="30px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/html-5.svg" title="html-5" alt="html-5" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/css-3.svg" title="css-3" alt="css-3" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/bootstrap.svg" title="bootstrap" alt="bootstrap" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/datatables.png" title="mysql" alt="mysql" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/postman.svg" title="postman" alt="postman" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/eclipse.svg" title="eclipse" alt="eclipse" height="35px"/>
  <img src="https://github.com/GerardPuigl/TechnologyStackIcons/blob/main/Logos/visual-studio-code.svg" title="visual-studio-code" alt="visual-studio-code" height="35px"/>
</p>

## Introduction

Backend of Rest API CRUD with H2 Persistence Database. Developed with Spring boot and applying design pattern MVC.

Frontend with Javascript & Jquery to consume & send Jsons to the Rest API and HTML, CSS with libraries Bootstrap & Datatables to show & interact with the user.


link: https://employee-it.herokuapp.com/


<p align="center">

  <img src="https://github.com/gerardpuigl/M13-Spring-REST-HTTP-Service-Client-JavaScript-Jquery/blob/main/screenshots/M13-Employee%20CRUD%20HTTP%20SERVICE.jpg" title="CRUD employeesScreenshot" alt="CRUD employees" />

</p>

## Exercise Description [in Catalan]

Exercici per aprofundir en peticions HTTP (GET, POST, PUT DELETE). Projecte realitzat amb Spring i amb patró MVC aplicat.

### - Nivell 1 - (Rest API Spring)

Realització d'una Rest API per fer peticions HTTP amb un CRUD (Create, Read, Update, Delete) al complet. Per això s'ha implementat un patró d'arquitectura MVC amb repositori en memòria.

S'ha utilitzat Spring (Java) construït amb Maven amb les implementacions:
- Spring Boot DevTools.
- Spring Web.
- Thymeleaf
- Spring Data JPA.

Crearem un programa de gestió d'empleats on depenent de la feina de l'empleat se li assignarà un salari automàticament. D'un treballador identifiquem el nom i la seva feina, estaria bé tenir un identificador únic per aquest treballador. Les feines són fixes, és a dir ja estan definits en un ENUMERABLE. Depenent de la feina s'assignarà un salari a l'empleat un cop es crea.

Comprovació de peticions amb Postman. 

### - Nivell 2 - (Estructura HTTP i lògica JavaScript)

Creació d'una web amb http/javascript/ajax per crear un formulari per poder provar les crides API de la Rest API anterior.
La web ha de poder fer el CRUD complet (Create, Read, Update, Delete) 

S'ha realitat la maqueta:
- Maqueta en HTML de la web. 
- Creació del JavaScript e importa'l al índex.html. 
- Importació de jQuery per poder fer les crides API.
- Creació funcions de JavaScript per fer les crides API. 
- No cal que sigui visualment atractiu. Només ha de ser funcional. 


### - Nivell 3 - (Disseny web amb CSS, Bootstrap i DataTable)

Realització del disseny estètic de la web mitjançant CSS, Bootstrap. S'ha implementat la llibreria DataTables per poder afegir funcionalitats a la taula d'empleats.

Implementació de base de dades persistent MySQL i creació de dos perfils de propietats per alternar entre MySQL i H2 (BD en memòria)


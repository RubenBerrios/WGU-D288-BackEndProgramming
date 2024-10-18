# D288 - Backend Programming

## Introduction
This application was built for the purpose of final coursework for the D288 backend programming class at Western Governor's University. For this application, I was tasked to create an entire backend database.
### Scenario
A travel agency has recently launched a complete overhaul of their front-end vacation bookings application using Angular and JavaScript. Lately, the front-end engineers have encountered various undocumented bugs when sending requests and fetching data from the back-end. Since the back-end was built in the early 1990s and the original developer has since retired and can no longer help troubleshoot, the existing team is concerned about the growing tech debt and lack of ongoing support. Your chief technology officer (CTO) decided to create a project to port over any mission-critical functionalities to a modern framework and has selected you, a software developer in Java, to start developing the minimally viable product (MVP) to migrate the legacy back-end to the modern Spring framework.

## Installation
Open with an IDE: Open in Intellij or your chosen IDE with the required libraries.



| D288 Backend Programming Tech Stack Overview||
| --- | --- |
| Programming Language | Java |
| Database | MySQL |
| Framework | Spring |


## Objectives
+ C. Construct four new packages, one for each of the following: controllers, entities, dao, and services. The packages will need to be used for a checkout form and vacations packages list.

    Note: The packages should be on the same level of the hierarchy.

    Note: Construct a package named config and copy the RestDataConfig.java provided in the laboratory environment to the package. Modify it so that the package and imports have the correct package and import addresses. Copy the application.properties file that is provided in the laboratory environment into your application properties resource file.

    ```
    See inside config Folder: RestDataConfig.java
    See inside resources Folder: application.properties
    ```

+ D. Write code for the entities package that includes entity classes and the enum designed to match the UML diagram.

    ```
    See inside entities Folder: Cart.java, CartItem.java, Country.java, Customer.java,  Division.java, Excursion.java,  StatusType.java, Vacation.java
    ```

+ E. Write code for the dao package that includes repository interfaces for the entities that extend JpaRepository, and add cross-origin support.

    ```
    See inside dao Folder: CartItemRepository.java, CartRepository.java, CountryRepository.java, CustomerRepository.java, DivisionRepository.java, ExcursionRepository.java, VacationRepository.java
    ```

+ F. Write code for the services package that includes each of the following:

    | |
    | --- |
    | a purchase data class with a customer cart and a set of cart items |
    | a purchase response data class that contains an order tracking number |
    | a checkout service interface |
    | a checkout service implementation class |


    ```
    See inside services Folder: CheckoutService.java, CheckoutServiceImpl.java, Purchase.java, PurchaseResponse.java
    See inside entities Folder: Cart.java, Customer.Java,
    ```

+ G. Write code to include validation to enforce the inputs needed by the Angular front-end.

    ```
    See inside entities Folder: Customer.java
    ```

+ H.   Write code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders.

    Note: You do not need to duplicate REST functionality for each repository by creating methods in Java.

    ```
    See inside controller Folder:  CheckoutController.java
    ```

+ I. Add five sample customers to the application programmatically.

    ```
    See inside BootStrapData Folder: BootStrapData.java
    ```


## Screenshots 
**The following two screen shots display the cart item, total and customer info**
![image](https://github.com/RubenBerrios/WGU-D288-BackEndProgramming/blob/main/Screenshot%202024-02-25%20130347.png)
![image](https://github.com/RubenBerrios/WGU-D288-BackEndProgramming/blob/main/Screenshot%202024-02-25%20130550.png)

**The following two screenshots display that the webpage successfully uploaded the information to the database**
![image](https://github.com/RubenBerrios/WGU-D288-BackEndProgramming/blob/main/Screenshot%202024-02-25%20131001.png)
![image](https://github.com/RubenBerrios/WGU-D288-BackEndProgramming/blob/main/Screenshot%202024-02-25%20131033.png)
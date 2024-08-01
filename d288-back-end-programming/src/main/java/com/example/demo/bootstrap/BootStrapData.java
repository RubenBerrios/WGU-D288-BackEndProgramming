package com.example.demo.bootstrap;


import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository)
    {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception
    {
        //array of customers Firstname,lastname,phone#,address,zipcode, division id
        String[][] customersArray = {
                {"Ruben","Berrios","(123)4567890","1 Main ST", "12345", "2"},
                {"Charles","Smith","(456)6349784","2 Main ST", "67890", "3"},
                {"Richard","Lopez","(789)9748372","3 Main ST", "90210", "4"},
                {"John","Wilson","(012)8572947","4 Main ST", "42069", "5"},
                {"Daniel","Thomas","(345)0194854","5 Main ST", "80823", "6"}
        };


        //loop 5 times to add the 5 customers
        for(int i = 0 ; i < 5 ; i++)
        {
            //first check if the Users have already been added
            if(customerRepository.count() > 5)
            {
                //exit loop and don't add customers
                break;
            }

            //create customer and fill data, grabbing data from customer array
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(customersArray[i][0]);
            newCustomer.setLastName(customersArray[i][1]);
            newCustomer.setPhone(customersArray[i][2]);
            newCustomer.setAddress(customersArray[i][3]);
            newCustomer.setPostal_code(customersArray[i][4]);

            //sets the division for the customer
            newCustomer.setDivision(divisionRepository.findById(Long.valueOf(customersArray[i][5])).get());


            //save customer to database
            customerRepository.save(newCustomer);
        }
    }
}

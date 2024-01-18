package customer.com.ginikascustomers.dto;

import customer.com.ginikascustomers.entity.Bought;
import customer.com.ginikascustomers.entity.Country;
import customer.com.ginikascustomers.entity.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerResponseFromDb {
    private Long id;

    private String firstName;

    private String lastName;

    private String state;

    private String country;

    private List<BoughtResponseFromDb> bought;


    public CustomerResponseFromDb(Customer customer){
        id = customer.getId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        state = customer.getState();
        country = customer.getCountry().getCountry();
        bought = convertFrmDbToResponse(customer);
    }

    public List<BoughtResponseFromDb> convertFrmDbToResponse(Customer customer){
        List<Bought> boughts = customer.getBought();
        List<BoughtResponseFromDb> bt = new ArrayList<>();

        for (Bought b: boughts) {
            BoughtResponseFromDb boughtResponseFromDb = new BoughtResponseFromDb(b);

            bt.add(boughtResponseFromDb);
        }

        return bt;
    }
}

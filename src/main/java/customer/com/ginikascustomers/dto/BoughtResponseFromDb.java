package customer.com.ginikascustomers.dto;

import customer.com.ginikascustomers.entity.Bought;
import customer.com.ginikascustomers.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtResponseFromDb {

    private Long id;

    private String thing;

    public BoughtResponseFromDb (Bought customer){
        id = customer.getId();
        thing = customer.getThing();
    }

}

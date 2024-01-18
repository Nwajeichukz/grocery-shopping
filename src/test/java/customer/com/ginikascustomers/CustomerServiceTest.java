package customer.com.ginikascustomers;
//
//import customer.com.ginikascustomers.dto.AppResponse;
//import customer.com.ginikascustomers.dto.CustomerRequest;
//import customer.com.ginikascustomers.dto.CustomerResponseFromDb;
//import customer.com.ginikascustomers.entity.Bought;
//import customer.com.ginikascustomers.entity.Country;
//import customer.com.ginikascustomers.entity.Customer;
//import customer.com.ginikascustomers.repository.CountryRepository;
//import customer.com.ginikascustomers.repository.CustomerRepository;
//import customer.com.ginikascustomers.service.CustomerService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @Mock
//    private CountryRepository countryRepository;
//
//    @InjectMocks
//    private CustomerService customerService;
//
//
//    @Test
//    public void CustomerService_Create_Customer(){
//        Customer addingCustomer = new Customer();
//        Bought bought = new Bought();
//        Country country = new Country();
//
//
//        CustomerRequest customerRequest = CustomerRequest.builder()
//                .firstName("Aisha")
//                .lastName("ginika")
//                .state("PH")
//                .country("Country")
//                .bought(List.of("Rice", "Beans", "Garri"))
//                .build();
//
//
//        country.setCountry("NIGERIA");
//
//
//        bought.setThing("rice");
//        bought.setCustomer(addingCustomer);
//
//
//        addingCustomer.setFirstName("Aisha");
//        addingCustomer.setLastName("ginika");
//        addingCustomer.setState("PH");
//        addingCustomer.setCountry(country);
//        addingCustomer.setBought(List.of(bought));
//
//
//
//        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(addingCustomer);
//        AppResponse<String> response = customerService.create(customerRequest);
//
//        Assertions.assertThat(response).isNotNull();
//    }
//
//
//    @Test
//    public void CustomerService_GetAll_Customer(){
//        Pageable pageReq = PageRequest.of(0, 3);
//        Customer addingCustomer = new Customer();
//        Bought bought = new Bought();
//        Country country = new Country();
//
//        addingCustomer.setFirstName("Aisha");
//        addingCustomer.setLastName("ginika");
//        addingCustomer.setState("PH");
//        addingCustomer.setCountry(country);
//        addingCustomer.setBought(List.of(bought));
//
//        country.setCountry("NIGERIA");
//
//
//        bought.setThing("rice");
//        bought.setCustomer(addingCustomer);
//
//
//        Page<Customer> cus = new PageImpl<>(List.of(addingCustomer), pageReq, 1);
//
//        when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(cus);
//        AppResponse<Map<String, Object>> response = customerService.getAll(pageReq);
//        Assertions.assertThat(response).isNotNull();
//    }
//
//    @Test
//    public void CustomerService_GetById_Customer(){
//        long id = 1l;
//
//        Customer addingCustomer = new Customer();
//        Bought bought = new Bought();
//        Country country = new Country();
//
//        addingCustomer.setFirstName("Aisha");
//        addingCustomer.setLastName("ginika");
//        addingCustomer.setState("PH");
//        addingCustomer.setCountry(country);
//        addingCustomer.setBought(List.of(bought));
//
//        country.setCountry("NIGERIA");
//
//
//        bought.setThing("rice");
//        bought.setCustomer(addingCustomer);
//
//        when(customerRepository.findById(id)).thenReturn(Optional.ofNullable(addingCustomer));
//        AppResponse<CustomerResponseFromDb> response = customerService.getById(id);
//        Assertions.assertThat(response).isNotNull();
//
//    }
}

package customer.com.ginikascustomers.service;

import customer.com.ginikascustomers.dto.AppResponse;
import customer.com.ginikascustomers.dto.CustomerResponseFromDb;
import customer.com.ginikascustomers.entity.Customer;
import customer.com.ginikascustomers.exception.ApiException;
import customer.com.ginikascustomers.repository.CountryRepository;
import customer.com.ginikascustomers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public AppResponse<Map<String, Object>> getAll(Pageable pageable) {
        Page<CustomerResponseFromDb> customerResponseFromDbPage = customerRepository.findAll(pageable).map((c) -> new CustomerResponseFromDb(c));

        Map<String, Object> page = Map.of(
                "page", customerResponseFromDbPage.getNumber(),
                "totalPages", customerResponseFromDbPage.getTotalPages(),
                "totalELments", customerResponseFromDbPage.getTotalElements(),
                "size", customerResponseFromDbPage.getSize(),
                "content", customerResponseFromDbPage.getContent()
        );

        return new AppResponse<>("success", page);

    }


    public AppResponse<CustomerResponseFromDb> getById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ApiException("id not found"));
        CustomerResponseFromDb cus = new CustomerResponseFromDb(customer);
        return new AppResponse<>(0, "successful", cus);
    }


    public String updateDetail(long id, String firstName) {
        Customer addingCustomer = customerRepository.findById(id).orElseThrow(() -> new ApiException("id not found"));

        addingCustomer.setFirstName(firstName);

        customerRepository.save(addingCustomer);

        return "successful";
    }





}
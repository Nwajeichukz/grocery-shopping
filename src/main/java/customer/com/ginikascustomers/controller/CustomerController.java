package customer.com.ginikascustomers.controller;

import customer.com.ginikascustomers.dto.AppResponse;
import customer.com.ginikascustomers.dto.CustomerResponseFromDb;
import customer.com.ginikascustomers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PreAuthorize("hasRole('admin')")
    @GetMapping()
    public AppResponse<Map<String, Object>> getCustomers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "page", required = false, defaultValue = "3") int size
    ){
        return customerService.getAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public AppResponse<CustomerResponseFromDb> getCustomerById(@PathVariable long id){
        return customerService.getById(id);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public String updateCustomerDetails(@PathVariable long id, @RequestBody @Valid String firstName){
        return customerService.updateDetail(id, firstName);
    }
}

package customer.com.ginikascustomers.controller;

import customer.com.ginikascustomers.dto.AppResponse;
import customer.com.ginikascustomers.dto.AuthenticationRequest;
import customer.com.ginikascustomers.dto.CustomerRequest;
import customer.com.ginikascustomers.service.AuthenticationService;
import customer.com.ginikascustomers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public AppResponse<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return authenticationService.create(customerRequest);
    }

    @PostMapping("/login")
    public AppResponse<String> login(@Valid @RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.login(authenticationRequest);
    }
}

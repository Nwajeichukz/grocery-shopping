package customer.com.ginikascustomers.service;

import customer.com.ginikascustomers.dto.AppResponse;
import customer.com.ginikascustomers.dto.AuthenticationRequest;
import customer.com.ginikascustomers.dto.CustomerRequest;
import customer.com.ginikascustomers.entity.Bought;
import customer.com.ginikascustomers.entity.Country;
import customer.com.ginikascustomers.entity.Customer;
import customer.com.ginikascustomers.entity.Role;
import customer.com.ginikascustomers.exception.ApiException;
import customer.com.ginikascustomers.repository.CountryRepository;
import customer.com.ginikascustomers.repository.CustomerRepository;
import customer.com.ginikascustomers.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final CustomerRepository customerRepository;

    private final RoleRepository roleRepository;

    private final MyUserDetailsService myUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final CountryRepository countryRepository;



    public AppResponse<String> create(CustomerRequest customerRequest){
        boolean check = customerRepository.existsByUsernameOrEmail(customerRequest.getUsername(), customerRequest.getEmail());

        if (check) throw new ApiException("User already exists, login to continue");

        Customer addingCustomer = new Customer();
        addingCustomer.setFirstName(customerRequest.getFirstName());
        addingCustomer.setLastName(customerRequest.getLastName());
        addingCustomer.setState(customerRequest.getState());
        addingCustomer.setUsername(customerRequest.getUsername());
        addingCustomer.setEmail(customerRequest.getEmail());

        addingCustomer.setCountry(returnCountry(customerRequest));
        addingCustomer.setPassword(passwordEncoder.encode(customerRequest.getPassword()));

        addingCustomer.setBought(thingsBought(customerRequest, addingCustomer) );

        Role roles = roleRepository.findByName(customerRequest.getRole());
        if (roles == null){
            Role role = new Role();
            role.setName(customerRequest.getRole());
            addingCustomer.setRoles(role);
        }else {
            addingCustomer.setRoles(roles);
        }

        customerRepository.save(addingCustomer);

        return new AppResponse<>(0, "successful");
    }


    public AppResponse<String> login(AuthenticationRequest authenticationRequest) {

        var user = myUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword()))
            return  new AppResponse<>(0,"wrong gmail/password");

        var jwtToken = jwtService.generateToken(user);


        return  new AppResponse<>(0,"Successfully logged in", jwtToken);

    }


    public Country returnCountry(CustomerRequest cus){
        Country countryDB = countryRepository.findByCountry(cus.getCountry());

        if (countryDB == null){
            Country country = new Country();
            country.setCountry(cus.getCountry());
            return country;
        }

        return countryDB;
    }


    public List<Bought> thingsBought(CustomerRequest customerRequest, Customer customer){
        List<String> tbS = customerRequest.getBought();
        List<Bought> boughtList = new ArrayList<>();

        for (String b : tbS) {
            Bought bought = new Bought();
            bought.setThing(b);
            bought.setCustomer(customer);

            boughtList.add(bought);
        }

        return boughtList;
    }

}

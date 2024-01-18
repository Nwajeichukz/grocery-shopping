package customer.com.ginikascustomers.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
public class CustomerRequest {

    @NotEmpty(message = "firstName cant be blank")
    private String firstName;

    @NotEmpty(message = "lastName cant be blank")
    private String lastName;
    @NotEmpty(message = "username should not be blank")
    private String username;
    @NotEmpty(message = "state cant be blank")
    private String state;

    @NotEmpty(message = "email cant be blank")
    private String email;

    @NotEmpty(message = "password should not be blank")
    private String password;

    @NotEmpty(message = "country cant be blank")
    private String country;

    @NotEmpty(message = "bought cant be blank")
    private List<String> bought;

    @NotEmpty(message = "role cant be blank")
    private String role;
}

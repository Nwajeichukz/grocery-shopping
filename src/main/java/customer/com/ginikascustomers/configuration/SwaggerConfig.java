package customer.com.ginikascustomers.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI bookOpenApi (AppInfo appInfo){
        return new OpenAPI()
                .info(new Info().title(appInfo.getTitle())
                        .description(appInfo.getDescription())
                        .version(appInfo.getVersion())
                        .contact(new Contact().email(appInfo.getContactEmail()).name(appInfo.getContactName()).url(appInfo.getContactUrl()))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.txt")));
    }
}
package customer.com.ginikascustomers.repository;

import customer.com.ginikascustomers.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountry(String country);
}

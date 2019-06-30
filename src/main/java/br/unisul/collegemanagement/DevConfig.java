package br.unisul.collegemanagement;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.address.AddressRepository;
import br.unisul.collegemanagement.city.CityRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;

@Configuration
@ConditionalOnProperty(prefix = "spring.jpa.hibernate", name = "ddl-auto", havingValue = "create")
@DependsOn({"initializeStates", "initializeCities"})
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DevConfig {

    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    /**
     * Populate the database with sample data for testing.
     */
    @Bean
    protected void populateDatabaseForTesting() {
        Address address1 = Address.builder()
                .street("Rua Fernando Antônio dos Santos")
                .postalCode("88790-000")
                .city(cityRepository.getOne(24))
                .build();
        Address address2 = Address.builder()
                .street("Rua Catulo Cearense")
                .postalCode("95680-000")
                .neighborhood("Vila Haity")
                .city(cityRepository.getOne(19))
                .build();
        Address address3 = Address.builder()
                .street("Praça do Espinhaço")
                .number("321")
                .postalCode("25000-000")
                .neighborhood("Praça Espinhaço")
                .city(cityRepository.getOne(23))
                .build();
        Address address4 = Address.builder()
                .street("Avenida General San Martin")
                .number("23A")
                .numberAptRoom("2B")
                .neighborhood("Leblon")
                .postalCode("20000-000")
                .city(cityRepository.getOne(26))
                .build();

        addressRepository.saveAll(Arrays.asList(address1, address2, address3, address4));
    }

}

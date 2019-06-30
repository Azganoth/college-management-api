package br.unisul.collegemanagement.address;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressService {

    private final AddressRepository addressRepository;

    public Address create(Address address) {
        address.setId(null);
        return addressRepository.save(address);
    }

    public Address retrieveById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> retrieveAll() {
        return addressRepository.findAll();
    }

}

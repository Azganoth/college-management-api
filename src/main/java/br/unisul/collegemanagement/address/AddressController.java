package br.unisul.collegemanagement.address;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressController {

    private final AddressService addressService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok(addressService.retrieveAll());
    }

}

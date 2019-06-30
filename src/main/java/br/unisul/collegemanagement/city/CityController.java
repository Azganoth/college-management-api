package br.unisul.collegemanagement.city;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CityController {

    private final CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCity(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok(cityService.retrieveAll());
    }

}

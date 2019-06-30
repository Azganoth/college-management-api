package br.unisul.collegemanagement.state;

import br.unisul.collegemanagement.city.City;
import br.unisul.collegemanagement.city.CityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StateController {

    private final StateService stateService;
    private final CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<State> getState(@PathVariable Integer id) {
        return ResponseEntity.ok(stateService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<State>> getStates() {
        return ResponseEntity.ok(stateService.retrieveAll());
    }

    @RequestMapping(value = "/{id}/cities", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getCities(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.retrieveAllByStateId(id));
    }

}

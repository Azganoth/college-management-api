package br.unisul.collegemanagement;

import br.unisul.collegemanagement.city.City;
import br.unisul.collegemanagement.city.CityRepository;
import br.unisul.collegemanagement.state.State;
import br.unisul.collegemanagement.state.StateRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class InitConfig {

    /**
     * Branch url from github project that hosts the data for states and cities from Brazil.
     */
    private final String SOURCE_URL =
            "https://raw.githubusercontent.com/felipefdl/cidades-estados-brasil-json/master";

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    /**
     * Register all states from Brazil on the database.
     */
    @Bean
    protected void initializeStates() throws Exception {
        URI statesUri = new URI(String.format("%s/Estados.json", SOURCE_URL));
        JSONTokener statesToken = new JSONTokener(statesUri.toURL().openStream());
        JSONArray statesArray = new JSONArray(statesToken);

        for (int i = 0, size = statesArray.length(); i < size; i++) {
            JSONObject stateObject = statesArray.getJSONObject(i);
            stateRepository.save(State.builder()
                    .id(stateObject.getInt("ID"))
                    .abbreviation(stateObject.getString("Sigla"))
                    .name(stateObject.getString("Nome"))
                    .build());
        }
    }

    /**
     * Register all cities from Brazil on the database.
     */
    @Bean
    protected void initializeCities() throws Exception {
        URI citiesUri = new URI(String.format("%s/Cidades.json", SOURCE_URL));
        JSONTokener citiesToken = new JSONTokener(citiesUri.toURL().openStream());
        JSONArray citiesArray = new JSONArray(citiesToken);

        for (int i = 0; i < citiesArray.length(); i++) {
            JSONObject cityObject = citiesArray.getJSONObject(i);
            cityRepository.save(City.builder()
                    .id(cityObject.getInt("ID"))
                    .name(cityObject.getString("Nome"))
                    .state(State.builder().id(cityObject.getInt("Estado")).build())
                    .build());
        }
    }

}

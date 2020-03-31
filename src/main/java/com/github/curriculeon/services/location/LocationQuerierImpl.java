package com.github.curriculeon.services.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountryResult;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leonhunter
 * @created 03/27/2020 - 7:22 PM
 */
public class LocationQuerierImpl implements LocationQuerierInterface {
    @Override
    public String getExternalApiEndPoint() {
        return "https://api.printful.com/countries";
    }

    @Override
    public PrintfulCountryResult getAllCountryResult() {
        return new RestTemplate().getForObject(getExternalApiEndPoint(), PrintfulCountryResult.class);
    }

    @Override
    public List<PrintfulCountry> getAllCountries() {
        return getAllCountryResult().getResult();
    }

    @Override
    public List<String> getAllCountryNames() {
        return getAllCountries()
                .stream()
                .map(PrintfulCountry::getName)
                .collect(Collectors.toList());
    }


    @Override
    public PrintfulCountry getCountry(final String countryName) {
        return getAllCountries()
                .stream()
                .filter(country -> country.getName().equalsIgnoreCase(countryName.replaceAll("_", " ")))
                .findFirst()
                .get();
    }

    @Override
    public List<PrintfulState> getAllStates(String countryName) {
        return getCountry(countryName).getStates();
    }


    @Override
    public List<String> getAllStateNames(String countryName) {
        List<PrintfulState> allStates = getAllStates(countryName);
        Stream<PrintfulState> allStatesStream = allStates.stream();
        Stream<String> allStateNames = allStatesStream.map(PrintfulState::getName);
        List<String> result = allStateNames.collect(Collectors.toList());
        return result;

    }

    @Override
    public PrintfulState getState(String countryName, String stateName) {
        return getAllStates(countryName)
                .stream()
                .filter(state -> state.getName().equalsIgnoreCase(stateName))
                .findFirst()
                .get();
    }
}

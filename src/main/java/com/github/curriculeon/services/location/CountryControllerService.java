package com.github.curriculeon.services.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leonhunter
 * @created 03/31/2020 - 6:43 PM
 */
@Service
public class CountryControllerService {
    private LocationQuerierInterface locationQuerier;

    public CountryControllerService(LocationQuerierInterface locationQuerier) {
        this.locationQuerier = locationQuerier;
    }

    public CountryControllerService() {
        this(new LocationQuerierLogger());
    }

    public LocationQuerierInterface getLocationQuerier() {
        return locationQuerier;
    }

    public List<PrintfulCountry> all() {
        return getLocationQuerier().getAllCountries();
    }

    public List<String> names() {
        return getLocationQuerier().getAllCountryNames();
    }

    public PrintfulCountry getCountry(String countryName) {
        return getLocationQuerier().getCountry(countryName);
    }

    public List<String> getAllStateNames(String countryName) {
        return getLocationQuerier().getAllStateNames(countryName);
    }

    public PrintfulState getState(String countryName, String stateName) {
        return getLocationQuerier().getState(countryName, stateName);
    }

    public List<PrintfulState> getAllStates(String countryName) {
        return getLocationQuerier().getAllStates(countryName);
    }
}

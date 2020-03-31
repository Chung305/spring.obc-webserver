package com.github.curriculeon.services.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountryResult;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import com.github.git_leon.logging.SimpleLoggerInterface;
import com.github.git_leon.logging.SimpleLoggerWarehouse;

import java.util.List;

/**
 * @author leonhunter
 * @created 03/31/2020 - 6:12 PM
 * decorates `LocationQuerierImpl` with logging
 */
public class LocationQuerierLogger implements LocationQuerierInterface {
    private final LocationQuerierInterface locationQuerier;
    private final SimpleLoggerInterface logger;

    public LocationQuerierLogger(LocationQuerierInterface locationQuerier, SimpleLoggerInterface logger) {
        this.logger = logger;
        this.locationQuerier = locationQuerier;
    }

    public LocationQuerierLogger(SimpleLoggerInterface logger) {
        this(new LocationQuerierImpl(), logger);
    }

    public LocationQuerierLogger() {
        this(new LocationQuerierImpl(), SimpleLoggerWarehouse.getLogger(LocationQuerierImpl.class.getName()));
    }

    public LocationQuerierInterface getLocationQuerier() {
        return locationQuerier;
    }

    public SimpleLoggerInterface getLogger() {
        return logger;
    }

    @Override
    public String getExternalApiEndPoint() {
        return getLocationQuerier().getExternalApiEndPoint();
    }

    @Override
    public PrintfulCountryResult getAllCountryResult() {
        getLogger().info("Attempting to get all-country-results from endpoint [ %s ] ", getExternalApiEndPoint());
        PrintfulCountryResult result = getLocationQuerier().getAllCountryResult();
        getLogger().info("Successfully retrieved all-country-results from endpoint [ %s ] ", getExternalApiEndPoint());
        getLogger().info("contents:\n\t %s", result);
        return result;
    }

    @Override
    public List<PrintfulCountry> getAllCountries() {
        List<PrintfulCountry> result = getLocationQuerier().getAllCountries();
        getLogger().info("List of all countries:\n\t %s", result);
        return result;
    }

    @Override
    public List<String> getAllCountryNames() {
        getLogger().info("Attempting to fetch all country names");
        List<String> result = getLocationQuerier().getAllCountryNames();
        getLogger().info("Successfully retrieved all countries.");
        getLogger().info("contents:\n\t[ %s ]", result);
        return result;
    }


    @Override
    public PrintfulCountry getCountry(final String countryName) {
        getLogger().info("Attempting to find state named [ %s ]", countryName);
        PrintfulCountry result = getLocationQuerier().getCountry(countryName);
        getLogger().info("Successfully retrieved country named [ %s ] ", countryName);
        getLogger().info("contents:\n\t[ %s ]", result);
        return result;
    }

    @Override
    public List<PrintfulState> getAllStates(String countryName) {
        getLogger().info("Attempting to get all states from country [ %s ]", countryName);
        List<PrintfulState> result = getLocationQuerier().getAllStates(countryName);
        getLogger().info("Successfully retrieved all states from country [ %s ].");
        getLogger().info("contents:\n\t[ %s ]", result);
        return result;
    }


    @Override
    public List<String> getAllStateNames(String countryName) {
        getLogger().info("Attempting to get all state names from [ %s ]", countryName);
        List<String> result = getLocationQuerier().getAllStateNames(countryName);
        getLogger().info("Successfully retrieved all state-names from country [ %s ].");
        getLogger().info("contents:\n\t[ %s ]", result);
        return result;
    }

    @Override
    public PrintfulState getState(String countryName, String stateName) {
        getLogger().info("Attempting to get state [ %s ] from country [ %s ]", stateName, countryName);
        PrintfulState result = getLocationQuerier().getState(countryName, stateName);
        getLogger().info("Successfully retrieved state [ %s ] from country [ %s ]", stateName, countryName);
        getLogger().info("contents:\n\t[ %s ]", result);
        return result;
    }

}

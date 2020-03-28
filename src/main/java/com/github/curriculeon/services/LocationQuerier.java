package com.github.curriculeon.services;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountryResult;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author leonhunter
 * @created 03/27/2020 - 7:22 PM
 */
@Component
public class LocationQuerier {
    private static final String endpoint = "https://api.printful.com/countries";
    private static final Logger logger = Logger.getLogger(LocationQuerier.class.getName());

    public PrintfulCountryResult getAllCountryResult() {
        logger.info(String.format("Attempting to all-country-results from endpoint [ %s ] ", endpoint));
        PrintfulCountryResult result = new RestTemplate().getForObject(endpoint, PrintfulCountryResult.class);
        logger.info(String.format("Successfully retrieved all-country-results from endpoint [ %s ] ", endpoint));
        logger.info(String.format("List of all all-country-results:\n\t", result));
        return result;
    }

    public List<PrintfulCountry> getAllCountries() {
        List<PrintfulCountry> result = getAllCountryResult().getResult();
        logger.info(String.format("List of all countries:\n\t", result));
        return result;
    }


    public List<PrintfulState> getAllStates(String countryName) {
        List<PrintfulState> result = null;
        for (PrintfulCountry country : getAllCountries()) {
            if (country.getName().equals(countryName)) {
                result = country.getStates();
            }
        }
        logger.info(String.format("List of all countries:\n\t", result));
        return result;
    }
}

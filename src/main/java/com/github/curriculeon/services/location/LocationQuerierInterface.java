package com.github.curriculeon.services.location;

import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountry;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulCountryResult;
import com.github.curriculeon.models.workopportunity.printfullocation.PrintfulState;

import java.util.List;

public interface LocationQuerierInterface {
    PrintfulCountryResult getAllCountryResult();

    List<PrintfulCountry> getAllCountries();

    List<String> getAllCountryNames();

    PrintfulCountry getCountry(String countryName);

    List<PrintfulState> getAllStates(String countryName);

    List<String> getAllStateNames(String countryName);

    PrintfulState getState(String countryName, String stateName);

    String getExternalApiEndPoint();
}

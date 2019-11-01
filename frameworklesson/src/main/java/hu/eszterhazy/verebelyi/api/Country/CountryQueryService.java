package hu.eszterhazy.verebelyi.api.Country;

import java.util.Collection;

public interface CountryQueryService {
    Collection<Country> listAll();
    Collection<Country> findById(Long id);
    Collection<Country> findByName(String country);
    void addCountry(Country country);
    void deleteCountry(Long id);
}

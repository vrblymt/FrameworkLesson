package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Country.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByIdEquals(Long id);
    List<Country> findByCountryContains(String country);
    void deleteCountryByIdEquals(Long id);
}

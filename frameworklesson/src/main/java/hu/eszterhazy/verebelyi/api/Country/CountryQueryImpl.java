package hu.eszterhazy.verebelyi.api.Country;

import hu.eszterhazy.verebelyi.dao.CountryRepository;

import java.util.Collection;

public class CountryQueryImpl implements CountryQueryService {

    private CountryRepository countryRepository;
    public CountryQueryImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Collection<Country> listAll() {
        return (Collection<Country>) countryRepository.findAll();
    }

    @Override
    public Collection<Country> findById(Long id) {
        return countryRepository.findByIdEquals(id);
    }

    @Override
    public Collection<Country> findByName(String country) {
        return countryRepository.findByCountryContains(country);
    }

    @Override
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteCountryByIdEquals(id);
    }
}

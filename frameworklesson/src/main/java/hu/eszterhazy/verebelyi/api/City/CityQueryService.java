package hu.eszterhazy.verebelyi.api.City;

import java.util.Collection;

public interface CityQueryService {
    Collection<City> listAll();
    Collection<City> findById(Long id);
    Collection<City> findByName(String name);
    void deleteById(Long id);
}

package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.City.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByIdEquals(Long id);
    List<City> findByCityContains(String name);
    void deleteByIdEquals(Long id);
}

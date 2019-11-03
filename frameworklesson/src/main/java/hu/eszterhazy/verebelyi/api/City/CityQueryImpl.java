package hu.eszterhazy.verebelyi.api.City;

import hu.eszterhazy.verebelyi.dao.CityRepository;

import java.util.Collection;

public class CityQueryImpl implements CityQueryService {
    private CityRepository cityRepository;

    public CityQueryImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }


    @Override
    public Collection<City> listAll() {
        return (Collection<City>) cityRepository.findAll();
    }

    @Override
    public Collection<City> findById(Long id) {
        return cityRepository.findByIdEquals(id);
    }

    @Override
    public Collection<City> findByName(String name) {
        return cityRepository.findByCityContains(name);
    }

    @Override
    public void deletebyId(Long id) {
        cityRepository.deleteByIdEquals(id);
    }
}

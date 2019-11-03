package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.City.City;
import hu.eszterhazy.verebelyi.api.City.CityQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value="/city")
public class CityController {

    @Autowired
    private CityQueryService cityQueryService;

    @RequestMapping(value = {"/", "", "/{city}"})
    public Collection<City> listAllCity(
            @PathVariable(name = "city", required = false) String city
    ){
        if(city != null){
            try{
                return cityQueryService.findById(Long.decode(city));
            }
            catch(NumberFormatException ex){
                return cityQueryService.findByName(city);
            }
        }else{
            return cityQueryService.listAll();
        }
    }
}

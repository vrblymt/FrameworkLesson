package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Country.Country;
import hu.eszterhazy.verebelyi.api.Country.CountryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.OptionalDataException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryQueryService countryQueryService;
    @RequestMapping(value ={"", "/", "/{country}"})
    public Collection<Country> listAllCountry(
            @PathVariable(name="country", required = false) String country){
        if(country != null){
            try{
                return countryQueryService.findById(Long.decode(country));
            }
            catch(NumberFormatException ex){
                return countryQueryService.findByName(country);
            }
        }else{
            return countryQueryService.listAll();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addNewCountry(
            @RequestParam(name="country", required = true) String country
    ){
                countryQueryService.addCountry(new Country(country));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyCountry(
            @RequestParam(name = "id", required = true) Long id,
            @RequestParam(name = "country", required = true) String name
    ){
        countryQueryService.modifyCountry(id, name);
    }

    @Transactional
    @RequestMapping(value="/delete", method =  RequestMethod.POST)
    public void deleteCountry(
            @RequestParam(name="id", required = true) Long id
    ){
        countryQueryService.deleteCountry(id);
    }
}

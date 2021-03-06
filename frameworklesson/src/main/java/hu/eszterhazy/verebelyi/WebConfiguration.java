package hu.eszterhazy.verebelyi;

import hu.eszterhazy.verebelyi.api.Actor.ActorQueryImpl;
import hu.eszterhazy.verebelyi.api.Actor.ActorQueryService;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryImpl;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryService;
import hu.eszterhazy.verebelyi.api.Category.CategoryQueryImpl;
import hu.eszterhazy.verebelyi.api.Category.CategoryQueryService;
import hu.eszterhazy.verebelyi.api.City.CityQueryImpl;
import hu.eszterhazy.verebelyi.api.City.CityQueryService;
import hu.eszterhazy.verebelyi.api.Costumer.CostumerQueryImpl;
import hu.eszterhazy.verebelyi.api.Costumer.CostumerQueryService;
import hu.eszterhazy.verebelyi.api.Country.CountryQueryImpl;
import hu.eszterhazy.verebelyi.api.Country.CountryQueryService;
import hu.eszterhazy.verebelyi.api.Film.FilmQueryImpl;
import hu.eszterhazy.verebelyi.api.Film.FilmQueryService;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorQueryImpl;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorQueryService;
import hu.eszterhazy.verebelyi.api.Language.LanguageQueryImpl;
import hu.eszterhazy.verebelyi.api.Language.LanguageQueryService;
import hu.eszterhazy.verebelyi.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean(name = "ActorQueryService")
    public ActorQueryService actorQueryService(ActorRepository actorRepository){
        return new ActorQueryImpl(actorRepository);
    }
    @Bean(name="AddressQueryService")
    public AddressQueryService addressQueryService(AddressRepository addressRepository){
        return new AddressQueryImpl(addressRepository);
    }
    @Bean(name="CountryQueryService")
    public CountryQueryService countryQueryService(CountryRepository countryRepository){
        return new CountryQueryImpl(countryRepository);
    }
    @Bean(name="LanguageQueryService")
    public LanguageQueryService languageQueryService(LanguageRepository languageRepository){
        return new LanguageQueryImpl(languageRepository);
    }

    @Bean(name="CategoryQueryService")
    public CategoryQueryService categoryQueryService(CategoryRepository categoryRepository){
        return new CategoryQueryImpl(categoryRepository);
    }

    @Bean(name = "CityQueryService")
    public CityQueryService cityQueryService(CityRepository cityRepository){
        return  new CityQueryImpl(cityRepository);
    }

    @Bean(name = "filmQueryService")
    public FilmQueryService filmQueryService(FilmRepository filmRepository){
        return new FilmQueryImpl(filmRepository);
    }

    @Bean(name = "filmActorQueryService")
    public FilmActorQueryService filmActorQueryService(FilmActorRepository filmActorRepository){
        return new FilmActorQueryImpl(filmActorRepository);
    }
    @Bean(name = "CostumerQueryService")
    public CostumerQueryService costumerQueryService(CostumerRepository costumerRepository){
        return new CostumerQueryImpl(costumerRepository);
    }
}

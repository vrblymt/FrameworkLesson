package hu.eszterhazy.verebelyi;

import hu.eszterhazy.verebelyi.api.Actor.ActorQueryImpl;
import hu.eszterhazy.verebelyi.api.Actor.ActorQueryService;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryImpl;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryService;
import hu.eszterhazy.verebelyi.api.Country.CountryQueryImpl;
import hu.eszterhazy.verebelyi.api.Country.CountryQueryService;
import hu.eszterhazy.verebelyi.api.Language.LanguageQueryImpl;
import hu.eszterhazy.verebelyi.api.Language.LanguageQueryService;
import hu.eszterhazy.verebelyi.dao.ActorRepository;
import hu.eszterhazy.verebelyi.dao.AddressRepository;
import hu.eszterhazy.verebelyi.dao.CountryRepository;
import hu.eszterhazy.verebelyi.dao.LanguageRepository;
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
}

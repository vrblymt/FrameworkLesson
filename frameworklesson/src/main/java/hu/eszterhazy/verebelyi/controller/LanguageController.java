package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Language.Language;
import hu.eszterhazy.verebelyi.api.Language.LanguageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value="/language")
public class LanguageController {
    @Autowired
    private LanguageQueryService languageQueryService;

    @RequestMapping(value={"", "/", "/{language}"})
    public Collection<Language> listAllLanguage(
            @PathVariable(name="language", required = false) String language
    ){
        if(language != null){
            try{
                return languageQueryService.findById(Long.decode(language));
            }
            catch(NumberFormatException ex){
                return languageQueryService.findByName(language);
            }
        }else{
            return languageQueryService.listAll();
        }
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewLanguage(
            @RequestParam(name ="language", required = true) String name
    ){
            Date date = new Date();
            Language language = new Language();
            language.setName(name);
            language.setLast_update(new Timestamp(date.getTime()));
            languageQueryService.addLanguage(language);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteLanguage(
            @RequestParam(name="id", required = true) Long id
    ){
        languageQueryService.deleteLanguageById(id);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyLanguage(
        @RequestParam(name = "id", required = true) Long id,
        @RequestParam(name = "language", required = true) String name
    ){
        languageQueryService.modifyLanguage(id, name);
    }
}

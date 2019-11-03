package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Film.Film;
import hu.eszterhazy.verebelyi.api.Film.FilmQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    private FilmQueryService filmQueryService;

    @RequestMapping(value = {"", "/", "/{film}"})
    public Collection<Film> listAllFilm(
            @PathVariable(name = "film", required = false) String film
    ){
        if(film != null){
            try{
                return filmQueryService.findById(Long.decode(film));
            }
            catch(NumberFormatException ex){
                return filmQueryService.findByName(film);
            }
        }else{
            return filmQueryService.listAll();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteById(
            @RequestParam(name = "id", required = true) Long id
    ){
        filmQueryService.deleteById(id);
    }
}

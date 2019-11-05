package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.FilmActor.FilmActor;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorId;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/filmactor")
public class FilmActorController {
    @Autowired
    private FilmActorQueryService filmActorQueryService;

    @RequestMapping(value = {"", "/"})
    public Collection<FilmActor> listAllFilmActor(){
        return filmActorQueryService.listAll();
    }
    @RequestMapping(value="/find")
    public Collection<FilmActor> listById(
            @RequestParam(name = "filmId", required = true) Long filmId,
            @RequestParam(name = "actorId", required = true) Long actorId
    ){
        return filmActorQueryService.findById(new FilmActorId(filmId, actorId));
    }
}

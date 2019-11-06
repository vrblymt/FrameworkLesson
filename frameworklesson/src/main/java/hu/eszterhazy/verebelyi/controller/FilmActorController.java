package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.FilmActor.FilmActor;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorId;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

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

    @Transactional
    @RequestMapping(value = "modify", method =  RequestMethod.POST)
    public void modifyFilmActor(
            @RequestParam(name = "filmId", required = true) Long film_id,
            @RequestParam(name = "actorId", required = true) Long actor_id,
            @RequestParam(name = "newFilmId", required = true) Long new_film_id,
            @RequestParam(name = "newActorId", required = true) Long new_actor_id
    ){
        filmActorQueryService.modifyFilmActor(film_id, actor_id, new_film_id, new_actor_id);
    }

    @RequestMapping(value = "add", method =  RequestMethod.POST)
    public void addNewFilmActor(
            @RequestParam(name = "filmId", required = true) Long film_id,
            @RequestParam(name = "actorId", required = true) Long actor_id
    ){
        Date date = new Date();
        filmActorQueryService.addNewFilmActor(
                new FilmActor(
                        new FilmActorId(film_id, actor_id),
                        new Timestamp(date.getTime())
                )
        );
    }

    @Transactional
    @RequestMapping(value = "delete", method =  RequestMethod.POST)
    public void deleteFilmActor(
            @RequestParam(name = "filmId", required = true) Long film_id,
            @RequestParam(name = "actorId", required = true) Long actor_id
    ){
        filmActorQueryService.deleteFilmAndActor(new FilmActorId(film_id, actor_id));
    }
}

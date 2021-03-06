package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Actor.Actor;
import hu.eszterhazy.verebelyi.api.Actor.ActorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value="/actors")
public class ActorController {

    @Autowired
    private ActorQueryService actorQueryService;

    @RequestMapping(value={"/", "", "/{actor}"})
    public Collection<Actor> findAll(
            @PathVariable(name = "actor", required = false) String actor) {
        if(actor != null){
            try{
                return actorQueryService.findActorById(Long.decode(actor));
            }
            catch(NumberFormatException ex){
                return actorQueryService.findActorByName(actor);
            }
        }else {
            return actorQueryService.allActors();
        }
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewActor(
            @RequestParam(name = "firstName", required = true) String firstName,
            @RequestParam(name = "lastName", required = true) String lastName){
        Date date = new Date();
        actorQueryService.addActor(new Actor(firstName, lastName, new Timestamp(date.getTime())));
    }
    @Transactional
    @RequestMapping(value="/modify", method = RequestMethod.POST)
    public void modifyExistingActor(
            @RequestParam(name="id", required = true) Long id,
            @RequestParam(name = "firstName", required = true) String firstName,
            @RequestParam(name = "lastName", required = true) String lastName){
        actorQueryService.ModifyActorById(id, firstName, lastName);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteSelectedActor(
            @RequestParam(name="id", required = true) Long id
    ){
        actorQueryService.DeleteActorById(id);
    }

}


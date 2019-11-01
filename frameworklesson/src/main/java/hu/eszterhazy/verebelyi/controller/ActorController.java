package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Actor.Actor;
import hu.eszterhazy.verebelyi.api.Actor.ActorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@RestController
@RequestMapping(value="/actors")
public class ActorController {

    @Autowired
    private ActorQueryService actorQueryService;

    @RequestMapping(value={"/", "", "/{actorId}"})
    public Collection<Actor> findAll(
            @PathVariable(name = "actorId", required = false) Long id) {
            if (id == null || "".equals(id)) {
                return actorQueryService.allActors();
            }
            return actorQueryService.findActorById(id);
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewActor(
            @RequestParam(name = "firstName", required = true) String firstName,
            @RequestParam(name = "lastName", required = true) String lastName){
        actorQueryService.addActor(new Actor(firstName, lastName));
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


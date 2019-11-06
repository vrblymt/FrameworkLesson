package hu.eszterhazy.verebelyi.api.Actor;

import java.util.Collection;

public interface ActorQueryService {
    Collection<Actor> allActors();
    Collection<Actor> findActorById(Long id);
    Collection<Actor> findActorByName(String name);
    void addActor(Actor actor);
    void ModifyActorById(Long id, String firstName, String lastName);
    void DeleteActorById(Long id);
}

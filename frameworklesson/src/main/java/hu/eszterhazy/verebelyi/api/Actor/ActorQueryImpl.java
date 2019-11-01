package hu.eszterhazy.verebelyi.api.Actor;

import hu.eszterhazy.verebelyi.dao.ActorRepository;

import java.util.Collection;

public class ActorQueryImpl implements ActorQueryService {
    private ActorRepository actorRepository;

    public ActorQueryImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Collection<Actor> allActors() {
        return (Collection<Actor>) actorRepository.findAll();
    }

    @Override
    public Collection<Actor> findActorById(Long id) {
        return actorRepository.findByIdEquals(id);
    }

    @Override
    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void ModifyActorById(Long id, String firstName, String lastName) {
        Actor actor = (Actor) actorRepository.findByIdEquals(id);
        actor.setId(id);
        actor.setLastName(lastName);
        actor.setFirstName(firstName);
        actorRepository.save(actor);

    }

    @Override
    public void DeleteActorById(Long id) {
        actorRepository.deleteActorByIdEquals(id);
    }


    //@Override
    //public void addActor(Actor actor) {
    //    actorRepository.save(actor);
    //}

    //@Override
    //public void updateActor(String first_name) {
    //    Actor actor = (Actor) actorRepository.findActorByFirst_nameOrLast_name(first_name);
    //}

    //@Override
    //public void deleteActor(Long id) {
    //    actorRepository.deleteActorByActor_id(id);
    //}
}

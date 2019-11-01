package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Actor.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Long> {
    List<Actor> findByIdEquals(Long id);
    void deleteActorByIdEquals(Long id);
}

package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.FilmActor.FilmActor;
import hu.eszterhazy.verebelyi.api.FilmActor.FilmActorId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
    List<FilmActor> findByFilmActorIdEquals(FilmActorId filmActorId);
}

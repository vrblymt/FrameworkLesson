package hu.eszterhazy.verebelyi.api.FilmActor;

import java.util.Collection;

public interface FilmActorQueryService {
    Collection<FilmActor> listAll();
    Collection<FilmActor> findById(FilmActorId filmActorId);
}

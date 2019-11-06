package hu.eszterhazy.verebelyi.api.FilmActor;

import java.util.Collection;

public interface FilmActorQueryService {
    Collection<FilmActor> listAll();
    Collection<FilmActor> findById(FilmActorId filmActorId);
    void addNewFilmActor(FilmActor filmActor);
    void modifyFilmActor(Long oldFilmId, Long oldActorId, Long newFilmId, Long newActorId);
    void deleteFilmAndActor(FilmActorId filmActorId);
}

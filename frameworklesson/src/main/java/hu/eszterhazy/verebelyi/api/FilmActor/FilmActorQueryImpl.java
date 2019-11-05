package hu.eszterhazy.verebelyi.api.FilmActor;

import hu.eszterhazy.verebelyi.dao.FilmActorRepository;

import java.util.Collection;

public class FilmActorQueryImpl implements FilmActorQueryService {
    private FilmActorRepository filmActorRepository;

    public FilmActorQueryImpl(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    @Override
    public Collection<FilmActor> listAll() {
        return (Collection<FilmActor>) filmActorRepository.findAll();
    }

    @Override
    public Collection<FilmActor> findById(FilmActorId filmActorId) {
        return filmActorRepository.findByFilmActorIdEquals(filmActorId);
    }
}

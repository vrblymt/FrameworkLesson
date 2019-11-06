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

    @Override
    public void addNewFilmActor(FilmActor filmActor) {
        filmActorRepository.save(filmActor);
    }

    @Override
    public void modifyFilmActor(Long oldFilmId, Long oldActorId, Long newFilmId, Long newActorId) {
        FilmActorId oldId = new FilmActorId(oldFilmId, oldActorId);
        FilmActor filmActor = filmActorRepository.findByFilmActorIdEquals(oldId).get(0);
        filmActor.setFilmActorId(new FilmActorId(newFilmId, newActorId));
        filmActorRepository.save(filmActor);
    }

    @Override
    public void deleteFilmAndActor(FilmActorId filmActorId) {
        filmActorRepository.deleteByFilmActorIdEquals(filmActorId);
    }
}

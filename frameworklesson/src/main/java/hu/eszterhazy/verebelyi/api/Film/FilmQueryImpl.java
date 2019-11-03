package hu.eszterhazy.verebelyi.api.Film;

import hu.eszterhazy.verebelyi.dao.FilmRepository;

import java.util.Collection;

public class FilmQueryImpl implements FilmQueryService {
    private FilmRepository filmRepository;

    public FilmQueryImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Collection<Film> listAll() {
        return (Collection<Film>) filmRepository.findAll();
    }

    @Override
    public Collection<Film> findById(Long id) {
        return filmRepository.findByIdEquals(id);
    }

    @Override
    public Collection<Film> findByName(String name) {
        return filmRepository.findByTitleContains(name);
    }

    @Override
    public void deleteById(Long id) {
        filmRepository.deleteByIdEquals(id);
    }
}

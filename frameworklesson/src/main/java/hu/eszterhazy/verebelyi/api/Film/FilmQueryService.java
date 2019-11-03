package hu.eszterhazy.verebelyi.api.Film;

import java.util.Collection;

public interface FilmQueryService {
    Collection<Film> listAll();
    Collection<Film> findById(Long id);
    Collection<Film> findByName(String name);
    void deleteById(Long id);
}

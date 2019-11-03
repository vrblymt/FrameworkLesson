package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Film.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findByIdEquals(Long id);
    List<Film> findByTitleContains(String name);
    void deleteByIdEquals(Long id);
}

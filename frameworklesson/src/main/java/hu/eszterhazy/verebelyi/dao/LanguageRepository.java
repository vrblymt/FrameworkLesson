package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Language.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findByNameContains(String name);
    List<Language> findByIdEquals(Long id);
    void deleteByIdEquals(Long id);
}

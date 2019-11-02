package hu.eszterhazy.verebelyi.api.Language;

import java.util.Collection;
import java.util.List;

public interface LanguageQueryService {
    Collection<Language> listAll();
    Collection<Language> findById(Long id);
    Collection<Language> findByName(String name);
    void addLanguage(Language language);
    void deleteLanguageById(Long id);
    void modifyLanguage(Long id, String name);
}

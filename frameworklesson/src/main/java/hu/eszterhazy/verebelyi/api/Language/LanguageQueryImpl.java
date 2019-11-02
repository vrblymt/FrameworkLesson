package hu.eszterhazy.verebelyi.api.Language;

import hu.eszterhazy.verebelyi.dao.LanguageRepository;

import java.util.Collection;
import java.util.Optional;

public class LanguageQueryImpl implements LanguageQueryService{

    private LanguageRepository languageRepository;

    public LanguageQueryImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Collection<Language> listAll() {
        return (Collection<Language>) languageRepository.findAll();
    }

    @Override
    public Collection<Language> findById(Long id) {
        return languageRepository.findByIdEquals(id);
    }

    @Override
    public Collection<Language> findByName(String name) {
        return languageRepository.findByNameContains(name);
    }

    @Override
    public void addLanguage(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void deleteLanguageById(Long id) {
        languageRepository.deleteByIdEquals(id);
    }
}

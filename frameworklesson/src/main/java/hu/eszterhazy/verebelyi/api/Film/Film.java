package hu.eszterhazy.verebelyi.api.Film;

import hu.eszterhazy.verebelyi.api.Actor.Actor;
import hu.eszterhazy.verebelyi.api.Language.Language;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Long id;
    private String title;
    private String description;
    @Column(name = "release_year")
    private Date releaseYear;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id", nullable = false, referencedColumnName = "language_id")
    private Language language;
    @Column(name="rental_duration")
    private Integer rentalDuration;
    @Column(name = "rental_rate")
    private Double rentalRate;
    private Integer length;
    @Column(name = "replacement_cost")
    private Double replacementCost;
    private String rating;
    @Column(name = "special_features")
    private String specialFeatures;

    /*public Collection<Actor> getFilms() {
        return films;
    }

    public void setFilms(Collection<Actor> films) {
        this.films = films;
    }

    @ManyToMany(mappedBy = "actorInFilms")
    Collection<Actor> films;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Film(String title, String description, Date releaseYear, Language language, Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating, String specialFeatures, Timestamp lastUpdate) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    public Film() {
    }

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

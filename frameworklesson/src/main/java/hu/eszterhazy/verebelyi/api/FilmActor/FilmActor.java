package hu.eszterhazy.verebelyi.api.FilmActor;


import hu.eszterhazy.verebelyi.api.Actor.Actor;
import hu.eszterhazy.verebelyi.api.Film.Film;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film_actor")
public class FilmActor {
    @EmbeddedId
    private FilmActorId filmActorId;

    public FilmActor(FilmActorId filmActorId) {
        this.filmActorId = filmActorId;
    }

    public Actor getActor() {
        return actor;
    }
    public Film getFilm() {
        return film;
    }
    @Override
    public String toString() {
        return "FilmActor{" +
                "filmActorId=" + filmActorId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public void setFilmActorId(FilmActorId filmActorId) {
        this.filmActorId = filmActorId;
    }

    public FilmActor(FilmActorId filmActorId, Timestamp lastUpdate) {
        this.filmActorId = filmActorId;
        this.lastUpdate = lastUpdate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public FilmActor() {
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id", nullable = false,referencedColumnName = "actor_id", insertable = false, updatable = false)
    Actor actor;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id",nullable = false, referencedColumnName = "film_id", insertable = false, updatable = false)
    Film film;
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public void setActor(Actor actor) {
        this.actor = actor;
    }


    public void setFilm(Film film) {
        this.film = film;
    }

}

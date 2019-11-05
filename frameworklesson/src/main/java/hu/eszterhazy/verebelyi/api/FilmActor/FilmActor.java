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


    @Override
    public String toString() {
        return "FilmActor{" +
                "filmActorId=" + filmActorId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public FilmActorId getFilmActorId() {
        return filmActorId;
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

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

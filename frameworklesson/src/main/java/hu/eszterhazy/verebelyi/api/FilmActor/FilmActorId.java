package hu.eszterhazy.verebelyi.api.FilmActor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId implements Serializable {
    @Column(name = "film_id", nullable = false)
    Long filmId;
    @Column(name = "actor_id", nullable = false)
    Long actorId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return getFilmId().equals(that.getFilmId()) &&
                getActorId().equals(that.getActorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmId(), getActorId());
    }

    public FilmActorId(Long filmId, Long actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getActorId() {
        return actorId
                ;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public FilmActorId() {
    }
}

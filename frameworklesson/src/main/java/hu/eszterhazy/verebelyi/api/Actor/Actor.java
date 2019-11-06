package hu.eszterhazy.verebelyi.api.Actor;


import hu.eszterhazy.verebelyi.api.Film.Film;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name="actor")
public class Actor {

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    /*public Collection<Film> getActorInFilms() {
        return actorInFilms;
    }

    public void setActorInFilms(Collection<Film> actorInFilms) {
        this.actorInFilms = actorInFilms;
    }

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    Collection<Film> actorInFilms;*/

    public Actor(String firstName, String lastName, Timestamp last_update) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = last_update;
    }

    public Actor() {

    }

}

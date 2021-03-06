package hu.eszterhazy.verebelyi.api.Country;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Country {
    @Id
    @Column(name="country_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @Column(name = "last_update")
    private Timestamp last_update;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", updated_at=" + last_update +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getUpdated_at() {
        return last_update;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.last_update = updated_at;
    }

    public Country(){

    }
    public Country(String country, Timestamp last_update) {
        this.country = country;
        this.last_update = last_update;
    }
}

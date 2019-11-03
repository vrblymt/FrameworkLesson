package hu.eszterhazy.verebelyi.api.City;

import hu.eszterhazy.verebelyi.api.Country.Country;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long id;
    private String city;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country=" + country.getCountry() +
                ", last_update=" + last_update +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false, referencedColumnName = "country_id")
    private Country country;
    private Timestamp last_update;

    public City(){}
    public City(String city, Country country, Timestamp last_update) {
        this.city = city;
        this.country = country;
        this.last_update = last_update;
    }
}

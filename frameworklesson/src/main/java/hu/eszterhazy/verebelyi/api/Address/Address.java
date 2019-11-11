package hu.eszterhazy.verebelyi.api.Address;


import hu.eszterhazy.verebelyi.api.City.City;

import javax.persistence.*;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long id;
    private String address;
    private String address2;
    private String district;
    @Column(name = "city_id",insertable = false, updatable = false)
    private Long cityId;

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Column(name = "postal_code", nullable = true)
    private String postalCode;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false, referencedColumnName = "city_id")
    private City city;
    public Address(){

    }
    public Address(String address, String district, Long cityId, String postalCode, String phone, Timestamp lastUpdate) {
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.cityId = cityId;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", city=" + city +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name="last_update")
    private Timestamp lastUpdate;

}

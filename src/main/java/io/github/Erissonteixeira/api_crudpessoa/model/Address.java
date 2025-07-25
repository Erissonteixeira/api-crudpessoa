package io.github.Erissonteixeira.api_crudpessoa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
    private Long id;
    private String road;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    public Address(Long id, String road, String number, String neighborhood, String city, String state, String zipCode){
        this.id = id;
        this.road = road;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getRoad() {
        return road;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipCode) {
        this.zipCode = zipCode;
    }
}

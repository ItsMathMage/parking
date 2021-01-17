package com.utm.entity;

public class Place {
    private Long id;
    private Integer number;
    private Double price;
    private Boolean IsEmpty;

    public Place() {}

    public Place(Integer number, Double price, Boolean isEmpty) {
        this.number = number;
        this.price = price;
        IsEmpty = isEmpty;
    }

    public Place(Long id, Integer number, Double price, Boolean isEmpty) {
        this.id = id;
        this.number = number;
        this.price = price;
        IsEmpty = isEmpty;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getEmpty() {
        return IsEmpty;
    }

    public void setEmpty(Boolean empty) {
        IsEmpty = empty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

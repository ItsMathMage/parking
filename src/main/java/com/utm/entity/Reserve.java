package com.utm.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Reserve {
    private Long id;
    private LocalDate reserveDate;
    private Client client;
    private Boolean isPay;
    private Map<Place, Integer> reserveDetails = new HashMap<>();

    public Reserve() {}

    public Reserve(LocalDate reserveDate, Client client, Map<Place, Integer> reserveDetails) {
        this.reserveDate = reserveDate;
        this.client = client;
        this.reserveDetails = reserveDetails;
    }

    public Reserve(Long id, LocalDate reserveDate, Client client, Boolean isPay, Map<Place, Integer> reserveDetails) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.client = client;
        this.isPay = isPay;
        this.reserveDetails = reserveDetails;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<Place, Integer> getReserveDetails() {
        return reserveDetails;
    }

    public void setReserveDetails(Map<Place, Integer> reserveDetails) {
        this.reserveDetails = reserveDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPay() {
        return isPay;
    }

    public void setPay(Boolean pay) {
        isPay = pay;
    }
}

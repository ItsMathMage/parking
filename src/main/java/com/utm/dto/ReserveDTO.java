package com.utm.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReserveDTO {
    private Long id;
    @NotNull
    private LocalDate reserveDate;
    @NotNull
    private Long clientId;

    private String some;

    public ReserveDTO() {}

    public ReserveDTO(Long id, @NotNull LocalDate reserveDate, Long clientId) {
        this.id = id;
        this.reserveDate = reserveDate;
        this.clientId = clientId;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getSome() {
        return some;
    }

    public void setSome(String some) {
        this.some = some;
    }
}

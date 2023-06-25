package com.hostfully.application.model;

import java.time.LocalDate;

public class Booking {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking() {

    }

    public Booking(long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

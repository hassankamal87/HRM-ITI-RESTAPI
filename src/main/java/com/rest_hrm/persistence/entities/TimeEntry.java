package com.rest_hrm.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "timeentries", schema = "hr_db")
public class TimeEntry {
    @Id
    @Column(name = "entryID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empID", nullable = false)
    private Employee empID;

    @NotNull
    @Column(name = "entryDate", nullable = false)
    private LocalDate entryDate;

    @Column(name = "timeIn")
    private LocalTime timeIn;

    @Column(name = "timeOut")
    private LocalTime timeOut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmpID() {
        return empID;
    }

    public void setEmpID(Employee empID) {
        this.empID = empID;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

}
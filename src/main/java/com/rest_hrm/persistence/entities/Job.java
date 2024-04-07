package com.rest_hrm.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job", schema = "hr_db")
public class Job {
    @Id
    @Column(name = "jobID", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "jobTitle", nullable = false, length = 30)
    private String jobTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}
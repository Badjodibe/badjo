package com.badjo.badjo.domain.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "conferences")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The title of the conference is required")
    @Size(max = 100, message = "Title must not extends 100 character")
    private String title;

    @NotBlank(message = "The description is required")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "The location is required")
    private String location;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime startDate;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endDate;

    @NotBlank(message = "The status is required")
    private String status;



    public Conference() {
    }

    public Conference(
            String title, String description, String location,
            LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public @NotBlank(message = "The status is required") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "The status is required") String status) {
        this.status = status;
    }
}

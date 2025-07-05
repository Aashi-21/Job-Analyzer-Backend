package com.example.jobanalyzer.entity;

import lombok.Data;
import jakarta.persistence.*;



@Data
@Entity
@Table(name = "remote_jobs")
public class RemoteJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;
}

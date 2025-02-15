package com.Host.Host.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "guest")
public class Visit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "long_url")
    private String longUrl;

    @Column (name = "keyword")
    private String keyword;

    @Column (name = "status")
    private String status;

    @Column (name = "count")
    private long count;

    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "updated_at")
    private LocalDateTime updatedAt;
}

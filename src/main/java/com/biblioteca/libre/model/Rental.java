package com.biblioteca.libre.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id; // id of the rental record

  @Column(nullable = false)
  private String customerName;

  @Column(nullable = false)
  private String isbn;

  @Column(nullable = false)
  private LocalDateTime returnDate; // when the book will be returned

  @Column(updatable = false)
  private LocalDateTime borrowDate; // day book was borrowed

  @PrePersist
  public void onCreate(){
    this.borrowDate = LocalDateTime.now();
  }

  @Column(columnDefinition = "boolean default false")
  private Boolean returned; // whether book has been returned or not

  private LocalDateTime updatedAt;
  @PreUpdate
  public void onUpdate(){
    this.updatedAt = LocalDateTime.now();
  }
}

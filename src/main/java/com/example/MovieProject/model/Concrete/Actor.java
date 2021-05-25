package com.example.MovieProject.model.Concrete;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Actor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;
private String FullName;

}

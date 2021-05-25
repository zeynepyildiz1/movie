package com.example.MovieProject.model.Concrete;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Type;
	  @OneToMany(fetch = FetchType.EAGER, mappedBy = "Type", cascade = CascadeType.ALL)
	    private Set<Movie> Movies = new HashSet<Movie>();

}

package com.example.MovieProject.Entities.Concrete;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class MovieType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Type;
	//  @OneToMany(fetch = FetchType.EAGER, mappedBy = "Type", cascade = CascadeType.ALL)
	//    private Set<Movie> Movies = new HashSet<Movie>();

}

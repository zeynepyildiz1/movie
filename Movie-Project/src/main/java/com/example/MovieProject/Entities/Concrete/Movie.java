package com.example.MovieProject.Entities.Concrete;
import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

	@Entity
	@Data
	public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	//@JoinColumn(name="Type_Id",referencedColumnName = "Type", nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "Type")
	private MovieType Type;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date DateOfPublish;
	private String Description;
	@Column(nullable = true, length = 64)
	private String Media;
	@ManyToMany(fetch=FetchType.EAGER,cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(
			name="MOVIE_LANGUAGE",
			joinColumns=@JoinColumn(name="MOVIE_ID"),
			inverseJoinColumns=@JoinColumn(name="LANGUAGE_ID")
			)
	private Set<Language> Languages=new HashSet<>();
	@ManyToMany(fetch=FetchType.EAGER,cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(
			name="MOVIE_ACTOR",
			joinColumns=@JoinColumn(name="MOVIE_ID"),
			inverseJoinColumns=@JoinColumn(name="ACTOR_ID")
			)
	private Set<Actor> Actors=new HashSet<>();
	@Transient
	public String getMediaPath() {
		
	    if (Media == null) return null;
	     
	    return "/movie-media/" + Id + "/" + Media;
	}
}

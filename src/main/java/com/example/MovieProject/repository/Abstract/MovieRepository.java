package com.example.MovieProject.repository.Abstract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MovieProject.model.Concrete.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
	//@Query("Select m.name,t.type from Movie m join Type t  on m.type_Id = t.id")
//public List<Movie> getFindAllWithType();

}

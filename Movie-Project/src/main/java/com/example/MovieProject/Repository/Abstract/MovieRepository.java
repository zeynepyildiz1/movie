package com.example.MovieProject.Repository.Abstract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MovieProject.Entities.Concrete.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

//  @Query("SELECT MOVIE.Id,MOVIE.Name, MOVIE.Date_Of_Publish, Movie_Type.Type,Actor.Full_Name FROM MOVIE_TYPE JOIN MOVIE on MOVIE_TYPE.Id=MOVIE.Type_Id JOIN MOVIE_ACTOR on MOVIE.Id=MOVIE_ACTOR.Movie_Id JOIN ACTOR on Movie_Actor.Actor_Id=Actor.Id where Movie.Name='Drama' OR Actor.Full_Name ='Drama'  OR Movie_Type.Type='Drama' ORDER BY Movie.Date_Of_Publish")
//	public List<Movie> search(String keyword);
}


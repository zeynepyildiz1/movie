package com.example.MovieProject.service.Abstract;
import java.util.List;

import com.example.MovieProject.model.Concrete.Movie;
public interface MovieService {
List<Movie> getAllMovies();
Movie addMovie(Movie movie);

}

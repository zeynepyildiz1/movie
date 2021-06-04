package com.example.MovieProject.Service.Abstract;

import java.util.List;

import com.example.MovieProject.Entities.Concrete.Movie;


public interface MovieService {
	List<Movie> getAllMovies(String keyword);
	Movie addMovie(Movie movie);
	Movie getMovieById(int id);
	void deleteMovieById(int id);
	//Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

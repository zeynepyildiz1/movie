package com.example.MovieProject.service.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieProject.model.Concrete.Movie;
import com.example.MovieProject.repository.Abstract.MovieRepository;
import com.example.MovieProject.service.Abstract.MovieService;

@Service
public class MovieManager implements MovieService {
	@Autowired
private MovieRepository movieRepository;
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	@Override
	public Movie addMovie(Movie movie) {
		return this.movieRepository.save(movie);
		
	}

}

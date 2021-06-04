package com.example.MovieProject.Service.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.MovieProject.Entities.Concrete.Movie;
import com.example.MovieProject.Repository.Abstract.MovieRepository;
import com.example.MovieProject.Service.Abstract.MovieService;

@Service
public class MovieManager implements MovieService {
	@Autowired
private MovieRepository movieRepository;
	@Override
	public List<Movie> getAllMovies(String keyword) {
		 return movieRepository.findAll();
		/* if (keyword != null) {
	            return movieRepository.search(keyword);
	        }
	        return movieRepository.findAll();*/
	}
	@Override
	public Movie addMovie(Movie movie) {
		return this.movieRepository.save(movie);
		
	}
	@Override
	public Movie getMovieById(int id) {
		Optional<Movie> optional = movieRepository.findById(id);
		Movie movie = null;
		if (optional.isPresent()) {
			movie = optional.get();
		} else {
			throw new RuntimeException(" Movie not found for id :: " + id);
		}
		return movie;
	}

	@Override
	public void deleteMovieById(int id) {
		this.movieRepository.deleteById(id);
	}

	//@Override
/*	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}*/
}
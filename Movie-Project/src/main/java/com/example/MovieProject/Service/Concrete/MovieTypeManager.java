package com.example.MovieProject.Service.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieProject.Entities.Concrete.MovieType;
import com.example.MovieProject.Repository.Abstract.MovieTypeRepository;
import com.example.MovieProject.Service.Abstract.MovieTypeService;



@Service
public class MovieTypeManager implements MovieTypeService {
	@Autowired
private MovieTypeRepository movieTypeRepository;

	@Override
	public List<MovieType> getAllType() {
		// TODO Auto-generated method stub
		return movieTypeRepository.findAll();
	}

	@Override
	public MovieType getFindById(int id) {
		return movieTypeRepository.getById(id);
	}
}

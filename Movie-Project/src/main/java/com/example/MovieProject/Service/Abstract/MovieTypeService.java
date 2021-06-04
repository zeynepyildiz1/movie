package com.example.MovieProject.Service.Abstract;

import java.util.List;

import com.example.MovieProject.Entities.Concrete.MovieType;


public interface MovieTypeService {
List<MovieType> getAllType();
MovieType getFindById(int id);

}
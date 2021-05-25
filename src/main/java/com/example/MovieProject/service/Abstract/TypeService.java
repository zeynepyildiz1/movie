package com.example.MovieProject.service.Abstract;
import java.util.List;

import com.example.MovieProject.model.Concrete.Type;


public interface TypeService {
List<Type> getAllType();
Type getFindById(int id);

}

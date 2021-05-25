package com.example.MovieProject.service.Concrete;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieProject.model.Concrete.Type;
import com.example.MovieProject.repository.Abstract.TypeRepository;
import com.example.MovieProject.service.Abstract.TypeService;


@Service
public class TypeManager implements TypeService {
	@Autowired
private TypeRepository typeRepository;

	@Override
	public List<Type> getAllType() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}

	@Override
	public Type getFindById(int id) {
		return typeRepository.getById(id);
	}


}

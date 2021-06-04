package com.example.MovieProject.Service.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieProject.Entities.Concrete.Language;
import com.example.MovieProject.Repository.Abstract.LanguageRepository;
import com.example.MovieProject.Service.Abstract.LanguageService;



@Service
public class LanguageManager implements LanguageService {
@Autowired
private LanguageRepository languageRepository;

	@Override
	public List<Language> getAllLanguage() {
		// TODO Auto-generated method stub
		return languageRepository.findAll();
	}

}
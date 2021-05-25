package com.example.MovieProject.repository.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieProject.model.Concrete.Language;
@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer>  {

}

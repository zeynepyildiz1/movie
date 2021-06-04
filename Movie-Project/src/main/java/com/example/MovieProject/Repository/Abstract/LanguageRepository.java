package com.example.MovieProject.Repository.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieProject.Entities.Concrete.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer>  {

}
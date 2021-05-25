package com.example.MovieProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.MovieProject.core.util.FileUploadUtil;
import com.example.MovieProject.model.Concrete.Language;
import com.example.MovieProject.model.Concrete.Movie;
import com.example.MovieProject.service.Abstract.LanguageService;
import com.example.MovieProject.service.Abstract.MovieService;
import com.example.MovieProject.service.Abstract.TypeService;



import org.springframework.util.StringUtils;



@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private TypeService typeService;
	

	@GetMapping("/")
	public String getAll(Model model){	
	
		model.addAttribute("listOfMovies",movieService.getAllMovies());
		System.out.println(movieService.getAllMovies());
		return "index";
	}
	@GetMapping("/showMovieForm")
	public String showNewEmployeeForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		List<Language> listLanguages=languageService.getAllLanguage();
		model.addAttribute("listLanguage", listLanguages);
		//List<Type> listType=typeService.getAllType();
		//model.addAttribute("listType", listType);
		return "addMovie";
	}
	
	@PostMapping("/addMovie")
	public String saveEmployee(@ModelAttribute("movie") Movie movie, @RequestParam("image") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        movie.setMedia(fileName);
        Movie savedMovie =  movieService.addMovie(movie);
        String uploadDir = "movie-media/" + savedMovie.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return "redirect:/";
	}
}

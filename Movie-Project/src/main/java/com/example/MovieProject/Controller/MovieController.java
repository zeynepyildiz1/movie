package com.example.MovieProject.Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MovieProject.Core.Util.FileUploadUtil;
import com.example.MovieProject.Entities.Concrete.Actor;
import com.example.MovieProject.Entities.Concrete.Language;
import com.example.MovieProject.Entities.Concrete.Movie;
import com.example.MovieProject.Entities.Concrete.MovieType;
import com.example.MovieProject.Service.Abstract.ActorService;
import com.example.MovieProject.Service.Abstract.LanguageService;
import com.example.MovieProject.Service.Abstract.MovieService;
import com.example.MovieProject.Service.Abstract.MovieTypeService;


@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private MovieTypeService movieTypeService;
	@Autowired
	private ActorService actorService;
	
	  @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public String getAll(Model model, @Param("keyword") String keyword){	
	       List<Movie> listProducts = movieService.getAllMovies(keyword);
	        model.addAttribute("listProducts", listProducts);
	        model.addAttribute("keyword", keyword);
	         
	        return "index";
	}
	@GetMapping("/showMovieForm")
	public String showNewEmployeeForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		List<Language> listLanguages=languageService.getAllLanguage();
		model.addAttribute("listLanguage", listLanguages);
		List<MovieType> listType=movieTypeService.getAllType();
		model.addAttribute("listType", listType);
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
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {

		Movie movie = movieService.getMovieById(id);
		System.out.println(movie);
		
		model.addAttribute("movie", movie);
		List<Language> listLanguages=languageService.getAllLanguage();
		model.addAttribute("listLanguage", listLanguages);
		List<MovieType> listType=movieTypeService.getAllType();
		model.addAttribute("listType", listType);
		return "updateMovie";
	}
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable (value = "id") int id) {
		// call delete employee method 
		this.movieService.deleteMovieById(id);
		return "redirect:/";
	}
	@GetMapping("/showFormForActor/{id}")
	public String showFormForActor(@PathVariable ( value = "id") int id, Model model) {
		Movie movie = movieService.getMovieById(id);
		
		Actor actor = new Actor();
		
		model.addAttribute("actor", actor);
		model.addAttribute("movie", movie);
		return "addActor";
	}
	@PostMapping("/addActor/{movieId}")
	 @RequestMapping(value = "movieId", method = RequestMethod.POST)
	public String saveActor(@ModelAttribute("actor") Actor actor,@RequestParam("movieId") int movieId) {
		System.out.println(actor);
		//System.out.println(id);
		actorService.addActor(actor);
		//Movie movie = movieService.getMovieById(id);
		//System.out.println("dgdfg"+movie);
		Set<Actor> actorList= new HashSet<>();
		actorList.add(actor);
        //movie.setActors(actorList);
        //movieService.addMovie(movie);
        return "redirect:/";
	}
}


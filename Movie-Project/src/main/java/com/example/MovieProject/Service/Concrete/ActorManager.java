package com.example.MovieProject.Service.Concrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MovieProject.Entities.Concrete.Actor;
import com.example.MovieProject.Repository.Abstract.ActorRepository;
import com.example.MovieProject.Service.Abstract.ActorService;

@Service
public class ActorManager implements ActorService {
@Autowired
private ActorRepository actorRespository;

@Override
public Actor addActor(Actor actor) {
	// TODO Auto-generated method stub
	return actorRespository.save(actor);
}





}
package com.example.MovieProject.Repository.Abstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.MovieProject.Entities.Concrete.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}

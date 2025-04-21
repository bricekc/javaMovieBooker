package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence;

import com.example.JavaMovieBooker.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}

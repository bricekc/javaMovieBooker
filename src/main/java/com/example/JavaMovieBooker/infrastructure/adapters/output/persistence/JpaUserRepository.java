package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends CrudRepository<UserEntity, String> {
}

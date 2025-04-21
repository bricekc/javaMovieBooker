package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence;

import com.example.JavaMovieBooker.application.ports.output.IUserRepository;
import com.example.JavaMovieBooker.domain.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepository implements IUserRepository {
    private final JpaUserRepository jpaRepo;

    public UserRepository(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<User> findAll() {
        return jpaRepo.findAll().stream()
                .map(this::convertToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return jpaRepo.findById(id).map(this::convertToDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email).map(this::convertToDomain);
    }

    @Override
    public void save(User user) {
        jpaRepo.save(convertToEntity(user));
    }

    private User convertToDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }

    private UserEntity convertToEntity(User user) {
        return new UserEntity(
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}

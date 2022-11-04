package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.businesssoftdevcourse.security.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CassandraRepository<User, String> {
    Optional<User> findByUsername(String username);
}

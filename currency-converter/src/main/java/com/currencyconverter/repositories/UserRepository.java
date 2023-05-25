package com.currencyconverter.repositories;

import com.currencyconverter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(" SELECT U " +
            "FROM User U " +
            "WHERE U.email = :email")
    Optional<User> findUserByEmail(
            @Param("email") String email
    );

}

package com.currencyconverter.repositories;

import com.currencyconverter.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Query( "SELECT W " +
            "FROM Wallet W " +
            "WHERE W.user.id = :id_user " +
            "AND W.from = :from ")
    Optional<Wallet> findWalletUserByFrom(
            @Param("id_user") UUID id_user,
            @Param("from") String from
    );

}

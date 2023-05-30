package com.currencyconverter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String from;

    private Double money;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Wallet(String from, Double money, User user) {
        this.from = from;
        this.money = money;
        this.user = user;
    }
}

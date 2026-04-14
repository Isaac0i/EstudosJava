package com.isaac.bank.model;

import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String holder;
    private Double balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> history = new ArrayList<>();

    public abstract void withdraw(Double value);
    public void deposit(Double value) { this.balance += value; }
}

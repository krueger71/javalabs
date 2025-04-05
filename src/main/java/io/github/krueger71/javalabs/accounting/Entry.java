package io.github.krueger71.javalabs.accounting;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @NotNull
    Account account;
    @ManyToOne
    @NotNull
    Transaction transaction;
    @Positive
    @Negative
    BigDecimal amount;      // positive is debit, negative is credit
}

package io.github.krueger71.javalabs.accounting;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.Positive;

record Entry(
                @Id Long id,
                AggregateReference<Account, Long> account,
                AggregateReference<Transaction, Long> transaction,
                @Positive @Negative BigDecimal amount // positive is debit, negative is credit
) {
}

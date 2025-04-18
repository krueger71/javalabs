package io.github.krueger71.javalabs.accounting;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.Positive;

@Table("ENTRY")
record EntryRecord(
                @Id Long id,
                AggregateReference<AccountRecord, Long> account,
                AggregateReference<TransactionRecord, Long> transaction,
                @Positive @Negative BigDecimal amount // positive is debit, negative is credit
) {
}

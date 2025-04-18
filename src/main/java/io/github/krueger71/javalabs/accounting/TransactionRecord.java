package io.github.krueger71.javalabs.accounting;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;

@Table("TRANSACTION")
record TransactionRecord(
                @Id Long id,
                @NotNull
                /** Business datetime */
                Instant occurred,
                @NotNull
                /** System datetime */
                Instant noticed,
                Set<EntryRecord> entries) {
}

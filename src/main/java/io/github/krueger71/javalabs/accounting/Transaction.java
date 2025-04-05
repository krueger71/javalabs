package io.github.krueger71.javalabs.accounting;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;

record Transaction(
                @Id Long id,
                @NotNull
                /** Business datetime */
                Instant occurred,
                @NotNull
                /** System datetime */
                Instant noticed,
                Set<Entry> entries) {
}

package io.github.krueger71.javalabs.accounting;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Table("ACCOUNT")
record AccountRecord(@Id Long number, String name, @Version Long version, Set<EntryRecord> entries) {
}

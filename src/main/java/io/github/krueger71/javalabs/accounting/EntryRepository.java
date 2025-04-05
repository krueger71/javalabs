package io.github.krueger71.javalabs.accounting;

import org.springframework.data.repository.ListCrudRepository;

public interface EntryRepository extends ListCrudRepository<Entry, Long> {

}

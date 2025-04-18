package io.github.krueger71.javalabs.accounting;

import org.springframework.data.repository.ListCrudRepository;

interface AccountRepository extends ListCrudRepository<AccountRecord, Long> {
}

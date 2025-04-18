package io.github.krueger71.javalabs.accounting;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@DataJdbcTest
class PersistenceTests {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    EntryRepository entryRepository;

    @Test
    void account() {
        final long number = 1250L;
        final String name = "Computers";

        assertEquals(0, accountRepository.count());
        var account = assertDoesNotThrow(() -> accountRepository.save(new AccountRecord(number, name, null, null)));
        assertEquals(1, accountRepository.count());
        assertEquals(number, account.number());
        assertEquals(name, account.name());
        assertNotNull(account.version());
    }

    @Test
    void transaction() {
        final var instant = Instant.now();
        assertEquals(0, transactionRepository.count());
        var transaction = assertDoesNotThrow(() -> transactionRepository.save(new TransactionRecord(null, instant,
                instant, null)));
        assertEquals(1, transactionRepository.count());
        var id = transaction.id();
        assertNotNull(transaction.id());

        transaction = transactionRepository.findById(id).orElseThrow();
        assertEquals(0, transaction.entries().size());
    }

    @Test
    void entry() {
        final var instant = Instant.now();
        var account = assertDoesNotThrow(() -> accountRepository.save(new AccountRecord(1234L, "Account", null, null)));
        var transaction = assertDoesNotThrow(
                () -> transactionRepository.save(new TransactionRecord(null, instant, instant, null)));

        transaction = transactionRepository.findById(transaction.id()).orElseThrow();
        transaction.entries()
                .add(new EntryRecord(null, AggregateReference.to(account.number()),
                        AggregateReference.to(transaction.id()),
                        new BigDecimal("123.45")));
        transaction.entries()
                .add(new EntryRecord(null, AggregateReference.to(account.number()),
                        AggregateReference.to(transaction.id()),
                        new BigDecimal("-123.45")));
        transaction = transactionRepository.save(transaction);
        assertEquals(2, entryRepository.count());
    }
}

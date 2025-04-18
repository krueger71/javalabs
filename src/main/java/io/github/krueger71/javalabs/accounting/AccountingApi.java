package io.github.krueger71.javalabs.accounting;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class AccountingApi {
    final AccountRepository accountRepository;

    AccountingApi(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    ResponseEntity<List<AccountModel>> getAccounts() {
        var response = new ResponseEntity<>(accountRepository.findAll().stream().map(AccountModel::of).toList(),
                HttpStatusCode.valueOf(200));
        return response;
    }

    static record AccountModel(Long number, String name, Long version, BigDecimal balance) {
        static AccountModel of(AccountRecord accountRecord) {
            return new AccountModel(accountRecord.number(), accountRecord.name(), accountRecord.version(),
                    BigDecimal.ZERO);
        }

        static AccountRecord to(AccountModel accountModel) {
            return new AccountRecord(accountModel.number(), accountModel.name(), accountModel.version(), null);
        }
    }
}

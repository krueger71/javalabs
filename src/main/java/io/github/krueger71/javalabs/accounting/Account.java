package io.github.krueger71.javalabs.accounting;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
class Account {
    @Id
    Long number;
    String name;
}

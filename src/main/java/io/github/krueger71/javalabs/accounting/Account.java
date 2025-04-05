package io.github.krueger71.javalabs.accounting;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

record Account(@Id Long number, String name, @Version Long version, Set<Entry> entries) {
}

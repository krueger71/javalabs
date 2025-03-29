package krueger71.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
class Test {
    @Id
    Integer id;
    String name;
}

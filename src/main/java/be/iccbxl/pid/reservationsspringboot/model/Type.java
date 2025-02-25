package be.iccbxl.pid.reservationsspringboot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Entity
@Table(name="types")
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;
}



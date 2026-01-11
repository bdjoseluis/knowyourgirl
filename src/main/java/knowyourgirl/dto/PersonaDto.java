package knowyourgirl.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class PersonaDto {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private Integer categoria;
}

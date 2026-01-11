package knowyourgirl.modelo.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private int idGrupo;

    private String nombre;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonManagedReference // La parte "padre"
    private List<Persona> personas;

    // CONSTRUCTORES
    public Grupo() {}

    // GETTERS Y SETTERS (Escríbelos tal cual)
    public int getIdGrupo() { return idGrupo; }
    public void setIdGrupo(int idGrupo) { this.idGrupo = idGrupo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Persona> getPersonas() { return personas; }
    public void setPersonas(List<Persona> personas) { this.personas = personas; }
}
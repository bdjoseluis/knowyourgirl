package knowyourgirl.modelo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;

    private String nombre;
    private String descripcion;
    private int edad;
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference // La parte "hija" que se oculta en el JSON
    private Grupo grupo;

    // CONSTRUCTOR VACÍO (Obligatorio para JPA)
    public Persona() {}

    // GETTERS Y SETTERS MANUALES
    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    // ESTE ES EL QUE TE ESTÁ DANDO ERROR
    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
}
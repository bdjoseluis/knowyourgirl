package knowyourgirl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import knowyourgirl.modelo.entities.Grupo;
import knowyourgirl.modelo.entities.Persona;


// Repositorio para Persona
public interface PersonaRepository extends JpaRepository<Persona, Integer> {}
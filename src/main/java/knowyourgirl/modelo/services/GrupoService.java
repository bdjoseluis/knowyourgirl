package knowyourgirl.modelo.services;

import knowyourgirl.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import knowyourgirl.modelo.entities.Grupo;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> obtenerTodos() {
        return grupoRepository.findAll();
    }

    public Grupo obtenerPorId(int id) {
        return grupoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Grupo guardarGrupo(Grupo grupo) {
        if (grupo.getPersonas() != null) {
            grupo.getPersonas().forEach(persona -> persona.setGrupo(grupo));
        }
        return grupoRepository.save(grupo);
    }

    @Transactional
    public void eliminarGrupo(int id) {
        grupoRepository.deleteById(id);
    }
}
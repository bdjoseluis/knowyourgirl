package knowyourgirl.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import knowyourgirl.modelo.entities.Grupo;
import knowyourgirl.modelo.services.GrupoService;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    // LISTAR TODOS LOS GRUPOS
    @GetMapping
    public List<Grupo> listarTodos() {
        return grupoService.obtenerTodos();
    }

    // OBTENER UNO POR ID (Opcional, pero útil)
    @GetMapping("/{id}")
    public Grupo obtenerPorId(@PathVariable int id) {
        return grupoService.obtenerPorId(id);
    }

    // CREAR O ACTUALIZAR
    // Spring Boot sabe que si el JSON lleva un 'idGrupo' que ya existe, debe actualizarlo
    @PostMapping
    public Grupo guardarGrupo(@RequestBody Grupo grupo) {
        return grupoService.guardarGrupo(grupo);
    }

    // ELIMINAR GRUPO
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        grupoService.eliminarGrupo(id);
    }
}
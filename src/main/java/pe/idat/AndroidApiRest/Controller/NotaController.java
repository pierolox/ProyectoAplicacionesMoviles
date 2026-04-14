package pe.idat.AndroidApiRest.Controller;

import org.springframework.web.bind.annotation.*;
import pe.idat.AndroidApiRest.Model.Nota;
import pe.idat.AndroidApiRest.Repository.NotaRepository;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Nota> getByUsuario(@PathVariable Long usuarioId) {
        return notaRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Nota create(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notaRepository.deleteById(id);
    }
}
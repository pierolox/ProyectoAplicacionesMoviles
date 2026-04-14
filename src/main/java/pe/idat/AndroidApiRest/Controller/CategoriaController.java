package pe.idat.AndroidApiRest.Controller;

import org.springframework.web.bind.annotation.*;
import pe.idat.AndroidApiRest.Model.Categoria;
import pe.idat.AndroidApiRest.Repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Categoria> getByUsuario(@PathVariable Long usuarioId) {
        return categoriaRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
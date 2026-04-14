package pe.idat.AndroidApiRest.Controller;

import org.springframework.web.bind.annotation.*;
import pe.idat.AndroidApiRest.Model.Habito;
import pe.idat.AndroidApiRest.Repository.HabitoRepository;

import java.util.List;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    private final HabitoRepository habitoRepository;

    public HabitoController(HabitoRepository habitoRepository) {
        this.habitoRepository = habitoRepository;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Habito> getByUsuario(@PathVariable Long usuarioId) {
        return habitoRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Habito create(@RequestBody Habito habito) {
        return habitoRepository.save(habito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        habitoRepository.deleteById(id);
    }
}
package pe.idat.AndroidApiRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.AndroidApiRest.Model.Habito;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
    List<Habito> findByUsuarioId(Long usuarioId);
}
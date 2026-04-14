package pe.idat.AndroidApiRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.AndroidApiRest.Model.Nota;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId);
}
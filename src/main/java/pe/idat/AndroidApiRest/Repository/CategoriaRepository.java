package pe.idat.AndroidApiRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.AndroidApiRest.Model.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByUsuarioId(Long usuarioId);
}
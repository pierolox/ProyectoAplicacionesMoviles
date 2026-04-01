package pe.idat.AndroidApiRest.Repository;

import pe.idat.AndroidApiRest.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
}


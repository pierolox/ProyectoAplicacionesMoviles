package pe.idat.AndroidApiRest.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "habito")
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "categoria_id")
    private Long categoriaId;

    @Column(name = "usuario_id")
    private Long usuarioId;
}
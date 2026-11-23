package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "correo", nullable = false, length = 150)
    private String correo;
    @Column(name = "clave", nullable = false, length = 255)
    private String clave;
    @Column(name = "rol", nullable = false, length = 30)
    private String rol;
}
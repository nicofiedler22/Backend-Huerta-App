package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "validaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tarea_id", nullable = false)
    private Long tareaId;
    @Column(name = "validador_id", nullable = false)
    private Long validadorId;
    @Column(name = "resultado", nullable = false, length = 30)
    private String resultado;
    @Column(name = "motivo", nullable = false, columnDefinition = "TEXT")
    private String motivo;
    @Column(name = "fecha", nullable = false, length = 30)
    private String fecha;
}
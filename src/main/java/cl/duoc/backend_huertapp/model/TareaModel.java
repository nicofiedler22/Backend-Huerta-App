package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaModel {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(name = "fecha_programada", nullable = false)
    private LocalDate fechaProgramada;

    @Column(name = "huerto_id", nullable = false)
    private Long huertoId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE";
        }
    }
}

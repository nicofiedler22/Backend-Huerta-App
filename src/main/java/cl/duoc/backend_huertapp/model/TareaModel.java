package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sector_id", nullable = false)
    private Long sectorId;
    @Column(name = "responsable_id", nullable = false)
    private Long responsableId;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name = "fecha_programada", nullable = false, length = 20)
    private String fechaProgramada;
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Column(name = "comentarios_estudiante", nullable = false, columnDefinition = "TEXT")
    private String comentariosEstudiante;
}
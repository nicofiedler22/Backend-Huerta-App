package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evidencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvidenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tarea_id", nullable = false)
    private Long tareaId;
    @Column(name = "ruta_foto", nullable = false, length = 1000)
    private String rutaFoto;
    @Column(name = "fecha", nullable = false, length = 30)
    private String fecha;
}
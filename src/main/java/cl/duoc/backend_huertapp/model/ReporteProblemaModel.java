package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reportes_problema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteProblemaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sector_id", nullable = false)
    private Long sectorId;
    @Column(name = "cultivo_id", nullable = true)
    private Long cultivoId;
    @Column(name = "reportante_id", nullable = false)
    private Long reportanteId;
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "fecha", nullable = false, length = 30)
    private String fecha;
    @Column(name = "estado_atencion", nullable = false, length = 30)
    private String estadoAtencion;
    @Column(name = "foto_ruta", nullable = false, length = 1000)
    private String fotoRuta;
}
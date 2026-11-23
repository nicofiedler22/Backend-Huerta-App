package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cultivos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CultivoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sector_id", nullable = false)
    private Long sectorId;
    @Column(name = "nombre_cultivo", nullable = false, length = 100)
    private String nombreCultivo;
    @Column(name = "fecha_siembra", nullable = false, length = 20)
    private String fechaSiembra;
    @Column(name = "fecha_cosecha_estimada", nullable = false, length = 20)
    private String fechaCosechaEstimada;
    @Column(name = "estado_desarrollo", nullable = false, length = 50)
    private String estadoDesarrollo;
    @Column(name = "frecuencia_riego_dias", nullable = false)
    private Integer frecuenciaRiegoDias;
}
package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sectores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "ubicacion", nullable = false, length = 255)
    private String ubicacion;
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "estado", nullable = false, length = 30)
    private String estado;
}
package cl.duoc.backend_huertapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "huertos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuertoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String ubicacion;

    @Column(name = "tipo_cultivo", length = 50)
    private String tipoCultivo;

    @Column(name = "area_m2")
    private Double areaM2;

    @Column(nullable = false, length = 20)
    private String estado; 

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "ACTIVO";
        }
    }
}
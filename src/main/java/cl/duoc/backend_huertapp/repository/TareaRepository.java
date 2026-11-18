package cl.duoc.backend_huertapp.repository;

import cl.duoc.backend_huertapp.model.TareaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<TareaModel, Long> {

    List<TareaModel> findByHuertoId(Long huertoId);

    List<TareaModel> findByUsuarioId(Long usuarioId);

    List<TareaModel> findByHuertoIdAndEstado(Long huertoId, String estado);
}
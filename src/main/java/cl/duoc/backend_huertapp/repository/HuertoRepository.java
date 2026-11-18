package cl.duoc.backend_huertapp.repository;

import cl.duoc.backend_huertapp.model.HuertoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HuertoRepository extends JpaRepository<HuertoModel, Long> {
    
    List<HuertoModel> findByUsuarioId(Long usuarioId);
}
package cl.duoc.backend_huertapp.repository;
import cl.duoc.backend_huertapp.model.TareaModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TareaRepository extends JpaRepository<TareaModel, Long> {}

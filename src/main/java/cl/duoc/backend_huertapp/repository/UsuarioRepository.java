package cl.duoc.backend_huertapp.repository;
import cl.duoc.backend_huertapp.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {}

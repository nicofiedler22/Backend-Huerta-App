package cl.duoc.backend_huertapp.service;

import cl.duoc.backend_huertapp.model.UsuarioModel;
import cl.duoc.backend_huertapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<UsuarioModel> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel actualizarUsuario(Long id, UsuarioModel datosNuevos) {
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuarioExistente.setNombre(datosNuevos.getNombre());
        usuarioExistente.setEmail(datosNuevos.getEmail());
        usuarioExistente.setRol(datosNuevos.getRol());
        
        if (datosNuevos.getPassword() != null && !datosNuevos.getPassword().isEmpty()) {
            usuarioExistente.setPassword(datosNuevos.getPassword());
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
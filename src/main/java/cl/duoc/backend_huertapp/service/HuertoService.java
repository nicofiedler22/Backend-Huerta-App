package cl.duoc.backend_huertapp.service;

import cl.duoc.backend_huertapp.model.HuertoModel;
import cl.duoc.backend_huertapp.repository.HuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuertoService {

    @Autowired
    private HuertoRepository huertoRepository;

    public List<HuertoModel> obtenerTodos() {
        return huertoRepository.findAll();
    }

    public Optional<HuertoModel> obtenerPorId(Long id) {
        return huertoRepository.findById(id);
    }

    public List<HuertoModel> obtenerPorUsuarioId(Long usuarioId) {
        return huertoRepository.findByUsuarioId(usuarioId);
    }

    public HuertoModel guardarHuerto(HuertoModel huerto) {
        if (huerto.getUsuarioId() == null) {
            throw new RuntimeException("El huerto debe estar asociado a un usuarioId");
        }
        return huertoRepository.save(huerto);
    }

    public HuertoModel actualizarHuerto(Long id, HuertoModel datosNuevos) {
        HuertoModel huertoExistente = huertoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Huerto no encontrado con ID: " + id));

        huertoExistente.setNombre(datosNuevos.getNombre());
        huertoExistente.setUbicacion(datosNuevos.getUbicacion());
        huertoExistente.setTipoCultivo(datosNuevos.getTipoCultivo());
        huertoExistente.setAreaM2(datosNuevos.getAreaM2());
        huertoExistente.setEstado(datosNuevos.getEstado());

        return huertoRepository.save(huertoExistente);
    }

    public void eliminarHuerto(Long id) {
        if (!huertoRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, huerto no encontrado con ID: " + id);
        }
        huertoRepository.deleteById(id);
    }
}
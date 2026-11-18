package cl.duoc.backend_huertapp.service;

import cl.duoc.backend_huertapp.model.TareaModel;
import cl.duoc.backend_huertapp.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<TareaModel> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Optional<TareaModel> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public List<TareaModel> obtenerPorHuertoId(Long huertoId) {
        return tareaRepository.findByHuertoId(huertoId);
    }

    public List<TareaModel> obtenerPorUsuarioId(Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

    public List<TareaModel> obtenerPendientesPorHuerto(Long huertoId) {
        return tareaRepository.findByHuertoIdAndEstado(huertoId, "PENDIENTE");
    }

    public TareaModel guardarTarea(TareaModel tarea) {
        if (tarea.getHuertoId() == null) {
            throw new RuntimeException("La tarea debe pertenecer a un huertoId");
        }
        return tareaRepository.save(tarea);
    }

    public TareaModel actualizarTarea(Long id, TareaModel datosNuevos) {
        TareaModel tareaExistente = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        tareaExistente.setTitulo(datosNuevos.getTitulo());
        tareaExistente.setDescripcion(datosNuevos.getDescripcion());
        tareaExistente.setTipo(datosNuevos.getTipo());
        tareaExistente.setEstado(datosNuevos.getEstado());
        tareaExistente.setFechaProgramada(datosNuevos.getFechaProgramada());
        tareaExistente.setUsuarioId(datosNuevos.getUsuarioId());

        return tareaRepository.save(tareaExistente);
    }

    public TareaModel marcarComoCompletada(Long id) {
        TareaModel tareaExistente = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        tareaExistente.setEstado("COMPLETADA");
        return tareaRepository.save(tareaExistente);
    }

    public void eliminarTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, tarea no encontrada con ID: " + id);
        }
        tareaRepository.deleteById(id);
    }
}
package cl.duoc.backend_huertapp.controller;

import cl.duoc.backend_huertapp.model.TareaModel;
import cl.duoc.backend_huertapp.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<TareaModel>> listarTodas() {
        return ResponseEntity.ok(tareaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaModel> obtenerPorId(@PathVariable Long id) {
        return tareaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ej: GET /api/tareas/huerto/1
    @GetMapping("/huerto/{huertoId}")
    public ResponseEntity<List<TareaModel>> listarPorHuerto(@PathVariable Long huertoId) {
        return ResponseEntity.ok(tareaService.obtenerPorHuertoId(huertoId));
    }

    // Ej: GET /api/tareas/huerto/1/pendientes
    @GetMapping("/huerto/{huertoId}/pendientes")
    public ResponseEntity<List<TareaModel>> listarPendientesPorHuerto(@PathVariable Long huertoId) {
        return ResponseEntity.ok(tareaService.obtenerPendientesPorHuerto(huertoId));
    }

    // Ej: GET /api/tareas/usuario/1
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TareaModel>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(tareaService.obtenerPorUsuarioId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<?> crearTarea(@RequestBody TareaModel tarea) {
        try {
            TareaModel nueva = tareaService.guardarTarea(tarea);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTarea(@PathVariable Long id, @RequestBody TareaModel tarea) {
        try {
            TareaModel actualizada = tareaService.actualizarTarea(id, tarea);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Ej: PATCH /api/tareas/5/completar
    @PatchMapping("/{id}/completar")
    public ResponseEntity<?> completarTarea(@PathVariable Long id) {
        try {
            TareaModel completada = tareaService.marcarComoCompletada(id);
            return ResponseEntity.ok(completada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        try {
            tareaService.eliminarTarea(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
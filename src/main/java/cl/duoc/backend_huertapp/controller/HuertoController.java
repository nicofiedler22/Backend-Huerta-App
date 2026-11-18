package cl.duoc.backend_huertapp.controller;

import cl.duoc.backend_huertapp.model.HuertoModel;
import cl.duoc.backend_huertapp.service.HuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/huertos")
@CrossOrigin(origins = "*")
public class HuertoController {

    @Autowired
    private HuertoService huertoService;

    @GetMapping
    public ResponseEntity<List<HuertoModel>> listarTodos() {
        return ResponseEntity.ok(huertoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuertoModel> obtenerPorId(@PathVariable Long id) {
        return huertoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HuertoModel>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(huertoService.obtenerPorUsuarioId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<?> crearHuerto(@RequestBody HuertoModel huerto) {
        try {
            HuertoModel nuevo = huertoService.guardarHuerto(huerto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarHuerto(@PathVariable Long id, @RequestBody HuertoModel huerto) {
        try {
            HuertoModel actualizado = huertoService.actualizarHuerto(id, huerto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHuerto(@PathVariable Long id) {
        try {
            huertoService.eliminarHuerto(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
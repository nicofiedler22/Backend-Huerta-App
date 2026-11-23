package cl.duoc.backend_huertapp.controller;

import cl.duoc.backend_huertapp.model.*;
import cl.duoc.backend_huertapp.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HuertAppApiController {
    private final UsuarioRepository usuarios;
    private final SectorRepository sectores;
    private final CultivoRepository cultivos;
    private final TareaRepository tareas;
    private final ValidacionRepository validaciones;
    private final EvidenciaRepository evidencias;
    private final ReporteProblemaRepository reportes;

    public HuertAppApiController(UsuarioRepository usuarios, SectorRepository sectores,
        CultivoRepository cultivos, TareaRepository tareas, ValidacionRepository validaciones,
        EvidenciaRepository evidencias, ReporteProblemaRepository reportes) {
        this.usuarios=usuarios; this.sectores=sectores; this.cultivos=cultivos; this.tareas=tareas;
        this.validaciones=validaciones; this.evidencias=evidencias; this.reportes=reportes;
    }

    @GetMapping("/usuarios") public List<UsuarioModel> usuarios(){ return usuarios.findAll(); }
    @GetMapping("/usuarios/{id}") public ResponseEntity<UsuarioModel> usuario(@PathVariable Long id){ return usuarios.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); }
    @PostMapping("/usuarios") public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(usuarios.save(x)); }
    @PutMapping("/usuarios/{id}") public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable Long id,@RequestBody UsuarioModel x){ return usuarios.findById(id).map(old->{x.setId(id);return ResponseEntity.ok(usuarios.save(x));}).orElseGet(()->ResponseEntity.notFound().build()); }
    @DeleteMapping("/usuarios/{id}") public ResponseEntity<Void> borrarUsuario(@PathVariable Long id){ if(!usuarios.existsById(id))return ResponseEntity.notFound().build(); usuarios.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/sectores") public List<SectorModel> sectores(){ return sectores.findAll(); }
    @GetMapping("/sectores/{id}") public ResponseEntity<SectorModel> sector(@PathVariable Long id){ return sectores.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); }
    @PostMapping("/sectores") public ResponseEntity<SectorModel> crearSector(@RequestBody SectorModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(sectores.save(x)); }
    @PutMapping("/sectores/{id}") public ResponseEntity<SectorModel> actualizarSector(@PathVariable Long id,@RequestBody SectorModel x){ return sectores.findById(id).map(old->{x.setId(id);return ResponseEntity.ok(sectores.save(x));}).orElseGet(()->ResponseEntity.notFound().build()); }
    @DeleteMapping("/sectores/{id}") public ResponseEntity<Void> borrarSector(@PathVariable Long id){ if(!sectores.existsById(id))return ResponseEntity.notFound().build(); sectores.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/cultivos") public List<CultivoModel> cultivos(){ return cultivos.findAll(); }
    @GetMapping("/cultivos/{id}") public ResponseEntity<CultivoModel> cultivo(@PathVariable Long id){ return cultivos.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); }
    @PostMapping("/cultivos") public ResponseEntity<CultivoModel> crearCultivo(@RequestBody CultivoModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(cultivos.save(x)); }
    @PutMapping("/cultivos/{id}") public ResponseEntity<CultivoModel> actualizarCultivo(@PathVariable Long id,@RequestBody CultivoModel x){ return cultivos.findById(id).map(old->{x.setId(id);return ResponseEntity.ok(cultivos.save(x));}).orElseGet(()->ResponseEntity.notFound().build()); }
    @DeleteMapping("/cultivos/{id}") public ResponseEntity<Void> borrarCultivo(@PathVariable Long id){ if(!cultivos.existsById(id))return ResponseEntity.notFound().build(); cultivos.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/tareas") public List<TareaModel> tareas(){ return tareas.findAll(); }
    @GetMapping("/tareas/{id}") public ResponseEntity<TareaModel> tarea(@PathVariable Long id){ return tareas.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); }
    @PostMapping("/tareas") public ResponseEntity<TareaModel> crearTarea(@RequestBody TareaModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(tareas.save(x)); }
    @PutMapping("/tareas/{id}") public ResponseEntity<TareaModel> actualizarTarea(@PathVariable Long id,@RequestBody TareaModel x){ return tareas.findById(id).map(old->{x.setId(id);return ResponseEntity.ok(tareas.save(x));}).orElseGet(()->ResponseEntity.notFound().build()); }
    @DeleteMapping("/tareas/{id}") public ResponseEntity<Void> borrarTarea(@PathVariable Long id){ if(!tareas.existsById(id))return ResponseEntity.notFound().build(); tareas.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/validaciones") public List<ValidacionModel> validaciones(){ return validaciones.findAll(); }
    @PostMapping("/validaciones") public ResponseEntity<ValidacionModel> crearValidacion(@RequestBody ValidacionModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(validaciones.save(x)); }
    @GetMapping("/evidencias") public List<EvidenciaModel> evidencias(){ return evidencias.findAll(); }
    @PostMapping("/evidencias") public ResponseEntity<EvidenciaModel> crearEvidencia(@RequestBody EvidenciaModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(evidencias.save(x)); }
    @GetMapping("/reportes") public List<ReporteProblemaModel> reportes(){ return reportes.findAll(); }
    @PostMapping("/reportes") public ResponseEntity<ReporteProblemaModel> crearReporte(@RequestBody ReporteProblemaModel x){ x.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(reportes.save(x)); }
    @PutMapping("/reportes/{id}") public ResponseEntity<ReporteProblemaModel> actualizarReporte(@PathVariable Long id,@RequestBody ReporteProblemaModel x){ return reportes.findById(id).map(old->{x.setId(id);return ResponseEntity.ok(reportes.save(x));}).orElseGet(()->ResponseEntity.notFound().build()); }
}

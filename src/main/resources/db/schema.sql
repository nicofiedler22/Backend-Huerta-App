CREATE TABLE IF NOT EXISTS usuarios (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL,
 correo VARCHAR(150) NOT NULL UNIQUE, clave VARCHAR(255) NOT NULL, rol VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS sectores (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL,
 ubicacion VARCHAR(255) NOT NULL, descripcion TEXT, estado VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS cultivos (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, sector_id BIGINT NOT NULL,
 nombre_cultivo VARCHAR(100) NOT NULL, fecha_siembra VARCHAR(20) NOT NULL,
 fecha_cosecha_estimada VARCHAR(20) NOT NULL, estado_desarrollo VARCHAR(50) NOT NULL,
 frecuencia_riego_dias INT NOT NULL,
 CONSTRAINT fk_cultivo_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS tareas (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, sector_id BIGINT NOT NULL, responsable_id BIGINT NOT NULL,
 titulo VARCHAR(100) NOT NULL, descripcion VARCHAR(500), tipo VARCHAR(50) NOT NULL,
 fecha_programada VARCHAR(20) NOT NULL, estado VARCHAR(50) NOT NULL,
 comentarios_estudiante TEXT,
 CONSTRAINT fk_tarea_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE,
 CONSTRAINT fk_tarea_responsable FOREIGN KEY (responsable_id) REFERENCES usuarios(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS validaciones (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, tarea_id BIGINT NOT NULL, validador_id BIGINT NOT NULL,
 resultado VARCHAR(30) NOT NULL, motivo TEXT, fecha VARCHAR(30) NOT NULL,
 CONSTRAINT fk_validacion_tarea FOREIGN KEY (tarea_id) REFERENCES tareas(id) ON DELETE CASCADE,
 CONSTRAINT fk_validacion_usuario FOREIGN KEY (validador_id) REFERENCES usuarios(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS evidencias (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, tarea_id BIGINT NOT NULL, ruta_foto VARCHAR(1000),
 fecha VARCHAR(30) NOT NULL,
 CONSTRAINT fk_evidencia_tarea FOREIGN KEY (tarea_id) REFERENCES tareas(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS reportes_problema (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, sector_id BIGINT NOT NULL, cultivo_id BIGINT NULL,
 reportante_id BIGINT NOT NULL, descripcion TEXT NOT NULL, fecha VARCHAR(30) NOT NULL,
 estado_atencion VARCHAR(30) NOT NULL, foto_ruta VARCHAR(1000),
 CONSTRAINT fk_reporte_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE,
 CONSTRAINT fk_reporte_cultivo FOREIGN KEY (cultivo_id) REFERENCES cultivos(id) ON DELETE SET NULL,
 CONSTRAINT fk_reporte_usuario FOREIGN KEY (reportante_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

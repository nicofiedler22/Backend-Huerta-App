-- 1. Tabla de Usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL -- Ej: 'ADMINISTRADOR', 'COLABORADOR'
);

-- 2. Tabla de Sectores (o Huertos según tu HuertoModel)
CREATE TABLE sectores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    ubicacion VARCHAR(150)
);

-- 3. Tabla de Cultivos
CREATE TABLE cultivos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_siembra DATE NOT NULL,
    cosecha_estimada DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    frecuencia_riego INT NOT NULL, -- en días
    sector_id BIGINT NOT NULL,
    CONSTRAINT fk_cultivo_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE
);

-- 4. Tabla de Tareas
CREATE TABLE tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT,
    tipo VARCHAR(50) NOT NULL, -- Ej: 'RIEGO', 'SIEMBRA', 'MANTENIMIENTO', 'OBSERVACION'
    estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE', -- PENDIENTE, EN_DESARROLLO, PENDIENTE_VALIDACION, VALIDADA, RECHAZADA
    fecha_asignacion DATE NOT NULL,
    fecha_limite DATE NOT NULL,
    sector_id BIGINT NOT NULL,
    responsable_id BIGINT NOT NULL,
    CONSTRAINT fk_tarea_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE,
    CONSTRAINT fk_tarea_responsable FOREIGN KEY (responsable_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 5. Tabla de Evidencias (Entregas de estudiantes)
CREATE TABLE evidencias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comentario TEXT,
    foto_url VARCHAR(500),
    fecha_entrega DATETIME DEFAULT CURRENT_TIMESTAMP,
    tarea_id BIGINT NOT NULL,
    CONSTRAINT fk_evidencia_tarea FOREIGN KEY (tarea_id) REFERENCES tareas(id) ON DELETE CASCADE
);

-- 6. Tabla de Validaciones (Aprobación o rechazo del docente)
CREATE TABLE validaciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    aprobada BOOLEAN NOT NULL,
    motivo_rechazo TEXT,
    fecha_validacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    tarea_id BIGINT NOT NULL,
    validador_id BIGINT NOT NULL,
    CONSTRAINT fk_validacion_tarea FOREIGN KEY (tarea_id) REFERENCES tareas(id) ON DELETE CASCADE,
    CONSTRAINT fk_validacion_usuario FOREIGN KEY (validador_id) REFERENCES usuarios(id)
);

-- 7. Tabla de Reportes de Problemas
CREATE TABLE reportes_problemas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    foto_url VARCHAR(500),
    estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
    fecha_reporte DATETIME DEFAULT CURRENT_TIMESTAMP,
    sector_id BIGINT NOT NULL,
    cultivo_id BIGINT NULL, -- Opcional según tu README
    reportante_id BIGINT NOT NULL,
    CONSTRAINT fk_reporte_sector FOREIGN KEY (sector_id) REFERENCES sectores(id) ON DELETE CASCADE,
    CONSTRAINT fk_reporte_cultivo FOREIGN KEY (cultivo_id) REFERENCES cultivos(id) ON DELETE SET NULL,
    CONSTRAINT fk_reporte_usuario FOREIGN KEY (reportante_id) REFERENCES usuarios(id)
);

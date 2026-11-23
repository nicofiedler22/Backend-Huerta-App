INSERT IGNORE INTO usuarios (id,nombre,correo,clave,rol) VALUES
(1,'Profesor Nicolás Fiedler','docente@huerto.cl','admin123','Administrador'),
(2,'Martina Cerón','estudiante1@huerto.cl','1234','Colaborador'),
(3,'Manuel Silva','estudiante2@huerto.cl','1234','Colaborador'),
(4,'Valeska Silva','estudiante3@huerto.cl','1234','Colaborador');
INSERT IGNORE INTO sectores (id,nombre,ubicacion,descripcion,estado) VALUES
(1,'Huerto Norte','Patio principal','Hortalizas de hoja y raíz','Activo'),
(2,'Invernadero','Costado del gimnasio','Tomates y pimentones','Activo'),
(3,'Jardín de hierbas','Entrada del colegio','Hierbas aromáticas','En descanso');

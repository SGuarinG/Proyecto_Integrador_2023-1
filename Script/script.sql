create database acreditacionpi;
use acreditacionpi;

create table usuarios(
id int not null auto_increment,
nombre varchar(50) not null,
contraseña varchar(50) not null,
primary key(id)
);

create table roles(
id int not null auto_increment,
nombre varchar(30) not null,
primary key(id)
);

create table usuarios_roles(
id int not null auto_increment,
id_usuarios int not null,
id_roles int not null,
primary key(id),
foreign key(id_usuarios) references usuarios(id),
foreign key(id_roles) references roles(id)
);

create table factores(
id int not null auto_increment, 
nombre varchar(50) not null,
id_usuarios int not null,
primary key(id),
foreign key(id_usuarios) references usuarios(id)
); 

create table caracteristicas(
id int not null auto_increment, 
nombre varchar (50) not null, 
id_factor int not null, 
primary key (id), 
foreign key (id_factor) references factores(id)
);  

create table calificacion_caracteristicas(
id int not null auto_increment, 
id_caracteristicas int not null, 
nota float not null,
primary key (id), 
foreign key (id_caracteristicas) references caracteristicas(id)
);  

create table aspectos(
id int not null auto_increment,
descripcion text not null,
id_caracteristicas int not null,
primary key (id),
foreign key(id_caracteristicas) references caracteristicas(id)
);

create table encuestas(
id int not null auto_increment,
caracter varchar(30) not null,
id_aspectos int not null,
primary key(id),
foreign key(id_aspectos) references aspectos(id)
);

create table preguntas(
id int not null auto_increment,
pregunta text not null,
id_encuesta int not null,
primary key(id),
foreign key(id_encuesta) references encuestas(id)
);

create table notas(
id int not null auto_increment,
nota float not null,
fecha date not null,
id_preguntas int not null,
primary key (id),
foreign key (id_preguntas) references preguntas(id)
);

insert into usuarios(nombre, contraseña) values('admin','123');
select * from usuarios;
insert into roles(nombre) values('Administrador');
insert into roles(nombre) values('Estudiante');
select * from roles;

insert into usuarios_roles(id_usuarios,id_roles) values(1,1);
select * from usuarios_roles;

insert into factores(nombre,id_usuarios) values('Factor 1', 1);
insert into factores(nombre,id_usuarios) values('Factor 2', 1);
insert into factores(nombre,id_usuarios) values('Factor 3', 1);
insert into factores(nombre,id_usuarios) values('Factor 4', 1);
insert into factores(nombre,id_usuarios) values('Factor 5', 1);
insert into factores(nombre,id_usuarios) values('Factor 6', 1);
insert into factores(nombre,id_usuarios) values('Factor 7', 1);
insert into factores(nombre,id_usuarios) values('Factor 8', 1);
insert into factores(nombre,id_usuarios) values('Factor 9', 1);
insert into factores(nombre,id_usuarios) values('Factor 10', 1);
insert into factores(nombre,id_usuarios) values('Factor 11', 1);
insert into factores(nombre,id_usuarios) values('Factor 12', 1);
select * from factores;

insert into caracteristicas(nombre,id_factor) values('Caracteristica 47', 12);
insert into caracteristicas(nombre,id_factor) values('Caracteristica 48', 12);
select * from caracteristicas;

insert into aspectos(descripcion,id_caracteristicas) values('Aspecto 101 Existencia de aulas, laboratorios, talleres, simuladores, plataformas tecnológicas, bibliotecas, etc. Para el cumplimiento de las funciones sustantivas del Programa.', 1);
insert into aspectos(descripcion,id_caracteristicas) values('Aspecto 102 Evidencia de planes y proyectos realizados o en ejecución, para la conservación, expansión, mejoras y mantenimiento de la planta física del Programa.', 1);
insert into aspectos(descripcion,id_caracteristicas) values('Aspecto 103 Evidencia de la coherencia entre recursos informáticos y de comunicación con las necesidades del Programa en su lugar de desarrollo y escenarios de práctica.', 2);
insert into aspectos(descripcion,id_caracteristicas) values('Aspecto 104 Apreciación de directivos, profesores y estudiantes sobre pertinencia, correspondencia y suficiencia de los recursos informáticos y de comunicación.', 2);

select * from aspectos;

insert into encuestas(caracter,id_aspectos) values('Encuesta 1',1);
insert into encuestas(caracter,id_aspectos) values('Encuesta 2',2);
insert into encuestas(caracter,id_aspectos) values('Encuesta 3',3);
insert into encuestas(caracter,id_aspectos) values('Encuesta 4',4);
select * from encuestas;

insert into preguntas(pregunta,id_encuesta) values('¿En qué medida consideras que el Programa cuenta con aulas equipadas y adecuadas para el desarrollo de las actividades académicas?',1);
insert into preguntas(pregunta,id_encuesta) values('¿Cuál es tu percepción sobre la disponibilidad y calidad de los laboratorios, talleres y simuladores para el aprendizaje práctico en el Programa?',1);
insert into preguntas(pregunta,id_encuesta) values('¿Qué tan accesibles y eficientes consideras las plataformas tecnológicas utilizadas por el Programa para el apoyo y desarrollo de las actividades educativas?',1);
insert into preguntas(pregunta,id_encuesta) values('¿Cuál es tu percepción sobre la implementación de planes y proyectos destinados a la conservación y mantenimiento de la infraestructura del Programa?',2);
insert into preguntas(pregunta,id_encuesta) values('¿En qué medida consideras que se han llevado a cabo proyectos para la expansión y crecimiento de la planta física del Programa?',2);
insert into preguntas(pregunta,id_encuesta) values('¿Cómo evalúas la calidad de las mejoras realizadas en la infraestructura del Programa?',2);
insert into preguntas(pregunta,id_encuesta) values('¿Consideras que la universidad cuenta con los recursos informáticos para desarrollar labores formativas y académicas?',3);
insert into preguntas(pregunta,id_encuesta) values('En una escala del 1 al 5, ¿Cuál sería tu calificación con respecto al estado de los equipos computacionales de la institución?',3);
insert into preguntas(pregunta,id_encuesta) values('¿Las instalaciones de la universidad tienen los medios de comunicación necesarios para la formación a distancia?',3);
insert into preguntas(pregunta,id_encuesta) values('¿Los recursos informáticos y de comunicación disponibles en la institución satisfacen las necesidades académicas?',4);
insert into preguntas(pregunta,id_encuesta) values('¿Los recursos informáticos y de comunicación de la universidad están adaptados a las necesidades y requisitos del programa correspondiente?',4);
insert into preguntas(pregunta,id_encuesta) values('¿Considera que los recursos informáticos y de comunicación disponibles en la institución son pertinentes y de ayuda para el desarrollo de su formación profesional?',4);

select * from preguntas;









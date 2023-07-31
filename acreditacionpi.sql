-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2023 a las 04:28:42
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `acreditacionpi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aspectos`
--

CREATE TABLE `aspectos` (
  `id` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `id_caracteristicas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aspectos`
--

INSERT INTO `aspectos` (`id`, `descripcion`, `id_caracteristicas`) VALUES
(2, 'Aspecto 101 Existencia de aulas, laboratorios, talleres, simuladores, plataformas tecnológicas, bibliotecas, etc. Para el cumplimiento de las funciones sustantivas del Programa.', 1),
(3, 'Aspecto 102 Evidencia de planes y proyectos realizados o en ejecución, para la conservación, expansión, mejoras y mantenimiento de la planta física del Programa.', 1),
(4, 'Aspecto 103 Evidencia de la coherencia entre recursos informáticos y de comunicación con las necesidades del Programa en su lugar de desarrollo y escenarios de práctica.', 2),
(5, 'Aspecto 103  Apreciación de directivos, profesores y estudiantes sobre pertinencia, correspondencia y suficiencia de los recursos informáticos y de comunicación.', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion_caracteristicas`
--

CREATE TABLE `calificacion_caracteristicas` (
  `id` int(11) NOT NULL,
  `caracter` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  `id_caracteristicas` int(11) NOT NULL,
  `comentario` varchar(100) NOT NULL,
  `nota` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristicas`
--

CREATE TABLE `caracteristicas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_factor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caracteristicas`
--

INSERT INTO `caracteristicas` (`id`, `nombre`, `id_factor`) VALUES
(1, 'Caracteristica 47', 12),
(2, 'Caracteristica 48', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestas`
--

CREATE TABLE `encuestas` (
  `id` int(11) NOT NULL,
  `caracter` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  `id_aspectos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `encuestas`
--

INSERT INTO `encuestas` (`id`, `caracter`, `fecha`, `id_aspectos`) VALUES
(1, 'Encuesta 1', '0000-00-00', 2),
(2, 'Encuesta 2', '0000-00-00', 3),
(3, 'Encuesta 3', '0000-00-00', 4),
(4, 'Encuesta 4', '0000-00-00', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factores`
--

CREATE TABLE `factores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_usuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factores`
--

INSERT INTO `factores` (`id`, `nombre`, `id_usuarios`) VALUES
(1, 'Factor 1', 2),
(2, 'Factor 2', 2),
(3, 'Factor 3', 2),
(4, 'Factor 4', 2),
(5, 'Factor 5', 2),
(6, 'Factor 6', 2),
(7, 'Factor 7', 2),
(8, 'Factor 8', 2),
(9, 'Factor 9', 2),
(10, 'Factor 10', 2),
(11, 'Factor 11', 2),
(12, 'Factor 12', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `nota` float NOT NULL,
  `fecha` date NOT NULL,
  `id_preguntas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`id`, `nombre_usuario`, `nota`, `fecha`, `id_preguntas`) VALUES
(1, 'pepe', 2, '2023-05-21', 1),
(2, 'pepe', 2, '2023-05-21', 2),
(3, 'pepe', 2, '2023-05-21', 3),
(4, 'pepe', 2, '2023-05-21', 7),
(5, 'pepe', 2, '2023-05-21', 8),
(6, 'pepe', 2, '2023-05-21', 8),
(7, 'pepe', 2, '2023-05-21', 1),
(8, 'pepe', 4, '2023-05-21', 1),
(9, 'pepe', 3, '2023-05-21', 1),
(10, 'pepe', 3, '2023-05-21', 2),
(11, 'pepe', 5, '2023-05-21', 3),
(12, 'pepe', 3, '2023-05-21', 1),
(13, 'pepe', 4, '2023-05-21', 2),
(14, 'pepe', 2, '2023-05-21', 3),
(15, 'pepe', 4, '2023-05-21', 7),
(16, 'pepe', 3, '2023-05-21', 8),
(17, 'pepe', 5, '2023-05-21', 8),
(18, 'pepe', 2, '2023-05-21', 1),
(19, 'pepe', 2, '2023-05-21', 1),
(20, 'pepe', 2, '2023-05-21', 1),
(21, 'pepe', 2, '2023-05-21', 1),
(22, 'pepe', 3, '2023-05-21', 1),
(23, 'pepe', 4, '2023-05-21', 1),
(24, 'pepe', 1, '2023-05-21', 7),
(25, 'pepe', 3, '2023-05-21', 8),
(26, 'pepe', 2, '2023-05-21', 8),
(27, 'pepe', 2, '2023-05-21', 8),
(28, 'pepe', 3, '2023-05-21', 8),
(29, 'pepe', 2, '2023-05-21', 1),
(30, 'pepe', 2, '2023-05-21', 1),
(31, 'pepe', 2, '2023-05-21', 2),
(32, 'pepe', 0, '2023-05-21', 1),
(33, 'pepe', 0, '2023-05-21', 1),
(34, 'pepe', 0, '2023-05-21', 1),
(35, 'pepe', 2, '2023-05-21', 1),
(36, 'pepe', 2, '2023-05-21', 2),
(37, 'pepe', 5, '2023-05-21', 2),
(38, 'pepe', 5, '2023-05-21', 2),
(39, 'pepe', 3, '2023-05-21', 3),
(40, 'pepe', 2, '2023-05-21', 1),
(41, 'pepe', 3, '2023-05-21', 2),
(42, 'pepe', 5, '2023-05-21', 3),
(43, 'pepe', 2, '2023-05-21', 1),
(44, 'pepe', 4, '2023-05-21', 2),
(45, 'pepe', 1, '2023-05-21', 3),
(46, 'pepe', 3, '2023-05-21', 7),
(47, 'pepe', 4, '2023-05-21', 8),
(48, 'pepe', 2, '2023-05-21', 8),
(49, 'pepe', 2, '2023-05-21', 8),
(50, 'pepe', 2, '2023-05-21', 8),
(51, 'pepe', 2, '2023-05-21', 8),
(52, 'pepe', 2, '2023-05-21', 8),
(53, 'pepe', 4, '2023-05-21', 8),
(54, 'pepe', 4, '2023-05-21', 8),
(55, 'pepe', 4, '2023-05-21', 8),
(56, 'pepe', 3, '2023-05-21', 8),
(57, 'pepe', 2, '2023-05-21', 8),
(58, 'pepe', 2, '2023-05-21', 8),
(59, 'pepe', 4, '2023-05-21', 2),
(60, 'pepe', 3, '2023-05-21', 1),
(61, 'pepe', 5, '2023-05-21', 3),
(62, 'pepe', 3, '2023-05-21', 7),
(63, 'pepe', 1, '2023-05-21', 8),
(64, 'pepe', 5, '2023-05-21', 8),
(65, 'pepe', 5, '2023-05-21', 8),
(66, 'pepe', 5, '2023-05-21', 8),
(67, 'pepe', 5, '2023-05-21', 7),
(68, 'pepe', 2, '2023-05-21', 1),
(69, 'pepe', 2, '2023-05-21', 2),
(70, 'pepe', 3, '2023-05-21', 3),
(71, 'pepe', 2, '2023-05-21', 7),
(72, 'pepe', 3, '2023-05-21', 8),
(73, 'pepe', 2, '2023-05-21', 2),
(74, 'pepe', 4, '2023-05-21', 1),
(75, 'pepe', 3, '2023-05-21', 3),
(76, 'pepe', 2, '2023-05-21', 7),
(77, 'pepe', 4, '2023-05-21', 8),
(78, 'pepe', 2, '2023-05-21', 1),
(79, 'pepe', 3, '2023-05-21', 2),
(80, 'pepe', 4, '2023-05-21', 3),
(81, 'pepe', 2, '2023-05-21', 7),
(82, 'pepe', 3, '2023-05-21', 8),
(83, 'pepe', 0, '2023-05-21', 1),
(84, 'pepe', 0, '2023-05-21', 2),
(85, 'pepe', 0, '2023-05-21', 3),
(86, 'pepe', 2, '2023-05-21', 1),
(87, 'pepe', 3, '2023-05-21', 2),
(88, 'pepe', 2, '2023-05-21', 3),
(89, 'pepe', 0, '2023-05-21', 7),
(90, 'pepe', 0, '2023-05-21', 8),
(91, 'pepe', 2, '2023-05-21', 1),
(92, 'pepe', 3, '2023-05-21', 2),
(93, 'pepe', 3, '2023-05-21', 3),
(94, 'pepe', 0, '2023-05-21', 7),
(95, 'pepe', 2, '2023-05-21', 8),
(96, 'pepe', 1, '2023-05-21', 1),
(97, 'pepe', 3, '2023-05-21', 2),
(98, 'pepe', 2, '2023-05-21', 3),
(99, 'pepe', 2, '2023-05-21', 7),
(100, 'pepe', 3, '2023-05-21', 8),
(101, 'pepe', 2, '2023-05-21', 1),
(102, 'pepe', 3, '2023-05-21', 2),
(103, 'pepe', 2, '2023-05-21', 3),
(104, 'pepe', 3, '2023-05-21', 7),
(105, 'pepe', 4, '2023-05-21', 8),
(106, 'pepe', 2, '2023-05-21', 1),
(107, 'pepe', 3, '2023-05-21', 2),
(108, 'pepe', 1, '2023-05-21', 3),
(109, 'pepe', 2, '2023-05-21', 7),
(110, 'pepe', 3, '2023-05-21', 8),
(111, 'pepe', 2, '2023-05-21', 1),
(112, 'pepe', 2, '2023-05-21', 2),
(113, 'pepe', 3, '2023-05-21', 3),
(114, 'pepe', 2, '2023-05-21', 7),
(115, 'pepe', 3, '2023-05-21', 8),
(116, 'pepe', 3, '2023-05-21', 1),
(117, 'pepe', 3, '2023-05-21', 3),
(118, 'pepe', 3, '2023-05-21', 2),
(119, 'pepe', 3, '2023-05-21', 7),
(120, 'pepe', 3, '2023-05-21', 8),
(121, 'pepe', 3, '2023-05-21', 1),
(122, 'pepe', 3, '2023-05-21', 2),
(123, 'pepe', 3, '2023-05-21', 3),
(124, 'pepe', 3, '2023-05-21', 7),
(125, 'pepe', 3, '2023-05-21', 8),
(126, 'pepe', 3, '2023-05-21', 1),
(127, 'pepe', 3, '2023-05-21', 2),
(128, 'pepe', 3, '2023-05-21', 3),
(129, 'pepe', 3, '2023-05-21', 7),
(130, 'pepe', 3, '2023-05-21', 8),
(131, 'pepe', 3, '2023-05-21', 1),
(132, 'pepe', 3, '2023-05-21', 2),
(133, 'pepe', 3, '2023-05-21', 3),
(134, 'pepe', 3, '2023-05-21', 7),
(135, 'pepe', 3, '2023-05-21', 8),
(136, 'pepe', 3, '2023-05-21', 1),
(137, 'pepe', 3, '2023-05-21', 2),
(138, 'pepe', 3, '2023-05-21', 3),
(139, 'pepe', 3, '2023-05-21', 7),
(140, 'pepe', 3, '2023-05-21', 8),
(141, 'pepe', 3, '2023-05-21', 1),
(142, 'pepe', 3, '2023-05-21', 2),
(143, 'pepe', 3, '2023-05-21', 3),
(144, 'pepe', 3, '2023-05-21', 7),
(145, 'pepe', 3, '2023-05-21', 8),
(146, 'pepe', 3, '2023-05-21', 1),
(147, 'pepe', 3, '2023-05-21', 2),
(148, 'pepe', 3, '2023-05-21', 3),
(149, 'pepe', 3, '2023-05-21', 7),
(150, 'pepe', 3, '2023-05-21', 8),
(151, 'pepe', 3, '2023-05-21', 7),
(152, 'pepe', 3, '2023-05-21', 8),
(153, 'pepe', 3, '2023-05-21', 8),
(154, 'pepe', 3, '2023-05-21', 8),
(155, 'pepe', 3, '2023-05-21', 8),
(156, 'pepe', 3, '2023-05-21', 8),
(157, 'pepe', 3, '2023-05-21', 8),
(158, 'pepe', 3, '2023-05-21', 8),
(159, 'pepe', 3, '2023-05-21', 8),
(160, 'pepe', 3, '2023-05-21', 1),
(161, 'pepe', 3, '2023-05-21', 2),
(162, 'pepe', 3, '2023-05-21', 3),
(163, 'pepe', 3, '2023-05-21', 1),
(164, 'pepe', 3, '2023-05-21', 2),
(165, 'pepe', 3, '2023-05-21', 3),
(166, 'pepe', 3, '2023-05-21', 7),
(167, 'pepe', 3, '2023-05-21', 8),
(168, 'pepe', 3, '2023-05-21', 1),
(169, 'pepe', 3, '2023-05-21', 2),
(170, 'pepe', 3, '2023-05-21', 3),
(171, 'pepe', 3, '2023-05-21', 7),
(172, 'pepe', 3, '2023-05-21', 8),
(173, 'pepe', 3, '2023-05-21', 9),
(174, 'pepe', 3, '2023-05-21', 1),
(175, 'pepe', 3, '2023-05-21', 2),
(176, 'pepe', 3, '2023-05-21', 3),
(177, 'pepe', 3, '2023-05-21', 7),
(178, 'pepe', 3, '2023-05-21', 8),
(179, 'pepe', 3, '2023-05-21', 9),
(180, 'pepe', 3, '2023-05-21', 1),
(181, 'pepe', 3, '2023-05-21', 2),
(182, 'pepe', 3, '2023-05-21', 3),
(183, 'pepe', 3, '2023-05-21', 7),
(184, 'pepe', 3, '2023-05-21', 8),
(185, 'pepe', 3, '2023-05-21', 9),
(186, 'pepe', 3, '2023-05-21', 1),
(187, 'pepe', 3, '2023-05-21', 2),
(188, 'pepe', 3, '2023-05-21', 3),
(189, 'pepe', 3, '2023-05-21', 7),
(190, 'pepe', 3, '2023-05-21', 8),
(191, 'pepe', 3, '2023-05-21', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `pregunta` text NOT NULL,
  `id_encuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `pregunta`, `id_encuesta`) VALUES
(1, '1.	¿Consideras que la universidad cuenta con los recursos informáticos para desarrollar labores formativas y académicas? ', 1),
(2, '2.	En una escala del 1 al 5, ¿Cuál sería tu calificación con respecto al estado de los equipos computacionales de la institución? ', 1),
(3, '¿La universidad proporciona los medios de comunicación necesarios en los escenarios de práctica para la formación a distancia?', 1),
(7, '¿Los recursos informáticos y de comunicación disponibles en la institución satisfacen las necesidades académicas? ', 2),
(8, '¿Los recursos informáticos y de comunicación de la universidad cumplen con las necesidades y requerimientos del programa correspondiente?', 2),
(9, '¿Considera que los recursos informáticos y de comunicación disponibles en la institución son pertinentes y de ayuda para el desarrollo de su formación profesional?', 2),
(10, 'Esto es la encuesta 3 p 1', 3),
(11, 'Esto es la encuesta 3 p 2', 3),
(12, 'Esto es la encuesta 3 p 3', 3),
(13, 'Esto es la encuesta 4 p 1', 4),
(14, 'Esto es la encuesta 4 p 2', 4),
(15, 'Esto es la encuesta 4 p 3', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'Estudiante'),
(2, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `contraseña`) VALUES
(2, 'sebastian', '1234'),
(3, 'jemssy', '1234'),
(7, 'pepitu', '1234'),
(8, 'patata', '1234'),
(9, 'pepo', '1234'),
(10, 'larry', '1234'),
(11, 'larrylasecuela', '1234'),
(12, 'a', '2'),
(13, '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_roles`
--

CREATE TABLE `usuarios_roles` (
  `id` int(11) NOT NULL,
  `id_usuarios` int(11) NOT NULL,
  `id_roles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios_roles`
--

INSERT INTO `usuarios_roles` (`id`, `id_usuarios`, `id_roles`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 10, 1),
(4, 11, 2),
(5, 13, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aspectos`
--
ALTER TABLE `aspectos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_caracteristicas` (`id_caracteristicas`);

--
-- Indices de la tabla `calificacion_caracteristicas`
--
ALTER TABLE `calificacion_caracteristicas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_caracteristicas` (`id_caracteristicas`);

--
-- Indices de la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_factor` (`id_factor`);

--
-- Indices de la tabla `encuestas`
--
ALTER TABLE `encuestas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aspectos` (`id_aspectos`);

--
-- Indices de la tabla `factores`
--
ALTER TABLE `factores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuarios` (`id_usuarios`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_preguntas` (`id_preguntas`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_encuesta` (`id_encuesta`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuarios` (`id_usuarios`),
  ADD KEY `id_roles` (`id_roles`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aspectos`
--
ALTER TABLE `aspectos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `calificacion_caracteristicas`
--
ALTER TABLE `calificacion_caracteristicas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `encuestas`
--
ALTER TABLE `encuestas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `factores`
--
ALTER TABLE `factores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=192;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aspectos`
--
ALTER TABLE `aspectos`
  ADD CONSTRAINT `aspectos_ibfk_1` FOREIGN KEY (`id_caracteristicas`) REFERENCES `caracteristicas` (`id`);

--
-- Filtros para la tabla `calificacion_caracteristicas`
--
ALTER TABLE `calificacion_caracteristicas`
  ADD CONSTRAINT `calificacion_caracteristicas_ibfk_1` FOREIGN KEY (`id_caracteristicas`) REFERENCES `caracteristicas` (`id`);

--
-- Filtros para la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  ADD CONSTRAINT `caracteristicas_ibfk_1` FOREIGN KEY (`id_factor`) REFERENCES `factores` (`id`);

--
-- Filtros para la tabla `encuestas`
--
ALTER TABLE `encuestas`
  ADD CONSTRAINT `encuestas_ibfk_1` FOREIGN KEY (`id_aspectos`) REFERENCES `aspectos` (`id`);

--
-- Filtros para la tabla `factores`
--
ALTER TABLE `factores`
  ADD CONSTRAINT `factores_ibfk_1` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`id_preguntas`) REFERENCES `preguntas` (`id`);

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuestas` (`id`);

--
-- Filtros para la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD CONSTRAINT `usuarios_roles_ibfk_1` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuarios_roles_ibfk_2` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

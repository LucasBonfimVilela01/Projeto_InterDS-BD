-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Nov-2024 às 18:28
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `academiagoes`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `assinatura`
--

CREATE TABLE `assinatura` (
  `id_Assinatura` int(10) NOT NULL,
  `id_Cliente` int(10) NOT NULL,
  `id_Plano` int(10) NOT NULL,
  `id_Turma` int(10) NOT NULL,
  `inicioCurso` date NOT NULL,
  `fimCurso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `assinatura`
--

INSERT INTO `assinatura` (`id_Assinatura`, `id_Cliente`, `id_Plano`, `id_Turma`, `inicioCurso`, `fimCurso`) VALUES
(1, 3, 1, 6, '2024-11-27', '2025-11-27'),
(4, 3, 3, 10, '2024-11-27', '2025-05-27'),
(5, 3, 5, 5, '2024-11-27', '2025-02-27'),
(6, 6, 6, 13, '2024-11-27', '2025-02-27'),
(7, 6, 1, 6, '2024-11-27', '2025-11-27'),
(8, 6, 3, 10, '2024-11-27', '2025-05-27'),
(9, 6, 2, 2, '2024-11-27', '2025-11-27'),
(10, 3, 2, 2, '2024-11-27', '2025-11-27'),
(11, 3, 4, 7, '2024-11-27', '2025-05-27');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_Cliente` int(10) NOT NULL,
  `senha_Cliente` varchar(20) NOT NULL,
  `nome_Cliente` varchar(50) NOT NULL,
  `CPF_Cliente` varchar(16) NOT NULL,
  `RG_Cliente` varchar(14) NOT NULL,
  `UF_Cliente` text NOT NULL,
  `endereco_Cliente` varchar(50) NOT NULL,
  `telefone_Cliente` varchar(20) NOT NULL,
  `email_Cliente` varchar(50) NOT NULL,
  `nasc_Cliente` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `senha_Cliente`, `nome_Cliente`, `CPF_Cliente`, `RG_Cliente`, `UF_Cliente`, `endereco_Cliente`, `telefone_Cliente`, `email_Cliente`, `nasc_Cliente`) VALUES
(1, 'entulho14', 'Erick', '234.234.523-45', '12.312.312-3', 'RJ', 'Rua do cafuné, 445', '+55  21 31231-2312', 'Erickzin_zl@gmail.com', '1999-03-12'),
(2, 'fitnesslife', 'Gabriel', '109.238.190-38', '31.291.471-1', 'SP', 'Avenida Nordestina, 122', '+55  11 98123-1231', 'fitnesgab@gmail.com', '1992-12-30'),
(3, '12', 'emily', '111.111.111-11', '11.111.111-1', 'SP', 'Rua das Amigas', '+55  11 11111-1111', 'emily@teste', '2007-11-14'),
(6, '1234', 'Lucas Bonfim Vilela', '983.298.329-84', '98.139.821-3', 'SP', 'Rua José Maria, 911', '+55  11 98982-1382', 'lucasb@gmail.com', '2008-01-26');

-- --------------------------------------------------------

--
-- Estrutura da tabela `instrutor`
--

CREATE TABLE `instrutor` (
  `id_Instrutor` int(10) NOT NULL,
  `senha_Instrutor` varchar(20) NOT NULL,
  `CPF_Instrutor` varchar(16) NOT NULL,
  `RG_Instrutor` varchar(14) NOT NULL,
  `nome_Instrutor` varchar(50) NOT NULL,
  `UF_Instrutor` varchar(2) NOT NULL,
  `endereco_Instrutor` varchar(50) NOT NULL,
  `formacao_Instrutor` varchar(50) NOT NULL,
  `telefone_Instrutor` varchar(20) NOT NULL,
  `email_Instrutor` varchar(50) NOT NULL,
  `nasc_Instrutor` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `instrutor`
--

INSERT INTO `instrutor` (`id_Instrutor`, `senha_Instrutor`, `CPF_Instrutor`, `RG_Instrutor`, `nome_Instrutor`, `UF_Instrutor`, `endereco_Instrutor`, `formacao_Instrutor`, `telefone_Instrutor`, `email_Instrutor`, `nasc_Instrutor`) VALUES
(1, 'fitfit', '111.111.111-11', '12.312.314-1', 'Rodrigo', 'SP', 'Rua fitness, 12', 'Fisioterapeuta', '+55  11 99182-3771', 'Rodrifit22@hotmail.com', '1999-08-20'),
(2, 'a', '111.111.111-11', '11.111.111-1', 'a', 'BH', 'a', '', '+55  11 11111-1111', 'a@a', '2007-11-14'),
(3, 'a', '111.111.111-11', '11.111.111-1', 'a', 'BH', 'a', '', '+55  11 11111-1111', 'a@a', '2007-11-14'),
(4, 'u', '111.111.111-11', '11.111.111-1', 'u', 'SP', 'u', '', '+55  11 11111-1111', 'u@u', '2007-11-14'),
(5, 'teste', '111.111.111-11', '11.111.111-1', 'teste', 'AA', 'teste', '', '+55  11 11111-1111', 'teste', '2000-10-10'),
(6, '1', '111.111.111-11', '11.111.111-1', 'Amanda', 'SP', 'rua santa, 222', '', '+55  11 11111-1111', 'Amandita@gmail', '2007-07-15'),
(7, 'senha', '111.111.111-11', '11.111.111-1', 'Cleide', 'SP', 'Rua das rosas, 478', '', '+55  11 11111-1111', 'Cleide@hotmail', '1978-03-17'),
(8, '123', '743.298.237-49', '92.443.298-4', 'Horacio Nunes', 'SP', 'Rua das flores, 833', '', '+55  11 99239-8742', 'horario@hotmail.com', '1980-11-04');

-- --------------------------------------------------------

--
-- Estrutura da tabela `laudo`
--

CREATE TABLE `laudo` (
  `id_Laudo` int(11) NOT NULL,
  `id_Cliente` int(10) NOT NULL,
  `id_Medico` int(10) NOT NULL,
  `yoga` tinyint(1) NOT NULL,
  `pilates` tinyint(1) NOT NULL,
  `spinning` tinyint(1) NOT NULL,
  `jump` tinyint(1) NOT NULL,
  `zumba` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `laudo`
--

INSERT INTO `laudo` (`id_Laudo`, `id_Cliente`, `id_Medico`, `yoga`, `pilates`, `spinning`, `jump`, `zumba`) VALUES
(1, 2, 17, 0, 0, 1, 1, 0),
(2, 1, 16, 1, 0, 0, 0, 1),
(3, 3, 20, 1, 1, 1, 1, 1),
(4, 6, 21, 1, 1, 0, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `id_Medico` int(5) NOT NULL,
  `senha_Medico` varchar(20) NOT NULL,
  `CPF_Medico` varchar(17) NOT NULL,
  `RG_Medico` varchar(15) NOT NULL,
  `nome_Medico` varchar(50) NOT NULL,
  `UF_Medico` varchar(2) NOT NULL,
  `endereco_Medico` varchar(50) NOT NULL,
  `telefone_Medico` varchar(20) NOT NULL,
  `email_Medico` varchar(50) NOT NULL,
  `nasc_Medico` date NOT NULL,
  `formacao_Medico` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`id_Medico`, `senha_Medico`, `CPF_Medico`, `RG_Medico`, `nome_Medico`, `UF_Medico`, `endereco_Medico`, `telefone_Medico`, `email_Medico`, `nasc_Medico`, `formacao_Medico`) VALUES
(1, '123', '1234123', '32334', 'Fernando', 'SP', 'rua dos doidos', '+12 11 23123', 'asdasd@asd.com', '0000-00-00', 'odontologia'),
(2, 'Senha', 'CPF', 'RG', '\"Nome', 'UF', 'Endereco', 'Tel', 'Email', '2000-01-01', 'Formacao'),
(3, 'Senha', 'CPF', 'RG', 'Nome', 'UF', 'Endereco', 'Tel', 'Email', '2000-01-01', 'Formacao'),
(7, 'diaz123', '981.234.798-21', '78.293.498-7', 'Marlene Diaz', 'MG', 'Rua do queijo, 821', '+55  31 98897-4263', 'marlene.diaz@hotmail.com', '1979-05-08', 'graduada em anatomia humana'),
(8, '12344', '   .   .   -  ', '  .   .   - ', '', '  ', '', '+55          -    ', '', '1111-11-11', ''),
(9, 'pagoiaba', '637.727.827-12', '11.221.121-1', 'lindo', 'SP', 'awjhwhwgh ruak, 322', '+55  11 91111-9844', 'daoralegal@legallindo.cp', '2001-12-10', ''),
(16, 'fernandomedico', '341.234.234-23', '12.312.312-3', 'Fernando Costa', 'MG', 'Rua dos medicos', '+55  24 12121-2122', 'med.fernando@gmail.com', '2000-10-10', ''),
(17, 'curandeiro20', '984.379.823-79', '89.734.598-6', 'Pedro', 'SP', 'Rua santo Jorge, 833', '+55  11 99123-1231', 'pedromedic@hotmail.com', '1989-05-19', ''),
(18, 'jorge12', '327.869.482-73', '40.987.978-2', 'Jo?o', 'SP', 'Rua S?o Jorge, 563', '+55  11 99743-2874', 'jo?omedicina@hotmail.com', '1982-11-12', ''),
(19, 'Karolinasss', '290.873.479-30', '53.478.922-3', 'Karolina', 'SP', 'Rua lindez, 922', '+55  11 98346-7723', 'KarolFisic@gmail.com', '2002-03-19', ''),
(20, '12', '111.111.111-11', '11.111.111-1', 'lucas', 'SP', 'Rua do Álcool', '+55  11 11111-1111', 'lucas@teste', '2008-01-26', ''),
(21, '123', '982.349.839-84', '92.398.239-8', 'Viviane Rocha', 'SP', 'Rua Cintia, 222', '+55  11 99823-9821', 'Viv@gmail.com', '1992-10-17', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `plano`
--

CREATE TABLE `plano` (
  `id_Plano` int(10) NOT NULL,
  `id_Turma` int(10) NOT NULL,
  `nome_Plano` varchar(50) NOT NULL,
  `categoria` varchar(10) NOT NULL,
  `duracao` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `plano`
--

INSERT INTO `plano` (`id_Plano`, `id_Turma`, `nome_Plano`, `categoria`, `duracao`) VALUES
(1, 6, 'Ano de Yoga', 'Yoga', 12),
(2, 2, 'Ano de Pilates', 'Pilates', 12),
(3, 10, '6 meses zumba', 'Zumba', 6),
(4, 7, '6 meses spinning', 'Spinning', 6),
(5, 5, '3 meses Jump', 'Jump', 3),
(6, 13, 'Pilates Matinal', 'Pilates', 3),
(7, 12, 'Jump da Tarde', 'Jump', 6),
(8, 11, 'Spinning noturno', 'Spinning', 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id_Turma` int(10) NOT NULL,
  `id_ Instrutor` int(10) NOT NULL,
  `nome_Turma` varchar(50) NOT NULL,
  `horario` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id_Turma`, `id_ Instrutor`, `nome_Turma`, `horario`) VALUES
(1, 1, 'Yoga Tarde', 'Tarde'),
(2, 1, 'Pilates Manh?', 'Manh?'),
(3, 1, 'Jump Noite', 'Noite'),
(4, 6, 'Spinning Manh?', 'Manh?'),
(5, 6, 'Jump Tarde', 'Tarde'),
(6, 6, 'Yoga Noite', 'Noite'),
(7, 1, 'Spinning', 'Tarde'),
(8, 7, 'Zumba Manh?', 'Manha'),
(9, 7, 'Zumba Tarde', 'Tarde'),
(10, 7, 'Zumba Noite', 'Noite'),
(11, 8, 'Spinning Noite', 'Noite'),
(12, 8, 'Jump Tarde', 'Tarde'),
(13, 8, 'Pilates Manha', 'Manha');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `assinatura`
--
ALTER TABLE `assinatura`
  ADD PRIMARY KEY (`id_Assinatura`),
  ADD KEY `qual cliente fez a assinatura` (`id_Cliente`),
  ADD KEY `que plano o cliente assinou` (`id_Plano`),
  ADD KEY `que turma o cliente faz parte` (`id_Turma`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_Cliente`);

--
-- Índices para tabela `instrutor`
--
ALTER TABLE `instrutor`
  ADD PRIMARY KEY (`id_Instrutor`);

--
-- Índices para tabela `laudo`
--
ALTER TABLE `laudo`
  ADD PRIMARY KEY (`id_Laudo`),
  ADD KEY `Laudo do cliente` (`id_Cliente`),
  ADD KEY `Medico do laudo` (`id_Medico`);

--
-- Índices para tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_Medico`);

--
-- Índices para tabela `plano`
--
ALTER TABLE `plano`
  ADD PRIMARY KEY (`id_Plano`),
  ADD KEY `que turma o plano é` (`id_Turma`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id_Turma`),
  ADD KEY `Instrutor da turma` (`id_ Instrutor`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `assinatura`
--
ALTER TABLE `assinatura`
  MODIFY `id_Assinatura` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_Cliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `instrutor`
--
ALTER TABLE `instrutor`
  MODIFY `id_Instrutor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `laudo`
--
ALTER TABLE `laudo`
  MODIFY `id_Laudo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `id_Medico` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `plano`
--
ALTER TABLE `plano`
  MODIFY `id_Plano` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `id_Turma` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `assinatura`
--
ALTER TABLE `assinatura`
  ADD CONSTRAINT `qual cliente fez a assinatura` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id_Cliente`),
  ADD CONSTRAINT `que plano o cliente assinou` FOREIGN KEY (`id_Plano`) REFERENCES `plano` (`id_Plano`),
  ADD CONSTRAINT `que turma o cliente faz parte` FOREIGN KEY (`id_Turma`) REFERENCES `turma` (`id_Turma`);

--
-- Limitadores para a tabela `laudo`
--
ALTER TABLE `laudo`
  ADD CONSTRAINT `Laudo do cliente` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id_Cliente`),
  ADD CONSTRAINT `Medico do laudo` FOREIGN KEY (`id_Medico`) REFERENCES `medico` (`id_Medico`);

--
-- Limitadores para a tabela `plano`
--
ALTER TABLE `plano`
  ADD CONSTRAINT `que turma o plano é` FOREIGN KEY (`id_Turma`) REFERENCES `turma` (`id_Turma`);

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `Instrutor da turma` FOREIGN KEY (`id_ Instrutor`) REFERENCES `instrutor` (`id_Instrutor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

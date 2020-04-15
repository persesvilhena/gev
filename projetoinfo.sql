-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.15
-- Versão do PHP: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `projetoinfo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `CodCid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomCid` varchar(45) NOT NULL,
  `UfCid` varchar(45) NOT NULL,
  PRIMARY KEY (`CodCid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`CodCid`, `NomCid`, `UfCid`) VALUES
(1, 'Muzambinho', 'MG'),
(2, 'Guaxupé', 'MG'),
(3, 'Cabo Verde', 'MG'),
(4, 'Monte Belo', 'MG'),
(5, 'Caconde', 'SP'),
(6, 'Botelhos', 'MG'),
(7, 'São José do Rio Pardo', 'SP'),
(8, 'Nova Resende', 'MG'),
(9, 'Monte Santo de Minas', 'MG'),
(10, 'Tapiratiba', 'SP'),
(11, 'Igaraí', 'SP'),
(12, 'teste', 'teste'),
(13, 'teste2', 'teste2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `CodCli` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomCli` varchar(45) NOT NULL,
  `EndCli` varchar(45) NOT NULL,
  `NumCli` varchar(45) NOT NULL,
  `BaiCli` varchar(45) NOT NULL,
  `CepCli` varchar(45) NOT NULL,
  `CidCli` varchar(45) NOT NULL,
  `EstCli` varchar(45) NOT NULL,
  `TelCli` varchar(45) NOT NULL,
  `EmaCli` varchar(45) NOT NULL,
  `CpfCli` varchar(45) NOT NULL,
  `RgCli` varchar(45) NOT NULL,
  `NasCli` datetime NOT NULL,
  PRIMARY KEY (`CodCli`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`CodCli`, `NomCli`, `EndCli`, `NumCli`, `BaiCli`, `CepCli`, `CidCli`, `EstCli`, `TelCli`, `EmaCli`, `CpfCli`, `RgCli`, `NasCli`) VALUES
(3, 'dfssdfsddfsda', 'sdfsdfsd', '1', 'fsdfsdf', '14.247-524', '6', 'fdgdfg', '(25)6345-4525', 'aswkjbsdfjbh@asdfsfd', '___.___.___-__', '__-__.___.___', '6456-09-14 00:00:00'),
(4, 'dfssdfsddfsa', 'sdfsdfsa', '12', 'fsdfsdf', '14.247-524', '6', 'fdgdfg', '(25)6345-4525', 'aswkjbsdfjbh@asdfsfd', '234.242.342-34', '23-42.342.342', '3426-06-23 00:00:00'),
(5, 'asdasdasd', 'asdasd', '12', 'sadasda', '12.312-321', '6', 'asdasdasd', '(23)1231-2312', 'sadsadasdasd', '123.123.123-12', '12-31.231.231', '2314-07-12 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE IF NOT EXISTS `fornecedores` (
  `codfornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  `obs` varchar(45) NOT NULL,
  PRIMARY KEY (`codfornecedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`codfornecedor`, `nome`, `endereco`, `email`, `telefone`, `cnpj`, `obs`) VALUES
(1, 'asdasd', 'asdasd', 'asdasd', '(13)2131-2312', 'asdasd', 'sfdfsfdsdfsdf'),
(2, 'fornecedora', 'end', 'email', '(11)2312-3123', 'cnpj', 'asdasda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `CodFun` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomFun` varchar(45) NOT NULL,
  `EndFun` varchar(45) NOT NULL,
  `NumFun` varchar(45) NOT NULL,
  `BaiFun` varchar(45) NOT NULL,
  `CepFun` varchar(45) NOT NULL,
  `CidFun` varchar(45) NOT NULL,
  `EstFun` varchar(45) NOT NULL,
  `TelFun` varchar(45) NOT NULL,
  `EmaFun` varchar(45) NOT NULL,
  `CpfFun` varchar(45) NOT NULL,
  `RgFun` varchar(45) NOT NULL,
  `NasFun` datetime NOT NULL,
  PRIMARY KEY (`CodFun`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`CodFun`, `NomFun`, `EndFun`, `NumFun`, `BaiFun`, `CepFun`, `CidFun`, `EstFun`, `TelFun`, `EmaFun`, `CpfFun`, `RgFun`, `NasFun`) VALUES
(4, 'dfssdfsddfsa', 'sdfsdfsa', '12', 'fsdfsdf', '14.247-524', '6', 'fdgdfg', '(25)6345-4525', 'aswkjbsdfjbh@asdfsfd', '234.242.342-34', '23-42.342.342', '3426-06-23 00:00:00'),
(5, 'persesA', 'testeA', '10', 'testeA', '12.312-310', '11', 'MGA', '(11)2312-3120', 'asdasda@sadasdaA', '131.232.313-10', '12-31.231.230', '1990-07-09 00:00:00'),
(6, 'dfssdfsddfsda', 'sdfsdfsd', '1', 'fsdfsdf', '14.247-524', '6', 'fdgdfg', '(25)6345-4525', 'aswkjbsdfjbh@asdfsfd', '131.232.313-10', '12-31.231.230', '1990-07-09 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensvenda`
--

CREATE TABLE IF NOT EXISTS `itensvenda` (
  `CodItem` int(11) NOT NULL AUTO_INCREMENT,
  `CodVen` int(11) DEFAULT NULL,
  `CodPro` int(11) DEFAULT NULL,
  `QtdPro` int(11) DEFAULT NULL,
  `ValPro` double DEFAULT NULL,
  PRIMARY KEY (`CodItem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `CodPro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomPro` varchar(45) NOT NULL,
  `DesPro` varchar(45) NOT NULL,
  `CusPro` double NOT NULL,
  `VenPro` double NOT NULL,
  `EstPro` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CodPro`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`CodPro`, `NomPro`, `DesPro`, `CusPro`, `VenPro`, `EstPro`) VALUES
(1, 'testeA', 'testeA', 121, 121, 121),
(2, 'novoa', 'new', 100, 123, 110);

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE IF NOT EXISTS `servicos` (
  `CodSer` int(11) NOT NULL AUTO_INCREMENT,
  `CodCli` int(11) NOT NULL,
  `DesSer` varchar(45) NOT NULL,
  `TotSer` double(10,2) NOT NULL,
  `DatSer` date NOT NULL,
  PRIMARY KEY (`CodSer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `CodUsu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomUsu` varchar(45) NOT NULL,
  `LogUsu` varchar(50) NOT NULL,
  `SenUsu` varchar(45) NOT NULL,
  `TipUsu` varchar(45) NOT NULL,
  `CidUsu` int(10) unsigned NOT NULL,
  `DatUsu` datetime NOT NULL,
  `CpfUsu` varchar(45) NOT NULL,
  PRIMARY KEY (`CodUsu`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`CodUsu`, `NomUsu`, `LogUsu`, `SenUsu`, `TipUsu`, `CidUsu`, `DatUsu`, `CpfUsu`) VALUES
(1, 'dsfsdfsdf', 'sdfsdfsdf', 'sdfsdfsd', 'USU', 3, '2010-01-01 00:00:00', '121.111.111-11'),
(2, 'dsfsdfsdf', 'sdfsdfsdf', 'sdfsdfsd', 'USU', 3, '2010-01-01 00:00:00', '121.111.111-11'),
(3, 'teste', 'teste', 'teste', 'ADM', 1, '1222-12-12 00:00:00', '122.323.233-22');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE IF NOT EXISTS `vendas` (
  `CodVen` int(11) NOT NULL AUTO_INCREMENT,
  `CliVen` int(11) DEFAULT NULL,
  `AcrVen` double DEFAULT NULL,
  `DesVen` double DEFAULT NULL,
  `TotVen` double DEFAULT NULL,
  `DatVen` datetime DEFAULT NULL,
  PRIMARY KEY (`CodVen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

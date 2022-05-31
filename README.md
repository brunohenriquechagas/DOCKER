# DOCKER
# //-----------------------------------------------------------//
# = INSTALLER | Autor: BRUNO HENRIQUE e WALDERLEY NETO =
# //-----------------------------------------------------------//

# 1 - Passo a passo para instalar .zip, java, docker e imagem MySQL

1. Sudo apt update && sudo apt upgrade -y && Sudo apt-get install xrdp lxde-core lxde tigervnc-standalone-server -y && sudo apt install zip && curl -s "https://get.sdkman.io" | bash

2. feche e acha o terminal ou execute source "/home/urubu100/.sdkman/bin/sdkman-init.sh"

3. sudo apt install openjdk-11-jre-headless && Sudo apt install Docker.io && Sudo systemctl start Docker && Sudo Docker pull mysql:5.7

# 2 - Comando para clonar repositorio, dar permissões a arquivos do repositorio, executar container e executar .jar (Apenas copiar e colar no terminal)

1. cd / && git clone https://github.com/brunohenriquechagas/DOCKER.git && cd /./DOCKER/ && cd repBruno && chmod +x scriptSQL.sh && chmod +x Java.sh && chmod 777 Swing-1.0-SNAPSHOT-jar-with-dependencies.jar && ./scriptSQL.sh && repBruno

2. java -jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar

# 3 - Script para criar as tabelas do banco (APENAS COPIAR E COLAR DENTRO DO SEU CONTAINER MYSQL)
create table empresa(
    idEmpresa int primary key auto_increment,
    cnpj char(18),
    nome varchar(50),
    email varchar (45),
    cep char(9),
    senha varchar(100)
) auto_increment 100;

INSERT INTO empresa VALUES 
(null,"03.778.130/0001-48", "Keep Swimming", 'Keep@hotmail.com', 06126020,'123');

CREATE TABLE FUNCIONARIO (
    idFuncionario INT PRIMARY KEY AUTO_INCREMENT,
    fkGestor Int,
    fkEmpresa Int,
    Nome varchar(50),
    EMAIL VARCHAR(50),
    SENHA VARCHAR(50),
    Cargo VARCHAR(50),
    foreign key (fkGestor) references FUNCIONARIO(idFuncionario),
    foreign key (fkEmpresa) references empresa(idEmpresa)
);

INSERT INTO FUNCIONARIO VALUES (null, null, 100, 'Gerson', 'Gerson@hotmail.com', '123', 'Gestor');

INSERT INTO FUNCIONARIO VALUES (null, 1, 100, "Bruno", "bruno@hotmail.com", '123', 'Desenvolvedor');

CREATE TABLE Maquina (
    idMaquina INT PRIMARY KEY AUTO_INCREMENT,
    fkUsuario INT,
    sistemaOperacional varchar(50),
    fabricante varchar(50),
    arquitetura int,
    hostName varchar(50),
    permissoes varchar(50),
    foreign key (fkUsuario) references FUNCIONARIO(idFuncionario)
);

INSERT INTO Maquina values (1, 2, 'Linux', 'GNU', 64, 'spNote', 'false');

CREATE TABLE Processos (
    idProcesso INT PRIMARY KEY AUTO_INCREMENT,
    fkMaquina INT,
    PID INT,
    Nome varchar(45),
    usoCPU FLOAT,
    usoMemoria FLOAT,
    bytesUtilizados INT,
    memVirtualUtilizada FLOAT,
    totalProcessos int,
    threads int,
    dataHoraProcesso datetime,
    foreign key (fkMaquina) references Maquina(idMaquina)
);

CREATE TABLE ComponentesHardware (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    fkMaquina INT,
    nomeDisco varchar(45),
    tamanhoDisco FLOAT,
    modeloDisco varchar(100),
    qtdDiscos int,
    memoriaTotal FLOAT,
    processadorNome varchar(50),
    foreign key (fkMaquina) references Maquina(idMaquina)
);

CREATE TABLE Historico (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    fkMaquina INT,
    data Datetime,
    tempoInicializado varchar(45),
    tempoDeAtividade varchar(45),
    temperaturaAtual varchar(45),
    memoriaEmUso FLOAT,
    memoriaDisponivel FLOAT,
    processadorUso FLOAT,
    foreign key (fkMaquina) references Maquina(idMaquina)
);
# 4 - Passo a passo para abrir o MySQL no Docker. ps: o comando acima deve ter sido executado, para que esse funcione
1. sudo docker exec -it seepSwimming bash
2. mysql -u root -p
3. insira a senha do banco
4. Show databases;
5. use keepSwimming;
6. show tables;
7. faça os selects que desejar!

# 5 - Comando para excluir contener contkeep e excluir diretorio shellscript (Apenas copiar e colar no terminal)
sudo docker stop keepSwimming && sudo docker rm keepSwimming && cd .. && sudo rm -r /DOCKER
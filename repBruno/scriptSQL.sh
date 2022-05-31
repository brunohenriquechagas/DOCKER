#!/bin/bash

docker --version

if [ $? -eq 0 ]

then

echo "docker instalado"

else

echo "docker não instalado, instalando o docker"

sudo apt install docker.io

echo "Startando o docker"

sudo systemctl start docker

sudo systemctl enable docker

echo "Subindo imagem MySql Docker"

sudo docker pull: mysql 5.7

fi

echo "deseja criar o seu banco dentro do docker?\n

s|n"

read resposta

if [ "$resposta" == "s" ]

then

        echo "criando o MySql, qual o nome do seu container?"

        read nome

        echo " qual o nome do seu banco de dados?"

        read banco

        echo "qual a senha do seu banco de dados?"

        read senha


        sudo docker run -d -p 3306:3306 --name $nome -e "MYSQL_DATABASE=$banco" -e "MYSQL_ROOT_PASSWORD=$senha" mysql:5.7

fi

echo "Deseja executar o MySql?\n s|n"

read resposta2

if [ "$resposta2" == "s" ]

then

        sudo docker ps -a

        echo "digite o nome do seu container"

        read nome

        echo "execute o comando mysql -u root -p e coloque a senha do seu usuario para entrar no banco de dados"
        echo "abra outro terminal e execute java -jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar "

sudo docker exec -it $nome bash

echo "$id"

fi

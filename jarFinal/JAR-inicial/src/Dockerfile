
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template



CMD ["/bin/sh"]

FROM openjdk:8-jre-alpine
ADD /target/Swing-1.0-SNAPSHOT-jar-with-dependencies.jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar
expose 8080
ENTRYPOINT java -jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar
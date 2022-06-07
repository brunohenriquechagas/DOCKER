
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:latest

CMD ["/bin/sh"]

FROM openjdk:keepSwimmingJava
ADD /target/Swing-1.0-SNAPSHOT-jar-with-dependencies.jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar
expose 8080
ENTRYPOINT java -jar Swing-1.0-SNAPSHOT-jar-with-dependencies.jar

FROM openjdk:23-jdk
ADD target/StudentService-1.0.jar StudentServiceApp.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/StudentServiceApp.jar" ]
FROM khipu/openjdk17-alpine
VOLUME /temp
EXPOSE 8080:8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aldeamostore.jar
ENTRYPOINT ["java","-jar","/aldeamostore.jar"]
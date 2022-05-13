FROM maven:3.8.5-openjdk-11-slim

# image layer
WORKDIR /backend/api/drinkerly
ADD ./drinkerly/pom.xml .
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY ./drinkerly .
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD ./drinkerly/target/drinkerly-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/drinkerly-0.0.1-SNAPSHOT.jar"]
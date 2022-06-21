FROM maven:3.8.5-openjdk-11-slim

#install chrome for selenium interface tests
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN sudo apt install ./google-chrome-stable_current_amd64.deb

# image layer
WORKDIR /backend/user_app_api/drinkerly
ADD ./drinkerly/pom.xml .
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY ./drinkerly .
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8082
ADD ./drinkerly/target/drinkerly-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/drinkerly-0.0.1-SNAPSHOT.jar"]
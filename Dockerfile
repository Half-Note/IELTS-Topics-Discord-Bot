FROM gradle:latest AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM eclipse-temurin:latest
RUN mkdir /opt/app
COPY --from=build /home/gradle/src/build/libs/application.jar /opt/app/application.jar
ENTRYPOINT ["java","-jar","/opt/app/application.jar"]

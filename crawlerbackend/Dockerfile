FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

RUN mvn clean install

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/crawlerbackend-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "crawlerbackend-0.0.1-SNAPSHOT.jar"]

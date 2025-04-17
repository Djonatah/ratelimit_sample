# build stage
FROM eclipse-temurin:21-jdk-alpine as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests

# actual image creation stage
FROM eclipse-temurin:21-jdk-alpine
COPY --from=builder /app/target/ratelimit.jar ratelimit.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ratelimit.jar"]

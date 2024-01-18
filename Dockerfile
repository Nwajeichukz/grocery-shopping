FROM public.ecr.aws/docker/library/maven:3.6-jdk-11 AS build

COPY src /app/src

WORKDIR /app

COPY pom.xml /app

RUN mvn clean install -DskipTests




FROM public.ecr.aws/docker/library/maven:3.6-jdk-11

WORKDIR /app

COPY --from=build /app/target/ginikas-customers-jpa-0.0.1-SNAPSHOT.jar ginikas-app.jar


ENTRYPOINT ["java", "-jar", "ginikas-app.jar"]
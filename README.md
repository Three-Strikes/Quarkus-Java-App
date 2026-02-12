# README

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Requirements

**Java JDK 25 (Necessary to build and run the project.)**

**Docker Desktop (Necessary to run the project in docker, which is optional.)**


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

## Running the application

The application can be packaged using:

```shell script
./mvnw clean package
```

This command produces the application jar and its dependencies in the target folder.

The application is now runnable using:

```shell script
java -jar target/quarkus-app/quarkus-run.jar
```

## Creating a Docker image and running a container

Next, you can use the included Dockerfile to create an image quickly.

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/quarkuslabseq-jvm .
```

After the image is created, you can run the application using Docker:

```shell script
docker run -i --rm -p 8080:8080 quarkus/quarkuslabseq-jvm  
```
> **_NOTE:_**  Make sure port 8080 is available in your system.

After the container is initialized, you can access the Swagger API specification by using this url http://localhost:8080/swagger/


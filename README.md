# stc-server

## Introduction

This is a proof of concept implementation of an STC (Slice the Cake) server.

## Run postgres locally

Make sure you have docker and docker compose installed. Run the following:

```console
./src/main/docker$ sudo docker compose -f docker-compose.dev.yml up
```

You can omit `sudo` in the previous command in certain situations. For this, consult the Docker documentation.

When the container runs, assuming you have psql installed, you can connect to the database with the following:

```console
$ psql -h 127.0.0.1 -p 5432 -U stc
```

Alternatively, use your preferred postgres client.

## Solved problems

### ./mvnw package -Dnative

#### Class initialization failed, use --initialize-at-run-time

[This explains how to solve it](https://stackoverflow.com/questions/65052105/quarkus-native-image-build-fails-with-unknown-arguments).

The error message is helpful, the link explains how to do it with Quarkus. We basically add a property so Quarkus
can forward the option to GraalVM.

#### UnresolvedElementException: Discovered unresolved type during parsing

[This explains the problem and possible solutions](https://quarkus.io/version/main/guides/native-reference#i-get-a-analysiserrorparsingerror-when-building-a-native-executable-due-to-an-unresolvedelementexception-what-can-i-do). 

The current way this is being solved here is to add the optional indirect dependencies directly to the project.
**This is not the optimal way to solve the problem**, but in some circumstances may be the only available.

There's a comment in `pom.xml` to separate the dependencies only imported because of this.

## Quarkus Generated Readme

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/stc-server-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

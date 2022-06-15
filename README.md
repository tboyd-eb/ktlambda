# ktLambda

This repository is a proof-of-concept Kotlin AWS Lambda project. You should be
able to deploy it on the AWS free tier without any issues.

Its Lambda entrypoint is `com.myorg.lambda.Handler::handleRequest`.

## Build

The project has a `shadowJar` Gradle task that will be executed as a dependency
of the `build` task. This will produce an uber-JAR file in the `lambda/build/libs`
directory.

```shell
./gradlew build
```

## Example request payload

```json
{
  "message": "world"
}
```

## Example response payload

```json
{
  "message": "Hello, world"
}
```

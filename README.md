# ktlambda

This repository is a proof-of-concept Kotlin AWS Lambda project. You should be
able to deploy it on the AWS free tier without any issues.

Its Lambda entrypoint is `com.myorg.lambda.Handler::handleRequest`.

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

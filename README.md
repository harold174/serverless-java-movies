# Java serverless example + AWS Lambda + API Gateway

The following example was developed using serverless framework

You can install it by the following command

```
npm install -g serverless
```

After that, you can create your boilerplate, in this case using kotlin and gradle

```
serverless create —-template aws-kotlin-jvm-gradle --path your_service
```

Next step is configuring AWS credentials that are going to be stored in /home/.aws/credentials file

Finally, you can deploy it to AWS Lambda. With the following task, serverless framework is able to:

1. Upload your code to s3 storage.
2. Provision the required resources with cloud formation.
3. Create the lambda function.
4. Create and parametrize the API Gateway according to the mapping routes that could be found in the serverless.yml file.

```
./gradlew deploy
```

# Java serverless example + AWS Lambda + API Gateway

## Configuration

The following example was developed using serverless framework

You can install it by the following command

```
npm install -g serverless
```

After that, you can create your boilerplate, in this case using kotlin and gradle

```
serverless create —-template aws-kotlin-jvm-gradle --path your_service
```

Next step is configuring AWS credentials that are going to be stored in `/home/.aws/credentials` file

Finally, you can deploy it to AWS Lambda. 
```
./gradlew deploy
```
With this task, serverless framework is going to perform several tasks:

1. Upload your code to s3 storage.
2. Provision the required resources with cloud formation.
3. Create the lambda function.
4. Create and parametrize the API Gateway according to the mapping routes that could be found in the `serverless.yml` file.

## Local Testing

You can test your project in your local environment using SAM Local. To achieve that you will need to install a sam plugin to your serverless npm package installed former. This plugin is going to give us the capability to transform our `serverless.yml` into `template.yml`. The last one is going to be understandable by SAM Local.

```
sls plugin install --name serverless-sam
```
Now, you should be able to Builds the fatJar.
```
gradle build shadowJar -x test
```
Export your serverless.yml to template.yml and finally invoke your functions locally
```
sls sam export -o template.yml
sam local invoke FunctionName <<< "{}" # JSON Event
```
You can add your own request as a parameter using the following command.
```
sam local invoke Hello -e src/test/resources/testRequest.json
```

A gradle script could become in handy...

```
{
"name": "my-hello",
"version": "1.0.0",
"scripts": {
  "getHelloEvent": "gradle build shadowJar -x test; sam local invoke Hello -e src/test/resources/testRequest.json"
},
```
And then you can run it
```
npm run getHelloEvent
```
One of the most important futures of SAM Local is the possibility to test your endpoints running your local server
```
sam local start-api
```
## Multiple serverless microservices sharing one API GATEWAY

By default, each serverless project will create an API GATEWAY. However, you can change this behavior changing some `serverless.yml` configurations.

In the provider item, you are going to add the `restApiId` and the `restApiRootResourceId`. The first refers to the API id that you can see on aws api gateway and the second one refers to the root path of the API.

```
provider:
  apiGateway:
    restApiId: XXXXXX # REST API resource ID. Default is generated by the framework
    restApiRootResourceId: XXXXXX # Root resource, represent as / path
```
This configuration must be realized in all of the serverless projects that you want to be part of your shared gateway.

[For more information you can refer to this awesome Article.](https://medium.com/tech-travelstart/using-kotlin-in-a-serverless-architecture-with-aws-lambda-part-1-setting-up-the-project-87033790e2f4)

[Some other interesting information could be founded on serverless blog](https://serverless.com/framework/docs/providers/aws/events/apigateway/#share-api-gateway-and-api-resources)

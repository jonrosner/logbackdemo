# How to replicate

Start the application

1. `mvn clean package`
2. `java -jar target/logbackdemo-0.0.1-SNAPSHOT.jar`

You will see that the log output looks something like this

```
{"level":"INFO","logger_name":"io.awspring.cloud.paramstore.AwsParamStorePropertySourceLocator","message":"Loading property from AWS Parameter Store with name: /config/null_dev/, optional: false","environment":"dev","version":"1.23","service":"test"}
```

Note the service and version property.

Now run `curl -X POST localhost:8080/actuator/refresh`

And then `curl localhost:8080/test`

You will see that the output looks something like this

```
{"level":"INFO","logger_name":"com.example.logbackdemo.DemoController","message":"received test request","environment":"dev","traceId":"57b60bde0ce8e99b","spanId":"57b60bde0ce8e99b"}
```

Service and version field are now missing.


# dropwizard-async-serlvet-demo
Demo app showing an asynchronous Servlet endpoint in a DropWizard 0.8.0 app with Jetty 9

## Build
```
$ mvn clean package
```

## Run the server
```
$ java -jar target/dropwizard-async-servlet-demo.jar server
```

## Issue request with Curl
```
$ curl http://localhost:8080/async
```

You should see output like:
```
$ curl -vvv http://localhost:8080/async
* About to connect() to localhost port 8080 (#0)
*   Trying ::1...
* connected
* Connected to localhost (::1) port 8080 (#0)
> GET /async HTTP/1.1
> User-Agent: curl/7.24.0 (x86_64-apple-darwin12.0) libcurl/7.24.0 OpenSSL/0.9.8| zlib/1.2.5
> Host: localhost:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Fri, 06 Feb 2015 19:42:35 GMT
< Vary: Accept-Encoding
< Transfer-Encoding: chunked
<
1
2
3
4
5
6
7
8
9
10
* Connection #0 to host localhost left intact
* Closing connection #0
```


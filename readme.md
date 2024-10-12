# Spring Boot 2 and Infinispan 15

## Version
- Infinispan 'I'm Still Standing' 15.0.7.Final
- Java 17
- Spring Boot 2.7.8

## Cache Configuration
```json
{
  "replicated-cache": {
    "mode": "SYNC",
    "statistics": true,
    "encoding": {
      "media-type": "application/x-protostream"
    },
    "indexing": {
      "enabled": true,
      "storage": "filesystem",
      "startup-mode": "AUTO",
      "indexing-mode": "AUTO",
      "indexed-entities": [
        "proto.User"
      ]
    }
  }
}
```

## How to Test
```
$ curl -kv http://localhost:8080/user -X POST \ 
        -d '{"name":"Ryoko Hirosue", "age":29,"address":"Ciledug"}' \
        -H "Content-Type: application/json"
*   Trying [::1]:8080...
* Connected to localhost (::1) port 8080
> POST /user HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.4.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 54
>
< HTTP/1.1 201
< Content-Length: 0
< Date: Sat, 12 Oct 2024 10:54:43 GMT
<
* Connection #0 to host localhost left intact
```

```
$  curl -kv http://localhost:8080/user
*   Trying [::1]:8080...
* Connected to localhost (::1) port 8080
> GET /user HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.4.0
> Accept: */*
>
< HTTP/1.1 200
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 12 Oct 2024 10:55:44 GMT
<
* Connection #0 to host localhost left intact
[{"name":"Ryoko Hirosue","age":29,"address":"Ciledug"}]           
```
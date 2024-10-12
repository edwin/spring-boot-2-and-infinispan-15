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
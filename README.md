# Camunda Extensions

## Requirements

* [Kotlin](https://kotlinlang.org/docs/getting-started.html) `1.4.31`

## Building

```
./gradlew clean build
```

## Testing

Run all tests with:
```
./gradlew cleanTest test
```

Run a single suite using filtering:
```
./gradlew cleanTest test --tests OrderTest
```

## Documentation

Generate documentation manually:
```
./gradlew dokkaGfm
```
You can read the documentation [here](docs).

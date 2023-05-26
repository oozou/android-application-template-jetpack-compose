# DaFund

### Static Analysis

- on your first build, gradle will add `githook` `pre-commit` so when you commit it will
  run `./gradlew ktlintCheck` to check the stage files
- you can manual run ktlint by `./gradlew ktlintCheck`
- you can use auto-format by `./gradlew ktlintFormat`

### Deployment

- (Temporary) we will only have 2 flavors for this project (Develop, Production)
- Everytime we `push` the code by merging `Pull Request` to `main` branch, the workflow will
  triggered and create `Develop` build then distribute to `Firebase`
- Everytime we `push` the code by create a new `tag` with `v*` name pattern the workflow will
  triggered and create `Production` build then distribute to `Firebase`

### How to add new secret keys in NDK

This project is using https://github.com/klaxit/hidden-secrets-gradle-plugin plugin to keep secret
keys safe and accessible from `${Develop|uat|Production}.properties`,

1. Update the keys in `${Develop|uat|Production}.properties`
2. Run below script to generate the keys as an NDK library or run `script/build-secrets-develop.sh`
    ```
    ./gradlew hideSecretFromPropertiesFile -PpropertiesFileName=${Develop|uat|Production}.properties -Ppackage=com.kbank.dafund
    ```
3. Now you can use the updated key using `Secrets().getNewSecretKey("com.kbank.dafund")` class that
   generated inside common module.

### How to run this project

1. Copy `${Develop|uat|Production}.properties` into the root of the folder
2. Run below command to generate all the required secret keys in the NDK library or
   run `script/build-secrets-develop.sh`
   ```
   ./gradlew hideSecretFromPropertiesFile -PpropertiesFileName=${Develop|uat|Production}.properties -Ppackage=com.kbank.dafund
   ```
3. Run the project

# DaFund
### Static Analysis
- on your first build, gradle will add `githook` `pre-commit` so when you commit it will run `./gradlew ktlintCheck` to check the stage files
- you can manual run ktlint by `./gradlew ktlintCheck`
- you can use auto-format by `./gradlew ktlintFormat`

### Deployment
- (Temporary) we will only have 2 flavors for this project (Develop, Production)
- Everytime we `push` the code by merging `Pull Request` to `main` branch, the workflow will triggered and create `Develop` build then distribute to `Firebase`
- Everytime we `push` the code by create a new `tag` with `v*` name pattern the workflow will triggered and create `Production` build then distribute to `Firebase`

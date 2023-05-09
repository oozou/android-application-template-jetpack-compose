//app level config constants
object AppConfig {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    val buildNumber = (System.getenv("GITHUB_RUN_NUMBER") ?: "1").toString().toInt()
    val versionCode = buildNumber
    const val versionName = "1.0.0"
}

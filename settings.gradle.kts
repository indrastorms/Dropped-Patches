rootProject.name = "dropped-patches"

buildCache {
    local {
        isEnabled = "CI" !in System.getenv()
    }
}

group = "dropped.patches"

patches {
    about {
        name = "Dropped Patches"
        description = "Patches for ReVanced."
        source = "git@github.com:you/revanced-patches.git"
        author = "indrastorms"
        contact = "https://t.me/Indra012"
        license = "GNU General Public License v3.0"
    }
}
dependencies {
    // Used by JsonGenerator.
    implementation(libs.gson)
    // Required due to smali, or build fails. Can be removed once smali is bumped.
    implementation(libs.guava)
}

tasks {
    jar {
        exclude("app/revanced/generator")
    }

    register<JavaExec>("generatePatchesFiles") {
        description = "Generate patches files"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("app.revanced.generator.MainKt")
    }

    // Used by gradle-semantic-release-plugin.
    publish {
        dependsOn("generatePatchesFiles")
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/indrastorms/dropped-patches")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

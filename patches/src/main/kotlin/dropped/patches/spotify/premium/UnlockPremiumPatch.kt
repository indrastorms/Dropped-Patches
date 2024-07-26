package dropped.patches.spotify.premium

import app.revanced.patcher.patch.rawResourcePatch
import dropped.patches.shared.misc.hex.hexPatch
import dropped.patches.shared.misc.hex.Replacement

@Suppress("unused")
val unlockPremiumPatch = rawResourcePatch(
    name = "Unlock Spotify Premium",
    description = "Unlock Spotify Premium features for ARM64 devices. " +
        "Server-sided features like downloading songs are still locked. ",
) {
    compatibleWith("com.spotify.music"("8.9.8.545"))

    dependsOn {
      hexPatch {
        execute {
          Replacement(
            "01 0a 2a 89 00 00 34",
            "01 0a 2a 1f 20 03 d5",
            "lib/arm64-v8a/liborbit-jni-spotify.so"
          )
          Replacement(
            "94 1f 31 00 71 81 00 00 54",
            "94 1f 31 00 71 04 00 00 14",
            "lib/arm64-v8a/liborbit-jni-spotify.so"
          )
          Replacement(
            "e1 01 00 54 20",
            "0f 00 00 14 20",
            "lib/arm64-v8a/liborbit-jni-spotify.so"
          )
        }
      }
    }
  }

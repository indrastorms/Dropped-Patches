package dropped.patches.spotify.premium

import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import dropped.patches.shared.misc.hex.BaseHexPatch

@Patch(
    name = "Unlock Spotify Premium",
    description = "Unlock Spotify Premium features for ARM64 devices. " +
        "Server-sided features like downloading songs are still locked. ",
    compatiblePackages = [
        CompatiblePackage(
            "com.spotify.music",
            [
                "8.9.56.618",
            ],
        ),
    ],
)
@Suppress("unused")
class UnlockPremiumPatch : BaseHexPatch() {
    private val arm64Replacements = listOf(
        Replacement(
            "24 21 14 fe 0f 1c f8",
            "24 21 14 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "1f 21 14 fe 0f 1c f8",
            "1f 21 14 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "f7 17 ff 83 06 d1",
            "f7 17 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "0f 00 f1 01 f9",
            "0f 00 f1 00 f9",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "16 94 80 01 00 36 88",
            "16 94 0c 00 00 14 88",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "40 41 39 88 00 00 34 80",
            "40 41 39 04 00 00 14 80",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "94 c0 00 00 36 a8",
            "94 06 00 00 14 a8",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "68 03 00 34 61",
            "1b 00 00 14 61",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "40 39 88 03 00 34 e0",
            "40 39 1c 00 00 14 e0",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "2e 17 14 fd 7b ba a9",
            "2e 17 14 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "39 17 94 fd 7b ba a9",
            "39 17 94 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "7a f6 17 ff 03 05 d1",
            "7a f6 17 c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "f7 14 14 ff 43 01 d1 fe",
            "f7 14 14 c0 03 5f d6 fe",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "61 12 00 54 00",
            "93 00 00 14 00",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "c0 03 00 54 c0",
            "1e 00 00 14 c0",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "5e 0c 14 fd 7b ba a9 fc",
            "5e 0c 14 c0 03 5f d6 fc",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "00 71 81 00 00 54 81",
            "00 71 04 00 00 14 81",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "0a 2a 89 00 00 34 01",
            "0a 2a 1f 20 03 d5 01",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        )
  )

    // To support other architectures, add replacements for them.
    override val replacements = arm64Replacements
}

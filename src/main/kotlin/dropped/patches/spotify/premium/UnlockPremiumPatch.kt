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
            "fe 0f 1c f8",
            "c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "ff 83 06 d1",
            "c0 03 5f d6",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "f1 01 f9 ff 54",
            "f1 00 f9 ff 54",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "80 01 00 36 88",
            "0c 00 00 14 88",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "88 00 00 34 80",
            "04 00 00 14 80",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "c0 00 00 36 a8",
            "06 00 00 14 a8",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "68 03 00 34 61",
            "1b 00 00 14 61",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "88 03 00 34 e0",
            "1c 00 00 14 e0",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "fd 7b ba a9 fc",
            "c0 03 5f d6 fc",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "ff 03 05 d1 fd",
            "c0 03 5f d6 fd",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "ff 43 01 d1 fe",
            "c0 03 5f d6 fe",
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
            "fd 7b ba a9 fc",
            "c0 03 5f d6 fc",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "81 00 00 54 81",
            "04 00 00 14 81",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        ),
        Replacement(
            "89 00 00 34 01",
            "1f 20 03 d5 01",
            "lib/arm64-v8a/liborbit-jni-spotify.so",
        )
  )

    // To support other architectures, add replacements for them.
    override val replacements = arm64Replacements
}

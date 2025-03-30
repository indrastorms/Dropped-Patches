package dropped.patches.fxfileexplorer.unlockplus

import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val unlockPlusPatch = bytecodePatch(
    name = "Unlock FX Plus",
    description = "Unlock features like 'Web Access', 'Network' and 'FX Connect'.",
) {
    compatibleWith("nextapp.fx")

    execute {
        isPlusUnlockedFingerprint.method.addInstructions(
            0,
            """
            const/4 v0, 0x1
            return v0
        """,
        )
    }
}

package dropped.patches.tasker.trial.unlock

import app.revanced.patcher.extensions.InstructionExtensions.addInstruction
import app.revanced.patcher.patch.bytecodePatch

val unlockLicensePatch = bytecodePatch(
    name = "Unlock trial",
    description = "Unlocks the trial version.",
) {
    compatibleWith("net.dinglisch.android.taskerm")

    execute {
        checkLicenseFingerprint.method.addInstruction(0, "return-void")
        // Return the method early, which prompts the user with a non dismissible dialog, when the trial period is over.
    }
}

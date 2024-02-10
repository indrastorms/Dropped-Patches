package app.revanced.patches.tasker.trial.unlock.patch

import app.revanced.util.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patches.tasker.trial.unlock.fingerprints.CheckLicenseFingerprint

@Patch(
    name = "Unlock trial",
    description = "Unlocks the trial version.",
    compatiblePackages = [
         CompatiblePackage("net.dinglisch.android.taskerm")
            ]
)
object UnlockLicensePatch : BytecodePatch(
    setOf(
        CheckLicenseFingerprint
    )
) {
    override fun execute(context: BytecodeContext) = CheckLicenseFingerprint
        .result
        ?.mutableMethod
        // Return the method early, which prompts the user with a non dismissible dialog, when the trial period is over.
        ?.addInstruction(0, "return-void")
        ?: throw CheckLicenseFingerprint.exception
}

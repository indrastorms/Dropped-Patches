package dropped.patches.nova.prime

import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val unlockPrimePatch = bytecodePatch(
    name = "Unlock prime",
    description = "Unlocks Nova Prime and all functions of the app.",
) {
    compatibleWith("com.teslacoilsw.launcher")

    val unlockPrimeMatch by unlockPrimeFingerprint()

    execute {
        // Any value except 0 unlocks Nova Prime, but 512 is needed for a protection mechanism
        // otherwise the preferences will be reset if the status on disk changes after a restart.
        val PRIME_STATUS = 512
        val setStatusIndex = unlockPrimeMatch.patternMatch!!.startIndex

        unlockPrimeMatch.mutableMethod.apply {
            val statusRegister = getInstruction<OneRegisterInstruction>(setStatusIndex).registerA
            replaceInstruction(setStatusIndex, "const/16 v$statusRegister, $PRIME_STATUS")
        }
    }
}
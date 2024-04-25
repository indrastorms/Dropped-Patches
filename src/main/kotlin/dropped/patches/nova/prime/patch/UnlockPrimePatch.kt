package dropped.patches.nova.prime.patch

import app.revanced.util.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import dropped.patches.nova.prime.fingerprints.UpdatePrimeStatusFingerprint
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Patch(
    name = "Unlock prime",
    description = "Unlocks Nova Prime and all functions of the app.",
    compatiblePackages = [CompatiblePackage("com.teslacoilsw.launcher")]
)
@Suppress("unused")
object UnlockPrimePatch : BytecodePatch(
    setOf(UpdatePrimeStatusFingerprint)
) {
  // Any value except 0 unlocks Nova Prime, but 512 is needed for a protection mechanism
  // otherwise the preferences will be reset if the status on disk changes after a restart.
  private const val PRIME_STATUS = 512

  override fun execute(context: BytecodeContext) = UpdatePrimeStatusFingerprint.result?.let {
      val setStatusIndex = it.scanResult.patternScanResult!!.startIndex

      it.mutableMethod.apply {
          val statusRegister = getInstruction<OneRegisterInstruction>(setStatusIndex).registerA
          replaceInstruction(setStatusIndex, "const/16 v$statusRegister, $PRIME_STATUS")
      }

      return@let
  } ?: throw UpdatePrimeStatusFingerprint.exception
}

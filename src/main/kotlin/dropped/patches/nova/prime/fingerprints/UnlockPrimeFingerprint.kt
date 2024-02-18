package app.revanced.patches.nova.prime.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.Opcode

object UpdatePrimeStatusFingerprint : MethodFingerprint(
    opcodes = listOf(Opcode.CONST_4), // Modify this to change the prime status.
    strings = listOf("widget_reset_ids")
)

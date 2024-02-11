package app.revanced.patches.nova.prime.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.Opcode

object UnlockPrimeFingerprint : MethodFingerprint(
    "V",
    opcodes = listOf(
        Opcode.IPUT_OBJECT,
        Opcode.CONST_STRING,
        Opcode.CONST_4,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT
    ),
    strings = listOf("1")
)

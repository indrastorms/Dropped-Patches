package dropped.patches.nova.prime

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val unlockPrimeFingerprint = fingerprint {
    opcodes(Opcode.CONST_4) // Modify this to change the prime status.
    strings("widget_reset_ids")
  }

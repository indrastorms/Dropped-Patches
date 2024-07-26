package dropped.patches.fxfileexplorer.unlockplus

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val isPlusUnlockedFingerprint = fingerprint {
    returns("Z")
    accessFlags(AccessFlags.PRIVATE, AccessFlags.STATIC)
    strings("keysig= ","\nlocalsig=","nextapp.fx")
    opcodes(
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CONST_16,
        Opcode.CONST_4,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT
    )
  }

package dropped.patches.tasker.trial.unlock.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint

object CheckLicenseFingerprint : MethodFingerprint(
    strings = listOf("Can't check license")
)

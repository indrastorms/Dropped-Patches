package app.revanced.patches.tasker.trial.unlock.annotations

import app.revanced.patcher.patch.annotation.Compatibility
import app.revanced.patcher.patch.annotation.Package

@Compatibility([Package("net.dinglisch.android.taskerm")])
@Target(AnnotationTarget.CLASS)
internal annotation class UnlockTrialCompatibility

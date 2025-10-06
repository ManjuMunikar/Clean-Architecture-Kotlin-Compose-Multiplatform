package hrm.compose.multiplatform

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import hrm.compose.multiplatform.utils.App

fun MainViewController() = ComposeUIViewController {
    App(
        batteryManager = remember { BatteryManager() }
    )
}
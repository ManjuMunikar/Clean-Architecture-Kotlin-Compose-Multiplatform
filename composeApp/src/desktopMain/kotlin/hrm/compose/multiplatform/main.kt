package hrm.compose.multiplatform

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Hrm",
    ) {
        App(batteryManager = remember { BatteryManager() })
    }
}
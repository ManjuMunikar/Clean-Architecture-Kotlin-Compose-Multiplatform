package hrm.compose.multiplatform.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import hrm.compose.multiplatform.BatteryManager
import hrm.compose.multiplatform.presentation.ui.screen.navigation.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    batteryManager: BatteryManager
) {
    MaterialTheme {
//        Box(
//            modifier = Modifier
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ){
//            Text(text = "The current battery level is ${batteryManager.getBatteryLevel()}")
//        }

        MainScreen()
    }
}

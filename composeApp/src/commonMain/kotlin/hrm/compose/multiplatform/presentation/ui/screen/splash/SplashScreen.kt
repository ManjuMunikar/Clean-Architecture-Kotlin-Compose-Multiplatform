package hrm.compose.multiplatform.presentation.ui.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hrm.compose.multiplatform.presentation.ui.components.AppIcon
import hrm.composeapp.generated.resources.Res
import hrm.composeapp.generated.resources.splash_icon

@Composable
fun SplashScreen(onNavigate: () -> Unit, onNavigateProfile: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        // Display splash screen image
        AppIcon(
            Res.drawable.splash_icon,
            modifier = Modifier.width(250.dp).height(250.dp),
        )
        Column {
            Button(onClick = { onNavigate() }) {
                Text("Login")
            }
            Button(onClick = { onNavigateProfile() }) {
                Text("Profile")
            }

        }


    }
}
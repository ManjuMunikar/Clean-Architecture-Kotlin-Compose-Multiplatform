package hrm.compose.multiplatform.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun AppIcon(
    imageRes: DrawableResource,
    modifier: Modifier = Modifier.width(250.dp).height(250.dp),
    alignment: Alignment = Alignment.Center
) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = alignment
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = modifier
        )
    }
}
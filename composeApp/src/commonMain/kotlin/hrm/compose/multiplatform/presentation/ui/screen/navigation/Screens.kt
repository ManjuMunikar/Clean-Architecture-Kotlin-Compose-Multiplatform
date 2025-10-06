package hrm.compose.multiplatform.presentation.ui.screen.navigation

import kotlinx.serialization.Serializable

enum class Screens(val title: String) {
    Splash(title = "Splash"),
    Login(title = "Login")
}

sealed class Route {
    @Serializable
    data object SplashRoute : Route()

    @Serializable
    data object LoginRoute : Route()

    @Serializable
    data object ProfileRoute : Route()
}
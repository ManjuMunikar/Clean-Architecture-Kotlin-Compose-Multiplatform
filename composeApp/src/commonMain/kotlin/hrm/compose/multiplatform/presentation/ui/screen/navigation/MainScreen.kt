package hrm.compose.multiplatform.presentation.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import hrm.compose.multiplatform.presentation.ui.screen.splash.LoginScreen
import hrm.compose.multiplatform.presentation.ui.screen.splash.ProfileScreen
import hrm.compose.multiplatform.presentation.ui.screen.splash.SplashScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Route.SplashRoute
    ) {

        composable<Route.SplashRoute> {
            SplashScreen(onNavigate = { navController.navigate(Route.LoginRoute) },
                onNavigateProfile = { navController.navigate(Route.ProfileRoute) })
        }
        composable<Route.LoginRoute> {
            LoginScreen()

        }
        composable<Route.ProfileRoute> {
            ProfileScreen()

        }

    }

}
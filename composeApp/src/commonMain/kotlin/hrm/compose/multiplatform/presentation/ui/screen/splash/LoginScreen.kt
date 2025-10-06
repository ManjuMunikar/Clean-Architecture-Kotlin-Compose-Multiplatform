package hrm.compose.multiplatform.presentation.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import hrm.compose.multiplatform.presentation.ui.components.AppIcon
import hrm.composeapp.generated.resources.Res
import hrm.composeapp.generated.resources.splash_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // State variables for error messages
    var emailError by remember { mutableStateOf<String?>("") }
    var passwordError by remember { mutableStateOf<String?>("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppIcon(
            Res.drawable.splash_icon,
            modifier = Modifier.width(250.dp).height(250.dp)
        )

        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Enter your email") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            isError = emailError != "",
        )
        emailError?.let { errorText ->
            Text(text = errorText, color = androidx.compose.ui.graphics.Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password input field with an icon and visibility toggle
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon")
            },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Toggles visibility
            shape = RoundedCornerShape(8.dp),
            isError = passwordError != ""  // Check if there's an error
        )
        passwordError?.let { errorText ->  // Display error message
            Text(text = errorText, color = androidx.compose.ui.graphics.Color.Red, modifier = Modifier.padding(top = 4.dp))
        }


        Spacer(modifier = Modifier.height(32.dp))

        // Login button
        Button(
            onClick = {
                // Handle login logic here
                emailError = validateEmail(email)
                passwordError = validatePassword(password)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}
// Email validation function
fun validateEmail(email: String): String? {
    return when {
        email.isEmpty() -> "Email cannot be empty"
//        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
        !email.endsWith("@gmail.com") -> "Email must be a gmail.com address"
        else -> ""
    }
}

// Password validation function
fun validatePassword(password: String): String? {
    return when {
        password.isEmpty() -> "Password cannot be empty"
        password.length < 6 -> "Password must be at least 6 characters long"
        else -> ""
    }
}

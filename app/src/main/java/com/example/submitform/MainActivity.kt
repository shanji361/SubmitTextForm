package com.example.submitform

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.submitform.ui.theme.SubmitFormTheme

private const val TAG = "LoginForm"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SubmitFormTheme {
                LoginScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Login") }, // title displayed in top bar
                //usage of M3 colors
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        modifier = modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Welcome!",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,

            )

            // stores the current text in the username TextField
            var username by remember { mutableStateOf("") }
            // stores whether there is an error with the username input (no error by default)
            var usernameError by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = username, //the text in the field
                // `onValueChange` is called every time user types
                // 'it' changes accord to user typed value
                onValueChange = {
                    username = it
                    usernameError = false // clear error when user starts typing
                    Log.d(TAG, "Username value changed: $it") // log change
                },
                // provides a floating label above the text field
                label = { Text("Username") },

                // highlights TextField (with error color) if theres an input error
                isError = usernameError,
                // displays error messages below the TextField
                supportingText = {
                    if (usernameError) {
                        // display error message
                        Text(
                            text = "Username cannot be empty",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next        // shows a "Next" action button on the keyboard
                ),
                // usage of M3 colors
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                ),

                modifier = Modifier
                    .fillMaxWidth()
            )

            //password TextField

            // stores current text in the password TextField
            var password by remember { mutableStateOf("") }
            // stores whether there is an error with the password input (no error by default)
            var passwordError by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = password,
                // called every time user types or changes the text
                onValueChange = {
                    password = it
                    passwordError = false // clear error when user starts typing
                    Log.d(TAG, "Password value changed") // log change
                },
                // floating label above the text field
                label = { Text("Password") },
                // mask the password input
                visualTransformation = PasswordVisualTransformation(),

                // highlights TextField if there's an input error
                isError = passwordError,
                // displays error messages below TextField
                supportingText = {
                    if (passwordError) {
                        Text(
                            text = "Password cannot be empty",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, // suggests a password input keyboard
                    imeAction = ImeAction.Done           // shows "Done" action button on the keyboard
                ),
                // use of M3 colors
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            // login button

            Button(
                onClick = {
                    // check if username or password is blank
                    usernameError = username.isBlank()
                    passwordError = password.isBlank()

                    if (!usernameError && !passwordError) {
                        Log.d(TAG, "Login successful for user: $username")
                    } else {
                        Log.d(TAG, "Login failed")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                // text on the button
                // usage of M3 typography
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            // vertical space after the button
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
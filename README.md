# Login Form Example

A simple Jetpack Compose app example that demonstrates how to use **Scaffold** with a **Top App Bar** and a **form layout** containing text fields and a button.  
This app showcases input validation, error handling, and Material 3 styling.

---

## Features

- **Top App Bar** with a title ("Login").  
- **Username field** with error validation (cannot be empty).  
- **Password field** with masked input and error validation (cannot be empty).  
- **Login button** that checks input fields and logs success or failure.  
- **Error messages** displayed under each field when input is invalid.  
- Styled with **Material 3 components** (colors, typography, etc.).  

---

### `LoginScreen`
- Implements the overall UI inside a `Scaffold`.  
- Contains the following elements:  
  - **TopAppBar**: Displays the title "Login" with Material 3 colors.  
  - **Column Layout**: Centers the content vertically and horizontally.  
  - **Welcome Text**: A headline greeting styled with Material 3 typography.  
  - **OutlinedTextField (Username)**:  
    - Tracks state with `remember`.  
    - Shows error text if empty.  
  - **OutlinedTextField (Password)**:  
    - Uses `PasswordVisualTransformation` to mask input.  
    - Shows error text if empty.  
  - **Button (Login)**:  
    - Validates fields when clicked.  
    - Displays success/failure logs using `Log.d`.  

---

## Reference
- Lecture 3 Example 27 

- [Android Studio Developers](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/input/VisualTransformation)

- [Kotlin Langauge](https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter)

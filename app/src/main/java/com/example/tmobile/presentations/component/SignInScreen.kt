@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING")

package com.example.tmobile.presentations.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tmobile.R
import com.example.tmobile.presentations.viewModel.SignInViewModel

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen()
}

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    signInButtonClick: () -> Unit = {}
) {

    val userEmail = rememberSaveable { mutableStateOf("") }
    val emailError = rememberSaveable { mutableStateOf(null) }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val showDialog by viewModel.showDialog.collectAsState()


    if (showDialog) {
        TAlertDialog(viewModel.showDialog, viewModel.errorMessage.value)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Spacer(Modifier.size(30.dp))

        Text(
            stringResource(R.string.sign_in_to_your_account),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(1.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.size(30.dp))

                TextField(
                    value = userEmail.value,
                    singleLine = true,
                    leadingIcon = {
                          Icon(
                            Icons.Default.Email,
                            contentDescription = stringResource(R.string.email_address)
                        )
                    },
                    label = {
                        Text(text = stringResource(R.string.email_address))
                    },
                    onValueChange = {
                        userEmail.value = it
                    }
                    )

                Spacer(Modifier.size(10.dp))
                TextField(
                    value = password.value, leadingIcon = {
                        Icon(
                            Icons.Filled.Lock,
                            contentDescription = stringResource(R.string.password)
                        )
                    },
                    label = {
                        Text(text = stringResource(R.string.password))
                    },
                    onValueChange = { newValue ->
                        password.value = newValue

                    },
                    singleLine = true,
                    visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton ( onClick = {
                            passwordVisibility.value= !passwordVisibility.value
                        }){
                            Icon(if(passwordVisibility.value) painterResource(R.drawable.baseline_visibility_24)
                                else
                                painterResource(R.drawable.baseline_visibility_off_24)
                                , contentDescription = "visibilty",
                            modifier = Modifier.size(16.dp),

                        )
                    }}
                )
                Spacer(Modifier.size(20.dp))
                Button(
                    onClick = {
                        if(userEmail.value.isNotEmpty() && password.value.isNotEmpty())
                        viewModel.login(userEmail.value,password.value,signInButtonClick)
                              else {
                                 viewModel.showDialog("Please fill the details first")
                              }},
                    modifier = Modifier.padding(5.dp),
                    enabled = true,
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonColors(
                        Color.Blue,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Cyan
                    )
                ) {
                    Text(
                        text = stringResource(R.string.sign_in),
                        color = Color.White
                    )
                }
                Spacer(Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = {
            viewModel.showDialog("Create An Account")
        }) {
            Text(
                stringResource(R.string.need_an_account),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }

}
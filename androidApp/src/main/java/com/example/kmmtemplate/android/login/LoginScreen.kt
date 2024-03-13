package com.example.kmmtemplate.android.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.kmmtemplate.android.R
import com.example.kmmtemplate.android.navigation.home
import com.example.kmmtemplate.android.views.ButtonWithLoadingIndicator
import com.example.kmmtemplate.android.views.ErrorBanner
import com.example.kmmtemplate.android.login.views.PasswordTextField
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = getViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_large)))

        Text(
            text = stringResource(id = R.string.login_title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

        val error = viewModel.error.value != null
        AnimatedVisibility(error) {
            viewModel.error.value?.let {
                ErrorBanner(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }

        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = {
                if (viewModel.email.value.isBlank()) {
                    Text(stringResource(id = R.string.login_email_placeholder))
                }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        )

        PasswordTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = {
                if (viewModel.password.value.isBlank()) {
                    Text(stringResource(id = R.string.login_password_placeholder))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        )

        Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_small)))

        ButtonWithLoadingIndicator(
            loading = viewModel.loading.value,
            onClick = { viewModel.login { navController.home() } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(stringResource(id = R.string.login_button))
        }
    }
}
package com.example.kmmtemplate.android.camera

import android.Manifest
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.kmmtemplate.android.R
import com.example.kmmtemplate.android.util.PermissionsProvider
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
    navController: NavController,
    permissionsProvider: PermissionsProvider
) {
    val cameraPermission = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val audioPermission = rememberPermissionState(permission = Manifest.permission.RECORD_AUDIO)

    LaunchedEffect(key1 = Unit) {
        permissionsProvider.requestPermission(Manifest.permission.RECORD_AUDIO)
    }

    LaunchedEffect(key1 = audioPermission.status) {
        if (audioPermission.status == PermissionStatus.Granted) {
            permissionsProvider.requestPermission(Manifest.permission.CAMERA)
        }
    }

    if (cameraPermission.status == PermissionStatus.Granted && audioPermission.status == PermissionStatus.Granted) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CameraPreview(modifier = Modifier.fillMaxSize())

            Text(
                text = "*This is the emulator camera preview*",
                modifier = Modifier.background(Color.White)
            )
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        ) {
            // Explain to user why they need to allow certain permissionsa
            Text(
                text = "This application needs camera and microphone permissions to work properly",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            )

            // Open App settings to help users give the necessary permissions
            Button(
                onClick = { permissionsProvider.openSettings() }
            ) {
                Text(text = "Open settings")
            }
        }
    }
}
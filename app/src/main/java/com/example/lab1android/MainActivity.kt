package com.example.lab1android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.lab1android.ui.theme.Lab1AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1AndroidTheme {
                Column(
                    Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PhotoName()
                    Contacts()
                }
            }
        }
    }
}

@Composable
@Preview
fun PhotoName() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.LightGray),
            ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.photo),
                contentDescription = stringResource(R.string.picture_description),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
        Text(
            text = stringResource(R.string.name),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 7.em
        )
        Text(
            text = stringResource(R.string.post),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 4.em
        )
    }
}

@Composable
@Preview
fun Contacts ()
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )   {
        Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = stringResource(R.string.email_description),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(R.string.phone) + ": " + stringResource(R.string.phone_number),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
            Icon(
                Icons.Filled.Email,
                contentDescription = stringResource(R.string.email_description),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(R.string.email) + ": " + stringResource(R.string.email_adress),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
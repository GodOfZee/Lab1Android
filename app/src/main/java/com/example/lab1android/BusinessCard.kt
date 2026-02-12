package com.example.lab1android

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.lab1android.ui.theme.Lab1AndroidTheme

@Composable
fun BusinessCardLayout ()
{
    val context     = LocalContext.current
    val isLandscape =
        context.resources.configuration.orientation == ORIENTATION_LANDSCAPE

    if(isLandscape)
        LandscapeLayout()
    else
        PortraitLayout()
}

@Composable
fun PortraitLayout()
{
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement     = Arrangement.SpaceEvenly,
        horizontalAlignment     = Alignment.CenterHorizontally) {
        PhotoName()
        Contacts()
    }
}

@Composable
fun LandscapeLayout()
{
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalArrangement   = Arrangement.SpaceEvenly,
        verticalAlignment       = Alignment.CenterVertically) {
        PhotoName()
        Contacts()
    }
}

@Composable
fun PhotoName() {
    Column(
        verticalArrangement     = Arrangement.Center,
        horizontalAlignment     = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.avatar_size))
                .clip(CircleShape)
                .background(Color.LightGray),
            bitmap = ImageBitmap.imageResource(R.drawable.photo),
            contentDescription = stringResource(R.string.picture_description),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_size)))
        Text(
            text = stringResource(R.string.name),
            color = MaterialTheme.colorScheme.primary,
            fontSize = integerResource(R.integer.primary_font_size).em
        )
        Text(
            text = stringResource(R.string.post),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = integerResource(R.integer.secondary_font_size).em
        )
    }
}

@Composable
fun Contacts ()
{

    Column(
        verticalArrangement     = Arrangement.Center,
        horizontalAlignment     = Alignment.CenterHorizontally
    )   {
        Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = stringResource(R.string.phone_icon_description),
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_size)))
            Text(
                text = stringResource(R.string.phone) + ": " + stringResource(R.string.phone_number),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = integerResource(R.integer.on_background_font_size).em
            )
        }
        Row(modifier = Modifier.align(Alignment.Start), Arrangement.SpaceBetween) {
            Icon(
                Icons.Filled.Email,
                contentDescription = stringResource(R.string.email_icon_description),
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_size)))
            Text(
                text = stringResource(R.string.email) + ": " + stringResource(R.string.email_adress),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = integerResource(R.integer.on_background_font_size).em
            )
        }
    }
}

@Preview(showBackground = true, locale = "ru")
@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun PreviewBusinessCard() {
    Lab1AndroidTheme {
        BusinessCardLayout()
    }
}
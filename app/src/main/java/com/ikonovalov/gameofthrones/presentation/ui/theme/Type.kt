package com.ikonovalov.gameofthrones.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ikonovalov.gameofthrones.R

val OpenSans = FontFamily(
    Font(R.font.opensans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.opensans_bold_normal, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.opensans_extrabold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(R.font.opensans_extrabold_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.opensans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.opensans_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.opensans_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.opensans_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.opensans_semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.opensans_semibold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
)

val typography = Typography(
    h2 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    h3 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    h4 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = OpenSans,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp

    )
)
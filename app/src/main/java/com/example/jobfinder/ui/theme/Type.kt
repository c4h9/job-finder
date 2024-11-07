package com.example.jobfinder.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jobfinder.R

val SfProDisplay = FontFamily(
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle( // Title 1
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    displayMedium = TextStyle( // Title 2
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle( // Title 3
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle( // Title 4
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle( // Text 1
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle( // Button title 1
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle( // Button text 2
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle( // Tab text
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )    ,
    labelSmall = TextStyle( // Number
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 7.sp
    )
)
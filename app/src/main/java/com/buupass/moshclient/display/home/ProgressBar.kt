package com.buupass.moshclient.display.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.buupass.moshclient.R


@Composable
fun ProgressBar(message: String, show: Boolean = true, color: Color, dismissDialog: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = dismissDialog,
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = message,
                    style = TextStyle(
                        color = colorResource(id = R.color.black),
                        fontSize = 14.sp, fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.fillMaxWidth(.75f)
                )



                /*CircularProgressIndicator(color = color)*/
            }
        }
    }

}
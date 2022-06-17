package com.buupass.moshclient.display.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buupass.moshclient.model.FakeDataResItem
import com.buupass.moshclient.R


@Composable
fun ProductCard(fakeDataResItem: FakeDataResItem) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .width(200.dp)
            .background(color = Color.White, shape = RoundedCornerShape(32.dp))
    ) {
        val image = fakeDataResItem.image.let {
            loadPicture(
                url = it,
                defaultImage = DEFAULT_LOGO_IMAGE
            ).value
        } ?: loadPicture(
            url = "", defaultImage = DEFAULT_LOGO_IMAGE
        ).value
        image?.asImageBitmap()?.let {
            Image(
                bitmap = it, contentDescription = "", modifier = Modifier
                    .clip(
                        RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
                    .fillMaxWidth()
                    .height(130.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = fakeDataResItem.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold
                    ), modifier = Modifier.fillMaxWidth(.5f)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0 until fakeDataResItem.rating.count) {
                        if (i < 5){
                            Image(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "",
                                modifier = Modifier.size(12.dp)
                            )
                        }

                    }
                }
            }

            Text(
                text = fakeDataResItem.description,
                style = TextStyle(
                    color = Color.Black.copy(.7f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Text(
                text = "${fakeDataResItem.price}Ksh",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )


        }


    }
}
package com.buupass.moshclient.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.masjid.timetable.fragments.maps.MapScreen
import com.buupass.moshclient.R

@Composable
fun HomeScreen() {
    ConstraintLayout() {
        val (map, mapdetailsCont) = createRefs()

        MapScreen(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(map) {
                    top.linkTo(parent.top)
                }, zoom = 14f
        )


        Column(
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight(.63f)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.White.copy(.9f), Color.White
                        )
                    ),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .constrainAs(mapdetailsCont) {
                    top.linkTo(parent.top, 270.dp)
                }
                .padding(14.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .height(2.dp)
                        .background(color = Color.LightGray)
                ) {

                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Stumptown \nCoffee Roasters",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Row(
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color.Blue, shape = RoundedCornerShape(18.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.curvearrow),
                        contentDescription = "",
                        modifier = Modifier.size(37.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(60.dp)
            ) {

                Row(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        modifier = Modifier
                            .size(30.dp)
                            .background(color = Color.LightGray.copy(.75f), shape = CircleShape),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pin),
                            contentDescription = "",
                            modifier = Modifier.size(15.dp),
                            colorFilter = ColorFilter.tint(Color.Blue)
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "GPS Location",
                            style = TextStyle(color = Color.LightGray, fontSize = 11.sp)
                        )
                        Text(
                            text = "55.342711 ,12.512885",
                            style = TextStyle(color = Color.Black, fontSize = 14.sp)
                        )
                    }
                }

                Row(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        modifier = Modifier
                            .size(30.dp)
                            .background(color = Color.LightGray.copy(.75f), shape = CircleShape),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "",
                            modifier = Modifier.size(15.dp),
                            colorFilter = ColorFilter.tint(Color.Blue)
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Distance",
                            style = TextStyle(color = Color.LightGray, fontSize = 11.sp)
                        )
                        Text(
                            text = "2.2mi",
                            style = TextStyle(color = Color.Black, fontSize = 14.sp)
                        )
                    }
                }
            }


            val list = remember {
                mutableListOf(
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.two,
                    R.drawable.one,
                    R.drawable.three,
                )
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(items = list) { index, item ->

                    Image(
                        painter = painterResource(id = item),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .size(100.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            ),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Text(
                text = "Amenities",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )
            )

            val listone = remember {
                mutableListOf(
                    R.drawable.p,
                    R.drawable.tv,
                    R.drawable.phone,
                    R.drawable.card,
                    R.drawable.cart,
                    R.drawable.wifi,
                )
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(items = listone) { index, item ->
                    val color = if (index % 2 == 0) {
                        Color.Blue
                    } else Color.LightGray
                    Image(
                        painter = painterResource(id = item),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(32.dp),
                        colorFilter = ColorFilter.tint(color = color)
                    )
                }
            }

            Text(
                text = "Reviews",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )
            )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {
                    for (i in 0 until 8) {
                        ReviewItem()
                    }
                }



        }
    }

}

@Composable
fun ReviewItem() {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .width(300.dp)
            .background(color = Color.LightGray.copy(.3f), shape = RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.one),
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text(
                    text = "Alicia Osborne",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = "",
                        modifier = Modifier
                            .size(12.dp),
                        colorFilter = ColorFilter.tint(color = Color.LightGray)
                    )
                    Text(
                        text = "12-09-2018",
                        style = TextStyle(color = Color.LightGray, fontSize = 11.sp)
                    )
                }

            }
        }

        Text(
            text = "The Maps Compose library contains composable functions and data types that let you perform many common tasks. Some of the commonly used composable functions ",
            style = TextStyle(color = Color.Black, fontSize = 13.sp)
        )
    }
}


package com.example.bossesapp_ikermuinos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bossesapp_ikermuinos.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainView(navController: NavController){
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFF607D8B)),
        title = {
            Text(
                text = "Bienvenido a AppBosses",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(Color(0xFF607D8B))
    )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFB0C4DE)
                )
                .clip(RoundedCornerShape(16.dp))
        ) {

            Column(
                modifier = Modifier
                    .height(400.dp)
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fondomain),
                    contentDescription = "Bosses",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(325.dp)
                        .height(325.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .background(
                        shape = RoundedCornerShape(15.dp),
                        color = (Color(0x44708090))
                    )
            ){
                Text(
                    text = "Escoge un juego:",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 15.dp)
                )


                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 30.dp, bottom = 30.dp)

                ) {
                    // Botones
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ds1portada),
                            contentDescription = "Dark Souls",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("ds1") }
                                .width(90.dp)
                                .height(120.dp)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ds2portada),
                            contentDescription = "Dark Souls 2",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("ds2") }
                                .width(90.dp)
                                .height(120.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .padding(5.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ds3portada),
                            contentDescription = "Dark Souls 3",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("ds3") }
                                .width(90.dp)
                                .height(120.dp)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                    }

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.bbportada),
                            contentDescription = "Bloodborne",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("bloodborne") }
                                .width(90.dp)
                                .height(120.dp)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.erportada),
                            contentDescription = "Elden Ring",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("er") }
                                .width(90.dp)
                                .height(120.dp)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.dsportada),
                            contentDescription = "Demon Souls",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .clickable { navController.navigate("ds") }
                                .width(90.dp)
                                .height(120.dp)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                    }
                }
            }
        }
    }
}
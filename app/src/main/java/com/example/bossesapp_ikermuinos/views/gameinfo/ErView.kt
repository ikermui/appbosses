package com.example.bossesapp_ikermuinos.views.gameinfo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bossesapp_ikermuinos.R
import kotlin.math.abs

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EldenRingScreen(navController: NavController){

    var swipeOffset by remember { mutableStateOf(0f) }
    val maxSwipeDistance = 450f

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.liurnia),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(25.5.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xAA000000))
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFe0deb2), Color(0xFF55624c))
                    ),
                    shape = RoundedCornerShape((15.dp))
                )
        ){}
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
                .border(
                    width = 2.5.dp,
                    brush = Brush.linearGradient(
                        listOf(Color(0xFF55624c), Color(0xFFe0deb2))
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            // Título
            Text(
                text = "Elden Ring",
                color = Color(0xFF647c5a),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            )

            // Año
            Text(
                text = "2022",
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            )

            // Imagen del juego con su Swipeable
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Elden Ring",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset { IntOffset(-350, 0) }
                )
                Image(
                    painter = painterResource(id = R.drawable.er),
                    contentDescription = "Elden Ring",
                    modifier = Modifier
                        .size(200.dp)
                        .offset { IntOffset(swipeOffset.toInt(), 0) }
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures(
                                onDragEnd = {
                                    if (abs(swipeOffset) < maxSwipeDistance / 2) {
                                        swipeOffset = 0f
                                    } else {
                                        swipeOffset = -maxSwipeDistance
                                    }
                                },
                                onHorizontalDrag = { _, dragAmount ->
                                    swipeOffset = (swipeOffset + dragAmount)
                                        .coerceIn(
                                            -maxSwipeDistance,
                                            0f
                                        )
                                }
                            )
                        }
                )
            }

            // Descripción
            Text(
                text = "Elden Ring es un juego de rol de acción creado por Hidetaka Miyazaki de FromSoftware en colaboracion con el escritor George R. R. Martin y publicado por Bandai Namco el 25 de Febrero de 2022.\n\n" +
                        "El juego tiene lugar en un mundo enorme conocido como las Tierras Intermedias, en donde el jugador tiene libertad de exploracion en su gigante mundo, cruzando por regiones como Necrolimbo, Caelid, Liurnia y muchas mas.\n\n" +
                        "Elden Ring es la evolucion de todos los juegos de la saga, contando con elementos de todos los juegos anteriores, y llevandolos a su maximo esplendor, contando con una extensa cantidad de armas, armaduras, magias, hechizos, invocaciones, etc.\n\n" +
                        "Elden Ring fue muy bien recibido por la critica, llegando a ser considerado por mucha gente un juego historico y llegando a llevarse muchisimos premios como el de Game of the Year en The Game Awards de 2022. Ademas, recientemente se lanzo una expansion del juego, Shadow of the Erdtree",
                color = Color.White,
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            // Botón
            Button(
                shape = RoundedCornerShape(0.dp),
                onClick = { navController.navigate("buscador") },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF909567)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.5.dp)
            ) {
                Text(text = "IR AL BUSCADOR DE JEFES", color = Color.Black)
            }
        }
    }
}
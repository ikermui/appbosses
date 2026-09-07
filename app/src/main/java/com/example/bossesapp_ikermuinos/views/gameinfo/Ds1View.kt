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
fun DarkSoulsScreen(navController: NavController) {

    var swipeOffset by remember { mutableStateOf(0f) }
    val maxSwipeDistance = 450f

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.anorlondo),
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
                        listOf(Color(0xFFECD184), Color(0xFFFFEB8C))
                    ),
                    shape = RoundedCornerShape((15.dp))
                )
        ) {}
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
                .border(
                    width = 2.5.dp,
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFECD184), Color(0xFFFFEB8C))
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            // Título
            Text(
                text = "Dark Souls",
                color = Color(0xFFECD184),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            )

            // Año
            Text(
                text = "2011",
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
                    text = "Dark Souls",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset { IntOffset(-350, 0) }
                )
                Image(
                    painter = painterResource(id = R.drawable.ds1),
                    contentDescription = "Dark Souls",
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
                text = "Dark Souls es un juego de rol de acción creado por Hidetaka Miyazaki de FromSoftware y publicado por Bandai Namco el 22 de Septiembre de 2011.\n\n" +
                        "El juego tiene lugar en un entorno de fantasía medieval, donde el jugador lucha contra demonios, dragones, caballeros, fantasmas y otras entidades monstruosas.\n\n" +
                        "El juego se juega desde una perspectiva en tercera persona, donde exploras entornos interconectados mientras luchas contra enemigos con armas y magias.\n" +
                        "Una de las principales mecánicas del juego es la muerte, la cual te enseña a adaptarte a todo tipo de entorno a base de la repetición y de la prueba y error.\n\n" +
                        "Dark Souls fue muy bien aclamado por la crítica, llegando a considerarse por mucha gente uno de los mejores juegos de la historia y llegando a inspirar a mucha gente a crear juegos similares, naciendo así el género Soulslike. Este juego cuenta con una expansion, Artorias of the Abyss.",
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
                    Color(0xFFFFEB8C)
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
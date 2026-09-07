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
fun DarkSouls2Screen(navController: NavController){

    var swipeOffset by remember { mutableStateOf(0f) }
    val maxSwipeDistance = 450f

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.majula),
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
                        listOf(Color(0xFF2B3A4C), Color(0xFF7D899D))
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
                        listOf(Color(0xFF7D899D), Color(0xFF2B3A4C))
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            // Título
            Text(
                text = "Dark Souls 2",
                color = Color(0xFF7D899D),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            )

            // Año
            Text(
                text = "2014",
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
                    text = "Dark Souls 2",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset { IntOffset(-350, 0) }
                )
                Image(
                    painter = painterResource(id = R.drawable.ds2),
                    contentDescription = "Dark Souls 2",
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
                text = "Dark Souls 2 es un juego de rol de accion lanzado el 11 de Marzo de 2014 por Tomohiro Shibuya Yui Tanimura de FromSoftware y distribuido por Bandai Namco.\n\n" +
                        "El juego, al igual que su predecesor tiene lugar en un entorno de fantasía medieval, donde el jugador lucha contra demonios, dragones, caballeros, fantasmas y otras entidades monstruosas.\n\n" +
                        "Este juego tuvo un director distinto al del resto de la saga debido a que para este momento Hidetaka Miyazaki estaba desarrollando Bloodborne, asi que eligieron como director a Tomohiro Shibuya Yui Tanimura y Miyazaki paso a ser un supervisor del proyecto.\n\n" +
                        "Dark Souls 2 tuvo muchas opiniones mixtas, debido a que al tener un director distinto se tomaron ciertas decisiones de diseño que no terminaron de agradar a todo el mundo. El juego cuenta con 3 expansiones, Crown of the Sunken King, Crown of the Old Iron King y Crown of the Ivory King",
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
                    Color(0xFF7D899D)
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
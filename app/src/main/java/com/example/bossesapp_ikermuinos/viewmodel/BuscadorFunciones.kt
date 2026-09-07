package com.example.bossesapp_ikermuinos.viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bossesapp_ikermuinos.R
import com.example.bossesapp_ikermuinos.data.model.Boss

@Composable
fun calculaDiff(diff: Int){
    for (i in 1..diff){
        Image(
            painter = painterResource(id = R.drawable.dificultad),
            contentDescription = "diff",
            modifier = Modifier
                .size(40.dp)
                .padding(15.dp, 0.dp, 0.dp, 10.dp)
        )
    }
}

@Composable
fun encuentraJuego(boss: Boss){
    if(boss.juego == "Dark Souls"){
        Image(
            painter = painterResource(R.drawable.iconods1),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    } else if(boss.juego == "Dark Souls 2"){
        Image(
            painter = painterResource(R.drawable.iconods2),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    } else if(boss.juego == "Dark Souls 3"){
        Image(
            painter = painterResource(R.drawable.iconods3),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    } else if(boss.juego == "Bloodborne"){
        Image(
            painter = painterResource(R.drawable.iconobb),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    } else if(boss.juego == "Demon Souls"){
        Image(
            painter = painterResource(R.drawable.iconods),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    } else if(boss.juego == "Elden Ring"){
        Image(
            painter = painterResource(R.drawable.iconoer),
            contentDescription = "icono",
            modifier = Modifier
                .size(100.dp)
        )
    }
}
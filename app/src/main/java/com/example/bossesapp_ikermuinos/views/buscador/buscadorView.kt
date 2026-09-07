package com.example.bossesapp_ikermuinos.views.buscador

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bossesapp_ikermuinos.R
import com.example.bossesapp_ikermuinos.data.model.Boss
import com.example.bossesapp_ikermuinos.viewmodel.BossViewModel
import com.example.bossesapp_ikermuinos.viewmodel.calculaDiff
import com.example.bossesapp_ikermuinos.viewmodel.encuentraJuego

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BuscadorScreen(viewModel: BossViewModel){

    val state = viewModel.state
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFF4f3838)),
                title = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp, 0.dp, 10.dp, 0.dp)
                    ) {
                        Text(
                            text = "BUSCADOR DE JEFES",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF4f3838))
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                containerColor = Color(0xFF4f3838)
            ) {
                Text(
                    text = "",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn (
                modifier = Modifier
                    .background(Color(0xFF362d2c))
            ){
                state.bossList.forEach { boss ->
                    item {
                            Box(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .border(
                                        width = 2.5.dp,
                                        brush = Brush.linearGradient(
                                            listOf(Color(0xFFa1998d), Color(0xFFa1998d))
                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clip(
                                        RoundedCornerShape(10.dp)
                                    )
                                    .background(Color(0xFF24211d))
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Column(
                                        verticalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.weight(1f)
                                    ){
                                        Text(
                                            text = boss.nombre,
                                            color = Color.White,
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                            ),
                                            modifier = Modifier
                                                .padding(10.dp, 20.dp, 20.dp, 20.dp)
                                                .fillMaxWidth()
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Row {
                                            calculaDiff(boss.diff)
                                        }
                                    }
                                }
                                Box (
                                    modifier = Modifier
                                        .size(100.dp)
                                        .align(Alignment.CenterEnd)
                                        .padding(0.dp, 0.dp, 20.dp, 0.dp)
                                ){
                                    encuentraJuego(boss)
                                }
                            }
                        }
                    }
            }
        }
    }
}
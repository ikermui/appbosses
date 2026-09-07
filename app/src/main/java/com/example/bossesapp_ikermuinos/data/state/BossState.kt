package com.example.bossesapp_ikermuinos.data.state

import com.example.bossesapp_ikermuinos.data.model.Boss

data class BossState(
    val bossList : List<Boss> = listOf(
        Boss("Ornstein y Smough", "Dark Souls", 4),
        Boss("Huerfano de Kos", "Bloodborne", 5),
        Boss("Malenia, Espada de Miquella", "Elden Ring", 5),
        Boss("Caballero de la Torre", "Demon Souls", 2),
        Boss("Hermana Friede", "Dark Souls 3", 5),
        Boss("Sir Alonne", "Dark Souls 2", 4),
        Boss("Iudex Gundyr", "Dark Souls 3", 3),
        Boss("Padre Gascoigne", "Bloodborne", 3),
        Boss("Molinete", "Dark Souls", 1),
        Boss("El Perseguidor", "Dark Souls 2", 3),
        Boss("Viejo Rey Allant", "Demon Souls", 3),
        Boss("Hoarah Loux, Guerrero", "Elden Ring", 4),
        Boss("Sif, el Lobo Gris", "Dark Souls", 3),
        Boss("Amygdala", "Bloodborne", 2),
        Boss("Caballero Artorias", "Dark Souls", 3),
        Boss("Gigante de Fuego", "Elden Ring", 3),
        Boss("Rey de la Tormenta", "Demon Souls", 2),
        Boss("Alma de Ceniza", "Dark Souls 3", 3)
    ),
    val nombre: String = "",
    val juego: String = "",
    val productID: String? = null
)

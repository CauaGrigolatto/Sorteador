package br.edu.ifsp.dmo1.sorteador.model

import kotlin.random.Random

abstract class DrawStrategy() {
    protected val random = Random.Default
    abstract fun nextNumber(): Int
    abstract fun getMinLimit(): Int
    abstract fun getMaxLimit(): Int
}
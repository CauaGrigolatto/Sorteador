package br.edu.ifsp.dmo1.sorteador.model

object DefaultLimit : DrawStrategy() {
    private val DEFAULT_MAX_LIMIT = 1000

    override fun nextNumber(): Int {
        return random.nextInt(1, DEFAULT_MAX_LIMIT + 1)
    }

    override fun getMaxLimit(): Int {
        return DEFAULT_MAX_LIMIT
    }
}
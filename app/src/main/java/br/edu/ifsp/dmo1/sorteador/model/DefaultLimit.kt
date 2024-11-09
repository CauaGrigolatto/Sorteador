package br.edu.ifsp.dmo1.sorteador.model

object DefaultLimit : DrawStrategy() {
    private val DEFAULT_MIN_LIMIT = 1
    private val DEFAULT_MAX_LIMIT = 1000

    override fun nextNumber(): Int {
        return random.nextInt(DEFAULT_MIN_LIMIT, DEFAULT_MAX_LIMIT + 1)
    }

    override fun getMinLimit(): Int {
        return DEFAULT_MIN_LIMIT
    }

    override fun getMaxLimit(): Int {
        return DEFAULT_MAX_LIMIT
    }
}
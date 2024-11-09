package br.edu.ifsp.dmo1.sorteador.model

class DefinedLimit(private val minLimit: Int, private val maxLimit: Int) : DrawStrategy() {
    override fun nextNumber(): Int {
        return random.nextInt(minLimit, maxLimit + 1)
    }
    override fun getMinLimit(): Int {
        return minLimit
    }
    override fun getMaxLimit(): Int {
        return maxLimit
    }
}
package br.edu.ifsp.dmo1.sorteador.model

class DefinedLimit(private val maxLimit: Int) : DrawStrategy() {
    override fun nextNumber(): Int {
        return random.nextInt(1, maxLimit + 1)
    }

    override fun getMaxLimit(): Int {
        return maxLimit
    }
}
package br.edu.ifsp.dmo1.sorteador.model

data class DrawnNumber(val order: Int, val number: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DrawnNumber) return false

        return number == other.number
    }

    override fun hashCode(): Int {
        return number.hashCode()
    }

    override fun toString(): String {
        return "${order}º ${number}"
    }
}

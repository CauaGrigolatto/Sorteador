package br.edu.ifsp.dmo1.sorteador.model

class Draw(private val maxLimit: Int = 1000) {
    private var strategy: DrawStrategy
    private var history = HashSet<DrawnNumber>()

    init {
        if (maxLimit == 1000) {
            strategy = DefaultLimit
        }
        else {
            strategy = DefinedLimit(maxLimit)
        }
    }

    fun getNumber(): DrawnNumber {
        var drawn: DrawnNumber

        do {
            drawn = DrawnNumber(history.size + 1, strategy.nextNumber())
        } while(! history.add(drawn))

        return drawn
    }

    fun getHistory() = ArrayList(history)

    fun getMaxLimit() = strategy.getMaxLimit()

    fun isFull(): Boolean {
        return history.size == maxLimit
    }
}
package br.edu.ifsp.dmo1.sorteador.model

class Draw(private val minLimit: Int = 1, private val maxLimit: Int = 1000) {
    private lateinit var strategy: DrawStrategy
    private var history = HashSet<Int>()

    init {
        if (minLimit == 1 && maxLimit == 100) {
            strategy = DefaultLimit
        }
        else {
            strategy = DefinedLimit(minLimit, maxLimit)
        }
    }

    fun getNumber(): Int {
        var number: Int = 0

        do {
            number = strategy.nextNumber()
        } while(! history.add(number))

        return number
    }

    fun getHistory() = ArrayList(history)

    fun getMinLimit() = strategy.getMinLimit()

    fun getMaxLimit() = strategy.getMaxLimit()
}
object Hamming {
    fun compute(leftStrand: String, rightStrand: String) : Int {
        if (leftStrand=="" && rightStrand=="")
            return 0
        if (leftStrand.length != rightStrand.length) {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        else {
            var dif: Int = 0
            for ((index, value) in leftStrand.withIndex()) {
                if (!rightStrand.get(index).equals(value)) {
                    dif++
                }
            }
            return dif
        }
    }
}

class Series(private val input: String) {
    init {
        require(input.contains("^[0-9]*$".toRegex()))
    }

    fun getDigits(source: String): List<Int> {
        require(source.all { it in '0'..'9' })
        return source.map { it.toInt() - '0'.toInt() }
    }

    fun getLargestProduct(span: Int): Long {
        require(span <= input.length)
        require(span >= 0)
        if (span == 0)
            return 1
        else
        {
            val list: List<Int> = getDigits(input)
            var max:Long = 0;
            for(k in 0..(input.length-span))
            {
                var temp:Long =1
                for(i in k until (k+span))
                {
                    temp=temp*list[i]
                }
                if (max < temp)
                    max = temp
            }
            return max
        }
    }
}
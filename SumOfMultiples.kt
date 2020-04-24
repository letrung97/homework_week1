object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        var total:Int =0
        if(factors.isEmpty()){
            return 0
        }
        else {
            for (i in factors) {
                if (i!=0){
                    total += chain(i,limit)
                }
            }
            total = total - checkdupe(factors, limit)
        }
        return total
    }
    fun chain(num:Int,limit: Int):Int{
        var chain:Int=0
        for (i in 0..limit.div(num)){
            if (num*i<limit) {
                chain += num * i
            }
        }
        return chain
    }
    fun checkdupe(factors: Set<Int>, limit: Int):Int{
        var dupe:Int=0
        if (factors.size>1){
            for (m in 0..(factors.size-2)){
                var i = factors.elementAt(m)
                if (i!=0) {
                    for (n in (m+1)..(factors.size-1)) {
                        var o =factors.elementAt(n)
                        if (o!=i && o!=0){
                            dupe += check(lcm(o,i),limit)
                        }
                    }
                }
            }
            if (factors.size>2)
            {
                for (i in 0..(factors.size-3)){
                    for (j in (i+1)..(factors.size-2)){
                        for (k in (j+1)..(factors.size-1)) {
                            dupe -= check(lcm(lcm(factors.elementAt(i),factors.elementAt(j)),lcm(factors.elementAt(k),factors.elementAt(i))),limit)
                        }
                    }
                }
                if (factors.size>3)
                {
                    for (i in 0..(factors.size-3)){
                        for (j in (i+1)..(factors.size-2)){
                            for (k in (j+1)..(factors.size-1)) {
                                for (l in (k+1)..(factors.size-1)) {
                                    dupe += check(lcm(lcm(factors.elementAt(i), factors.elementAt(j)), lcm(factors.elementAt(k), factors.elementAt(l))), limit)
                                }
                            }
                        }
                    }
                    dupe -= check(lcm(lcm(lcm(factors.elementAt(0), factors.elementAt(1)), lcm(factors.elementAt(2), factors.elementAt(3))),factors.elementAt(4)),limit)
                }
            }
            return dupe
        }
        else {
            return 0
        }
    }
    fun lcm(num1:Int,num2:Int):Int{
        var lcm:Int=0;
        lcm = if (num1 > num2) num1 else num2
        while (true) {
            if (lcm % num1 == 0 && lcm % num2 == 0) {
                break
            }
            ++lcm
        }
        return lcm
    }
    fun check(num: Int,lim:Int):Int{
        var value:Int=0
        if (num<lim){
            var k:Int=num
            while (k<lim) {
                value += k
                k += num
            }
        }
        return value
    }
}

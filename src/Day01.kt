fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            var digits = ""
            for (i in line.indices) {
                if (line[i].isDigit()) {
                    digits += line[i]
                    break
                }
            }
            for (i in line.length-1 downTo 0) {
                if (line[i].isDigit()) {
                    digits += line[i]
                    break
                }
            }
            sum += digits.toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val numbers = arrayOf("1", "one", "2", "two", "3", "three", "4", "four", "5", "five",
                "6", "six", "7", "seven", "8", "eight", "9", "nine")
        var sum = 0
        for (line in input) {
            var digits = ""
            
            var firstPos = line.length
            var firstNumber = ""
            for (i in numbers.indices) {
                val nbPos = line.indexOf(numbers[i])
                if (nbPos >= 0 && nbPos < firstPos) {
                    firstPos = nbPos
                    firstNumber = if (i % 2 == 0) numbers[i] else numbers[i-1]
                }
            }
            digits += firstNumber
            
            var lastPos = -1
            var lastNumber = ""
            for (i in numbers.indices) {
                val nbPos = line.lastIndexOf(numbers[i])
                if (nbPos >= 0 && nbPos > lastPos) {
                    lastPos = nbPos
                    lastNumber = if (i % 2 == 0) numbers[i] else numbers[i-1]
                }
            }
            digits += lastNumber
            
            sum += digits.toInt()
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    val testInput2 = readInput("Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

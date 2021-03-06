package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
                "Хлеб" to 50.0,
                "Молоко" to 100.0
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко"),
                        itemCosts
                )
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        itemCosts
                )
        )
        assertEquals(
                0.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        mapOf()
                )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
                "Quagmire" to "+1-800-555-0143",
                "Adam's Ribs" to "+82-000-555-2960",
                "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю Котлин".split(" "),
                        "как-то"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю таки Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я люблю Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
                buildWordSet("Я люблю Котлин".split(" ")),
                mutableSetOf("Я", "люблю", "Котлин")
        )
        assertEquals(
                buildWordSet("Я люблю люблю Котлин".split(" ")),
                mutableSetOf("Котлин", "люблю", "Я")
        )
        assertEquals(
                buildWordSet(listOf()),
                mutableSetOf<String>()
        )
    }

    @Test
    @Tag("Normal")
    fun mergePhoneBooks() {
        assertEquals(
                mapOf("Emergency" to "112"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112", "Fire department" to "01"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
    }

    @Test
    @Tag("Easy")
    fun buildGrades() {
        assertEquals(
                mapOf<Int, List<String>>(),
                buildGrades(mapOf())
        )
        // TODO: Sort the values here or let the students do it?
        assertEquals(
                mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
        )
        assertEquals(
                mapOf(3 to listOf("Марат", "Семён", "Михаил")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
        )
    }

    @Test
    @Tag("Easy")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
    }

    @Test
    @Tag("Normal")
    fun averageStockPrice() {
        assertEquals(
                mapOf<String, Double>(),
                averageStockPrice(listOf())
        )
        assertEquals(
                mapOf("MSFT" to 100.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 45.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("Normal")
    fun findCheapestStuff() {
        assertNull(
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        ""
                )
        )
        assertNull(
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "торт"
                )
        )
        assertEquals(
                "Мария",
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "печенье"
                )
        )
    }

    @Test
    @Tag("Hard")
    fun propagateHandshakes() {
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Mikhail"),
                        "Mikhail" to setOf()
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Sveta"),
                                "Sveta" to setOf("Mikhail")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Marat", "Mikhail"),
                        "Mikhail" to setOf("Sveta", "Marat")
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Mikhail", "Sveta"),
                                "Sveta" to setOf("Marat"),
                                "Mikhail" to setOf("Sveta")
                        )
                )
        )
    }

    @Test
    @Tag("Easy")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(from, mapOf("b" to "c"))
    }

    @Test
    @Tag("Easy")
    fun whoAreInBoth() {
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
                listOf("Marat"),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
    }

    @Test
    @Tag("Normal")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
    }

    @Test
    @Tag("Normal")
    fun extractRepeats() {
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(emptyList())
        )
        assertEquals(
                mapOf("a" to 2),
                extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(listOf("a", "b", "c"))
        )
    }

    @Test
    @Tag("Normal")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
        assertFalse(hasAnagrams(listOf("израилем", "реализме")))
    }

    @Test
    @Tag("Hard")
    fun findSumOfTwo() {
        assertEquals(
                Pair(0, 2),
                findSumOfTwo(listOf(1, 2, 3), 4)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(emptyList(), 1)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(listOf(1, 2, 3), 6)
        )
        assertEquals(
                Pair(6, 8),
                findSumOfTwo(listOf(5543, 49288, 40699, 40700, 12086, 40700, 0, 1, 0, 0, 20610, 40699, 22317, 40700,
                        40700, 40700, 40699, 37100, 40699, 40699, 1, 44280, 0, 1, 1309, 36255, 1, 40699, 3098, 0,
                        40700, 13288, 0, 24254, 40699, 40700, 25515, 1, 1, 0, 40699, 21050, 40699, 0, 42331, 1,
                        40700, 49671, 1, 0, 40699, 12281, 1, 40700, 40700, 27277, 1, 46430, 0, 40700, 21851, 40700,
                        7291, 40700, 0, 27958, 1, 0, 0, 22999, 0, 40699, 24799, 1, 18337, 9481, 0, 37248, 40700, 40700,
                        10035, 40699, 1, 1973, 40699, 1, 0, 1, 1, 40699, 0, 40700, 47732, 33445, 1, 0, 20751, 40700,
                        40699, 20303, 0, 40700, 38931, 25669, 30219, 0, 26393, 40699, 40699, 22792, 0, 40700, 40700,
                        29979, 40699, 40699, 40700, 39002, 40700, 40699, 0, 24287, 0, 1, 40699, 43866, 1, 23440, 40699,
                        40699, 0, 40099, 1, 3356, 1, 0, 40700, 0, 0, 0, 1, 0, 0, 40699, 0, 43973, 13206, 25969, 40700,
                        40699, 1, 0, 37036, 40699, 9804, 40524, 40700, 40700, 6863, 0, 40700, 7899, 0, 0, 21796, 40699,
                        0, 0, 0, 1, 1, 19759, 39921, 1887, 22569, 1, 0, 1), 0)
        )
    }

    @Test
    @Tag("Impossible")
    fun bagPacking() {
        assertEquals(
                setOf("47", "45", "44", "43", "42", "41", "40", "38", "37", "35", "34", "33", "31", "30", "28", "26",
                        "25", "24", "22", "20", "19", "18", "17", "16", "15", "13", "11", "10", "8", "7", "6", "5",
                        "4", "3", "0"),
                bagPacking(
                        mapOf("0" to (149 to 148), "1" to (252 to 111), "2" to (419 to 2), "3" to (1 to 488),
                                "4" to (148 to 377), "5" to (2 to 419), "6" to (1 to 148), "7" to (2 to 1),
                                "8" to (459 to 255), "9" to (149 to 2), "10" to (60 to 149), "11" to (1 to 149),
                                "12" to (149 to 1), "13" to (148 to 270), "14" to (254 to 2), "15" to (296 to 385),
                                "16" to (91 to 84), "17" to (149 to 149), "18" to (431 to 294), "19" to (2 to 227),
                                "20" to (247 to 148), "21" to (217 to 1), "22" to (1 to 148), "23" to (495 to 1),
                                "24" to (1 to 30), "25" to (148 to 148), "26" to (149 to 279), "27" to (210 to 2),
                                "28" to (1 to 148), "29" to (138 to 2), "30" to (149 to 148), "31" to (1 to 344),
                                "32" to (449 to 12), "33" to (1 to 1), "34" to (1 to 1), "35" to (260 to 149),
                                "36" to (352 to 148), "37" to (149 to 300), "38" to (149 to 149), "39" to (149 to 1),
                                "40" to (46 to 148), "41" to (149 to 246), "42" to (148 to 299), "43" to (2 to 148),
                                "44" to (2 to 149), "45" to (2 to 149), "46" to (149 to 2), "47" to (36 to 293),
                                "48" to (148 to 2)),
                        3649
                )
        )
        assertEquals(
                setOf("17", "16", "15", "14", "12", "11", "10", "9", "6", "5", "4", "2", "1", "0"),
                bagPacking(
                        mapOf("0" to (148 to 149), "1" to (1 to 2), "2" to (2 to 1), "3" to (149 to 1),
                                "4" to (38 to 148), "5" to (352 to 148), "6" to (2 to 1), "7" to (492 to 149),
                                "8" to (132 to 65), "9" to (2 to 2), "10" to (83 to 148), "11" to (149 to 407),
                                "12" to (130 to 148), "13" to (353 to 148), "14" to (2 to 149), "15" to (2 to 149),
                                "16" to (148 to 148), "17" to (148 to 148), "18" to (149 to 1), "19" to (379 to 149)),
                        1230
                )
        )
        assertEquals(
                setOf("Кубок"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        850
                )
        )
        assertEquals(
                emptySet<String>(),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        450
                )
        )
    }

    // TODO: map task tests
}

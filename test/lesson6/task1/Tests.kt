package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("29 февраля 1993"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateStrToDigit("32.09.2011"))
        assertEquals("", dateStrToDigit("29.02.1993"))
        assertEquals("", dateStrToDigit("02.63.2833934"))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("134_+874"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(700, bestLongJump("% - - % - 700"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))
        assertEquals(2147483647, bestLongJump("% 2147483647 -   - 2147483647 832949539   - 55920285 47345780"))
        assertEquals(2147483647, bestLongJump("% - -   - - -  -  - 1   -  1 % 0  -  - 1633388235 " +
                "2147483647  1   %  - -  -  - -   -  %  - -  -    0 - 2147483647 - 1505332896 0 1 %  - 816500264 % 1" +
                "  1 % 0  - - 2082918603 1 1656405487   2147483647 -  -  - 2147483647 712050822 %  -  % 1 -  % %" +
                "  2147483647 552114708 -   1 %  -  2147483647 2147483647 % - 0 583787236  2147483647  1 -" +
                " 0 1819284618 % 1819860674 0 % 2147483647 2147483647 - 883354896 1842390340 1384740591 1818889019" +
                " % 2147483647  % - 2147483647  -"))

    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(226, bestHighJump("226 +"))
        assertEquals(-1, bestHighJump("???"))
        assertEquals(230, bestHighJump("220 + 224 %+ 228 %- 230 %+ 232 %%- 234 %"))
        assertEquals(980484880, bestHighJump("0 %- 1 %- 878992321 %-" +
                " 739943926 %%- 139849251 %+ 22360429 %+ 147483647 %+ 980344828 %- 980484880 %+ 1 %-" +
                " 147483647 %- 147483647 %+ 640631255 %+"))
        assertEquals(969545233, bestHighJump("721143130 %+ 884381137 %%- 147483648 + 156960534 %- " +
                "370252384 %%- 0 %%- 147483647 %- 98931265 %%- 1 %+ 147483648 + 147483648 %+ 355583316 %+ 0 %%+ " +
                "288036176 + 31481533 %%- 579722299 %%+ 1 %- 451597819 %%- 11694397 + 147483647 + 329611038 %- 0 %- " +
                "0 %%- 673614044 %+ 1 %- 147483648 %- 455845634 %%- 580436952 + 147483647 + 139998461 %%+ 416649148 " +
                "%%- 0 %+ 147483648 %%- 147483648 %%- 0 %+ 147483648 %%- 742486082 %+ 147483647 %- 147483647 %%- 1 %+ " +
                "147483648 %%- 147483648 %- 0 + 0 + 1 + 291343744 %%- 834955457 %- 226948873 %%- 25255662 %%- 366146138 " +
                "%%- 147483648 + 147483648 %+ 147483647 %- 147483648 + 634551512 %+ 1 %+ 1 %+ 1 + 777414210 %- 19033630 " +
                "+ 0 %+ 0 + 84371204 %+ 147483648 %%+ 147483647 %%- 147483647 + 147483648 %%- 88519911 + 451770070 %+ " +
                "541187495 %+ 33875164 %%- 385996178 %- 147483647 %- 0 + 0 %- 429103708 %%- 474328907 + 147483648 %%- " +
                "0 %%- 147483647 + 475458598 %+ 855248050 %+ 0 %%+ 210737191 %+ 57625925 %- 256923102 %- 1 %%- 0 %%- " +
                "147483648 %%- 765187873 %%- 147483648 %%- 667243130 + 739501048 %+ 0 %- 147483648 %%+ 246255331 + " +
                "147483647 + 147483647 + 308201019 + 147483647 %- 175327835 + 624144403 %- 139790174 + 969545233 + " +
                "936070284 + 147483648 %- 147483648 %- 147483648 %+ 175619076 %%+ 147483647 %+ 1 %- 15930150 %- " +
                "151047379 + 999795068 %%- 947149638 %%- 147483647 %- 147483648 %%- 51847960 %+ 115221731 + " +
                "147483648 %+ 147483647 %- 1 + 1 %%- 0 %%- 908672778 %- 0 + 1 + 1 %- 117014869 %- 0 %- 147483647 " +
                "%- 147483648 %+ 27785613 %+ 793343280 + 423129391 %- 646506749 + 1 %%- 147483648 %+ 0 %%- 0 %+" +
                " 201347459 %%- 300044389 %+ 197307277 %%- 0 %- 1 %+ 993811962 %%- 147483648 %%- 147483648 %%- " +
                "147483648 + 362321086 %- 538944564 %%+ 150083183 %+ 0 %%- 1 %+ 371448422 %%- 238933852 %- " +
                "666948896 %- 398726993 %%- 504752051 + 968681004 %+ 147483648 %- 147483648 + 0 + 1 %%- 0 " +
                "%%+ 648742023 %+ 147483648 %+ 0 %+"))
        assertEquals(147483648, bestHighJump("0 %%+ 147483647 %+ 147483648 %- 147483648 %%+ 147483647 " +
                "%+ 0 %+ 147483647 %+ 1 %- 147483647 %+ 932302374 %- 624931059 %- 0 %%-"))
        assertEquals(-1, bestHighJump("122821823 %-"))
    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - + 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("{]bS;l]Zi.d!X.x'U.g#") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("") }
    }

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("| w q z { - Y 4 > 5 _ e % 2 = G w ` ' 9 [ T Y X c % G f | F H | 8 i R J - E } d # . @ 0"))
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("", mostExpensive(""))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
        assertEquals("Вино", mostExpensive("Вино 0.0"))
        assertEquals("&#45@#^", mostExpensive("hp 110.0; Samsung 62.5; &#45@#^ 1000.0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
        assertEquals(-1, fromRoman(""))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), computeDeviceCells(449, "", 10000))
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000))

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256))
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
    }
}
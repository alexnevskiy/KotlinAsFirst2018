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
        assertEquals(996490538, bestHighJump("1 %+ 147483647 + 147483648 %%- 1 %%+ 0 %%- 0 + 978802645 %%- 147483647 %%+ 147483648 %%- 41798909 + 338696258 %- 471201123 + 0 + 147483648 %+ 147483647 %- 147483647 + 0 %+ 1 %%+ 651734141 %%- 147483647 %- 147483647 %%- 147483648 %- 0 + 148429205 + 893728729 %%+ 796351206 %%- 779923907 %%+ 840973426 %+ 147483647 %- 268755687 + 958219825 %- 147483647 + 525433212 %%+ 49905605 %%- 913129856 %%+ 848156866 + 147483648 %+ 0 %+ 1 %- 1 %- 584514476 + 914175385 + 295153687 %+ 147483647 %- 129033510 %%- 1 %+ 262728739 %+ 147483648 %+ 1 %+ 821229294 + 29675742 %%- 950812832 %%+ 267983257 %%+ 147483647 + 54777975 + 0 + 88053271 %%- 0 %%+ 147483647 %- 147483648 %- 277422688 + 119190772 %%- 147483648 %+ 26340718 + 696801389 + 147483647 + 898084712 %%- 161655040 + 976524849 %- 498896251 + 1 %+ 0 + 207907548 %- 688144097 %+ 547389071 %+ 147483647 %- 469410599 %%- 397083192 %%- 147483648 %%+ 799029251 + 874024724 + 0 %- 0 %+ 1 + 912171085 %%- 821138141 %%- 0 %- 1 %- 147483648 + 147483648 %%+ 0 + 323715624 %+ 547835134 %%- 1 %%+ 1 %- 482329932 %%- 692832663 %%- 147483648 %%- 147483648 %- 439996344 %- 147483647 %%- 0 %- 147483647 %%- 147483648 %%+ 147483648 %- 128501123 %- 147483647 %%- 141229021 %- 147483647 %%- 147483648 %- 63445556 + 148966517 %%- 0 %%- 147483647 + 324456632 + 316565651 %%- 147483647 %- 251144029 + 0 %- 0 %+ 0 %- 147483648 %%- 105032347 + 147483648 %+ 0 %- 312195358 %%- 147483647 %%+ 147483647 + 0 %%- 474709866 + 33153501 %+ 0 %- 324361746 %- 423539137 %%- 1 %%- 0 + 1 %%- 753393677 %+ 0 %%- 65121164 %- 1 %%- 278039094 + 1 %+ 147483647 %- 27367266 %- 688560848 %%- 1 %+ 147483648 %- 512292901 + 946031925 + 673661910 + 112656764 + 147483648 %+ 147483648 %%- 0 %%+ 147483648 %+ 147483648 %%+ 301168092 %+ 34729574 %- 1 %+ 29601943 %%- 83545661 %+ 147483648 %%- 1 %- 0 %%+ 147483648 %- 147483648 %%- 0 %- 898055227 %- 1 %- 147483648 %%- 0 %+ 147483648 %%- 111377396 %- 331179732 + 147483647 %%- 147483648 + 646584263 %- 1 %- 147483648 %- 764332469 %%- 147483647 %+ 753094467 %%+ 22485156 %+ 147483647 %+ 74119751 %%- 456992532 + 0 + 1 %+ 760886307 %- 0 %+ 1 %%- 246452853 %- 0 %+ 0 + 147483648 + 0 + 1 %%- 1 %- 938039 + 147483648 + 691800409 %+ 147483647 %%- 949958051 %+ 0 %- 147483647 %- 0 %%+ 798951160 + 147483648 %%- 604811800 %- 0 %+ 656762763 + 545346240 + 1 %%- 749070459 %- 147483647 %- 994724954 %%- 147483648 %%- 512631097 %+ 147483648 %+ 147483647 %- 0 + 147483647 %- 1 %- 0 %- 147483648 %- 670368542 %+ 0 %+ 532183062 + 607599128 %- 58489303 %- 0 + 147483648 + 734777171 %%- 147483648 %%- 147483647 + 147483648 + 147483648 %%+ 0 %- 126835106 %+ 1 %%- 82875134 %+ 147483647 %%- 179220349 %%- 147483647 + 1 %- 147483647 %+ 1 %%+ 131208031 %%- 1 %- 115123236 + 289676730 %+ 114136912 %+ 147483648 %%- 147483648 %- 97965564 %- 147483648 %- 147483648 %%- 1 %- 1 + 743253975 %%+ 147483647 %%- 147483648 %%- 989180876 %- 0 %+ 124802530 %+ 147483648 + 1 %+ 931391770 %+ 742082936 %+ 1 %%+ 837570448 %+ 324246643 %%+ 1 %%+ 0 + 0 %+ 1 %%+ 1774833 %%- 841886543 %- 1 + 781085891 %%- 0 %%- 1 + 0 %- 147483647 %- 342467075 %+ 942193020 %- 1 + 883810522 %+ 1 + 616426377 + 920807515 %%- 475132333 %%- 147483647 %+ 186895145 %- 147483648 %%+ 841741672 %- 163835797 + 520117558 + 147483648 %%+ 0 %- 183698096 + 694659878 + 147483648 %+ 147483648 %- 551272138 + 1 %%- 955484965 %+ 929712851 %- 0 + 147483648 %%- 996151636 %+ 614788458 %%- 531276849 + 0 %- 147483647 %- 147483648 %%+ 281802003 %- 821591160 %%- 147483647 %+ 690203770 + 147483648 %%+ 1 %%+ 147483647 %%- 517344663 %%+ 147483648 %- 147483648 %%+ 701488363 + 147483647 %+ 92024045 %%+ 284200865 %%- 271778826 + 1 %+ 1 + 145609934 %+ 0 + 193526319 + 25205809 %%+ 0 %%- 539534794 + 10122928 %%- 1 %%+ 0 %+ 710961771 %%+ 1 + 147483648 + 1 + 0 + 1 + 1 %+ 189037677 %%- 147483648 + 147483647 %%- 249388380 %- 29896710 + 13686714 + 830030438 %%- 1 %%- 147483648 + 378316204 %%- 0 %- 23539073 %%- 21899160 + 330064103 %- 147483648 %- 44324684 %%- 147483648 %%- 114835754 %- 147483647 + 710143908 %%- 0 + 0 %- 94663252 + 147483648 %- 773256545 + 147483647 %+ 706198734 + 488878867 + 741214823 + 1 %+ 147483647 + 371173709 %+ 0 + 834994332 %+ 928357352 + 147483647 %+ 1 %+ 1 %%+ 198935584 %- 665251835 + 1 + 384765797 %%- 203228837 %%- 702460137 %%- 0 %+ 0 %- 0 + 162583564 %+ 512805551 %+ 868395648 + 32912534 %- 75956145 %+ 738067027 %+ 298058445 %%- 799625961 + 56564002 %%- 645666615 %%+ 147483647 %%- 248009801 %%+ 538823340 %%+ 0 %- 147483647 + 444360396 %%+ 224983615 + 115785095 %+ 185145410 + 0 + 147483647 %+ 75885362 %%+ 147483647 + 0 + 0 %+ 147483647 + 1 %- 321394936 + 147483647 + 925946448 + 0 %%- 1 %%+ 583708024 %%- 147483647 %%- 255176634 %%+ 576764097 %+ 582056471 %+ 147483647 + 1 %+ 817327753 %%- 123915364 + 147483648 %%- 147483648 + 600332113 + 808045407 %+ 147483647 + 729962667 %%+ 0 %- 915159184 %%+ 639681039 %- 147483648 + 667277995 + 0 %%- 0 %+ 147483647 + 238215699 %+ 0 %+ 147483647 %%- 212034310 %- 478959270 %+ 131954747 + 1 + 0 + 147483648 %- 890033287 %%- 147483647 %%- 147483648 + 100271279 %- 147483648 %%- 769261747 %%- 147483648 %+ 147483647 + 734708809 %%- 147483648 %+ 147483647 %%- 716461145 %%- 907335356 %%- 677312084 %%+ 0 %+ 356497032 + 924879150 + 1 + 1 %%- 147483648 %%- 147483648 %%- 786261676 %%- 0 %- 799427213 + 713025735 + 27765311 %%+ 119307575 %%+ 65751893 %%- 1 %%- 257033119 + 281347794 + 1 + 147483647 %%+ 439275556 %- 608248101 %%- 147483648 %+ 0 %+ 1 %+ 147483647 %- 91327063 %%+ 510167865 %%+ 1 %+ 718267221 %%- 147483647 %- 754292676 + 13472449 + 147483647 %- 65349889 %%- 445193347 + 0 %%- 109378860 %%- 0 %%+ 147483647 %%+ 147483648 %%- 600681673 %%+ 147483648 %- 147483648 %- 375433928 %%- 0 %- 0 %- 0 %%+ 147483647 %%- 996148941 %+ 0 %+ 1 %- 147483648 %+ 147483647 %+ 1 + 599185885 %%- 588741743 %%- 1 + 0 %%+ 0 %%+ 354992221 %+ 147483647 + 250927691 + 147483647 %%+ 819301601 %- 147483648 + 1 %%+ 117640637 %+ 147483648 %- 1 %- 284546979 + 147483648 %%- 319332114 %- 0 %+ 715447840 %%+ 968182885 %+ 857465599 %+ 0 %- 919641222 %%+ 147483647 + 1 %- 816792940 %- 742091558 %%+ 147483647 %+ 1 %- 0 %- 147483648 %%- 1 %%- 141913354 + 147483648 %- 1 %- 147483647 + 448163348 %%- 147483648 %%+ 749972058 %%+ 147483647 %%- 727982613 %%- 147483648 %%- 147483647 %%- 350013742 %- 703130804 %+ 610784059 %%- 1 %%- 0 %+ 0 %- 1 %%- 0 %+ 147483647 %- 0 %- 1 %%- 725900077 %+ 147483647 + 49201333 %+ 58429993 + 0 %+ 190153262 + 613150441 + 0 + 1 %- 906532359 %- 0 + 147483647 %+ 948849801 %+ 147483648 %- 196500526 + 147483647 + 176296135 + 0 %- 388929313 %%+ 147483648 %+ 147483647 %- 147483648 %+ 147483648 %%- 147483648 %%- 147483647 %%- 813898244 %%+ 1 %- 147483647 %+ 1 %+ 233593619 + 0 %- 621463906 + 147483648 + 147483648 %+ 294425330 %+ 642966371 %%+ 426188483 + 960941624 %+ 468068879 %%- 147483647 %+ 1 %%- 753341562 + 0 %+ 147483647 %+ 927640143 + 1 %- 526653905 + 367693640 %+ 229697760 + 147483648 %- 41338838 %%+ 147483647 %%- 147483647 %+ 366355038 %%- 147483647 %%+ 1 %+ 1 %%+ 147483647 %%- 64575015 %- 147483647 %+ 147483647 + 446539530 %%+ 103051370 %+ 634843133 + 103421805 %- 72433060 + 173728148 %+ 0 + 147483647 + 1 %- 729478087 %- 920120711 %- 815358201 %- 1 %- 745193147 + 147483647 %- 895445640 %- 875308775 %%- 1 %%- 1 %%- 0 %%+ 86203962 + 147483647 + 832207946 + 147483648 %- 1 %- 858128853 %+ 0 %- 407912045 + 0 %%- 147483647 %%+ 147483647 %- 0 %%- 147483647 %%+ 147483648 + 849206649 %%- 714654194 %%- 147483648 %+ 874936503 %+ 147483648 %+ 656443144 %+ 587395089 %- 908342236 %+ 1 %%+ 1 %+ 147483648 %+ 577594375 %%- 147483648 %- 0 %%- 147483648 %%- 485428653 + 147483648 + 147483647 %- 0 %+ 147483648 + 200140889 %+ 228446224 %%- 147483647 %- 147483647 + 37693135 %- 1 %- 505502773 + 185025361 %%+ 584237478 %%- 951237679 %+ 147483648 + 147483647 + 147483647 %%- 147483647 + 1 %+ 14839820 %%+ 308271793 %+ 1085023 %+ 604504098 %%- 0 %+ 147483648 %+ 147483648 %%- 977360821 %%+ 923987484 + 1 + 112477877 %+ 1 %%- 114399114 %- 147483648 + 0 %+ 58681267 %%- 147483648 + 913811677 + 73464078 + 38599353 %%- 147483648 %+ 0 %%- 147483648 + 1 + 550384531 + 398652422 %%- 147483647 + 63480773 %+ 229289453 %+ 1 + 147483648 %+ 631995701 + 1 %%- 147483648 %+ 756309647 %+ 1 %%- 0 %+ 631401878 %%+ 147483647 %%+ 365363262 %%- 147483647 %%- 159495094 %%- 1 %%- 986467726 %+ 131496983 %%- 147483648 + 147483648 %+ 953702726 %+ 747086803 %%- 24745961 %+ 628779413 %+ 147483648 + 1 %%+ 323446658 %- 1 %+ 807227532 + 856063903 %%- 36656456 %- 967690627 + 317575407 + 147483647 %- 428155819 %+ 147483647 + 104006019 %%- 147483648 %- 658210611 %+ 147483647 %%- 84876817 %+ 1 %- 0 %- 924123723 %%- 1 %%- 688119010 + 0 %- 0 + 0 %- 822521544 %- 147483648 %%- 918300692 + 147483648 %- 967007872 %- 147483648 %+ 0 %%- 81515597 + 0 + 1 %- 0 + 147483648 %%+ 356161155 %+ 0 %%- 147483648 %- 147483648 %%- 0 %%- 1 %%- 129329182 %%- 147483648 + 147483647 %%- 178900229 %- 822384567 %+ 538067989 %%- 176237208 %- 147483648 %%- 147483647 %- 147483647 + 147483647 %%- 0 %- 147483648 + 703212257 + 147483648 %+ 147483648 + 922537658 %%- 0 %%- 488357695 %%+ 0 %+ 952335019 + 624941899 + 1 + 142586879 %- 0 %- 1 + 1 + 147483648 %- 790919399 %- 1 + 135511027 %%+ 340118494 %+ 147483648 %%- 319221222 + 969196912 + 325804510 %%- 1 %%- 947775036 %%- 1 %%- 332212985 %%- 472815309 + 117866111 + 147483647 %%+ 147483648 + 0 + 664262335 %%+ 290795326 + 147483647 %- 1 %%- 927396062 %+ 495384556 %+ 147483647 %+ 147483647 %%+ 147483647 %+ 147483648 %+ 147483648 + 81816210 %- 919333423 %- 0 %%- 0 %+ 534284078 + 147483648 %%- 328521280 %%- 76066241 %%+ 147483648 %- 559507724 %- 0 + 231169507 %- 1 + 0 %+ 145409829 %+ 147483647 %%- 147483648 + 147483648 %+ 817012934 %%+ 1 + 1 + 1 %- 88210664 %- 362785304 %%- 121334096 + 900998447 + 709315711 %%- 1 %%- 633041651 %+ 147483648 %+ 147483647 %%+ 736852784 + 147483648 + 124377504 + 1 %%- 32151445 %+ 551867463 + 0 %%+ 421061210 %+ 186464115 + 0 %+ 147483648 %+ 147483648 + 893212823 %%- 805317399 %- 470109504 %%- 731244141 %%- 147483648 %+ 147483648 %%- 147483647 %- 20470363 + 443395333 %+ 147483647 %%+ 1 %+ 0 + 131743838 %%+ 500138494 %%+ 0 %- 592454943 + 1 %+ 147483647 %%- 443379876 %+ 268055839 %- 0 %%+ 0 + 417343026 %%+ 793211493 + 548167026 %%+ 101828748 %+ 0 + 0 %+ 147483647 %%+ 0 + 753018115 + 194164374 %- 853262411 + 912399169 %+ 606642498 %- 1 %+ 173445356 %%- 1 %%+ 1 + 1 + 0 %- 147483648 %+ 1 %%- 18860820 + 757715392 %- 34935731 + 586496782 %- 147483647 %%- 301719558 %- 704880951 %+ 160395761 %%- 266477056 %+ 0 %%- 926078409 + 0 %%- 147483648 %- 1 %- 628756507 + 127943951 %- 188830617 %+ 147483647 %+ 360329141 + 0 %%+ 0 + 38036845 %%+ 147483648 + 1 %+ 147483648 %+ 675101088 + 147483648 %- 99896032 %+ 465920833 %%- 1 %%- 147483647 %+ 810386990 %%- 147483648 %- 147483648 + 411274479 %+ 147483648 %%+ 438007648 %- 596521591 %%- 0 %+ 885137069 %+ 147483647 %%+ 1 %- 245218761 %%- 1 %%- 0 %%- 140537190 %%- 728972541 %- 1 %+ 484398376 %+ 89838315 %+ 147483648 %+ 215297965 %- 460979533 %%+ 931367449 %%- 0 + 1 %%- 0 %%- 248673122 %+ 147483647 + 147483648 + 6340444 %- 68195493 + 147483648 %+ 988739524 %%- 468763937 %+ 1 %+ 790190974 %%- 232131586 %- 0 %- 405285031 + 918330812 %%- 134443148 %+ 33109102 + 145148876 + 147483648 + 1 %- 147483647 %%- 33190574 + 147483647 %- 1 + 0 %+ 111546367 %+ 147483647 %- 147483648 %%+ 495964789 %- 0 + 147483648 %+ 121119541 + 77941455 %%+ 431084864 %- 1 %- 1 %%- 147483647 + 0 + 378742862 %%- 772441468 %+ 0 + 147483648 %- 147483648 %+ 147483648 %- 0 %+ 147483648 %%- 147483648 %%+ 367510240 + 461858516 %%- 473074976 %+ 573361473 %- 160664860 %+ 350499393 %+ 147483648 %- 719374838 %%- 232219783 + 1 + 1 %+ 211051667 %+ 147483647 + 718088302 + 664519768 %- 0 + 290138211 %%+ 803599925 + 0 %%- 0 %- 0 %- 338935453 + 0 + 842550267 %%+ 768495322 %%- 827803000 %%- 0 %- 905427400 %- 1 %+ 257388355 %%- 401633866 %- 708160509 %- 147483647 %- 147483647 %- 127818884 %+ 147483648 %- 147483648 %- 1 %- 1 %- 901782291 %+ 446654947 + 147483648 %+ 147483648 %- 147483647 + 1 %+ 147483648 %+ 841972117 %%- 147483648 %+ 127909168 + 207173987 %%- 147483648 + 450814571 %- 0 %- 147483648 + 0 %- 147483647 %%- 147483648 + 130576223 %- 0 %%- 141295862 %- 835754242 %%- 754690934 %%+ 273912450 %- 51054300 %%- 616635880 %- 0 %%- 0 + 0 %- 233514314 %- 147483648 %+ 147483648 %%- 1 %+ 0 %%- 147483648 %+ 147483647 %+ 0 %- 1 %%+ 0 %- 98935742 %%- 914619865 %%- 147483648 %%- 147483647 %%- 1 %- 51480301 %%+ 554631939 %- 0 %- 701167311 %- 147483648 %+ 645371883 %- 699321622 %- 236666631 %+ 0 %+ 500326475 %+ 140376392 %%- 147483647 %+ 752506302 %- 147483648 %+ 300205161 %+ 0 %- 0 %%- 147483648 + 1 %- 358948391 %%+ 535814623 %- 1 %+ 872247608 %%- 147483648 %- 616257087 %- 281815598 + 147483647 + 117505898 %- 0 + 475727851 %+ 60490212 + 1 + 1 %+ 0 %+ 147483648 %+ 449252782 %%- 508969344 %+ 147483647 %- 147483648 %- 224900386 + 332515312 %%+ 147483648 %%- 147483647 %%- 213025764 %- 147483647 + 0 %- 147483648 + 860414586 %%- 147483648 %%- 147483648 %%+ 53096069 %+ 1 %- 147483648 %- 147483647 %%+ 380254099 %- 147483648 %+ 1 %+ 248229716 %+ 147483648 + 720292769 %- 147483647 %- 0 %- 851994310 %- 103941886 + 30845810 %%- 0 %%- 147483647 %+ 1 %%- 1102587 %+ 975096554 %- 1 %- 881610957 %+ 412988540 %+ 147483647 %+ 147483648 %- 90592811 %%- 147483648 %+ 258248045 %- 410817720 %%+ 147483647 %%- 147483648 %- 147483647 %%- 147483647 %- 600611801 %- 147483647 + 316127941 %%- 0 %%- 147483648 %- 549407316 %%- 147483648 %- 147483648 + 540358941 %%- 1 + 1 %- 1 %- 18784273 %%- 394537143 %- 0 + 0 + 815417876 %%- 147483648 %+ 147483648 + 1 + 1 %%+ 984054563 %%+ 920114214 + 1 + 1 %- 717235293 %+ 358974117 %%- 1 %%+ 147483647 %- 147483648 + 147483648 %+ 147483647 + 175555604 %%- 415439700 %- 147483647 %- 1 %- 147483647 + 147483647 %%- 147483647 %- 970724010 %%- 676400693 %+ 925919113 + 405594335 %+ 1 %%- 147483648 + 993392984 %%+ 617973368 %- 177097520 %+ 1 %- 1 + 43886272 %- 596771645 %+ 147483648 %%- 320675929 %%+ 147483647 %%- 147483648 %- 542884918 %- 0 %%+ 0 %%- 406530137 %+ 1 %%- 0 %+ 589929910 %+ 147483648 %- 147483648 + 147483647 %%+ 147483648 + 1 %+ 52327947 %+ 147483648 %- 147483647 %- 704941707 + 94423731 %+ 1 + 0 %+ 0 %%- 147483648 %+ 1 %%- 147483648 %%+ 1 %- 147483647 %+ 147483648 %%- 1 + 147483647 %%- 681667501 %%+ 431022286 %+ 588994003 %%- 1 %- 0 %%- 499027605 + 946821883 + 255126243 + 1 %- 147483648 %%- 0 %- 899473334 %%- 147483647 %+ 147483647 + 147483648 %- 1 %+ 644008347 + 147483647 %%- 1 %+ 831645202 %%- 0 + 692630802 + 125956817 %%+ 78690699 %- 147483647 %+ 147483648 %%- 576240461 %+ 147483647 + 0 %%- 0 + 1 %%- 1 %%- 147483647 %%+ 147483647 %- 1 %- 537301598 %- 147483648 %- 147483647 + 96733909 + 0 %%- 0 + 136648806 %+ 640402615 %%- 0 + 39396487 %%- 140144425 %- 68505079 %+ 639573819 %%- 0 %- 1 %- 496551424 %+ 1 %%- 147483647 %%- 147483648 + 184967166 %- 147483647 %%- 147483648 %%- 1 %%+ 1 %- 147483648 %- 1 + 900174960 %%- 147483647 %+ 1 + 147483648 %%- 147483648 %%- 87271700 %%+ 147483647 + 4530149 + 0 %+ 147483647 %%+ 147483647 %%- 0 %+ 746040286 %%- 0 + 0 + 147483647 + 532445468 %%- 147483648 %%- 1 %%- 0 + 491847755 %+ 780276729 %+ 0 %%- 891015539 + 237008434 + 147483648 + 0 %%- 261870460 %+ 841561003 + 147483648 %+ 147483648 %- 147483647 %%- 147483648 %+ 843044155 %%- 232971806 %%+ 147483648 + 1 %%+ 147483648 %%- 1 %%- 0 %- 147483648 %%- 386484932 %- 147483647 %+ 623969856 %%+ 1 %- 147483648 %%- 147483648 %%+ 0 %- 379971407 + 826444155 %- 108486693 %%+ 147483647 + 72594668 + 147483647 %%- 1 + 4314829 %%- 95659947 %- 772736887 %%+ 1 %- 147483648 + 0 %- 147483648 %- 147483647 %+ 107502767 + 425752216 %%- 147483648 %- 0 %+ 618779673 %- 147483648 %+ 147483648 %%- 776204783 %%- 147483647 %%+ 147483647 %+ 25479872 + 1 %+ 147483647 %%- 129162364 + 147483647 + 445326027 %%- 127583733 + 462238680 + 246585901 + 1 + 436839988 %+ 147483647 %%+ 1 %+ 888385800 %%+ 715945202 %- 701286497 %%+ 178670173 %- 1 + 147483648 %%- 147483647 + 0 %%+ 1 %- 147483647 %%- 1 %+ 325773015 + 962470726 + 0 %+ 0 %%- 338451424 + 1 %+ 147483647 %+ 1 + 514090473 %%+ 745537296 %%+ 147483648 %- 147483647 %+ 1 %- 147483647 %- 0 %%- 694285702 %- 1 %%+ 927663421 %+ 1 %%- 0 %%- 397827406 %- 0 %%- 1 %+ 147483647 %%- 147483647 %- 147483647 %%- 147483648 %%+ 45920408 %+ 0 + 398094029 %%- 830069387 %%- 203281517 %- 828749159 + 0 %- 1 %%- 147483648 %- 628618737 + 1 %- 21781638 + 147483648 %%- 863397766 %- 147483647 %+ 147483647 %- 545736509 %%- 147483648 %- 359731531 + 521151596 + 147483648 + 1 + 922779755 + 971227576 %%- 1 %+ 0 %%- 987891987 %+ 736271500 + 262142672 + 1 %+ 1 %%+ 798443994 + 773334480 %+ 990056940 %%- 768275182 %- 147483648 %+ 147483647 %- 0 %- 147483647 %- 1 + 0 %- 147483648 %%- 147483648 %+ 647495989 %- 147483648 %%- 147483648 %%- 185076426 %%- 384576451 %%- 147483647 %+ 147483648 %- 0 %- 147483648 %- 1 %+ 856151006 %%- 28334641 %- 0 + 147483648 %+ 69974690 %- 147483647 %%- 147483647 %%- 147483648 %+ 972093880 %%- 0 %+ 147483648 %%- 1 + 964861343 + 308674355 %+ 643352248 %+ 0 %%- 275925131 + 995606090 %+ 615581608 %%- 1 %+ 376815466 %%- 147483648 %+ 1 %+ 1 %%- 28146086 %%- 0 %- 0 %%- 147483648 %%- 779043311 %- 0 %- 714031782 %%- 147483648 %- 0 %%- 147483647 %+ 147483647 %- 0 + 147483647 %- 1 %%- 582060645 %- 147483648 %+ 147483647 %%+ 308752279 %%- 147483647 %%- 0 %- 652893210 %+ 147483647 %%+ 884623420 %- 617791497 %+ 0 %+ 147483648 %- 1 %- 71172448 %- 3837098 %- 147483648 %%+ 1 + 432327768 %+ 741638755 %+ 147483647 %+ 129116562 %%- 147483647 %%- 147483648 + 0 + 446923762 %%- 147483647 + 312571407 %+ 55836138 %%- 118744300 + 245098576 + 1 %%+ 460013944 %+ 0 + 147483647 + 294417863 + 636034885 %%+ 147483647 %%- 532002769 %%- 391290120 %%- 306042082 %+ 1 %- 43468203 %%- 0 %+ 0 + 802957038 %+ 836442476 %- 970017487 %+ 433801726 %%- 924002 %%- 136773681 %+ 834562485 %+ 46561416 %%- 623580518 %%- 1 %- 374679277 %%+ 147483647 %- 1 %+ 147483647 %%- 147483648 %+ 702587685 %- 0 %%- 728926729 + 1 %+ 147483647 + 169017298 %+ 147483648 + 19827511 %- 0 %+ 0 %+ 518951000 %+ 819236563 + 23365363 %%+ 0 %+ 790310398 %+ 1 + 147483647 %- 147483648 + 147483648 %+ 1 + 147483648 %%- 580281918 %%+ 557226047 %%- 0 %+ 147483647 %+ 0 %- 0 + 927061564 %%- 624580307 %- 720554382 %%+ 874365038 %- 0 %+ 302483330 %%- 0 %%- 297927372 %%+ 539448954 %+ 164726753 %%+ 1 %+ 1 + 804054347 %%- 147483647 %%+ 147483648 %+ 0 %- 285861169 %- 461096728 + 1 %- 147483647 %- 0 %+ 147483648 %- 0 %+ 394800119 %- 2456259 %%- 1 + 1 %- 0 %%- 268482494 %- 21893858 %- 481133928 %%+ 534733189 + 147483648 %+ 778113031 %- 670777141 + 1 %%- 1 %+ 147483647 + 147483648 + 427420195 %%- 147483647 %+ 685080216 %- 147483648 %%- 147483647 %- 1 %- 1 + 147483647 %%+ 1 %%+ 147483648 %%- 827936949 %%+ 159482223 %%- 235727149 %%- 147483648 + 564809476 %+ 1 %+ 0 %+ 1 %%+ 147483648 %%- 147483648 + 0 %%- 677989138 %+ 1 %+ 704537640 + 40445338 + 147483647 %+ 799078268 + 147483648 %- 147483647 %%- 147483648 %+ 417685874 + 350629830 + 96383214 %%- 982318388 + 1 %+ 0 %%- 147483647 %+ 147483648 %%- 0 %+ 989602244 + 326737498 %+ 0 %- 147483647 %+ 147483648 %+ 147483648 %%- 981391866 %+ 519191658 + 147483647 %%+ 784806916 %%+ 287922725 + 147483647 %- 21550431 %%+ 147483647 %- 147483648 %+ 147483647 %- 184958936 %- 147483647 %%- 1 %%- 147483647 %- 0 %- 0 + 147483648 %- 147483647 %- 0 %%- 997568146 %%- 147483648 %- 386377649 %%- 147483648 %%- 40490597 %+ 773561751 %+ 147483648 + 147483647 %+ 0 + 147483647 %- 690672747 %%+ 537649849 + 466638543 + 899413055 %+ 147483648 %+ 172184263 %+ 0 + 974115273 %%- 1 %+ 104302317 %%- 0 %- 147483648 %%- 1 %+ 760585682 %- 0 %+ 565220484 %- 147483647 %+ 1 + 0 %+ 197545063 %%+ 592559792 %%- 0 %%- 888555534 %+ 542185228 %+ 534659743 %%+ 147483647 + 71626691 + 857685711 %- 1 %+ 448037292 %%+ 0 + 0 %%+ 0 %+ 953789078 %%- 147483648 %+ 68925174 + 0 %%- 790920146 %%- 1 %%- 147483648 %%- 147483648 + 853344133 %%- 1 %%+ 0 %- 926588602 %%+ 1 + 495205154 %+ 1 %- 147483648 %- 147483648 %%- 862772509 %%- 34467443 %%- 113310953 %%- 108616298 %+ 1 %%+ 0 %+ 147483648 %%+ 730354860 %+ 210241149 %%+ 0 %+ 101668434 %- 106405446 %%- 936182051 %- 448562187 + 336131578 %%- 0 + 147483648 %+ 1 + 0 %%- 281363733 %%- 509281772 %%+ 0 %%- 147483647 %- 147483647 %- 1 + 147483648 %%- 147483648 + 1 %%- 675481494 %%- 66085930 %+ 147483648 %%- 236275295 %%- 524617607 %- 147483647 %+ 1 + 735136938 %+ 711018734 %%+ 147483648 %+ 0 %- 147483648 %%+ 1 %- 190021527 %%+ 1 + 147483648 %%- 147483648 %- 64464363 %- 0 + 86408535 + 611354663 %%- 414642144 + 0 %%+ 147483647 %%- 836077899 %- 0 %- 147483647 + 431023178 %+ 0 %%- 0 %%- 1 + 669563823 + 905004668 + 147483647 %- 18150421 %- 1 %%- 0 %%- 76778097 %%- 147483648 + 1 + 653153792 %+ 269074844 %%- 0 %%+ 1 %- 464663961 + 154263348 + 769490238 %%+ 93695409 + 1 %%+ 0 %- 593360529 %- 117720437 %%+ 147483648 + 0 %%+ 1 %%+ 147483648 %+ 1 %- 957960724 %%- 147483648 + 147483648 %%- 1 %%+ 147483648 %- 13358119 %- 147483647 %- 147483648 + 1 %%- 147483648 %+ 147483647 %- 177296674 %+ 0 %+ 0 %+ 345411549 + 696555489 + 94120905 %%- 964553109 %%- 979051081 %%- 147483648 %%- 147483647 %- 0 %+ 123721557 %%- 0 %- 947172111 %+ 147483647 %- 147483647 %- 0 %%- 147483648 %+ 147483647 + 147483648 %+ 147483647 + 868749619 %+ 147483648 %%- 809131929 + 147483648 %%+ 147483647 %%- 390842266 %- 147483648 + 685117601 %%- 147483647 %- 1 %- 1 %- 0 %%+ 0 + 117258576 %- 1 %%- 147483648 %%- 0 %- 147483648 %%+ 704935047 %+ 429375891 %+ 147483648 %+ 147483647 %- 147483648 %%- 642455037 %%- 179424391 %+ 203511164 %+ 147483648 %+ 3644293 + 241151453 + 247278630 %%- 795642735 %%- 0 %%- 9718856 %- 0 %- 1 %+ 1 %- 809008914 %%- 0 + 22425894 %%+ 147483648 %- 0 %%- 147483647 %%- 2032534 %+ 88849879 %%- 1 %- 130086161 %+ 0 %%+ 358045403 + 1 %- 147483647 %%+ 1 %+ 147483648 %- 36097493 %+ 1 + 1 %- 0 + 0 %- 209638879 %- 147483647 %- 1 %%- 1 %%- 1 %%- 50339590 + 222986721 %%+ 1 %+ 749103470 %+ 1 %+ 147483647 %- 416639919 %- 275532808 + 912505491 %%- 147483648 %%+ 992329887 %- 1 %%- 389940469 %- 139016701 + 901985861 %%- 101452089 %%- 147483647 + 387415875 %%+ 0 %+ 238043393 %- 147483647 %- 793036434 + 519424528 %+ 823665441 %- 67379530 %+ 0 + 147483647 %%- 147483648 %%- 0 + 1 %+ 147483648 %%- 1 + 0 %%+ 21747605 %+ 147483648 + 895419992 %%+ 297935044 %+ 0 %+ 0 %+ 95029277 %%- 866131805 %+ 0 + 0 %- 947729890 %%- 147483648 %- 614596421 + 65650358 %%- 427135298 %- 0 %%+ 147483648 %- 147483647 + 147483648 %%- 147483647 + 0 %- 1 %- 0 %+ 1 + 0 %%+ 147483647 + 0 %+ 122673929 %+ 147483648 %+ 147483648 %%- 147483648 %+ 734136252 %%- 602053703 %+ 0 + 280813038 %+ 0 %%+ 1 %%+ 147483647 %- 147483648 + 609133040 %%- 1 %+ 405701546 %+ 1 %- 1 + 147483647 %%- 147483648 %%+ 0 %%+ 1 %- 0 %%- 1 %%+ 1 + 381844332 %- 103186713 %+ 487932304 %- 147483648 %%- 1 %%+ 147483648 %+ 0 %+ 147483648 %+ 822333354 %+ 1 %- 1 %%- 57656500 %+ 147483648 %%- 526265576 %%- 999163304 %- 147483647 + 147483648 %%- 1 %- 0 %+ 147483647 %%- 440555513 %%- 147483648 + 19718064 %%+ 729061920 %%- 147483648 + 147483648 %%- 147483648 %- 1 + 35830375 %- 841893863 + 1 + 147483647 %- 1 %+ 935073584 %+ 838195419 %+ 358838494 %%- 897409625 %- 216816167 %- 536695924 %- 1 %+ 0 %- 0 + 147483648 %%+ 1 + 1 %+ 147483647 %%+ 987275704 %+ 615950429 %%- 954556330 %%- 1 %%- 702773887 %+ 127272244 %- 1 %%+ 786117495 + 0 + 147483648 %+ 576159359 + 147483648 %%+ 147483648 %%- 147483648 %%- 93516165 %- 0 %%- 834025209 %%+ 1 %- 854900436 + 0 %- 773245113 %- 649096724 %- 814806907 %+ 147483648 + 487534429 %%+ 1 %%+ 0 %%- 147483648 %- 646332363 %- 826993987 %%- 494551516 + 522822590 %- 0 %%+ 147483647 + 0 %+ 147483647 + 373629512 %%+ 38428619 %+ 612957063 + 147483647 %%- 1 %%- 147483648 %+ 147483648 %- 1 %%- 535724552 + 289047445 %%- 147483647 + 190423288 %+ 147483648 + 147483647 + 147483647 %+ 1 + 1 %%+ 415630969 + 1 %%- 0 %- 374780860 %%- 941292469 %+ 740560524 %- 147483647 %- 0 %+ 0 %%+ 1 %- 982661028 %+ 147483647 %%+ 147483648 %+ 393084531 %%- 967809763 %%- 1 %%- 141875345 %%- 147483648 %+ 147483647 + 126338326 %- 797130946 %%- 379399485 + 374749345 %- 761218778 + 0 + 0 %- 387397383 %+ 881509220 %+ 41755671 + 613718822 %%+ 147483648 %%- 147483647 + 1 %+ 147483648 %- 141980573 + 67755537 + 0 %%- 147483647 + 244906264 %- 1 %- 577678369 %+ 1 %- 0 %%- 505432721 %- 1 + 147483648 %%- 147483647 + 147483648 + 720068221 %%- 147483648 %- 712081550 %- 147483648 %%- 1 %+ 42481782 %%+ 147483647 %+ 336327697 %- 0 %%- 1 %- 0 %%- 147483648 %%- 1 %%- 147483648 + 817559631 %+ 160256332 %+ 147483648 %- 147483648 %%+ 119561679 %+ 0 %+ 801032614 %- 147483647 %- 315508274 + 957320467 %%+ 866370022 %- 231323337 %%- 147483648 %%- 786240066 %- 293121004 %+ 0 + 0 + 1 %%- 147483648 + 147483647 %%+ 186667989 %- 0 %%- 385958971 %+ 147483648 %%+ 166698593 + 147483648 %%+ 84748519 + 0 %%- 902317720 + 21163127 + 147483648 %- 147483647 %+ 147483647 %+ 1 %- 1 %%- 0 %+ 147483647 %%- 388002810 %- 147483647 %- 1 %- 147483648 %%+ 0 %%- 0 + 147483647 %+ 770262237 %- 780370470 %%- 147483648 %%- 877625584 %%- 862085843 %%+ 115440267 %- 0 %- 1 %- 393198654 %- 0 %+ 147483648 %%+ 11582488 %+ 503767061 %- 204783401 %%- 147483647 + 147483647 %%- 0 %%- 816085505 %+ 541623712 %%+ 996490538 %+ 1 + 147483648 + 1 %+ 147483647 %%+ 0 %+ 218939115 + 147483648 + 0 %- 285441407 %+ 188254232 %+ 147483647 %- 235513223 %%- 147483648 %%+ 0 %- 1 %- 147483648 %%- 267610775 %+ 147483647 + 275906256 %%+ 191677264 %- 797922044 %- 147483647 %+ 147483647 + 1 %%- 147483647 + 1 %- 147483648 %%- 501369002 %- 595766972 + 898416799 %%- 147483648 %%- 547877919 %%- 147483647 %+ 521827677 %- 147483647 %+ 147483648 %- 471254529 %+ 1 %%- 391720304 %+ 147483648 + 264585892 %- 663621079 %+ 506729265 %- 0 %+ 0 %- 661829975 %%+ 639213071 + 147483647 %+ 0 %- 0 %+ 1 %- 1 %+ 254585595 %- 0 + 0 %- 818156342 %%- 1 + 970949329 %%- 147483648 %%- 304870892 + 110703741 + 0 %+ 543542013 %+ 706110605 + 720711945 %+ 147483647 %- 49568498 %+ 212524561 %+ 0 %%+ 147483648 + 0 %+ 147483648 %+ 147483647 %+ 249112457 %%- 507231085 %+ 0 %+ 0 + 0 %+ 147483648 + 54118323 %- 1 %+ 531340419 %%- 147483647 %- 853016625 %+ 893667116 %- 0 %+ 147483647 %%+ 359780763 %%- 779715045 + 147483648 %%- 533647259 %+ 147483648 %+ 617949134 + 147483647 + 121665603 %%- 15968952 %+ 0 %- 1 %%- 246797725 %%- 147483648 %%- 138726812 %- 0 %- 147483648 %%- 147483648 %+ 178467504 %- 1 + 113182527 %%- 1 + 147483648 %%- 1 %%+ 147483647 %+ 147483647 %+ 147483647 + 0 %- 442336828 %+ 1 %%- 1 + 0 + 147483648 %- 147483647 + 147483647 %+ 85981297 %- 449441971 + 697651052 %%- 101214794 %%- 147483648 %- 147483648 %- 1 %%- 38463351 + 369271147 %- 0 + 147483647 %- 512646199 %%- 147483648 %%- 147483648 %%+ 147483648 %%+ 147483648 %%- 3855383 + 0 %+ 147483648 %%+ 1 %%- 147483648 %- 0 %- 708226308 %%- 147483648 + 74025531 %- 0 %+ 428101749 + 1 %- 0 %%- 526843860 %%+ 0 + 1 %- 0 %+ 1 %+ 1 %- 147483647 %%- 147483647 %- 28817303 %+ 878573164 %+ 661441721 %- 429383560 %%- 147483648 %%- 147483647 %%- 539058665 + 1 %%- 681744632 %%- 1 %%- 147483647 %%- 976802859 %%+ 147483647 %%+ 129799019 + 10694331 %+ 583989154 %- 731879248 + 1 %+ 147483648 %%+ 1 %%+ 0 %%- 0 + 147483647 %- 0 %- 645896125 %%- 270054128 %- 1 %- 225811124 %%- 1 %+ 1 %- 147483648 %- 970792431 %- 0 %+ 0 %%- 147483648 %%- 147483647 %+ 147483647 %%- 1 %+ 0 %%+ 147483648 %%+ 147483648 %%+ 439182828 + 147483647 %+ 0 %+ 551957295 + 1 + 667254433 + 1 + 181785527 + 147483647 %+ 147483648 %- 147483648 %+ 1 %+ 1 %%- 147483647 %+ 215165348 %+ 147483647 %- 228538912 %%- 1 %%+ 0 + 156096990 + 147483647 + 732954511 %%- 1 %+ 883120222 %+ 1 %- 906699969 %+ 716764486 %%+ 1 %%- 211391978 %+ 303699228 + 147483647 %- 147483648 %%- 147483648 %%- 158837650 %- 147483648 %- 1 + 147483647 %+ 0 %+ 147483647 + 814518979 %%- 147483647 %%- 395340132 %- 759721668 %- 985657991 %%- 790440493 %%+ 1 %- 1 %- 420966978 + 837417945 %+ 749039788 + 756952945 + 819345219 %- 0 %%- 147483648 %%- 0 %- 207216783 %%+ 147483648 + 147483647 %+ 147483648 %%- 147483647 %+ 340488047 %+ 777743725 + 81887372 %%- 0 %+ 8359452 + 1 %%- 948626638 %%- 0 %+ 147483647 %%+ 0 %%+ 1 %%- 0 %+ 364216441 %- 713163423 %%- 1 %%+ 491933138 + 147483647 %+ 0 %%- 147483647 %%+ 105182312 +"))
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
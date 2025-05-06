import org.junit.Test;

import static org.junit.Assert.*;

public class FractionsTest {
    @Test
    public void test01() {
        assertEquals("Un terç", Fractions.toWords("1/3"));
        assertEquals("Un mig", Fractions.toWords("1/2"));
        assertEquals("Un onzè", Fractions.toWords("1/11"));
        assertEquals("Un dissetè", Fractions.toWords("1/17"));
        assertEquals("Un dècim", Fractions.toWords("1/10"));

        assertEquals("Tres cinquens", Fractions.toWords("3/5"));
        assertEquals("Vuit novens", Fractions.toWords("8/9"));
        assertEquals("Onze catorzens", Fractions.toWords("11/14"));
        assertEquals("Disset divuitens", Fractions.toWords("17/18"));
        assertEquals("Set dècims", Fractions.toWords("7/10"));
    }

    @Test
    public void test02() {
        assertEquals("Un cinquantè", Fractions.toWords("1/50"));
        assertEquals("Un vint-i-unè", Fractions.toWords("1/21"));
        assertEquals("Un trentè", Fractions.toWords("1/30"));
        assertEquals("Un cinquantè", Fractions.toWords("1/50"));
        assertEquals("Cinc vint-i-dosens", Fractions.toWords("5/22"));
        assertEquals("Setze cinquanta-tresens", Fractions.toWords("16/53"));
        assertEquals("Un cinquanta-novè", Fractions.toWords("1/59"));
        assertEquals("Noranta-vuit noranta-novens", Fractions.toWords("98/99"));
        assertEquals("Quaranta-quatre seixanta-tresens", Fractions.toWords("44/63"));
    }

    @Test
    public void test03() {
        assertEquals("Un centèsim", Fractions.toWords("1/100"));
        assertEquals("Cent cent tresens", Fractions.toWords("100/103"));
        assertEquals("Cent vint-i-tres nou-cents cinquanta-quatrens", Fractions.toWords("123/954"));
        assertEquals("Un vuit-cents cinquanta-dosè", Fractions.toWords("1/852"));
        assertEquals("Un dos-cents seixanta-cinquè", Fractions.toWords("1/265"));
        assertEquals("Seixanta-sis dos-cents seixanta-cinquens", Fractions.toWords("66/265"));
        assertEquals("Quatre-cents setanta-sis nou-cents noranta-novens", Fractions.toWords("476/999"));
        assertEquals("Cinc-cents quaranta-tres nou-cents quaranta-vuitens", Fractions.toWords("543/948"));
    }

    @Test
    public void test04() {
        assertEquals("Un mil unè", Fractions.toWords("1/1001"));
        assertEquals("Dos mil unens", Fractions.toWords("2/1001"));
        assertEquals("Un mil·lèsim", Fractions.toWords("1/1000"));
        assertEquals("Dos mil·lèsims", Fractions.toWords("2/1000"));
        assertEquals("Un deu mil centèsim", Fractions.toWords("1/10100"));
        assertEquals("Un deu mil·lèsim", Fractions.toWords("1/10000"));
        assertEquals("Sis deu mil cent dècims", Fractions.toWords("6/10110"));
        assertEquals("Deu mil cinc-cents quaranta-tres seixanta-cinc mil vint-i-unens", Fractions.toWords("10543/65021"));
        assertEquals("Seixanta-set mil quatre-cents trenta-dos vuitanta-quatre mil dos-cents onzens", Fractions.toWords("67432/84211"));
    }

    @Test
    public void test05() {
        assertEquals("Dos milionèsims", Fractions.toWords("2/1000000"));
        assertEquals("Un milionèsim", Fractions.toWords("1/1000000"));
        assertEquals("Un milió unè", Fractions.toWords("1/1000001"));
        assertEquals("Dos milió unens", Fractions.toWords("2/1000001"));
        assertEquals("Tres dos milions tresens", Fractions.toWords("3/2000003"));
        assertEquals("Un milió mil·lèsim", Fractions.toWords("1/1001000"));
        assertEquals("Cinc-cents quaranta-tres mil nou-cents seixanta-cinc sis milions cinc-cents quaranta-tres mil nou-cents vint-i-unens",
                Fractions.toWords("543965/6543921"));
        assertEquals("Un milió dos-cents trenta-quatre mil cinc-cents seixanta-set dotze milions tres-cents quaranta-cinc mil sis-cents setanta-vuitens",
                Fractions.toWords("1234567/12345678"));
    }

    @Test
    public void test06() {
        assertEquals("Quatre, dos dotzens", Fractions.toWords("50/12"));
        assertEquals("Vuit, vint-i-dos setanta-novens", Fractions.toWords("654/79"));
        assertEquals("Vint", Fractions.toWords("100/5"));
        assertEquals("Noranta-nou", Fractions.toWords("990/10"));
        assertEquals("Un", Fractions.toWords("1000/1000"));
        assertEquals("Set-cents dos, tres-cents cinquanta-nou sis-cents cinquanta-tresens",
                Fractions.toWords("458765/653"));
        assertEquals("Cent dos milions vuit-cents vuitanta mil sis-cents cinquanta-set, sis dotzens",
                Fractions.toWords("1234567890/12"));
    }
}
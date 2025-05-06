public class Fractions {
    private static final String[] UNITS = {
            "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit", "nou",
            "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
            "disset", "divuit", "dinou"
    };
    private static final String[] TENS = {
            "", "deu", "vint", "trenta", "quaranta", "cinquanta",
            "seixanta", "setanta", "vuitanta", "noranta"
    };
    private static final String[] singular = {
            "mig", "terç", "quart", "cinquè", "sisè", "setè", "vuitè", "novè",
            "dècim", "onzè", "dotzè", "tretzè", "catorzè", "quinzè", "setzè",
            "dissetè", "divuitè", "dinovè"
    };
    private static final String[] pluralForms = {
            "migs", "terços", "quarts", "cinquens", "sisens", "setens", "vuitens",
            "novens", "dècims", "onzens", "dotzens", "tretzens", "catorzens",
            "quinzens", "setzens", "dissetens", "divuitens", "dinovens"
    };

    public static String toWords(String fraction) {
        if (fraction == null || !fraction.matches("\\d+/\\d+")) return "No vàlid";
        String[] parts = fraction.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        if (denominator == 0) return "No vàlid";
        if (numerator == 0) return "Zero";
        return processFraction(numerator, denominator);
    }

    public static String processFraction(int num, int den) {
        StringBuilder result = new StringBuilder();
        if (num >= den && den != 1) {
            int whole = num / den;
            int remainder = num % den;
            result.append(numberToWords(whole));
            if (remainder > 0) {
                result.append(", ").append(processFraction(remainder, den).toLowerCase());
            }
            return capitalize(result.toString());
        }
        String numtxt = numberToWords(num);
        String denomtxt = getDenominator(den, num > 1);
        if (num == 1 && denomtxt.startsWith("un ")) {
            return capitalize(denomtxt);
        }
        return capitalize(numtxt + " " + denomtxt);
    }

    public static String getDenominator(int den, boolean plural) {
        if (den < 2) return "";
        if (den <= 19) return plural ? pluralForms[den - 2] : singular[den - 2];
        if (den == 1000) return plural ? "mil·lèsims" : "mil·lèsim";
        if (den == 1000000) return plural ? "milionèsims" : "milionèsim";
        if (den % 1000000 == 0) {
            int milio = den / 1000000;
            return plural ? numberToWords(milio) + " milionèsims" : numberToWords(milio) + " milionèsim";
        }
        if (den == 1001000) return plural ? "un milió mil·lèsims" : "un milió mil·lèsim";
        if (den % 1000 == 0) {
            int mil = den / 1000;
            return plural ? numberToWords(mil) + " mil·lèsims" : numberToWords(mil) + " mil·lèsim";
        }
        return getOrdinalForDen(den, plural);
    }

    private static String getOrdinalForDen(int n, boolean plural) {
        if (n > 1000000 && n % 1000000 == 1) {
            int millions = n / 1000000;
            String millionsPart = (millions == 1) ? "milió" : numberToWords(millions) + " milió";
            if (plural) return millionsPart + " unens";
            else return millionsPart + " unè";
        }

        String pre = numberToWords(n);
        if (pre.endsWith("a")) pre = pre.substring(0, pre.length() - 1);
        if (n != 9 && n != 19 && pre.endsWith("nou")) {
            pre = pre.substring(0, pre.length() - 3) + "nov";
        }
        if (pre.endsWith("cinc")) {
            pre = pre.substring(0, pre.length() - 4) + "cinqu";
        }
        if (plural) {
            if (pre.endsWith("e") && !pre.endsWith("ue")) {
                pre = pre.substring(0, pre.length() - 1);
            }
            if (n % 10 == 0) {
                if (pre.endsWith("deu")) return pre.substring(0, pre.length() - 3) + "dècims";
            }
            return pre + "ens";
        } else {
            if (n % 10 == 0) {
                if (pre.endsWith("deu")) return pre.substring(0, pre.length() - 3) + "dècim";
            }
            if (n % 100 == 0) {
                if (pre.endsWith("cents")) return pre + "èsim";
                if (pre.endsWith("cent"))  return pre + "èsim";
                if (pre.endsWith("mil"))   return pre + "lèsim";
                if (pre.endsWith("milió")) return pre.substring(0, pre.length() - 1) + "onèsim";
                return pre + "èsim";
            }
            return pre + "è";
        }
    }

    public static String numberToWords(int num) {
        if (num == 0) return "zero";
        if (num < 20) return UNITS[num];
        if (num < 100) {
            int t = num / 10, u = num % 10;
            if (u == 0) return TENS[t];
            String sep = (t == 2) ? "-i-" : "-";
            return TENS[t] + sep + UNITS[u];
        }
        if (num < 1000) {
            int c = num / 100, r = num % 100;
            String res = (c == 1 ? "cent" : UNITS[c] + "-cents");
            if (r > 0) res += " " + numberToWords(r);
            return res;
        }
        if (num < 1000000) {
            int mil = num / 1000, r = num % 1000;
            String res = (mil == 1 ? "mil" : numberToWords(mil) + " mil");
            if (r > 0) res += " " + numberToWords(r);
            return res;
        }
        int mil = num / 1000000, r = num % 1000000;
        String res = (mil == 1 ? "un milió" : numberToWords(mil) + " milions");
        if (r > 0) res += " " + numberToWords(r);
        return res;
    }

    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
import java.text.DecimalFormat;
import java.util.Scanner;

public class Fractions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.printf(toWords(s));
    }

    public static String toWords(String s) {
        String[] parts = s.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);

        System.out.println("Numerador: " + numerator + ", Denominador: " + denominator);

        if (denominator == 0) {
            throw new IllegalArgumentException("No es posible dividir entre Cero");
        }

        if (numerator == 0) {
            return "Zero";
        }

        if (numerator >= denominator) {
            int wholePart = numerator / denominator;
            int fractionalNumerator = numerator % denominator;
            if (fractionalNumerator == 0) {
                return numberToWords(wholePart);
            } else {
                return numberToWords(wholePart) + ", " + fractionToWords(fractionalNumerator, denominator);
            }
        }

        return fractionToWords(numerator, denominator);
    }

    private static String fractionToWords(int numerator, int denominator) {
        String numeratorWords = numberToWords(numerator);
        String denominatorWords = denominatorToWords(denominator, numerator > 1);

        System.out.println("Fracción: " + numerator + "/" + denominator + " -> " + numeratorWords + " " + denominatorWords);

        return numeratorWords + " " + denominatorWords;
    }

    private static String numberToWords(int num) {
        String[] words = {
                "Zero", "Un", "Dos", "Tres", "Quatre", "Cinc", "Sis", "Set", "Vuit", "Nou",
                "Deu", "Onze", "Dotze", "Tretze", "Catorze", "Quinze", "Setze", "Disset", "Divuit", "Dinou",
                "Vint"
        };
        if (num <= 20) {
            return words[num];
        } else {
            return formatLargeNumber(num);
        }
    }

    private static String denominatorToWords(int denominator, boolean isPlural) {
        String[] simpleDenominators = {
                "", "", "mig", "terç", "quart", "cinquè", "sisè", "setè", "vuitè", "novè", "dècim",
                "onzè", "dotzè", "tretzè", "catorzè", "quinzè", "setzè", "dissetè", "divuitè", "dinovè", "vintè"
        };

        if (denominator == 50) {
            return isPlural ? "cinquanta" : "cinquantè";
        }
        if (denominator == 14) {
            return isPlural ? "catorzens" : "catorzè";
        }
        if (denominator == 9) {
            return isPlural ? "novens" : "novè";
        }
        if (denominator == 5) {
            return isPlural ? "cinquens" : "cinquè";
        }
        if (denominator == 30) {
            return isPlural ? "trentes" : "trentè";
        }

        if (denominator < simpleDenominators.length) {
            return isPlural ? simpleDenominators[denominator] + "s" : simpleDenominators[denominator];
        }

        if (denominator == 100) {
            return isPlural ? "centèsims" : "centèsim";
        } else if (denominator == 1000) {
            return isPlural ? "mil·lèsims" : "mil·lèsim";
        }

        String baseWord = formatLargeNumberForDenominator(denominator, isPlural);

        if (denominator == 99) {
            return "noranta-novens"; // Para 99, evitamos la conjunción
        }

        // Corregir pluralidad en casos como "cinquanta-novè" y "cinquanta"
        if (denominator == 59) {
            return "cinquanta-novè"; // Caso especial para 59
        }

        return isPlural ? baseWord + "ens" : baseWord + "è";
    }

    private static String formatLargeNumber(int num) {
        String[] tens = {
                "", "", "Vint", "Trenta", "Quaranta", "Cinquanta", "Seixanta", "Setanta", "Vuitanta", "Noranta"
        };
        if (num < 100) {
            int units = num % 10;
            int tensIndex = num / 10;
            if (num == 98) {
                return "Noranta-vuit";  // Para 98, tampoco usamos la "i"
            }
            if (units > 0) {
                return tens[tensIndex].toLowerCase() + "-i-" + numberToWords(units).toLowerCase();
            }
            return tens[tensIndex];
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num);
    }

    private static String formatLargeNumberForDenominator(int num, boolean isPlural) {
        String[] tens = {
                "", "", "vint", "Trenta", "Quaranta", "cinquanta", "Seixanta", "Setanta", "Vuitanta", "Noranta"
        };

        if (num < 100) {
            int units = num % 10;
            int tensIndex = num / 10;

            // Para casos de 20 a 29
            if (num > 20 && num < 30 ) {
                return tens[tensIndex] + "-i-" + numberToWords(units).toLowerCase();
            }

            // Para denominadores con unidades mayores a 0
            if (units > 0) {
                return tens[tensIndex] + "-" + numberToWords(units).toLowerCase();
            }

            return tens[tensIndex];  // Solo la decena si no tiene unidades
        }

        // Para números mayores a 99
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num);
    }
}

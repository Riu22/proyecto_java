import java.text.DecimalFormat;

public class Fractions {

    // Método principal para convertir fracciones en palabras
    public static String toWords(String s) {
        // Separar numerador y denominador
        String[] parts = s.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);

        // Si el numerador es cero
        if (numerator == 0) {
            return "Zero";
        }

        // Si el numerador es mayor o igual al denominador
        if (numerator >= denominator) {
            int wholePart = numerator / denominator;
            int fractionalNumerator = numerator % denominator;

            if (fractionalNumerator == 0) {
                return numberToWords(wholePart); // Solo el número entero
            } else {
                return numberToWords(wholePart) + ", " + fractionToWords(fractionalNumerator, denominator);
            }
        }

        // Si es una fracción propia
        return fractionToWords(numerator, denominator);
    }

    // Método para convertir fracciones propias en palabras
    private static String fractionToWords(int numerator, int denominator) {
        String numeratorWords = numberToWords(numerator);
        String denominatorWords = denominatorToWords(denominator, numerator > 1);
        return numeratorWords + " " + denominatorWords;
    }

    // Método para convertir números en palabras (numerador y parte entera)
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

    // Método para convertir denominadores en palabras
    private static String denominatorToWords(int denominator, boolean isPlural) {
        String[] simpleDenominators = {
            "", "mig", "terç", "quart", "cinquè", "sisè", "setè", "vuitè", "novè", "dècim",
            "onzè", "dotzè", "tretzè", "catorzè", "quinzè", "setzè", "dissetè", "divuitè", "dinovè", "vintè"
        };

        if (denominator <= 20) {
            return isPlural ? simpleDenominators[denominator] + "s" : simpleDenominators[denominator];
        }

        // Potencias de 10
        if (denominator == 100) {
            return isPlural ? "centèsims" : "centèsim";
        } else if (denominator == 1000) {
            return isPlural ? "mil·lèsims" : "mil·lèsim";
        }

        // Números grandes (no potencias de 10)
        String baseWord = formatLargeNumber(denominator);
        return isPlural ? baseWord + "ens" : baseWord + "è";
    }

    // Método para formatear números grandes
    private static String formatLargeNumber(int num) {
        String[] tens = {
            "", "", "Vint", "Trenta", "Quaranta", "Cinquanta", "Seixanta", "Setanta", "Vuitanta", "Noranta"
        };

        if (num < 100) {
            int units = num % 10;
            int tensIndex = num / 10;
            return units == 0 ? tens[tensIndex] : tens[tensIndex] + "-" + numberToWords(units).toLowerCase();
        }

        // Para números mayores (denominadores grandes)
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num);
    }
}



public class Fractions {

    public static String toWords(String s) {
        // La función convierte una fracción en su forma escrita en palabras en español.

        String[] parts = s.split("/");  // Separa la entrada en dos partes: numerador y denominador.
        int num = Integer.parseInt(parts[0]);  // Convierte el numerador a un número entero.
        int denominator = Integer.parseInt(parts[1]);  // Convierte el denominador a un número entero.

        String res;

        // Si el numerador es mayor o igual al denominador (es decir, tiene una parte entera)
        if (num >= denominator) {
            int rest = num / denominator;  // Calcula la parte entera (cuántas veces cabe el denominador en el numerador).
            int fract = partFranctional(num, denominator);  // Obtiene la parte fraccionaria restante.

            // Si no hay fracción restante, solo devuelve la parte entera.
            if (fract == 0) {
                return numUntillM(rest);
            }

            // Si hay fracción restante, devuelve la parte entera y la fracción en palabras.
            res = numUntillM(rest) + ", " + toWords(fract + "/" + denominator).toLowerCase();
        } else {
            // Si el numerador es menor que el denominador (es una fracción propia)

            if (num < 1) {
                res = "zero";  // Si el numerador es 0, devuelve "zero".
            } else if (num == 1 && denominator <= 19) {
                // Si el numerador es 1 y el denominador es menor o igual a 19, lo convierte en palabra singular.
                res = numUntill999(num) + " " + denominatorUntill20(denominator);
            } else if (denominator <= 19) {
                // Si el denominador es menor o igual a 19, lo convierte en plural.
                res = numUntill999(num) + " " + denominatorPluralUnTill20(denominator);
            } else if (denominator <= 99) {
                // Si el denominador es mayor que 19 pero menor o igual a 99, lo maneja de forma especial.
                res = numUntill999(num) + " " + Create99s(num, denominator);
            } else if (denominator <= 999) {
                // Si el denominador es mayor que 99 pero menor o igual a 999, lo maneja de forma especial.
                res = numUntill999(num) + " " + Create999s(num, denominator);
            } else if (denominator <= 999_999) {
                // Si el denominador es mayor que 999 pero menor o igual a 999,999, lo maneja de forma especial.
                res = numUntill9999(num) + " " + Create9999s(num, denominator);
            } else if (denominator <= 999_999_999) {
                // Si el denominador es mayor que 999,999 pero menor o igual a 999,999,999, lo maneja de forma especial.
                res = numUntillM(num) + " " + CreateMs(num, denominator);
            } else {
                // Si el denominador es mayor que 999,999,999, devuelve "No válido".
                res = "No válido";
            }
        }

        // Convierte la primera letra a mayúsculas y el resto a minúsculas antes de devolver la respuesta.
        return res.substring(0, 1).toUpperCase() + res.substring(1).toLowerCase();
    }

    public static String denominatorUntill20(int denominator) {
        // La función recibe un denominador y devuelve su representación en palabras
        // en catalán, para los denominadores entre 2 y 19 (inclusive), en formato ordinal.

        switch (denominator) {
            case 2:
                return "mig";  // "medio" (para 1/2)
            case 3:
                return "terç";  // "tercio" (para 1/3)
            case 4:
                return "quart";  // "cuarto" (para 1/4)
            case 5:
                return "cinquè";  // "quinto" (para 1/5)
            case 6:
                return "sisè";  // "sexto" (para 1/6)
            case 7:
                return "setè";  // "séptimo" (para 1/7)
            case 8:
                return "vuitè";  // "octavo" (para 1/8)
            case 9:
                return "novè";  // "noveno" (para 1/9)
            case 10:
                return "dècim";  // "décimo" (para 1/10)
            case 11:
                return "onzè";  // "undécimo" (para 1/11)
            case 12:
                return "dotzè";  // "duodécimo" (para 1/12)
            case 13:
                return "tretzè";  // "decimotercero" (para 1/13)
            case 14:
                return "catorzè";  // "decimocuarto" (para 1/14)
            case 15:
                return "quinzè";  // "decimoquinto" (para 1/15)
            case 16:
                return "setzè";  // "decimosexto" (para 1/16)
            case 17:
                return "dissetè";  // "decimoséptimo" (para 1/17)
            case 18:
                return "devuitè";  // "decimoctavo" (para 1/18)
            case 19:
                return "dinouè";  // "decimonoveno" (para 1/19)
        }

        return "";  // Si el denominador no está entre 2 y 19, retorna una cadena vacía.
    }

    public static String denominatorPluralUnTill20(int denominator) {
        // La función recibe un denominador y devuelve su representación en palabras
        // en catalán, para los denominadores entre 2 y 19 (inclusive), en formato plural ordinal.

        switch (denominator) {
            case 2:
                return "mitjos";  // "medios" (para 1/2, en plural)
            case 3:
                return "terços";  // "tercios" (para 1/3, en plural)
            case 4:
                return "quarts";  // "cuartos" (para 1/4, en plural)
            case 5:
                return "cinquens";  // "quintos" (para 1/5, en plural)
            case 6:
                return "sisens";  // "sextos" (para 1/6, en plural)
            case 7:
                return "setens";  // "séptimos" (para 1/7, en plural)
            case 8:
                return "vuitens";  // "octavos" (para 1/8, en plural)
            case 9:
                return "novens";  // "novenos" (para 1/9, en plural)
            case 10:
                return "dècims";  // "décimos" (para 1/10, en plural)
            case 11:
                return "onzens";  // "undécimos" (para 1/11, en plural)
            case 12:
                return "dotzens";  // "duodécimos" (para 1/12, en plural)
            case 13:
                return "tretzens";  // "decimoterceros" (para 1/13, en plural)
            case 14:
                return "catorzens";  // "decimocuartos" (para 1/14, en plural)
            case 15:
                return "quinzens";  // "decimoquintos" (para 1/15, en plural)
            case 16:
                return "setzens";  // "decimosextos" (para 1/16, en plural)
            case 17:
                return "dissetens";  // "decimoséptimos" (para 1/17, en plural)
            case 18:
                return "devuitens";  // "decimoctavos" (para 1/18, en plural)
            case 19:
                return "dinouens";  // "decimonovenos" (para 1/19, en plural)
        }
        return "";  // Si el denominador no está entre 2 y 19, retorna una cadena vacía.
    }

    public static String numUntill20(int num) {
        // La función recibe un número entre 1 y 19 (inclusive) y devuelve su
        // representación en palabras en catalán.

        switch (num) {
            case 1:
                return "Un";  // "Un" para el número 1
            case 2:
                return "Dos";  // "Dos" para el número 2
            case 3:
                return "Tres";  // "Tres" para el número 3
            case 4:
                return "Quatre";  // "Quatre" para el número 4
            case 5:
                return "Cinc";  // "Cinc" para el número 5
            case 6:
                return "Sis";  // "Sis" para el número 6
            case 7:
                return "Set";  // "Set" para el número 7
            case 8:
                return "Vuit";  // "Vuit" para el número 8
            case 9:
                return "Nou";  // "Nou" para el número 9
            case 10:
                return "Deu";  // "Deu" para el número 10
            case 11:
                return "Onze";  // "Onze" para el número 11
            case 12:
                return "Dotze";  // "Dotze" para el número 12
            case 13:
                return "Tretze";  // "Tretze" para el número 13
            case 14:
                return "Catorze";  // "Catorze" para el número 14
            case 15:
                return "Quinze";  // "Quinze" para el número 15
            case 16:
                return "Setze";  // "Setze" para el número 16
            case 17:
                return "Disset";  // "Disset" para el número 17
            case 18:
                return "Devuit";  // "Devuit" para el número 18
            case 19:
                return "Dinou";  // "Dinou" para el número 19
        }
        return "";  // Si el número no está entre 1 y 19, retorna una cadena vacía.
    }

    public static String numTens(int num) {
        // La función recibe un número que representa la decena (de 1 a 9) y devuelve
        // su nombre en palabras en catalán, correspondiente a decenas completas.

        switch (num) {
            case 2:
                return "Vint";  // "Vint" para 20
            case 3:
                return "Trenta";  // "Trenta" para 30
            case 4:
                return "Quaranta";  // "Quaranta" para 40
            case 5:
                return "Cinquanta";  // "Cinquanta" para 50
            case 6:
                return "Seixanta";  // "Seixanta" para 60
            case 7:
                return "Setanta";  // "Setanta" para 70
            case 8:
                return "Vuitanta";  // "Vuitanta" para 80
            case 9:
                return "Noranta";  // "Noranta" para 90
            case 1:
                return "Cent";  // "Cent" para 100
        }
        return "";  // Si el número no está en el rango de 1 a 9, retorna una cadena vacía.
    }

    public static String DenominatorTens(int denominator) {
        // La función recibe un número que representa el denominador en forma de decenas
        // y devuelve su nombre en palabras en catalán para el denominador correspondiente.

        switch (denominator) {
            case 2:
                return "vintè";  // "Vintè" para 20
            case 3:
                return "trentè";  // "Trentè" para 30
            case 4:
                return "quarantè";  // "Quarantè" para 40
            case 5:
                return "cinquantè";  // "Cinquantè" para 50
            case 6:
                return "seixantè";  // "Seixantè" para 60
            case 7:
                return "setantè";  // "Setantè" para 70
            case 8:
                return "vuitantè";  // "Vuitantè" para 80
            case 9:
                return "norantè";  // "Norantè" para 90
            case 1:
                return "dècims";  // "Dècims" para 100
        }
        return "";  // Si el denominador no está en el rango de 1 a 9, retorna una cadena vacía.
    }

    public static String denominadorHundredsPlural(int denominator) {
        // La función recibe un número que representa el denominador en forma de centenas
        // y devuelve su nombre en palabras en catalán para el denominador correspondiente.

        switch (denominator) {
            case 2:
                return "vint";  // "Vint" para 20
            case 3:
                return "trenta";  // "Trenta" para 30
            case 4:
                return "quaranta";  // "Quaranta" para 40
            case 5:
                return "cinquanta";  // "Cinquanta" para 50
            case 6:
                return "seixanta";  // "Seixanta" para 60
            case 7:
                return "setanta";  // "Setanta" para 70
            case 8:
                return "vuitanta";  // "Vuitanta" para 80
            case 9:
                return "noranta";  // "Noranta" para 90
            case 1:
                return "cent";  // "Cent" para 100
        }
        return "";  // Si el denominador no está en el rango de 1 a 9, retorna una cadena vacía.
    }
    public static String remainderTensSingular(int residue) {
        // La función recibe un número que representa un residuo en el rango de 1 a 9
        // y devuelve su nombre en palabras en catalán, con una terminación singular
        // para indicar el orden de una fracción.

        switch (residue) {
            case 1:
                return "unè";  // "Unè" para 1
            case 2:
                return "dosè";  // "Dosè" para 2
            case 3:
                return "tresè";  // "Tresè" para 3
            case 4:
                return "quatrè";  // "Quatrè" para 4
            case 5:
                return "cinquè";  // "Cinquè" para 5
            case 6:
                return "sisè";  // "Sisè" para 6
            case 7:
                return "setè";  // "Setè" para 7
            case 8:
                return "vuitè";  // "Vuitè" para 8
            case 9:
                return "novè";  // "Novè" para 9
        }
        return "";  // Si el residuo no está en el rango de 1 a 9, devuelve una cadena vacía.
    }

    public static String residueDesenesPlural(int residue) {
        // La función recibe un número de resto de decenas y devuelve su nombre en plural en catalán.

        switch (residue) {
            case 1:
                return "unens";  // Si el número es 1, devuelve "unens" (para el resto de 10).
            case 2:
                return "dosens";  // Para 2, devuelve "dosens" (resto de 20).
            case 3:
                return "tresens";  // Para 3, devuelve "tresens".
            case 4:
                return "quatrens";  // Para 4, devuelve "quatrens".
            case 5:
                return "cinquens";  // Para 5, devuelve "cinquens".
            case 6:
                return "sisens";  // Para 6, devuelve "sisens".
            case 7:
                return "setens";  // Para 7, devuelve "setens".
            case 8:
                return "vuitens";  // Para 8, devuelve "vuitens".
            case 9:
                return "novens";  // Para 9, devuelve "novens".
        }
        return "";  // Si el número no está entre 1 y 9, devuelve una cadena vacía.
    }

    public static String numUnits(int num) {
        // La función recibe un número entre 1 y 9 y devuelve su nombre en palabras en catalán.

        switch (num) {
            case 1:
                return "u";  // Si el número es 1, devuelve "u".
            case 2:
                return "dos";  // Para 2, devuelve "dos".
            case 3:
                return "tres";  // Para 3, devuelve "tres".
            case 4:
                return "quatre";  // Para 4, devuelve "quatre".
            case 5:
                return "cinc";  // Para 5, devuelve "cinc".
            case 6:
                return "sis";  // Para 6, devuelve "sis".
            case 7:
                return "set";  // Para 7, devuelve "set".
            case 8:
                return "vuit";  // Para 8, devuelve "vuit".
            case 9:
                return "nou";  // Para 9, devuelve "nou".
        }
        return "";  // Si el número no está entre 1 y 9, devuelve una cadena vacía.
    }

    public static String numHundreds(int num) {
        // La función recibe un número entre 1 y 9 y devuelve su representación en palabras en catalán para centenas.

        if (num == 1) {
            return "Cent";  // Si el número es 1, devuelve "Cent".
        }
        return numUnits(num) + "-cents";  // Para otros números, devuelve el número en unidades seguido de "-cents".
    }

    public static String numThousand(int num) {
        // La función recibe un número entre 1 y 9 y devuelve su representación en palabras en catalán para miles.

        if (num == 1) {
            return "Mil";  // Si el número es 1, devuelve "Mil".
        }
        return numUnits(num) + "mil";  // Para otros números, devuelve el número en unidades seguido de "mil".
    }

    public static String numMilions(int num) {
        // La función recibe un número entre 1 y 9 y devuelve su representación en palabras en catalán para millones.

        if (num == 1) {
            return "Milió";  // Si el número es 1, devuelve "Milió".
        }
        return numUnits(num) + "milio";  // Para otros números, devuelve el número en unidades seguido de "milio".
    }

    public static String numsEsims(int num, int denominator) {
        // La función recibe dos parámetros:
        // - 'num' es el número que queremos representar en palabras.
        // - 'denominator' es el denominador (un número que representa el rango al que pertenece el 'num', como 1,000 o 1,000,000).

        if (num == 0) return ""; // Si el número es 0, la función devuelve una cadena vacía.

        if (denominator <= 999) {
            // Si el denominador es hasta 999 (centenas), maneja los números hasta "centenes".
            if (num == 1 && denominator % 10 == 0 && denominator % 100 == 0)
                return numHundreds(num).toLowerCase() + "èsim";  // Si es 1 y es un múltiplo de 100, devuelve "centèsim".
            return numHundreds(num).toLowerCase();  // Para otros números, devuelve el número en "hundreds" (centenas).
        } else if (denominator <= 9999) {
            // Si el denominador es hasta 9999 (miles), maneja los números hasta "mil".
            int milesimas = denominator / 1_000;
            if (milesimas == 1 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numThousand(milesimas).toLowerCase() + sufijo;  // Si es 1 y múltiplo de 1000, añade el sufijo.
            }
            return numThousand(milesimas).toLowerCase();  // Para otros valores, devuelve el número en miles.
        } else if (denominator <= 99999) {
            // Si el denominador es hasta 99999 (diezmil), maneja los números hasta "diezmil".
            int milesimas10 = denominator / 10_000;
            int milesimas = (denominator % 10_000) / 1_000;
            int mil = (milesimas10 * 10) + milesimas;
            if (milesimas10 == 1 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1_000 == 0 && denominator % 10_000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numUntill99(mil) + " mil" + sufijo;  // Si es un múltiplo de 10,000, añade sufijo.
            }
            return numUntill99(mil) + " mil";  // Para otros casos, devuelve el número hasta 10,000.
        } else if (denominator <= 999999) {
            // Si el denominador es hasta 999999 (cienmil), maneja los números hasta "cienmil".
            int milesimas100 = denominator / 100_000;
            int milesimas10 = (denominator % 100_000) / 10_000;
            int milesimas = (denominator % 10_000) / 1_000;
            int mil100 = (milesimas100 * 100) + (milesimas10 * 10) + milesimas;
            if (milesimas100 == 1 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1_000 == 0 && denominator % 10_000 == 0 && denominator % 100_000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numUntill999(mil100) + " mil" + sufijo;  // Si es un múltiplo de 100,000, añade sufijo.
            }
            return numUntill999(mil100) + " mil";  // Para otros casos, devuelve el número hasta 100,000.
        } else if (denominator <= 9999999) {
            // Si el denominador es hasta 9999999 (millones), maneja los números hasta "millón".
            int milionesimas = denominator / 1_000_000;
            int milesimas100 = (denominator % 1_000_000) / 100_000;
            int milesimas10 = (denominator % 100_000) / 10_000;
            int milesimas = (denominator % 10_000) / 1_000;
            if (milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1_000 == 0 && denominator % 10_000 == 0 && denominator % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                if (milionesimas == 1) return "milion" + sufijo;  // Si es 1 millón, devuelve "milionèsim" o "milions".
                return numUntill999(milionesimas) + " milion" + sufijo;
            }
            if (milionesimas == 1) return "milió";  // Para 1 millón.
            return numUntill999(milionesimas) + " milions";  // Para más de 1 millón.
        } else if (denominator <= 99999999) {
            // Si el denominador es hasta 99999999 (diez millones).
            // El proceso es similar al anterior, pero con una escala de millones más grande.
            int milionesimas10 = denominator / 10_000_000;
            int milionesimas = (denominator % 10_000_000) / 1_000_000;
            int milesimas100 = (denominator % 1_000_000) / 100_000;
            int milesimas10 = (denominator % 100_000) / 10_000;
            int milesimas = (denominator % 10_000) / 1_000;
            int mil100 = (milionesimas10 * 10) + milionesimas;
            if (milionesimas == 0 && milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1_000 == 0 && denominator % 10_000 == 0 && denominator % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                return numUntill999(mil100) + " milion" + sufijo;
            }
            return numUntill999(mil100) + " milions";  // Devuelve el número en millones.
        } else if (denominator <= 999999999) {
            // Si el denominador es hasta 999999999 (mil millones), maneja la escala de mil millones.
            int milionesimas100 = denominator / 100_000_000;
            int milionesimas10 = (denominator % 100_000_000) / 10_000_000;
            int milionesimas = (denominator % 10_000_000) / 1_000_000;
            int milesimas100 = (denominator % 1_000_000) / 100_000;
            int milesimas10 = (denominator % 100_000) / 10_000;
            int milesimas = (denominator % 10_000) / 1_000;
            int mil100 = (milionesimas100 * 100) + (milionesimas10 * 10) + milionesimas;
            if (milionesimas10 == 0 && milionesimas == 0 && milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denominator % 10 == 0 && denominator % 100 == 0 && denominator % 1_000 == 0 && denominator % 10_000 == 0 && denominator % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                return numUntill999(mil100) + " milion" + sufijo;
            }
            String sufijo = " milions";
            if (milionesimas == 1 && milionesimas10 == 0) sufijo = " milió";  // Si es "mil millón", se dice "milió".
            return numUntill999(mil100) + sufijo;
        }

        return ""; // Si el denominador es mayor a 999999999, devuelve una cadena vacía.
    }

    public static String Create99s(int num, int denominator) {
        // Determina cómo separar las unidades y decenas.
        String separador = "-";
        if (denominator < 30) {
            separador += "i-"; // Para números menores de 30, utiliza "i" para unir decenas y unidades.
        }
        int decenes = denominator / 10;  // Decenas del número.
        int unitats = denominator % 10; // Unidades del número.

        // Si las decenas o las unidades son 0, el separador no es necesario.
        if (decenes == 0 || unitats == 0) {
            separador = "";
        }

        // Si el número es 1 y tiene unidades, se maneja de manera especial.
        if (unitats > 0 && num == 1) {
            return denominadorHundredsPlural(decenes) + separador + remainderTensSingular(unitats);
        }
        // Si el número es mayor que 1, devuelve la forma plural.
        else if (unitats > 0 && num > 1) {
            return denominadorHundredsPlural(decenes) + separador + residueDesenesPlural(unitats);
        }
        // Si no hay unidades, solo devuelve las decenas.
        else {
            return DenominatorTens(decenes);
        }
    }

    public static String Create999s(int num, int denominator) {
        if (denominator <= 99) {
            // Si el denominador es 99 o menor, usa Create99s.
            return Create99s(num, denominator);
        }

        // Si el denominador es mayor, maneja las centenas.
        int centenes = denominator / 100;  // Centenas del número.
        int decenes = denominator % 100;   // Las otras partes (decenas y unidades).
        String separador = " ";  // Por defecto, usa espacio como separador.

        if (centenes == 0) {
            separador = "";  // Si no hay centenas, no se usa separador.
        }

        // Si las decenas son mayores que 0 y el número es 1, usa Create99s para decenas.
        if (decenes > 0 && num == 1) {
            return numsEsims(centenes, denominator) + separador + Create99s(num, decenes);
        }
        // Si el número es mayor que 1, también llama a Create99s para decenas.
        else if (decenes > 0 && num > 1) {
            return numsEsims(centenes, denominator) + separador + Create99s(num, decenes);
        }
        // Si no hay decenas, solo usa la conversión para las centenas.
        else {
            return numsEsims(centenes, denominator);
        }
    }

    public static String Create9999s(int num, int denominator) {
        if (denominator <= 999) {
            // Si el denominador es 999 o menos, delega al método Create999s.
            return Create999s(num, denominator);
        }

        int centenes = denominator % 1_000; // Extrae las centenas del denominador.

        // Si hay centenas y el número es 1, se usa el método numsEsims para manejar el número y luego se llama a Create999s para las centenas.
        if (centenes > 0 && num == 1) {
            return numsEsims(num, denominator) + " " + Create999s(num, centenes);
        }
        // Si hay centenas y el número es mayor que 1, hace lo mismo pero en plural.
        else if (centenes > 0 && num > 1) {
            return numsEsims(num, denominator) + " " + Create999s(num, centenes);
        }
        // Si no hay centenas, solo se llama a numsEsims.
        else {
            return numsEsims(num, denominator);
        }
    }

    public static String CreateMs(int num, int denominator) {
        int milesimas = denominator % 1_000_000; // Extrae las milesimas del denominador.

        // Si hay milesimas y el número es 1, se usa numsEsims y luego se llama a Create9999s para las milesimas.
        if (milesimas > 0 && num == 1) {
            return numsEsims(num, denominator) + " " + Create9999s(num, milesimas);
        }
        // Si hay milesimas y el número es mayor que 1, hace lo mismo pero en plural.
        else if (milesimas > 0 && num > 1) {
            return numsEsims(num, denominator) + " " + Create9999s(num, milesimas);
        }
        // Si no hay milesimas, solo se llama a numsEsims.
        else {
            return numsEsims(num, denominator);
        }
    }

    public static String numUntill99(int num) {
        if (num <= 19) {
            return numUntill20(num);  // Delegar a un método especializado para números hasta 20
        }
        int decenes = num / 10;
        int unitats = num % 10;
        String separador = (unitats == 0) ? "" : (num < 30 ? "-i-" : "-");
        return numTens(decenes) + separador + numUnits(unitats);
    }

    public static String numUntill999(int num) {
        if (num <= 99) {
            return numUntill99(num);  // Delegar al método numUntill99 para manejar números hasta 99
        }
        int centenas = num / 100;
        int resto = num % 100;
        String separador = (resto == 0) ? "" : " ";
        return numHundreds(centenas) + separador + numUntill99(resto);  // Llamada recursiva para el resto
    }

    public static String numUntill9999(int num) {
        if (num <= 999) {
            return numUntill999(num);  // Delegar al método numUntill999 para manejar números hasta 999
        }
        int mils = num / 1000;
        int resto = num % 1000;
        String separador = (resto == 0) ? "" : " ";

        // Si el número tiene miles y el resto es cero, no se necesita un separador adicional.
        return numUntill999(mils) + " mil" + separador + numUntill999(resto);
    }

    public static String numUntillM(int num) {
        if (num <= 999999) {
            return numUntill9999(num);  // Delegar al método numUntill9999 para manejar hasta 999,999
        }
        int millones = num / 1_000_000;
        int miles = num % 1_000_000;
        String separador = miles == 0 ? "" : " ";

        String millonesStr = numUntill999(millones) + " milio";
        String milesStr = numUntill9999(miles);

        return millonesStr + separador + milesStr;  // Combina millones y miles
    }

    public static int partFranctional(int num, int denominator) {
        return num % denominator;  // Esto retorna el residuo de la división
    }

}
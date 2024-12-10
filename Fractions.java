public class Fractions {

    public static String toWords(String s) {
        String[] parts = s.split("/");
        int num = Integer.parseInt(parts[0]);
        int denom = Integer.parseInt(parts[1]);
        String res;
        if (num >= denom) {
            int resto = num / denom;
            int fract = parteFraccional(num, denom);
            if (fract == 0) {
                return numTillM(resto);
            }
            res = numTillM(resto) + ", " + toWords(fract + "/" + denom).toLowerCase();
        } else {
            if (num < 1) {
                res = "zero";
            } else if (num == 1 && denom <= 19) {
                res = numTill999(num) + " " + denomTill20(denom);
            } else if (denom <= 19) {
                res = numTill999(num) + " " + denomPluralTill20(denom);
            } else if (denom <= 99) {
                res = numTill999(num) + " " + crear99s(num, denom);
            } else if (denom <= 999) {
                res = numTill999(num) + " " + crear999s(num, denom);
            } else if (denom <= 999_999) {
                res = numTill9999(num) + " " + crear9999s(num, denom);
            } else if (denom <= 999_999_999) {
                res = numTillM(num) + " " + crearMs(num, denom);
            } else {
                res = "No vàlid";
            }
        }
        return res.substring(0, 1).toUpperCase() + res.substring(1).toLowerCase();
    }
    public static String denomTill20(int denom) {
        switch (denom) {
            case 2:
                return "mig";
            case 3:
                return "terç";
            case 4:
                return "quart";
            case 5:
                return "cinquè";
            case 6:
                return "sisè";
            case 7:
                return "setè";
            case 8:
                return "vuitè";
            case 9:
                return "novè";
            case 10:
                return "dècim";
            case 11:
                return "onzè";
            case 12:
                return "dotzè";
            case 13:
                return "tretzè";
            case 14:
                return "catorzè";
            case 15:
                return "quinzè";
            case 16:
                return "setzè";
            case 17:
                return "dissetè";
            case 18:
                return "devuitè";
            case 19:
                return "dinouè";
        }
        return "";
    }
    public static String denomPluralTill20(int denom) {
        switch (denom) {
            case 2:
                return "mitjos";
            case 3:
                return "terços";
            case 4:
                return "quarts";
            case 5:
                return "cinquens";
            case 6:
                return "sisens";
            case 7:
                return "setens";
            case 8:
                return "vuitens";
            case 9:
                return "novens";
            case 10:
                return "dècims";
            case 11:
                return "onzens";
            case 12:
                return "dotzens";
            case 13:
                return "tretzens";
            case 14:
                return "catorzens";
            case 15:
                return "quinzens";
            case 16:
                return "setzens";
            case 17:
                return "dissetens";
            case 18:
                return "devuitens";
            case 19:
                return "dinouens";
        }
        return "";
    }
    public static String numTill20(int num) {
        switch (num) {
            case 1:
                return "Un";
            case 2:
                return "Dos";
            case 3:
                return "Tres";
            case 4:
                return "Quatre";
            case 5:
                return "Cinc";
            case 6:
                return "Sis";
            case 7:
                return "Set";
            case 8:
                return "Vuit";
            case 9:
                return "Nou";
            case 10:
                return "Deu";
            case 11:
                return "Onze";
            case 12:
                return "Dotze";
            case 13:
                return "Tretze";
            case 14:
                return "Catorze";
            case 15:
                return "Quinze";
            case 16:
                return "Setze";
            case 17:
                return "Disset";
            case 18:
                return "Devuit";
            case 19:
                return "Dinou";
        }
        return "";
    }
    public static String numDecenes(int num) {
        switch (num) {
            case 2:
                return "Vint";
            case 3:
                return "Trenta";
            case 4:
                return "Quaranta";
            case 5:
                return "Cinquanta";
            case 6:
                return "Seixanta";
            case 7:
                return "Setanta";
            case 8:
                return "Vuitanta";
            case 9:
                return "Noranta";
            case 1:
                return "Cent";
        }
        return "";
    }
    public static String denomDecenes(int denom) {
        switch (denom) {
            case 2:
                return "vintè";
            case 3:
                return "trentè";
            case 4:
                return "quarantè";
            case 5:
                return "cinquantè";
            case 6:
                return "seixantè";
            case 7:
                return "setantè";
            case 8:
                return "vuitantè";
            case 9:
                return "norantè";
            case 1:
                return "dècims";
        }
        return "";
    }

    //String de denominadores (decenes) plural
    public static String denomDecenesPlural(int denom) {
        switch (denom) {
            case 2:
                return "vint";
            case 3:
                return "trenta";
            case 4:
                return "quaranta";
            case 5:
                return "cinquanta";
            case 6:
                return "seixanta";
            case 7:
                return "setanta";
            case 8:
                return "vuitanta";
            case 9:
                return "noranta";
            case 1:
                return "cent";
        }
        return "";
    }
    public static String residuoDecenesSingular(int residuo) {
        switch (residuo) {
            case 1:
                return "unè";
            case 2:
                return "dosè";
            case 3:
                return "tresè";
            case 4:
                return "quatrè";
            case 5:
                return "cinquè";
            case 6:
                return "sisè";
            case 7:
                return "setè";
            case 8:
                return "vuitè";
            case 9:
                return "novè";
        }
        return "";
    }
    public static String residuoDecenesPlural(int residuo) {
        switch (residuo) {
            case 1:
                return "unens";
            case 2:
                return "dosens";
            case 3:
                return "tresens";
            case 4:
                return "quatrens";
            case 5:
                return "cinquens";
            case 6:
                return "sisens";
            case 7:
                return "setens";
            case 8:
                return "vuitens";
            case 9:
                return "novens";
        }
        return "";
    }
    public static String numUnitats(int num) {
        switch (num) {
            case 1:
                return "u";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "quatre";
            case 5:
                return "cinc";
            case 6:
                return "sis";
            case 7:
                return "set";
            case 8:
                return "vuit";
            case 9:
                return "nou";
        }
        return "";
    }
    public static String numCentenas(int num) {
        if (num == 1) {
            return "Cent";
        }
        return numUnitats(num) + "-cents";
    }
    public static String numMilesimas(int num) {
        if (num == 1) {
            return "Mil";
        }
        return numUnitats(num) + "mil";
    }
    public static String numMilionesimas(int num) {
        if (num == 1) {
            return "Milió";
        }
        return numUnitats(num) + "milio";
    }
    public static String numsEsims(int num, int denom) {
        if (num == 0) return "";
        if (denom <= 999) { // cienes
            if (num == 1 && denom % 10 == 0 && denom % 100 == 0) return numCentenas(num).toLowerCase() + "èsim";
            return numCentenas(num).toLowerCase();
        } else if (denom <= 9999) { // miles
            int milesimas = denom / 1_000;
            if (milesimas == 1 && denom % 10 == 0 && denom % 100 == 0 && denom % 1000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numMilesimas(milesimas).toLowerCase() + sufijo;
            }
            return numMilesimas(milesimas).toLowerCase();
        } else if (denom <= 99999) { // diezmiles
            int milesimas10 = denom / 10_000;
            int milesimas = (denom % 10_000) / 1_000;
            int mil = (milesimas10 * 10) + milesimas;
            if (milesimas10 == 1 && denom % 10 == 0 && denom % 100 == 0 && denom % 1_000 == 0 && denom % 10_000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numTill99(mil) + " mil" + sufijo;
            }
            return numTill99(mil) + " mil";
        } else if (denom <= 999999) { // cienmiles
            int milesimas100 = denom / 100_000;
            int milesimas10 = (denom % 100_000) / 10_000;
            int milesimas = (denom % 10_000) / 1_000;
            int mil100 = (milesimas100 * 100) + (milesimas10 * 10) + milesimas;
            if (milesimas100 == 1 && denom % 10 == 0 && denom % 100 == 0 && denom % 1_000 == 0 && denom % 10_000 == 0 && denom % 100_000 == 0) {
                String sufijo = "·lèsim";
                if (num > 1) sufijo += "s";
                return numTill999(mil100) + " mil" + sufijo;
            }
            return numTill999(mil100) + " mil";
        } else if (denom <= 9999999) { // millones
            int milionesimas = denom / 1_000_000;
            int milesimas100 = (denom % 1_000_000) / 100_000;
            int milesimas10 = (denom % 100_000) / 10_000;
            int milesimas = (denom % 10_000) / 1_000;
            if (milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denom % 10 == 0 && denom % 100 == 0 && denom % 1_000 == 0 && denom % 10_000 == 0 && denom % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                if (milionesimas == 1) return "milion" + sufijo;
                return numTill999(milionesimas) + " milion" + sufijo;
            }
            if (milionesimas == 1) return "milió";
            return numTill999(milionesimas) + " milions";
        } else if (denom <= 99999999) { //diez millones
            int milionesimas10 = denom / 10_000_000;
            int milionesimas = (denom % 10_000_000) / 1_000_000;
            int milesimas100 = (denom % 1_000_000) / 100_000;
            int milesimas10 = (denom % 100_000) / 10_000;
            int milesimas = (denom % 10_000) / 1_000;
            int mil100 = (milionesimas10 * 10) + milionesimas;
            if (milionesimas == 0 && milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denom % 10 == 0 && denom % 100 == 0 && denom % 1_000 == 0 && denom % 10_000 == 0 && denom % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                return numTill999(mil100) + " milion" + sufijo;
            }
            return numTill999(mil100) + " milions";
        } else if (denom <= 999999999) { //cien millones
            int milionesimas100 = denom / 100_000_000;
            int milionesimas10 = (denom % 100_000_000) / 10_000_000;
            int milionesimas = (denom % 10_000_000) / 1_000_000;
            int milesimas100 = (denom % 1_000_000) / 100_000;
            int milesimas10 = (denom % 100_000) / 10_000;
            int milesimas = (denom % 10_000) / 1_000;
            int mil100 = (milionesimas100 * 100) + (milionesimas10 * 10) + milionesimas;
            if (milionesimas10 == 0 && milionesimas == 0 && milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && denom % 10 == 0 && denom % 100 == 0 && denom % 1_000 == 0 && denom % 10_000 == 0 && denom % 100_000 == 0) {
                String sufijo = "èsim";
                if (num > 1) sufijo += "s";
                return numTill999(mil100) + " milion" + sufijo;
            }
            String sufijo = " milions";
            if (milionesimas == 1 && milionesimas10 == 0) sufijo = " milió";
            return numTill999(mil100) + sufijo;
        }
        return "";
    }
    public static String crear99s(int num, int denom) {
        String separador = "-";
        if (denom < 30) {
            separador += "i-";
        }
        int decenes = denom / 10;
        int unitats = denom % 10;
        if (decenes == 0 || unitats == 0) {
            separador = "";
        }
        if (unitats > 0 && num == 1) {
            return denomDecenesPlural(decenes) + separador + residuoDecenesSingular(unitats);
        } else if (unitats > 0 && num > 1) {
            return denomDecenesPlural(decenes) + separador + residuoDecenesPlural(unitats);
        } else {
            return denomDecenes(decenes);
        }
    }
    public static String crear999s(int num, int denom) {
        if (denom <= 99) return crear99s(num, denom);
        int centenes = denom / 100;
        int decenes = denom % 100;
        String separador = " ";

        if (centenes == 0) {
            separador = "";
        }
        if (decenes > 0 && num == 1) {
            return numsEsims(centenes, denom) + separador + crear99s(num, decenes);
        } else if (decenes > 0 && num > 1) {
            return numsEsims(centenes, denom) + separador + crear99s(num, decenes);
        } else {
            return numsEsims(centenes, denom);
        }
    }

    public static String crear9999s(int num, int denom) {
        if (denom <= 999) return crear999s(num, denom);
        int centenes = denom % 1_000;

        if (centenes > 0 && num == 1) {
            return numsEsims(num, denom) + " " + crear999s(num, centenes);
        } else if (centenes > 0 && num > 1) {
            return numsEsims(num, denom) + " " + crear999s(num, centenes);
        } else {
            return numsEsims(num, denom);
        }
    }

    public static String crearMs(int num, int denom) {
        int milesimas = denom % 1_000_000;

        if (milesimas > 0 && num == 1) {
            return numsEsims(num, denom) + " " + crear9999s(num, milesimas);
        } else if (milesimas > 0 && num > 1) {
            return numsEsims(num, denom) + " " + crear9999s(num, milesimas);
        } else {
            return numsEsims(num, denom);
        }
    }
    public static String numTill99(int num) {
        if (num <= 19) {
            return numTill20(num);
        }
        String separador = "-";
        if (num < 30) {
            separador += "i-";
        }
        int decenes = num / 10;
        int unitats = num % 10;
        if (unitats == 0) {
            separador = "";
        }
        return numDecenes(decenes) + separador + numUnitats(unitats);
    }
    public static String numTill999(int num) {
        if (num <= 99) {
            return numTill99(num);
        }
        String separador = " ";
        int centenas = num / 100;
        int decenas = num % 100;
        int unitats = num % 10;

        if (decenas <= 9 && unitats == 0) { // El residuo del num sea menor o igual a nueve
            separador = "";                    // y las unidades tmb son 0, no hya separador.
        }                                      // (decenas y unidades)
        return numCentenas(centenas) + separador + numTill99(decenas);
    }
    public static String numTill9999(int num) {
        if (num <= 999) {
            return numTill999(num);
        }
        String separador = " ";
        int milesimas100 = num / 100_000;
        int milesimas10 = (num % 100_000) / 10_000;
        int milesimas = (num % 10_000) / 1_000;
        int centenas = num % 1000;
        int decenas = num % 100;
        int unitats = num % 10;
        int mil100 = (milesimas100 * 100) + (milesimas10 * 10) + milesimas;
        String milcien = numTill999(mil100);
        if (centenas <= 99 && decenas <= 9 && unitats == 0) {
            separador = "";
        }
        return milcien + " mil" + separador + numTill999(num % 1000);
    }
    public static String numTillM(int num) {
        if (num <= 999999) {
            return numTill9999(num);
        }
        String separador = " ";
        int millones100 = num / 100_000_000;
        int millones10 = (num % 100_000_000) / 10_000_000;
        int millones = (num % 10_000_000) / 1_000_000;
        int milesimas100 = (num % 1_000_000) / 100_000;
        int milesimas10 = (num % 100_000) / 10_000;
        int milesimas = (num % 10_000) / 1_000;
        int centenas = num % 1000;
        int decenas = num % 100;
        int unitats = num % 10;
        int M100 = (millones100 * 100) + (millones10 * 10) + millones;
        int milcien = num % 1_000_000;
        if (milesimas100 == 0 && milesimas10 == 0 && milesimas == 0 && centenas <= 99 && decenas <= 9 && unitats == 0) {
            separador = "";
        }
        String mcien = numTill999(M100);
        return mcien + " miliò" + separador + numTill9999(milcien);
    }
    public static int parteFraccional(int num, int denom) {
        while (num >= denom) {
            num -= denom;
        }
        return num;
    }
}
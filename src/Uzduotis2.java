/*
`Užduotis 2:`
1. Susikurkite `Java` projektą, susikurkite `Programa.java` failą (class), tame faile susikurkite `main` funkciją.
2. Susikurti papildomą funkciją, kuri gauna du skaičius `x` ir `y`. Jeigu `x` yra lyginis skaičius, tai tada `funkcija` grąžina `x * y`. Jeigu `x` yra nelyginis skaičius, tai tada jeigu `y` yra didesnis už 100, funkcija grąžina `y - x`; jeigu `y < 100` tai grąžina `x - y`. Jeigu `y = 100`, tai grąžina `0`.
 */
public class Uzduotis2 {
    public static void main(String[] args) {
        System.out.println("skaiciavimas(15, 95) = " + skaiciavimas(15, 95));
        System.out.println("skaiciavimas(16, 95) = " + skaiciavimas(16, 95));
        System.out.println("skaiciavimas(15, 105) = " + skaiciavimas(15, 105));
        System.out.println("skaiciavimas(15, 100) = " + skaiciavimas(15, 100));
    }


    /**
     * Jeigu `x` yra lyginis skaičius, tai tada `funkcija` grąžina `x * y`. Jeigu `x` yra nelyginis skaičius, tai tada jeigu `y` yra didesnis už 100, funkcija grąžina `y - x`; jeigu `y < 100` tai grąžina `x - y`. Jeigu `y = 100`, tai grąžina `0`.
     * @param x pirmas skaičius
     * @param y antras skaičius
     * @return rezultatą apskaičiuotą pagal sąlygą
     */
    public static int skaiciavimas(int x, int y) {
        if (arLyginis(x)) {
            return x * y;
        }
        else if (y > 100) {
            return  y - x;
        }
        else if (y < 100) {
            return x - y;
        }
        else {
            return 0;
        }
    }


    /**
     * Funkcija patikrina ar skaičius yra lyginis.
     * @param x tikrinamas skaičius
     * @return true, jeigu lyginis, false jeigu ne.
     */
    public static boolean arLyginis(int x) {
        return x % 2 == 0;
    }
}

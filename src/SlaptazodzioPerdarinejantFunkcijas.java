import java.util.Scanner;

/*
1. Susikurkite Java projektą - tai bus registracijos dvigubas patikrinimas, susikurkite Programa.java failą (class), tame faile susikurkite main funkciją.
2. Susikurti programą, kuri iš konsolės nuskaito keturis tekstinius kintamuosius: login, email, password ir pakartotasPassword
3. Sukurkite papildomą funkciją, kuri patikrina ar registracijos duomenys yra visi teisingai suvesti. T.y.:
a) ar login nesutampa su password
b) ar email turi @ ir . simbolius
c) ar password sutampa su pakartotasPassword
d) ar password turi daugiau nei 10 raidžių
e) ar password yra bent viena mažoji raidė
f) ar password yra bent viena didžioji raidė
e) ar password yra bent vienas skaičius

b ir e punktams perkursiu funkcijas nuo nulio (nenaudosiu jau kai kurių esančių Java funkcijų, išradinėsiu dviratį)
 */
public class SlaptazodzioPerdarinejantFunkcijas {
    public static void main(String[] args) {
        Scanner skaitytuvas = new Scanner(System.in);
        String login = regNuskaitymas(skaitytuvas, "login");
        String email = regNuskaitymas(skaitytuvas, "email");
        String password = regNuskaitymas(skaitytuvas, "password");
        String pakartotinassPassword = regNuskaitymas(skaitytuvas, "dar kartą savo password");

        System.out.println("arLoginNesutampaSuPassword(login, password) = " + arLoginNesutampaSuPassword(login, password));
        System.out.println("arEmailoFormatasTeisingas(email) = " + arEmailoFormatasTeisingas(email));
        System.out.println("arSutampaSlaptazodziai(password, pakartotinassPassword) = " + arSutampaSlaptazodziai(password, pakartotinassPassword));
        System.out.println("arSlaptazodisIlgesnis(password) = " + arSlaptazodisIlgesnis(password));
        System.out.println("arSlaptazodyjeYraMazojiRaide(password) = " + arSlaptazodyjeYraMazojiRaide(password));
        System.out.println("arSlaptazodyjeYraDidziojiRaide(password) = " + arSlaptazodyjeYraDidziojiRaide(password));
        System.out.println("arPasswordeYraBentVienasSkaicius(password) = " + arPasswordeYraBentVienasSkaicius(password));

    }

    /**
     * Funkcija nuskaito kažkurį vieną iš registracijos duomenų. Tai nėra ideali funkcija, kadangi dažniausiai tai nuskaitytų funkcija visus iš karto ir juos grąžintų per objektą.
     * Kadangi šios užduoties metu mes dar nesimokinome Klasių/Objektų, todėl tai reikėjo kažkaip apeiti kitaip.
     * @param skaitytuvas scannerio objektas, kuris skaito iš konsolės
     * @param kurisDalykas registracijos duomenų pavadinimas, pvz.: "email", "password", "pakartotinas password"
     * @return ką įvedė klientas į konsolę
     */
    public static String regNuskaitymas(Scanner skaitytuvas, String kurisDalykas) {
        System.out.println("Įveskite savo " + kurisDalykas + ":" );
        return skaitytuvas.nextLine();
    }


    /**
     * Funkcija patikrina ar login nesutampa su password.
     * Sakiau, jog nenaudosiu Java sukurtų funkcijų, tačiau čia nėra kažkokia speciali funkcija, tiesiog paprasčiausias == operatorius,
     * tačiau javoje tekstams negalima daryti == operatoriaus, todėl esu priverstas naudoti equals() funkciją (kuri yra tiesiog == pakaitalas)
     * @param login loginas
     * @param password password
     * @return true, jeigu nesutampa, false jeigu sutampa.
     */
    public static boolean arLoginNesutampaSuPassword(String login, String password) {
        return !login.equals(password);
    }

    /**
     * Funkcija patikrina ar gautume žodyje yra '@' ženklas ir '.' ženklas. Kadangi lyginama `char` o ne `String` reikšmės, tai galima naudoti == operatorių
     * @param email tikrinamas žodis
     * @return true, jeigu yra taškas ir emailas, false jeigu jų nėra.
     */
    public static boolean arEmailoFormatasTeisingas(String email) {
        boolean arYraEta = false;
        boolean arYraTaskas = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                arYraEta = true;
            }
            if (email.charAt(i) == '.') {
                arYraTaskas = true;
            }
        }
        return arYraEta && arYraTaskas;
    }

    /**
     * Funkcija patikrina ar sutampa slaptažodžiai
     * @param password slaptažodis
     * @param pakartotasPassword pakartotas slaptažodis
     * @return true, jeigu sutampa, false jeigu ne
     */
    public static boolean arSutampaSlaptazodziai(String password, String pakartotasPassword) {
        return password.equals(pakartotasPassword);
    }

    /**
     * Funkcija patikrina ar slaptažodis yra ilgesnis už 10
     * @param password slaptažodis
     * @return true, jeigu ilgesnis, false jeigu ne
     */
    public static boolean arSlaptazodisIlgesnis(String password) {
        return password.length() > 10;
    }

    /**
     * Funkcija patikrina ar slaptažodyje yra bent viena mažoji raidė
     * @param password slaptažodis
     * @return true, jeigu yra, false jeigu nėra.
     */
    public static boolean arSlaptazodyjeYraMazojiRaide(String password) {
        return !password.toUpperCase().equals(password);
    }

    /**
     * Funkcija patikrina ar slaptažodyje yra bent viena didžioji raidė
     * @param password slaptažodis
     * @return true jeigu yra didžioji, false jeigu nėra
     */
    public static boolean arSlaptazodyjeYraDidziojiRaide(String password) {
        return !password.toLowerCase().equals(password);
    }

    /**
     * Funkcija patikrina ar slaptažodyje yra skaičius. Susikuriu "skaičių" masyvą, kurie iš tikro yra char skaičiai.
     * Tada einu per kiekvieną slaptažodžio simbolį ir ties kiekvienu simboliu einu per visą skaičių masyvą (Dėl to ciklas cikle) ir tikrinu kiekvieną slaptažodžio simbolį su kiekvienu skaičiauss simboliu
     * Jei randu bent vieną atitinkantį - išsyk grąžinu true
     * Jeigu pereina per visus slaptažodžio simbolius ir niekada negrąžina true - reiškias nebuvo skaičiu ir galiausiai grąžinu false
     * @param password slaptažodis
     * @return true jeigu yra skaičius, false jeigu nėra.
     */
    public static boolean arPasswordeYraBentVienasSkaicius(String password) {
        char[] skaiciai = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < skaiciai.length; j++) {
                if (password.charAt(i) == skaiciai[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

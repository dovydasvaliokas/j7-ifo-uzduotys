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
public class SlaptazodzioNaudojantJavosContains {
    public static void main(String[] args) {
        Scanner skaitytuvas = new Scanner(System.in);
        String login = regNuskaitymas(skaitytuvas, "login");
        String email = regNuskaitymas(skaitytuvas, "email");
        String password = regNuskaitymas(skaitytuvas, "password");
        String pakartotinassPassword = regNuskaitymas(skaitytuvas, "dar kartą savo password");

        System.out.println("arLoginNesutampaSuPassword(login, password) = " + arLoginNesutampaSuPassword(login, password));
        System.out.println("arTeisingasEmailoFormatas(email) = " + arTeisingasEmailoFormatas(email));
        System.out.println("arSutampaSlaptazodziai(password, pakartotinassPassword) = " + arSutampaSlaptazodziai(password, pakartotinassPassword));
        System.out.println("arSlaptazodisIlgesnis(password) = " + arSlaptazodisIlgesnis(password));
        System.out.println("arSlaptazodyjeYraMazojiRaide(password) = " + arSlaptazodyjeYraMazojiRaide(password));
        System.out.println("arSlaptazodyjeYraDidziojiRaide(password) = " + arSlaptazodyjeYraDidziojiRaide(password));
        System.out.println("arYraSkaiciusPsw(password) = " + arYraSkaiciusPsw(password));
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
     * Patikrina ar emailo formatas yra teisingas (turi eta ir tašką)
     * @param email emailass
     * @return true, jeigu yra eta ir taškas, falsse jeigu nėra
     */
    public static boolean arTeisingasEmailoFormatas(String email) {
        return email.contains("@") && email.contains(".");
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
     * Funkcija patikrina ar yra skaičius slaptažodyje
     * @param password slaptažodis
     * @return true jeigu yra, false jeigu ne
     */
    public static boolean arYraSkaiciusPsw(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}

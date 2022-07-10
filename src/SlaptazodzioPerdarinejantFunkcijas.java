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

kiekvienam a-e punktui perkursiu funkcijas nuo nulio (nenaudosiu jau kai kurių esančių Java funkcijų, išradinėsiu dviratį)
 */
public class SlaptazodzioPerdarinejantFunkcijas {
    public static void main(String[] args) {
        Scanner skaitytuvas = new Scanner(System.in);
        String login = regNuskaitymas(skaitytuvas, "login");
        String email = regNuskaitymas(skaitytuvas, "email");
        String password = regNuskaitymas(skaitytuvas, "password");
        String pakartotinassPassword = regNuskaitymas(skaitytuvas, "dar kartą savo password");

        System.out.println(login + email + password + pakartotinassPassword);

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

}

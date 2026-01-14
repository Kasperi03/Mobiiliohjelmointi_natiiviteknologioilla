Viikkotehtävä 1 – Kotlin-perusteet ja ensimmäinen Compose-näkymä
Kuvaus

Tämän tehtävän tavoitteena oli opetella Kotlinin perusteita sekä luoda ensimmäinen Android-sovellus Jetpack Composea käyttäen. Sovellus on yksinkertainen tehtävälista, jossa käyttäjä voi tarkastella tehtäviä, merkitä niitä tehdyiksi sekä suodattaa ja järjestää listaa eri tavoin.

Projektissa keskitytään erityisesti domain-logiikan ja käyttöliittymän erotteluun sekä Kotlin-funktioiden käyttöön.

Tehtävän vaatimukset

Tehtävässä vaadittiin seuraavat asiat:

Android Studio -projekti (Compose-template)

domain/-paketti, joka sisältää:

Task data class (id, title, dueDate, done)

5–10 kappaletta mock-dataa listana

Kotlin-funktiot tehtävälistan käsittelyyn:

-addTask

-toggleDone

-filterByDone

-sortByDueDate

Ensimmäinen Compose-näkymä HomeScreen, joka:

näyttää otsikon ja tehtävälistan

käyttää Column-, Row- ja Modifier-rakenteita

Datamalli (Task)

Sovelluksessa käytetään Task-data classia, joka kuvaa yksittäistä tehtävää.
Task sisältää muun muassa seuraavat tiedot:
-id
-title
-dueDate
-done

Task-luokkaa käytetään sovelluksen kaikessa logiikassa ja UI:ssa tehtävien esittämiseen ja muokkaamiseen.

Kotlin-funktiot

Domain-pakettiin on toteutettu useita Kotlin-funktioita tehtävälistan käsittelyä varten:

addTask()
Lisää uuden tehtävän tehtävälistaan annettujen tietojen perusteella.

toggleDone()
Vaihtaa tehtävän tilan false → true jolloin tehtävä voidaan merkitä tehdyksi.

filterByDone()
Suodattaa tehtävälistan ja palauttaa vain tehtävät, jotka ovat tehtyjä,

sortByDueDate()
Järjestää tehtävät eräpäivän mukaan. (Tämä toiminnallisuus ei ole täysin toiminnallinen.)

Käyttöliittymä (HomeScreen)

Sovelluksen käyttöliittymä on toteutettu Jetpack Composella HomeScreen-näkymässä.

HomeScreen:
-näyttää otsikon ja tehtävälistan
-käyttää Column, Row, LazyColumn, Text ja Button -komponentteja
-sisältää nappeja, joilla kutsutaan domain-paketin Kotlin-funktioita
-vastaa UI:n päivittämisestä, kun tehtäviä lisätään tai niiden tila muuttuu

MainActivity:
MainActivity vastaa sovelluksen käynnistämisestä.
Se sisältää vain HomeScreen-Composable-funktion kutsun, joka renderöi koko sovelluksen käyttöliittymän.

Sovelluksen ajaminen

Sovelluksen ajamiseen tarvitaan:
-Android Studio
-Android-emulaattori tai fyysinen Android-laite
-Projekti avataan Android Studiossa ja ajetaan joko emulaattorilla tai liitetyllä fyysisellä laitteella debug-tilassa.

Tekijä: Kasperi Mustonen

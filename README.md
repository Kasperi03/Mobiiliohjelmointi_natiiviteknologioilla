**Viikkotehtävä 2 – Kotlin + Compose: Tehtävälista ViewModelilla**

**Kuvaus**
Week2-projekti laajentaa Week1-tehtävää. Sovellus on tehtävälista, jossa voi:
- lisätä, poistaa ja merkitä tehtäviä tehdyiksi
- suodattaa ja järjestää tehtäviä
- UI päivittyy automaattisesti ViewModelin tilamuutosten perusteella

**Toteutus**
- **TaskViewModel**: sisältää MutableState<List<Task>>, mock-datan initissa, funktiot addTask, toggleDone, removeTask, filterByDone, sortByDueDate
- **HomeScreen**: näyttää tehtävälistan LazyColumnilla, sisältää Checkboxin done-tilan hallintaan, poista-painikkeen ja uuden tehtävän lisäyksen
- **MainActivity**: käynnistää sovelluksen, kutsuu HomeScreeniä
- **Task data class**: id, title, description, priority, dueDay, done

**Tilanhallinta**
- Sovellus käyttää **ViewModelia**, jotta UI päivittyy automaattisesti ja muistuttaa tilaa oikein eri Composable-kutsujen välillä

**Sovelluksen ajaminen**
- Android Studio + emulaattori tai fyysinen laite
- Debug-tilassa ajettaessa kaikki toiminnot näkyvät

**Release / APK**
- APK löytyy GitHub Release -kohdasta

**Tekijä:** Kasperi Mustonen


**Viikkotehtävä 3 – Kotlin + Compose: Tehtävälista MVVM + StateFlow**

**Kuvaus**
Week3-projekti laajentaa Week2-tehtävää. Sovellus on tehtävälista, jossa voi:

lisätä, poistaa ja merkitä tehtäviä tehdyiksi

suodattaa tehtäviä “done” / “not done”

järjestää tehtäviä eräpäivän mukaan

avata dialogin, jossa voi muokata tehtävän tietoja

palauttaa kaikki tehtävät "Show All" -napilla

UI päivittyy automaattisesti ViewModelin tilamuutosten perusteella (StateFlow).

**Toteutus**
TaskViewModel:

hallitsee tehtävälistaa MutableStateFlow<List<Task>>

master-lista allTasks säilyttää kaikki tehtävät filttereistä huolimatta

funktiot: addTask, toggleDone, removeTask, updateTask, filterByDone, sortByDueDate, clearTask, showAll

HomeScreen:

näyttää tehtävälistan LazyColumnilla

sisältää checkboxin done-tilan hallintaan, poista-painikkeen ja uuden tehtävän lisäyksen

suodatusnapit ja showAll-nappi

DetailDialog:

avautuu valitun tehtävän muokkaamista varten

sisältää “Update” ja “Close” -napit

Task data class:

id, title, description, priority, dueDay, done

Tilanhallinta (StateFlow)

tasks: StateFlow<List<Task>> ja selectedTask: StateFlow<Task?> hallitsevat sovelluksen tilaa

UI kuuntelee tilaa collectAsState()-kutsulla

Tilamuutokset päivittyvät heti näkyviin dialogiin ja listaan

**Sovelluksen ajaminen**
Android Studio + emulaattori tai fyysinen laite

Debug-tilassa kaikki toiminnot näkyvät

Release / APK: GitHub Release -kohdasta

**Tekijä:** Kasperi Mustonen


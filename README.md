**Viikkotehtävä 3 – Kotlin + Compose: Tehtävälista MVVM + StateFlow**

**MVVM (Model-View-ViewModel)**

**MVVM on arkkitehtuurimalli, jossa sovelluksen eri osat erotetaan selkeästi:**

Model sisältää datan (Task)

ViewModel hallitsee sovelluksen tilaa ja logiikkaa

View (Compose UI) näyttää tiedon ja kuuntelee ViewModelin tilaa

**Hyöty Compose-sovelluksissa:**

UI pysyy yksinkertaisena, koska se ei hallitse logiikkaa

Tilamuutokset päivittyvät automaattisesti, jolloin Compose recomposoi tarvittavat komponentit

Koodin ylläpito ja testaus helpottuvat

**StateFlow**

**StateFlow on Kotlin Coroutines -kirjaston tila- ja tapahtumavirta:**

MutableStateFlow: muokattava tila ViewModelissa

StateFlow: UI kuuntelee vain lukuoikeudella

Kun value muuttuu, kaikki kuuntelijat saavat uuden tilan heti

**Hyöty sovelluksessa:**

UI päivittyy automaattisesti, kun tilaa muutetaan ViewModelissa

Ei tarvita imperatiivista päivityskoodia

Sovellus pysyy reaktiivisena ja MVVM-logiikka selkeänä

**Tekijä:** Kasperi Mustonen


## Domain Driven Design
### Einführung
#### Was ist Design ?
- SW beschreibt Ausschnitt aus Realität (Anwendungs-/Problemdomäne)
- Design beschreibt wie ein Modell die realen Gegebenheiten der Problem-Domäne abstrahiert
- Abbildung von Realität auf Modell
- Summe aller Entscheidungen, die Einfluss haben, wie ein Problem als SW-Lösung modelliert wird

#### Warum braucht man Design?
- SW-Entwicklung ist komplex
- Neben Problemdomäne viele Nebeneinflüsse
- Auswirkungen von Komplexität begrenzbar, kontrollierbar, nicht unnötig verkomplizieren
- Design mach Komplexität beherrschbar

#### Software-Komplexität
- Grad zu welchem das Design / eine Implementierung schwer zu verstehen ist
- Komplexität der Problemdomäne ist gegeben (essential complexity)
  - Anforderungen
- Unfallkomplexität (accidential comp.): notwendiges Übel, möglichst
verhindern
  - Legacy-Systeme, UI, Framework, Persistenz, …
- Mit Lebensdauer von SW wird mehr Code gelesen als geschrieben

#### Big Ball of Mud

- Code, der etwas nützliches macht, aber ohne Erklärung

- Kein erkennbares Design

-> Code schwer wartbar, erweiterbar

### Domain Driven Design

Herangehensweise an die Modellierung von SW, die sich auf Problemdomäne
konzentriert

#### Grundsätze
- Designentscheidungen von Fachlichkeit/Fachlogik der Prob-Domäne
  getrieben, nicht von technischen Details
- Entwicklung einer Domänensprache (Vokabular)
- Relevante, fachliche Zusammenhänge der Prob-Domäne in Domänenmodell erfassen

#### Strategie und Taktik

- Strategisch: Verständnis der Domäne, Analysieren, aufdecken,
  abgrenzen, dokumentieren und begreifen der Fachlichkeit
- Taktisch: Implementierung der Fachlichkeit in Code

#### Warum ist es wichtig, dass sich die Sprache der Domäne in der Software befindet?

Strategisches Domain Driven Design

##### Domäne

- Abgrenzbares Problemfeld oder best. Einsatzbereich für den Einsatz
  von SW

- Was soll mit SW gelöst werden?

-> Raumfahrt, Logistik, Fertigung,  …

##### Domänenmodell

- Abstraktion, die best. Teile der Domäne beschreibt

- Erlaubt das Lösen von Problemen innerhalb der Domäne

- Wie soll ein Problem mit SW gelöst werden?

<img src="./media/image12.jpeg" width="448" height="233" />

##### Ubiquitous Language

- Domänenmodell erfordert Verständnis
- Weg zum Verständnis der Domäne über Sprache
- Gemeinsame Sprache zw. Domänenexperten und Entwicklern „Ubiquitous
  Language“
- Technische Sprache der Entwickler --> Fachjargon der
  Domänenexperten, eignen sich nicht
- Kluft im Verständnis -> pflanzt sich in Code fort
- Ziel der UL: Kluft schließen mit gemeinsamer Sprache (Wichtige Konzepte, Zusammenhänge, Mehrdeutigkeiten / Unklarheiten beseitigen)

##### Wie kommt man zur UL?

- Kollaboration zw. Entwicklern / Domänenexperten

- Iterativer Prozess, mit zuhören und nachfragen, eigenes Wörterbuch
  nur ggf.

##### Aufteilung der Domäne

Betrachtete Problemdomäne möglichst klein, aufgrund von Komplexität
- Kerndomäne: Kerngeschäft
- Unterstützende Domäne: Unterstützt Kerngeschäft
- Generische Domäne: Nicht Kerngeschäft, z.B. Rechnungen versenden
  (-&gt; ggf. Dritt-SW)
- Kontext
- Kontextgrenzen: Wo werden Kontexte aufgebrochen? Und wo sind Zusammenhänge? Unabhängig.
<img src="./media/image13.jpeg" width="359" height="219" />

##### Taktisches Domain Driven Design

Unterstützt bei Entwurf von Modellen, die Komplexität beherrschbar
machen, durch Katalog von Entwurfsmustern

###### Übersicht

- Entities, Value Objects, Domain Services, Aggregates

  - Kern des Modells, Großteil der Geschäftslogik, Forcieren die in
    der Domäne geltenden Invarianten und machen diese sichtbar
- Repositories, Factories

  - Kapseln der Logik fürs Persistieren/Erzeugen von Entities, Value
  Objects und Aggregates, Freihalten von Acc.Komplexität

- Modules:

  - Strukturierung/Kapselung verwandter Domänenobj. Innerhalb des
  Modells, fördern geringe Koppelung & hohe Kohäsion

<img src="./media/image14.jpeg" width="387" height="210" />

###### Value Objects

- Objekte ohne eigene Identität
- Unveränderlich

  - Gültige Konstruktion -&gt; immer gültig (Invarianten einhalten)
  - Frei von Seiteneffekten

- Wird nur durch Werte beschrieben
- 2 VO sind gleich, wenn Werte gleich (equals, hashCode überschreiben)
- Oft Ganzheitliches Konzept

  - Gewicht: Zahl + Einheit
  - Geld: Betrag + Währung
  - Adresse: Straße + PLZ + Stadt
- Beschreiben, begrenzen oder messen Sache näher

###### Vorteile

- Kapseln Verhalten/Regeln
- Unveränderlich
- Selbst-validierend
- Leicht testbar
- Verbessern Deutlichkeit/Verständlichkeit durch Modellierung von
  fachlichen Domänenkonzepten

###### Implementierung
- Klasse: final
- Felder: blank final
- Nach Konstruktion gültig, ansonsten muss Konstruktion fehlschlagen
- Keine Setter
- Rückgabewerte sind unveränderlich oder defensive Kopien

###### Persistierung

- Eingebettet in Tabelle des Elternobjekts: JPA-Embeddable, jedes Feld
  eine Spalte
    - Vorteile: Einfach, erlaubt Queries über Elemente des VO
    - Nachteil: Ggf. Denormalisierung, nur 1:1-Beziehungen

- Serialisierung: Objekt in einer Spalte, Converter
  - Vorteile: Komplexe Bez. mög., 1:n-Bez. mög. (Listen, Sets)
  - Nachteil: unlesbar, Queries über VO nicht möglich, aufwändiger

- In eigener Tabelle (als DB-Entity): Entität auf DB-Ebene, mit ID, muss versteckt werden
  - Vorteil: einfach, Normalisierung mög., Queries über VO mög., 1:n-Bez. Mög.
  - Nachteil: Verschleiert Natur von VO durch ID, Gefahr, dass mehrere Entities gleich VO nutzen

### Entities

#### Unterschiede zu VO
  - Haben eindeutige ID
  - Verschieden, wenn unterschiedliche ID
  - Hat Lebenszyklus, verändert sich dabei

#### Allgemeine Regeln für Entities
  - Invarianten forcieren: Konstruktion nur mit gültigen Werten, kein
    Verändern in ungültigen Zustand
  - Möglichst viel Verhalten in VO auslagern
  - Die öffentlichen Methoden sollten Verhalten beschreiben
    (nicht Getter/Setter)
  - equals/hashCode: Definition von Gleichheit vom Anwendungsfall
    abhängig

#### Strategien für einzigartige Identitäten

#### Natürliche Schlüssel: Kursname, KFZ-Kennzeichen,
  Personalausweisnummer
  - Vorteil: aussagekräfig, keine Duplikate
  wenn global eindeutig
  - Nachteil: Fremdbestimmt (ändert sich vielleicht?), ggf. nicht global
  eindeutig

- Surrogatschlüssel: Selbst generiert

#### Universally Unique Identifier (UUID)
- Vorteil: jederzeit generierbar, anwendungsübergreifend eindeutig
- Nachteil: nicht sprechend, Performance

#### Inkrementeller Zähler
- Vorteil: eigenständig, unabhängige ID-Generierung, ID steht sofort fest
- Nachteil: Nicht sprechend, Zähler muss gespeichert werden

#### String-Format basierend auf Entity-Eigenschaften
- Vorteil: Sprechend, jederzeit generierbar
- Nachteil: hoher Aufwand, falls sich Werte ändern
#### Surrogatschlüssel vom Perstistence-Provider
- Vorteil: ID eindeutig, kein Aufwand
- Nachteil: nicht sprechend, muss erst durch ORM laufen, abhängig von ORM und DB

#### Wahl der Strategie
- Selbst verwaltet: Early ID Generation, reduziert Abhängigkeit, erleichtert Komm., wirklich eindeutig?, erleichtert Tests
- Fremdverwaltet: Late ID Generation, erschwert Tests, wenig Eigenverantwortung, funktionierender Standard-Weg

### Domain-Service

- Kleiner Helfer innerhalb des Domänenmodells

- Wenn ein best. Verhalten / Regel weder VO noch Entity zugeordnet werden kann

- Beispiele: Berechnung Zahlungsmoral des Kunden (Entities: Kunde, Rechnungen, Kontenbewegungen)

#### Vertrag

- Domäne kann auf ext. Unterstützung angewiesen sein
- Innerhalb Domäne: Domain Service als Vertrag (Interface)
- Außerhalb Domäne: Dienstleister (Infrastruktur-Schicht) kann Vertrag implementieren und benötige Funktionen bereitstellen

#### Eigenschaften

- Erfüllt Funktion, die nicht in Entity oder VO modelliert werden kann
- Operiert ausschließlich mit anderen Elementen des Modells
- Verkörpern Konzepte der UL
- Statuslos

#### Aggregate

- Entstehen von großen Objektgraphen mit bidirektionalen Abhängigkeiten
- Nachteil: Performance, Kollisionen, Verletzen von Invarianten
- Technische Lösung: Locking-Modi, Lazy/Eager Loading
- Domänen-Lösung: Aggregate
- Gruppen Entities und VO zu Einheiten
- Aggregat hat Root Entitiy (Aggregate Root): Über dieses erfolgt Zugriff auf Teile der Aggregate
- Reduzieren Komplexität beim Verwalten von Obj.
- Erleichtern Handhabung von TAs
- Reduzieren die Möglichkeit Invarianten zu verletzen
- Möglichkeiten:
  - Einschränkung der Assoziationsrichtung
  - Ersetzen von Objektreferenzen durch IDs

<img src="./media/image15.jpeg" width="538" height="135" />

#### Ersetzen von Objektreferenten durch IDs

- Entspricht der Abbildung in einer relationalen DB (Foreign Key)
- Nachteile
  - DB über OR-Mapper erzeugt?
  -> keine Fremdschlüssel mehr
  - Weitere Abfragen nötig, um bspw. aufs AddressBook eines Cusomerszuzugreifen
  - Mehr Verantwortung

- Vorteile
  - Schlankere Objektgrapgen
    - Zuständigkeiten klarer getrennt
    - Aggregate bilden bzgl. TAs eine Unit of Work
    - -> Mehr Kontrolle

#### Aggregate Root
- Alle Zugriffe auf innere Elemente nur über AR
- Referenzen von außen auf innere Elemente nicht erlaubt
- Daher: Zentrale Stelle zur Einhaltung von Invarianten (Bsp: Maximale Bestellpositonen)
- AR sollte nur defensive Kopien ausliefern

#### Transaktionsgrenzen, Repostitory
- Aggregates werden als Einheit verwaltet (create, read, …)
- Jede Entity gehört zu einem Aggregate
- Repository: Arbeiten mit Aggregates und kann dieses komplett innerhalb einer TA lesen / schreiben
- Aggregates bilden natürliche Transaktionsgrenzen

#### Zusammenfassung
- Entities und VO zu Aggregates zusammen
- Werden als Einheit betrachtet (create, read, update, …)
- Forcieren/Visualisieren Transaktionsgrenzen
- Forcieren Invarianten
- Persistenz-Frage muss getroffen werden (Nachteile)

### Repositories

- Vermitteln zw. Domäne und Datenmodell
- Stellen Domäne Methoden bereit: Lesen etc. von Aggregates aus Persistenzspeicher
- Konkreter Zugriff wird vom Repository verborgen
- Domäne von technischen Details unbeinflusst
- Eigenschaften:
  - Repositories arbeiten ausschließlich mit Aggregates (1:1-Bez)
  - Ähnelt Domain-Service (definiert Vertrag, der in technischer Schicht impl. wird)
  - Aussagekräftige Schnittstelle
  - Ggf. Erzeugung von IDs
  - Kann Prüffelder setzen (LastUpdatedAt)

  - Kann allg. Infos bieten: Zusammenfassung
- Implementierung in technischer Schicht, nicht in Domänenmodell

### Factories
- Ggf. Logik für Erzeugen komplex -&gt; Factory
- Erzeugen von Objekten
- Allgemein: Irgendein Objekt/Methode zur Erzeugung anderer Obj. als Kontruktorersatz
- Speziell:
  - Factory Method
  - Abstract Factory

### Modules

- Zur Strukturierung/Kapselung verwandter Komponenten
- Abbildung über Namespaces, Packages
- Gruppierung nach fachlichen, nicht technischen, Gesichtspunkten
- Ziel: Zusammengehörende Komponenten gruppieren (hohe Kohäsion, geringe Kopplung zw. Modulen)
- Vorteile: Sichtbarkeit, Abhängigkeiten

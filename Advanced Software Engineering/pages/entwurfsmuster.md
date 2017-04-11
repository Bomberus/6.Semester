## Entwurfsmuster
-   Muster beschreiben wiederkehrende Probleme

### Nutzung von Entwurfsmustern
-   Vermittlung von Wissen auf abstraktem Niveau
-   Ausprägung einer höherwertigen Sprache in OOP
-   Helfen komplexe SW-Systeme zu beherrschen

### Gliederung von Entwurfsmustern
- Nach Zweck
  - Erzeugungsmuster
  - Strukturmuster
  - Verhaltensmuster
- Nach Geltungsbereich
  - Klassenebene: Beim Kompilieren festgelegt
  - Objektebene: Bei Laufzeit festgelegt

### Erzeugungsmuster
-   Trennen Erstellung von Verwendung von Objekten
-   Instanzen werden einfacher ersetzbar für anderes Verhalten
-   System unabhängig von Implementierung der Objekte
-   Kapseln Wissen

### Strukturmuster
-   Kombinieren Klassen u. Obj., um größere Strukturen zu schaffen
-   Kombination von mehreren Interfaces
-   Kombination von Funktionalität zur Laufzeit
-   Übersetzung von einem zum anderen Interface
-   Sparen von Ressourcen

### Verhaltensmuster
-   Zuweisung von Verantwortlichkeiten an Obj.
-   Austausch von Verhalten
-   Kommunikation zw. Obj.
-   Steuerung des Kontrollflusses einer Anwendung zur Laufzeit

|           |  Erzeugungsmuster  |  Strukturmuster  |   Verhaltensmuster  |
|-----------|--------------------|------------------|---------------------|
| Klasse    | Fabrikmethode      | Adapter          | Schablonenmethode   |
| Objekt    | Erbauer            | Kompositum </br> Dekorierer  | Beobachter   |

-   **Trennung der Erstellung von ihrer Repräsentation von (komplexen)
     Objekten**
-   Gleicher Erstellungsprozess -&gt; ggf. unterschiedliche
     Repräsentationen
-   Wiederverwendung einer komplexen Logik zur Umwandlung von Objekten
-   Erzeugungslogik für versch. Formate von Konvertierungslogik trennen
-   **Schrittweise Erzeugung von komplexen Produkten**
-   **Wiederverwendung der Erzeugungs- bzw. Konstruktionslogik
     voneinander**
-   **Vereinfacht die Erweiterbarkeit**
-   Akteure
  - Erbauer: Schnittstelle zur Erstellung der Teile eines Produkts
  - Konkreter Erbauer: Erzeugt, verwaltet und setzt zusammen versch. Teile d. Prod., Implementiert Erbauer, Möglichkeit zur Erzeugung d. Prod.
  - Direktor: Konstruiert m.H. des Erbauers ein Prod. o Produkt: Komplex erzeugtes Produkt

<img src="./media/image6.jpeg" width="584" height="160" />

### Auswirkungen

 - Interne Repräsentation des Prod. kann variieren o Genaue Kontrolle
 über Konstruktionsprozess

 - Trennung von Code zur Erstellung und Repräsentation

### Kompositum

-   Setze Obj. zu Baumstrukturen zusammen, um Teil-Ganzes-Hierarchien zu
     bilden
-   Kombination einfacher Elemente zur Erzeugung komplexer Strukturen
-   Anwender soll Elemente (die etwas ausführen) und Komposita
     (Container, die etwas aufnehmen) nicht unterscheiden müssen
- Akteure
  - Anwender: Manipuliert Objekte im Kompositum nur über Interface
  - Komponente: Interface der Obj. im Kompositum, für Verwaltung der
 Kinder, Standardverhalten für alle Fälle
  - Blatt: Keine Kinder, definiert Verhalten einfacher Objekte
  - Kompositum: Def. Verhalten für Obj. mit Kindern, verwaltet Kinder,
     Implementiert Verhalten bezogen auf Kinder

<img src="./media/image7.jpeg" width="525" height="164" />

-   Auswirkungen
  - \+ Einfache Elemente können beliebig zusammengebaut werden -&gt;
     Rekursive Verschachtelung
  - \+ Vereinfacht Logik beim Anwender
  - \+ Neue Komponenten können einfach def. werden
  - \- Design zu generell
-   Transparenz, Typsicherheit
  - Folie 39 – 42?

Dekorierer
-   Dynamische Zuweisung einer weiteren Verantwortung zu einem Objekt
-   Erweitern eines Objekts mit Funktionalität
-   Flexible Alternative zu Objekthierarchien
-   Einhaltung einer flachen Objekthierarchie
-   Leichtgewichtig, Instanzreich
-   Verschachtelung von Obj. zum Hinzufügen von Funktionalität bietet
     mehr Freiheiten als Vererbung
-   Zusatzfunktion bleibt transparent
-   Wenn Ableitung einer Klasse zu komplex ist
-   Akteure
  - Komponente: Interface, das dynamisch erweitert werden soll
  - Konkrete Komponente: Kann dynamisch erweitert werden
  - Dekorierer: Hält Referenz auf Komponente, Implementiert Interface
 der Komp.
  - Konkreter Dekorierer: Fügt weitere Zuständigkeit zur
 Komponente hinzu

<img src="./media/image8.jpeg" width="594" height="215" />

-   Auswirkungen

    - \+ Flexibler als Ableitungen (dynamisch, beliebige Kombination,
 mehrfach)
    - \+ Einfache, zusammengesteckte Klassen
    - \+ Vermeidet große, konfigurierbare Klassen
    -\– Identität des Dekorierers und der Komponente unterschiedlich
    - \– Viele kleine Objekte erschweren das Debuggen bzw. Lernen des System

### Beobachter
-   Definiere 1-zu-viele Beziehungen zwischen Objekten
-   Benachrichtige/aktualisiere alle abhängigen Obj., wenn ein Obj. den
     Zustand ändert
-   Langlebig
-   Motivation

    -  **Sicherstellung bzw. Erhaltung der Konsistenz in modularen
         Systemen**
    -  **Lose Kopplung**

    -  **Sofortige Benachrichtigung bei Änderung des Zustands**

- Anwendung
  - Änderung von Obj. zieht andere Änderungen von anderen Obj. unbekannter Zahl nach sich
  - Obj. soll andere benachrichtigen, unabhängig vom Typ
  - Eine Abstraktion hat mehrere Aspekte, die von einem anderen Aspekt
     derselben Abstraktion abhängen

- Akteure
  - Subjekt: Kennt beliebig viele Beobachter, Interface zur
         Registrierung und Abmeldung von Beobachtern, Abruf von
         aktuellem Zustand
  - Konkretes Subjekt: Speichert für Beobachter interessanten Zustand,
 benachrichtigt Beobachter über Zustandsänderung

  - Beobachter: Schnittstelle zur Benachrichtung bzw. Aktualisierung der
 Objekte

  - Konkreter Beobachter: Referenz auf konkretes Subjekt, speichert
     Zustand, der konsistent mit Subjekt sein soll, implementiert
     Beobachter zur Aktualisierung des Zustands

<img src="./media/image9.jpeg" width="601" height="200" />

- Auswirkungen
  - \+ Nur abstrakte Kopplung zw. Subjekt u. Beobachter über Interface
  - \+ Automatische Broad-/Multicast-Kommunikation an interessierte
     Objekte
  - \– Unerwartete Aktualisierung
- **Arten**
  - Push-Modell: Subjekt benachrichtigt Beobachter inklusive
         Information
  - Pull-Modell: Subjekt benachrichtigt Beobachter exklusive
     Information, Beobachter muss sie selbst holen

<img src="./media/image10.jpeg" width="593" height="221" />

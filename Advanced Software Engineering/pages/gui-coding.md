## GUI-Coding

### Gestaltungsrichtlinien

- Verwaltungswesen
- Konkrete Beschreibung einzelner Elemente

-  Einheitliches Erscheinungsbild (Corporate Identity)

-  Inhalt: Papierart, -format, Druckart, Schriftart

-   Softwareentwicklung

    -  Herstellerspezifisch: MS, Google

- Platfformabhängigkeit

  - Eingabemethode, -genauigkeit, Bildschirmgröße

-   Desktop, Mobile, Web o Typische Vorgaben

-   Ist das die richtige Komponente? -&gt; Link oder Button

-   Design-Konzepte (Aktion) -&gt; Print… oder Print

-   Verwendungsarten (Bedienung, Aussehen) -&gt; Normal, Fokussiert,
     Split Button

-   Richtlinien -&gt; Vorgaben zur Verwendung

-   Größe, Abstände, Farben -&gt; Pixelabstände usw.

-   Beschreibung / Dokumentation -&gt;

-   Inhalt: Fenster, Text, GUI-Komponenten (vgl Blooper)

### Testen von Benutzeroberflächen

#### Motivation und Ziele

-   UI ist SW, kann Fehler enthalten -&gt; GUI testen

-   Ziel: Funktion von Komponenten u. Zusammenspiel gewährleisten, Test
     automatisieren

-   GUI-Tests: Funktionaler Test von GUI-Komp. (Komponenten-,
     Integrations-, Akzeptanztest)

-   Vorteil: Testen während Buildvorgang, einmal Aufwand für kont.
     Tests, Test für unterschiedliche Plattformen, Monkey Test
     vergleichbar mit normalen Nutzer, Screenshots

-   Nachteil: Ergebnis genau spezifieren, einmalige Überprüfung durch
     Menschen schneller

-   Probleme: Laufzeit, Asynchron, Grafischer Desktop, Eingabe während
     Ausführung blockiert

#### Manuelles Testen

-   Reale Person testet Programm von Hand

-   Protokoll mit Abfolge von Aktionen

-   Fehler/Erfolg wird protokolliert

-   Vorteile: Erkennung sinnvoller Abweichung, Plausibilitätsprüfung,
     Gutes Aussehen prüfbar, schnell bei einmaliger Ausführung

-   Nachteil: Zeitaufwändig, teuer, keine Wahrnehmung von Details,
     erfüllt Anforderung automatisch nicht

#### Probleme von automatischen Tests

-   Suchen/Finden/Interkation der Elemente (-&gt; ggf. ID)

-   Überprüfen/Feststellen von Ereignissen

-   Protokollierung von Fehlern

#### Vorgehen

-   Robot: Zentrale Komponente jedes GUI-Testtools
     (Benutzeraktionen, Maus-Tastatursteuerung, Screenshots)

-   Überprüfung: Vergleich Screenshots, Attribute der GUI-Komp.,
     Direkter Zugriff auf Businessmodell

-   Feststellen von Änderungen: Ereignisse (Events), Polling

-   Protokollierung: Wie Unit-Tests + Screenshot

#### Record and Replay

-   Aufzeichung -&gt; Aktionen ausführen -&gt; Tests / Überprüfungen
     definieren

-   Erzeugter Test: Testskript, Grafischer Testablauf

-   Bestandteile

#### Schrittweise Anleitung

- Aktion: Pixelkoordinate, Komponente

  - Manuelle eingefügte Überprüfung

-  Ausgabe im Fehlerfall

-   Testausführung: Ausführung der gespeicherten Schritte,
     Aktionen/Fehler protokollieren

-   Fehlerfall: Informationen sammeln

-   Vorteile: einfach, schnell, wenig Programmieren

-   Nachteil: unübersichtlich, manuelle Wiederverwendung, Redundanz,
     Änderung schwierig

#### Skriptbasiertes Testen

-   Programmierer erstellt Skript

-   Vorteil: wartbar, umfasst versch. Aktionen, Wiederverwendung,
     gleiche Programmiersprache

-   Nachteil: GUI bei Erstellung nicht sichtbar

#### Automatisiertes Testen

- Matrix Tests

  - Einsatz: Großer Datenbereich für Eingabe, Kombination versch.
 Eingaben
  - Ablauf: Auswahl der Parameter, Definition Parawerte -&gt;
 Tabelle

<img src="./media/image11.jpeg" width="249" height="92" />

1.  Vorteil: Viele Kombinationen, Reduktion der Redundanz

1.  Nachteil: Exponentielle Laufzeit

-   Monkey Tests

    1.  Kontrollierter Zufallsgenerator für Aktionen

- Suche nach Fehlern

-  Aktionsfolge speichern

- Bei gefundenem Fehler: Aktionsfolge als dauerhaften Test

- KI
  - Zustände, Aktionen -&gt; Graphensuche für Start- und Endzustand o
    Erzeugung von Testfällen (Graphensuche, EA)
  - Vorteile: Generierung vieler Testfälle, viele Wege zum Ziel testbar
  - Nachteil: Komplexe Definitionen u. Suche

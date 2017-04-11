Advanced Software Engineering

(Unit) Testing

Fehler

-   Fehlerursachen: Falsche Einschätzung von Risiken, Fehlende Tests

-   Fehler kosten Ressourcen

-   Kosten steigen mit der Zeit

Tests

-   Verpflichtung zum Testen

-   Tests schützen bestehende Funktionen

-   Orientierungshilfe und Dokumentation

-   Neuere Entwicklungsmethoden: Test First, Test Driven Development

-   Nutzen statt Aufwand

-   Tests unterscheiden zwischen zufälliger und gewollter Funktionalität

Testarten

-   Akzeptanztest

 o Test des kompletten Systems

1.  Realistische Umgebung, Steuerung durch Mittel des Benutzers,
     Absegnung durch Auftraggeber

    1.  Ziel: Echte Benutzerszenarien

-   Integrationstest

    1.  Nur relevante Teile des Systems werden gestartet

    <!-- --

    1.  Stellvertreter für nicht relevante Teile

    <!-- --

    1.  Testframework

    <!-- --

    1.  Zusammenspiel der Komponenten sichern

<!-- --

-   Komponententest

    1.  Nur relevanter Teil des Systems wird gestartet

 o Alle anderen Teile durch Stellvertreter ersetzen o Testframework

1.  Funktionalität einzelner Komponenten sicherstellen

-   Performancetest

\[Folie 11?\]

Was ist eine Komponente?

-   Meist Klasse

-   Ersetzen der Abhängigkeiten durch Stellvertreter „Mocks“

-   Mock: Minimale notwendige Funktionalität

xUnit-Testframework

-   Vorlage für Unit-Tests

-   Trennung zwischen Test- und Produktivcode

-   Für fast alle Sprachen existiert Implementierung

Aufbau eines Tests

-   Arrange: Initialisieren der Testumgebung (String def.)

<!-- --

-   Act: Ausführen des zu testenden Codes (Lowercase String)

-   Assert: Überprüfen des Ergebnisses (Is der String lowercase?)

JUnit

-   Quasi-Standard in der Java-Entwicklung

Überprüfungen

-   asserts

    1.  Überprüfung auf Gleichheit, Referenz, Wahrheit, Null

    <!-- --

    1.  assertEquals("blub", result);

<!-- --

-   Matcher

    1.  Möglichkeit, um weitere Überprüfungen hinzuzufügen

    <!-- --

    1.  Bestehen aus:

        -   Überprüfung eines Wertes mit einem erwarteten Wert

        -   Beschreibung, welcher Wert erwartet wird („start at…“)

        -   Beschreibung, welcher Wert überprüft wurde („started at…“)

 o Zahlen auf größer/kleiner, von Objekten auf Gleichheit, von Listen
 und ähnlichem o assertThat(list, contains(„element“));

 o Können verschachtelt werden

 o assertThat(number, is(lessThan(0)));

|                                       |                                |
|---------------------------------------|--------------------------------|
| **Vorteile**                          | **Nachteile**                  |
| Verbessern die Lesbarkeit des Tests   | Implementierung braucht Zeit   |
| Sprechendere Fehlermeldungen          |                                |
| Wiederverwendbarkeit                  |                                |
| Exceptions und Spezialfälle           |                                |
| o Exceptions:                         |                                |

1.  Gewisse Exceptions können ebenfalls erwartet werden (Annotation
     möglich, oder Assert)

 o Gleitkommazahlen lassen sich nicht exakt überprüfen o Genauigkeit
 kann angegeben werden

 o assertThat(value, closeTo(1.0d, 1E-2)) o Arithmetische Spezialfälle

 o Ganzzahlen kennen keinen Overflow

 o Kleinster Wert von Datentypen haben unterschiedliche Semantik o
 Double kennt kein DivisionByZero

Ergebnis eines Tests

|     |           |                                       |
|-----|-----------|---------------------------------------|
| o   | Success   |                                       |
|     | o         | Testmethode erfolgreich durchlaufen   |
|     | o         | Keine Assertion fehlgeschlagen        |
| o   | Failure   |                                       |
|     | o         | Assertion ist fehlgeschlagen          |
| o   | Error     |                                       |
|     | o         | Unerwarteter Fehler                   |

Eigenschaften guter Tests – ATRIP

Automatic

o Minimale Anforderung bei der Ausführung

1.  Einfach ausführbar (1 Knopf), automatisch (kein Input),
     selbst-überprüfbar (bestanden/fehlgeschlagen)

Thorough (Vollständig)

 o Alles Notwendig überprüfen

 o Iteratives Vorgehen (bei Fehler ergänzen)

 o Fehler klumpen: Bei Fehler auch Umgebung testen

Repeatable

 o Beliebig wiederholbar -&gt; gleiches Ergebnis

 o Plattform, Zeit, Zufall, Multithreading kritisch

 o Tests, die ohne Änderungen fehlschlagen -&gt; Fehlerhafte Tests

Zufall muss gesteuert werden. Statt random() feste Zahl wählen.

Independent

 o Keine Abhängigkeit zu anderen Tests (keine Reihenfolge) o Tests
 sollen auf Aufgabe fokussiert sein

Professional

 o Tests sollen qualitative hochwertig sein (kein Doppelcode etc.) o
 Keine unnötigen Tests

 o Teil der Dokumentation

Mock-Objekte

Verhalten im Test

 o Reduzieren Abhängigkeit zu anderen Komponenten o Stellvertreter für
 Objekte

 o Mocks können manuell erstellt werden (Großer Aufwand) oder durch
 Mocking-Frameworks o Arrange: Konfiguration der Mocks

 o Act: Verwendun der Mocks

 o Assert: Überprüfen der Mocks

1.  Beispiel: HW-Gerät verlangsamt Test, HW soll nicht getestet werden
     -&gt; Mockup durch Interface abilden

Schwierigkeiten

 o Verwendung von statischen Methoden (-&gt; Dependency Injection) o
 Tiefe Abhängigkeiten erschweren Mocking (-&gt; Lose Kopplung)

 o Vorsicht vor Testen von reinem Mock-Verhalten?

Code Coverage

 o Tests testen

 o Testabdeckung

 o Temporäre Probleme einbauen

 o SW, die Produktivcode ändert (Mutation Testing) o Coverage: Wie viel
 Code wurde während Test durchlaufen?

 o Branch Coverage: Misst die Anzahl der durchlaufenen Pfade (if, else
 etc.) o Line Coverage: Misst die Anzahl der durchlaufenen
 Quellcode-Zeilen

1.  Branch/Line -&gt; unterschiedliche Aussagekraft, keine Aussage über
     Funktion, deuten auf potentiell problematische Bereiche hin

Test First

 o Klassisch: Funktion planen -&gt; Programmieren -&gt; Refactoring
 -&gt; Testen -&gt; Fehler beheben o Test First: Funktion planen -&gt;
 Tests -&gt; Programmieren -&gt; Refactoring

 o TDD: Tests in kleinen Schritten entwickeln (bis fehlschlägt) -&gt;
 Funktion ändern bis Test erfüllt o Kerngedanke

|                                                                         |                                       |                 |
|-------------------------------------------------------------------------|---------------------------------------|-----------------|
| o                                                                       | Tests &gt; Produktivcode              |                 |
| o Entwicklungsende, wenn Tests erfüllt -&gt; Minimal notwendiger Code   |
| o                                                                       | Test als Wegweiser                    |                 |
|                                                                         |                                       |                 |
| **Vorteile**                                                            |                                       | **Nachteile**   |
| Volle Testabdeckung                                                     | Testen wird zur Pflicht               |
| Fehlerrate sinkt                                                        | Ungewohntes Vorgehen / Einarbeitung   |
| Angst existierende Fnkt. zu ändern, sinkt                               | Aufwand zur Implementierung höher     |
| Automatische Spezifikation/Dokumentation                                | Ggf. schwierige Anwendung             |
| Weniger Produktivcode                                                   |                                       |

Umgang mit bestehendem Code

 o Bestehender Code schwer testbar (Legacy Code)

 o Legacy Code nicht fürs Testen entwickelt (viele Abhängigkeiten) o
 Kann schrittweise weiterentwickelt werden (absichern, isolieren)

Testen auf der grünen Wiese

 o Neue Projekt -&gt; von Anfang an testbar

 o Feature -&gt; „Ende-zu-Ende-Test“ definieren, bei Erfüllung ist
 Feature fertig o Einzelne Schritte -&gt; Unit-Tests

Refactoring

Was ist Refactoring?

 o Bestehenden Code durchgehen: Code Review o Intention/Funktion
 nachvollziehen

 o Testabdeckung wird überprüft

 o Code wird umgestaltet (Verhalten & Schittstellen bleiben gleich,
 neues Wissen einbauen) o Ziel: Codequalität verbessern (lesbarer,
 flexibler nutzbar, Struktur verbessern)

Folie 5?

Warum sollte man Refactoring verwenden?

 o Design der SW wird verbessert o SW wird wartbarer

 o SW wird einfacher verständlich

 o Fehler werden einfacher gefunden

 o Neue Funktionen kann schneller entwickelt werden

Folie 9?

Wann sollten wir Refactoring verwenden?

 o Bestandteil der Entwicklung -&gt; kontinuierlich o Regel: Three
 strikes and you refactor

 o 1. Implementieren -&gt; neue Funktionalität o Ähnliche Funktion?
 -&gt; Code kopieren

 o Erneut Ähnliche Funktion? -&gt; Code refactorn und wiederverwenden

 o Code Review

 o Vor Hinzufügen neuer Funktionalität o Beim Beheben eines Fehlers

Folie 16?

Wann wird Refactoring schwierig?

 o DB-Schemata schwieriger änderbar o Änderung von Schnittstellen

 o Zentrale Designentscheidungen

 o Aufwand zu groß? -&gt; Komplett neu entwickeln

Auswirkungen auf das Design

Folie 20

Nachteile von Refactoring

 o Refactoring kostet Zeit

 o Verschlechtert die Performance

Code Smells

 o Code kann stinken, Stärke des „Gestanks“ schlecht messbar

1.  Deuten auf verbesserungswürdige Stellen im Code hin und welche die
     die Entwicklung behindern

Duplicated Code

 o Doppelt vorhandener Code

 o Gleiche Code-Struktur an mehr als einer Stelle o Auseinanderdriften
 mehrere Stellen

 o Lösung: Gemeinsamen Code auslagern

Long Method

 o Lange Methoden

 o Je länger -&gt; schwerer verständlicher o OO: viele Methoden
 delegieren

 o Semantische Distanz zwischen Code und Name der Methode

 o Lösung: Auftrennen der Methode (gute Namen, Kommentare, Schleifen,
 ifs sind gute Stellen)

Large Class

 o Große Klasse

 o Anzahl Instanzvariablen, Methoden, Präfixe, Suffixe bei Variablen o
 Klasse: Zu viel Verantwortung

 o Lösung: Unterteilen der Klasse

Shotgun Surgery

 o Flickenteppich Änderung

 o Kleine funktionale Änderung -&gt; Anpassung vieler Stellen o Lösung:
 Umstrukturierung des Codes

Switch Statements

1.  Switch Statements: oft gleiche Switchs, wenige Nahtstellen zum
     Auftrennen, Fehler durch vergessenes Break

o Lösung: OO

Code Comments

 o Schlechter Code muss erklärt werden

1.  Lösung: Kommentar ist guter Indikator zur Trennung von Methoden
     -&gt; Intention des Kommentars als Methodenname

Refactorings

Extract Method

 o Problem: Zusammenhängendes Stück Code kann extrahiert warden

1.  Lösung: Code in eigene Methode auslagern, passenden Namen wählen,
     Code freingranular aufteilen

 o Verbesserung: Bessere Strukturierung des Codes

 o Hilft gegen: Code Comments, Duplicated Code, Long Method

Rename Method

 o Problem: Methodenname passt nicht zum Inhalt der Methode o Lösung:
 Methodenname ändern

 o Verbesserung: Code lesbarer/verständlicher o Hilft gegen: Code
 Comments

Replace Temp with Query

 o Problem: Ergebnis einer Berechnung wird temporär in einer Variablen
 gespeichert o Lösung: Berechnung des Wertes in eine Methode auslagern

 o Verbesserung: Extrahierung, Schreibzugriffe auf Variablen werden
 sichtbar, Wert der Berechnung wird nicht zwischengespeichert

 o Hilft gegen: Long Method

Replace Conditional with Polymorphism

 o Problem: Verhalten mit Konditionalstrukturen und einer Typ-Kodierung
 gesteuert

 o Lösung: Verhalten der einzelnen Pfade in abgeleitete Klasse
 überschreiben, Basismethode abstrakt

 o Verbesserung: Software besser gekapselt, dynamisch erweiterbar o
 Hilft gegen: Switch-Statements

Replace ErrorCode with Exception

 o Problem: Fehlerwerte warden zurückgegeben o Lösung: Statt Fehlerwert
 lieber Exception

 o Verbesserung: Klare Definition von Fehlern, bessere Steuerung, Code
 verständlicher

Replace Inheritance with Delegation

 o Problem: Funktionalität in abgeleiteter Klasse nicht brauchbar o
 Lösung: Instanzvariable mit dem Type der Oberklasse anlegen

 o Verbesserung: Klarer def. Schnittstellen, Trennung zw. eigener u.
 vorhandener Funktionalität

GUI Blooper

Personen im Umfeld der UI

Folie 5 - 8

Häufiges Vorgehen in der UI-Entwicklung

o Typischer Entwicklungsprozess: Businesslogik -&gt; GUI -&gt; Workflow
o Alle Entwicklungsprozesse durch Programmierer dominiert

 o Businesslogik bestimmt GUI und Workflow -&gt; GUI Blooper

GUI Blooper

Was sind GUI-Blooper?

 o Allgemeine GUI-Design-Fehler o Über 70 GUI-Blooper

Durch Blooper verursachte Probleme

 o Verwirrung beim Nutzer o Unnötiger Zeitaufwand o Datenverlust

Gründe für Blooper

Fehlende Zeit, Wissen, Ressourcen

Arten von Bloopern

 o GUI-Komponenten

 o Navigation

 o Texte

 o Design und Layout

 o Interaktion

 o Management

 o Antwortverhalten

GUI Komponenten

 o Umgang mit GUI-Komponenten

 o Aussehen &gt; Wahl der Komponenten

 o Fehlende Unterstützung durch GUI-Toolkit o Fehlendes Fachwissen

 o 2 Kategorien

 o Falsche Komponente

 o Falsche Verwendung von Komponenten o Beispiele:

 o Verwirrende Checkboxen/Radiobutton (Einzelner Radiobutton, Checkbox
 als Radiobutton)

 o Textfelder für beschränkten Input (Datumsfeld, Radiobutton, …)

Navigation

 o Navigation allgegenwärtig, wichtig für Orientierung

 o Aktueller Ort, Vorheriger Ort, Mögliche nächste Orte, Entfernung zum
 Ziel o Beispiele:

 o Gleicher Titel für unterschiedliche Fenster o Zu viele Ebenen von
 Dialogboxen

Text

 o Viel Text in GUI

 o So wenig wie möglich, so viel wie nötig o Visualisierung oft besser

 o Kategorien:

 o Unkommunikativ

 o Entwicklerzentriert

 o Fehlleitend

 o Beispiele:

 o Inkonsistente Terminologie

o Speaking Geek: Entwicklersprache für Nutzer unverständlich

Design und Layout

 o Design, Farben, Layout

 o Amateurhaft vs. Professionell o In der Regel einfach korrigierbar o
 Beispiele:

 o Leicht übersehbare Informationen

 o Radiobuttons zu weit auseinander (-&gt; Groupboxen)

Interaktion

|                              |                                   |
|------------------------------|-----------------------------------|
| o                            | Schwierig zu erkennen/beheben     |
| o Decken größere Bereiche ab |
| o                            | Arten:                            |
|                              | o Ablenkung von eig. Aufgabe      |
|                              | o                                 |
|                              | o Gedächtnis des Users belasten   |
|                              | o Kontrolle des Users entziehen   |
| o                            | Beispiele:                        |
|                              | o                                 |
|                              | o                                 |

Management

 o UI unterschätzt durch Management o UI überschätzt von Management

 o Beispiele:

 o UI als niedrige Priorität o Anarchische Entwicklung

 o Programmierer bekommen schnellsten Computer

Antwortverhalten

 o Benutzer immer ungeduldig o Intransparenz der Aktion

 o Mehrfaches Ausführen o Beispiele:

 o Lag zerstört Hand-Augen-Koordination

 o Anwendung zeigt nicht, dass es beschäftigt ist

 o Lange Operationen ohne Möglichkeit abzubrechen

Responsiveness

1.  Responsivness != Performance

2.  Ressourcen sind limitiert

3.  UI ist ein real-time Interface

4.  Verzögerungen sind nicht gleich

5.  Aufgaben nicht in der Reihenfolge in der sie erscheinen

6.  SW braucht nicht alle Aufgaben machen, die gefordert wurden

Vermeidung von langem Antwortverhalten

 o Timely Feedback

 o Benutzereingaben direkt bestätigen

 o Parallel Problem Solution

 o Prioritäten vergeben (Usereingaben &gt; Update)

 o Vorarbeiten

 o Queue Optimization

 o Unkritische/Unnötige Aufgaben verzögern/entfernen

 o Dynamic Time Management

 o Bearbeitungszeit berechnen

 o Abarbeitung der Warteschlange ändern

UI-Entwicklung

Sinnvoller Designprozess

-   Workflow (Interface Designer) -&gt; GUI (IF Designer / Grafiker)
     -&gt; Businesslogik (Programmierer)

Definition von Usability

-   Usability eines Produktes ist das Ausmaß, in dem es von einem
     Benutzer verwendet werden kann, um Ziele in einem Kontext
     effektiv, effizient und zufriedenstellend zu erreichen.

-   Wesentliche Elemente

 o Benutzer

 o Ziele

1.  Kontext

-   Wesentliche Messgrößen

    1.  Effektivität

 o Effizienz

 o Zufriedenheit

-   5Es

 o Effective: Vollständigkeit/Genauigkeit o Efficient: Geschwindigkeit

 o Engaging: Zufriedenheit

 o Error tolerant: Vermeidung von Fehlern

 o Easy to learn: Unterstützung bei erster Bedienung

User Centered Design Process

-   Ziel: Benutzerfreundliche Oberfläche

-   Analyse -&gt; Design -&gt; Implementierung -&gt; Deployment

-   Während Design und Implementierung auch Evaluation

Analyse

-   Aufgabe: Informationen sammeln über

    1.  Benutzer, Aktivitäten/Ziele, Umfeld

<!-- --

-   Ziel: Mentales Modell des Produkts

Folie 9, 10, 12

Informationsquellen

-   Marktforschung

<!-- --

-   Interne Schulungsunterlagen

-   Benutzer beobachten/interviewen

Informationen zum Benutzer

-   Wichtigste Komponente: Benutzer

-   Eigenschaften wie Name, Alter, Geschlecht, Bild, Job, Ziele,
     Domänenwissen, Umfeld

-   Grundlage für Tester

-   Vorteile:

 o Konkretes Bild eines Benutzers

 o Bessere Identifikation mit dem Benutzer

<img src="./media/image1.jpeg" width="329" height="159" /

Mentales Modell

-   Grundlage/Inhalt

 o Probleme des Nutzers o Ziele des Nutzers

1.  Daten, die der Nutzer verarbeitet

-   Zusammen mit dem Kunden erstellen

-   Aufgabenspezifisch ohne UI-Begriffe

-   Verwendung der Begriffe des Benutzers

-   =&gt; Zuerst die Funktion, dann das Aussehen

*Objekt-Aktions-Analyse*

-   Welche Objekte und Aktionen gibt es?

-   Beziehungen und Hierarchien festhalten

-   Keine Implementierungsdetails

*Regeln an ein mentales Modell*

-   Schlichtheit/Einfachheit

-   Vertrautheit

-   Flexibilität

-   Sicherheit

-   Affordances

*Lexikon*

-   Wörterbuch für Begrifflichkeiten

-   Verständlich für den Benutzer

-   Gleiche Aktion -&gt; Gleicher Begriff

-   Kompakt

-   =&gt; Konsistenz zwischen SW und Doku

*Szenarios*

-   Beschreiben Abläufe einzelner Aktivitäten

-   Blaupause für Usability-Test

*Gemeinsame Diskussionsgrundlage*

-   Für alle einsehbar

-   Blaupause für erste Implementierung

*Vorteile*

-   Ziel / Aktivitäten bezogen: Festlegung von Relevanz und Beziehungen

-   Wichtigkeit: Ordnung der einzelnen Komponenten

-   Konsistenz: Definition allg. Aktionen, Verwendung einheitlicher UI,
     Einfache Korrekturmög.

<img src="./media/image2.jpeg" width="413" height="570" /

Design

-   Aufgabe: Umfang und Aussehen der SW festlegen

-   Anzahl der Features, Wichtigkeit der Features,
     Bedienkonzepte (Workflow)

-   Ziel: Prototyp für Usability Tests und weitere Entwicklung

Umfang der Software

-   Sicht des Benutzers Grundlage für die UI

<!-- --

-   Verwende natürliche Abläufe und Begriffe

-   So wenig Beschränkungen wie möglich

-   Anzahl Features vs. Komplexität

-   =&gt; Sichtweise des Benutzers auf die Aufgabe zählt

Anzahl Features versus Komplexität

-   Standardwerte

-   Templates

-   Wizards

-   Schrittweise Offenlegung

-   Generische Befehle

-   Aufgabenspezifisches Design

-   Anpassungsfähigkeit

-   Standardfall einfach erreichbar

 o Arten: Anzahl Benutzer, Aufrufhäufigkeit

<img src="./media/image3.jpeg" width="407" height="98" /

-   UI sorgfältig planen

-   Benutzer die Kontrolle überlassen

-   Minimale Änderung bei neuen daten

Gestaltprinzipien

-   Gute Beschreibung menschlicher Wahrnehmung

-   Gute Richtline für UI-Design

-   Grundlage für Bedienkonzepte

-   Sind allgemeingültig

-   Kombination ist möglich

-   Erkenntnis über unterwünschte Gruppierung und Fokussierung

-   Nach UI-Entwurf Prinzipien überprüfen und unerwünschte Effekte
     entfernen

-   Prinzipien:

 o Proximity: Nähe gruppiert

 o Similarity: Ähnlichkeit gruppiert

 o Closure: Offene Objekte werden geschlossen wahrgenommen

<img src="./media/image4.jpeg" width="144" height="31" /

 o Figure/Ground: Einteilung in Voder- und Hintergrund (Vordergrund:
 Fokus) o Common Fate: Gemeinsame Bewegung wirken gruppiert

Evaluation

-   Paper Prototyping

-   Expert Review

-   Usability Testing

Implementierung

-   Antwortverhalten

<!-- --

-   Gestaltungsrichtlinien

-   GUI-Tests

Usability nach Auslieferung

-   Feldtest

-   Logoanalyse

-   Langzeitstudien

Usability Evaluation

Review durch Experten

-   Überprüfung durch Usability Experte / Domain Experte

-   Prüfung basierend auf einfach Regeln

Evaluationsregeln

-   Sichtbarkeit des Systemstatus (aktuell)

-   Unterschiede zw. Realität und System (Sprache, Abfolge)

-   Konsistenz / Standards

-   Flexibilität, Effizienz

-   Gedächtnis des Nutzers entlasten

-   Minimalistisches Design

-   Benutzer einen Ausweg lassen

-   Fehlervermeidung

-   Unterstützung bei Fehlern

-   Hilfe und Dokumentation

Evaluationsarten

-   Formell:

    1.  Experten -&gt; Berichte -&gt; Zusammenfassung der Berichte

    <!-- --

    1.  Klassifizierung der Probleme

<!-- --

-   Informell

    1.  Teammitglied überprüft

 o Informelles Meeting

Usability Test

-   Überprüfung durch echte Nutzer

-   Zeit für Korrekturen einplanen

-   Ziel: Information, soziales Ziel

Testarten

-   Formativ: klein, iterativ, während Entwicklung, für ein Ziel -&gt;
     günstig, schnell

-   Summativ: umfangreich, vor Auslieferung

Vorbereitung

-   Benutzerprofile erstellen -&gt; Auswahl der Benutzer

-   Szenarien/Ziele definieren (Szenario beschreibt „Suche
     nach Informationen“)

-   Umfang definieren

-   Teilnehmer rekrutieren

-   Zeitraum festlegen

-   Testablauf für Beteiligten beschreiben

<!-- --

-   Labor / Unterlagen vorbereiten

Einführung

-   Teilnehmer begrüßen

-   Angenehme Atmosphäre schaffen

-   Beteiligte vorstellen

-   Räumlichkeit zeigen

-   Szenarien / Ziele erklären

-   Verhalten während Test besprechen

-   Produkt wird getestet, nicht Teilnehmer

*Lautes Denken*

-   + Besseres Verständnis

-   - Ungewohnt, passende Umgebung notwendig

Durchführung

-   Teilnehmer soll Lösung selbst finden

-   TN bestimmt Tempo

-   Genügend Pausen

-   Klare Aufteilung zw. Moderator / Beobachtern

-   Produktexperte für Nachfragen

-   Bei Verwirrung nachfragen

-   Teilnehmer verabschieden

*Testumgebung*

-   Testutensilien

-   Eigenes Labor

    1.  Basisaufwand gering, größter Nutzen

    <!-- --

    1.  Teuer, großer Platzbedarf

<!-- --

-   allg. nutzbarer Raum

    1.  Günstig, wenig Platz notwendig

    <!-- --

    1.  Höherer Basisaufwand

<!-- --

-   Feldtest: pot. überall

    1.  Reale, gewohnte Umgebung

    <!-- --

    1.  Ablenkung, höhere Kosten, Umgebung nicht festlegbar

<!-- --

-   Remotetest: örtlich getrennt

    1.  Synchron (verbunden via. Video): vielfältig, günstig,
         zeitsparend, schwierig,

 Setupaufwand, allg. Prob. von Remote

1.  Asynchron (Vordef. Fragen, Aufzeichnung): mehr Teilnehmer, vgl. mit
     Konkurrenzprod., kein Audio/Blickkontakt, teuer

*Testutensilien*

-   Basic: Möbel, Geräte

-   Nice to have: Kamera, Mikrofon, …

-   Special: Eye-Tracker, …

*Auswahlkriterien*

-   Budget

-   Ressourcen

-   Größte des potentiellen Teilnehmerkreises

*Häufige Fehler*

-   Verwendung von Wörtern der UI

-   Beeinflussung des TN

-   Erzeugung von Stress

-   Benutzer gibt sich die Schuld am Fehler

Evaluation

-   Hauptfragen: Was wurde gesehen, was bedeutet es, wie damit umgehen?

-   Evaluation durch versch. Personen

-   Einteilung der resultierenden Aktionen: Dringend, lokal, global

*A/B-Test*

-   Redesign vs. bestehende SW

-   Unklar, welcher besser -&gt; Benutzer in Gruppen teilen und je eine
     Version geben

-   Usability messen und statistische Signifikanz beachten

Programmierprinzipien

-   Leitfaden

-   Aus Erfahrung und Diskussion

-   Existieren in unterschiedlichen Abstraktionen

-   Müssen zusammen betrachtet werden

-   Müssen nicht erzwungen werden

-   Verantwortung aufteilen

-   Allgemeiner als Muster

SOLID

-   Singe Responsibility

    1.  Klasse soll nur einen Grund haben sich zu ändern

    <!-- --

    1.  Niedrige Komplexität/Kopplung

    <!-- --

    1.  Jede Klasse nur eine Zuständigkeit

    <!-- --

    1.  Klasse enthält Achsen, auf der sich Anforderungen ändern können
         (-&gt; nur eine)

    <!-- --

    1.  Beispiel: Bus -&gt; PassangerRoom, Vehicle

<!-- --

-   Open Closed

    1.  Elemente der SW sollten offen für Erweiterungen, geschlossen für
         Änderungen sein

    <!-- --

    1.  Erweiterung durch Vererbung / Interfaces

    <!-- --

    1.  Bestehender Code wird nicht geändert

    <!-- --

    1.  Beispiel: Loop statt if

<!-- --

-   Liskov Substitution

    1.  Objekte eines abgeleiteten Typs müssen als Ersatz für Instanzen
         ihres Basistyps funktionieren ohne die Korrektheit des
         Programms zu ändern

    <!-- --

    1.  Starke Einschränkung der Ableitungsregeln

    <!-- --

    1.  Führt zur Einhaltung von Invarianzen

    <!-- --

    1.  Beispiel: Quadrat, Rechteck, Funktion zur Flächenberechnung

<!-- --

-   Interface Segregation

    1.  Anwender sollten nicht von Funktionen abhängig sein, die sie
         nicht nutzen

    <!-- --

    1.  Schwere Interfaces/Klasses bündeln viel Funktionalität

    <!-- --

    1.  Interfaces passend zu den Anwendern gestalten

    <!-- --

    1.  Daher oft mehrere Interfaces: Clonable, Serializable, Comparable

    <!-- --

    1.  Beispiel: Arbeiter Interface mit work und eat, Person-Klasse,
         Roboter-Klasse, Roboter braucht essen eigentlich nicht

<!-- --

-   Dependency Inversion

    1.  High-Level-Module sollten nicht von Low-Level-Module
         abhängig sein. Beide sollten

 von Abstraktionen abhängig sein.

 o Details sollten von Abstraktionen abhängig sein.

 o Regeln von High-Level-Modul vorgeben -&gt; Low-Level-Modul
 implementiert o High-Level-Module können wiederverwendet werden

1.  Beispiel: Manager abhängig von Worker-Klasse -&gt; Besser Manager
     abhängig von Worker-Interface, Worker und Superworker können dann
     das Interface implementieren

TODO: UML-Klassendiagramme

Tell don’t ask

-   Prozedural

 o Holt sich Informationen, trifft dann Entscheidung o Zentralisierte
 Logik

 o Hohe Kopplung

-   OO

 o Sagt Objekten, dass sie etwas tun sollen o Verteilte Logik

1.  Bessere Kapslung innerhalb der Objekte

-   Kommandos stellen besser als Abfragen -&gt; Command Query Seperation
     (Seiteneffektfrei, definierte Aktionen)

KISS

-   Keep it simple, stupid

-   Komplexität vermeiden, da Fehler wahrscheinlicher und unverständlich

SLAP

-   Single Level of Abstraction Principle

-   Code in einer Methode ist auf einem Abstraktionsniveau o Arbeit,
     Delegation

 o DB, Businesslogik

-   -&gt; Entstehen von Composed Methods

-   Fördert Wiedervewendbarkeit

-   Sprünge im Abstraktionsniveau schwer zu verstehen

GRASP

-   General Responisbility Assigment SW Patterns

-   Basis-Prinzipien auf denen Entwurfsmuster aufbauen

-   Low Representational Gap (LRG) minimieren

    1.  Lücke zwischen Domänenmodell und Implementierung

<!-- --

-   Zuweisung von Zuständigkeiten (2 Typen: Ausführung, Wissen)

-   Low Coupling

    1.  Geringe Kopplung, Abhänigigkeit zw. Objekten

 o Leichter änderbar, testbar, wiederverwendbar, verständlicher

1.  Bsp: Impl. von Interfaces, Vererbung, gemeinsame Dateien, Locks
     durch Threads

-   High Cohesion

    1.  Zusammenhalt einer Klasse: Semantische Nähe der Elemente

 o Einfacher, verständlicher, wiedervendbarer

1.  Schwer bestimmbar, ggf. durch Anzahl Verwendungen, Anzahl Attribute

-   Information Expert

    1.  Zuweisung einer Zuständigkeit zu einem Objekt

 o Objekte sind zuständig für Aufgaben über die sie Informationen
 besitzen

 o Kapselung von Infos, leichtere Klassen &lt;-&gt; ggf. Problem mit
 anderen Prinzipien

<img src="./media/image5.jpeg" width="214" height="133" /

-   Creator

 o Wer ist für Erzeugung eines Obj. Zuständig?

1.  Wenn das Objekt zu jedem erstellen Objekt eine Beziehung hat (z.B.
     Komposition, wenn a Teil von B ist \[Raum, Haus\])

    1.  Verringert Kopplung

-   Indirection

    1.  Indirektion/Delegation, kann Syteme oder Teile voneinander
         entkoppeln

    <!-- --

    1.  Mehr Freiheitsgerade als Vererbung

    <!-- --

    1.  Komposition verschiedener Objekte möglich

    <!-- --

    1.  Bsp: Objekt nutzen statt davon erben

<!-- --

-   Polymorphism

    1.  Behandlung von Alternativen abhängig von einem konkreten Typ

    <!-- --

    1.  Methoden erhalten je nach Typ andere Implementierung

    <!-- --

    1.  Vermeidung von Fallunterscheidung

    <!-- --

    1.  Abstrakte Klasse, Interface als Basistyp

    <!-- --

    1.  Polymorphe Methodenaufrufe erst zur Laufzeit gebunden

    <!-- --

    1.  -&gt; Entwurfsmuster Strategie

    <!-- --

    1.  Beispiel: Steuer-Interface, Deutschland, Frankreich-Klasse

    <!-- --

    1.  Erweiterbar, bestehendes muss nicht geändert werden,
         extrahierung von Frameworks vereinfacht

<!-- --

-   Controller

    1.  Verarbeitung von einkommenden Benutzereingaben

 o Koordination zwischen UI und Logik o Delegation zu anderen Objekten

 o Zustand der Anwendung kann in Controller gehalten werden

1.  Arten

    -   System Controller: Controller für alle Aktionen

    -   Use Case Controller: Controller pro Use-Case,

-   Pure Fabrication

    1.  Reine Erfindung, reine Verhaltens- / Arbeitsklasse ohne Bezug
         zur Domäne (möglichst selten!)

 Imposed Duplication: Auferlegt, unumgänglich Inadvertent Duplication:
 Versehentlich Impatient Duplication: Ungeduldig, zu faul

1.  Trennung zw. Technik und Domäne

<!-- --

1.  Wiederverwendbar, High Cohesion

-   Protected Variations

    1.  Sicherung vor Variation

 o Kapselung versch. APIs hinter einheitlicher API o Polymorphie,
 Delegation als Schutz

 o Bsp: OS (HW), SQL (DB)

DRY

-   Don’t Repeat Yourself

-   Anwendbar auf alles: DB-Schema, Doku, Tests

-   Nur eine Quelle der Wahrheit, alle anderen leiten ab

-   Auswirkung der Modifikation haben eine definierte Reichweite

-   Arten

 o o o

YAGNI

-   You ain’t gonna need it (Du wirst es nicht brauchen)

-   Unnötige Features erhöhen Komplexität, binden Ressourcen

-   Eigene Ideen -&gt; schwer objektiv betrachtbar

-   Frameworks sinnvoll, wenn sie aus dem Projekt heraus entstehen,
     nicht wenn sie durch spekulatives Programmieren entstehen

-   Kommunikation zw. Entwicklung u. Kunde wichtig

Conway’s Law

-   Kommunikationsstruktur findet sich in Code wieder

-   Kommunikationsschnittstellen = Modulschnittstellen im Code

-   Müssen zum Produkt passen…

-   Bei Neuausrichtig des Produkts -&gt; Kommunikationsstruktur anpassen

-   Beispiel: Konzernwebseiten spiegeln Org. wieder statt Bedürfnisse
     des Kunden

Entwurfsmuster

Entwurfsmuster

-   Muster beschreiben wiederkehrende Probleme

Nutzung von Entwurfsmustern

-   Vermittlung von Wissen auf abstraktem Niveau

-   Ausprägung einer höherwertigen Sprache in OOP

-   Helfen komplexe SW-Systeme zu beherrschen

Gliederung von Entwurfsmustern

-   Nach Zweck

 o Erzeugungsmuster

 o Strukturmuster

1.  Verhaltensmuster

-   Nach Geltungsbereich

    1.  Klassenebene: Beim Kompilieren festgelegt

 o Objektebene: Bei Laufzeit festgelegt

Erzeugungsmuster

-   Trennen Erstellung von Verwendung von Objekten

-   Instanzen werden einfacher ersetzbar für anderes Verhalten

-   System unabhängig von Implementierung der Objekte

-   Kapseln Wissen

Strukturmuster

-   Kombinieren Klassen u. Obj., um größere Strukturen zu schaffen

-   Kombination von mehreren Interfaces

-   Kombination von Funktionalität zur Laufzeit

-   Übersetzung von einem zum anderen Interface

-   Sparen von Ressourcen

Verhaltensmuster

-   Zuweisung von Verantwortlichkeiten an Obj.

-   Austausch von Verhalten

-   Kommunikation zw. Obj.

-   Steuerung des Kontrollflusses einer Anwendung zur Laufzeit

|           |                    |                  |                     |
|-----------|--------------------|------------------|---------------------|
|           | Erzeugungsmuster   | Strukturmuster   | Verhaltensmuster    |
| Klasse    | Fabrikmethode      | Adapter          | Schablonenmethode   |
| Objekt    | Erbauer            | Kompositum       | Beobachter          |
|           |                    | Dekorierer       |                     |
| Folie 10? |                    |                  |                     |
| Erbauer   |                    |                  |                     |

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

 o Erbauer: Schnittstelle zur Erstellung der Teile eines Produkts

 o Konkreter Erbauer: Erzeugt, verwaltet und setzt zusammen versch.
 Teile d. Prod., Implementiert Erbauer, Möglichkeit zur Erzeugung d.
 Prod.

 o Direktor: Konstruiert m.H. des Erbauers ein Prod. o Produkt: Komplex
 erzeugtes Produkt

<img src="./media/image6.jpeg" width="584" height="160" /

-   Auswirkungen

 o Interne Repräsentation des Prod. kann variieren o Genaue Kontrolle
 über Konstruktionsprozess

 o Trennung von Code zur Erstellung und Repräsentation

Kompositum

-   Setze Obj. zu Baumstrukturen zusammen, um Teil-Ganzes-Hierarchien zu
     bilden

-   Kombination einfacher Elemente zur Erzeugung komplexer Strukturen

-   Anwender soll Elemente (die etwas ausführen) und Komposita
     (Container, die etwas aufnehmen) nicht unterscheiden müssen

-   Akteure

 o Anwender: Manipuliert Objekte im Kompositum nur über Interface

 o Komponente: Interface der Obj. im Kompositum, für Verwaltung der
 Kinder, Standardverhalten für alle Fälle

 o Blatt: Keine Kinder, definiert Verhalten einfacher Objekte

1.  Kompositum: Def. Verhalten für Obj. mit Kindern, verwaltet Kinder,
     Implementiert Verhalten bezogen auf Kinder

<img src="./media/image7.jpeg" width="525" height="164" /

-   Auswirkungen

1.  + Einfache Elemente können beliebig zusammengebaut werden -&gt;
     Rekursive Verschachtelung

 o + Vereinfacht Logik beim Anwender

1.  + Neue Komponenten können einfach def. werden

<!-- --

1.  – Design zu generell

-   Transparenz, Typsicherheit

    1.  Folie 39 – 42?

Dekorierer

-   Dynamische Zuweisung einer weiteren Verantwortung zu einem Objekt

-   Erweitern eines Objekts mit Funktionalität

-   Flexible Alternative zu Objekthierarchien

<!-- --

-   Einhaltung einer flachen Objekthierarchie

-   Leichtgewichtig, Instanzreich

-   Verschachtelung von Obj. zum Hinzufügen von Funktionalität bietet
     mehr Freiheiten als Vererbung

-   Zusatzfunktion bleibt transparent

-   Wenn Ableitung einer Klasse zu komplex ist

-   Akteure

 o Komponente: Interface, das dynamisch erweitert werden sol o Konkrete
 Komponente: Kann dynamisch erweitert werden

 o Dekorierer: Hält Referenz auf Komponente, Implementiert Interface
 der Komp. o Konkreter Dekorierer: Fügt weitere Zuständigkeit zur
 Komponente hinzu

<img src="./media/image8.jpeg" width="594" height="215" /

-   Auswirkungen

 o + Flexibler als Ableitungen (dynamisch, beliebige Kombination,
 mehrfach) o + Einfache, zusammengesteckte Klassen

 o + Vermeidet große, konfigurierbare Klassen

 o – Identität des Dekorierers und der Komponente unterschiedlich

 o – Viele kleine Objekte erschweren das Debuggen bzw. Lernen des
 System

Beobachter

-   Definiere 1-zu-viele Beziehungen zwischen Objekten

-   Benachrichtige/aktualisiere alle abhängigen Obj., wenn ein Obj. den
     Zustand ändert

-   Langlebig

-   Motivation

    1.  **Sicherstellung bzw. Erhaltung der Konsistenz in modularen
         Systemen**

    <!-- --

    1.  **Lose Kopplung**

    <!-- --

    1.  **Sofortige Benachrichtigung bei Änderung des Zustands**

<!-- --

-   Anwendung

    1.  Änderung von Obj. zieht andere Änderungen von anderen Obj.
         unbekannter Zahl nach sich

 o Obj. soll andere benachrichtigen, unabhängig vom Typ

1.  Eine Abstraktion hat mehrere Aspekte, die von einem anderen Aspekt
     derselben Abstraktion abhängen

-   Akteure

    1.  Subjekt: Kennt beliebig viele Beobachter, Interface zur
         Registrierung und Abmeldung von Beobachtern, Abruf von
         aktuellem Zustand

 o Konkretes Subjekt: Speichert für Beobachter interessanten Zustand,
 benachrichtigt Beobachter über Zustandsänderung

 o Beobachter: Schnittstelle zur Benachrichtung bzw. Aktualisierung der
 Objekte

1.  Konkreter Beobachter: Referenz auf konkretes Subjekt, speichert
     Zustand, der konsistent mit Subjekt sein soll, implementiert
     Beobachter zur Aktualisierung des Zustands

<img src="./media/image9.jpeg" width="601" height="200" /

-   Auswirkungen

 o + Nur abstrakte Kopplung zw. Subjekt u. Beobachter über Interface

1.  + Automatische Broad-/Multicast-Kommunikation an interessierte
     Objekte

<!-- --

1.  – Unerwartete Aktualisierung

-   **Arten**

    1.  Push-Modell: Subjekt benachrichtigt Beobachter inklusive
         Information

1.  Pull-Modell: Subjekt benachrichtigt Beobachter exklusive
     Information, Beobachter muss sie selbst holen

<img src="./media/image10.jpeg" width="593" height="221" /

GUI-Coding

Gestaltungsrichtlinien

-   Verwaltungswesen

 o Konkrete Beschreibung einzelner Elemente

1.  Einheitliches Erscheinungsbild (Corporate Identity)

<!-- --

1.  Inhalt: Papierart, -format, Druckart, Schriftart

-   Softwareentwicklung

    1.  Herstellerspezifisch: MS, Google

 o Platfformabhängigkeit

-   Eingabemethode, -genauigkeit, Bildschirmgröße

<!-- --

-   Desktop, Mobile, Web o Typische Vorgaben

-   Ist das die richtige Komponente? -&gt; Link oder Button

-   Design-Konzepte (Aktion) -&gt; Print… oder Print

-   Verwendungsarten (Bedienung, Aussehen) -&gt; Normal, Fokussiert,
     Split Button

-   Richtlinien -&gt; Vorgaben zur Verwendung

-   Größe, Abstände, Farben -&gt; Pixelabstände usw.

-   Beschreibung / Dokumentation -&gt;

 o Inhalt: Fenster, Text, GUI-Komponenten (vgl Blooper)

Testen von Benutzeroberflächen

Motivation und Ziele

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

Manuelles Testen

-   Reale Person testet Programm von Hand

-   Protokoll mit Abfolge von Aktionen

-   Fehler/Erfolg wird protokolliert

-   Vorteile: Erkennung sinnvoller Abweichung, Plausibilitätsprüfung,
     Gutes Aussehen prüfbar, schnell bei einmaliger Ausführung

-   Nachteil: Zeitaufwändig, teuer, keine Wahrnehmung von Details,
     erfüllt Anforderung automatisch nicht

Probleme von automatischen Tests

-   Suchen/Finden/Interkation der Elemente (-&gt; ggf. ID)

-   Überprüfen/Feststellen von Ereignissen

-   Protokollierung von Fehlern

*Vorgehen*

-   -&gt; Robot: Zentrale Komponente jedes GUI-Testtools
     (Benutzeraktionen, Maus-Tastatursteuerung, Screenshots)

-   -&gt; Überprüfung: Vergleich Screenshots, Attribute der GUI-Komp.,
     Direkter Zugriff auf Businessmodell

-   -&gt; Feststellen von Änderungen: Ereignisse (Events), Polling

-   -&gt; Protokollierung: Wie Unit-Tests + Screenshot

Record and Replay

-   Aufzeichung -&gt; Aktionen ausführen -&gt; Tests / Überprüfungen
     definieren

-   Erzeugter Test: Testskript, Grafischer Testablauf

-   Bestandteile

o Schrittweise Anleitung

o Aktion: Pixelkoordinate, Komponente

 o Manuelle eingefügte Überprüfung

1.  Ausgabe im Fehlerfall

-   Testausführung: Ausführung der gespeicherten Schritte,
     Aktionen/Fehler protokollieren

-   Fehlerfall: Informationen sammeln

-   Vorteile: einfach, schnell, wenig Programmieren

-   Nachteil: unübersichtlich, manuelle Wiederverwendung, Redundanz,
     Änderung schwierig

Skriptbasiertes Testen

-   Programmierer erstellt Skript

-   Vorteil: wartbar, zsmfassen versch. Aktionen, Wiederverwendung,
     gleiche Programmiersprache

-   Nachteil: GUI bei Erstellung nicht sichtbar

Automatisiertes Testen

-   Matrix Tests

 o Einsatz: Großer Datenbereich für Eingabe, Kombination versch.
 Eingaben o Ablauf: Auswahl der Parameter, Definition Parawerte -&gt;
 Tabelle

<img src="./media/image11.jpeg" width="249" height="92" /

 o

1.  Vorteil: Viele Kombinationen, Reuktion der Redundanz

<!-- --

1.  Nachteil: Exponentielle Laufzeit

-   Monkey Tests

    1.  Kontrollierter Zufallsgenerator für Aktionen

 o Suche nach Fehlern

 o Aktionsfolge speichern

 o Bei gefundenem Fehler: Aktionsfolge als dauerhaften Test

-   KI

 o Zustände, Aktionen -&gt; Graphensuche für Start- und Endzustand o
 Erzeugung von Testfällen (Graphensuche, EA)

 o Vorteile: Generierung vieler Testfälle, viele Wege zum Ziel testbar
 o Nachteil: Komplexe Definitionen u. Suche

Domain Driven Design

Einführung

Was ist Design?

-   SW beschreibt Ausschnitt aus Realität (Anwendungs-/Problemdomäne)

-   Design beschreibt wie ein Modell die realen Gegebenheiten der
     Prob-Domäne abstrahiert

-   Abbildung von Realität auf Modell

-   Summe aller Entscheidungen, die Einfluss haben, wie ein Problem als
     SW-Lösung modelliert wird

Warum braucht man Design?

-   SW-Entwicklung ist komplex

-   Neben Problemdomäne viele Nebeneinflüsse

-   Auswirkungen von Komplexität begrenzbar, kontrollierbar, nicht
     unnötig verkomplizieren

-   Design mach Komplexität beherrschbar

Software-Komplexität

-   Grad zu welchem das Design / eine Implementierung schwer zu
     verstehen ist

-   Komplexität der Problemdomäne ist gegeben (essential complexity)

    1.  Anforderungen

<!-- --

-   Unfallkomplexität (accidential comp.): notwendiges Übel, möglichst
     verhindern

    1.  Legacy-Systeme, UI, Framework, Persistenz, …

-   Mit Lebensdauer von SW wird mehr Code gelesen als geschrieben

Big Ball of Mud

-   Code, der etwas nützliches macht, aber ohne Erklärung

-   Kein erkennbares Design

-   -&gt; Code schwer wartbar, erweiterbar

Domain Driven Design

Herangehensweise an die Modellierung von SW, die sich auf Problemdomäne
konzentriert

*Grundsätze*

-   Designentscheidungen von Fachlichkeit/Fachlogik der Prob-Domäne
     getrieben, nicht von technischen Details

-   Entwicklung einer Domänensprache (Vokabular)

-   Relevante, fachliche Zusammenhänge der Prob-Domäne in Domänenmodell
     erfassen

*Strategie und Taktik*

-   Strategisch: Verständnis der Domäne, Analysieren, aufdecken,
     abgrenzen, dokumentieren und begreifen der Fachlichkeit

-   Taktisch: Implementierung der Fachlichkeit in Code

Warum ist es wichtig, dass sich die Sprache der Domäne in der Software
befindet?

Strategisches Domain Driven Design

Domäne

-   Abgrenzbares Problemfeld oder best. Einsatzbereich für den Einsatz
     von SW

-   Was soll mit SW gelöst werden? -&gt; Raumfahrt, Logistik, Fertigung,
     …

Domänenmodell

-   Abstraktion, die best. Teile der Domäne beschreibt

-   Erlaubt das Lösen von Problemen innerhalb der Domäne

-   Wie soll ein Problem mit SW gelöst werden?

 <img src="./media/image12.jpeg" width="448" height="233" /

Ubiquitous Language

-   Domänenmodell erfordert Verständnis

-   Weg zum Verständnis der Domäne über Sprache

-   Gemeinsame Sprache zw. Domänenexperten und Entwicklern „Ubiquitous
     Language“

-   Technische Sprache der Entwickler &lt;-&gt; Fachjargon der
     Domänenexperten, eignen sich nicht

-   Kluft im Verständnis -&gt; pflanzt sich in Code fort

-   Ziel der UL: Kluft schließen mit gemeinsamer Sprache (Wichtige
     Konzepte, Zusammenhänge, Mehrdeutigkeiten /
     Unklarheiten beseitigen)

*Wie kommt man zur UL?*

-   Kollaboration zw. Entwicklern / Domänenexperten

-   Iterativer Prozess, mit zuhören und nachfragen, eigenes Wörterbuch
     nur ggf.

Aufteilung der Domäne

Betrachtete Problemdomäne möglichst klein, aufgrund von Komplexität

-   Kerndomäne: Kerngeschäft

-   Unterstützende Domäne: Unterstützt Kerngeschäft

-   Generische Domäne: Nicht Kerngeschäft, z.B. Rechnungen versenden
     (-&gt; ggf. Dritt-SW)

-   Kontext

-   Kontextgrenzen: Wo werden Kontexte aufgebrochen? Und wo sind
     Zusammenhänge? Unabhängig.

<img src="./media/image13.jpeg" width="359" height="219" /

Taktisches Domain Driven Design

Unterstützt bei Entwurf von Modellen, die Komplexität beherrschbar
machen, durch Katalog von Entwurfsmustern

Übersicht

-   Entities, Value Objects, Domain Services, Aggregates

    1.  Kern des Modells, Großteil der Geschäftslogik, Forcieren die in
         der Domäne geltenden Invarianten und machen diese sichtbar

<!-- --

-   Repositories, Factories

    1.  Kapseln der Logik fürs Persistieren/Erzeugen von Entities, Value
         Objects und Aggregates, Freihalten von Acc.Komplexität

-   Modules:

    1.  Strukturierung/Kapselung verwandter Domänenobj. Innerhalb des
         Modells, fördern geringe Koppelung & hohe Kohäsion

<img src="./media/image14.jpeg" width="387" height="210" /

Value Objects

-   Objekte ohne eigene Identität

-   Unveränderlich

    1.  Gültige Konstruktion -&gt; immer gültig (Invarianten einhalten)

    <!-- --

    1.  Frei von Seiteneffekten

<!-- --

-   Wird nur durch Werte beschrieben

-   2 VO sind gleich, wenn Werte gleich (equals, hashCode überschreiben)

-   Oft Ganzheitliches Konzept

    1.  Gewicht: Zahl + Einheit

 o Geld: Betrag + Währung

1.  Adresse: Straße + PLZ + Stadt

-   Beschreiben, begrenzen oder messen Sache näher

*Vorteile*

-   Kapseln Verhalten/Regeln

-   Unveränderlich

-   Selbst-validierend

-   Leicht testbar

-   Verbessern Deutlichkeit/Verständlichkeit durch Modellierung von
     fachlichen Domänenkonzepten

*Implementierung*

-   Klasse: final

-   Felder: blank final

-   Nach Konstruktion gültig, ansonsten muss Konstruktion fehlschlagen

-   Keine Setter

-   Rückgabewerte sind unveränderlich oder defensive Kopien

*Persistierung*

-   Eingebettet in Tabelle des Elternobjekts: JPA-Embeddable, jedes Feld
     eine Spalte o Vorteile: Einfach, erlaubt Queries über Elemente des
     VO

 o Nachteil: Ggf. Denormalisierung, nur 1:1-Beziehungen

-   Serialisierung: Objekt in einer Spalte, Converter

 o Vorteile: Komplexe Bez. mög., 1:n-Bez. mög. (Listen, Sets)

1.  Nachteil: unlesbar, Queries über VO nicht möglich, aufwändiger

-   In eigener Tabelle (als DB-Entity): Entität auf DB-Ebene, mit ID,
     muss versteckt werden

    1.  Vorteil: einfach, Normalisierung mög., Queries über VO
         mög., 1:n-Bez. Mög.

1.  Nachteil: Verschleiert Natur von VO durch ID, Gefahr, dass mehrere
     Entities gleich VO nutzen

Entities

*Unterschiede zu VO*

-   Haben eindeutige ID

-   Verschieden, wenn unterschiedliche ID

<!-- --

-   Hat Lebenszyklus, verändert sich dabei

*Allgemeine Regeln für Entities*

-   Invarianten forcieren: Konstruktion nur mit gültigen Werten, kein
     Verändern in ungültigen Zustand

-   Möglichst viel Verhalten in VO auslagern

-   Die öffentlichen Methoden sollten Verhalten beschreiben
     (nicht Getter/Setter)

-   equals/hashCode: Definition von Gleichheit vom Anwendungsfall
     abhängig

*Strategien für einzigartige Identitäten*

-   Natürliche Schlüssel: Kursname, KFZ-Kennzeichen,
     Personalausweisnummer o Vorteil: aussagekräfig, keine Duplikate
     wenn global eindeutig

 o Nachteil: Fremdbestimmt (ändert sich vielleicht?), ggf. nicht global
 eindeutig

-   Surrogatschlüssel: Selbst generiert

1.  Universally Unique Identifier (UUID)

    -   Vorteil: jederzeit generierbar, anwendungsübergreifend eindeutig

    -   Nachteil: nicht sprechend, Performance

<!-- --

1.  Inkrementeller Zähler

    -   Vorteil: eigenständig, unabhängige ID-Generierung, ID steht
         sofort fest

    -   Nachteil: Nicht sprechend, Zähler muss gespeichert werden

    1.  String-Format basierend auf Entity-Eigenschaften

        -   Vorteil: Sprechend, jederzeit generierbar

        -   Nachteil: hoher Aufwand, falls sich Werte ändern

-   Surrogatschlüssel vom Perstistence-Provider

    1.  Vorteil: ID eindeutig, kein Aufwand

o Nachteil: nicht sprechend, muss erst durch ORM laufen, abhängig von
ORM und DB

*Wahl der Strategie*

-   Selbst verwaltet: Early ID Generation, reduziert Abhängigkeit,
     erleichtert Komm., wirklich eindeutig?, erleichtert Tests

-   Fremdverwaltet: Late ID Generation, erschwert Tests, wenig
     Eigenverantwortung, funktionierender Standard-Weg

Domain-Service

-   Kleiner Helfer innerhalb des Domänenmodells

-   Wenn ein best. Verhalten / Regel weder VO noch Entity zugeordnet
     werden kann

-   Beispiele: Berechnung Zahlungsmoral des Kunden (Entities: Kunde,
     Rechnungen, Kontenbewegungen)

*Vertrag*

-   Domäne kann auf ext. Unterstützung angewiesen sein

-   Innerhalb Domäne: Domain Service als Vertrag (Interface)

-   Außerhalb Domäne: Dienstleister (Infrastruktur-Schicht) kann Vertrag
     implementieren und benötige Funktionen bereitstellen

*Eigenschaften*

-   Erfüllt Funktion, die nicht in Entity oder VO modelliert werden kann

-   Operiert ausschließlich mit anderen Elementen des Modells

-   Verkörpern Konzepte der UL

-   Statuslos

Aggregate

-   Entstehen von großen Objektgraphen mit bidirektionalen
     Abhängigkeiten

-   Nachteil: Performance, Kollisionen, Verletzen von Invarianten

-   Technische Lösung: Locking-Modi, Lazy/Eager Loading

-   Domänen-Lösung: Aggregate

-   Gruppen Entities und VO zu Einheiten

-   Aggregat hat Root Entitiy (Aggregate Root): Über dieses erfolgt
     Zugriff auf Teile der Aggregate

-   Reduzieren Komplexität beim Verwalten von Obj.

-   Erleichtern Handhabung von TAs

-   Reduzieren die Möglichkeit Invarianten zu verletzen

-   Möglichkeiten:

 o Einschränkung der Assoziationsrichtung o Ersetzen von
 Objektreferenzen durch IDs

<img src="./media/image15.jpeg" width="538" height="135" /

*Ersetzen von Objektreferenten durch IDs*

-   Entspricht der Abbildung in einer relationalen DB (Foreign Key)

-   Nachteile

 o DB über OR-Mapper erzeugt? -&gt; keine Fremdschlüssel mehr

1.  Weitere Abfragen nötig, um bspw. aufs AddressBook eines Cusomers
     zuzugreifen

<!-- --

1.  -&gt; Mehr Verantwortung

-   Vorteile

    1.  Schlankere Objektgrapgen

 o Zuständigkeiten klarer getrennt

 o Aggregate bilden bzgl. TAs eine Unit of Work o -&gt; Mehr Kontrolle

*Aggregate Root*

-   Alle Zugriffe auf innere Elemente nur über AR

-   Referenzen von außen auf innere Elemente nicht erlaubt

-   Daher: Zentrale Stelle zur Einhaltung von Invarianten (Bsp:
     Maximale Bestellpositonen)

-   AR sollte nur defensive Kopien ausliefern

*Transaktionsgrenzen, Repostitory*

-   Aggregates werden als Einheit verwaltet (create, read, …)

-   Jede Entity gehört zu einem Aggregate

<!-- --

-   Repository: Arbeiten mit Aggregates und kann dieses komplett
     innerhalb einer TA lesen / schreiben

-   Aggregates bilden natürliche Transaktionsgrenzen

*Zusammenfassung*

-   Entities und VO zu Aggregates zusammen

-   Werden als Einheit betrachtet (create, read, update, …)

-   Forcieren/Visualisieren Transaktionsgrenzen

-   Forcieren Invarianten

-   Persistenz-Frage muss getroffen werden (Nachteile)

Repositories

-   Vermitteln zw. Domäne und Datenmodell

-   Stellen Domäne Methoden bereit: Lesen etc. von Aggregates aus
     Persistenzspeicher

-   Konkreter Zugriff wird vom Repository verborgen

-   Domäne von technischen Details unbeinflusst

-   Eigenschaften:

 o Repositories arbeiten ausschließlich mit Aggregates (1:1-Bez)

 o Ähnelt Domain-Service (definiert Vertrag, der in technischer Schicht
 impl. wird) o Aussagekräftige Schnittstelle

 o Ggf. Erzeugung von IDs

 o Kann Prüffelder setzen (LastUpdatedAt)

1.  Kann allg. Infos bieten: Zusammenfassung

-   Implementierung in technischer Schicht, nicht in Domänenmodell

Factories

-   Ggf. Logik für Erzeugen komplex -&gt; Factory

-   Erzeugen von Objekten

-   Allgemein: Irgendein Objekt/Methode zur Erzeugung anderer Obj. als
     Kontruktorersatz

-   Speziell:

 o Factory Method

 o Abstract Factory

Modules

-   Zur Strukturierung/Kapselung verwandter Komponenten

-   Abbildung über Namespaces, Packages

-   Gruppierung nach fachlichen, nicht technischen, Gesichtspunkten

-   Ziel: Zusammengehörende Komponenten gruppieren (hohe Kohäsion,
     geringe Kopplung zw. Modulen)

-   Vorteile: Sichtbarkeit, Abhängigkeiten

Onion-Architecture

Klassisch

-   Presentation – Business – Infrastructure

-   Schicht darf nur mit unterliegenden Schichten kommunizieren

-   Strikt: nur nächstniedrigere, Offen: Beliebige Schicht

-   Vorteile

 o Beherrschung der Komplexität durch technische Trennung der Anwendung
 o Geringe Kopplung je Schicht, hohe Kohäsion je Schicht

 o Einzelne Schichten leichter / unabhängiger änderbar

Dependency Inversion Principle

*Motivation*

-   Repositories ist Teil der Domänenschicht (-&gt; Businessschicht)

-   Konkreter Zugriff gehört aber in die Infrastrukturschicht

-   Domänenschicht soll frei von technischen Details bleiben

-   Implementierung eines Repos nicht in Domänenschicht

-   Repo gehört konzeptionell zur Domänenschicht, daher nicht
     Infrastrukturschicht

*Definition*

-   Domänenschicht gibt durch Interface einen Vertrag (beschreibt,
     welches Verhalten sie erwartet)

-   Konkrete Impl. erfolgt in Infrastrukturschicht

-   Domäne nicht abhängig von Details (HibernatePersonRepo), sondern von
     Abstraktionen (PersonRepo)

-   Konkrete Impl. kann dann gewählt werden, bspw. durch Dependency
     Injection

*Umschichtung*

-   Infrastrukturschicht ist nun abhängig von Domänenschicht

-   Verletzt Regel der Kommunikation

-   -&gt; Verschieben der Infrastrukturschicht

-   Infrastrukurschicht ganz oben

-   Darf nun konkrete Verträge für alle anderen Schichten implementieren

-   Präsentationsschicht kann als Teil der Infra-Schicht betrachtet
     werden

-   Domänenschicht nun ganz unten, von keinem abhängig -&gt; Kern der
     Architektur

<img src="./media/image16.jpeg" width="297" height="152" /

Onion-Architecture

Hauptmerkmale

-   Alle Abhängigkeiten von außen nach innen

-   Infrastruktur-Schicht: Technische Details

-   Innere Schichten: Frei von technischen Details, UI-Änderungen egal

Domain Layer

-   Kernobj., Regeln der Fachlogik (Domänenmodell mit Entities etc.)

-   Definiert Verträge (Abstraktionen: Repositories, Logging etc.)

Application Service Layer

-   Wenn mehr als Domänenobj. Involviert ist

-   -&gt; Implementierung als Application Service

-   API für Infrastrukturschicht

<!-- --

-   Isolationsschicht zw. Domäne und Infrastruktur

-   Infra-Schicht weniger anfällig für Änderung in Domäne

*Aufgaben*

-   Implementierung eines Anwendungsfalls

    1.  Ein AS -&gt; ein oder mehrere Anwendungsfälle

    <!-- --

    1.  Nutzt Komponenten der Domäne

    <!-- --

    1.  Enthält keine Regeln, weiß nur, welche Domänenobj. in welcher
         Reihenfolge aufgerufen werden müssen

    <!-- --

    1.  Eher prozedural

    <!-- --

    1.  Keine Create/Update-Methoden -&gt; Konkrete Methoden

<!-- --

-   Validierung, Übersetzung / Aufbereitung von Eingaben/Ausgaben

    1.  Alle Eingaben korrekt / vorhanden?

    <!-- --

    1.  Keine Regeln der Domäne, sondern technische (Datentyp,
         -format etc.)

    <!-- --

    1.  Übersetzung der Eingaben in Domänenobjekte, ggf. der Ausgabe

<!-- --

-   TA-Verwaltung

    1.  AS als TA, nicht Domänenobjekte

-   Reporting

    1.  Kann Daten aggregieren (Umsätze, Lagerbestände)

    <!-- --

    1.  In Domänenschicht wäre dies teuer -&gt; Datensätze zu Objekte

    <!-- --

    1.  Vertrag erlaubt direkte Zugriff auf Daten

<!-- --

-   Security

    1.  Anwendungsfall durch Zugriffskontrolle sichern

*Wie stark soll die Domäne von der Außenschicht abgeschottet sein?*

-   Objekte dürfen ASL passieren?

-   Isolierung bietet Schutz vor ungewollten Veränderungen

-   Erhöht Komplexität, zusätzliches Mapping, Indirektion

-   Aufwand muss gerechtfertigt sein

Infrastructure Layer

-   Technische Details

-   Beispiele: UI, Web Services, DB

Kritik

-   FW wird isoliert

-   Höhere Komplexität (nicht überall benötigt)

-   Mehr Aufwand durch Zwischencode und Isolation

-   Architektur ist von Testbarkeit getrieben, nicht von Nutzen

DevOps

Was ist DevOps?

Defintion

-   Development Operations, Bewegung

-   Ziel: Reduzierung der Time-To-Market einer Änderungseinheit - bei
     gleichzeitiger Gewährleistung hoher Qualität

-   Erreichen durch: Konsequente Anwendung von Lean-Prinzipien auf
     gesamten SW-Wertstrom

Warum DevOps?

-   Entwickler sollen Veränderungen schnell umsetzen

-   Admins sollen Sicherheit/Stabilität der Systeme gewährtleisten

-   -&gt; Zielkonflikt, Silo-Denken (starkes Abteilungsdenken),
     Stereotypen, Mauer zw. Dev und Ops

-   -&gt; Agile Methoden erhöhen Dev-Geschw. -&gt; Mehr Druck auf Ops

Conway’s Law

Teams, die nicht gut zusammenarbeiten produzieren Lösungen, die nicht
gut zusammenarbeiten

Konsequenzen von Silodenken

-   Mehr/Längere Systemausfälle

-   Mehr Fehler

-   Höheres Risiko

-   Angst vor Veränderung

-   Längere Time-To-Market, schlechtere Qualität

-   Wertstrom stoppt an der Mauer zu Operations

-   Viel Zeit geht verloren (Verschwendung) – Features fertig, aber
     nicht produktiv verfügbar

Folie 18? 26?

DevOps-Prinzipien – CALMS

Culture

*Ziel*

-   Hauptziel von DevOps: Veränderung der Organisationskultur

-   Silos zu Kollaboration

-   Schuldzuweisung zu gemeinsamer Verantwortung

-   Für die erstellten Produkte/Leistungen und Prozesse

*Definition von Organisationskultur*

-   Abstraktes, komplexes Konzept, schwer messbar

-   Glaubenssätze, Haltungen, welche ein Kontext für alles in der
     Organistation bilden

-   Hat Einfluss auf Erreichen der Ziele

*Kulturmerkmale von DevOps*

-   Respekt

-   Vertrauen

-   No-Blame

-   Growth Mindset

-   Gemeinsame Anreize

-   Kollaboration

*Blame-Kultur – No-Blame-Kultur*

-   Nicht Individuen, sondern Situationen führen zu Fehlern

-   Suche nach Ursachen statt nach einem Sündenbock

-   Blame Kultur: Fehler werden verschleiert (Verschwendung)

*5-Why-Methode*

-   Methode zur Bestimmung von Ursache und Wirkung

-   So lange „Warum“ fragen bis Ursache klar ist

*Fixed Mindset vs. Growth Mindset*

-   Fixed: Fähigkeiten sind gegeben, Fehler sind Resultat ungenügender
     Fähigkeiten, Tendenz sich nicht blamieren zu wollen

-   Growth: Fähigkeiten können verbessert werden, Fehler sind
     Gelegenheit zu verbessern, Tendenz nach Rückschlägen
     weiterzuarbeiten

*Gemeinsame Anreize*

Team wird belohnt, bei Lieferung von Wert für Kunden, gemeinsame
Verbesserung des Flusses von Wert zum Kunden

*Kollaboration*

-   Abhängig vom Unternehmen

-   Beispiel: Bereichsübergreifende Teams, Austausch von Experten etc.

Automation

*Automatisierung*

-   Wesentliches Hilfsmittel zur Optimierung des Wertstroms

-   Durch: Eliminierung von Verschwendung und Einführung eines def.
     Arbeitsablaufs

-   Wichtig ist, zu wissen, wann es sich lohnt zu automatisieren und
     wann nicht

*Automatisierungsstufen*

1.  Automatisierte Entwicklungsumgebung (Setup, build, test, check)

2.  Continuous Integration

    -   Automatisierter Bauvorgang aller Artefakte (deliverables)

    -   Automatisierte Tests

    -   Automatisierte Code-Analyse

    -   **SW kann immer gebaut werden und erfüllt gewisse
         Qualitätskriterien**

3.  Continuous Delivery: CI + Staging

    -   Automatisierte Installation/Konfiguration der Zielumgebungen

    -   Automatisierte Akzeptanz- und Kapazitätstests

    -   Automatisiertes Deployment in Testumgebungen

    -   ABER: **Manuelles Auslösen des Deployments in Produktion, SW
         könnte jederzeit** **deployed werden**

4.  Continuous Deployment : CD + Automatisches Deployment

    -   Änderung alle Stages erfolgreich durchlaufen? -&gt; automatisch
         deployed

*DevOps und Automatisierung*

-   Ziel ist nicht die Automatisierung des Wertstroms

-   Bereichsübergreifende Automatisierung zwischen Entwicklung und
     Produktivbetrieb -&gt; Zusammenarbeit bzgl. Installation und
     Konfiguration der Zielumgebungen

-   Lösung: Infrastructure as Code

*Infrastructure as Code*

-   Infrastruktur wie SW behandeln

-   Anweisungen für das Aufsetzen der Umgebungen -&gt; Teil des
     Quellcodes

-   Änderung an Infrastruktur -&gt; Änderung an Quellcode

-   Keine Blaupause für ein Unternehmen -&gt; Angepasst an Abläufe,
     Rechenzentren etc.

-   Beispiele: Ansible, Chef

*Vorteile von Infrastructure as Code*

-   Keine Shadow-IT

<!-- --

-   Erhöhung der Effizienz

-   Infrastruktur wird mit Code kontinuierlich getestet/verwaltet

-   Änderungen an Infrastruktur werden versioniert

-   Zusammenarbeit von Dev und Ops wird forciert

*Wann lohnt sich Automatisierung?*

-   Wenn im relevanten Maß Zeit gespart wird: Legacy-Systeme einzubinden
     kostet viel Zeit

-   Zeitinvestitionen sind nicht immer vergleichbar (Rollback-Script
     versus Change Log)

-   Zeitersparnis kann auch anderen zugutekommen und multipliziert sich
     dann

*Automatisierungs-Paradoxon*

Je höher der Grad der Automatisierung, umso kompetenter der Verwalter

*Automatisierungs-Ironie*

Grundlagen des Prozesses werden verlernt, Problem: Fehlerfall

Lean

*Was ist Lean?*

-   Philosophie

-   Ziel: Kontinuierliche Verbesserung eines Prozesses

-   Durch: Eliminierung von Verschwendung, Bedürfnisse der Kunden sind
     Ausgangspunkt allen Handelns

*Verschwendungen*

-   Muda: Menschliche Aktivität, die Ressourcen verbraucht, aber keinen
     Wert erzeugt

    1.  Bsp: Materialbewegung, Bestände, Wartezeit, Überproduktion,
         Korrekturen/Fehler

<!-- --

-   Mura: Unausgeglichenheit, Unausgewogenheit, Inkonsistenz

-   Muri: Überlastung von Menschen/Maschinen

*Lean-Prinzipien*

1.  Zu produzierenden Wert aus Sicht des Kunden definieren

    -   Wert: Leistung, die den Anforderungen des Kunden hinsichtlich
         Qualität, Verfügbarkeit, Preis entspricht ( was der Kunde
         kauft )

2.  Wertstrom identifizieren

    -   Alle nicht wertschöpfenden und wertschöpfenden Aktivitäten, die
         notwendig sind, um ein Produkt/DL herzustellen/anzubieten

    -   Ziel des Wertstroms: Kunden zufriedenstellen

    -   Jeder Wertstrom umfasst 1 oder mehrere Geschäftsprozesse

    -   Unterscheidung nach

        1.  Wertschöpfender Tätigkeit

        2.  Nicht wertschöpfende Tätigkeit, die unvermeidbar ist

        3.  Nicht wertschöpfende Tätigkeit, die vermeidbar
             ist (Verschwendung)

    -   Dient insb. der Aufdeckung von Verschwendung

    -   Forciert ganzheitliche Betrachtung aller am Wertstrom
         beteiligten Prozesse

    -   Trägt bei zu Siloübergreifende Optimierung des Gesamtprozesses

Beispiel für einen Wertstrom

<img src="./media/image17.jpeg" width="400" height="162" /

1.  Fluss-Prinzip umsetzen

    -   Produkt/Leistung soll zum Kunden fließen, möglichst:

        1.  Kontinuierlich

        2.  Mit wenigen Wartezeiten / Umwegen

        3.  Über alle Abteilungen/Stationen hinweg

        4.  In kleinen Änderungseinheiten (z.B. Features)

            1.  Geringere Mean Time To Repair

            2.  Geringere Time To Market

    -   Erreicht durch Beseitigung der identifizierten Verschwendung

2.  Pull-Prinzip einführen

    -   Nur produzieren, was der Kunde und wann er es will

3.  Perfektion anstreben

    -   4 Schritte werden kontinuierlich gemessen und hinterfragt

    -   -&gt; Verbesserungspotentiale

    -   Ziel: Jede Tätigkeit/jedes Gut trägt zum Wert für den Kunden bei

Metrics

*Intention: DevOps messen*

-   Messen damit kontinuierlich verbessert werden kann

-   Klassische Metriken für SW-Entwicklung

-   Metriken, die die Leistungsfähigkeit des gesamten Wertstroms
     aufdecken

*Klassische SW-Metriken*

-   Lines of Code, Zyklomatische Komplexität, Testabdeckung, Stil

*Klassische Ops-Metriken*

-   Uptime, Antwortzeiten, Ressourcen-Auslastung

*DevOps-Metriken*

|                                            |                                            |     |
|--------------------------------------------|--------------------------------------------|-----|
| •                                          | Betreffen gesamten Wertstrom               |     |
|                                            |                                            |
| **Durchsatz**                              | **Stabilität**                             |
| Häufigkeit von Deployments in Produktion   | Mittlere Reparaturzeit                     |
| Änderungs-Durchlaufzeit                    | Fehlerrate in Produktion                   |
| •                                          | Häufigkeit von Deployments in Produktion   |     |

1.  Einfach messbar, ggf. Unterscheidung in erfolgreich / nicht
     erfolgreich

-   Änderungs-Durchlaufzeit „Change Lead Time“

    1.  Zeit von Änderungseinheit von Beginn der Arbeit bis zum
         Deployment in Produktion

    <!-- --

    1.  Frage: Wann beginnt Arbeit? -&gt; Erfassen der Änderungseinheit

    <!-- --

    1.  = Time To Market

    <!-- --

    1.  Zykluszeit: Ab Beginn der Entwicklung bis Ende der Entwicklung

<!-- --

-   Mittlere Reperaturzeit –Mean Time To Repair (MTTR)

    1.  Zeit zw. Feststellung eines Fehlers in Produktion und dessen
         Beseitigung

    <!-- --

    1.  Z.B. Durchlaufzeit von Issues „Bug“

<!-- --

-   Fehlerrate in Produktion „Change Failure Rate“

    1.  Zahl der Bugs in Produktion

 o Einfach messbar, ggf. unterscheidbar nach Schwere, Messung von
 Reaktionszeit

*Zusammenhang zwischen Durchsatz und Stabilität*

TODO

Share

-   Verantwortung, Ziele, Information, Wissen, Code und Tools, …

-   Know-How: Verstehen von Ebenen überhalb und unterhalb der eigenen
     Ebene

Kritik

-   Sicherheit/Stabilität manchmal wichtiger als Geschwindigkeit, wird
     vernachlässigt

-   Ggf. Architektur ungeeignet

-   Ggf. Anforderung ungeeignet

Fazit

-   Abhängig von Organisation, Kultur, Softwareausstattung

-   Beginnen mit schneller Auslieferung ohne Qualitätseinbußen

-   Herausfinden, wo DevOps Sinn macht: Wo Geschwindigkeit wichtig ist

-   Mehr als IT-Methode: Unternehmensweite Transformation

-   Kann Produktivität und Markteinführungszeiten von SW verbessern

Ausblick

-   DevSec: Sicherheit in den Prozessen verankern

-   Bimodale IT: Zwei Arten von IT, traditionell (Tagesgeschäft) und
     agil (Innovation)

Continuous Delivery

Definition

-   Vorgehensweise: soll sicherstellen, dass

 o SW immer in einem auslieferbaren Zustand ist

1.  Und automatisiert ausgeliefert (deployed) werden kann

-   Durch: Einführung einer hochautomatisierten
     Deployment-Pipeline (Lean-orientiert)

Antipatterns

-   Manuelles Deployment in Produktion

-   Entwicklung/Tests nicht in produktivähnlicher Umgebung

-   Manuelle Verwaltung der Konfiguration

-   Manuelle Tests

Release versus Deploy

-   Release: Version einer SW, die für Veröffentlichung außerhalb der
     Entwicklung geplant ist

-   release: Version einer SW wird einer best. Nutzergruppe zur
     Verfügung gestellt

-   Release-Kandidat: Jeder Stand einer SW, der als Release infrage
     kommt (CD -&gt; jede Version)

-   Deploy: Installation und Konfiguration einer Anw. in einer
     Zielumgebung

Prinzipien

-   Wiederholbarer, verlässlicher Auslieferungsprozess

-   Möglichst hohe Automatisierung

-   Versioniere alles

-   Wenn es wehtut -&gt; mach es häufiger (Identifizierung)

-   Hohe Qualität

-   Fertig heißt deployed (min. auf Testsys.)

-   Jeder ist für Auslieferungsprozess verantwortlich (DevOps)

-   Kontinuierliche Verbesserung des Prozesses

Deployment-Pipeline

-   Code durchläuft mehrere Phasen (Stages)

-   Jede Phase ist ein Quality Gate

-   Mit jeder Phase: Vertrauen in Funktion/Deploybarkeit steigt,
     Feedback-Geschwindigkeit sinkt

-   Beispiel: Commit Stage -&gt; Akzeptanztest -&gt; Kapazitätstest
     -&gt; Manuelle Tests -&gt; Release

Bezug zu Lean Manufacturing?

Richtlinien

-   Artefakte (Deliverables) werden in Commit-Phase genau einmal gebaut

-   Gleiche Deployment-Strategie u. Tools für alle Zielumgebunne

-   Nach Deployment: Smoke-Tests

-   Alle Tests in produktionsähnlicher Umgebung

-   Jede Änderung sofort durch Pipeline

-   Fehler? -&gt; Pipeline stoppen

-   Jeder Build -&gt; Schlägt fehl oder Release-Candidate

Commit-Phase

*Aufgaben*

-   Kompilieren, Interne Release-Nummer erzeugen

-   Automatisierte Tests

-   Automatisierte statische Analyse

-   Erzeugung aller Artefakte für spätere Phasen (Doku, Testdaten) o
     -&gt; Artefakt-Repository

*Artefakt-Repository*

-   Speichert alle erzeugten Artefakte

-   Spätere Phase: über ID auf Artefakt zugreifen

-   Verzeichnusstruktur auf Fileserver oft ausreichend

-   -&gt; Backup, aufräumen

Akzeptanztest-Phase

*Aufgaben*

-   Zielumgebungen aufsetzen

-   Deployment der Artefakte in Zielumgebungen

-   Ausführen der Tests: Akzeptanz und Smoke

*Smoke-Tests*

-   Testet grundsätzliche Funktion vor Detailprüfung

-   Beispiel: Request gg. Anwendung

*Verteilung von Tests*

-   Autom. Akz.-Tests teuer in Erstellung/Unterhaltung

-   Wenn, dann: „Happy Path“ testen

<img src="./media/image18.jpeg" width="350" height="192" /

Weitere Test-Phasen

-   Exploratory Testing

-   User Acceptance Tests

-   Lasttests

-   Sicherheitstests

Deployment-Antipatterns

-   Doku statt Autom.

-   Untersch. Tools für untersch. Umgebungen

-   Manuelle Rollbacks

-   Manuelle Änderungen an Produktivumgebung

Deployment-Bestpractices

-   Automatisierter Rollback-Plan

-   Blue-Green-Deployment

-   Canary Releases

-   Feature Toggles

-   Parallel Code Paths

<img src="./media/image19.jpeg" width="254" height="149" /

Blue-Green-Deployment

-   Zwei identische Produktivumgebungen (doppelte Kosten)

-   Eine ist produktiv, andere ist Staging-Umgebung

-   Erlaubt schneller Rollback

Canary-Releases

-   Beide Version gleichzeitig in Betrieb

-   Schritt für Schritt User umleiten

-   + Last kann langsam erhöht werden, + schnelles Rollback

-   - Höhere Kosten für Infra., - Routing komplex

Features Toggles

-   Schalter, um best. Funktionen zu aktivieren

-   Möglich, wenn alle im Main-Branch arbeiten

-   - unübersichtlich

-   -&gt; Features in kleine Einheiten aufteilen

Parallel Code Paths

-   Alter/neuer Code parallel ausführen

-   Ergebnisse vergleichen -&gt; Abweichung loggen

-   Keine Abweichung -&gt; Alten Code entfernen

-   + Prüfen von Refactoring

CD-Tools

-   Infrastructure as Code-Tools

-   Virtualisierung (docker)

-   Build-Tools (maven)

-   Dependency-Management (maven)

-   Dependency-Tools (capistrano)

Schritte zur Deployment-Pipeline

-   Wertstrom identifizieren

-   Walking Skeleton erstellen

-   Build, Deployment autom.

-   Unit Tests / Code Analyse autom.

-   Akzeptanztests autom.

-   Releases autom.

Vorteile

-   Weniger Risiko durch häufige Deployments

-   Schnelles Feedback

-   Mehr Vertrauen / Sicherheit in Funktionsfähigkeit

-   Schnelle, wiederholbare Prozesse statt Doku

-   Forciert Zusammenarbeit

Nachteile

-   Große Umstellung

-   Hoher Initialaufwand

-   Ggf. hohe Kosten (Akzeptanztests, HW, …)

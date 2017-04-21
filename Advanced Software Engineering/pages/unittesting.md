## Unit-Testing
### Fehler
- Fehlerursachen: Falsche Einschätzung von Risiken, Fehlende Tests
- Fehler kosten Ressourcen
- Kosten steigen mit der Zeit
### Tests
- Verpflichtung zum Testen
- Tests schützen bestehende Funktionen
- Orientierungshilfe und Dokumentation
- Neuere Entwicklungsmethoden: Test First, Test Driven Development
- Nutzen statt Aufwand
- Tests unterscheiden zwischen zufälliger und gewollter Funktionalität
### Testarten
- Akzeptanztest
  - **Test des kompletten Systems**
  - Realistische Umgebung, Steuerung durch Mittel des Benutzers, Absegnung durch Auftraggeber
  - **Ziel**: Echte Benutzerszenarien
- Integrationstest
  - Nur relevante Teile des Systems werden gestartet
  - Stellvertreter für nicht relevante Teile
  - Testframework
  - **Zusammenspiel der Komponenten sichern**
- Komponententest
  - Nur relevanter Teil des Systems wird gestartet
  - Alle anderen Teile durch Stellvertreter ersetzen
  - Testframework
  - **Funktionalität einzelner Komponenten sicherstellen**
- Performancetest

### Was ist eine Komponente?
- Meist Klasse
- Ersetzen der Abhängigkeiten durch Stellvertreter „Mocks“
- Mock: Minimale notwendige Funktionalität
### xUnit-Testframework
- Vorlage für Unit-Tests
- Trennung zwischen Test- und Produktivcode
- Für fast alle Sprachen existiert Implementierung
### Aufbau eines Tests
- Arrange: Initialisieren der Testumgebung (String def.)
- Act: Ausführen des zu testenden Codes (Lowercase String)
- Assert: Überprüfen des Ergebnisses (Is der String lowercase?)
### JUnit
- Quasi-Standard in der Java-Entwicklung
### Überprüfungen
- asserts
  - Überprüfung auf Gleichheit, Referenz, Wahrheit, Null
  - assertEquals("blub", result);
- Matcher
  - Möglichkeit, um weitere Überprüfungen hinzuzufügen
  - Bestehen aus:
    - Überprüfung eines Wertes mit einem erwarteten Wert
    - Beschreibung, welcher Wert erwartet wird („start at...“)
    - Beschreibung, welcher Wert überprüft wurde („started at...“)
  - Zahlen auf größer/kleiner, von Objekten auf Gleichheit, von Listen und ähnlichem
  - assertThat(list, contains(„element“));
  - Können verschachtelt werden
  - assertThat(number, is(lessThan(0)));

|Vorteile | Nachteile|
|---------|----------|
|Verbessern die Lesbarkeit des Tests |Implementierung braucht Zeit|
|Sprechendere Fehlermeldungen ||
|Wiederverwendbarkeit |  |

### Exceptions und Spezialfälle
- Exceptions:
  - Gewisse Exceptions können ebenfalls erwartet werden (Annotation möglich, oder
    Assert)
- Gleitkommazahlen lassen sich nicht exakt überprüfen
  - Genauigkeit kann angegeben werden
  - assertThat(value, closeTo(1.0d, 1E-2))
- Arithmetische Spezialfälle
  - Ganzzahlen kennen keinen Overflow
  - Kleinster Wert von Datentypen haben unterschiedliche Semantik
  - Double kennt kein DivisionByZero
### Ergebnis eines Tests
- Success
  - Testmethode erfolgreich durchlaufen
  - Keine Assertion fehlgeschlagen
- Failure
  - Assertion ist fehlgeschlagen
- Error
  - Unerwarteter Fehler
### Eigenschaften guter Tests – ATRIP
#### Automatic
  - Minimale Anforderung bei der Ausführungo
  - Einfach ausführbar (1 Knopf), automatisch (kein Input), selbst-überprüfbar
  (bestanden/fehlgeschlagen)
#### Thorough (Vollständig)
  - Alles Notwendig überprüfen
  - Iteratives Vorgehen (bei Fehler ergänzen)
  - VFehler klumpen: Bei Fehler auch Umgebung testen
#### Repeatable
- Beliebig wiederholbar -> gleiches Ergebnis
  - Plattform, Zeit, Zufall, Multithreading kritisch
- Tests, die ohne Änderungen fehlschlagen -> Fehlerhafte Tests

> Zufall muss gesteuert werden. Statt random() feste Zahl wählen.

#### Independent
- Keine Abhängigkeit zu anderen Tests (keine Reihenfolge)
- Tests sollen auf Aufgabe fokussiert sein
#### Professional
- Tests sollen qualitative hochwertig sein (kein Doppelcode etc.)
- Keine unnötigen Tests
- Teil der Dokumentation
### Mock-Objekte
#### Verhalten im Test
- Reduzieren Abhängigkeit zu anderen Komponenten
- Stellvertreter für Objekte
- Mocks können manuell erstellt werden (Großer Aufwand) oder durch Mocking-Frameworks
- Arrange: Konfiguration der Mocks
- Act: Verwendun der Mocks
- Assert: Überprüfen der Mocks
- Beispiel: HW-Gerät verlangsamt Test, HW soll nicht getestet werden -> Mockup durch
  Interface abilden
#### Schwierigkeiten
- Verwendung von statischen Methoden (-> Dependency Injection)
- Tiefe Abhängigkeiten erschweren Mocking (-> Lose Kopplung)
- Vorsicht vor Testen von reinem Mock-Verhalten?
### Code Coverage
- Tests testen
  - Testabdeckung
  - Temporäre Probleme einbauen
  - SW, die Produktivcode ändert (Mutation Testing)
- Coverage: Wie viel Code wurde während Test durchlaufen?
- Branch Coverage: Misst die Anzahl der durchlaufenen Pfade (if, else etc.)
- Line Coverage: Misst die Anzahl der durchlaufenen Quellcode-Zeilen
- Branch/Line -> unterschiedliche Aussagekraft, keine Aussage über Funktion, deuten auf
potentiell problematische Bereiche hin
### Test First
- Klassisch: Funktion planen -> Programmieren -> Refactoring -> Testen -> Fehler beheben
- Test First: Funktion planen -> Tests -> Programmieren -> Refactoring
- TDD: Tests in kleinen Schritten entwickeln (bis fehlschlägt) -> Funktion ändern bis Test erfüllt
- Kerngedanke
  - Tests > Produktivcode
  - Entwicklungsende, wenn Tests erfüllt -> Minimal notwendiger Code
  - Test als Wegweiser

|Vorteile|Nachteile|
|---|---|
|Volle Testabdeckung| Testen wird zur Pflicht|
|Fehlerrate sinkt| Ungewohntes Vorgehen / Einarbeitung|
|Angst existierende Fnkt. zu ändern, sinkt| Aufwand zur Implementierung höher|
|Automatische Spezifikation/Dokumentation| Ggf. schwierige Anwendung|
|Weniger Produktivcode||

### Umgang mit bestehendem Code
- Bestehender Code schwer testbar (Legacy Code)
- Legacy Code nicht fürs Testen entwickelt (viele Abhängigkeiten)
- Kann schrittweise weiterentwickelt werden (absichern, isolieren)
### Testen auf der grünen Wiese
- Neue Projekt -> von Anfang an testbar
- Feature -> „Ende-zu-Ende-Test“ definieren, bei Erfüllung ist Feature fertig
- Einzelne Schritte -> Unit-Tests

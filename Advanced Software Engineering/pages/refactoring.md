## Refactoring
### Was ist Refactoring?
- Bestehenden Code durchgehen: Code Review
- Intention/Funktion nachvollziehen
- Testabdeckung wird überprüft
- Code wird umgestaltet (Verhalten & Schittstellen bleiben gleich, neues Wissen einbauen)
- Ziel: Codequalität verbessern (lesbarer, flexibler nutzbar, Struktur verbessern)
### Warum sollte man Refactoring verwenden?
- Design der SW wird verbessert
- SW wird wartbarer
- SW wird einfacher verständlich
- Fehler werden einfacher gefunden
- Neue Funktionen kann schneller entwickelt werden
- Optimierung von SW

### Wann sollten wir Refactoring verwenden?
- Bestandteil der Entwicklung -> kontinuierlich
- Regel: Three strikes and you refactor
  - 1. Implementieren -> neue Funktionalität
  - Ähnliche Funktion? -> Code kopieren
  - Erneut Ähnliche Funktion? -> Code refactorn und wiederverwendeno
- Code Review
- Vor Hinzufügen neuer Funktionalität
- Beim Beheben eines Fehlers
- Lesbarkeit von SW verbessern
- Optimierung, hält Geschwindigkeit konstant

### Wann wird Refactoring schwierig?
- DB-Schemata schwieriger änderbar
- Änderung von Schnittstellen
- Zentrale Designentscheidungen
- Aufwand zu groß? -> Komplett neu entwickeln
### Auswirkungen auf das Design
- Funktion, wird während der Implementierung verstanden
- überarbeiten der Software kann Komplexität reduzieren
- Software lässt sich schnell ändern => Design dynamisch

- Gegensatz: Ingenieur
### Nachteile von Refactoring
- Refactoring kostet Zeit
- Verschlechtert die Performance
### Code Smells
- Code kann stinken, Stärke des „Gestanks“ schlecht messbar
- Deuten auf verbesserungswürdige Stellen im Code hin und welche die die Entwicklung
behindern
### Duplicated Code
- Doppelt vorhandener Code
- Gleiche Code-Struktur an mehr als einer Stelle
- Auseinanderdriften mehrere Stellen
- Lösung: Gemeinsamen Code auslagern
### Long Method
- lange Methoden
- Je länger -> schwerer verständlicher
- OO: viele Methoden delegieren
- Semantische Distanz zwischen Code und Name der Methode
- Lösung: Auftrennen der Methode (gute Namen, Kommentare, Schleifen, ifs sind gute Stellen)
### Large Class
- Große Klasse
- Anzahl Instanzvariablen, Methoden, Präfixe, Suffixe bei Variablen
- Klasse: Zu viel Verantwortung
- Lösung: Unterteilen der Klasse
### Shotgun Surgery
- Flickenteppich Änderung
- Kleine funktionale Änderung -> Anpassung vieler Stellen
- Lösung: Umstrukturierung des Codes
### Switch Statements
- Switch Statements: oft gleiche Switchs, wenige Nahtstellen zum Auftrennen, Fehler durch
- vergessenes Break
- Lösung: OO

### Code Comments
- Schlechter Code muss erklärt werden
- Lösung: Kommentar ist guter Indikator zur Trennung von Methoden -> Intention des
- Kommentars als Methodenname
### Refactorings
#### Extract Method
- Problem: Zusammenhängendes Stück Code kann extrahiert warden
- Lösung: Code in eigene Methode auslagern, passenden Namen wählen, Code freingranular aufteilen
- Verbesserung: Bessere Strukturierung des Codes
Hilft gegen: Code Comments, Duplicated Code, Long Method
#### Rename Method
- Problem: Methodenname passt nicht zum Inhalt der Methode
- Lösung: Methodenname ändern
- Verbesserung: Code lesbarer/verständlicher
- Hilft gegen: Code Comments
#### Replace Temp with Query
- Problem: Ergebnis einer Berechnung wird temporär in einer Variablen gespeichert
- Lösung: Berechnung des Wertes in eine Methode auslagern
- Verbesserung: Extrahierung, Schreibzugriffe auf Variablen werden sichtbar, Wert der
- Berechnung wird nicht zwischengespeichert
- Hilft gegen: Long Method
#### Replace Conditional with Polymorphism
- Problem: Verhalten mit Konditionalstrukturen und einer Typ-Kodierung gesteuert
- Lösung: Verhalten der einzelnen Pfade in abgeleitete Klasse überschreiben, Basismethode abstrakt
- Verbesserung: Software besser gekapselt, dynamisch erweiterbar
- Hilft gegen: Switch-Statements
#### Replace ErrorCode with Exception
- Problem: Fehlerwerte werden zurückgegeben
- Lösung: Statt Fehlerwert lieber Exception
- Verbesserung: Klare Definition von Fehlern, bessere Steuerung, Code verständlicher
#### Replace Inheritance with Delegation
- Problem: Funktionalität in abgeleiteter Klasse nicht brauchbar
- Lösung: Instanzvariable mit dem Type der Oberklasse anlegen
- Verbesserung: Klarer def. Schnittstellen, Trennung zw. eigener u. vorhandener Funktionalität

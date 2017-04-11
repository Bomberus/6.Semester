## GUI Blooper
### Was sind GUI-Blooper?
- Allgemeine GUI-Design-Fehler
- Über 70 GUI-Blooper
### Durch Blooper verursachte Probleme
- Verwirrung beim Nutzer
- Unnötiger Zeitaufwand
- Datenverlust
### Gründe für Blooper
- Fehlende Zeit, Wissen, Ressourcen
- Arten von Bloopern
  - GUI-Komponenten
  - Navigation
  - Texte
  - Design und Layout
  - Interaktion
  - Management
- Antwortverhalten
#### GUI Komponenten
- Umgang mit GUI-Komponenten
- Aussehen > Wahl der Komponenten
- Fehlende Unterstützung durch GUI-Toolkit
- Fehlendes Fachwissen
- 2 Kategorien
  -  Falsche Komponente
  - Falsche Verwendung von Komponenten
- Beispiele:
  -  Verwirrende Checkboxen/Radiobutton (Einzelner Radiobutton, Checkbox als
Radiobutton)
  - Textfelder für beschränkten Input (Datumsfeld, Radiobutton, ...)
##### Navigation
Navigation allgegenwärtig, wichtig für Orientierung
Aktueller Ort, Vorheriger Ort, Mögliche nächste Orte, Entfernung zum Ziel
Beispiele:
-  Gleicher Titel für unterschiedliche Fenster
-  Zu viele Ebenen von Dialogboxen
##### Text
- Viel Text in GUI
- So wenig wie möglich, so viel wie nötig
- Visualisierung oft besser
- Kategorien:
  - Unkommunikativ
  - Entwicklerzentriert
  - Fehlleitend
- Beispiele:
  - Inkonsistente Terminologie
  - Speaking Geek: Entwicklersprache für Nutzer unverständlich
#### Design und Layout
- Design, Farben, Layout
- Amateurhaft vs. Professionell
- In der Regel einfach korrigierbar
- Beispiele:
  - Leicht übersehbare Informationen
  - Radiobuttons zu weit auseinander (-> Groupboxen)
#### Interaktion
- Schwierig zu erkennen/beheben
- Decken größere Bereiche ab
- Arten:
  - Ablenkung von eig. Aufgabe
  - Unnötige Abläufe
  - Gedächtnis des Users belasten
  - Kontrolle des Users entziehen
- Beispiele:
  - Unnötige Beschränkungen (Zeichenbeschränkung etc.)
  - Sinnlose Auswahlmöglichkeiten (HTTP1 oder HTTP2?)
#### Management
  - UI unterschätzt durch Management
  - UI überschätzt von Management
- Beispiele:
  - UI als niedrige Priorität
  - Anarchische Entwicklung
  - Programmierer bekommen schnellsten Computer
#### Antwortverhalten
  - Benutzer immer ungeduldig
  - Intransparenz der Aktion
  - Mehrfaches Ausführen
- Beispiele:
  - Lag zerstört Hand-Augen-Koordination
  - Anwendung zeigt nicht, dass sie beschäftigt ist
  - Lange Operationen ohne Möglichkeit abzubrechen
#### Responsiveness
- Responsivness != Performance
- Ressourcen sind limitiert
- UI ist ein real-time Interface
- Verzögerungen sind nicht gleich
- Aufgaben nicht in der Reihenfolge in der sie erscheinen
- SW braucht nicht alle Aufgaben machen, die gefordert wurden
#### Vermeidung von langem Antwortverhalten
##### Timely Feedback
- Benutzereingaben direkt bestätigen
##### Parallel Problem Solution
- Prioritäten vergeben (Usereingaben > Update)
- Vorarbeiten
##### Queue Optimization
- Unkritische/Unnötige Aufgaben verzögern/entfernen
##### Dynamic Time Management
- Bearbeitungszeit berechnen
- Abarbeitung der Warteschlange ändern

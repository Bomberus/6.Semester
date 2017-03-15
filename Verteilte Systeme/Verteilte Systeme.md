# Verteilte Systeme

## Socket-Programmierung

* Port, Zuordnung, Ip Adressen
* 3 Phasen TCP
* Wie vergibt und identifiziert IP und Port
* Initiator und Beantworter
* DNS
* Socket Endpunkte der Verbindung
* Sichten des Client + Server

## Verteilte Anwendungen

* Was spricht gegen eine direkte Kommunikation
* Wie gestaltet man verteilte Anwendungen
* Was spricht für Client-Server Konzept
* Multi Threading
* Dispatcher und Working Threads
* Dispatcher: reserviert den Port und hört auf Verbindung, delegiert Aufgaben an Worker
* Worker: verarbeiten Anfrage

## RMI

* Remote Methode Invocation
* Stub auf lokalen Rechner dient als Proxy zu externe Ressource
* benötigen RMI Klasse 
* Nennen sie 3 Fälle, in der es zu einer Remote Exception kommt:
  * Netzwerkausfall
  * Stub und externe Ressource nicht synchron
  * Interfaceabweichungen
  * nicht serialisierbare Daten
  * Objekt wurde gelöscht vom Server
* Welche Aufgabe bind ? (Eintragung von Namen in Registry resultierend in Url)
* Welche Aufgabe lookup ? (Finden von Objekten mittels Url resultierend in Proxy)
* Für beide Parameter und Rückgabewerte wissen
* RMI Compiler (keine Instanzen, nur Klassen) erzeugt aus Klasse die passende Stubklasse
* explizit aufrufen oder implizit durch Proxy, wenn Stubklasse nicht existiert



## Serialisierung

* Umwandlung eines Objektes in eine Serie von Bytes
* Fragen:
  * Wie gehe ich mit Objektreferenzen um?
  * Nennen sie ein Objekt das nicht serialisierbar ist?
    * Output string (Streams)
    * Instanz von Thread
  * Wie geht man mit Remoteobjekt um ? 
  * Wann müssen Daten serialisiert und übertragen werden:
    * Bindoperationen
    * Parameterübergabe
    * Ergebnisabruf
  * => Es entstehen Kopien von Objekten
  * Was ist ein Web of Objects ?
    * Alle Objekte, die mit einem Objekt verbunden sind und sich referenzieren
  * Call by Value (remote)
* Übertragen von Objekten:
  * bei gewöhnlichen => serialisieren
  * wenn nicht möglich => Laufzeitfehler (Übertragung schlägt fehl)
  * RMI Übertragen => Proxy entsteht
  * Proxy => Proxy entsteht mit gleichen Verweis
* Garbage Collection
  * RMI Objekt kann gelöscht werden (wenn es lokal keinen Verweis mehr auf das Objekt)
  * Löschen des Proxies durch den Garbage Collection wird an den Computer gemeldet, auf dem sich das RMI-Objekt befindet
  * Wenn nach 10 Minuten kein Aufruf mehr durchgefürt wird, so werden alle externen Referenzen als nicht mehr existenz angenommen
* Laden von Klassen
  * Nur verwendete Klassen werden geladen
  * Dynamic Class Loading
  * => RMI Class Loader
  * Klassen im HTTP Server hinterlegt, um mehrere Server zu synchronisieren
  * => Aus Sicherheitsgründen, werden Zertifikate verwendet

## JDBC

- einheitlicher Datenbanktreiber, welcher eine API für verschiedene Datenbanksysteme bereitstellt
- Datasource P 177 (entspricht Entitymanager ) Wo ist Datenquelle, wie kann ich es zugreifen?

## ORM 

- Was entspricht beim ORM Mapping einer Klasse(Tabelle) ?


- Was bewirkt persist

- Welchen Vorteil haben Prepared Statements

- Nennen Sie einen Fall, wo ein rollback sinnvoll ist

- Connection Pooling 226

  - Welche Verbindung hat get() close() (mit / ohne ConnectionPooling)

- Dirty Reads

  - Lesend auf eine Änderung zugreifen, welche nicht commited wurde

- Non repeatable Reads

  - Zweimal lesend auf den selben Datensatz wird zugegriffen

    => Änderungen verzögern, alte Daten zurückliefern

- Phantom Reads

  - Datensätze mit Filter 
  - Alle Müller der DH, Menge der Datensätze verändern sich unter dem Filter, wenn der Datensätz geändert wird
  - Szenario : Wieviele Müller haben Gesamtstudio abgeschlossen?
  - 2.Szenario : Wieviele Müller gibt es insgesamt

## JPA 

- Was bedeutet persistent? 
- EntityManagerFactory => vergleichbar mit Datasource
- man erzeugt die Instanz zu Beginn
- Nach commit werden Objekte in den Peristentkontext abgelegt und mit Datenbank inhalt verglichen und synchronisiert (Batch Operationen)
- Löschen:
  - Wie kommt es zum löschen?
  - Was bedeutet Persistente Identität und was hat das mit dem Primärschlüssel zu tun
  - Zustände F280
  - Detached Objekt, bei Attributänderung, keine Auswirkungen
- Dirty reads ausgeschlossen
- Phantom Reads nicht verhinderbar
- Non repeatable Reads : @Version, dient für interne Verarbeitung
- Lock-Modes angeben

## JPQL

- kein Detailwissen
- 3 Arten von Befehlen
- Standartisierte Sprache 

## Beziehungen

@OneToOne = kein Verweis auf andere Objekte, nur auf sich selbst

## EJB

- Wozu braucht man es ? Businesslogik 
- JPA : Persistente Speicherung von Daten
- Dependency Injection
- Stateless
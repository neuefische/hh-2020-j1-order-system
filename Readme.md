## Order db 
This was an exercise to learn and repeat OOP
#### friday exercise

#### Schreibe ein Bestellsystem (mit Tests!)
1. Verwalte zu bestellende Produkte in einer ProductDb (muss nicht veränderbar sein)
2. Gebe alle Produkte in der App Main aus
3. Verwalte Bestellungen über eine OrderDb
4. Füge eine Bestellung über einen Order Service hinzu
5. Gebe alle Bestellungen aus
6. nutze für die get Methoden als Rückgabewert ein Optional
7. throw eine Exception wenn Produkte bestellt werden sollen die nicht existieren
Nutze anstelle einer Product Klasse ein Interface und implementiere verschiedene Ausführungen

#### Bonus: 
- schaue dir hamcrest an
- Mache aus deiner OrderDb ein Interface und 2 Implementierung 
    - einer Version, welche die Bestellungen wie zuvor im Speicher hält
    - eine Version, welche  den jackson ObjectMapper nutzt um bestellungen auf die Festplatte zu speichern
- Nutze in deiner Main einen Scanner um Interaktiv zu bestellen


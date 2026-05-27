public class Wagen {
    // Statischer Zähler zur Erzeugung eindeutiger IDs für jeden Wagen
    private static int zaehler = 0;

    // Die eindeutige ID des Wagens ( "W1", "W2", ...)
    private final String id;

    // Referenz auf den nächsten Wagen im Zug (oder null, wenn keiner folgt)
    private Wagen nachfolger;

    // Konstruktor – erzeugt eine neue ID und initialisiert den Nachfolger mit null
    public Wagen() {
        this.id = "W" + (++zaehler);
        this.nachfolger = null;
    }

    // Getter für die ID des Wagens
    public String getId() {
        return id;
    }

    // Getter für den Nachfolger
    public Wagen getNachfolger() {
        return nachfolger;
    }

    // Setter für den Nachfolger – nur innerhalb des Pakets/Zug-Klasse verwendbar
    void setNachfolger(Wagen nachfolger) {
        this.nachfolger = nachfolger;
    }

    // Iteratives Anhängen eines Wagens am Ende der Wagenkette
    void anhaengenIterativ(Wagen neuerWagen) {
        Wagen current = this;
        // Gehe bis zum letzten Wagen (dessen Nachfolger null ist)
        while (current.nachfolger != null) {
            current = current.nachfolger;
        }
        // Hänge den neuen Wagen ans Ende
        current.nachfolger = neuerWagen;
    }

    // Rekursives Anhängen eines Wagens
    void anhaengenRekursiv(Wagen neuerWagen) {
        if (this.nachfolger == null) {
            // Basisfall: letzter Wagen gefunden
            this.nachfolger = neuerWagen;
        } else {
            // Rekursiver Fall: weiter zum nächsten Wagen
            this.nachfolger.anhaengenRekursiv(neuerWagen);
        }
    }
}

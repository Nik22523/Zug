public class Zug {
    // Referenz auf den ersten Wagen des Zuges
    private Wagen ersterWagen;

    // Getter für den ersten Wagen
    public Wagen getErsterWagen() {
        return ersterWagen;
    }

    // Methode zum Anhängen eines Wagens – iterativ
    public void anhaengenIterativ(Wagen neuerWagen) {
        if (ersterWagen == null) {
            // Wenn der Zug leer ist, wird der neue Wagen der erste
            ersterWagen = neuerWagen;
        } else {
            // Andernfalls delegieren wir an die Methode im ersten Wagen
            ersterWagen.anhaengenIterativ(neuerWagen);
        }
    }

    // Methode zum Anhängen eines Wagens – rekursiv
    public void anhaengenRekursiv(Wagen neuerWagen) {
        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } else {
            ersterWagen.anhaengenRekursiv(neuerWagen);
        }
    }

    // Entfernt einen bestimmten Wagen aus dem Zug
    public boolean abhaengen(Wagen zuEntfernenderWagen) {
        // Falls Zug leer oder Wagen null, kann nichts entfernt werden
        if (ersterWagen == null || zuEntfernenderWagen == null) {
            return false;
        }

        // Sonderfall: zu entfernender Wagen ist der erste
        if (ersterWagen == zuEntfernenderWagen) {
            // Überspringe den ersten Wagen
            ersterWagen = ersterWagen.getNachfolger();
            zuEntfernenderWagen.setNachfolger(null);
            return true;
        }

        // Iteration durch die Wagenkette zur Suche des Wagens
        Wagen current = ersterWagen;
        while (current.getNachfolger() != null) {
            // Wenn der Nachfolger der gesuchte Wagen ist
            if (current.getNachfolger() == zuEntfernenderWagen) {
                // Überspringe ihn, verlinke Vorgänger mit dem Nachfolger
                current.setNachfolger(zuEntfernenderWagen.getNachfolger());
                // Der entfernte Wagen zeigt auf niemanden mehr
                zuEntfernenderWagen.setNachfolger(null);
                return true;
            }
            // Weiter mit dem nächsten Wagen
            current = current.getNachfolger();
        }

        // Wagen wurde nicht gefunden
        return false;
    }

    // Zählt, wie viele Wagen im Zug enthalten sind
    public int zaehleWagen() {
        int count = 0;
        Wagen current = ersterWagen;
        // Durchläuft die Wagenkette und zählt jeden Wagen
        while (current != null) {
            count++;
            current = current.getNachfolger();
        }
        return count;
    }

    // Gibt die Struktur des Zuges in der Konsole aus ( "W1 -> W2 -> W3")
    public void druckeZug() {
        Wagen current = ersterWagen;
        while (current != null) {
            System.out.print(current.getId());
            if (current.getNachfolger() != null) {
                System.out.print(" -> ");
            }
            current = current.getNachfolger();
        }
        System.out.println();
    }
}


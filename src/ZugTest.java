public class ZugTest {

    public static void main(String[] args) {
        System.out.println("TEST 1: Anhaengen (rekursiv)");
        testAnhaengenRekursiv();

        System.out.println("\nTEST 2: Anhaengen (iterativ)");
        testAnhaengenIterativ();

        System.out.println("\nTEST 3: Abhaengen (mittlerer Wagen)");
        testAbhaengenMitte();

        System.out.println("\nTEST 4: Abhaengen (erster Wagen)");
        testAbhaengenErster();

        System.out.println("\nTEST 5: Abhaengen (nicht im Zug)");
        testAbhaengenNichtImZug();

        System.out.println("\nTEST 6: Leerer Zug");
        testLeererZug();

        System.out.println("\nTEST 7: Zaehlen");
        testZaehlen();
    }

    static void testAnhaengenRekursiv() {
        Zug zug = new Zug();
        Wagen w1 = new Wagen();
        Wagen w2 = new Wagen();
        Wagen w3 = new Wagen();

        zug.anhaengenRekursiv(w1);
        zug.anhaengenRekursiv(w2);
        zug.anhaengenRekursiv(w3);

        zug.druckeZug(); // Erwartet: W1 -> W2 -> W3
    }

    static void testAnhaengenIterativ() {
        Zug zug = new Zug();
        Wagen w1 = new Wagen();
        Wagen w2 = new Wagen();

        zug.anhaengenIterativ(w1);
        zug.anhaengenIterativ(w2);

        zug.druckeZug(); // Erwartet: W4 -> W5
    }

    static void testAbhaengenMitte() {
        Zug zug = new Zug();
        Wagen w1 = new Wagen();
        Wagen w2 = new Wagen();
        Wagen w3 = new Wagen();

        zug.anhaengenRekursiv(w1);
        zug.anhaengenRekursiv(w2);
        zug.anhaengenRekursiv(w3);

        boolean entfernt = zug.abhaengen(w2);
        System.out.println("Erfolg beim Entfernen von W2? " + entfernt); // true
        zug.druckeZug(); // Erwartet: W6 -> W8
    }

    static void testAbhaengenErster() {
        Zug zug = new Zug();
        Wagen w1 = new Wagen();
        Wagen w2 = new Wagen();

        zug.anhaengenRekursiv(w1);
        zug.anhaengenRekursiv(w2);

        boolean entfernt = zug.abhaengen(w1);
        System.out.println("Erfolg beim Entfernen von erstem Wagen? " + entfernt); // true
        zug.druckeZug(); // Erwartet: W10
    }

    static void testAbhaengenNichtImZug() {
        Zug zug = new Zug();
        Wagen w1 = new Wagen();
        Wagen w2 = new Wagen();
        Wagen fremd = new Wagen();

        zug.anhaengenRekursiv(w1);
        zug.anhaengenRekursiv(w2);

        boolean entfernt = zug.abhaengen(fremd);
        System.out.println("Wagen nicht im Zug entfernt? " + entfernt); // false
        zug.druckeZug(); // Erwartet: W13 -> W14
    }

    static void testLeererZug() {
        Zug leererZug = new Zug();
        boolean entfernt = leererZug.abhaengen(new Wagen());
        System.out.println("Entfernen aus leerem Zug? " + entfernt); // false
        leererZug.druckeZug(); // Erwartet: (leer)
    }

    static void testZaehlen() {
        Zug zug = new Zug();
        zug.anhaengenRekursiv(new Wagen());
        zug.anhaengenRekursiv(new Wagen());
        zug.anhaengenRekursiv(new Wagen());

        int anzahl = zug.zaehleWagen();
        System.out.println("Wagen im Zug: " + anzahl); // Erwartet: 3
    }
}


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int reihen = 10;
        int plaetzeProReihe = 10;
        Random random = new Random();

        char[][] kinosaal = new char[reihen][plaetzeProReihe];

        // Zufällige Belegung
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < plaetzeProReihe; j++) {
                if (random.nextBoolean()) { // Wenn wahr
                    kinosaal[i][j] = 'x'; // Belegter Platz
                } else {
                    kinosaal[i][j] = ' '; // Ansonsten frei - [ ]
                }
            }
        }

        // Anzeige des Kinosaals mit Reihenbeschriftung
        for (int i = 0; i < reihen; i++) {
            System.out.print("Reihe " + (i + 1) + " \t"); // Reihenbeschriftung
            for (int j = 0; j < plaetzeProReihe; j++) {
                if (kinosaal[i][j] == 'x') {
                    System.out.print("x\t"); // Belegter Platz
                } else {
                    System.out.print("[ ]\t"); // Freier Platz
                }
            }
            System.out.println(); // Neue Zeile nach jeder Reihe
        }

        // Berechnung der Auslastung
        int gesamtPlaetze = 0;
        int belegtePlaetze = 0;

        for (int i = 0; i < reihen; i++) {
            int freiePlaetze = 0;
            for (int j = 0; j < plaetzeProReihe; j++) {
                gesamtPlaetze++;
                if (kinosaal[i][j] == 'x') { //Wenn belegt dann belegtePlaetze erhöhen
                    belegtePlaetze++;
                } else {
                    freiePlaetze++;
                }
            }
            System.out.println(freiePlaetze + " freie Plätze in Reihe " + (i + 1));  // i +1 da bei 0 beginnt
        }

        double auslastung = ((double) belegtePlaetze / gesamtPlaetze) * 100;
        System.out.printf("Die Auslastung des Kinosaals beträgt %.2f%%\n", auslastung);
    }
}

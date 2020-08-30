import Oblig1.*;

////// Testprogram for Oblig 1 ////////////////////////

/*
Testprogrammet har en main-metode som tester metodene i de 10 oppgavene.
Som utgangspunkt er metodekallene kommentert vekk. Her må en passe på
å bruke nøyaktig samme navn på metodene som det er bedt om i oppgaveteksten.

Når en mener at en oppgave/metode er løst, bør en først teste med egne tester.
Når en så tror at koden er feilfri, kan testprogrammet brukes ved at
kommentartegnet foran metodekallet tas vekk. Testprogrammet må gi 0 feil før
Oblig 1 sendes inn!
*/

import java.util.*;

/**
 * Alle tester i denne klassen skal passere når du leverer inn.
 * Du skal ikke endre noe som helst i denne filen
 */
public class egenTest {
    public static void main(String[] args){
        oppgave1();
        oppgave2();
        oppgave3();
    }
    ///// Oppgave 1 //////////////////////////////////////
    static void oppgave1() {
        int antallFeil = 0;

        boolean unntak = false;
        int[] tom = {};
        try {
            Oblig1.maks(tom);  // kaller maks-metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Opgave 1: a) Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println("Opgave 1: b) Kast unntak for en tom tabell!");
            antallFeil++;
        }

        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        if (Oblig1.maks(a) != 3 || Oblig1.maks(b) != 8 ||
                Oblig1.maks(c) != 5 || Oblig1.maks(d) != 5) {
            System.out.println("Oppgave 1: c) Maks-metoden: Feil resultat!");
            antallFeil++;
        }

        int[] e = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] f = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};

        Oblig1.maks(e);
        if (!Arrays.equals(e, f)) {
            System.out.println("Oppgave 1: d) Maks-metoden: feil i ombyttingene!");
            antallFeil++;
        }

        a = new int[]{6, 5, 4, 3, 2, 1};
        b = new int[]{1, 2, 3, 4, 5};
        c = new int[]{4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        d = new int[]{2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

        if (Oblig1.ombyttinger(a) != 5 || Oblig1.ombyttinger(b) != 0
                || Oblig1.ombyttinger(c) != 7 || Oblig1.ombyttinger(d) != 6) {
            System.out.println("Oppgave 1: e) Feil opptelling i ombyttingsmetoden!");
            antallFeil++;
        }
    }

    ///// Oppgave 2 /////////////////////////////////////
    static void oppgave2() {
        int antallFeil = 0;

        int[] a = {};
        int[] b = {1};
        int[] c = {1, 2, 3, 4, 5, 4};

        try {
            Oblig1.antallUlikeSortert(a);  // kaller metoden
            Oblig1.antallUlikeSortert(b);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 2: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        boolean unntak = false;

        try {
            Oblig1.antallUlikeSortert(c);  // kaller metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof IllegalStateException)) {
                System.out.println
                        ("Oppgave 2: b) Feil unntak for en usortert tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println
                    ("Oppgave 2: c) Kast et unntak for en usortert tabell!");
            antallFeil++;
        }

        int[] d = {1, 1};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

        if (Oblig1.antallUlikeSortert(a) != 0
                || Oblig1.antallUlikeSortert(b) != 1
                || Oblig1.antallUlikeSortert(d) != 1
                || Oblig1.antallUlikeSortert(e) != 7
                || Oblig1.antallUlikeSortert(f) != 7) {
            System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
            antallFeil++;
        }
    }

    ///// Oppgave 3 /////////////////////////////////////
    static void oppgave3() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!
        int[] b = {1};  // skal ikke kaste unntak her!
        int[] c = {1, 1};
        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] dkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] e = {5, 4, 3, 2, 1};
        int[] f = {1, 2, 2, 2, 2, 2, 3};

        try {
            Oblig1.antallUlikeUsortert(a);  // kaller metoden
            Oblig1.antallUlikeUsortert(b);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 3: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        if (Oblig1.antallUlikeUsortert(a) != 0
                || Oblig1.antallUlikeUsortert(b) != 1
                || Oblig1.antallUlikeUsortert(c) != 1
                || Oblig1.antallUlikeUsortert(d) != 6
                || Oblig1.antallUlikeUsortert(e) != 5
                || Oblig1.antallUlikeUsortert(f) != 3) {
            System.out.println("Oppgave 3: b) Metoden gir feil resultat!");
            antallFeil++;
        }

        if (!Arrays.equals(d, dkopi)) {
            System.out.println("Oppgave 3: c) Metoden endrer tabellen!");
            antallFeil++;
        }


    }

    ///// Oppgave 4 //////////////////////////////////////
    static void oppgave4() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: a) Ikke unntak for en tom tabell!");
            antallFeil++;
        }

        a = new int[]{5};
        int[] b = {5};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: b) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: c) Metoden gjør feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4};
        b = new int[]{4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: d) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: e) Metoden gjør feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4, 2, 6, 10, 8};
        b = new int[]{2, 4, 6, 8, 10};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: f) Det går galt hvis det kun er partall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: g) Det blir feil hvis det kun er partall!");
            antallFeil++;
        }

        a = new int[]{9, 5, 3, 1, 7};
        b = new int[]{1, 3, 5, 7, 9};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: h) Det går galt hvis det kun er oddetall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: i) Det blir feil hvis det kun er oddetall!");
            antallFeil++;
        }
/*
        a = new int[]{1, 2, 3, 4, 5, 6};
        b = new int[]{1, 3, 5, 2, 4, 6};
        boolean flere = true;

        do {
            int[] c = a.clone();
            Oblig1.delsortering(c);

            if (!Arrays.equals(c, b)) {
                System.out.println
                        ("Oppgave 4: j) Gitt tabell:     " + Arrays.toString(a));
                System.out.println
                        ("              Metoden skal gi: " + Arrays.toString(b));
                System.out.println
                        ("              Du fikk:         " + Arrays.toString(c));

                antallFeil++;
                break;
            }
        } while (nestePermutasjon(a));
*/
        a = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};
        b = new int[]{-3, -1, 1, 3, -4, -2, 0, 2, 4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: k) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: l) Metoden gjør feil for negative verdier!");
            antallFeil++;
        }

        if (antallFeil == 0) {
            //a = randPerm(100000); //Finn ut hvor denne funksjonen er laget
            long tid = System.currentTimeMillis();
            Oblig1.delsortering(a);
            tid = System.currentTimeMillis() - tid;

            for (int i = 0; i < 50000; i++) {
                if (a[i] != 2 * i + 1) {
                    System.out.println
                            ("Oppgave 4: m) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            for (int i = 50000; i < 100000; i++) {
                if (a[i] != 2 * (i - 49999)) {
                    System.out.println
                            ("Oppgave 4: n) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            if (tid > 100) {
                System.out.println
                        ("Oppgave 4: o) Tid: " + tid + ". Metoden er for ineffektiv!");
                System.out.println
                        ("              Hint: Bruk en partisjoneringsteknikk!");
                antallFeil++;
            }
        }
    }
}
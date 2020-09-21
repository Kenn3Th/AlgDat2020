package hjelpeklasse;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    /*
    Funksjoner fra boken
     */

    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til); //Lagt til i fra oppgave 3 seksjon 1.2.3

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static int maks(double[] a)     // Programkode 1.4.1 a) fra boka
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
/*
    public static int maks(String[] a)    // Programkode 1.4.1 b) fra boka
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        System.out.println("Det var String som ble kalt");
        return m;  // returnerer posisjonen til største verdi
    }

 */

    //Oppgave1.4.1 2
    public static int maks(char[] a)     // Måtte endre på 2 plasser for å få den til å ta char
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
    //Oppgave1.4.1 3
    public static int maks(Integer[] a)     // Måtte endre på 2 plasser for å få den til å ta Integer
    {
        int m = 0;                           // indeks til største verdi
        Integer maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) //Programkode 1.4.2 b) fra boka
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        System.out.println("Det var generic som ble kalt");
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) //Programkode 1.4.2 e) fra boka
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    /****** Oppgaver fra kap 1.4.3 ******/

    public static <T extends Comparable<? super T>> void bytt(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<? super T>> void skriv(T[] a, int fra, int til){
        System.out.print(a[fra]);
        for (int i = fra+1; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static <T extends Comparable<? super T>> void skriv(T[] a){
        skriv(a,0,a.length);
    }

    public static <T extends Comparable<? super T>> void skrivln(T[] a){
        skriv(a,0,a.length-1);
        System.out.println(" " + a[a.length-1]);
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    public static Double[] double2Double(double[] a){
        int len = a.length;
        Double[] b = new Double[len]; // Lager en ny tom Double tabell med samme lengde
        //Fyller Double tabellen med samme verdi som i double.
        for (int i = 0; i < len; i++) {
            b[i] = a[i];
        }

        return b;

    }

    /*** Oppgave 1.4.3 8) ***/
    public static void f(int a, Integer b){
        System.out.println("int a, Integer b");
    }

    public static void f(Integer a, int b){
        System.out.println("Integer a, int b");
    }


    /*
    Kontroll funksjoner
     */
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }
}

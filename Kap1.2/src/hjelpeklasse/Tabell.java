package hjelpeklasse;

import java.util.*;
import java.sql.SQLOutput;

public class Tabell {

    private Tabell(){}

    /***** Seksjon 1.2.1 *****/
    //metode 1 har intervallet [fra,til)
    public static int minMetode1(int[] rekke, int fra, int til){

        fratilKontroll(rekke.length, fra, til); //Lagt til i fra oppgave 3 seksjon 1.2.3

        int minst = rekke[fra];
        int minPos = fra;
        for (int i = (fra+1); i < til ; i++) {
            if (rekke[i]<minst) {
                minst = rekke[i];
                minPos = i;
            }
        }
        return minPos;
    }

    //metode 2 har intervallet [venstre,høyre]
    public static int minMetode2(int[] rekke, int v, int h){
        vhKontroll(rekke.length, v, h); //Lagt til i oppgave 3 seksjon 1.2.3

        int minst = rekke[v];
        int minPos = v;
        for (int i = v+1; i <=h ; i++) {
            if (rekke[i]<minst) {
                minst = rekke[i];
                minPos = i;
            }
        }
        return minPos;
    }

    /**** Seksjon 1.2.2 ****/
    //Oppgave 1
    public static void byttTall(int[] a, int i, int j) { //Programkode 1.1.8 d)
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) { // Programkode 1.1.8 e)
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            byttTall(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a, Programkode 1.1.8 f)
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            byttTall(a,k,i);
        }
    }

    public static int maksMetode1(int[] a, int fra, int til)
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

    public static int maksMetode2(int[] a)  // bruker hele tabellen
    {
        return maksMetode1(a,0,a.length);     // kaller metoden over
    }

    //Oppgave 3
    public static void byttChar(char[] ord, int i, int j)
    {
        char temp = ord[i];
        ord[i] = ord[j];
        ord[j] = temp;
    }

    //Oppgave 4
    public static void skriv(int[] tallRekke, int fra, int til)
    {
        for(int i = fra; i<til; i++){
            if (i==(til-1)) System.out.print(tallRekke[i]);
            else System.out.print(tallRekke[i] + " ");
        }
    }

    public static void skriv(int[] tallRekke) {
        for(int tall : tallRekke) System.out.print(tall + " ");
    }

    public static void skrivln(int[] tallRekke){
        skriv(tallRekke);
        System.out.println(" ");
    }

    public static void skrivln(int[] tallRekke, int fra, int til){
        for(int i = fra; i<til; i++){
            if (i==(til-1)) System.out.println(tallRekke[i]);
            else System.out.print(tallRekke[i] + " ");
        }
    }

    /**** Seksjon 1.2.3 ****/
    //Oppgave 1 - 5
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

    /**** Seksjon 1.2.4 ****/

    //Oppgave 1
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maksMetode2(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maksMetode1(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maksMetode1(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maksMetode1(a, 0, m);              // leter i a[0:m>
            int mh = maksMetode1(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon

    } // nestMaks

    //Oppgave 2
    public static int[] KennethsNestMax(int[] tallrekke){
        int n = tallrekke.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new NoSuchElementException("a.length(" + n + ") < 2!");


        int mPos = maksMetode2(tallrekke);  // m er posisjonen til tabellens største verdi
        int nm; //nestmaks

        if (mPos == 0) { //Hvis den største ligger først
            nm = maksMetode1(tallrekke, 1, n);                  // leter i a[1:n>
        }
        else {
            int temp = tallrekke[0];
            int maks = tallrekke[mPos];
            tallrekke[0] = maks;
            tallrekke[mPos] = temp;
            nm = maksMetode1(tallrekke, 1, n);
            tallrekke[0] = temp;
            tallrekke[mPos] = maks;
        }
        return new int[]{mPos,nm};
    }

    //Oppgave 4
    public static void SorteringNestmaks(int[] tallrekke){
        int n = tallrekke.length;
        if(n<2) throw
                new NoSuchElementException(n + " er ikke en tallrekke!");

        int mPos = maksMetode2(tallrekke);
        int index = n-1;
        int temp = tallrekke[index];
        tallrekke[index] = tallrekke[mPos];
        tallrekke[mPos] = temp;

        for (int i = 1; i < n; i++) {
            temp = tallrekke[index-i];
            mPos = maksMetode1(tallrekke,0, n-i);
            tallrekke[index-i] = tallrekke[mPos];
            tallrekke[mPos] = temp;
        }
    }



}

import hjelpeklasse.*;

public class Program
{
    public static void main(String ... args)      // hovedprogram
    {   /**** Seksjon 1.2.2 ****/
    /*
        // Test for oppgave 1
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maksMetode2(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi er "+ a[m] +" og ligger på plass " + m);

        // Test for oppgave 3
        char[] bokstaver = new char[]{'a','b','c','d','e','f','q'};

        System.out.println("\nTest for oppgave 3");
        for(char k : bokstaver) System.out.print(k + " ");
        Tabell.byttChar(bokstaver,0,6);
        System.out.println("\nså bytter vi plass på siste of første bokstav");
        for(char k : bokstaver) System.out.print(k + " ");

        // Test for oppgave 4
        System.out.println("\n\nTest for metoden som skriver ut hele tabellen");
        Tabell.skriv(a);
        System.out.println("\nTest for metoden som kun skriver ut i intervallet [fra,til)");
        Tabell.skriv(a,4,11);

        // Test for oppgave 5
        System.out.println("\nTest for oppgave 5");
        Tabell.skrivln(a);
        System.out.println("Det fungerte");
        Tabell.skrivln(a,4,11);
        System.out.println("Det fungerte igjen");
        */

        /**** Seksjon 1.2.3 ****/
        /*
        //oppgave 3
        System.out.println("Tester Feil og unntak i koden");
        Tabell.maksMetode1(a,8, 2);
        */

        /**** Seksjon 1.2.4 ****/

        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.minNestMax(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

    } // main

} // class Program
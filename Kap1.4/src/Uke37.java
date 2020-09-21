import eksempelKlasser.*;
import eksempelKlasser.Generisk.Person;
import hjelpeklasse.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.*;

public class Uke37 {

    public static void main(String[] args){
        //oppgave141();
        //comp2Integer();
        //comp2String();
        //compBoolean();
        //oppgave142();
        //oppgave143();
        //oppgave1441();
        //oppgave1442();
        //oppgave145();
        Generisk.Måned.vår();
        Generisk.Måned.vinter();

    }

    static void oppgave141(){
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] c = "HBFSDKJPWQDVSDK".toCharArray();
        Integer[] I = {4,1,5,2,16,7,2,3,5,10,6};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s
        //Oppgave2
        int n = Tabell.maks(c);     // posisjonen til den største i c
        //Oppgave3
        int o = Tabell.maks(I);     // posisjonen til den største i I

        System.out.println("Tabell " + Arrays.toString(a)+ " \nint maks: " + a[k]);
        System.out.println("Tabell " + Arrays.toString(d)+ " \ndouble maks: " + d[l]);
        System.out.println("Tabell " + Arrays.toString(s)+" \nString maks: " + s[m]);
        System.out.println("Tabell " + Arrays.toString(c)+" \nString maks: " + c[n]);
        System.out.println("Tabell " + Arrays.toString(I)+" \nString maks: " + I[o]);
    }
    //Oppgave5
    static void comp2Integer(){
        Integer a = 6, b = 4;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("b.compareTo(a) = " + b.compareTo(a));
        System.out.println("a.compareTo(a) = " + a.compareTo(a));
        /*
        Ser ut til at compareTo gir negativ verdi hvis tallet som skal sammenlignes
         er mindre eks (a=6).compareTo(b=8) = -tall

         Er a større enn b ?
         posetiv verdi = ja
         negativ verdi = nei
         0 = lik verdi
         */
    }
    //Oppgave5
    static void comp2String(){
        String a = "A", b = "B";
        String s = "KARIANNE", t = "KARI";

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("b.compareTo(a) = " + b.compareTo(a));
        System.out.println("a.compareTo(a) = " + a.compareTo(a));
        /*
        Ser ut til at compareTo gir negativ verdi hvis bokstaven som skal sammenlignes
        kommer først leksikografisk eks (a = "A").compareTo(b = "X") = -tall

        Kommer bokstaven sist i alfabetet?
        posetiv verdi = ja
        negativ verdi = nei
        0 = lik verdi
         */
        System.out.println("s = " + s + ", t = " + t);
        System.out.println("s.compareTo(t) = " + s.compareTo(t));
        System.out.println("t.compareTo(s) = " + t.compareTo(s));
        System.out.println("t.compareTo(t) = " + t.compareTo(t));
        /*
        Ser ut til at compareTo gir negativ verdi hvis ordet som skal sammenlignes
        kommer først leksikografisk eks (t=AKE).compareTo(s=Pike) = -tall

        Kommer ordet sist i alfabetet?
        posetiv verdi = ja
        negativ verdi = nei
        0 = lik verdi
         */
    }
    //Oppgave6
    static void compBoolean(){
        Boolean a = true, b = false;

        System.out.println("a = true, b = false");
        System.out.println("Boolean.compare(b,a) = " + Boolean.compare(b, a));
        System.out.println("Boolean.compare(a,a) = " + Boolean.compare(a, a));
        System.out.println("Boolean.compare(a,b) = " + Boolean.compare(a, b));
        /*
        Ser ut til at java sier at true er større enn false
         */

    }

    static void oppgave142() {
        //Oppgave1
        String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
        int k = Tabell.maks(s);
        System.out.println(s[k]);

        //Oppgave 2
        String[] t = {"Per", "Kari", "Ole", "Anne", "Ali", "Eva"};
        System.out.println("Før sortering: " + Arrays.toString(t));
        Tabell.innsettingssortering(t);
        System.out.println("Etter sortering: " + Arrays.toString(t));
    }

    static void oppgave143(){
        //Oppgave 5
        /*
        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        System.out.println("skrivln funksjonen");
        Tabell.skrivln(s);
        System.out.println("skriv funksjonen");
        Tabell.skriv(d);
        */
        //Oppgave 6
        /*
        Integer[] a = Tabell.randPermInteger(20);
        System.out.println(Arrays.toString(a));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        */
        //Oppgave 7
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] D = Tabell.double2Double(d);
        System.out.println("Før sortering " + Arrays.toString(D));
        Tabell.innsettingssortering(D);
        System.out.println("Etter sortering " + Arrays.toString(D));

        //Oppgave 8
        Integer a = 1;
        int b = 1;
        Tabell.f(a,b);
        /*
        * Hvis funksjons kallet er f(1,1) får jeg at det ambiguos å kalle på 2 like metoder. Kommenter jeg vekk en
        * vil den andre brukes. en løsning på hvordan man kan velge hvilken av de to like metodene som skal brukes
        * er å definere variabler av de to forskjellige typene, og sende inn variablene i funksjonskallet.
        * */

    }

    static void oppgave1441(){
        int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Generisk.Heltall[] h = new Generisk.Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++)
            h[i] = new Generisk.Heltall(a[i]);

        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

        Generisk.Heltall x = new Generisk.Heltall(3), y = new Generisk.Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));
    }

    static void oppgave1442() {
        Person[] p = new Person[8];                   // en persontabell

        p[0] = new Person("Kari", "Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");              // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");        // Kari Pettersen
        p[5] = new Person("Karianne", "Pettersen");
        p[6] = new Person("Caroline", "Olsen");
        p[7] = new Person("Kenneth", "Eikrehagen");

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
    }

    static void oppgave145(){
        for (Generisk.Studium s : Generisk.Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
    }

}

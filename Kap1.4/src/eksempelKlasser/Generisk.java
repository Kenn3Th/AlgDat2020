package eksempelKlasser;

import javax.management.Descriptor;
import java.rmi.MarshalException;
import java.util.Objects;

public class Generisk {

    public static final class Heltall implements Comparable<Heltall> //Programkode 1.4.4 a) fra boka
    {
        private final int verdi;    // et heltall som instansvariabel

        public Heltall(int verdi) { this.verdi = verdi; }   // konstruktør

        public int intVerdi() { return verdi; }             // aksessor

        public int compareTo(Heltall h)        // Heltall som parameter
        {
            /*
            //Oppgave b
            if (verdi < h.verdi) return -1;
            else if (verdi == h.verdi) return 0;
            else return 1;

             */
            //return verdi - h.verdi; //Oppgave c
            return verdi < h.verdi ? -1 : (verdi == h.verdi ? 0 : 1);
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;   // sammenligner med seg selv
            if (!(o instanceof Heltall)) return false;  // feil datatype
            return verdi == ((Heltall)o).verdi;
        }

        public boolean equals(Heltall h) { return verdi == h.verdi; }

        public int hashCode() { return 31 + verdi; }

        public String toString() { return Integer.toString(verdi); }

    } // class Heltall

    public static class Person implements Comparable<Person> //Programkode 1.4.4 d) fra boka
    {
        private final String fornavn;         // personens fornavn
        private final String etternavn;       // personens etternavn

        public Person(String fornavn, String etternavn)   // konstruktør
        {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
        }

        public String fornavn() { return fornavn; }       // aksessor
        public String etternavn() { return etternavn; }   // aksessor

        public int compareTo(Person p)    // pga. Comparable<Person>
        {
            int cmp = etternavn.compareTo(p.etternavn);     // etternavn
            if (cmp != 0) return cmp;             // er etternavnene ulike?
            return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
        }

        public boolean equals(Object o)      // vår versjon av equals
        {
            if (o == this) return true;
            if (!(o instanceof Person)) return false;
            return compareTo((Person)o) == 0;
        }

        public int hashCode() { return Objects.hash(etternavn, fornavn); }

        public String toString() { return fornavn + " " + etternavn; }

    } // class Person

    public class Student extends Person   // Student blir subklasse til Person
    {
        private final Studium studium;      // studentens studium

        public Student(String fornavn, String etternavn, Studium studium)
        {
            super(fornavn, etternavn);
            this.studium = studium;
        }

        public String toString() { return super.toString() + " " + studium.name();}

        public Studium studium() { return studium; }

    }  // class Student

    public enum Studium  // Programkode 1.4.5 a) fra boka
    {
        Data ("Ingeniørfag - data"),         // enumkonstanten Data
        IT ("Informasjonsteknologi"),        // enumkonstanten IT
        Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
        Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

        private final String fulltnavn;      // instansvariabel
        private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

        public String toString() { return fulltnavn; }
    }

    public enum Måned
    {
        JAN (1),
        FEB (2),
        MAR (3),
        APR (4),
        MAI (5),
        JUN (6),
        JUL (7),
        AUG (8),
        SEP (9),
        OKT (10),
        NOV (11),
        DES (12);

        private final int mndNr;

        Måned(int mndNr) { this.mndNr = mndNr; } //Konstruktør, setter verdien i objectet til verdien som skal vises.

        public int mndNr() { return mndNr; } //Returnerer verdien til enumVariabelen

        public static void vår() {
            //april og mai
            System.out.println("April : " + APR.mndNr());
            System.out.println("Mai : " + MAI.mndNr());
        }

        public static void sommer() {
            // Juni, jui og august
            System.out.println("Juni : " + JUN.mndNr());
            System.out.println("JULI : " + JUL.mndNr());
            System.out.println("August : " + AUG.mndNr());
        }

        public static void høst() {
            //September og oktober
            System.out.println("Septmeber : " + SEP.mndNr());
            System.out.println("Oktober : " + OKT.mndNr());
        }

        public static void vinter() {
            //November, desember, januar, februar og mars
            System.out.println("November : " + NOV.mndNr());
            System.out.println("Desember : " + DES.mndNr());
            System.out.println("Januar : " + JAN.mndNr());
            System.out.println("Februar : " + FEB.mndNr());
            System.out.println("Mars : " + MAR.mndNr());
        }
    }
}

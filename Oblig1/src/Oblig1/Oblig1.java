package Oblig1;

import java.util.*;
import java.util.ArrayList;
import java.lang.UnsupportedOperationException;

public class Oblig1 {
    private Oblig1() {}

    /********************* Oppgave 1 *********************/
    public static int maks(int[] tallrekke) {
        if ( tallrekke.length< 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }
        int begin = 0;
        int end = tallrekke.length -1;
        int max = tallrekke[0];
        for (int i = begin; i < end; i++) {
            if(tallrekke[i]>tallrekke[i+1]){
                max = tallrekke[i];
                tallrekke[i] = tallrekke[i+1];
                tallrekke[i+1] = max;
            }else if(tallrekke[i+1]>max){
                max=tallrekke[i+1];
            }
        }
        return max; //Returnerer den maksimale verdien i tallrekken
    }

    public static int ombyttinger(int[] tallrekke) {
        if ( tallrekke.length< 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }
        int begin = 0;
        int end = tallrekke.length - 1;
        int byttet = 0;
        for (int i = begin; i <end; i++) {
            if(tallrekke[i]>tallrekke[i+1]){
                int temp = tallrekke[i];
                tallrekke[i] = tallrekke[i+1];
                tallrekke[i+1] = temp;
                byttet += 1;
            }
        }
        return byttet; //Returnerer hvor mange ganger det ble gjennomført ombytter
    }

    /********************* Oppgave 2 *********************/
    public static int antallUlikeSortert(int[] tallrekke) {
        if(tallrekke.length == 0){
            //System.out.println("Tabellen er tom og har derfor "+ 0 +" forskjellige verdier");
            return 0;
        }
        else {
            int end = tallrekke.length - 1;
            for (int i = 0; i < end; i++) {
                if (tallrekke[i + 1] < tallrekke[i]) {
                    throw new IllegalStateException("Tabellen er ikke sortert stigende!");
                }
            }
            int forskjell = 1;
            for (int i = 0; i < end; i++) {
                if (tallrekke[i] != tallrekke[i + 1]) {
                    forskjell += 1;
                }
            }
            return forskjell; // returnerer antall forskjellige verdier i tallrekken
        }
    }

    /********************* Oppgave 3 *********************/
    public static int antallUlikeUsortert(int[] tallrekke) {
        if(tallrekke.length == 0){
            return 0;
        }
        else {
            ArrayList<Integer> differentValues = new ArrayList<Integer>();
            for(int tall : tallrekke){
                if(!differentValues.contains(tall)){
                    differentValues.add(tall);
                }
            }
            return differentValues.size();
        }
    }

    /********************* Oppgave 4 *********************/
    public static void delsortering(int[] tallrekke) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 5 *********************/
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 6 *********************/
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 7 *********************/
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 8 *********************/
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 9 *********************/
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    /********************* Oppgave 10 *********************/
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1

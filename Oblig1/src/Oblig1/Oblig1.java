package Oblig1;

import jdk.jshell.execution.Util;

import java.sql.Array;
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
   /*
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
*/
    public static int antallUlikeUsortert(int[] tallrekke) {
        int n = tallrekke.length;
        if(n == 0){
            return 0;
        } else {
            int[] kopi = tallrekke.clone();
            kvikksortering(kopi, 0 , n-1);
            int forskjell = antallUlikeSortert(kopi);
            return forskjell;
        }
    }

    private static void kvikksortering(int[] a, int v, int h)  // hentet fra boka: programkode 1.3.9 h)
        {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    private static int sParter0(int[] a, int v, int h, int indeks) // hentet fra boka: programkode 1.3.9 f)
    {
        byttInt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        byttInt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
    private static int parter0(int[] a, int v, int h, int skilleverdi) // hentet fra boka: programkode 1.3.9 a)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) byttInt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static void byttInt(int[] a, int v, int h){
        int temp = a[v]; a[v] = a[h]; a[h] = temp;
    }

    /********************* Oppgave 4 *********************/
    public static void delsortering(int[]a){
        int v= 0;
        int h = a.length-1;
        int første_partall = 0;
        int k = (v+h)/2; //deler array i to

        //finner ut partall
        while(v<h){
            while(a[v]%2!=0 && v<a.length-1){
                v++;
            }

            //finner ut odetall
            while (a[h]%2== 0 && h >=1){
                h--;
            }

            // sorterer odetall og partall
            if(v<h){
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;
            }

            første_partall = v;

        }
        //sorterer odetall
        for(int i = 1; i < første_partall; i++){
            int cur = a[i];
            int prev = i-1;

            while (prev >= 0 && a[prev]>cur){
                a[prev+1] = a[prev];
                prev = prev-1;
            }
            a[prev+1]=cur;

        }
        //sorterer partall
        for(int i = første_partall+1; i <a.length; i++){
            int cur = a[i];
            int prev = i-1;

            while (prev >= første_partall && a[prev]>cur){
                a[prev+1] = a[prev];
                prev = prev-1;
            }
            a[prev+1]=cur;
        }
    }

    /********************* Oppgave 5 *********************/
    public static void rotasjon(char[] a)
    {
        int n = 1;

        if (a == null) {

        }

        else if(a.length>0) {
            int sisteElement = a[a.length - 1];
            for (int j = a.length - 1; j > 0; j--) {
                    a[j] = a[j - 1];
            }
            a[0] = (char) sisteElement;
        }
    }

    /********************* Oppgave 6 *********************/
    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void rotasjon(char[] a, int d)             // 2. versjon
    {
        int n = a.length;
        if (n < 2) return;                                     // tomt eller en verdi

        if ((d %= n) < 0) d += n;                              // motsatt vei?

        for (int v = 0, h = n - 1; v < h; bytt(a, v++, h--));  // snur a[a:n>
        for (int v = 0, h = d - 1; v < h; bytt(a, v++, h--));  // snur a[0:d>
        for (int v = d, h = n - 1; v < h; bytt(a, v++, h--));  // snur a[d:n>
    }
    /*
    public static void rotasjon(char[] a, int k) {

        String rotation;

        if (k < 0) {
            k = -k;
            rotation = "left";
        } else {
            rotation = "right";
        }

        if (k < a.length) {
            char temp;
            int j, i;
            int n = a.length-1;
            for (i = 0; i < k; i++) {
                if (rotation.equals("left")) {
                    temp = a[0];
                    for (j = 0; j < n; j++) {
                        a[j] = a[j + 1];
                    }
                } else {
                    temp = a[n];
                    for (j = n; j > 0; j--) {
                        a[j] = a[j - 1];
                    }
                }
                a[j] = temp;
            }
        }
    }
*/
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
    public static int[] indekssortering(int[] tallrekke) {

        int n = tallrekke.length;
        int[] index = new int[n];
        int[] klone = tallrekke.clone();
        if(n > 1) {
            int maxVar = tallrekke[maksPos(klone)] + 1;
            for (int i = 0; i <n ; i++) {
                int minPos = min(klone);
                index[i] = minPos;
                klone[minPos] = maxVar;
            }
        }
      
        return index;
    }

    public static int min(int[] tallrekke){
        int end = tallrekke.length;
        int minPos = 0;
        int minst = tallrekke[minPos];

        for (int i = 1; i < end ; i++) {
            if(tallrekke[i]<minst){
                minst = tallrekke[i];
                minPos = i;
            }
        }
        return minPos;
    }

    public static int maksPos(int[] tallrekke){
        int end = tallrekke.length;
        int maxPos = 0;
        int maks = tallrekke[maxPos];
        for (int i = 1; i < end ; i++) {
            if (tallrekke[i]> maks){
                maxPos = i;
                maks = tallrekke[maxPos];
            }
        }
        return maxPos;
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


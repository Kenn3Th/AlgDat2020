import java.util.NoSuchElementException;

public class Uke34 {
    public static void main(String[] args){
        int[] listeMedTall = new int[]{8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        int minste, storste;
        minste = min(listeMedTall);
        storste = max(listeMedTall);
        //Printer resultatet fra seksjon 1.1.2
        System.out.println("*_*_*_*_*_*_* Seksjon 1.1.2 *_*_*_*_*_*_*_*_*\n");
                System.out.println("******* Oppgave 2 og 3 *********");
        System.out.println("Minste verdien er "+listeMedTall[minste]+
                " største verdien er "+listeMedTall[storste]);
        //Printer resultatet fra seksjon 1.1.3
        System.out.println("\n*_*_*_*_*_*_* Seksjon 1.1.3 *_*_*_*_*_*_*_*_*\n");
        System.out.println("******* Oppgave 5 *********");
        System.out.println("Minst: "+ listeMedTall[maxMin(listeMedTall)[0]] + " størst: " +
                listeMedTall[maxMin(listeMedTall)[1]]);
        System.out.println("******* Oppgave 6 *********");
        System.out.println("3 fakultet er " + fak(3));
        System.out.println("5 fakultet er " + fak(5));
        System.out.println("8 fakultet er " + fak(8));
    }

    /***** Seksjon 1.1.2 *****/
    //Oppgave 2
    public static int min(int[] tallArray){
        if (tallArray.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int minPos = 0; //Posisjonen til den minste verdien, starter med første indeks i array
        for(int tall = 1; tall<tallArray.length; tall++){
            if( tallArray[tall]<tallArray[minPos]){
                minPos = tall;
            }
        }
        return minPos;
    }

    //Oppgave 3
    public static int max(int[] tallArray){
        if (tallArray.length < 1){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int maxPos = 0; //Samenligningen starter med første indeks i array
        int maxVerdi = tallArray[0];
        for(int tall = 1; tall<tallArray.length; tall++){
            if( tallArray[tall] >= maxVerdi) { // >= gjør at det er den siste maksverdi posisjonen vises
                maxPos = tall;
                maxVerdi = tallArray[tall];
            }
        }
        return maxPos;
    }

    /***** Seksjon 1.1.3 *****/
    //Oppgave 5
    public static int[] maxMin(int[] tallArray){
        if (tallArray.length < 2){
            throw new NoSuchElementException("Tabellen er for liten!");
        }
        int minst = 0;
        int maks = 0;
        /*
        Hvis jeg kunne gjenbrukt kode
        minst = min(tallArray);
        maks = max(tallArray);
         */

        for(int pos = 1; pos < tallArray.length; pos++){
            if (tallArray[minst]>tallArray[pos]){
                minst = pos;
            }
            else if (tallArray[maks]<tallArray[pos])
                maks = pos;
        }

        int[] b = {minst,maks};
        return b;
    }

    //Oppgave 6
    public static int fak(int tall){
        if(tall <= 0){
            throw new NoSuchElementException("Tallet må være større enn 0");
        }
        int n = 1;
        for(int i = 2; i<=tall; i++){
            n *= i;
        }
        return n;
    }
}

public class Uke35 {
    public static void main(String[] args){
        //oppgave 1 fra seksjon 1.2.1
        int[] tallrekke = new int[]{4,3,3,2,17,11,5,6,10,13,2,6,8};

        System.out.println(tallrekke[minMetode1(tallrekke,4,10)]); // denne skal gi 5
        System.out.println(tallrekke[minMetode2(tallrekke,4,10)]); // denne skal gi 2

        //oppgave 5 fra seksjon 1.2.1
        System.out.println("Tallrekken vi gikk gjennom var: ");
        for(int tall : tallrekke)System.out.print(tall + " ");
        System.out.println("\nder første intervallet var [4,10), og andre intervallet [4,10]");
    }
    /***** Seksjon 1.2.1 *****/
    //metode 1 har intervallet [fra,til)
    public static int minMetode1(int[] rekke, int fra, int til){
        if (fra < 0 || til > rekke.length || fra > til){
            throw new IllegalArgumentException("Illegalt intervall!");
        }
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
        if (v < 0 || h > rekke.length || v > h){
            throw new IllegalArgumentException("Ulovlig intervall!");
        }
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
}

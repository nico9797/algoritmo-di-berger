public class Berger {
String[][] calendario=new String[760][4];
    Berger(){
        String [] squadre = {"Juventus", "Inter", "Milan", "Roma", "Napoli", "Lazio", "Atalanta", "Fiorentina", "Cremonese", "Salernitana", "Spezia", "Sassuolo", "Torino", "Sampdoria", "Bologna", "Empoli", "Udinese", "Verona", "Lecce", "Monza"};
        int n = 20;
        int giornate = n - 1;

        String[] casa = new String[n / 2];
        String[] fuori = new String[n / 2];

        for (int i = 0; i < n / 2; i++) {
            casa[i] = squadre[i];
            fuori[i] = squadre[n - 1 - i];
        }
        for (int i = 0; i < giornate*2; i++) {
            /* stampa le partite di questa giornata */
            //System.out.printf("%d^ Giornata\n", i + 1);
            //
                for (int j = 0; j < n / 2; j++) {
                    //System.out.printf("%d %s - %s\n", j + 1, casa[j], fuori[j]);
                    addCalendario(casa[j],fuori[j]);

                }
            String pivot = casa[0];
            String riporto = fuori[fuori.length - 1];

            fuori = shiftRight(fuori, casa[1]);
            casa = shiftLeft(casa, riporto);
            casa[0] = pivot;
        }
    }
    //senso orario
     void stampaCalendario(){
        int k=0;
        int g=2;
         System.out.println("\n GIORNATA"+1);
        for(int i=0;i<380;i++){
                if(k==10){
                    k=0;
                    System.out.println("\n GIORNATA"+g); g++;
                }
                System.out.println(calendario[i][0] + " - " + calendario[i][1]);
                k++;
            }
    }
    void addCalendario(String s1,String s2){
        int i=0;
        boolean e=false;
        while(!e) {
            if (calendario[i][0] != null && calendario[i][1] != null) {
                i++;
            }
            else {
                calendario[i][0] = s1; calendario[i][1] = s2;
                e = true;
            }
        }
    }
    private String[] shiftRight(String[] data, String add) {
        String[] temp = new String[data.length];
        for (int i = 1; i < data.length; i++) {
            temp[i] = data[i - 1];
        }
        temp[0] = add;
        return temp;
    }
    private String[] shiftLeft(String[] data, String add) {
        String[] temp = new String[data.length];
        for (int i = 0; i < data.length-1; i++) {
            temp[i] = data[i + 1];
        }
        temp[data.length - 1] = add;
        return temp;
    }
}
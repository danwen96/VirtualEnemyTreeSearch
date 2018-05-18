package WirtualnyPrzeciwnik;

import java.util.Random;

/**Klasa ktora dzieki zawartym algorytmom przeszukiwania drzewa decyzyjnego umozliwia gre z AI
 */
public class WirtualnyPrzeciwnik {
    DrzewoDecyzyjne drzewoDecyzyjne;
    private int stronaPlanszy; // strona po ktorej gra skomputer 1 oznacza krzyzyk 0 kolo
    private static int glebokosc = 0;

    /**Metoda na podstawie dostarczonego drzewa decyzyjnego zwraca index ruchu komputera uzywajac do tego ustalonego algorytmu
     * @param drzewoDecyzyjne przyjmuje zbudowane wczesniej drzewo decyzyjne
     * @return zwraca index ruchu do podjecia
     */
    public int zwrocRuch(DrzewoDecyzyjne drzewoDecyzyjne) {//TO DO
//        int indexMax= 0;
//        int wartoscMax = -1;
//        for (int i = 0; i < drzewoDecyzyjne.rodzice.size(); i++) {
//            if(wartoscMax<drzewoDecyzyjne.rodzice.get(i).wartosc)
//            {
//                wartoscMax = drzewoDecyzyjne.rodzice.get(i).wartosc;
//                indexMax = i;
//            }
//            if(i%3 == 0)
//                System.out.println();
//            System.out.print(drzewoDecyzyjne.rodzice.get(i).wartosc+ "  ");
//        }
//        System.out.println("Rozmiar : "+drzewoDecyzyjne.rodzice.size());
//        return drzewoDecyzyjne.indexyOdpowiadajace.get(indexMax);

        return drzewoDecyzyjne.indexyOdpowiadajace.get(minMax(drzewoDecyzyjne));
    }


    /**Algorytm mini-max przeszukiwania drzewa decyzyjnege
     * @param drzewoDecyzyjne drzewo decyzyjne do przeszukania
     * @return zwraca index z drzewa decyzyjnego z najlepsza wedlug tego algorytmu wartoscia
     */
    public int minMax(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        //TO DO
        int max = Integer.MIN_VALUE;
        int id = 0;
        for(int i = 0;i<drzewoDecyzyjne.rodzice.size();i++)
        {
            glebokosc++;
            int tmp = minMaxReqursiveCall(drzewoDecyzyjne.rodzice.get(i),0);
            glebokosc--;
            //tmp += drzewoDecyzyjne.rodzice.get(i).wartosc;
            System.out.println("glebokosc "+glebokosc +" " +tmp + " ");
            if(tmp>max)
            {
                id = i;
                max = tmp;
            }
        }

        return id;
    }


    /**
     * Rekursywna metoda uzywana w funkcji minMax zwracajaca najwieksza albo najmniejsza wartosc dziecka w zaleznosci od glebokosci przeszukania
     * @param elementDrzewa element drzewa dla ktorego beda szukane wartosci
     * @param operacja 1 oznacza zwrocenie max 0 mininimum, przechodzac wglab powinna zmieniac sie na przemian
     * @return najwieksza albo najmniejsza wartosc
     * @see ElementDrzewa
     */
    private int minMaxReqursiveCall(ElementDrzewa elementDrzewa, int operacja)
    {
        if(elementDrzewa.dzieci.isEmpty())
        {
            //System.out.println("Doszlo do dziecka z wartoscia: " + elementDrzewa.wartosc);
            return elementDrzewa.wartosc;
        }

        if(operacja == 1) //wlasny ruch - szukanie maximum
        {
            int max = Integer.MIN_VALUE;
            int id = 0;

            for (int i = 0; i < elementDrzewa.dzieci.size(); i++) {
                glebokosc++;
                int tmp = minMaxReqursiveCall(elementDrzewa.dzieci.get(i),0);
                glebokosc--;
                //tmp += elementDrzewa.dzieci.get(i).wartosc;
               // System.out.println("glebokosc "+glebokosc +" " +tmp + " ");
                if(tmp > max)
                {
                    //id = i;
                    max  = tmp;
                }
            }
            return max;
        }
        else // przeciwnik - szukanie minimum
        {
            int min = Integer.MAX_VALUE;
            int id = 0;

            for (int i = 0; i < elementDrzewa.dzieci.size(); i++) {
                glebokosc++;
                int tmp = minMaxReqursiveCall(elementDrzewa.dzieci.get(i),1);
                glebokosc--;
                //tmp += elementDrzewa.dzieci.get(i).wartosc;
                //System.out.println("glebokosc "+glebokosc +" " +tmp + " ");
                if(tmp < min)
                {
                    //id = i;
                    min  = tmp;
                }
            }
            return min;
        }
    }

    /**
     * //TO DO
     */
    int alphaBeta(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        //TO DO
        return 0;
    }

    /**Metoda zwraca calkowicie losowy ruch, moze byc uzywana do testow
     * @param drzewoDecyzyjne drzewo decyzyjne dla ktorego index ruchu ma byc zwrocony
     * @return index ruchu w otrzymanym drzewie decyzyjnym
     */
    int fullRand(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        Random random = new Random();

        return random.nextInt(drzewoDecyzyjne.rodzice.size());
    }


    public int getStronaPlanszy() {
        return stronaPlanszy;
    }

    public void setStronaPlanszy(int stronaPlanszy) {
        this.stronaPlanszy = stronaPlanszy;
    }

}

import java.util.Random;

public class WirtualnyPrzeciwnik {
    DrzewoDecyzyjne drzewoDecyzyjne;
    int stronaPlanszy; // strona po ktorej gra skomputer 1 oznacza krzyzyk 0 kolo
    static int glebokosc = 0;

    //metoda majaca zwrocic ruch komputera
    int zwrocRuch(DrzewoDecyzyjne drzewoDecyzyjne) {//TO DO
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


    //implementacja algorytmow przeszukiwania drzewa za pomoca ktorych bedzie zwracany ruch
    int minMax(DrzewoDecyzyjne drzewoDecyzyjne)
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
     * Rekursywna metoda uzywana w funkcji minMax zwracajaca najwieksza albo najmniejsza wartosc dziecka w zaleznosci
     *
     * @param elementDrzewa element drzewa dla ktorego beda szukane wartosci
     * @param operacja 1 oznacza zwrocenie max 0 mininimum
     * @return najwieksza albo najmniejsza wartosc
     * @see ElementDrzewa
     */
    int minMaxReqursiveCall(ElementDrzewa elementDrzewa,int operacja)
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
                    id = i;
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
                    id = i;
                    min  = tmp;
                }
            }
            return min;
        }
    }

    int alphaBeta(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        //TO DO
        return 0;
    }

    int fullRand(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        Random random = new Random();

        return random.nextInt(drzewoDecyzyjne.rodzice.size());
    }

}

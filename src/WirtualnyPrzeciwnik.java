import java.util.Random;

public class WirtualnyPrzeciwnik {
    DrzewoDecyzyjne drzewoDecyzyjne;


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
        return drzewoDecyzyjne.indexyOdpowiadajace.get(fullRand(drzewoDecyzyjne));
    }


    //implementacja algorytmow przeszukiwania drzewa za pomoca ktorych bedzie zwracany ruch
    int minMax(DrzewoDecyzyjne drzewoDecyzyjne)
    {
        //TO DO
        return 0;
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

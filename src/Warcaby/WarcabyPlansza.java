package Warcaby;

/** Klasa zawierajaca plansze do warcab // TO DO
 */
public class WarcabyPlansza {
    private char tab[][];

    /**Tworzenie nowej tablicy i wypelnienie jej
     *
     */
    WarcabyPlansza()
    {
        tab = new char[8][8];
        wypelnijPlanszeNaStartGry();
    }

    /**
     * Wypelnienie planszy wartosciami odzworujacymi pionki w warcabach, po 3 rzedy pionkow z dwoch stron
     */
    void wypelnijPlanszeNaStartGry()
    {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = '-';
            }
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = (i%2 == 0)? 0:1; j < tab.length; j+=2) {
                if(i<=2)
                    tab[i][j] = '@';
                else if(i>=5)
                    tab[i][j] = '#';
                else
                    tab[i][j] = '_';
            }
        }
    }

    /**
     * Wyswietlanie planszy razem z indeksami danych pol
     */
    void wyswietlPlansze()
    {
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.print((char)('a'+i));
            System.out.println();
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print((i+1)+" ");
        }
        System.out.println();
    }

    /**
     * Metoda obslugujaca potrzebe ruszenia sie pionkiem
     * @param i indeks wiersza pionka do ruszenia
     * @param j indeks kolumny pionka do ruszenia
     * @param k indeks pola na ktore chcemy sie ruszyc
     * @param l indeks pola na ktore chcemy sie ruszyc
     * @return true jesli sie udalo, false jesli podane argumenty sa nieprawidlowe
     */
    boolean ruszPionek(char i,int j,char k,int l)
    {
        //TO DO
        return false;
    }

    public static void main(String[] args) {
        WarcabyPlansza warcabyPlansza = new WarcabyPlansza();
        warcabyPlansza.wyswietlPlansze();
    }



}

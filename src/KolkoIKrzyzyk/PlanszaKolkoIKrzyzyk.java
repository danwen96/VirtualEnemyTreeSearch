package KolkoIKrzyzyk;

/**Klasa zawierajaca plansze do gry w kolko i krzyzyk i metody umozliwiajace uzywanie na niej podstawowych akcji
 */
public class PlanszaKolkoIKrzyzyk {
    public char[][] plansza;

    private int n = 3;

    int getN() {
        return n;
    }

    /**Tworzenie nowej tablicy charow i wyzerowanie ich
     */
    PlanszaKolkoIKrzyzyk() {
        plansza = new char[n][n];
        wyczysc();
    }

    /**Metoda zerujaca tablice plansza
     */
    void wyczysc(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                plansza[i][j] = '-';
            }
        }
    }

    /**Metoda umieszczajaca kolko na danych wspolrzednych
     * @param k wsporzedna pola x
     * @param l wspolrzedna pola y
     */
    void umiescKolko(int k,int l)
    {
        plansza[k][l] = 'o';
    }

    /**Metoda umieszczajaca krzyz na danych wspolrzednych
     * @param k wsporzedna pola x
     * @param l wspolrzedna pola y
     */
    void umiescKrzyzyk(int k,int l)
    {
        plansza[k][l] = 'x';
    }

    /**Metoda wyswietlajaca sformatowana plansze w terminalu
     */
    public void wyswietlPlansze()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(plansza[i][j] +"  ");
            }
            System.out.println();
        }
    }

    /**Metoda kopiujaca plansze z podanego obiektu KolkoIKrzyzyk.PlanszaKolkoIKrzyzyk do tego obiektu
     * @param plansza plansza z ktorej elementy beda skopiwane
     */
    void skopiujTablice(PlanszaKolkoIKrzyzyk plansza)
    {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                this.plansza[i][j] = plansza.plansza[i][j];
//            }
//        }
        System.arraycopy(plansza.plansza,0,this.plansza,0,n);
    }

    /**
     * @return zwraca true jesli jest jeszcze miejsce na ruch na planszy
     */
    public boolean sprawdzCzyJestJeszczeWolnePole()
    {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (plansza[i][j] == '-')
                    return true;
            }
        }
        return false;
    }


    /** Metoda sprawdza czy na planszy nie zaszla sytuacja oznaczajaca wygrana ktorejs ze stron
     * @return 0 gdy jeszcze nikt nie wygral, 1 gdy wygra kollko, 2 gdy krzyzyk
     */
    public int sprawdzWygrana()
    {
        boolean sprawdzenieo = true;
        boolean sprawdzeniex = true;
        boolean sprawdzenieo2 = true;
        boolean sprawdzeniex2 = true;

        //sprawdzenie w wierszach
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(plansza[i][j] != 'o')
                    sprawdzenieo = false;
                if(plansza[i][j] != 'x')
                    sprawdzeniex = false;
                if(plansza[j][i] != 'o')
                    sprawdzenieo2 = false;
                if(plansza[j][i] != 'x')
                    sprawdzeniex2 = false;
            }
            if(sprawdzenieo)
                return 1;
            if(sprawdzeniex)
                return 2;
            if(sprawdzenieo2)
                return 1;
            if(sprawdzeniex2)
                return 2;
            sprawdzenieo = true;
            sprawdzeniex = true;
            sprawdzenieo2 = true;
            sprawdzeniex2 = true;
        }

        for (int i = 0; i < n; i++) {
            if(plansza[i][i] != 'o')
                sprawdzenieo = false;
            if(plansza[n-i-1][i] != 'o')
                sprawdzenieo2 = false;
            if(plansza[i][i] != 'x')
                sprawdzeniex = false;
            if(plansza[n-i-1][i] != 'x')
                sprawdzeniex2 = false;
        }

        if(sprawdzenieo)
            return 1;
        if(sprawdzeniex)
            return 2;
        if(sprawdzenieo2)
            return 1;
        if(sprawdzeniex2)
            return 2;

        return 0;
    }
}


public class PlanszaKolkoIKrzyzyk {
    public char[][] plansza;

    private int n = 3;

    int getN() {
        return n;
    }

    PlanszaKolkoIKrzyzyk() {
        plansza = new char[n][n];
        wyczysc();
    }

    void wyczysc(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                plansza[i][j] = '-';
            }
        }
    }

    void umiescKolko(int k,int l)
    {
        plansza[k][l] = 'o';
    }

    void umiescKrzyzyk(int k,int l)
    {
        plansza[k][l] = 'x';
    }

    void wyswietlPlansze()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(plansza[i][j] +"  ");
            }
            System.out.println();
        }
    }

    void skopiujTablice(PlanszaKolkoIKrzyzyk plansza)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.plansza[i][j] = plansza.plansza[i][j];
            }
        }
    }

    boolean sprawdzCzyJestJeszczeWolnePole()
    {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (plansza[i][j] == '-')
                    return true;
            }
        }
        return false;
    }


    // 0 gdy jeszcze nikt nie wygral, 1 gdy wygra kollko, 2 gdy krzyzyk, 3 gdy remis
    int sprawdzWygrana()
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
            if(sprawdzenieo == true)
                return 1;
            if(sprawdzeniex == true)
                return 2;
            if(sprawdzenieo2 == true)
                return 1;
            if(sprawdzeniex2 == true)
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

        if(sprawdzenieo == true)
            return 1;
        if(sprawdzeniex == true)
            return 2;
        if(sprawdzenieo2 == true)
            return 1;
        if(sprawdzeniex2 == true)
            return 2;

        return 0;
    }
}


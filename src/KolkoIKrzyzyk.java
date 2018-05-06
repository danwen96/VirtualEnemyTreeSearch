import java.util.Random;
import java.util.Scanner;

public class KolkoIKrzyzyk implements MozliwoscGryAI {

    PlanszaKolkoIKrzyzyk planszaKolkoIKrzyzyk;
    //PlanszaKolkoIKrzyzyk planszaDoPrzewidywania;
    WirtualnyPrzeciwnik wirtualnyPrzeciwnik;

    KolkoIKrzyzyk() {
        planszaKolkoIKrzyzyk = new PlanszaKolkoIKrzyzyk();
    }

    void graMiedzyDwomaGraczami() {//metoda umozliwiajaca gra miedzy dwoma graczami stworzona w ramach testow
        int tura = 0;
        Random random = new Random();
        if( random.nextInt()<0)
        {
            tura = 1;
        }
        System.out.println("Tura = " + tura);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < planszaKolkoIKrzyzyk.getN() * planszaKolkoIKrzyzyk.getN(); i++) {
            planszaKolkoIKrzyzyk.wyswietlPlansze();
            if (tura == 0) {
                System.out.println("\n\nPodaj wspolrzedne ruchu pierwszego gracza");
                int k = scanner.nextInt();
                int l = scanner.nextInt();
                planszaKolkoIKrzyzyk.umiescKolko(k, l);
                if (planszaKolkoIKrzyzyk.sprawdzWygrana() == 1) {
                    planszaKolkoIKrzyzyk.wyswietlPlansze();
                    System.out.println("Wygral pierwszy gracz");
                    return;
                }
                tura = 1;
                continue;
            }

            if (tura == 1) {
                System.out.println("\n\nPodaj wspolrzedne ruchu drugiego gracza");
                int k = scanner.nextInt();
                int l = scanner.nextInt();
                planszaKolkoIKrzyzyk.umiescKrzyzyk(k, l);
                if (planszaKolkoIKrzyzyk.sprawdzWygrana() == 2) {
                    planszaKolkoIKrzyzyk.wyswietlPlansze();
                    System.out.println("Wygral drugi gracz");
                    return;
                }
                tura = 0;
                continue;
            }
        }
        System.out.println("Gra zakonczona remisem");
    }

    // metoda rozpoczynajaca gre z komputerem
    void graZKomputerem(){ //TO DO
        WirtualnyPrzeciwnik wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik();
        this.wirtualnyPrzeciwnik = wirtualnyPrzeciwnik;
        int tura = 0;
        Random random = new Random();
        if( random.nextInt()<0)
        {
            tura = 1;
        }
        System.out.println("Tura = " + tura);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < planszaKolkoIKrzyzyk.getN() * planszaKolkoIKrzyzyk.getN(); i++) {
            planszaKolkoIKrzyzyk.wyswietlPlansze();
            if (tura == 0) {
                int k;
                int l;
                do {
                    System.out.println("\n\nPodaj wspolrzedne ruchu pierwszego gracza");
                    k = scanner.nextInt();
                    l = scanner.nextInt();
                }while(planszaKolkoIKrzyzyk.plansza[k][l] != '-');
                planszaKolkoIKrzyzyk.umiescKolko(k, l);
                if (planszaKolkoIKrzyzyk.sprawdzWygrana() == 1) {
                    planszaKolkoIKrzyzyk.wyswietlPlansze();
                    System.out.println("Wygral pierwszy gracz");
                    return;
                }
                tura = 1;
                continue;
            }

            if (tura == 1) {
                wirtualnyPrzeciwnik.stronaPlanszy = tura;
                int zwrot = wirtualnyPrzeciwnik.zwrocRuch(zbudujDrzewo(tura));//ruch komputera jest uzyskiwany za pomoca klasy WirtualnyPrzeciwnik

                System.out.println("\n\nZwrocono " + zwrot);
                int k = zwrot/planszaKolkoIKrzyzyk.getN();
                int l = zwrot%planszaKolkoIKrzyzyk.getN();
                planszaKolkoIKrzyzyk.umiescKrzyzyk(k, l);
                if (planszaKolkoIKrzyzyk.sprawdzWygrana() == 2) {
                    planszaKolkoIKrzyzyk.wyswietlPlansze();
                    System.out.println("Wygral drugi gracz");
                    return;
                }
                tura = 0;
                continue;
            }
        }
        System.out.println("Gra zakonczona remisem");

    }


    @Override
    public DrzewoDecyzyjne zbudujDrzewo(int aktualnyGracz)// budowanie drzewa decyzyjnego wymaganego przez interfejs mozliwoscAI, w celu mozliwosci gry z komputerem
    {

        // 9 mozliwych ruchow na start gry
        char znak;
        if(aktualnyGracz==0)
            znak = 'o';
        else
            znak = 'x';

        DrzewoDecyzyjne drzewoDecyzyjne = new DrzewoDecyzyjne();
        int wartoscRuchu = 0;

//        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
//            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
//                wartoscRuchu = 0;
//                if(planszaKolkoIKrzyzyk.plansza[k][l] != '-')
//                {
//                    continue;
//                }
//                for (int i = 0; i < planszaKolkoIKrzyzyk.getN(); i++) {
//                    for (int j = 0; j < planszaKolkoIKrzyzyk.getN(); j++) {
//                        if(i != k || l != j) {
//                            if (planszaKolkoIKrzyzyk.plansza[i][j] == '-') {
//                                if (i == k)
//                                    wartoscRuchu++;
//                                if (l == j)
//                                    wartoscRuchu++;
//                                if (k == l && i == j)
//                                    wartoscRuchu++;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu++;
//                            } else if(planszaKolkoIKrzyzyk.plansza[i][j] == znak) {
//                                if (i == k)
//                                    wartoscRuchu+=10;
//                                if (l == j)
//                                    wartoscRuchu+=10;
//                                if (k == l && i == j)
//                                    wartoscRuchu+=10;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu+=10;
//                            } else {
//                                if (i == k)
//                                    wartoscRuchu-=0;
//                                if (l == j)
//                                    wartoscRuchu-=0;
//                                if (k == l && i == j)
//                                    wartoscRuchu-=0;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu-=0;
//                            }
//
//                        }
//                    }
//                }
//                drzewoDecyzyjne.dodajRodzica(k,l,wartoscRuchu,k*planszaKolkoIKrzyzyk.getN() + l);
//
//            }
//        }

        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
                wartoscRuchu = 0;
                if (planszaKolkoIKrzyzyk.plansza[k][l] != '-') {
                    continue;
                }
                else{
                    drzewoDecyzyjne.dodajRodzica(k,l,0,k*planszaKolkoIKrzyzyk.getN() + l);
                }
            }
        }


        PlanszaKolkoIKrzyzyk tmp;
        for (int i = 0; i < drzewoDecyzyjne.rodzice.size(); i++) {//budowanie drzewa rekurencyjnie przy pomocy metody dodajMozliweScenariusze
            tmp = new PlanszaKolkoIKrzyzyk();
            tmp.skopiujTablice(planszaKolkoIKrzyzyk);
            tmp.plansza[drzewoDecyzyjne.rodzice.get(i).indi][drzewoDecyzyjne.rodzice.get(i).indj] = znak;
            if(aktualnyGracz == 0)
                dodajMozliweScenariusze(drzewoDecyzyjne.rodzice.get(i),tmp,1);
            else
                dodajMozliweScenariusze(drzewoDecyzyjne.rodzice.get(i),tmp,0);

        }

        //TO DO



        return drzewoDecyzyjne;
    }

    private void dodajMozliweScenariusze(ElementDrzewa elementDrzewa,PlanszaKolkoIKrzyzyk planszaKolkoIKrzyzyk,int aktualnyGracz)//dalszy etap budowania drzewa wykorzystany w metodzie zbudujDrzewo
    {
        char znak;
        if(aktualnyGracz==0)
            znak = 'o';
        else
            znak = 'x';
        int wartoscRuchu;

        if(planszaKolkoIKrzyzyk.sprawdzWygrana() != 0) {
           // planszaKolkoIKrzyzyk.wyswietlPlansze();
            if(aktualnyGracz != wirtualnyPrzeciwnik.stronaPlanszy)// tu jest sprawdzana wygranego poprzedniego gracza a nie aktulanego wiec musi byc !=
                elementDrzewa.wartosc +=10000;
            else elementDrzewa.wartosc -= 10000;
            return;
        }

//        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
//            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
//                wartoscRuchu = 0;
//                if(planszaKolkoIKrzyzyk.plansza[k][l] != '-')
//                {
//                    continue;
//                }
//                for (int i = 0; i < planszaKolkoIKrzyzyk.getN(); i++) {
//                    for (int j = 0; j < planszaKolkoIKrzyzyk.getN(); j++) {
//                        if(i != k || l != j) {
//                            if (planszaKolkoIKrzyzyk.plansza[i][j] == '-') {
//                                if (i == k)
//                                    wartoscRuchu++;
//                                if (l == j)
//                                    wartoscRuchu++;
//                                if (k == l && i == j)
//                                    wartoscRuchu++;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu++;
//                            } else if(planszaKolkoIKrzyzyk.plansza[i][j] == znak) {
//                                if (i == k)
//                                    wartoscRuchu+=10;
//                                if (l == j)
//                                    wartoscRuchu+=10;
//                                if (k == l && i == j)
//                                    wartoscRuchu+=10;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu+=10;
//                            } else {
//                                if (i == k)
//                                    wartoscRuchu-=0;
//                                if (l == j)
//                                    wartoscRuchu-=0;
//                                if (k == l && i == j)
//                                    wartoscRuchu-=0;
//                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
//                                    wartoscRuchu-=0;
//                            }
//
//                        }
//                    }
//                }
//                if(aktualnyGracz != wirtualnyPrzeciwnik.stronaPlanszy)
//                    wartoscRuchu = -wartoscRuchu;
//                elementDrzewa.dodajDziecko(k,l,wartoscRuchu,k*planszaKolkoIKrzyzyk.getN() + l);
//
//            }
//        }
        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
                wartoscRuchu = 0;
                if (planszaKolkoIKrzyzyk.plansza[k][l] != '-') {
                    continue;
                }
                else{
                    elementDrzewa.dodajDziecko(k,l,0,k*planszaKolkoIKrzyzyk.getN() + l);
                }
            }
        }

        PlanszaKolkoIKrzyzyk tmp;
        for (int i = 0; i < elementDrzewa.dzieci.size(); i++) {
            tmp = new PlanszaKolkoIKrzyzyk();
            tmp.skopiujTablice(planszaKolkoIKrzyzyk);
            tmp.plansza[elementDrzewa.dzieci.get(i).indi][elementDrzewa.dzieci.get(i).indj] = znak;
            //System.out.println();
            //tmp.wyswietlPlansze();
            if(aktualnyGracz == 0)
                dodajMozliweScenariusze(elementDrzewa.dzieci.get(i),tmp,1);
            else
                dodajMozliweScenariusze(elementDrzewa.dzieci.get(i),tmp,0);

        }
        return;
    }
}

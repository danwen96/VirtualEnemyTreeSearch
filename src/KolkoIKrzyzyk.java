import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class KolkoIKrzyzyk implements MozliwoscAI{

    PlanszaKolkoIKrzyzyk planszaKolkoIKrzyzyk;
    //PlanszaKolkoIKrzyzyk planszaDoPrzewidywania;

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
        int wartoscRuchu;

        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
                wartoscRuchu = 0;
                if(planszaKolkoIKrzyzyk.plansza[k][l] != '-')
                {
                    continue;
                }
                for (int i = 0; i < planszaKolkoIKrzyzyk.getN(); i++) {
                    for (int j = 0; j < planszaKolkoIKrzyzyk.getN(); j++) {
                        if(i != k || l != j) {
                            if (planszaKolkoIKrzyzyk.plansza[i][j] == '-') {
                                if (i == k)
                                    wartoscRuchu++;
                                if (l == j)
                                    wartoscRuchu++;
                                if (k == l && i == j)
                                    wartoscRuchu++;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu++;
                            } else if(planszaKolkoIKrzyzyk.plansza[i][j] == znak) {
                                if (i == k)
                                    wartoscRuchu+=4;
                                if (l == j)
                                    wartoscRuchu+=4;
                                if (k == l && i == j)
                                    wartoscRuchu+=4;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu+=4;
                            } else {
                                if (i == k)
                                    wartoscRuchu-=2;
                                if (l == j)
                                    wartoscRuchu-=2;
                                if (k == l && i == j)
                                    wartoscRuchu-=2;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu-=2;
                            }

                        }
                    }
                }
                drzewoDecyzyjne.dodajRodzica(k,l,wartoscRuchu,k*planszaKolkoIKrzyzyk.getN() + l);

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

        for (int k = 0; k < planszaKolkoIKrzyzyk.getN(); k++) {// aktualnie rozwazane pole
            for (int l = 0; l < planszaKolkoIKrzyzyk.getN(); l++) {//druga petla odpowiedzialna za aktualnie rozwazane pole
                wartoscRuchu = 0;
                if(planszaKolkoIKrzyzyk.plansza[k][l] != '-')
                {
                    continue;
                }
                for (int i = 0; i < planszaKolkoIKrzyzyk.getN(); i++) {
                    for (int j = 0; j < planszaKolkoIKrzyzyk.getN(); j++) {
                        if(i != k || l != j) {
                            if (planszaKolkoIKrzyzyk.plansza[i][j] == '-') {
                                if (i == k)
                                    wartoscRuchu++;
                                if (l == j)
                                    wartoscRuchu++;
                                if (k == l && i == j)
                                    wartoscRuchu++;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu++;
                            } else if(planszaKolkoIKrzyzyk.plansza[i][j] == znak) {
                                if (i == k)
                                    wartoscRuchu+=4;
                                if (l == j)
                                    wartoscRuchu+=4;
                                if (k == l && i == j)
                                    wartoscRuchu+=4;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu+=4;
                            } else {
                                if (i == k)
                                    wartoscRuchu-=2;
                                if (l == j)
                                    wartoscRuchu-=2;
                                if (k == l && i == j)
                                    wartoscRuchu-=2;
                                if (k == (planszaKolkoIKrzyzyk.getN() - 1 - l) && i == (planszaKolkoIKrzyzyk.getN() - 1 - j))
                                    wartoscRuchu-=2;
                            }

                        }
                    }
                }
                elementDrzewa.dodajDziecko(k,l,wartoscRuchu,k*planszaKolkoIKrzyzyk.getN() + l);

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

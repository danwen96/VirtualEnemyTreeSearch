package WirtualnyPrzeciwnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Klasa uzywana w drzewie decyzyjnym, umozliwia ona jego budowanie i przechowywanie informacji
 * @see WirtualnyPrzeciwnik.DrzewoDecyzyjne
 */
public class ElementDrzewa {
    private ElementDrzewa rodzic;
    public List<ElementDrzewa> dzieci = new ArrayList<>();
    private Map<Integer,Integer> indexyOdpowiadajace = new HashMap<>();
    private int indexWDrzewie = 0;
    int wartosc;
    private int indi;//wsporzedne mowiace do ktorego pola planszy element sie odnosi
    private int indj;

    ElementDrzewa(){}

    /**
     * @param indi index x tablicy dla ktorego rozpatrywany jest ruch
     * @param indj index y tablicy dla ktorego rozpatrywany jest ruch
     * @param rodzic rodzic danego elementu w drzewie
     * @param wartosc wartosc ruchu danego elementu
     */
    ElementDrzewa(int indi,int indj,ElementDrzewa rodzic,int wartosc)
    {
        this.indi = indi;
        this.indj = indj;
        this.rodzic = rodzic;
        this.wartosc = wartosc;
    }

    /** Metoda dodajaca elementy do listy dzieci w aktualnym elemencie drzewa
     * @param indi index x tablicy dla ktorego rozpatrywany jest ruch
     * @param indj index y tablicy dla ktorego rozpatrywany jest ruch
     * @param wartosc wartosc ruchu do dodania
     * @param index rzeczywisty index elementu na tablicy
     */
    public void dodajDziecko(int indi,int indj,int wartosc,int index)
    {
        ElementDrzewa dziecko = new ElementDrzewa(indi,indj,this,wartosc);
        dzieci.add(dziecko);
        indexyOdpowiadajace.put(indexWDrzewie++,index);
    }

    /**
     * @return Metoda zwraca index dziecka z maksymalna wartoscia
     */
    int zwrocIndexMaksymalnejWartosciDziecka()
    {
        int maksIndex = -1;
        int Maks = 0;
        for(int i=0;i<dzieci.size();i++)
        {
            if(dzieci.get(i).wartosc>Maks)
            {
                Maks = dzieci.get(i).wartosc;
                maksIndex = i;
            }
        }
        return maksIndex;
    }
    /**
     * @return Metoda zwraca index dziecka z minimalna wartoscia
     */
    int zwrocIndexMinimalnejWartosciDziecka()
    {
        int minIndex = -1;
        int Min = 0;
        for(int i=0;i<dzieci.size();i++)
        {
            if(dzieci.get(i).wartosc<Min)
            {
                Min = dzieci.get(i).wartosc;
                minIndex = i;
            }
        }
        return minIndex;
    }


    public int getIndi() {
        return indi;
    }

    public int getIndj() {
        return indj;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }
}

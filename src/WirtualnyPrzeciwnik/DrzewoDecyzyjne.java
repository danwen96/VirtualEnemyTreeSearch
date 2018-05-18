package WirtualnyPrzeciwnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Klasa przechowywyjaca drzewo decyzyjne przy pomocy obiektow WirtualnyPrzeciwnik.WirtualnyPrzeciwnik.ElementDrzewa
 * @see ElementDrzewa
 */
public class DrzewoDecyzyjne {

    public List<ElementDrzewa> rodzice = new ArrayList<>();
    Map<Integer,Integer> indexyOdpowiadajace = new HashMap<>();
    private int indexWDrzewie = 0;

    public DrzewoDecyzyjne()
    {

    }

    /** Metoda dodajaca pierwsze elementy drzew oznaczajace mozliwe ruchy do wykonania
     * @param indi wspolrzedna x ruchu na tablicy
     * @param indj wspolrzedna y ruchu na tablicy
     * @param wartosc wartosc ruchu ktora ma byc zapisana do danego elementu drzewa
     * @param index index pola na planszy oznaczajacy ruch, zostaje zapisany za pomoca mapy
     */
    public void dodajRodzica(int indi,int indj,int wartosc,int index)
    {
        ElementDrzewa rodzic = new ElementDrzewa(indi,indj,null,wartosc);
        rodzice.add(rodzic);
        indexyOdpowiadajace.put(indexWDrzewie++,index);
    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrzewoDecyzyjne {

    //w drzewie decyzyjnym wartosci oznaczaja naprzemienne przyblizone wartosci ruchow kazdego z graczy
    /*np
          1     3 - 1 gracz
         / \   / \
        4   6 7   2 - 2 gracz

    */

    ElementDrzewa glownyElement;
    List<ElementDrzewa> rodzice = new ArrayList<ElementDrzewa>();
    Map<Integer,Integer> indexyOdpowiadajace = new HashMap<Integer,Integer>();
    int indexWDrzewie = 0;

    DrzewoDecyzyjne()
    {

    }

    void dodajRodzica(int indi,int indj,int wartosc,int index)
    {
        ElementDrzewa rodzic = new ElementDrzewa(indi,indj,null,wartosc);
        rodzice.add(rodzic);
        indexyOdpowiadajace.put(indexWDrzewie++,index);
    }

}

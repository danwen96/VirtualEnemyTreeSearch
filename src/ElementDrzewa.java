import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementDrzewa {
    ElementDrzewa rodzic;
    List<ElementDrzewa> dzieci = new ArrayList<ElementDrzewa>();
    Map<Integer,Integer> indexyOdpowiadajace = new HashMap<Integer,Integer>();
    int indexWDrzewie = 0;
    int wartosc;
    int indi;//wsporzedne mowiace do ktorego pola planszy element sie odnosi
    int indj;

    ElementDrzewa(){}
    ElementDrzewa(int indi,int indj,ElementDrzewa rodzic,int wartosc)
    {
        this.indi = indi;
        this.indj = indj;
        this.rodzic = rodzic;
        this.wartosc = wartosc;
    }

    void dodajDziecko(int indi,int indj,int wartosc,int index)
    {
        ElementDrzewa dziecko = new ElementDrzewa(indi,indj,this,wartosc);
        dzieci.add(dziecko);
        indexyOdpowiadajace.put(indexWDrzewie++,index);
    }

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
}

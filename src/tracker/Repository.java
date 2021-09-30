package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map <Long, Defect> errorList;
    private int sizeRepository;
    private long enumeratorDef = 0L;

    public Repository (int sizeRepository) {
        this.errorList = new HashMap<>();
        this.sizeRepository = sizeRepository;
    }

    void add(Defect defect) {
        errorList.put(enumeratorDef, defect);
        enumeratorDef++;
    }

    public boolean isFull() {
        return enumeratorDef >= sizeRepository;
    }

    public boolean isEmpty() {
        return enumeratorDef==0;
    }

    public List<Defect> getErrorList() {
        List<Defect> defects = new ArrayList<>();
        for (Map.Entry<Long, Defect> defect: errorList.entrySet()){
            defects.add(defect.getValue());
        }
        return defects;
    }

    public  long getEnumeratorDef() {
        return enumeratorDef;
    }
}

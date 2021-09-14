package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map<Long, Defect> defectsList;
    private int repositorySize;
    private long defectCount = 0L;

    public Repository(int repositorySize) {

        this.defectsList = new HashMap<>();
        this.repositorySize = repositorySize;
    }

    public void add(Defect defect) {
        defectsList.put(defectCount, defect);
        defectCount++;
    }

    public boolean isFull() {
        return defectCount >= repositorySize;
    }

    public boolean isEmpty() {
        return defectCount == 0;
    }

    public List<Defect> getDefectsList() {
        List<Defect> defects = new ArrayList<>();
        for (Map.Entry<Long, Defect> defect: defectsList.entrySet()){
            defects.add(defect.getValue());
        }
        return defects;
    }

    public long getDefectCount() {
        return defectCount;
    }


}

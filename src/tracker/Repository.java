package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map<Long, Defect> defectsList;
    private int repositorySize;
    // private long defectCount = 0L;

    public Repository(int repositorySize) {
        this.defectsList = new HashMap<>();
        this.repositorySize = repositorySize;
    }

    public void add(Defect defect) {
        defectsList.put(defect.getId(), defect);
    }

    public boolean isFull() {
        return defectsList.size() >= repositorySize;
    }

    public boolean isEmpty() {
        return defectsList.size() == 0;
    }

    public List<Defect> getDefectsList() {
        return new ArrayList<>(defectsList.values());
    }
}

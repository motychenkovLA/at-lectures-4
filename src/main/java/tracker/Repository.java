package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map <Long, Defect> errorList;
    private int sizeRepository;


    public Repository (int sizeRepository) {
        this.errorList = new HashMap<>();
        this.sizeRepository = sizeRepository;
    }

    void add(Defect defect) {
        errorList.put(defect.getId(), defect);

    }

    public boolean isFull() {
        return errorList.size() >= sizeRepository;
    }

    public boolean isEmpty() {
        return errorList.size()==0;
    }

    public List<Defect> getErrorList() {
        return new ArrayList<>(errorList.values());
    }


}

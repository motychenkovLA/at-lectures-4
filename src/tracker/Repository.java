package tracker;

public class Repository {
    private Defect[] errorList;
    private int sizeRepository;
    private int enumeratorDef = 0;

    public Repository (int sizeRepository) {
        this.errorList = new Defect[sizeRepository];
        this.sizeRepository = sizeRepository;
    }

    void add(Defect defect) {
        this.errorList[enumeratorDef] = defect;
        enumeratorDef++;
    }

    String getAll() {
        StringBuilder list = new StringBuilder();
        if (enumeratorDef == 0) {
            list = new StringBuilder("Дефекты отсутствуют");
        } else {
            for (int i = 0; i < enumeratorDef; i++) {
                list.append(errorList[i].listInfo());
            }
        }
        return list.toString();
    }

    public boolean isFull() {
        return enumeratorDef >= sizeRepository;
    }

    public Defect[] getErrorList() {
        return errorList;
    }

    public  int getEnumeratorDef() {
        return enumeratorDef;
    }
}

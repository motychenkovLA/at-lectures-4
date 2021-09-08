package tracker;

public class Repository {
    private Defect[] errorList;
    private int sizeRepository;
    private int inputEnumeratorDef = 0;
    static int enumeratorDef = 0;

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
            while (inputEnumeratorDef < enumeratorDef) {
                list.append(errorList[inputEnumeratorDef].list());
                inputEnumeratorDef++;
            }
            inputEnumeratorDef = 0;
        }
        return list.toString();
    }

    public boolean isFull() {
        return enumeratorDef == sizeRepository;
    }

    public Defect[] getErrorList() {
        return errorList;
    }

    public void setErrorList(Defect[] errorList) {
        this.errorList = errorList;
    }
}

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

    public boolean isFull() {
        return enumeratorDef >= sizeRepository;
    }

    public boolean isEmpty() {
        return enumeratorDef==0;
    }

    public Defect[] getErrorList() {
        Defect[] result = new Defect[enumeratorDef];
        System.arraycopy(errorList,0,result,0,enumeratorDef);
        return result;
    }

    public  int getEnumeratorDef() {
        return enumeratorDef;
    }
}

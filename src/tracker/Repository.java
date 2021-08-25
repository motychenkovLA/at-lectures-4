package tracker;

public class Repository {
    private final Defect[] defects;
    private int index;

    public int getIndex() {
        return index;
    }

    public Repository(int length) {
        this.defects = new Defect[length];
        index = 0;
    }

    public void add(Defect defect){
        defects[index] = defect;
        index++;
    }

    public Defect[] getAll(){
        return defects;
    }
}

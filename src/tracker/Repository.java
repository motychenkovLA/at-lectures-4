package tracker;

public class Repository {
    private final Defect[] defectList;
    private int inputCounter = 0;
    static int counter = 0;

    public Repository(int LIMIT) {
        this.defectList = new Defect[LIMIT];
    }

    void add(Defect defect) {
        this.defectList[counter] = defect;
        counter++;
    }

    String getAllDefect() {
        StringBuilder list = new StringBuilder();
        if (getDefectCounter() == 0) {
            list = new StringBuilder("Дефекты отсутствуют.\n");
        } else {
            while (inputCounter < getDefectCounter()) {
                list.append(defectList[inputCounter].getInfoOfDefect());
                inputCounter++;
            }
            inputCounter = 0;
        }
        return list.toString();
    }

    public Defect[] getDefectsList() {
        return defectList;
    }

    public static int getDefectCounter() {
        return counter;
    }
}

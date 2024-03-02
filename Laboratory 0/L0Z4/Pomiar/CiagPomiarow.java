package Pomiar;

import java.io.Serializable;
import java.util.Arrays;

public class CiagPomiarow implements Serializable {

    private Pomiar [] pomiary;

    public CiagPomiarow(Pomiar [] pomiary) {
        this.pomiary = pomiary;
    }

    public Pomiar[] getPomiary() {
        return pomiary;
    }

    public void setPomiary(Pomiar[] pomiary) {
        this.pomiary = pomiary;
    }

    @Override
    public String toString() {
        return "CiagPomiarow{" +
                "pomiary=" + Arrays.toString(pomiary) +
                '}';
    }
}

package maratische.kotlin.sdktest1;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Evil implements Serializable {
    String name;

    private void readObject(ObjectInputStream s) {
        System.exit(1);
    }
}

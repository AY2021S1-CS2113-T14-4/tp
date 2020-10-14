package seedu.duke.database;

import java.util.ArrayList;
import java.util.List;

public class Canteen {
    private final String name;
    private final ArrayList<Store> storeList;

    public Canteen(String name) {
        this.name = name;
        this.storeList = new ArrayList<>();
    }

    /**
     * Name of the canteen is for filtering purposes.
     *
     * @return name of canteen
     */
    public String getName() {
        return name;
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public List<Store> getStoreList() {
        return storeList;
    }
}

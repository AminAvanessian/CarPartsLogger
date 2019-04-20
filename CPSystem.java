import java.util.ArrayList;
import java.util.HashMap;


class CPSystem {
    // partID unique number for new parts
    int latestCarPartID = 0;

    // inventory of parts
    HashMap carPartsInventory = new HashMap<String, CarPart>();
    

    // add new car part
    int add(CarMake make, String model, int year) {
        // get new partID
        int newPartID = ++latestCarPartID;

        // create new CarPart object
        CarPart part = new CarPart(newPartID, make, model, year);

        // add to inventory
        carPartsInventory.put(newPartID, part);

        return newPartID;
    } 

    // remove car part from inventory
    CarPart remove(int partID) throws PartIdNotFound {
        // check if car part exists in inventory
        if (!carPartsInventory.containsKey(partID)) {
            // part does not exists
            throw PartIdNotFound();
        }

        // get car part
        CarPart removedPart = carPartsInventory.get(partID);

        // remove part from inventory
        carPartsInventory.remove(partID);

        // return removed car part
        return removedPart;
    }

    // search by make of car
    ArrayList<CarPart> searchByMake(CarMake make) {
        // create list of car parts
        ArrayList foundParts = new ArrayList<CarPart>();

        // search each car part in inventory
        for (CarPart part : carPartsInventory.values()) {
            // check for make
            if (part.make == make) {
                foundParts.add(part);
            }
        }

        // return list
        return foundParts;
    }

    // search by model of car
    ArrayList<CarPart> searchByModel(String model) {
        // create list of car parts
        ArrayList foundParts = new ArrayList<CarPart>();

        // search each car part in inventory
        for (CarPart part : carPartsInventory.values()) {
            // check for model
            if (part.model == model) {
                foundParts.add(part);
            }
        }

        // return list
        return foundParts;
    }

    // search by year of car
    ArrayList<CarPart> searchByYear(int year) {
        // create list of car parts
        ArrayList foundParts = new ArrayList<CarPart>();

        // search each car part in inventory
        for (CarPart part : carPartsInventory.values()) {
            // check for make
            if (part.year == year) {
                foundParts.add(part);
            }
        }

        // return list
        return foundParts;
    }

    // search by id of car
    CarPart searchByID(int partID) {
        // check if car part exists in inventory
        if (!carPartsInventory.containsKey(partID)) {
            // part does not exists
            return null;
        }

        // get car part
        CarPart foundPart = carPartsInventory.get(partID);

        // return found car part
        return foundPart;
    }
}

public class PartIdNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    // Part ID not found in inventory
    public PartIdNotFound(String message) {
        super(message);
    }
}
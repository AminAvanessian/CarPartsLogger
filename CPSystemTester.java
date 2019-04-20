import java.util.Random;
// junit testing

class CPSystemTester {
    CPSystem cpSystem = new CPSystem();
    
    // test adding a new car part to inventory
    @Test
    public void testAddNewCarPart() {
        // generate test values
        int year = generateYear();
        String model = "Test";
        CarMake make = CarMake.FORD;

        // get latest part ID
        int latestID = cpSystem.getLatestCarPartID();

        // get expected new car partID
        int newID = ++latestID;

        // test to see if we reach expected value of 'newID'
        assertEquals(newID, cpSystem.add(make,model,year));
    }

    // test removing a car part that exists inside inventory
    @Test
    public void testRemoveValidPart() {
        // get latest valid car part ID
        int validID = cpSystem.getLatestCarPartID();

        // get car part object using id
        CarPart part = cpSystem.searchByID(validID);

        // test to see if correct part is removed
        assertEquals(part.partID, cpSystem.remove(validID).partID);
    }

    // test search by year function
    @Test
    public void testSearchByYear() {
        // generate test fields
        int year = generateYear();
        String model = "Test";
        CarMake make = CarMake.FORD;

        // add new car part
        cpSystem.add(make, model, year);

        // search for car part with year, at least 1 result should exist
        ArrayList<CarPart> results = cpSystem.searchByYear(year);

        // compare results with expected value of 1
        assertTrue(results.size() >= 1);
    }

    // test search by make
    @Test
    public void testSearchByMake() {
        // generate test fields
        int year = generateYear();
        String model = "Test";
        CarMake make = CarMake.FORD;

        // add new car part
        cpSystem.add(make, model, year);

        // search for car part with make, at least 1 result should exist
        ArrayList<CarPart> results = cpSystem.searchByMake(make);

        // compare results with expected value of 1
        assertTrue(results.size() >= 1);
    }

    // test search by model
    @Test
    public void testSearchByModel() {
        // generate test fields
        int year = generateYear();
        String model = "Test";
        CarMake make = CarMake.FORD;

        // add new car part
        cpSystem.add(make, model, year);

        // search for car part with model, at least 1 result should exist
        ArrayList<CarPart> results = cpSystem.searchByModel(model);

        // compare results with expected value of 1
        assertTrue(results.size() >= 1);
    }

    // generate a random value for year
    int generateYear() {
        Random rand = new Random();

        // generate random number for year
        int year = rand.nextInt(3000);

        return year;
    }
}
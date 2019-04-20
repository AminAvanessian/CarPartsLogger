import java.util.Random;

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
        
    }

    // test removing a car part that does not exist inside inventory
    @Test
    public void testRemoveInValidPart() {
        
    }

    // generate a random value for year
    int generateYear() {
        Random rand = new Random();

        // generate random number for year
        int year = rand.nextInt(3000);

        return year;
    }
}
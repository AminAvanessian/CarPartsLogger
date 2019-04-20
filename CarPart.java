class CarPart {
    int partID;
    CarMake make;
    String model;
    int year;

    public CarPart(int partID, CarMake make, String model, int year) {
        this.partID = partID;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

enum CarMake {
    CHEVROLET,
    FORD,
    HONDA,
    HYUNDAI,
    KIA,
    MAZDA,
    MITSUBISHI,
    TOYOTA,
    VOLKSWAGEN,
}
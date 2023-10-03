package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private String firstName, lastName, phoneNumber, zipCode, state, gender;

    // Use a Builder for the Frogger class
    public class FroggerBuilder {
        private final Road road;
        private final Records records;
        private int position;
        private String firstName, lastName, phoneNumber, zipCode, state, gender;

        public FroggerBuilder(Road road, Records records) {
            this.road = road;
            this.records = records;
        }

        public FroggerBuilder setPosition(int position) {
            this.position = position;
            return this;
        }

        public FroggerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public FroggerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public FroggerBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public FroggerBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public FroggerBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public FroggerBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Frogger build() {
            return new Frogger(this);
        }
    }

    // Private constructor for Frogger
    private Frogger(FroggerBuilder builder) {
        this.road = builder.road;
        this.records = builder.records;
        this.position = builder.position;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.zipCode = builder.zipCode;
        this.state = builder.state;
        this.gender = builder.gender;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!isValid(nextPosition) || this.road.isOccupied(nextPosition)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }
    
    public boolean isValid(int position) {
        if (position < 0) return false;
        boolean[] occupied = this.road.getOccupied();
        return position < occupied.length;
    }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      boolean success = records.addRecord(firstName, lastName, phoneNumber, zipCode, state, gender);
      return success;
    }

}

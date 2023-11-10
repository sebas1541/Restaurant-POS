package model;

public class User {
    private int firstName;
    private int surName;

    public User(int firstName, int surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getSurName() {
        return surName;
    }

    public void setSurName(int surName) {
        this.surName = surName;
    }
}

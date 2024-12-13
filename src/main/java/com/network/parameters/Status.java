package main.java.com.network.parameters;

public class Status {
    private final String status;

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}

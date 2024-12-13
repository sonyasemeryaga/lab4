package main.java.com.network.parameters;

public class IPaddress {
    private final String ipAddress;

    public IPaddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return ipAddress;
    }
}

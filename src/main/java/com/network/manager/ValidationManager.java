package main.java.com.network.manager;

public class ValidationManager {

    public static boolean isValidIP(String ipAddress) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return ipAddress.matches(regex);
    }

    public static boolean isValidVlanId(Integer vlanId) {
        return vlanId != null && vlanId >= 0 && vlanId <= 4094;
    }

    public static boolean isValidAsNumber(Integer asNumber) {
        return asNumber != null && asNumber >= 1 && asNumber <= 65535;
    }

    public static String validateIP(String ipAddress) {
        if (!isValidIP(ipAddress)) {
            return "Invalid IP address: " + ipAddress;
        }
        return null;
    }

    public static String validateVlanId(Integer vlanId) {
        if (vlanId != null && !isValidVlanId(vlanId)) {
            return "Invalid VLAN ID: " + vlanId;
        }
        return null;
    }

    public static String validateAsNumber(Integer asNumber) {
        if (asNumber != null && !isValidAsNumber(asNumber)) {
            return "Invalid AS Number: " + asNumber;
        }
        return null;
    }
}

package main.java.com.network.devices;

import main.java.com.network.parameters.*;

public class Manual {
    private final Name name;
    private final DeviceType type;
    private final Status status;
    private final IPaddress ipAddress;
    private final WiFiType wiFiType;
    private final Integer vlanId;
    private final Integer asNumber;

    public Manual(Name name, DeviceType type, Status status, IPaddress ipAddress, WiFiType wiFiType, Integer vlanId, Integer asNumber) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.ipAddress = ipAddress;
        this.wiFiType = wiFiType;
        this.vlanId = vlanId;
        this.asNumber = asNumber;
    }

    public String getNameInfo() {
        return "Device Name: " + name;
    }

    public String getTypeInfo() {
        return "Device Type: " + type;
    }

    public String getStatusInfo() {
        return "Status: " + status;
    }

    public String getIpAddressInfo() {
        return "IP Address: " + ipAddress;
    }

    public String getWiFiTypeInfo() {
        return (wiFiType != null) ? "WiFi Type: " + wiFiType : "";
    }

    public String getVlanIdInfo() {
        return vlanId != null ? "VLAN ID: " + vlanId : "";
    }

    public String getAsNumberInfo() {
        return asNumber != null ? "AS Number: " + asNumber : "";
    }


    private String cleanInfoString(String... info) {
        return String.join(", ", info).replaceAll(", ,", ",").replaceAll("(, )+$", "");
    }

    private String getRequiredInfo() {
        return cleanInfoString(
                getNameInfo(),
                getTypeInfo(),
                getStatusInfo(),
                getIpAddressInfo()
        );
    }

    private String getOptionalInfo() {
        return cleanInfoString(
                getWiFiTypeInfo(),
                getVlanIdInfo(),
                getAsNumberInfo()
        );
    }

    public void printSummary() {
        String mandatoryInfo = getRequiredInfo();
        String optionalInfo = getOptionalInfo();
        String summary = cleanInfoString(mandatoryInfo, optionalInfo);
        System.out.println(summary);
    }
}

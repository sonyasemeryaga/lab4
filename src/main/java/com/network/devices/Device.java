package main.java.com.network.devices;

import main.java.com.network.parameters.*;

public class Device {
    private final Name name;
    private final DeviceType type;
    private final Status status;
    private final IPaddress ipAddress;
    private final WiFiType wiFiType;
    private final Integer vlanId;
    private final Integer asNumber;

    public Device(Name name, DeviceType type, Status status, IPaddress ipAddress, WiFiType wiFiType, Integer vlanId, Integer asNumber) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.ipAddress = ipAddress;
        this.wiFiType = wiFiType;
        this.vlanId = vlanId;
        this.asNumber = asNumber;
    }

    public Name getName() {
        return name;
    }

    public DeviceType getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public IPaddress getIpAddress() {
        return ipAddress;
    }

    public WiFiType getWiFiType() {
        return wiFiType;
    }

    public Integer getVlanId() {
        return vlanId;
    }

    public Integer getASNumber() {
        return asNumber;
    }
}

package main.java.com.network.builders;

import main.java.com.network.devices.DeviceType;
import main.java.com.network.parameters.*;
import main.java.com.network.devices.Manual;

public class DeviceManual implements Builder {
    private Name name;
    private DeviceType type;
    private Status status;
    private IPaddress ipAddress;
    private WiFiType wiFiType;
    private Integer vlanId;
    private Integer asNumber;

    @Override
    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public void setType(DeviceType type) {
        this.type = type;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void setIPAddress(IPaddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void setWiFiType(WiFiType wiFiType) {
        this.wiFiType = wiFiType;
    }

    @Override
    public void setVlanID(Integer vlanID) {
        this.vlanId = vlanID;
    }

    @Override
    public void setASNumber(Integer asNumber) {
        this.asNumber = asNumber;
    }

    public Manual build() {
        return new Manual(name, type, status, ipAddress, wiFiType, vlanId, asNumber);
    }
}

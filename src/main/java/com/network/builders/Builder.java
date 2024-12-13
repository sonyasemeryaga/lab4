package main.java.com.network.builders;

import main.java.com.network.devices.DeviceType;
import main.java.com.network.parameters.*;

public interface Builder {
    void setName(Name name);
    void setType(DeviceType type);
    void setStatus(Status status);
    void setIPAddress(IPaddress ipAddress);
    void setWiFiType(WiFiType wiFiType);
    void setVlanID(Integer vlanID);
    void setASNumber(Integer asNumber);
}

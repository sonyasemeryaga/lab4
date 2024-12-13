package main.java.com.network.director;

import main.java.com.network.builders.Builder;
import main.java.com.network.parameters.*;
import main.java.com.network.devices.DeviceType;

public class Director {
    private void setupCommonFields(Builder builder, String name, String status, String ipAddress) {
        builder.setName(new Name(name));
        builder.setStatus(new Status(status));
        builder.setIPAddress(new IPaddress(ipAddress));
    }

    public void buildSwitch(Builder builder, String name, String status, String ipAddress, int vlanID) {
        setupCommonFields(builder, name, status, ipAddress);
        builder.setType(DeviceType.SWITCH);
        builder.setVlanID(vlanID);
    }

    public void buildRouter(Builder builder, String name, String status, String ipAddress, int asNumber) {
        setupCommonFields(builder, name, status, ipAddress);
        builder.setType(DeviceType.ROUTER);
        builder.setASNumber(asNumber);
    }

    public void buildAccessPoint(Builder builder, String name, String status, String ipAddress, String wiFiType) {
        setupCommonFields(builder, name, status, ipAddress);
        builder.setType(DeviceType.ACCESS_POINT);
        builder.setWiFiType(new WiFiType(wiFiType));
    }

}


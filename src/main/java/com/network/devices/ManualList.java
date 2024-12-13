package main.java.com.network.devices;

import main.java.com.network.builders.DeviceManual;

public class ManualList {
    public void printDeviceList(DeviceList deviceList) {
        for (Device device : deviceList.getDevices()) {
            Manual deviceManual = buildDeviceManual(device);
            deviceManual.printSummary();
        }
    }

    private Manual buildDeviceManual(Device device) {
        DeviceManual manualBuilder = new DeviceManual();
        setRequiredFields(device, manualBuilder);
        setOptionalFields(device, manualBuilder);
        return manualBuilder.build();
    }

    private void setOptionalFields(Device device, DeviceManual manualBuilder) {
        manualBuilder.setWiFiType(device.getWiFiType());
        manualBuilder.setVlanID(device.getVlanId());
        manualBuilder.setASNumber(device.getASNumber());
    }

    private void setRequiredFields(Device device, DeviceManual manualBuilder) {
        manualBuilder.setName(device.getName());
        manualBuilder.setType(device.getType());
        manualBuilder.setStatus(device.getStatus());
        manualBuilder.setIPAddress(device.getIpAddress());
    }
}

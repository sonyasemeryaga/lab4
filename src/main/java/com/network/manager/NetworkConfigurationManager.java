package main.java.com.network.manager;

import main.java.com.network.devices.DeviceList;
import main.java.com.network.devices.Device;

import java.util.ArrayList;
import java.util.List;

public class NetworkConfigurationManager {

    public void addDevice(DeviceList devices, Device device) {
        List<String> validationErrors = validateDevice(device);
        if (validationErrors.isEmpty()) {
            devices.getDevices().add(device);
        } else {
            System.out.println("Invalid configuration for device: " + device.getName());
            validationErrors.forEach(System.out::println);
        }
    }

    private List<String> validateDevice(Device device) {
        List<String> errors = new ArrayList<>();
        String ipError = ValidationManager.validateIP(String.valueOf(device.getIpAddress()));
        if (ipError != null) errors.add(ipError);
        String vlanError = ValidationManager.validateVlanId(device.getVlanId());
        if (vlanError != null) errors.add(vlanError);
        String asError = ValidationManager.validateAsNumber(device.getASNumber());
        if (asError != null) errors.add(asError);
        return errors;
    }

    public void removeDevice(DeviceList devices, Device device) {
        devices.getDevices().remove(device);
    }
}

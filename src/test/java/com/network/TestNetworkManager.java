package test.java.com.network;

import main.java.com.network.builders.DeviceBuilder;
import main.java.com.network.devices.Device;
import main.java.com.network.director.Director;
import main.java.com.network.manager.NetworkConfigurationManager;
import main.java.com.network.devices.DeviceList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNetworkManager {

    @Test
    void givenValidDevice_whenAddDevice_thenDeviceAddedSuccessfully() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildSwitch(builder, "Switch1", "Active", "10.0.0.1", 100);
        Device switchDevice = builder.build();
        manager.addDevice(deviceList, switchDevice);

        assertEquals(1, deviceList.getDevices().size());
        assertEquals(switchDevice, deviceList.getDevices().getFirst());
    }

    @Test
    void givenInvalidIP_whenAddDevice_thenDeviceNotAdded() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildRouter(builder, "InvalidDevice", "Active", "300.300.300.300", 65001); // Invalid IP
        Device invalidDevice = builder.build();
        manager.addDevice(deviceList, invalidDevice);

        assertEquals(0, deviceList.getDevices().size());
    }

    @Test
    void givenInvalidVlanId_whenAddDevice_thenDeviceNotAdded() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildSwitch(builder, "InvalidVlanDevice", "Active", "10.0.0.2", -1); // Invalid VLAN ID
        Device invalidVlanDevice = builder.build();
        manager.addDevice(deviceList, invalidVlanDevice);

        assertEquals(0, deviceList.getDevices().size());
    }

    @Test
    void givenValidVlanId_whenAddDevice_thenDeviceAddedSuccessfully() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildSwitch(builder, "ValidVlanDevice", "Active", "10.0.0.3", 100); // Valid VLAN ID
        Device validVlanDevice = builder.build();
        manager.addDevice(deviceList, validVlanDevice);

        assertEquals(1, deviceList.getDevices().size());
        assertEquals(validVlanDevice, deviceList.getDevices().getFirst());
    }

    @Test
    void givenInvalidAsNumber_whenAddDevice_thenDeviceNotAdded() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildRouter(builder, "InvalidAsDevice", "Active", "10.0.0.4", 70000); // Invalid AS Number
        Device invalidAsDevice = builder.build();
        manager.addDevice(deviceList, invalidAsDevice);

        assertEquals(0, deviceList.getDevices().size());
    }

    @Test
    void givenValidAsNumber_whenAddDevice_thenDeviceAddedSuccessfully() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildRouter(builder, "ValidAsDevice", "Active", "10.0.0.5", 50000); // Valid AS Number
        Device validAsDevice = builder.build();
        manager.addDevice(deviceList, validAsDevice);

        assertEquals(1, deviceList.getDevices().size());
        assertEquals(validAsDevice, deviceList.getDevices().getFirst());
    }

    @Test
    void givenDeviceInList_whenRemoveDevice_thenDeviceRemovedSuccessfully() {
        NetworkConfigurationManager manager = new NetworkConfigurationManager();
        DeviceList deviceList = new DeviceList();
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();

        director.buildSwitch(builder, "Switch1", "Active", "10.0.0.1", 100);
        Device switchDevice = builder.build();
        manager.addDevice(deviceList, switchDevice);
        manager.removeDevice(deviceList, switchDevice);

        assertTrue(deviceList.getDevices().isEmpty());
    }
}

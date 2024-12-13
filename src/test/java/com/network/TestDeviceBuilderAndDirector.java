package test.java.com.network;

import main.java.com.network.builders.DeviceBuilder;
import main.java.com.network.devices.Device;
import main.java.com.network.devices.DeviceType;
import main.java.com.network.director.Director;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDeviceBuilderAndDirector {
    @Test
    void whenSwitchDirector1_thenBuildSwitch() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildSwitch(builder, "Switch1", "Enabled", "192.168.1.10", 100);
        Device device = builder.build();

        assertEquals("Switch1", device.getName().toString());
        assertEquals(DeviceType.SWITCH, device.getType());
        assertEquals("Enabled", device.getStatus().toString());
        assertEquals("192.168.1.10", device.getIpAddress().toString());
        assertEquals(100, device.getVlanId());
    }

    @Test
    void whenRouterDirector1_thenBuildRouter() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildRouter(builder, "Router1", "Disabled", "10.0.0.1", 65001);
        Device device = builder.build();

        assertEquals("Router1", device.getName().toString());
        assertEquals(DeviceType.ROUTER, device.getType());
        assertEquals("Disabled", device.getStatus().toString());
        assertEquals("10.0.0.1", device.getIpAddress().toString());
        assertEquals(65001, device.getASNumber());
    }

    @Test
    void whenAccessPointDirector1_thenBuildAccessPoint() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildAccessPoint(builder, "AP1", "Enabled", "192.168.0.100", "WiFi-5");
        Device device = builder.build();

        assertEquals("AP1", device.getName().toString());
        assertEquals(DeviceType.ACCESS_POINT, device.getType());
        assertEquals("Enabled", device.getStatus().toString());
        assertEquals("192.168.0.100", device.getIpAddress().toString());
        assertEquals("WiFi-5", device.getWiFiType().toString());
    }

    @Test
    void whenSwitchDirector2_thenBuildSwitch() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildSwitch(builder, "Switch2", "Disabled", "192.168.1.20", 124);
        Device device = builder.build();

        assertEquals("Switch2", device.getName().toString());
        assertEquals(DeviceType.SWITCH, device.getType());
        assertEquals("Disabled", device.getStatus().toString());
        assertEquals("192.168.1.20", device.getIpAddress().toString());
        assertEquals(124, device.getVlanId());
    }

    @Test
    void whenRouterDirector2_thenBuildRouter() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildRouter(builder, "Router2", "Enabled", "172.16.0.1", 65535);
        Device device = builder.build();

        assertEquals("Router2", device.getName().toString());
        assertEquals(DeviceType.ROUTER, device.getType());
        assertEquals("Enabled", device.getStatus().toString());
        assertEquals("172.16.0.1", device.getIpAddress().toString());
        assertEquals(65535, device.getASNumber());
    }

    @Test
    void whenAccessPointDirector2_thenBuildAccessPoint() {
        DeviceBuilder builder = new DeviceBuilder();
        Director director = new Director();

        director.buildAccessPoint(builder, "AP2", "Disabled", "192.168.0.10", "WiFi-6");
        Device device = builder.build();

        assertEquals("AP2", device.getName().toString());
        assertEquals(DeviceType.ACCESS_POINT, device.getType());
        assertEquals("Disabled", device.getStatus().toString());
        assertEquals("192.168.0.10", device.getIpAddress().toString());
        assertEquals("WiFi-6", device.getWiFiType().toString());
    }
}
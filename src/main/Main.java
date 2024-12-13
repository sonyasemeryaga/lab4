package main;

import main.java.com.network.devices.Device;
import main.java.com.network.devices.DeviceList;
import main.java.com.network.devices.ManualList;
import main.java.com.network.director.Director;
import main.java.com.network.builders.DeviceBuilder;
import main.java.com.network.manager.NetworkConfigurationManager;

//Мій варіант 19, а отже  необхідно розробити програму з використанням патернів Чиста вигадка (Pure Fabrication)
// + Будівельник (Builder) Предметна область: Система конфігурації та моніторингу мережевого обладнання
// Завдання: Створити систему для конфігурації та моніторингу мережевого обладнання. Розробити клас
// NetworkConfigurationManager як Чисту вигадку для управління конфігураціями. Використати патерн Будівельник
// для створення складних конфігурацій мережевих пристроїв з різними параметрами та протоколами.


public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        DeviceBuilder builder = new DeviceBuilder();
        NetworkConfigurationManager manager = new NetworkConfigurationManager();

        director.buildSwitch(builder, "Switch", "Enabled", "192.43.5.1", -1);
        Device switchDevice = builder.build();

        builder = new DeviceBuilder();
        director.buildRouter(builder, "Router", "Enabled", "192.43.5.2", 235);
        Device routerDevice = builder.build();

        builder = new DeviceBuilder();
        director.buildAccessPoint(builder, "Access Point", "Enabled", "192.43.5.3", "WiFi-5");
        Device accessPointDevice = builder.build();

        DeviceList deviceList = new DeviceList();
        manager.addDevice(deviceList, switchDevice);
        manager.addDevice(deviceList, routerDevice);
        manager.addDevice(deviceList, accessPointDevice);

        ManualList manualList = new ManualList();
        manualList.printDeviceList(deviceList);

        manager.removeDevice(deviceList, routerDevice);
        System.out.println("\nUpdated Device List after VLAN ID update:");
        manualList.printDeviceList(deviceList);
    }
}
package test.java.com.network;

import main.java.com.network.manager.ValidationManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidationManager {
    @Test
    void givenValidIpAddress_whenIsValidIP_thenTrue() {
        assertTrue(ValidationManager.isValidIP("192.168.0.1"));
        assertTrue(ValidationManager.isValidIP("255.255.255.255"));
    }

    @Test
    void givenInvalidIpAddress_whenIsValidIP_thenFalse() {
        assertFalse(ValidationManager.isValidIP("256.256.256.256"));
        assertFalse(ValidationManager.isValidIP("192.168.1"));
        assertFalse(ValidationManager.isValidIP("abcd"));
    }

    @Test
    void givenValidVlanId_whenIsValidVlanId_thenTrue() {
        assertTrue(ValidationManager.isValidVlanId(0));
        assertTrue(ValidationManager.isValidVlanId(4094));
        assertTrue(ValidationManager.isValidVlanId(100));
    }

    @Test
    void givenInvalidVlanId_whenIsValidVlanId_thenFalse() {
        assertFalse(ValidationManager.isValidVlanId(-1));
        assertFalse(ValidationManager.isValidVlanId(4095));
        assertFalse(ValidationManager.isValidVlanId(null));
    }

    @Test
    void givenValidAsNumber_whenIsValidAsNumber_thenTrue() {
        assertTrue(ValidationManager.isValidAsNumber(1));
        assertTrue(ValidationManager.isValidAsNumber(65535));
        assertTrue(ValidationManager.isValidAsNumber(65000));
    }

    @Test
    void givenInvalidAsNumber_whenIsValidAsNumber_thenFalse() {
        assertFalse(ValidationManager.isValidAsNumber(0));
        assertFalse(ValidationManager.isValidAsNumber(65536));
        assertFalse(ValidationManager.isValidAsNumber(null));
    }

    @Test
    void givenCombinationOfMethods_whenValidating_thenCorrectResults() {
        assertTrue(ValidationManager.isValidIP("10.0.0.1"));
        assertFalse(ValidationManager.isValidIP("300.300.300.300"));

        assertTrue(ValidationManager.isValidVlanId(200));
        assertFalse(ValidationManager.isValidVlanId(-10));

        assertTrue(ValidationManager.isValidAsNumber(50000));
        assertFalse(ValidationManager.isValidAsNumber(70000));
    }
}

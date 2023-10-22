package edu.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Task3test {

    @Test
    public void testUpdatePackagesSuccess() {
        ConnectionManager manager = new DefaultConnectionManager(0.05);
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
        assertDoesNotThrow(() -> executor.updatePackages());
    }


}

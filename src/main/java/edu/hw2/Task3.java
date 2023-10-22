package edu.hw2;

import java.util.Random;

interface Connection extends AutoCloseable {
    void execute(String command);
}

interface ConnectionManager {
    Connection getConnection();
}

class ConnectionException extends RuntimeException {
    public ConnectionException(String s, ConnectionException lastException) {

    }

    public ConnectionException(String s) {

    }
}

class DefaultConnectionManager implements ConnectionManager {
    private final double failureProbability;

    public DefaultConnectionManager(double failureProbability) {
        this.failureProbability = failureProbability;
    }

    @Override
    public Connection getConnection() {
        if (new Random().nextDouble() < failureProbability) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}

class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}

final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        int attempts = 0;
        Connection connection = manager.getConnection();
        ConnectionException lastException = null;

        while (attempts < maxAttempts) {
            try {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                attempts++;
                lastException = e;
            }
        }

        if (lastException != null) {
            throw new ConnectionException("Failed to execute command after " + attempts + " attempts.", lastException);
        } else {
            throw new ConnectionException("Failed to execute command after " + attempts + " attempts.");
        }
    }
}

class StableConnection implements Connection {
    @Override
    public void execute(String command) {}

    @Override
    public void close() {}
}

class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        if (new Random().nextDouble() < 0.2) {
            throw new ConnectionException("Connection failed");
        }
    }

    @Override
    public void close() {}
}

public class Task3 {
    public static void main(String[] args) {
        ConnectionManager manager = new DefaultConnectionManager(0.1); // Настроим вероятность сбоя
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3); // Настроим максимальное количество попыток

        try {
            executor.updatePackages(); // Выполняем команду обновления пакетов
            System.out.println("Команда выполнена успешно.");
        } catch (ConnectionException e) {
            System.err.println("Не удалось выполнить команду: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Причина сбоя: " + e.getCause().getMessage());
            }
        }
    }
}

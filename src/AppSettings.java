import java.util.HashMap;
import java.util.Map;

/**
 * Вариант №1. Паттерн Singleton (Одиночка).
 * Теория: у класса один экземпляр и одна точка доступа — getInstance().
 * Приватный конструктор не даёт создать объект через new снаружи.
 */
public class AppSettings {
    private static AppSettings instance;
    private final Map<String, String> settings = new HashMap<>();

    private AppSettings() {
    }

    public static synchronized AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public synchronized void setSetting(String key, String value) {
        settings.put(key, value);
    }

    public synchronized String getSetting(String key) {
        return settings.get(key);
    }
}

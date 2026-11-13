public class TestAppSettings {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            AppSettings settings = AppSettings.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + ", объект: " + settings.hashCode());
        };

        Thread thread1 = new Thread(task, "Поток-1");
        Thread thread2 = new Thread(task, "Поток-2");
        Thread thread3 = new Thread(task, "Поток-3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        AppSettings settings = AppSettings.getInstance();
        settings.setSetting("тема", "тёмная");
        settings.setSetting("язык", "русский");
        settings.setSetting("путь", "/home/user/files");

        AppSettings sameSettings = AppSettings.getInstance();
        System.out.println("тема: " + sameSettings.getSetting("тема"));
        System.out.println("язык: " + sameSettings.getSetting("язык"));
        System.out.println("путь: " + sameSettings.getSetting("путь"));
        System.out.println("Один и тот же объект? " + (settings == sameSettings));
    }
}

package wait;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Waiter {

    public static <T> boolean wait(Supplier<Boolean> action, int seconds) {
        LocalDateTime endDate = LocalDateTime.now().plusSeconds(seconds);
        while (LocalDateTime.now().isBefore(endDate)) {
            try {
                boolean result = action.get();
                if (result) {
                    return true;
                }
            } catch (Exception ex) {
            } finally {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        }
        return false;
    }

    public static void waitNoError(Runnable runnable) {
        wait(() -> {
            runnable.run();
            return true;
        }, 10);
    }

}
package component;

import org.openqa.selenium.By;

public class Locator {

    public By element;
    public Locator parent;
    public boolean iFrame;

    public Locator(By element, boolean iFrame) {
        this.element = element;
        this.iFrame = iFrame;
    }

    public Locator(By element, Locator parent) {
        this.element = element;
        this.parent = parent;
    }
    
}

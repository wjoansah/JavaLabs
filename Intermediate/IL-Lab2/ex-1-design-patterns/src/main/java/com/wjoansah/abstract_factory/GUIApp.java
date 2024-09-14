package com.wjoansah.abstract_factory;

public class GUIApp {
    private final Button button;

    public GUIApp(GUIFactory guiFactory) {
        button = guiFactory.createButton();
    }

    public void renderButton() {
        button.render();
    }

    public static void main(String[] args) {
        var os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            GUIFactory windowsFactory = new WindowsFactory();
            GUIApp windowsApp = new GUIApp(windowsFactory);

            windowsApp.renderButton();
        } else if (os.contains("Linux")) {
            GUIFactory linuxFactory = new LinuxFactory();
            GUIApp linuxApp = new GUIApp(linuxFactory);

            linuxApp.renderButton();
        } else {
            System.out.println("Platform " + os + "not supported");
        }
    }
}

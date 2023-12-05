package data;

import utils.PropsReader;

public class ProjectProperties {
    public static final String APPIUM_URL = PropsReader.getInstance().getProperty("appium.server");
    public static final String EMULATOR_ID = PropsReader.getInstance().getProperty("emulator.id");
    public static final String APK_PATH = PropsReader.getInstance().getProperty("apk.path");
    public static final String USERNAME = PropsReader.getInstance().getProperty("user.username");
    public static final String PASSWORD = PropsReader.getInstance().getProperty("user.password");
}

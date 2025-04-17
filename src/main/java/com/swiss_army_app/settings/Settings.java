package com.swiss_army_app.settings;

public class Settings {
    private static Settings instance = new Settings();

    private boolean darkMode;
    private boolean soundEnabled;
    private boolean notificationsOn;
    private boolean autoLogin;
    private boolean showTooltips;
    private String nickname;

    private Settings() {}

    public static Settings getInstance() {
        return instance;
    }

    public boolean isDarkMode() { return darkMode; }
    public void setDarkMode(boolean value) { darkMode = value; }

    public boolean isSoundEnabled() { return soundEnabled; }
    public void setSoundEnabled(boolean value) { soundEnabled = value; }

    public boolean isNotificationsOn() { return notificationsOn; }
    public void setNotificationsOn(boolean value) { notificationsOn = value; }

    public boolean isAutoLogin() { return autoLogin; }
    public void setAutoLogin(boolean value) { autoLogin = value; }

    public boolean isShowTooltips() { return showTooltips; }
    public void setShowTooltips(boolean value) { showTooltips = value; }

    public String getNickname() { return nickname; }
    public void setNickname(String value) { nickname = value; }
}

package sample.Game;

public class AppPanelManager {
    private int order = 0;
    public static final int ICON_WIDTH = 44;
    public static final int GLOBAL_OFFSET = 80;

    private static AppPanelManager ourInstance = new AppPanelManager();

    public static AppPanelManager getInstance() {
        return ourInstance;
    }

    private AppPanelManager() {

    }
    public double newIconRequestX() {
        return GLOBAL_OFFSET+(order++)*ICON_WIDTH;
    }

}

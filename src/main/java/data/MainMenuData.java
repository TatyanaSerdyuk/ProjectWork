package data;

public enum MainMenuData {
    COURCES("Курсы");

    private String name;

    MainMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

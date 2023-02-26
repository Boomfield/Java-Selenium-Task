package pages.tutorialNavigator.helpers;

public enum OptionType {
    NewTutorials("New tutorials"),
    NoLicense("No license"),
    Community("Community");
    private String displayName;

    OptionType(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}


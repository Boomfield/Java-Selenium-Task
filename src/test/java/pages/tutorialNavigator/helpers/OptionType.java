package pages.tutorialNavigator.helpers;

public enum OptionType {
    NEW_TUTORIALS("New tutorials"),
    NO_LICENSE("No license"),
    COMMUNITY("Community");

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


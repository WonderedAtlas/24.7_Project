package enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    COMPUTER_SCIENCE("Информатика"),
    JURISPRUDENCE("Юриспруденция"),
    MATHEMATICS("Математика"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика"),
    MANAGEMENT("Менеджмент"),
    ECONOMY("Экономика"),
    GEOGRAPHY("География");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}

package models;

import enums.StudyProfile;

public class Statistics {

    private StudyProfile profile;
    private float avgExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String universityNames;

    public Statistics(StudyProfile profile, float avgExamScore, int numberOfStudents, int numberOfUniversities, String universityNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.universityNames = universityNames;
    }

    public Statistics() {

    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}

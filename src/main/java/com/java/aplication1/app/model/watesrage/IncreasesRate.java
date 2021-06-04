package com.java.aplication1.app.model.watesrage;

public class IncreasesRate {

    private IncreasesRate() {
        throw new IllegalStateException("Utility class");
    }
    
    public static final Float RATE_BY_COURSES = 0.1f;
    public static final Float RATE_BY_TRAINING = 0.15f;
    public static final Float RATE_BY_UNIVERSITY_GRADUATE = 0.23f;
    public static final Float RATE_BY_POST_GRADUATE = 0.3f;
    public static final Float RATE_BY_PRODUCTION = 0.05f;

}
package com.training.template.constants;

public interface Constants {

    String DEFAULT_CONFIG_LOCATION = "src/test/resources/config/config.cfg";


    // Success Toast messages
    String CREATE_COURSE_SUCCESS_TOAST = "Course created";
    String CREATE_LESSON_SUCCESS_TOAST = "Lesson created";
    String CREATE_UNIT_SUCCESS_TOAST = "Unit created";
    String CREATE_CHAPTER_SUCCESS_TOAST = "Chapter created successfully";
    String COURSE_UPDATE_SUCCESS_TOAST = "Course updated";
    String COURSE_DELETE_SUCCESS_TOAST = "Course deleted";
    String ENROLL_SUCCESS_TOAST = "Course enrollment successful.";


    // Error Toast messages
    String COURSE_DELETE_FAILED_TOAST = "Deletion is not allowed for this course as it has already been purchased by students.";
}

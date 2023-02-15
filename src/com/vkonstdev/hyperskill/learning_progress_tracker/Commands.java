package com.vkonstdev.hyperskill.learning_progress_tracker;

public enum Commands {

    EXIT("exit"),
    ADD_STUDENTS("add students"),
    BACK("back"), LIST("list");

    public final String name;

    Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

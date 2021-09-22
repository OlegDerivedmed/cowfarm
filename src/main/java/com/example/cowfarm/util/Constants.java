package com.example.cowfarm.util;

public class Constants {

    public static final String COW_PARENT_NOT_FOUND = "Cow with such parentId not found.";
    public static final String COW_NOT_FOUND = "Cow with such parentId not found.";
    public static final String HOUSEHOLD = "Household:";
    public static final String COW_ADDED_TEMPLATE = "New cow was added:  {}";
    public static final String COW_REMOVED_TEMPLATE = "Cow ended life span: {}";
    public static final String IMMORTAL_COW = "Mother cow is immortal.";

    public static final String SOLUTION_TYPE_ONE = "1";
    public static final String SOLUTION_TYPE_TWO = "2";

    //Menu templates
    public static final String MAIN_MENU = "Available commands:" + "\n" +
            "1. Add new cow;" + "\n" +
            "2. Delete cow;" + "\n" +
            "3. Print farm data" + "\n" +
            "4. Stop application";
    public static final String SELECT_OPTION_MESSAGE = "Select option:";
    public static final String ENTER_PARENT_ID_MESSAGE = "Enter parent id:";
    public static final String ENTER_COW_ID_MESSAGE = "Enter cow id:";
    public static final String ENTER_NAME_MESSAGE = "Enter name:";
    public static final String INVALID_INPUT_MESSAGE = "Invalid input";
    public static final String INVALID_ARGUMENT_MESSAGE = "Incorrect argument provided. Available inputs: 1, 2.";
}

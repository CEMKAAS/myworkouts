package com.zaroslikov.myworkouts.db;


public class MyConstanta {

    public static final String DB_NAME = "my_dbWorkout.db"; //База данных
    public static final int DB_VERSION = 1; //Версия базы данных


    public static final String TABLE_NAME = "Person"; // Название таблицы
    public static final String _ID = "id";

    public static final String NAME = "Name"; // Имя
    public static final String GENDER = "Gender"; //Пол
    public static final String DREAM_WEIGHT = "DreamWeigh";

    public static final String TABLE_PARAMETER = "Parameter";
    public static final String WEIGHT = "Weight"; //Вес
    public static final String HEIGHT = "Height"; // Рост
    public static final String DATE = "Date"; //Дата


    public static final String TABLE_WORKOUT = "Workout";
    public static final String NAME_WORKOUT = "NameWorkout";
    public static final String WEEKDAY = "WeekDay";


    public static final String TABLE_EXERCISE = "Exercise";
    public static final String APPROACH = "Approach";
    public static final String COUNT = "Count";
    public static final String WEIGHTWORKOUT = "WeightWorkout";
    public static final String TIME = "TIME";
    public static final String ID_WORKOUT = "IdWorkout";


    public static final String TABLE_STRUCTURE_NAME = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, "
            + NAME + " TEXT, "
            + GENDER + " TEXT, "
            + DREAM_WEIGHT + " REAL)";


    public static final String TABLE_STRUCTURE_PARAMETER = "CREATE TABLE IF NOT EXISTS " +
            TABLE_PARAMETER + " (" + _ID + " INTEGER PRIMARY KEY, "
            + WEIGHT + " REAL, "
            + HEIGHT + " REAL, "
            + DATE + " TEXT)";


    public static final String TABLE_STRUCTURE_WORKOUT = "CREATE TABLE IF NOT EXISTS " +
            TABLE_WORKOUT + " (" + _ID + " INTEGER PRIMARY KEY, "
            + NAME_WORKOUT + " TEXT, "
            + WEEKDAY + " TEXT, ";


    public static final String TABLE_STRUCTURE_EXERCISE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_EXERCISE + " (" + _ID + " INTEGER PRIMARY KEY, "
            + APPROACH + " INTEGER, "
            + COUNT + " INTEGER, "
            + WEIGHTWORKOUT + " REAL, "
            + TIME + " TEXT, "
            + ID_WORKOUT + " INTEGER, FOREIGN KEY (" + ID_WORKOUT + ") REFERENCES " + TABLE_WORKOUT + " (" + _ID + "))";



    public static final String DROP_TABLE_PERSON = "DROP TABLE IF EXISTS" + TABLE_NAME; // сброс продаж
    public static final String DROP_TABLE_PARAMETER = "DROP TABLE IF EXISTS" + TABLE_PARAMETER; // сброс покупок
    public static final String DROP_TABLE_WORKOUT = "DROP TABLE IF EXISTS" + TABLE_WORKOUT; // сброс обычной
    public static final String DROP_TABLE_EXERCISE = "DROP TABLE IF EXISTS" + TABLE_EXERCISE; // сброс обычной


}

package com.example.LocalStorageDemo.ultil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.LocalStorageDemo.model.Student;

import java.util.ArrayList;

/**
 * User: anhnt
 * Date: 10/23/13
 * Time: 8:22 AM
 */
public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentManager.db";
    private static final String TABLE = "student";

    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_AGE = "student_age";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String CREATE_TABLE_SQL = "CREATE TABLE " + TABLE
                + "(" + STUDENT_ID + " INTEGER PRIMARY KEY autoincrement, "
                + STUDENT_AGE + " TEXT, "
                + STUDENT_NAME + " TEXT" + " )";
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
    {
        String DROP_TABLE_SQL = "DROP TABLE IF EXISTS " + TABLE;
        sqLiteDatabase.execSQL(DROP_TABLE_SQL);
        onCreate(sqLiteDatabase);
    }

    public Student findOne(int studentId)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE, new String[]{STUDENT_NAME, STUDENT_AGE}, STUDENT_ID + "=?"
                , new String[]{String.valueOf(studentId)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
    }

    public boolean insert(Student student)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        try
        {
            ContentValues values = new ContentValues();
            values.put(STUDENT_AGE, student.getStudentAge());
            values.put(STUDENT_NAME, student.getStudentName());
            database.insert(TABLE, null, values);
            database.close();
            return true;
        }
        catch (Exception ignored)
        {
        }
        return false;
    }

    public ArrayList<Student> getAll()
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Student> students = new ArrayList<Student>();
        String selectQuery = "SELECT * FROM " + TABLE;
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Student student = new Student();
                student.setStudentId(cursor.getInt(0));
                student.setStudentAge(cursor.getString(1));
                student.setStudentName(cursor.getString(2));
                students.add(student);
            } while (cursor.moveToNext());
        }
        database.close();
        return students;
    }

    public int update(Student student)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_AGE, student.getStudentAge());
        return database.update(TABLE, values, STUDENT_ID + "=?", new String[]{String.valueOf(student.getStudentId())});
    }

    public void delete(Student student)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE, STUDENT_ID + "=?", new String[]{String.valueOf(student.getStudentId())});
        database.close();
    }

}

package com.example.LocalStorageDemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.LocalStorageDemo.R;
import com.example.LocalStorageDemo.model.Student;
import com.example.LocalStorageDemo.ultil.DatabaseHandler;
import com.example.LocalStorageDemo.ultil.ListArrayAdapter;

import java.util.ArrayList;

/**
 * User: anhnt
 * Date: 10/23/13
 * Time: 8:34 AM
 */
public class SQLiteActivity extends Activity
{
    private static final String TAG = "SQLiteActivity";
    private ListView lvStudentList;
    private Button btAdd;
    private Button btBack;
    private EditText etStudentName;
    private EditText etStudentAge;
    private DatabaseHandler databaseHandler;
    private View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.sqlite_btAdd:
                    doAdd();
                    break;
                case R.id.sqlite_btBack:
                    doBack();
                    break;
            }
        }
    };
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            initStudentList();
        }
    };

    private void doBack()
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void doAdd()
    {
        Student student = getStudent();
        databaseHandler.insert(student);
        Log.i(TAG, student.getStudentName());
        initStudentList();
    }

    private Student getStudent()
    {
        Student student = new Student();
        student.setStudentName(etStudentName.getText().toString());
        student.setStudentAge(etStudentAge.getText().toString());
        return student;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);
        setUpUI();
        databaseHandler = new DatabaseHandler(this);
        initStudentList();
        setUpControllerListener();
    }

    private void setUpControllerListener()
    {
        btAdd.setOnClickListener(onClickListener);
        btBack.setOnClickListener(onClickListener);
        lvStudentList.setOnItemClickListener(onItemClickListener);
    }

    private void setUpUI()
    {
        lvStudentList = (ListView) findViewById(R.id.sqlite_lvStudenList);
        btAdd = (Button) findViewById(R.id.sqlite_btAdd);
        btBack = (Button) findViewById(R.id.sqlite_btBack);
        etStudentName = (EditText) findViewById(R.id.sqlite_etStudentName);
        etStudentAge = (EditText) findViewById(R.id.sqlite_etStudentAge);
    }

    private void initStudentList()
    {
        ArrayList<Student> list = databaseHandler.getAll();
        lvStudentList.setAdapter(new ListArrayAdapter(this, R.id.sqlite_lvStudenList, list));
    }


}
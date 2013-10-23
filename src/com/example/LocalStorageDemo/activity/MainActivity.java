package com.example.LocalStorageDemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.LocalStorageDemo.R;

import java.io.*;

public class MainActivity extends Activity
{
    private Button btDatabase;
    private Button btSharedPreference;
    private Button btExternalStorage;
    private View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.main_btDatabase:
                    showDatabaseView();
                    break;
                case R.id.main_btSharedPrefrence:
                    showSharedPreferenceView();
                    break;
                case R.id.main_btExternalStorage:
                    showExternalStorageView();
                    break;
            }
        }
    };

    private void showExternalStorageView()
    {
        startActivity(new Intent(this, ExternalStorageActivity.class));
    }

    private void showSharedPreferenceView()
    {
        startActivity(new Intent(this, SharedPreferenceActivity.class));
    }

    private void showDatabaseView()
    {
        startActivity(new Intent(this, SQLiteActivity.class));
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpUI();
        setUpControllerListener();

        copyFile("/data/data/com.example.LocalStorageDemo/databases/StudentManager.db",
                Environment.getExternalStorageDirectory() + "/StudentManager.db");

    }

    private void copyFile(String fromFile, String toFile)
    {
        try
        {
            Log.e("fromFile", " " + fromFile);
            Log.e("toFile", " " + toFile);
            File f1 = new File(fromFile);
            File f2 = new File(toFile);
            InputStream in = new FileInputStream(f1);

            // For Append the file.
            // OutputStream out = new FileOutputStream(f2,true);
            // For Overwrite the file.
            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            Log.e("============Okkk1111", "File copied.");
        }
        catch (FileNotFoundException ex)
        {
            Log.e("============FileNotFoundException", ex.getMessage()
                    + " in the specified directory.");
        }
        catch (IOException e)
        {
            Log.e("============IOException", e.getMessage());
        }
    }

    private void setUpControllerListener()
    {
        btDatabase.setOnClickListener(onClickListener);
        btSharedPreference.setOnClickListener(onClickListener);
        btExternalStorage.setOnClickListener(onClickListener);
    }

    private void setUpUI()
    {
        btDatabase = (Button) findViewById(R.id.main_btDatabase);
        btSharedPreference = (Button) findViewById(R.id.main_btSharedPrefrence);
        btExternalStorage = (Button) findViewById(R.id.main_btExternalStorage);
    }
}

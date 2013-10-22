package com.example.LocalStorageDemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.LocalStorageDemo.R;

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

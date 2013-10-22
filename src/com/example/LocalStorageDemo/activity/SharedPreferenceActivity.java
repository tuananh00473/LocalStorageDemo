package com.example.LocalStorageDemo.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import com.example.LocalStorageDemo.R;

/**
 * User: anhnt
 * Date: 10/22/13
 * Time: 8:56 AM
 */
public class SharedPreferenceActivity extends Activity
{
    public static final String KEY = "inputText";
    private EditText etInputText;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preference);
        setUpUI();
        setUpControllerListener();
        loadSharedPreferences();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    private final TextWatcher textChangeListener = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3)
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void afterTextChanged(Editable editable)
        {
            saveToSharedPreferences(KEY, etInputText.getText().toString());
        }
    };

    private void saveToSharedPreferences(String key, String value)
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void setUpControllerListener()
    {
        etInputText.addTextChangedListener(textChangeListener);
    }

    private void setUpUI()
    {
        etInputText = (EditText) findViewById(R.id.shared_preference_etInputText);
    }

    private void loadSharedPreferences()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String inputText = sharedPreferences.getString(KEY, "inputText");
        if (null != inputText)
        {
            etInputText.setText(inputText);
        }
    }
}
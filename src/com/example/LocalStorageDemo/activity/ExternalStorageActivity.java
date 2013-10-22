package com.example.LocalStorageDemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.LocalStorageDemo.R;
import com.example.LocalStorageDemo.dialog.MyDialog;

/**
 * User: anhnt
 * Date: 10/22/13
 * Time: 10:06 AM
 */
public class ExternalStorageActivity extends Activity
{
    private Button btWriteText;
    private Button btLoadText;
    private Button btWriteXML;
    private Button btLoadXML;
    private View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.external_storage_btWriteText:
                    doWriteText();
                    break;
                case R.id.external_storage_btLoadText:
                    doLoad();
                    break;
                case R.id.external_storage_btWriteXML:
                    break;
                case R.id.external_storage_btLoadXML:
                    break;
            }
        }
    };

    private void doLoad()
    {
        MyDialog.showDialogLoad(this, "Load file from SDcard");
    }

    private void doWriteText()
    {
        MyDialog.showDialogWriteText(this, "Write text to SDcard");
    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage);
        setUpUI();
        setUpControllerListener();
    }

    private void setUpControllerListener()
    {
        btWriteText.setOnClickListener(onClickListener);
        btLoadText.setOnClickListener(onClickListener);
        btWriteXML.setOnClickListener(onClickListener);
        btLoadXML.setOnClickListener(onClickListener);
    }

    private void setUpUI()
    {
        btWriteText = (Button) findViewById(R.id.external_storage_btWriteText);
        btLoadText = (Button) findViewById(R.id.external_storage_btLoadText);
        btWriteXML = (Button) findViewById(R.id.external_storage_btWriteXML);
        btLoadXML = (Button) findViewById(R.id.external_storage_btLoadXML);
    }
}
package com.example.LocalStorageDemo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.LocalStorageDemo.R;
import com.example.LocalStorageDemo.ultil.IOFile;

import java.io.File;

/**
 * User: anhnt
 * Date: 10/22/13
 * Time: 10:13 AM
 */
public class MyDialog
{
    private static Activity activity;
    private static Dialog dialog;

    private static TextView tvTittle;
    private static EditText etContent;
    private static EditText etFileName;

    private static Button btSubmit;
    private static Button btCancel;


    private static File root = android.os.Environment.getExternalStorageDirectory();
    private static View.OnClickListener onViewClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String filePath = root.getAbsolutePath() + "/anhnt";
            String fileName;
            String content;
            switch (view.getId())
            {
                case R.id.dialog_write_text_btWrite:
                    fileName = etFileName.getText().toString();
                    content = etContent.getText().toString();
                    boolean isSuccess = IOFile.writeTextToSD(filePath, fileName, content);
                    if (isSuccess)
                    {
                        showMessageDialog(activity, "Success", "Write file success!");
                    }
                    else
                    {
                        showMessageDialog(activity, "Failure", "Write file failure!");
                    }
                    dialog.dismiss();
                    break;
                case R.id.dialog_write_text_btCancel:
                    dialog.dismiss();
                    break;
                case R.id.dialog_load_btLoadFile:
                    fileName = etFileName.getText().toString();
                    content = IOFile.loadTextFromSD(filePath, fileName);
                    if (content != null)
                    {
                        etContent.setText(content);
                    }
                    else
                    {
                        showMessageDialog(activity, "Failure", "Load file failure!");
                    }
                    break;
                case R.id.dialog_load_btCancel:
                    dialog.dismiss();
                    break;
            }
        }
    };

    public static void showDialogWriteText(Activity act, String tittle)
    {
        activity = act;
        dialog = new Dialog(activity);
        dialog.setContentView(R.layout.dialog_write_text);
        setUpUIDialogWriteText(tittle);
        btSubmit.setOnClickListener(onViewClickListener);
        btCancel.setOnClickListener(onViewClickListener);
        dialog.show();
    }

    private static void setUpUIDialogWriteText(String tittle)
    {
        tvTittle = (TextView) dialog.findViewById(android.R.id.title);
        tvTittle.setSingleLine(false);
        tvTittle.setText(tittle);
        etContent = (EditText) dialog.findViewById(R.id.dialog_write_text_etInputText);
        etFileName = (EditText) dialog.findViewById(R.id.dialog_write_text_etFileName);
        btSubmit = (Button) dialog.findViewById(R.id.dialog_write_text_btWrite);
        btCancel = (Button) dialog.findViewById(R.id.dialog_write_text_btCancel);
    }

    public static void showDialogLoad(Activity act, String tittle)
    {
        activity = act;
        dialog = new Dialog(activity);
        dialog.setContentView(R.layout.dialog_load);
        setUpUIDialogLoad(tittle);
        btSubmit.setOnClickListener(onViewClickListener);
        btCancel.setOnClickListener(onViewClickListener);
        dialog.show();
    }

    private static void setUpUIDialogLoad(String tittle)
    {
        tvTittle = (TextView) dialog.findViewById(android.R.id.title);
        tvTittle.setSingleLine(false);
        tvTittle.setText(tittle);
        etContent = (EditText) dialog.findViewById(R.id.dialog_load_etOutput);
        etFileName = (EditText) dialog.findViewById(R.id.dialog_load_etFileName);
        btSubmit = (Button) dialog.findViewById(R.id.dialog_load_btLoadFile);
        btCancel = (Button) dialog.findViewById(R.id.dialog_load_btCancel);
    }

    public void showConfirmDialog(Activity act, String tittle, String message)
    {
        activity = act;
        final int[] result = null;
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(activity);
        alertDialog2.setTitle(tittle);
        alertDialog2.setMessage(message);
        alertDialog2.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                result[0] = 1;
            }
        });
        alertDialog2.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                result[0] = 0;
            }
        });
        alertDialog2.show();
    }

    public static void showMessageDialog(Activity act, String tittle, String message)
    {
        activity = act;
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(activity);
        alertDialog2.setTitle(tittle);
        alertDialog2.setMessage(message);
        alertDialog2.setPositiveButton("OK", onClickListener);
        alertDialog2.show();
    }

    private static final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialogInterface, int i)
        {
            // do some thing.
        }
    };
}

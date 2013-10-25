package com.example.LocalStorageDemo.ultil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.LocalStorageDemo.R;
import com.example.LocalStorageDemo.model.Student;

import java.util.ArrayList;

/**
 * User: anhnt
 * Date: 10/10/13
 * Time: 11:41 AM
 */
public class ListArrayAdapter extends ArrayAdapter<Student>
{
    private Context context;
    private ArrayList<Student> students;
    private DatabaseHandler databaseHandler;

    public ListArrayAdapter(Context context, int textViewResourceId, ArrayList<Student> students)
    {
        super(context, textViewResourceId, students);
        this.context = context;
        this.students = students;
        databaseHandler = new DatabaseHandler(this.context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, null);
        }
        Student student = students.get(position);

        TextView tvStudentId = (TextView) convertView.findViewById(R.id.sqlite_tvStudentId);
        TextView tvStudentName = (TextView) convertView.findViewById(R.id.sqlite_tvStudentName);
        TextView tvStudentAge = (TextView) convertView.findViewById(R.id.sqlite_tvStudentAge);

        tvStudentId.setText(String.valueOf(student.getStudentId()));
        tvStudentName.setText(student.getStudentName());
        tvStudentAge.setText(student.getStudentAge());

        Button btEdit = (Button) convertView.findViewById(R.id.sqlite_btEdit);
        Button btDelete = (Button) convertView.findViewById(R.id.sqlite_btDelete);

        MyOnClickListener onClickListener = new MyOnClickListener(position);

        btEdit.setOnClickListener(onClickListener);
        btDelete.setOnClickListener(onClickListener);

        return convertView;
    }

    private class MyOnClickListener implements View.OnClickListener
    {
        private int position;

        private MyOnClickListener(int position)
        {
            this.position = position;
        }

        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.sqlite_btEdit:

                    break;
                case R.id.sqlite_btDelete:
                    databaseHandler.delete(students.get(position));
                    students.remove(position);
                    notifyDataSetChanged();
                    break;
            }
        }
    }
}

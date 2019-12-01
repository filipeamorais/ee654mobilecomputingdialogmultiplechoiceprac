package com.example.dialogmultiplechoiceprac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView text;
    String[] colors = {"Red", "Green", "Blue"};
    final ArrayList items = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        String s = " ";
                        for (int i = 0; i < items.size(); i++)
                            s = s + colors[(int) items.get(i)] + " ";
                        text.setText(s);
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        // User cancelled the dialog
                    }
                });
        builder.setMultiChoiceItems(colors, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which, boolean isChecked) {
                        if (isChecked) items.add(which);
                        else if (items.contains(which))
                            items.remove(Integer.valueOf(which));
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


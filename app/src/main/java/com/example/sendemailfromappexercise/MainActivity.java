package com.example.sendemailfromappexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toEditText)
    EditText sendTo;
    @BindView(R.id.subjectEditText)
    EditText subject;
    @BindView(R.id.compose)
    EditText compose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sendButton)
    public void onClick() {
        sendEmail();
    }

    public void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{sendTo.getText().toString()});
        i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, compose.getText().toString());
        i.setData(Uri.parse("mailto:"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}

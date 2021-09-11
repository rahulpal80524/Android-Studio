package com.example.adminmedi_capsuniversity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adminmedi_capsuniversity.faculty.UpdateFaculty;
import com.example.adminmedi_capsuniversity.notice.DeleteNoticeActivity;
import com.example.adminmedi_capsuniversity.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice,addGalleryImage,addEbook,faculty,deleteNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        faculty =findViewById(R.id.addfaculty);
        addEbook = findViewById(R.id.addEbook);
        deleteNotice = findViewById(R.id.deleteNotice);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){

            case R.id.addNotice:
                 intent = new Intent(this, UploadNotice.class);
                startActivity(intent);
                break;

            case R.id.addGalleryImage:
                 intent = new Intent(this,UploadImage.class);
                startActivity(intent);
                break;

            case R.id.addEbook:
                 intent = new Intent(this,UploadPdfActivity.class);
                startActivity(intent);
                break;

            case R.id.addfaculty:
                 intent = new Intent(this, UpdateFaculty.class);
                startActivity(intent);
                break;

            case R.id.deleteNotice:
                 intent = new Intent(this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

        }

    }
}
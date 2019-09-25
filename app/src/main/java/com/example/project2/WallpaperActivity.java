package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button camera, setWall;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        imageView = (ImageView) findViewById(R.id.imageWallpaper);
        camera = (Button) findViewById(R.id.buttonCamera);
        setWall = (Button) findViewById(R.id.buttonSetWall);

        camera.setOnClickListener(this);
        setWall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCamera:
                final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
                break;

            case R.id.buttonSetWall:
                try {
                    getApplicationContext().setWallpaper(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Wallpaper Set Successfully", Toast.LENGTH_SHORT).show();
                // finish();

//                Thread thread = new Thread() {
//                    @Override
//                    public void run() {
//                        super.run();
//                        try {
//                            sleep(2000);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        } finally {
//                            Intent intent1 = new Intent(WallpaperActivity.this, WallpaperActivity.class);
//                            startActivity(intent1);
//                        }
//
//                    }
//                };
//                thread.start();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle b = data.getExtras();
            bitmap = (Bitmap) b.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}

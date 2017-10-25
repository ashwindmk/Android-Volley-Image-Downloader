package com.example.volleyimagedownloader;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "http://placehold.it/600/92c952";

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);

        loadImage();
    }

    private void loadImage() {
        // Retrieves an image specified by the url
        ImageRequest request = new ImageRequest(IMAGE_URL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mImageView.setImageResource(R.drawable.no_image_available);
                    }
                }
        );

        // Access the RequestQueue through your singleton class
        VolleySingleton.getInstance().addToRequestQueue(request);
    }
}

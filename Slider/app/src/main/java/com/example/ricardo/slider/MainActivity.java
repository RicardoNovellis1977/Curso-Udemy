package com.example.ricardo.slider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new SimpleSlide.Builder().title("Titulo")
                                          .description("Description")
                                          .image(R.drawable.um)
                                          .background(android.R.color.holo_orange_light)
                                          .build()
        );

        addSlide(new SimpleSlide.Builder().title("Titulo2")
                .description("Description2")
                .image(R.drawable.dois)
                .background(android.R.color.holo_orange_light)
                .build()
        );

        addSlide(new SimpleSlide.Builder().title("Titulo3")
                .description("Description3")
                .image(R.drawable.tres)
                .background(android.R.color.holo_orange_light)
                .build()
        );

        addSlide(new SimpleSlide.Builder().title("Titulo4")
                .description("Description4")
                .image(R.drawable.quatro)
                .background(android.R.color.holo_orange_light)
                .build()
        );

    }
}

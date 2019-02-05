package com.example.nei.themoviedb.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nei.themoviedb.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class ViewActivity extends AppCompatActivity {
    private TextView score,overview,name;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        name= findViewById(R.id.Tname);
        score= findViewById(R.id.tscore);
        overview= findViewById(R.id.toverview);
        picture= findViewById(R.id.picture);
        Bundle arg= getIntent().getExtras();
        if( arg!= null){
            String URL="https://image.tmdb.org/t/p/w185_and_h278_bestv2"+arg.getString("picture");
            name.setText(arg.getString("name"));
            score.setText("Score: "+arg.getString("score"));
            overview.setText(arg.getString("overview"));
            Picasso.Builder builder= new Picasso.Builder(this);
            builder.downloader(new OkHttp3Downloader(this));
            builder.build().load(URL)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).into(picture);


        }

    }
}

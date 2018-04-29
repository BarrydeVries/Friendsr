package com.example.barry.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // retrieve intended friend to show up
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // find id's of elements of view
        ImageView photo = findViewById(R.id.Photo);
        TextView name = findViewById(R.id.Name);
        TextView bio = findViewById(R.id.Bio);
        RatingBar ratingBar = findViewById(R.id.Rating);

        // fill page accordingly
        Drawable imageId = getResources().getDrawable((retrievedFriend.getDrawable()));
        name.setText(retrievedFriend.getName());
        photo.setImageDrawable(imageId);
        bio.setText(retrievedFriend.getBio());

        // set up rating bar
        ratingBar.setRating(0);
        addListenerOnRatingBar(retrievedFriend);
    }

    public void addListenerOnRatingBar(final Friend retrievedFriend) {

        RatingBar ratingBar = findViewById(R.id.Rating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                // open shared preferences
                SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                // get shared preferences for current name
                Float storedRating = prefs.getFloat("rating" + retrievedFriend.getName(),
                        0);
                Integer timesRated = prefs.getInt("rated" + retrievedFriend.getName(),
                        0) + 1;

                // add a new rating to counter
                editor.putInt("rated" + retrievedFriend.getName(), timesRated);

                // check whether a rating is available
                if (storedRating != 0) {

                    // set new rating
                    ratingBar.setRating((storedRating + rating) / timesRated);
                    // put new rating in shared preferences
                    editor.putFloat("rating" + retrievedFriend.getName(), storedRating + rating);
                }
                else {
                    // set rating
                    ratingBar.setRating(rating);
                    // put new rating in shared preferences
                    editor.putFloat("rating" + retrievedFriend.getName(), rating);
                }
                editor.apply();
            }
        });
    }
}

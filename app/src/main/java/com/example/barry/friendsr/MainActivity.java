package com.example.barry.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    // set up list of friends we add
    String[] names = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                      "Melisandre", "Sansa", "Tyrion"};

    String[] names2 = {"arya", "cersei", "daenerys", "jaime", "jon", "jorah", "margaery",
            "melisandre", "sansa", "tyrion"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create initial profiles
        for (int i = 0; i < names.length; i++){
            Friend aFriend = new Friend(names[i], "Hi I'm " + names[i] + ".",
                    getResources().getIdentifier(names2[i] ,
                                                 "drawable", getPackageName()));
            friends.add(aFriend);
        }

        // set up the gridview
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = findViewById(R.id.dynamic);
        gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            // create intent for reference to new screen
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }
}
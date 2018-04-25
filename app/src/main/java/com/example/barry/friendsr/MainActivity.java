package com.example.barry.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    String[] names = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                      "Melisandre", "Sansa", "Tyrion"};

    String[] names2 = {"arya", "cersei", "daenerys", "jaime", "jon", "jorah", "margaery",
            "melisandre", "sansa", "tyrion"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loop over initial profiles
        for (int i = 0; i < names.length; i++){
            Friend aFriend = new Friend(names[i], "Hi I'm " + names[i] + ".",
                    getResources().getIdentifier(names2[i] ,
                                                 "drawable", getPackageName()));
            friends.add(aFriend);
        }

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = findViewById(R.id.dynamic);
        gridView.setAdapter(adapter);
    }



}

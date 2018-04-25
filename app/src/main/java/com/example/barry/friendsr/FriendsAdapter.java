package com.example.barry.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        ImageView photo = convertView.findViewById(R.id.Photo);
        TextView name = convertView.findViewById(R.id.Name);

        Friend aFriend = (Friend) friends.get(position);

        Drawable imageId = getContext().getResources().getDrawable(aFriend.getDrawable());

        name.setText(aFriend.getName());
        Log.d(aFriend.getName(), "name");
        photo.setImageDrawable(imageId);
        return convertView;
    }
}

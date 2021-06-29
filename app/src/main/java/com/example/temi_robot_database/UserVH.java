package com.example.temi_robot_database;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserVH extends RecyclerView.ViewHolder
{
    public TextView txt_Username, txt_Password,txt_option;
    public UserVH(@NonNull View itemView) {
        super(itemView);
        txt_Username = itemView.findViewById(R.id.txt_Username);
        txt_Password = itemView.findViewById(R.id.txt_Password);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}

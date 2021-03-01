package com.benchelbikh.architecture.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.benchelbikh.architecture.R;
import com.benchelbikh.architecture.models.User;

import java.util.List;

public class UserAdapter extends
        RecyclerView.Adapter<UserAdapter.ViewHolder> {

    MyContext context;
    List<User> users;

    public UserAdapter(MyContext ctx) {
        context = ctx;
        users = ctx.getDs().getUsers();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_user, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);

        TextView nameTextView = holder.nameTextView;
        TextView userNameTextView = holder.userNameTextView;
        TextView emailTextView = holder.emailTextView;

        nameTextView.setText(user.getName());
        userNameTextView.setText(user.getUsername());
        emailTextView.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView userNameTextView;
        public TextView emailTextView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.name);
            userNameTextView = (TextView) itemView.findViewById(R.id.username);
            emailTextView = (TextView) itemView.findViewById(R.id.email);

        }
    }
}
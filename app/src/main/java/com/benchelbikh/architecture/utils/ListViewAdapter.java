package com.benchelbikh.architecture.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.benchelbikh.architecture.R;
import com.benchelbikh.architecture.models.User;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    MyContext context;
    List<User> users ;
    LayoutInflater layoutInflater;

    public ListViewAdapter(MyContext c) {
        context = c;
        users = context.getDs().getUsers();
        layoutInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        ViewHolder holder;

        if (itemView == null) {
            itemView = layoutInflater.inflate(R.layout.item_user,null);
            holder = new ViewHolder();
            holder.name = (TextView)itemView.findViewById(R.id.name);
            holder.username = (TextView)itemView.findViewById(R.id.username);
            holder.email = (TextView)itemView.findViewById(R.id.email);
            holder.removeButton = (Button)itemView.findViewById(R.id.removeBtn);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        holder.name.setText(users.get(position).getName());
        holder.username.setText(users.get(position).getUsername());
        holder.email.setText(users.get(position).getEmail());
        holder.removeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.getDs().deleteUser(users.get(position).getId());
                ListViewAdapter.this.notifyDataSetChanged();
            }
        });
        return itemView;
    }

    static class ViewHolder {
        TextView name;
        TextView username;
        TextView email;
        Button removeButton;
    }
}

//package com.benchelbikh.architecture.utils;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.benchelbikh.architecture.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
//
//    private List<String> mDataset;
//    private static Context sContext;
//
//    public MyAdapter(Context context, List<String> myDataset) {
//        mDataset = myDataset;
//        sContext = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_so, parent, false);
//
//        ViewHolder holder = new ViewHolder(v);
//        ((TextView)holder.mNameTextView).setOnClickListener(MyAdapter.this);
//        holder.mNameTextView.setOnLongClickListener(MyAdapter.this);
//
//        holder.mNameTextView.setTag(holder);
//
//        return holder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        holder.mNameTextView.setText(mDataset.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        ViewHolder holder = (ViewHolder) view.getTag();
//        if (view.getId() == holder.mNameTextView.getId()) {
//            Toast.makeText(sContext, holder.mNameTextView.getText(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    @Override
//    public boolean onLongClick(View view) {
//        ViewHolder holder = (ViewHolder) view.getTag();
//        if (view.getId() == holder.mNameTextView.getId()) {
//            mDataset.remove(holder.getAdapterPosition());
//
//            notifyDataSetChanged();
//
//            Toast.makeText(sContext, "Item " + holder.mNameTextView.getText() + " has been removed from list",
//                    Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView mNumberRowTextView;
//        public TextView mNameTextView;
//
//
//        public ViewHolder(View v) {
//            super(v);
//
//            mNameTextView = (TextView) v.findViewById(R.id.nameTextView);
//        }
//    }
//}
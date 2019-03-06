package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.model.ApiGitHub;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    Context context;
    ArrayList<ApiGitHub> users = new ArrayList<>();




    public Adapter(Context context, ArrayList<ApiGitHub> users) {
        this.context =  context;
        this.users = users;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // khoi tao dong cua recyclerview
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_row, viewGroup, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    //bind du lieu
    @Override
    public void onBindViewHolder(@NonNull final Viewholder viewholder, final int i) {

        Picasso.with(context).
                load(users.get(i).getAvatarUrl()).
                into(viewholder.imageView);

        viewholder.textView.setText(users.get(i).getLogin());
        viewholder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+users.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,DigitalActivity.class);
                intent.putExtra("namedigital",""+viewholder.textView.getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout layout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView2);
            layout = itemView.findViewById(R.id.layout_linear);
        }
    }
}

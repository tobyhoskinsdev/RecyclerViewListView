package examples.aaronhoskins.com.recyclerviewlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Movies> moviesArrayList;

    public RecyclerViewAdapter(ArrayList<Movies> moviesArrayList) {
        this.moviesArrayList = moviesArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Movies movie = moviesArrayList.get(position);

        if(movie != null) {
            //Drawable image = viewHolder.itemView.getContext().getResources().getDrawable(R.drawable.image);
            String title = movie.getTitle();
            String desc = movie.getDesc();

            viewHolder.setItemMovie(movie);
            viewHolder.tvDesc.setText(desc);
            viewHolder.tvTitle.setText(title);
            //viewHolder.imgImage.setImageResource(R.drawable.image);
            //viewHolder.imgImage.setImageDrawable(image);
            Glide.with(viewHolder.itemView.getContext())
                    .load("https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg")
                    .into(viewHolder.imgImage);
        }
    }

    public void addMovie(Movies movies){
        moviesArrayList.add(movies);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return moviesArrayList != null ? moviesArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        TextView tvTitle;
        TextView tvDesc;
        Movies itemMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.imgViewImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), itemMovie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setItemMovie(Movies itemMovie) {
            this.itemMovie = itemMovie;
        }

    }
}

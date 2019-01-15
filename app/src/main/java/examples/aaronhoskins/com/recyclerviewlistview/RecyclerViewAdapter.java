package examples.aaronhoskins.com.recyclerviewlistview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
            String title = movie.getTitle();
            String desc = movie.getDesc();

            viewHolder.tvDesc.setText(desc);
            viewHolder.tvTitle.setText(title);
        }
    }

    @Override
    public int getItemCount() {
        return moviesArrayList != null ? moviesArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        TextView tvTitle;
        TextView tvDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.imgViewImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}

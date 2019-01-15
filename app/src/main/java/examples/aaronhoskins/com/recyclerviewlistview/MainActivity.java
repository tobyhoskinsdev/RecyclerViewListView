package examples.aaronhoskins.com.recyclerviewlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMainRecyclerView);
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(listOfMovies());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);

    }

    private ArrayList<Movies> listOfMovies() {
        ArrayList<Movies> moviesArrayList = new ArrayList<>();


        for(int i = 0 ; i < 30 ; i++) {
            Movies movie = new Movies();
            movie.setDesc(String.valueOf(i));
            movie.setTitle("TITLE" + i);
            moviesArrayList.add(movie);
        }
        return moviesArrayList;
    }
}

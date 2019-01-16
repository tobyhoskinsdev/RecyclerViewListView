package examples.aaronhoskins.com.recyclerviewlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMainRecyclerView);
        lstView = findViewById(R.id.listView);

        //RV
        rvAdapter = new RecyclerViewAdapter(listOfMovies());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);
        int image = R.drawable.image;
        Log.d("TAG", "onCreate: " + image);

        //List
        String[] list =  {"sam", "joe", "sarah" , "toby", "ect"};
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(
                        this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, list);

        lstView.setAdapter(adapter);

    }

    public void onClick(View view) {
        Movies newMoview = new Movies("Pulp Fiction", "People get high and kill people");
        rvAdapter.addMovie(newMoview);

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

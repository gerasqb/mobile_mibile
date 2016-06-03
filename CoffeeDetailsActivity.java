package com.homemade.barista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CoffeeDetailsActivity extends AppCompatActivity {

    private TextView title;
    private ImageView imageView;
    private TextView description;

    private Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_details);

        Intent intent = getIntent();
        coffee = (Coffee) intent.getSerializableExtra("coffee");

        title = (TextView) findViewById(R.id.title);
        imageView = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);

        title.setText(coffee.getTitle());
        int id = getResources().getIdentifier("coffee"+coffee.getId(),"drawable",getPackageName());
        /*imageView.setImageResource(id);*/
        description.setText(coffee.getDescription());

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

package com.example.simonhsieh.ddcharactersheet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_main);
        Iconify.with(new FontAwesomeModule());
        ButterKnife.bind(this);
        PagerAdapter adapter = new PagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.app_bar_search).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_search).colorRes(R.color.white).actionBarSize());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.app_bar_search) {
//            DO SOME THINGS
//            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingsActivity.class);
//            String message = editText.getText().toString();
//            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}

package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS, btnOCBC, btnUOB;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDBS = findViewById(R.id.btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_web_con, menu);

        int id = v.getId();

        if (id == R.id.btnDBS) {
            type = "DBS";
        } else if (id == R.id.btnOCBC) {
            type = "OCBC";
        } else if (id == R.id.btnUOB) {
            type = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.website:
                if (type.equals("DBS")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb))));
                } else if (type.equals("OCBC")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb))));
                } else if (type.equals("UOB")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb))));
                }
                break;

            case R.id.contact:
                if (type.equals("DBS")) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsNum))));
                } else if (type.equals("OCBC")) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcNum))));
                } else if (type.equals("UOB")) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobNum))));
                }
                break;
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ChineseSelection) {

            btnDBS.setText(getString(R.string.dbsC));
            btnOCBC.setText(getString(R.string.ocbcC));
            btnUOB.setText(getString(R.string.uobC));
            return true;
        } else if (id == R.id.EnglishSelection) {
            btnDBS.setText(getString(R.string.dbs));
            btnOCBC.setText(getString(R.string.ocbc));
            btnUOB.setText(getString(R.string.uob));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

package ca.mohawk.ougriniouk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
///I, Alexei Ougriniouk, 000776331 certify that this material is my original work. No
//other person's work has been used without due acknowledgement.
/// YT LINK ----> https://youtu.be/Unt7zeKqTR4

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {





    public static final String TAG = "==MainActivity==";
    private DrawerLayout myDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO Access myDrawer
         myDrawer = (DrawerLayout)
                    findViewById(R.id.drawer_layout);
        // TODO Access the ActionBar, enable "home" icon
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);
        // TODO Add an ActionBarDrawerToggle element
        ActionBarDrawerToggle myactionbartoggle = new
                ActionBarDrawerToggle(this, myDrawer,
                (R.string.open), (R.string.close));
        myDrawer.addDrawerListener(myactionbartoggle);
        myactionbartoggle.syncState();
        // TODO set up callback method for Navigation View
        NavigationView myNavView = (NavigationView)
                findViewById(R.id.nav_view);
        myNavView.setNavigationItemSelectedListener(this);

        Log.d(TAG, "onCreate");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Find out the current state of the drawer (open or closed)
        boolean isOpen = myDrawer.isDrawerOpen(GravityCompat.START);
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                // Home button - open or close the drawer
                if (isOpen == true) {
                    myDrawer.closeDrawer(GravityCompat.START);
                } else {
                    myDrawer.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Respond to Navigation Drawer item selected
    @Override
    public boolean onNavigationItemSelected(@NonNull
                                                    MenuItem item) {
        // Show visual for selection
        item.setChecked(true);
        // Close the Drawer
        myDrawer.closeDrawers();
        switch (item.getItemId()) {
            case R.id.AndroidDev:
                replaceFragment(new AndroidDev());
                Toast.makeText(this, "AndroidDev",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.AdvancedNet:
                replaceFragment(new AdvNet());
                Toast.makeText(this, "Advanced.Net",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.OracleSQL:
                replaceFragment(new OracleSQL());
                Toast.makeText(this, "OracleSQL",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();

    }
}


package com.cloudifive.healthcare;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.cloudifive.healthcare.fragment.DashboardFragment;

public class DashboardActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        toolbar = getSupportActionBar();
        toolbar.setTitle(R.string.app_name);
        loadFragment(new DashboardFragment(),"dashboard");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    public void loadFragment(Fragment fragment,String aBackstack ) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(aBackstack);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        try {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();

            } else {
                int aCount = getSupportFragmentManager().getBackStackEntryCount();

                String aBackStack = getSupportFragmentManager().getBackStackEntryAt(aCount - 1).getName();
                System.out.println("BACK STACK : "+aBackStack);
                if(aBackStack.equals("aster")||aBackStack.equals("chairman")||aBackStack.equals("success"))
                {
                    super.onBackPressed();

                }
                else
                {
                    super.onBackPressed();
                    toolbar.setTitle(R.string.app_name);
                    loadFragment(new DashboardFragment(),"dashboard");
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        try {
//        Fragment f=new DashboardFragment();
//        loadFragment(f,"dashboard");
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

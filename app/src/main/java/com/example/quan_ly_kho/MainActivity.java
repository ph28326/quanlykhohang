package com.example.quan_ly_kho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar toolbar;
    FragmentManager fragmentManager;
    Animation FadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=getSupportActionBar();
        FadeIn= AnimationUtils.loadAnimation(this,R.anim.fadein);
        BottomNavigationView navigation=findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.startAnimation(FadeIn);
        fragmentManager =   getSupportFragmentManager();
        FragmentTransaction fragment = fragmentManager.beginTransaction();//


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.changePass) {
            FragmentTransaction fragment = fragmentManager.beginTransaction();//
          // Them man hinh doi mat khau

            fragment.commit();
            toolbar.setTitle("Đổi mật khẩu");
        }if(item.getItemId()==R.id.Logout){
            Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,Man_Hinh_Login_Activity.class);
            startActivity(i);
        }if(item.getItemId()==R.id.exit){
            Toast.makeText(getBaseContext(), "Thoát thành công ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);
            finish();
        }

        return false;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.TongQuan:
                    toolbar.setTitle("Tổng quan");
                   // fragment
                    return true;
                case R.id.Bill:
                    toolbar.setTitle("Hóa đơn ");
                   // fragment
                    return true;
                case R.id.HangHoa:
                    toolbar.setTitle("Hàng hóa ");
                   // fragment
                    return true;
                case R.id.Menu:
                    toolbar.setTitle("Menu");
                    // fragment
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
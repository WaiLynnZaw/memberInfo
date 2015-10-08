package com.dhammaschool.memberinfo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.member_recycler)
    RecyclerView member_recycler;
    ArrayList<Member> memberArrayList;
    MemberAdapter memberAdapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
        getSupportActionBar().setIcon(R.drawable.dhammaschool_background_white);
        memberArrayList = new ArrayList<>();
        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        member_recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        member_recycler.setLayoutManager(layoutManager);
        memberAdapter = new MemberAdapter(memberArrayList);
        member_recycler.setAdapter(memberAdapter);
    }
    private void loadData(){
        Member m1 = new Member(1,"Ye Tay Zar Shein","yetayzar@gmail.com","09428030737","DhammaSchoolFoundataion");
        Member m2 = new Member(2,"Zaw Myo Latt","zawmyolatt@gmail.com","09428030737","124 Street, Mingalar Taung Nyunt Township,Yangon");
        Member m3 = new Member(3, "Thura Aung","thura.ucsy@gmail.com","097930845800","Zaw Ti Ka Street,Tarmwe Township, Yangon");
        Member m4 = new Member(3, "Thura Aung","thura.ucsy@gmail.com","097930845800","Zaw Ti Ka Street,Tarmwe Township, Yangon");
        Member m5 = new Member(3, "Thura Aung","thura.ucsy@gmail.com","097930845800","Zaw Ti Ka Street,Tarmwe Township, Yangon");
        Member m6 = new Member(3, "Thura Aung","thura.ucsy@gmail.com","097930845800","Zaw Ti Ka Street,Tarmwe Township, Yangon");
        memberArrayList.add(m1);
        memberArrayList.add(m2);
        memberArrayList.add(m3);
        memberArrayList.add(m4);
        memberArrayList.add(m5);
        memberArrayList.add(m6);
        memberAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

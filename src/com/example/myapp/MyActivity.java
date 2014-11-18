package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.example.myapp.adapter.TestAdapter;
import com.example.myapp.widget.ContentListView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements ContentListView.OnRefreshListener, ContentListView.OnLoadListener{
    private ContentListView listView;
    TestAdapter adapter;
    private List<String> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        list = getList();
        adapter = new TestAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);
    }

    private List<String> getList(){
        List<String> strings = new ArrayList<String>();
        for (int i=0; i<20; i++){
            strings.add("良训传媒"+i);
        }
        return strings;
    }

    private void initView(){
        listView = (ContentListView) findViewById(R.id.main_lsv);
        listView.setOnRefreshListener(this);
        listView.setOnLoadListener(this);
    }

    @Override
    public void onLoad() {
        loadData(ContentListView.REFRESH);
    }

    @Override
    public void onRefresh() {
        loadData(ContentListView.LOAD);
    }

    private void loadData(int tag){

    }
}

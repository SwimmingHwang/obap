package kr.sj.obap;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class FoodLikeFragement extends Fragment {

    private ListView foodlikelistview;

    public static FoodLikeFragement newInstance(){
        return new FoodLikeFragement();
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        //View view =  inflater.inflate(R.layout.frament_foodlike,null);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.frament_foodlike);
//
//
//
//    }
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_like, container, false );

        foodlikelistview = (ListView)view.findViewById(R.id.lv_foodlikelist);
        setFoodList();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getFoodRate();
    }


    private void setFoodList(){
        FoodListAdapter mAdapter = new FoodListAdapter();
        for(int i =0;i<10;i++){
            mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.tt),"name"+i,i);
        }
        foodlikelistview.setAdapter(mAdapter);
    }

    private void getFoodRate(){
        FoodLikeItem item;
        for(int i =0;i<10;i++){
            item = (FoodLikeItem)foodlikelistview.getAdapter().getItem(i);
            float rate = item.getRate();
            Log.e("rate",i+ "i  ="+ rate);
        }
    }
}

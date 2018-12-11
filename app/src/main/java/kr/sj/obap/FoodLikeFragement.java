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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.internal.Version;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* MypageFragment위에 생기는 음식 선호 조사 Fragment임*/

public class FoodLikeFragement extends Fragment {


    /*food list 불러오기 위한 통신 셋팅*/
    NetworkService networkService;
    private String myUrl = "http://52.78.67.243:8000";

    //ArrayList<String> foodNameList = new ArrayList<String>();
    private ListView foodlikelistview;

    public static FoodLikeFragement newInstance(){

        return new FoodLikeFragement();
    }

    /*
    public void get_foodNameList()
    {
        //GET
        Log.i("sysysy","getFoodList funcution in~");
        Call<List<Food>> foodCall = networkService.get_food();
        Log.i("sysysy1","getFoodList funcution in~");

        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                Log.i("sysysy2-1","getFoodList funcution in~");
                if(response.isSuccessful()) {
                    List<Food> foodList = response.body();
                    Log.i("sysysy2-2","getFoodList funcution in~");
                    for(Food food : foodList){
                        Log.i("sysysy3","getFoodList funcution in~");
                        foodNameList.add(food.getFood());

                    }

                    //tv_breakfast.setText(food_txt);
                } else {
                    int StatusCode = response.code();
                    Log.i("sysysy4","getFoodList funcution in~");
                    Log.i(ApplicationController.TAG, "Status Code : " + StatusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.i(ApplicationController.TAG, "Fail Message : " + t.getMessage());
            }
        });
    }

    public void get_pk_1(int pk)
    {
        //GET

        Call<Food> foodCall = networkService.get_pk_food(pk);

        foodCall.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {

                Log.i("getpkpk","getFoodList funcution in~");
                if(response.isSuccessful()) {
                    Food food = response.body();

                    String food_txt = "";
                    food_txt = food.getFood();



                    //tv_breakfast.setText(food_txt);
                    Log.i("food_txt",food_txt);
                } else {
                    int StatusCode = response.code();
                    Log.i(ApplicationController.TAG, "Status Code : " + StatusCode);
                }
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                Log.i(ApplicationController.TAG, "Fail Message : " + t.getMessage());
            }
        });
    }
    */

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_like, container, false );


        /*통신셋팅*/
        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService("52.78.67.243", 8000);
        networkService = ApplicationController.getInstance().getNetworkService();

        //get_pk_1(1);
        /*음식이름리스트 받아오기 -> mypage에서 미리 로드해둠 가져와서 써야함*/
        //get_foodNameList();

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
        /*for(int i =0;i<10;i++){

            mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.tt),LikeFragment.foodNameList.get(i),i);
        }
        */
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.tt),LikeFragment.foodNameList.get(0),0);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(1)),LikeFragment.foodNameList.get(0),0);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(2)),LikeFragment.foodNameList.get(1),1);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(3)),LikeFragment.foodNameList.get(2),2);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(4)),LikeFragment.foodNameList.get(3),3);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(5)),LikeFragment.foodNameList.get(4),4);

        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(6)),LikeFragment.foodNameList.get(5),5);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(7)),LikeFragment.foodNameList.get(6),6);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(8)),LikeFragment.foodNameList.get(7),7);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(9)),LikeFragment.foodNameList.get(8),8);
        mAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.pic(10)),LikeFragment.foodNameList.get(9),9);

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

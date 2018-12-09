package kr.sj.obap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LikeFragment extends Fragment {

    NetworkService networkService;
    private String myUrl = "http://52.78.67.243:8000";


    //@BindView(R.id.usermeal_tv1) TextView usermeal_tv1;
    @BindView(R.id.tv_breakfast) TextView tv_breakfast;
    @BindView(R.id.tv_lunch) TextView tv_lunch;
    @BindView(R.id.tv_dinner) TextView tv_dinner;
    //@BindView(R.id.tv_breakfast) TextView tv1;

    public void bt1_Click()
    {
        //GET

        Call<List<Food>> foodCall = networkService.get_food();

        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if(response.isSuccessful()) {
                    List<Food> foodList = response.body();

                    String food_txt = "";
                    for(Food food : foodList){
                        food_txt += food.getFood() + "\n";
                    }

                    tv_breakfast.setText(food_txt);
                } else {
                    int StatusCode = response.code();
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
                if(response.isSuccessful()) {
                    Food food = response.body();

                    String food_txt = "";
                    food_txt += food.getFood() + "\n";


                    tv_breakfast.setText(food_txt);
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
    public void get_pk_2(int pk)
    {
        //GET

        Call<Food> foodCall = networkService.get_pk_food(pk);

        foodCall.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.isSuccessful()) {
                    Food food = response.body();

                    String food_txt = "";
                    food_txt += food.getFood() + "\n";


                    tv_lunch.setText(food_txt);
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
    public void get_pk_3(int pk)
    {
        //GET

        Call<Food> foodCall = networkService.get_pk_food(pk);

        foodCall.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.isSuccessful()) {
                    Food food = response.body();

                    String food_txt = "";
                    food_txt += food.getFood() + "\n";


                    tv_dinner.setText(food_txt);
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

    //1 tv_breakfast
    public void usermeal_breakfast()
    {
        //GET

        Call<List<UserMeal>> usermealCall = networkService.get_usermeal();

        usermealCall.enqueue(new Callback<List<UserMeal>>() {
            @Override
            public void onResponse(Call<List<UserMeal>> call, Response<List<UserMeal>> response) {
                if(response.isSuccessful()) {
                    List<UserMeal> breakfastList = response.body();
                    String breakfast_txt = "";
                    for(UserMeal breakfast : breakfastList){
                        Food food = new Food();
                        breakfast_txt = breakfast.getBreakfast();
                        //get_pk(Integer.parseInt(tv1.getText().toString()));

                    }

                    Log.i("breakfastList",breakfast_txt);
                    //Log.i("breakfastList", tv1.getText().toString());
                    get_pk_1(Integer.parseInt(breakfast_txt));
                    tv_breakfast.setText(tv_breakfast.getText().toString());

                } else {
                    int StatusCode = response.code();
                    Log.i(ApplicationController.TAG, "Status Code : " + StatusCode);
                }
            }

            @Override
            public void onFailure(Call<List<UserMeal>> call, Throwable t) {
                Log.i(ApplicationController.TAG, "Fail Message : " + t.getMessage());
            }
        });
    }

    //2 tv_lunch
    public void usermeal_lunch()
    {
        //GET

        Call<List<UserMeal>> usermealCall = networkService.get_usermeal();

        usermealCall.enqueue(new Callback<List<UserMeal>>() {
            @Override
            public void onResponse(Call<List<UserMeal>> call, Response<List<UserMeal>> response) {
                if(response.isSuccessful()) {
                    List<UserMeal> lunchList = response.body();
                    String lunch_txt = "";
                    for(UserMeal lunch : lunchList){
                        lunch_txt += lunch.getLunch() ;
                    }
                    Log.i("lunchList", lunch_txt);
                    get_pk_2(Integer.parseInt(lunch_txt));
                    tv_lunch.setText(tv_lunch.getText().toString());
                    //tv_lunch.setText(lunch_txt);
                } else {
                    int StatusCode = response.code();
                    Log.i(ApplicationController.TAG, "Status Code : " + StatusCode);
                }
            }

            @Override
            public void onFailure(Call<List<UserMeal>> call, Throwable t) {
                Log.i(ApplicationController.TAG, "Fail Message : " + t.getMessage());
            }
        });
    }
    //tv_dinner
    public void usermeal_dinner()
    {
        //GET

        Call<List<UserMeal>> usermealCall = networkService.get_usermeal();

        usermealCall.enqueue(new Callback<List<UserMeal>>() {
            @Override
            public void onResponse(Call<List<UserMeal>> call, Response<List<UserMeal>> response) {
                if(response.isSuccessful()) {
                    List<UserMeal> dinnerList = response.body();

                    String dinner_txt = "";
                    for(UserMeal dinner : dinnerList){
                        dinner_txt += dinner.getDinner();

                    }
                    Log.i("dinnerList", dinner_txt);
                    //tv_dinner.setText(dinner_txt);
                    get_pk_3(Integer.parseInt(dinner_txt));
                    tv_dinner.setText(tv_dinner.getText().toString());
                } else {
                    int StatusCode = response.code();
                    Log.i(ApplicationController.TAG, "Status Code : " + StatusCode);
                }
            }

            @Override
            public void onFailure(Call<List<UserMeal>> call, Throwable t) {
                Log.i(ApplicationController.TAG, "Fail Message : " + t.getMessage());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_diary,null);

        //ButterKnife.bind(this);

        ImageView iv_cam=(ImageView) view.findViewById(R.id.iv_dycam);
        iv_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).captureCamera();
            }
        });
        ApplicationController application = ApplicationController.getInstance();
        //application.buildNetworkService("61fa624f.ngrok.io");
        application.buildNetworkService("52.78.67.243", 8000);
        networkService = ApplicationController.getInstance().getNetworkService();

        //usermeal_tv1=(TextView)view.findViewById(R.id.usermeal_tv1);

        //bt1_Click();
        //get_pk(1);
        //tv_breakfast=(TextView)view.findViewById(R.id.tv_breakfast);
        //get_pk(1);


        //usermeal_breakfast();

        usermeal_breakfast();
        tv_breakfast=(TextView)view.findViewById(R.id.tv_breakfast);
        usermeal_lunch();
        tv_lunch=(TextView)view.findViewById(R.id.tv_lunch);
        usermeal_dinner();
        tv_dinner=(TextView)view.findViewById(R.id.tv_dinner);

        return view;
    }

}

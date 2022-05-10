package hcmute.edu.vn.foodapp_16;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoriesAdapter;
import Adapter.FoodNearAdapter;
import Adapter.PopularFoodAdapter;
import Adapter.RecommendFoodAdapter;
import Adapter.RestaurantAdapter;

public class HomeFragment extends Fragment {

    ImageSlider imageSlider;

    private RecyclerView rcvCategories;
    private CategoriesAdapter categoriesAdapter;

    private RecyclerView rcvRecommendFood;
    private RecommendFoodAdapter recommendFoodAdapter;

    private RecyclerView rcvFoodNear;
    private FoodNearAdapter foodNearAdapter;

    private RecyclerView rcvPopularFood;
    private PopularFoodAdapter popularFoodAdapter;

    private RecyclerView rcvSuggestions;
    private RestaurantAdapter restaurantAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //SLIDER BANNER
        ////////////////////////////////////////////////////////////////////////////////////////////

        imageSlider = (ImageSlider) view.findViewById(R.id.sliderBanner);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.img_banner_01));
        slideModels.add(new SlideModel(R.drawable.img_banner_02));
        slideModels.add(new SlideModel(R.drawable.img_banner_03));
        slideModels.add(new SlideModel(R.drawable.img_banner_04));

        imageSlider.setImageList(slideModels, true);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //RECYCLER VIEW CATEGORIES
        ////////////////////////////////////////////////////////////////////////////////////////////

        rcvCategories = view.findViewById(R.id.rcv_categories);
        rcvCategories.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));

        categoriesAdapter = new CategoriesAdapter(this.getContext(), getListCategories());

        rcvCategories.setAdapter(categoriesAdapter);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //RECYCLER VIEW RECOMMEND FOOD
        ////////////////////////////////////////////////////////////////////////////////////////////

        rcvRecommendFood = view.findViewById(R.id.rcv_recommend_food);
        rcvRecommendFood.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));

        recommendFoodAdapter = new RecommendFoodAdapter(getListRecommendFood());

        rcvRecommendFood.setAdapter(recommendFoodAdapter);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //RECYCLER VIEW FOOD NEAR
        ////////////////////////////////////////////////////////////////////////////////////////////

        rcvFoodNear = view.findViewById(R.id.rcv_food_near);
        rcvFoodNear.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));

        foodNearAdapter = new FoodNearAdapter(getListFoodNear());

        rcvFoodNear.setAdapter(foodNearAdapter);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //RECYCLER VIEW POPULAR FOOD
        ////////////////////////////////////////////////////////////////////////////////////////////

        rcvPopularFood = view.findViewById(R.id.rcv_popular_food);
        rcvPopularFood.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));

        popularFoodAdapter = new PopularFoodAdapter(getListPopularFood());

        rcvPopularFood.setAdapter(popularFoodAdapter);

        ////////////////////////////////////////////////////////////////////////////////////////////

        //RECYCLER VIEW SUGGESTIONS FOOD
        ////////////////////////////////////////////////////////////////////////////////////////////

        rcvSuggestions = view.findViewById(R.id.rcv_food_suggestions);
        rcvSuggestions.setLayoutManager(new LinearLayoutManager(this.getContext()));

        restaurantAdapter = new RestaurantAdapter(this.getContext(),getListSuggestions());

        rcvSuggestions.setAdapter(restaurantAdapter);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Click Category


        return view;
    }



    //RECYCLER VIEW - LIST CATEGORIES
    private List<Categories> getListCategories() {
        List<Categories> list = new ArrayList<>();

        list.add(new Categories(R.drawable.img_rice, "Rice"));
        list.add(new Categories(R.drawable.img_noodles, "Noodles"));
        list.add(new Categories(R.drawable.img_pastry, "Pastry"));
        list.add(new Categories(R.drawable.img_fastfood, "FastFood"));
        list.add(new Categories(R.drawable.img_dessert, "Dessert"));
        list.add(new Categories(R.drawable.img_milktea, "MilkTea"));
        list.add(new Categories(R.drawable.img_healthy, "Healthy"));
        list.add(new Categories(R.drawable.img_hotpot, "HotPot"));
        list.add(new Categories(R.drawable.img_speciality, "Speciality"));

        return list;
    }

    //RECYCLER VIEW - LIST RECOMMEND FOOD
    private List<RecommendFood> getListRecommendFood() {
        List<RecommendFood> list = new ArrayList<>();

        list.add(new RecommendFood(R.drawable.recommend_food_01, "$12.00", "Crispy Fry Burger"));
        list.add(new RecommendFood(R.drawable.recommend_food_02, "$12.00", "Crispy Fry Burger"));
        list.add(new RecommendFood(R.drawable.recommend_food_03, "$12.00", "Crispy Fry Burger"));
        list.add(new RecommendFood(R.drawable.recommend_food_04, "$12.00", "Crispy Fry Burger"));
        list.add(new RecommendFood(R.drawable.recommend_food_05, "$12.00", "Crispy Fry Burger"));
        list.add(new RecommendFood(R.drawable.recommend_food_05, "$12.00", "Crispy Fry Burger"));

        return list;
    }

    //RECYCLER VIEW - LIST FOOD NEAR
    private List<FoodNear> getListFoodNear() {
        List<FoodNear> list = new ArrayList<>();

        list.add(new FoodNear(R.drawable.recommend_food_03, "$12.00", "Crispy Fry Burger"));
        list.add(new FoodNear(R.drawable.recommend_food_04, "$12.00", "Crispy Fry Burger"));
        list.add(new FoodNear(R.drawable.recommend_food_05, "$12.00", "Crispy Fry Burger"));
        list.add(new FoodNear(R.drawable.recommend_food_01, "$12.00", "Crispy Fry Burger"));
        list.add(new FoodNear(R.drawable.recommend_food_02, "$12.00", "Crispy Fry Burger"));

        return list;
    }

    //RECYCLER VIEW - LIST POPULAR FOOD
    private List<PopularFood> getListPopularFood() {
        List<PopularFood> list = new ArrayList<>();

        list.add(new PopularFood(R.drawable.popular_banner_03, "Most Loved Fried Chicken", "$10.00", "4.1 (100+)"));
        list.add(new PopularFood(R.drawable.popular_banner_04, "Most Loved Fried Chicken", "$10.00", "4.1 (100+)"));
        list.add(new PopularFood(R.drawable.popular_banner_05, "Most Loved Fried Chicken", "$10.00", "4.1 (100+)"));
        list.add(new PopularFood(R.drawable.popular_banner_01, "Most Loved Fried Chicken", "$10.00", "4.1 (100+)"));
        list.add(new PopularFood(R.drawable.popular_banner_02, "Most Loved Fried Chicken", "$10.00", "4.1 (100+)"));


        return list;
    }

    //RECYCLER VIEW - LIST SUGGESTIONS FOOD
    private List<Restaurant> getListSuggestions() {
        List<Restaurant> list = new ArrayList<>();

        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre - Hoàng Diệu 2", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_04, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_01, "Bún Đậu Mắm Tôm Mẹt Tre - Hoàng Diệu 2", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_03, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre - Hoàng Diệu 2", "Bún đậu tá lả", "4.1 (100+)"));

        return list;
    }





}
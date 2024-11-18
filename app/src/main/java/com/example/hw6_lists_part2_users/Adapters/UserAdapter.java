package com.example.hw6_lists_part2_users.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw6_lists_part2_users.Models.UserModel;
import com.example.hw6_lists_part2_users.R;
import com.example.hw6_lists_part2_users.Services.AgeService;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<UserModel> userList;

    public UserAdapter(List<UserModel> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel user = userList.get(position);
        String fullName = user.getFirstName() + " " + user.getLastName();
        String countryCity = user.getCityName() + ", " + user.getCountryName();
        String yearsOld = AgeService.getAgeByLongUTC(user.getAgeUTC()) + " years old";

        holder.userNameTextView.setText(fullName);
        holder.userCountryCityTextView.setText(countryCity);
        holder.userAgeTextView.setText(yearsOld);
        holder.userImageView.setImageResource(user.getProfileResourceId());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        public ImageView userImageView;
        public TextView userNameTextView;
        public TextView userCountryCityTextView;
        public TextView userAgeTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.user_image);
            userNameTextView = itemView.findViewById(R.id.user_full_name);
            userCountryCityTextView = itemView.findViewById(R.id.user_country_city);
            userAgeTextView = itemView.findViewById(R.id.user_age);
        }
    }
}

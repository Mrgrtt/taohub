package com.github.mrgrtt.taohub.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mrgrtt.taohub.R;
import com.github.mrgrtt.taohub.activity.HistoryActivity;
import com.github.mrgrtt.taohub.activity.LoginActivity;
import com.github.mrgrtt.taohub.util.AuthUtil;

public class MineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        TextView username = view.findViewById(R.id.username);
        username.setText(AuthUtil.getCurrentUsername(getContext()));

        Button historyButton = view.findViewById(R.id.history);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MineFragment.this.getContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        Button logoutButton = view.findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUtil.removeLoginState(getContext());
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;
    }

}

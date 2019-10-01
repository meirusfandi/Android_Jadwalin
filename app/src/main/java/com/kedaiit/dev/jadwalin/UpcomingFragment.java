package com.kedaiit.dev.jadwalin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class UpcomingFragment extends Fragment {

    private static final String JSON_URL = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328";
    ListView listView;
    private List<UpcomingItem> upcomingItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_upcoming,container,false);

        listView =  view.findViewById(R.id.listView);

        return view;
    }

    private void loadUpcoming(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray upcomingArray = obj.getJSONArray("result");

                            for (int i = 0; i < upcomingArray.length(); i++) {

                                JSONObject upcomingObject = upcomingArray.getJSONObject(i);


                                UpcomingItem upcomingItem = new UpcomingItem(upcomingObject.getString("idEvent"),
                                        upcomingObject.getString("strEvent"),
                                        upcomingObject.getString("dateEvent"));

                                upcomingItemList.add(upcomingItem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(upcomingItemList, getContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        requestQueue.add(stringRequest);
    }
}

package com.mohammad.android.soccerTips;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Fixture> fixtureList;

    RecyclerViewAdapter(List<Fixture> fixtureList, Context context) {
        this.fixtureList = fixtureList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Fixture fixture = fixtureList.get(position);
        String shortStatus = fixture.getStatusShort();
        if (shortStatus.equals("CANC") || shortStatus.equals("PST") || shortStatus.equals("NS")) {
            viewHolder.home_team_name.setText(fixture.getHome_team_name());
            viewHolder.away_team_name.setText(fixture.getAway_team_name());
            viewHolder.goalsHomeTeam.setText("");
            viewHolder.goalsAwayTeam.setText("");
            viewHolder.elapsed.setText(fixture.getStatus());
            System.out.println("HERE1 " + fixture.getStatusShort() + " / " + shortStatus);
        } else if (shortStatus.equals("FT")) {
            viewHolder.home_team_name.setText(fixture.getHome_team_name());
            viewHolder.away_team_name.setText(fixture.getAway_team_name());
            viewHolder.goalsHomeTeam.setText(fixture.getGoalsHomeTeam());
            viewHolder.goalsAwayTeam.setText(fixture.getGoalsAwayTeam());
            viewHolder.elapsed.setText(fixture.getStatus());
        } else {
            viewHolder.home_team_name.setText(fixture.getHome_team_name());
            viewHolder.away_team_name.setText(fixture.getAway_team_name());
            viewHolder.goalsHomeTeam.setText(fixture.getGoalsHomeTeam());
            viewHolder.goalsAwayTeam.setText(fixture.getGoalsAwayTeam());
            viewHolder.elapsed.setText(fixture.getElapsed());
            System.out.println("HERE2 " + fixture.getStatusShort() + " / " + shortStatus);
        }


//        viewHolder.resultListView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //will do later
////                String matchId = model.getId();
////                String date = model.getDate();
//
//                String fixture_id = Integer.toString(fixture.getFixture_id());
//
//                Intent intent = new Intent(context, MatchDetailActivity.class);
//
//
//                intent.putExtra("match_id", fixture_id);
////                intent.putExtra("date", date);
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView home_team_name, away_team_name, goalsHomeTeam, goalsAwayTeam, elapsed;
        View resultListView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_team_name = itemView.findViewById(R.id.home_team_name);
            away_team_name = itemView.findViewById(R.id.away_team_name);
            goalsHomeTeam = itemView.findViewById(R.id.goalsHomeTeam);
            goalsAwayTeam = itemView.findViewById(R.id.goalsAwayTeam);
            elapsed = itemView.findViewById(R.id.elapsed);

            resultListView = itemView.findViewById(R.id.resultListView);
        }
    }
}

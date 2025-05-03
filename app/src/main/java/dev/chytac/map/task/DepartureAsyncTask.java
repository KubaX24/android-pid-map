package dev.chytac.map.task;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import dev.chytac.map.R;
import dev.chytac.map.entities.LineEntity;
import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.servicies.PIDService;

public class DepartureAsyncTask extends AsyncTask<Void, Void, List<LineEntity>> {

    private final StationEntity station;
    private final LinearLayout linearLayout;
    private final Context context;

    private final PIDService pidService;

    public DepartureAsyncTask(StationEntity station, LinearLayout linearLayout, Context context) {
        this.station = station;
        this.linearLayout = linearLayout;
        this.context = context;

        this.pidService = new PIDService();
    }

    @Override
    protected List<LineEntity> doInBackground(Void... voids) {
        try {
            return pidService.getLines(station.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(List<LineEntity> lines) {
        for (LineEntity line : lines) {
            View lineView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.mhd_layout, null);
            TextView lineName = lineView.findViewById(R.id.line_id);
            lineName.setText(line.getName());

            Drawable backName = lineName.getBackground();

            switch (line.getType()) {
                case "bus":
                    backName.setTint(Color.rgb(0, 200, 200));
                    break;
                case "tram":
                    backName.setTint(Color.rgb(209, 77, 77));
                    break;
                case "train":
                    backName.setTint(Color.rgb(119, 130, 237));
                    break;
                case "metroA":
                    backName.setTint(Color.rgb(119, 237, 130));
                    break;
                case "metroB":
                    backName.setTint(Color.rgb(240, 70, 85));
                    break;
                case "metroC":
                    backName.setTint(Color.rgb(237, 119, 130));
                    break;
                default:
                    backName.setTint(Color.rgb(200, 200, 200));
            }

            lineName.setBackground(backName);

            TextView finalStation = lineView.findViewById(R.id.last_stop);
            finalStation.setText(line.getFinalStation());

            TextView departureTime = lineView.findViewById(R.id.time_leaving);
            departureTime.setText(line.getDeparture().format(new DateTimeFormatterBuilder().appendPattern("HH:mm").toFormatter()));

            TextView delay = lineView.findViewById(R.id.line_delay);
            if (line.getDelay() == 0) {
                delay.setVisibility(View.GONE);
            } else {
                delay.setText("+" + line.getDelay());
            }

            linearLayout.addView(lineView);
        }
    }
}

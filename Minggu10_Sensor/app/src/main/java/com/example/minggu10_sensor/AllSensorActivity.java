package com.example.minggu10_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AllSensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sensor);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        ListView listView = findViewById(R.id.lv_sensors);
        listView.setAdapter(new MySensorAdapter(this, R.layout.item_sensor, sensorList));
    }

    class MySensorAdapter extends ArrayAdapter<Sensor> {

        private int txtResouceID;

        public MySensorAdapter( Context context, int resource, List<Sensor> objects) {
            super(context, resource, objects);
            this.txtResouceID = resource;
        }

        public class ViewHolder {
            private TextView itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            int idSensor = position + 1;

            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.getContext())
                        .inflate(txtResouceID, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.itemView = convertView.findViewById(R.id.txt_item_sensor);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Sensor item = getItem(position);

            if (item != null) {
                viewHolder.itemView.setText(idSensor+". Name : "+item.getName()+"\nInt Type : "+item.getType()
                        +"\nPower : "+item.getPower()+"mAh\nMax range : "+item.getMaximumRange());
            }

            return convertView;
        }
    }
}

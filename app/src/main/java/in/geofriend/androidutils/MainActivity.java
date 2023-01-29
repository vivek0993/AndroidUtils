package in.geofriend.androidutils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.geofriend.androidutils.camera.CameraActivity;
import in.geofriend.androidutils.fileutility.FileUtilityActivity;
import in.geofriend.camerahelper.CameraHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutCompat listContainer = findViewById(R.id.listContainer);
        for(String item : Constants.DEMOS) {
            ViewGroup layout = (ViewGroup) getLayoutInflater().inflate(R.layout.demo_list_item, null);
            TextView textView = layout.findViewById(R.id.demo_name);
            textView.setText(item);
            listContainer.addView(layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked(item);
                }
            });
        }
    }

    private void onItemClicked(String item) {
        Intent intent = null;
        switch (item) {
            case Constants.FILE_UTILITY:
                intent = new Intent(this, FileUtilityActivity.class);
                break;
            case Constants.CAMERA_HELPER:
                intent = new Intent(this, CameraActivity.class);
                break;
        }
        startActivity(intent);
    }
}
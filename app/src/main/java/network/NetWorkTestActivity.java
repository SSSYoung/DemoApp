package network;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoapp.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

public class NetWorkTestActivity extends AppCompatActivity {
    private static final String TAG = "NetWorkTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work_test);
        TextView loadGson = findViewById(R.id.btn_load_gson);
        loadGson.setOnClickListener(v -> {
            loadGson();
        });
        TextView loadPic = findViewById(R.id.btn_load_pic);
        loadPic.setOnClickListener(v -> {
            loadPic();
        });
        TextView post = findViewById(R.id.btn_post);
        loadPic.setOnClickListener(v -> {
            postComment();
        });
    }

    private void loadGson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.sunofbeaches.com/shop/discovery/categories");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                    connection.setRequestProperty("Accept", "*/*");
                    connection.connect();

                    int responseCode = connection.getResponseCode();

                    if (responseCode == 200) {
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();

                        for (Map.Entry<String, List<String>> entry : entries) {
                            Log.d(TAG, entry.getKey() + "=======" + entry.getValue());
                        }
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String l = bufferedReader.readLine();
                        Log.d(TAG, "loadGson: " + l);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void loadPic() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://img.alicdn.com/tfscom/i1/850484481/O1CN01B5dq8Z1iyLGULHvUL_!!850484481.jpg");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                    connection.setRequestProperty("Accept", "*/*");
                    connection.connect();

                    int responseCode = connection.getResponseCode();

                    if (responseCode == 200) {
                        InputStream inputStream = connection.getInputStream();
                        //final Bitmap bitmap = BitmapFactory.decodeByteArray(inputStream);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void postComment() {

    }

    private void updateUi(){
        new Gson();
    }
}
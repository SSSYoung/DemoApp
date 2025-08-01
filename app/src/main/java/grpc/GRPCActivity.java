package grpc;

import androidx.appcompat.app.AppCompatActivity;

public class GRPCActivity extends AppCompatActivity {
    // private Button sendButton;
    // private EditText hostEdit;
    // private EditText portEdit;
    // private EditText messageEdit;
    // private TextView resultText;
    // @Override
    // protected void onCreate(Bundle savedInstanceState) {
    //     super.onCreate(savedInstanceState);
    //     setContentView(R.layout.activity_grpcactivity);
    //     sendButton = (Button) findViewById(R.id.send_button);
    //     sendButton.setOnClickListener(
    //             new View.OnClickListener() {
    //                 @Override
    //                 public void onClick(View v) {
    //                     sendMessage(v);
    //                 }
    //             });
    //     hostEdit = (EditText) findViewById(R.id.host_edit_text);
    //     portEdit = (EditText) findViewById(R.id.port_edit_text);
    //     messageEdit = (EditText) findViewById(R.id.message_edit_text);
    //     resultText = (TextView) findViewById(R.id.grpc_response_text);
    //     resultText.setMovementMethod(new ScrollingMovementMethod());
    // }
    //
    // public void sendMessage(View view) {
    //     ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
    //             .hideSoftInputFromWindow(hostEdit.getWindowToken(), 0);
    //     sendButton.setEnabled(false);
    //     resultText.setText("");
    //     new GrpcTask(this)
    //             .execute(
    //                     hostEdit.getText().toString(),
    //                     messageEdit.getText().toString(),
    //                     portEdit.getText().toString());
    // }
    //
    // private static class GrpcTask extends AsyncTask<String, Void, String> {
    //     private final WeakReference<Activity> activityReference;
    //     private ManagedChannel channel;
    //
    //     private GrpcTask(Activity activity) {
    //         this.activityReference = new WeakReference<Activity>(activity);
    //     }
    //
    //     @Override
    //     protected String doInBackground(String... params) {
    //         String host = "localhost";
    //         String message = params[1];
    //         String portStr = "8080";
    //         Log.e("yangshuang", "doInBackground: host: " + host + "  message: " + message + "   portStr: " + portStr );
    //         int port = TextUtils.isEmpty(portStr) ? 0 : Integer.valueOf(portStr);
    //         try {
    //             channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    //             GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
    //             HelloRequest request = HelloRequest.newBuilder().setName(message).build();
    //             HelloReply reply = stub.sayHello(request);
    //             return reply.getMessage();
    //         } catch (Exception e) {
    //             StringWriter sw = new StringWriter();
    //             PrintWriter pw = new PrintWriter(sw);
    //             e.printStackTrace(pw);
    //             pw.flush();
    //             return String.format("Failed... : %n%s", sw);
    //         }
    //     }
    //
    //     @Override
    //     protected void onPostExecute(String result) {
    //         Log.e("yangshuang", "onPostExecute: " + result);
    //         try {
    //             channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    //         } catch (InterruptedException e) {
    //             Thread.currentThread().interrupt();
    //         }
    //         Activity activity = activityReference.get();
    //         if (activity == null) {
    //             return;
    //         }
    //         TextView resultText = (TextView) activity.findViewById(R.id.grpc_response_text);
    //         Button sendButton = (Button) activity.findViewById(R.id.send_button);
    //         resultText.setText(result);
    //         sendButton.setEnabled(true);
    //     }
    // }
}
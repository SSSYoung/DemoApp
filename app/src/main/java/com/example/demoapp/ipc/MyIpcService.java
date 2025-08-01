package com.example.demoapp.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.demoapp.IMyAidlTestInterface;

public class MyIpcService extends Service {
    public IMyAidlTestInterface.Stub binder = new IMyAidlTestInterface.Stub(){

        @Override
        public String getName() throws RemoteException {
            return "我是服务端数据";
        }
    };
    public MyIpcService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }
}
package contact

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.demoapp.databinding.ActivityContactBinding
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission.READ_CALL_LOG
import com.hjq.permissions.Permission.READ_PHONE_STATE
import com.hjq.permissions.XXPermissions

class ContactActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "yangshuang"
    }

    private val permissions = arrayOf(
        Manifest.permission.READ_CONTACTS
    )

    private lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(
            TAG,
            "onCreate: "
        )
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.button2.setOnClickListener {
            getContact()
        }
        binding.button3.setOnClickListener {
            getSimContact()
        }
        binding.button4.setOnClickListener {
            getHistory()
        }
        binding.button1.setOnClickListener {
//            XXPermissions.with(this)
//                .permission(Permission.RECORD_AUDIO)
//                .request(object : OnPermissionCallback {
//                    override fun onGranted(
//                        permissions: MutableList<String>,
//                        allGranted: Boolean
//                    ) {
//                        TODO(reason = "Not yet implemented")
//                    }
//
//                    override fun onDenied(
//                        permissions: MutableList<String>,
//                        doNotAskAgain: Boolean
//                    ) {
//                        super.onDenied(
//                            permissions,
//                            doNotAskAgain
//                        )
//                        XXPermissions.startPermissionActivity(this,)
//                    }
//                })
//            XXPermissions
//                .with(this)
//                .permission(Permission.RECORD_AUDIO)
//                .request(object : OnPermission {
//                    override fun hasPermission(
//                        granted: MutableList<String>?,
//                        isAll: Boolean
//                    ) {
//                        Log.d(
//                            "yangshuang",
//                            "hasPermission:$isAll,${granted?.size} "
//                        )
//                        granted?.forEach {
//                            Log.d(
//                                "yangshuang",
//                                "hasPermission: $it"
//                            )
//                        }
//                    }
//
//                    override fun noPermission(
//                        denied: MutableList<String>?,
//                        quick: Boolean
//                    ) {
//                        denied?.forEach {
//                            Log.d(
//                                "yangshuang",
//                                "noPermission: $it"
//                            )
//                            Log.d(
//                                "yangshuang",
//                                "noPermission:$quick,${denied?.size} "
//                            )
//                        }
//
//                        if (quick) {
//                            XXPermissions.startPer()
//                        }
//                    }
//
//                })
        }
    }

    @SuppressLint("LogNotTimber")
    private fun getHistory() {
        requestPermission(arrayOf(READ_CALL_LOG,
            READ_PHONE_STATE)
        ) {
            val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            // 获取主副卡的 IMSI
            //val primaryImsi = telephonyManager.getSubscriberId(0)
            //val secondaryImsi = telephonyManager.getSubscriberId(1)

            val projection = arrayOf(
                CallLog.Calls.DATE,
                CallLog.Calls.NUMBER,
                CallLog.Calls.TYPE,
                CallLog.Calls.DURATION
            )

            val sortOrder = "${CallLog.Calls.DATE} DESC"

            val cursor: Cursor? = contentResolver.query(
                CallLog.Calls.CONTENT_URI,
                projection,
                null,
                null,
                sortOrder
            )

            if (cursor != null && cursor.moveToFirst()) {
                while (cursor.moveToNext()) {
                    val callDate = cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE))
                    val phoneNumber = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER))
                    val callType = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.TYPE))
                    val callDuration = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.DURATION))

                    val callTypeStr = when (callType) {
                        CallLog.Calls.INCOMING_TYPE -> "Incoming"
                        CallLog.Calls.OUTGOING_TYPE -> "Outgoing"
                        CallLog.Calls.MISSED_TYPE -> "Missed"
                        else -> "Unknown"
                    }

                    val imsi = cursor.getString(cursor.getColumnIndex("imsi_column_name")) // 请替换成真实的 IMSI 列名
                    Log.d(
                        "CallLogUtil",
                        "imsi: $imsi, Primary SIM Card - Date: $callDate, Number: $phoneNumber, Type: $callTypeStr, " +
                                "Duration: $callDuration seconds"
                    )
//                    // 判断是主副卡的通话记录
//                    if (imsi == primaryImsi) {
//                        Log.d(
//                            "CallLogUtil",
//                            "Primary SIM Card - Date: $callDate, Number: $phoneNumber, Type: $callTypeStr, Duration: $callDuration seconds"
//                        )
//                    } else if (imsi == secondaryImsi) {
//                        Log.d(
//                            "CallLogUtil",
//                            "Secondary SIM Card - Date: $callDate, Number: $phoneNumber, Type: $callTypeStr, Duration: $callDuration seconds"
//                        )
//                    }
                }
                cursor.close()
            }
        }

    }

    private fun getContact() {
        XXPermissions.with(this)
            .permission(permissions)
            .request(object : OnPermissionCallback {
                override fun onGranted(
                    permissions: MutableList<String>,
                    allGranted: Boolean
                ) {
                    if (allGranted) {
                        getPhoneContact()
                    }
                }

                override fun onDenied(
                    permissions: MutableList<String>,
                    doNotAskAgain: Boolean
                ) {
                    if (doNotAskAgain) {
                        XXPermissions.startPermissionActivity(
                            this@ContactActivity,
                            permissions
                        )
                    } else {
                        Toast.makeText(
                            this@ContactActivity,
                            "message",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            })
    }

    private fun getPhoneContact() {
        val contactsList = mutableListOf<String>()

        // Use ContentResolver to query contacts
        val contentResolver: ContentResolver = contentResolver
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        if (cursor != null && cursor.moveToFirst()) {
            val displayNameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            Log.d(
                TAG,
                "getPhoneContact: $displayNameIndex"
            )
            if (displayNameIndex != -1) {
                do {
                    val contactName = cursor.getString(displayNameIndex)
                    Log.d(
                        TAG,
                        "getContact: $contactName"
                    )
                    contactsList.add(contactName ?: "Unknown")
                } while (cursor.moveToNext())
            } else {
                // 处理未找到显示名称的情况
                Log.e("ContactsUtil", "Display name index not found")
            }

            cursor.close()
        }
    }

    fun requestPermission(
        permissions: Array<String>,
        onAllGranted: () -> Unit
    ) {
        XXPermissions.with(this)
            .permission(permissions)
            .request { _, allGranted ->
                if (allGranted) {
                    onAllGranted.invoke()
                }
            }
    }

    private fun getSimContact() {

        XXPermissions.with(this)
            .permission(permissions)
            .request(object : OnPermissionCallback {
                override fun onGranted(
                    permissions: MutableList<String>,
                    allGranted: Boolean
                ) {
                    if (allGranted) {
                        val contactsList = mutableListOf<String>()
                        val uri: Uri = Uri.parse("content://icc/adn")
                        // Use ContentResolver to query contacts
                        val contentResolver: ContentResolver = contentResolver
                        val cursor = contentResolver.query(
                            uri,
                            null,
                            null,
                            null,
                            null
                        )

                        if (cursor != null && cursor.moveToFirst()) {
                            Log.d(
                                TAG,
                                " "
                            )
                            val displayNameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

                            if (displayNameIndex != -1) {
                                do {
                                    val contactName = cursor.getString(displayNameIndex)
                                    Log.d(
                                        TAG,
                                        "getSimContact"
                                    )
                                    contactsList.add(contactName ?: "Unknown")
                                } while (cursor.moveToNext())
                            } else {
                                // 处理未找到显示名称的情况
                                Log.e("ContactsUtil", "Display name index not found")
                            }

                            cursor.close()
                        }
                    }
                }

                override fun onDenied(
                    permissions: MutableList<String>,
                    doNotAskAgain: Boolean
                ) {
                    if (doNotAskAgain) {
                        XXPermissions.startPermissionActivity(
                            this@ContactActivity,
                            permissions
                        )
                    } else {
                        Toast.makeText(
                            this@ContactActivity,
                            "message",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            })


    }
}
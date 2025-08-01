package bean

import android.os.Parcel
import android.os.Parcelable

data class NumBean(val num1: Int, val num2: Int, val extra: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    companion object CREATOR : Parcelable.Creator<NumBean> {
        override fun createFromParcel(parcel: Parcel): NumBean {
            return NumBean(parcel)
        }

        override fun newArray(size: Int): Array<NumBean?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(
        dest: Parcel,
        flags: Int,
    ) {

    }
}

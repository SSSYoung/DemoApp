package mvvm.player

import mvvm.player.domain.Music

class PlayerModel {
    fun getMusicById(id: String): Music {
        return Music(
            "歌曲名： $id",
            "https://i.loli.net/2020/05/02/cDYxJdkVjnMetif.png?x-oss-process=image/resize,h_118",
            "https://www.sunofbeach.net"

        )
    }
}
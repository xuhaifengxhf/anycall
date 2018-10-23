package com.anycall.parent.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.util.Map;

public class StringUtil {
    /**
     * 字符串转json
     *
     * @param str_json
     * @return
     */
    public static Map<String, Object> json2map(String str_json) {
        Map<String, Object> res = null;
        try {
            Gson gson = new Gson();
            res = gson.fromJson(str_json, new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取mp3时长
     *
     * @param position
     * @return
     */
    public static int getDuration(String position) {

        int length = 0;
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(new File(position));
            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

            // 单位为秒
            length = audioHeader.getTrackLength();

            return length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(getDuration("http://drp2.oss-cn-shanghai.aliyuncs.com/mdcszh/1537946777354-0.mp3"));
    }
}

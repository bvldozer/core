package com.cartenz.core.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by pratama on 2/27/2018.
 */

public class Dictionary {
    public static String CORE_DICTIONARY = "CORE_DICTIONARY1992";

    public static HashMap<String, String> set() {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("99020302", "username");
        dictionary.put("99020402", "password");
        dictionary.put("92000001", "status_data");
        dictionary.put("92000002", "is_active");
        dictionary.put("92000003", "alasan_dihapus");
        dictionary.put("92000004", "created_by");
        dictionary.put("92000005", "updated_by");
        dictionary.put("92000006", "verified_by");
        dictionary.put("92000007", "created_date");
        dictionary.put("92000008", "updated_date");
        dictionary.put("92000009", "verified_date");
        dictionary.put("92000010", "verified_status");
        dictionary.put("92000011", "latitude");
        dictionary.put("92000012", "longitude");
        dictionary.put("92000013", "alamat");
        dictionary.put("92000014", "telephone1");
        dictionary.put("92000015", "telephone2");
        dictionary.put("92000016", "source_data");
        dictionary.put("92000017", "foto");
        dictionary.put("92000101", "kd_provinsi");
        dictionary.put("92000102", "kd_dati2");
        dictionary.put("92000103", "kd_kecamatan");
        dictionary.put("92000104", "kd_kelurahan");
        dictionary.put("92000105", "kd_blok");
        dictionary.put("92000106", "no_urut");
        dictionary.put("92000107", "kd_jns_op");
        dictionary.put("92000108", "no_bng");
        dictionary.put("92000109", "no_bumi");
        dictionary.put("92000110", "nop");
        dictionary.put("92000111", "kd_jpb");
        dictionary.put("92000112", "nop_lama");
        dictionary.put("92000113", "kd_znt");
        dictionary.put("92000201", "provinsi_id");
        dictionary.put("92000202", "dati2_id");
        dictionary.put("92000203", "kecamatan_id");
        dictionary.put("92000204", "kelurahan_id");
        dictionary.put("92000205", "blok_id");
        dictionary.put("92000206", "meta_data");
        dictionary.put("92000207", "shp_data");
        dictionary.put("92000208", "shp_id");
        return dictionary;
    }

    public static void set(Context context) {
        Gson gson = new Gson();
        String jsonFromMap = gson.toJson(set());
        PrefHelper.saveToPref(context, CORE_DICTIONARY, jsonFromMap);

    }

    public static String getValueByKey(Context context, String key) {
        HashMap<String, String> dictionary = getPref(context);
        return dictionary.get(key);
    }

    public static String getValueByKey(List<String> keys) {
        String result = null;
        if (keys != null) {
            HashMap<String, String> dictionary = Dictionary.set();
            for (int i = 0; i < keys.size(); i++) {
                if (TextUtils.isEmpty(result)) {
                    result = dictionary.get(keys.get(i));
                } else {
                    result += ", " + dictionary.get(keys.get(i));
                }

            }
        }
        return result;
    }

    public static HashMap<String, String> getPref(Context context) {
        HashMap<String, String> dictionary = new HashMap<>();
        String jsonString = PrefHelper.getPref(context, CORE_DICTIONARY);
        dictionary = new Gson().fromJson(
                jsonString, new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        if (dictionary == null) {
            return new HashMap<>();
        }

        return dictionary;
    }

    public static String getKeyByValue(Context context, String value) {
        HashMap<String, String> dictionary = getPref(context);
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}

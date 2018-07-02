package com.cartenz.helper;

import android.content.Context;
import android.text.TextUtils;

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
        dictionary.put("-1", "error");
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
        dictionary.put("92010001", "no_formulir_spop");
        dictionary.put("92010002", "no_persil");
        dictionary.put("92010003", "total_luas_bumi");
        dictionary.put("92010004", "total_luas_bng");
        dictionary.put("92010005", "njop_bumi");
        dictionary.put("92010006", "njop_bng");
        dictionary.put("92010007", "kd_status_cabang");
        dictionary.put("92010008", "kd_status_wp");
        dictionary.put("92010009", "jns_transaksi_op");
        dictionary.put("92010010", "foto_op");
        dictionary.put("92010101", "jalan_op");
        dictionary.put("92010102", "blok_kav_no_op");
        dictionary.put("92010103", "rt_op");
        dictionary.put("92010104", "rw_op");
        dictionary.put("92010105", "no_telp_op");
        dictionary.put("92010201", "status_peta_op");
        dictionary.put("92010202", "status_spop");
        dictionary.put("92010203", "status_mutasi");
        dictionary.put("92010204", "status_verifikasi");
        dictionary.put("92010301", "no_urut_bersama");
        dictionary.put("92010302", "kd_jns_op_bersama");
        dictionary.put("92010401", "kd_jns_hak");
        dictionary.put("92010402", "no_sertifikat");
        dictionary.put("92010403", "tgl_sertifikat");
        dictionary.put("92010501", "luas_bumi");
        dictionary.put("92010502", "jns_bumi");
        dictionary.put("92010503", "nilai_sistem_bumi");
        dictionary.put("92010601", "no_formulir_lspop");
        dictionary.put("92010602", "thn_dibangun_bng");
        dictionary.put("92010603", "thn_renovasi_bng");
        dictionary.put("92010604", "luas_bng");
        dictionary.put("92010605", "jml_lantai_bng");
        dictionary.put("92010606", "kondisi_bng");
        dictionary.put("92010607", "jns_konstruksi_bng");
        dictionary.put("92010608", "jns_atap_bng");
        dictionary.put("92010609", "kd_dinding");
        dictionary.put("92010610", "kd_lantai");
        dictionary.put("92010611", "kd_langit_langit");
        dictionary.put("92010612", "nilai_sistem_bng");
        dictionary.put("92010613", "nilai_individu_bng");
        dictionary.put("92010614", "jns_transaksi_bng");
        dictionary.put("92010615", "tgl_kunjungan_kembali");
        dictionary.put("92010616", "jml_lantai_basement");
        dictionary.put("92010617", "luas_bng_lain");
        dictionary.put("92010618", "luas_basement");
        dictionary.put("92010619", "nilai_sistem_bng_sippt");
        dictionary.put("92010620", "daya_listrik");
        dictionary.put("92010621", "foto_op_bangunan");
        dictionary.put("92010701", "kls_jpb2");
        dictionary.put("92010702", "type_konstruksi");
        dictionary.put("92010703", "ting_kolom_jpb3");
        dictionary.put("92010704", "lbr_bent_jpb3");
        dictionary.put("92010705", "luas_mezzanine_jpb3");
        dictionary.put("92010706", "keliling_dinding_jpb3");
        dictionary.put("92010707", "daya_dukung_lantai_jpb3");
        dictionary.put("92010708", "kls_jpb4");
        dictionary.put("92010709", "kls_jpb5");
        dictionary.put("92010710", "luas_jpb5_dg_ac");
        dictionary.put("92010711", "luas_rng_lain_jpb5_dg_ac");
        dictionary.put("92010712", "kls_jpb6");
        dictionary.put("92010713", "jns_jpb7");
        dictionary.put("92010714", "bintang_jpb7");
        dictionary.put("92010715", "jml_kmr_jpb7");
        dictionary.put("92010716", "luas_kmr_jpb7_dg_ac");
        dictionary.put("92010717", "luas_kmr_lain_dg_ac");
        dictionary.put("92010718", "ting_kolom_jpb8");
        dictionary.put("92010719", "lbr_bent_jpb8");
        dictionary.put("92010720", "luas_mezzanine_jpb8");
        dictionary.put("92010721", "keliling_dinding_jpb8");
        dictionary.put("92010722", "daya_dukung_lantai_jpb8");
        dictionary.put("92010723", "kls_jpb9");
        dictionary.put("92010724", "type_jpb12");
        dictionary.put("92010725", "kls_jpb13");
        dictionary.put("92010726", "jml_jpb13");
        dictionary.put("92010727", "luas_jpb13_dg_ac");
        dictionary.put("92010728", "luas_jpb13_lain_dg_ac");
        dictionary.put("92010729", "luas_kanopi_jpb14");
        dictionary.put("92010730", "jml_kanopi_jpb14");
        dictionary.put("92010731", "letak_tangki_jpb15");
        dictionary.put("92010732", "kapasitas_tangki_jpb15");
        dictionary.put("92010733", "kls_jpb16");
        dictionary.put("92010801", "ac_1");
        dictionary.put("92010802", "ac_2");
        dictionary.put("92010803", "ac_3");
        dictionary.put("92010804", "kolam_renang_1");
        dictionary.put("92010805", "kolam_renang_2");
        dictionary.put("92010806", "perkerasan_halaman_1");
        dictionary.put("92010807", "perkerasan_halaman_2");
        dictionary.put("92010808", "perkerasan_halaman_3");
        dictionary.put("92010809", "perkerasan_halaman_4");
        dictionary.put("92010810", "lapangan_tenis_1");
        dictionary.put("92010811", "lapangan_tenis_2");
        dictionary.put("92010812", "lapangan_tenis_3");
        dictionary.put("92010813", "lapangan_tenis_4");
        dictionary.put("92010814", "lapangan_tenis_5");
        dictionary.put("92010815", "lapangan_tenis_6");
        dictionary.put("92010816", "lift_1");
        dictionary.put("92010817", "lift_2");
        dictionary.put("92010818", "lift_3");
        dictionary.put("92010819", "eskalator_1");
        dictionary.put("92010820", "eskalator_2");
        dictionary.put("92010821", "pagar_1");
        dictionary.put("92010822", "pagar_2");
        dictionary.put("92010823", "hydrant");
        dictionary.put("92010824", "fire_alarm");
        dictionary.put("92010825", "sprinkler");
        dictionary.put("92010826", "saluran_pabx");
        dictionary.put("92010827", "sumur_artesis");
        dictionary.put("92020001", "wajib_pajak_id");
        dictionary.put("92020002", "no_identitas_wp");
        dictionary.put("92020003", "jenis_wp");
        dictionary.put("92020004", "jenis_identitas_wp");
        dictionary.put("92020005", "nama_wp");
        dictionary.put("92020006", "status_data_wp");
        dictionary.put("92020101", "nama_jalan_wp");
        dictionary.put("92020102", "rt_wp");
        dictionary.put("92020103", "rw_wp");
        dictionary.put("92020104", "blok_kav_no_wp");
        dictionary.put("92020105", "no_telp1_wp");
        dictionary.put("92020106", "no_telp2_wp");
        dictionary.put("92020107", "email_wp");
        dictionary.put("92020201", "nama_bank_wp");
        dictionary.put("92020202", "cabang_bank_wp");
        dictionary.put("92020203", "no_rek_bank_wp");
        dictionary.put("92020301", "npwp");
        dictionary.put("92020302", "npwpd");
        dictionary.put("92020303", "status_pekerjaan_wp");
        dictionary.put("92020401", "tempat_lahir");
        dictionary.put("92020402", "tanggal_lahir");
        dictionary.put("92020403", "signature");
        dictionary.put("92020404", "foto");
        dictionary.put("92030001", "znt_id");
        dictionary.put("92030002", "tipe_aset");
        dictionary.put("92030003", "harga_penawaran");
        dictionary.put("92030004", "harga_penjualan");
        dictionary.put("92030005", "harga_sewa");
        dictionary.put("92030006", "luas_tanah");
        dictionary.put("92030007", "luas_bangunan");
        dictionary.put("92030008", "tahun_input");
        dictionary.put("92030009", "lebar_jalan");
        dictionary.put("92030010", "nama_penjual");
        dictionary.put("92030011", "tipe_bangunan");
        dictionary.put("92030012", "jenis_data");
        dictionary.put("92030013", "sisa_umur_ekonomis");
        dictionary.put("92030014", "nilai_bumi_per_m2");
        dictionary.put("92030015", "nilai_bangunan");

//        new
        dictionary.put("92000018", "verifiedReason");
        dictionary.put("92040000", "objekPajakId");
        dictionary.put("92040001", "subjekPajakid");
        dictionary.put("92040002", "objekId");
        dictionary.put("92040003", "jenisPajak");
        dictionary.put("92040004", "nopd");
        dictionary.put("92040005", "namaOp");
        dictionary.put("92040006", "namaJalanOp");
        dictionary.put("92040011", "noTelp1Op");
        dictionary.put("92040012", "noTelp2Op");
        dictionary.put("92040013", "emailOp");
        dictionary.put("92040015", "status");
        dictionary.put("92040017", "verifiedReason");
        dictionary.put("92040101", "namaObjek");
        dictionary.put("92040102", "alamatObjek");
        dictionary.put("92040103", "jenisObjek");
        dictionary.put("92040201", "klasifikasiUsaha");
        dictionary.put("92040202", "statusTempatUsaha");
        dictionary.put("92040203", "jumlahKaryawan");
        dictionary.put("92040204", "kapasitasMeja");
        dictionary.put("92040205", "kapasitasKursi");
        dictionary.put("92040206", "mekanismePerhitungan");
        dictionary.put("92040207", "jumlahPengunjungPerHari");
        dictionary.put("92040208", "jumlahHariPerBulan");
        dictionary.put("92040209", "dailySales");
        dictionary.put("92040210", "omset");
        dictionary.put("92040211", "statusOnline");
        dictionary.put("92040212", "catatan");
        dictionary.put("92040301", "hotelId");
        dictionary.put("92040302", "kamarHotel");
        dictionary.put("92040303", "jumlahHari");
        dictionary.put("92040304", "tingkatHunian");
        dictionary.put("92040401", "restoranId");
        dictionary.put("92040402", "modelPelayanan");
        dictionary.put("92040403", "jamBuka");
        dictionary.put("92040404", "jamTutup");
        dictionary.put("92040405", "merekPos");
        dictionary.put("92040406", "jumlahCabang");
        dictionary.put("92040407", "isFranchise");
        dictionary.put("92040408", "transactionPerDay");
        dictionary.put("92040409", "hargaRataTransaksiPerOrang");
        dictionary.put("92040501", "parkirId");
        dictionary.put("92040502", "kapasitasMotor");
        dictionary.put("92040503", "kapasitasMobil");
        dictionary.put("92040504", "tarifParkir");
        dictionary.put("92040505", "memberMotor");
        dictionary.put("92040506", "memberMobil");
        dictionary.put("92040507", "rataLamaParkir");
        dictionary.put("92040601", "hiburanId");
        dictionary.put("92040602", "sifatUsaha");
        dictionary.put("92040603", "kapasitasRuangan");
        dictionary.put("92040604", "kapasitasMesinKeping");
        dictionary.put("92040605", "tarif");
        dictionary.put("92040606", "jamBukaPerBulan");
        dictionary.put("92040701", "reklameId");
        dictionary.put("92040702", "klasifikasiReklame");
        dictionary.put("92040703", "judulReklame");
        dictionary.put("92040704", "panjang");
        dictionary.put("92040705", "lebar");
        dictionary.put("92040706", "tinggiAmbang");
        dictionary.put("92040707", "jumlahMukaReklame");
        dictionary.put("92040708", "jumlahReklame");
        dictionary.put("92040709", "lokasiReklame");
        dictionary.put("92040710", "kontenProduk");
        dictionary.put("92040801", "airTanahId");
        dictionary.put("92040802", "jumlahMeteran");

        return dictionary;
    }

    public static HashMap<String, String> setNonPbb() {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("92040007", "rtOp");
        dictionary.put("92040008", "rwOp");
        dictionary.put("92040009", "blokKavNoOp");
        dictionary.put("92040010", "kelurahanId");
        dictionary.put("92040014", "fotoOp");
        dictionary.put("92040016", "statusVerifikasi");
        dictionary.put("92040901", "kdProvinsi");
        dictionary.put("92040902", "kdDati2");
        dictionary.put("92040903", "kdKecamatan");
        dictionary.put("92040904", "kdKelurahan");
        return dictionary;
    }

    public static void set(Context context) {
//        Gson gson = new Gson();
//        String jsonFromMap = gson.toJson(set());
//        PrefHelper.saveToPref(context, CORE_DICTIONARY, jsonFromMap);
    }


    public static String getValueByKey(Context context, String key) {
        HashMap<String, String> dictionary = Dictionary.set();
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

    public static String getKeyByValue(Context context, String value) {
        HashMap<String, String> dictionary = set();
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (Objects.equals(value.toLowerCase(), entry.getValue().replace("_", "").toLowerCase())) {
                return entry.getKey();
            }
        }
        return null;
    }



    public static String getValueByKey(HashMap<String, String> dictionary ,Context context, String key) {
        return dictionary.get(key);
    }

    public static String getValueByKey(HashMap<String, String> dictionary ,List<String> keys) {
        String result = null;
        if (keys != null) {
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

    public static String getKeyByValue(Context context, HashMap<String, String> dictionary ,String value) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (Objects.equals(value.toLowerCase(), entry.getValue().replace("_", "").toLowerCase())) {
                return entry.getKey();
            }
        }
        return null;
    }

}

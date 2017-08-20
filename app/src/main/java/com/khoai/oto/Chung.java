package com.khoai.oto;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

/**
 * Created by anhkh on 4/27/2017.
 */

public class Chung {
    public static String tenxe = "name";

    public static String image = "image";

//    public static String gianiemyet = getString(R.string.gianiemyet);
//    public static String giadamphan = "Giá đàm phán:";
//    public static String nguongoc = "Nguồn gốc:";
//    public static String loaixe = "Loại xe:";

//    public static String dairongcao = "Dài x rộng x cao (mm):";
//    public static String dungtichbinhxang = "Dung tích bình xăng (lít):";
//    public static String dongco = "Động cơ:";
//    public static String congxuat = "Công suất (mã lực):";
//    public static String moment = "Mô-men xoắn (Nm):";
//    public static String khoangsanggam = "Khoảng sáng gầm (mm):";
//    public static String duongkinhvongquaytoithieu = "Đường kính vòng quay tối thiểu (m):";
//
//    public static String hopso = "Hộp số:";
//    public static String muctieuthunhienlieu = "Mức tiêu thụ nhiên liệu:";

//    public static String denpha = "Đèn pha :";
//    public static String guonggapdien = "Gương gập điện :";
//    public static String remchenangphiasau = "Rèm che nắng phía sau :";

//    public static String chatlieunoithat = "Chất liệu nội thất :";
//    public static String dieuhoa = "Điều hòa :";
//    public static String danlanhchohangghesau = "Dàn lạnh cho hàng ghế sau :";
//    public static String guongchieuhauchongchoi = "Gương chiếu hậu chống chói :";
//    public static String ghelai = "Ghế lái :";
//    public static String nhovitrighe = "Nhớ vị trí ghế :";
//    public static String suoighe = "Sưởi ghế :";
//    public static String lammatghe = "Làm mát ghế :";
//    public static String ghemassage = "Ghế massage :";
//    public static String cuakinhghelai = "Cửa kính ghế lái :";
//    public static String manhinhcamung = "Màn hình cảm ứng :";
//    public static String hethongloa = "Hệ thống loa (cái) :";
//    public static String ketnoibluetooth = "Kết nối Bluetooth :";
//    public static String daucamusb = "Đầu cắm USB :";
//    public static String manhinhdvd = "Màn hình DVD :";
//    public static String volangchinhdien = "Vô-lăng chỉnh điện :";
//    public static String cansangsotrenvolang = "Cần sang số trên vô-lăng :";
//    public static String manhinhgoidau = "Màn hình gối đầu :";
//    public static String hienthithongtintrenkinhlai = "Hiển thị thông tin trên kính lái HUD :";

//    public static String trolucdien = "Trợ lực điện (EPS) :";
//    public static String hotrokhoihanhngangdoc = "Hỗ trợ khởi hành ngang dốc (HAS) :";
//    public static String dieukhienhanhtrinh = "Điều khiển hành trình (Cruise Control) :";
//    public static String luachonchedochay = "Lựa chọn chế độ chạy :";
//    public static String hethongtreokhinen = "Hệ thống treo khí nén :";
//    public static String mocopranhtay = "Mở cốp rảnh tay :";
//    public static String chiakhoathongminh = "Chìa khóa thông minh :";
//    public static String ruadenphatudong = "Rửa đèn pha tự động :";
//    public static String denphatudongdieuchinhgochieu = "Đèn pha tự động điều chỉnh góc chiếu (AFS) :";
//    public static String gatmuatudong = "Gạt mưa tự động :";
//    public static String cameralui = "Camera lùi :";
//    public static String copdien = "Cốp điện :";
//    public static String cuasotroi = "Cửa sổ trời :";
//    public static String cuahit = "Cửa hít :";

//    public static String chongbocungphanh = "Chống bó cứng phanh (ABS) :";
//    public static String hotrophanhkhancap = "Hỗ trợ phanh khẩn cấp (BA) :";
//    public static String canbangdientu = "Cân bằng điện tử (ESP) :";
//    public static String kiemsoatdobamduong = "Kiểm soát độ bám đường (TRC) :";
//    public static String tuikhi = "Túi khí :";
//    public static String canhbaochechlan = "Cảnh báo chệch làn :";
//    public static String canhbaoapxuatlop = "Cảnh báo áp suất lốp :";
//    public static String phanhtaydientu = "Phanh tay điện tử :";
//    public static String cambienkhoangcach = "Cảm biến khoảng cách :";
//    public static String loprunflat = "Lốp Runflat :";

//    String[] ngoaithat = {denpha, guonggapdien, remchenangphiasau};

//    public static String[] dongcokhungxe = {dairongcao, dungtichbinhxang, dongco, congxuat, moment,
//            khoangsanggam, duongkinhvongquaytoithieu, hopso, muctieuthunhienlieu};

//    String[] noithat = {chatlieunoithat, dieuhoa, danlanhchohangghesau, guongchieuhauchongchoi,
//            ghelai, nhovitrighe, suoighe, lammatghe, ghemassage, cuakinhghelai, manhinhcamung, hethongloa,
//            ketnoibluetooth, daucamusb, manhinhdvd, volangchinhdien, cansangsotrenvolang, manhinhgoidau, hienthithongtintrenkinhlai

//    String[] tiennghi = {trolucdien, hotrokhoihanhngangdoc, dieukhienhanhtrinh, luachonchedochay,
//            hethongtreokhinen, mocopranhtay, chiakhoathongminh, ruadenphatudong,
//            denphatudongdieuchinhgochieu, gatmuatudong, cameralui, copdien,
//            cuasotroi, cuahit};
//    String[] antoan = {chongbocungphanh, hotrophanhkhancap, canbangdientu, kiemsoatdobamduong, tuikhi,
//            canhbaochechlan, canhbaoapxuatlop, phanhtaydientu, cambienkhoangcach, loprunflat};

    public static String stand_string(String string){
        string = string.replace(" ", "");
        string = string.replace(".", "");
        string = string.replace("₫", "");
        string = string.substring(0, string.length() - 6);
        return string;
    }
    public static Spannable color_text(String string, int color, String gia){
        string = stand_string(string);
        string = gia + string + " triệu";
        Spannable spannable = new SpannableString(string);
        spannable.setSpan(new ForegroundColorSpan(color), 5, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}

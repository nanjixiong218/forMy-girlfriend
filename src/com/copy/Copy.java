package com.copy;

import java.io.File;

import com.excel.util.Write;

public class Copy {
	public static void main(String arges[]){
		
		
		
		Write w = new Write();
		String names[] = new String[18];
		names[0] = "D:/����/ʡ��/����.xls";
		names[1] = "D:/����/ʡ��/�ױ�.xls";
		names[2] = "D:/����/ʡ��/��Դ.xls";
		names[3] = "D:/����/ʡ��/����.xls";
		names[4] = "D:/����/ʡ��/����.xls";
		names[5] = "D:/����/ʡ��/����.xls";
		names[6] = "D:/����/ʡ��/���.xls";
		names[7] = "D:/����/ʡ��/����.xls";
		names[8] = "D:/����/ʡ��/ƽ��ɽ.xls";
		names[9] = "D:/����/ʡ��/���.xls";
		names[10] = "D:/����/ʡ��/����Ͽ.xls";
		names[11] = "D:/����/ʡ��/����.xls";
		names[12] = "D:/����/ʡ��/����.xls";
		names[13] = "D:/����/ʡ��/����.xls";
		names[14] = "D:/����/ʡ��/���.xls";
		names[15] = "D:/����/ʡ��/֣��.xls";
		names[16] = "D:/����/ʡ��/�ܿ�.xls";
		names[17] = "D:/����/ʡ��/פ���.xls";
		String namesSw[] = new String[9];
		namesSw[0]="D:/����/ʡ��/����.xls";
		namesSw[1]="D:/����/ʡ��/����.xls";
		namesSw[2]="D:/����/ʡ��/�ӱ�.xls";
		namesSw[3]="D:/����/ʡ��/����.xls";
		namesSw[4]="D:/����/ʡ��/����.xls";
		namesSw[5]="D:/����/ʡ��/����.xls";
		namesSw[6]="D:/����/ʡ��/ɽ��.xls";
		namesSw[7]="D:/����/ʡ��/ɽ��.xls";
		namesSw[8]="D:/����/ʡ��/����.xls";
		for(int i = 0 ;i<namesSw.length;i++){
			File file = new File(namesSw[i]);
			w.copy(file);
		}
		
	/*	File file = new File("D:/����/ʡ��/����.xls");
		w.copy(file);*/
		
	}
}

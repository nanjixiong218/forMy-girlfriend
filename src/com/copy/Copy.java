package com.copy;

import java.io.File;

import com.excel.util.Write;

public class Copy {
	public static void main(String arges[]){
		
		
		
		Write w = new Write();
		String names[] = new String[18];
		names[0] = "D:/导出/省内/安阳.xls";
		names[1] = "D:/导出/省内/鹤壁.xls";
		names[2] = "D:/导出/省内/济源.xls";
		names[3] = "D:/导出/省内/焦作.xls";
		names[4] = "D:/导出/省内/开封.xls";
		names[5] = "D:/导出/省内/洛阳.xls";
		names[6] = "D:/导出/省内/漯河.xls";
		names[7] = "D:/导出/省内/南阳.xls";
		names[8] = "D:/导出/省内/平顶山.xls";
		names[9] = "D:/导出/省内/濮阳.xls";
		names[10] = "D:/导出/省内/三门峡.xls";
		names[11] = "D:/导出/省内/商丘.xls";
		names[12] = "D:/导出/省内/新乡.xls";
		names[13] = "D:/导出/省内/信阳.xls";
		names[14] = "D:/导出/省内/许昌.xls";
		names[15] = "D:/导出/省内/郑州.xls";
		names[16] = "D:/导出/省内/周口.xls";
		names[17] = "D:/导出/省内/驻马店.xls";
		String namesSw[] = new String[9];
		namesSw[0]="D:/导出/省外/安徽.xls";
		namesSw[1]="D:/导出/省外/广西.xls";
		namesSw[2]="D:/导出/省外/河北.xls";
		namesSw[3]="D:/导出/省外/湖北.xls";
		namesSw[4]="D:/导出/省外/江苏.xls";
		namesSw[5]="D:/导出/省外/江西.xls";
		namesSw[6]="D:/导出/省外/山东.xls";
		namesSw[7]="D:/导出/省外/山西.xls";
		namesSw[8]="D:/导出/省外/陕西.xls";
		for(int i = 0 ;i<namesSw.length;i++){
			File file = new File(namesSw[i]);
			w.copy(file);
		}
		
	/*	File file = new File("D:/导出/省内/安阳.xls");
		w.copy(file);*/
		
	}
}

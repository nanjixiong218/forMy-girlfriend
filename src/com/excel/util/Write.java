package com.excel.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Write {
	public void create(HashMap<String,List<String>> hm,String province,String month,File file){
		try {
			List<String> title = hm.get("title");
			List<String> place = hm.get("place");
			List<String> time = hm.get("time");
			WritableWorkbook wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet(month, 0);
			
			WritableFont font = new WritableFont(WritableFont.ARIAL,16,WritableFont.BOLD);
			
			WritableFont font1 = new WritableFont(WritableFont.TIMES,25,WritableFont.BOLD,true,UnderlineStyle.NO_UNDERLINE,Colour.RED);
			WritableCellFormat formate = new WritableCellFormat(font1);
			WritableCellFormat formate1 = new WritableCellFormat(font);
			Label h = new Label(0, 1, province,formate1);
			
			Label h1 = new Label(0, 0, "展会主题",formate);
			Label h2 = new Label(1, 0, "展会时间",formate);
			Label h3 = new Label(2, 0, "展会地点",formate);
			ws.addCell(h);
			ws.addCell(h1);
			ws.addCell(h2);
			ws.addCell(h3);
			ws.mergeCells(0, 1, 2, 1);
			for(int i =0;i<title.size();i++){
				Label label = new Label(0, i+2, title.get(i));
				Label label1 = new Label(1, i+2, time.get(i));
				Label label2 = new Label(2, i+2, place.get(i));
				ws.addCell(label);
				ws.addCell(label1);
				ws.addCell(label2);
			}
			ws.setColumnView(0, 40);
			ws.setColumnView(1, 25);
			ws.setColumnView(2, 25);
			wwb.write();
			wwb.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read(){
		try {
			Workbook wb = Workbook.getWorkbook(new File("D:/file/text.xls"));
			int numOfSheet = wb.getNumberOfSheets();
		
			Sheet st = wb.getSheet(0);
			String name = st.getName();
			int colsNum = st.getColumns();
			int rowsNum = st.getRows();
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update (File file) {
		try {
			Workbook wb = Workbook.getWorkbook(file);
			WritableWorkbook wwb = Workbook.createWorkbook(file,wb);
			int sheetNum = wwb.getNumberOfSheets();
			for(int i =0;i<sheetNum;i++){
				WritableSheet ws = wwb.getSheet(i);
				int rowNum = ws.getRows();
				for(int r=5;r<rowNum;r++){
					changeByColumn(ws,2,r);
					changeByColumn(ws,4,r);
					changeByColumn(ws,6,r);
					changeByColumn(ws,9,r);
					changeByColumn(ws,11,r);
					changeByColumn(ws,13,r);
				}
			}
			wwb.write();
			wwb.close();
		
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	private void changeByColumn (WritableSheet ws,int col,int row) throws Exception {
		// TODO Auto-generated method stub
		Cell c = ws.getCell(col,row);
		String content = c.getContents();
		NumberFormat nf = new NumberFormat("0.00");
		WritableCellFormat wcf = new WritableCellFormat(nf);
		Number nb = new Number(col, row, Double.valueOf(content).doubleValue(), wcf);
		ws.addCell(nb);
		
	}
	public void copy(File file) {
		
		try {
			Workbook wbMoban = Workbook.getWorkbook(new File("D:/导出/省外/省外重点品牌.xls"));
			WritableWorkbook wwbMoban = Workbook.createWorkbook(new File("D:/导出/省外/省外重点品牌.xls"),wbMoban);
			
			Workbook readwb = Workbook.getWorkbook(file);
			int sheetNumMoban = wwbMoban.getNumberOfSheets();
			String filename = file.getName().substring(0, file.getName().lastIndexOf("."));
			for(int i=0;i<sheetNumMoban;i++){
				if(wwbMoban.getSheet(i).getName().equals(filename)){
					WritableSheet ws = wwbMoban.getSheet(i);
					Sheet read = readwb.getSheet(0);
					int readRowNum = read.getRows();
					int readColNum = read.getColumns();
					int writeRowNum = ws.getRows();
					int writeColNum = ws.getColumns();
					int rowNum = Math.min(readRowNum, writeRowNum);
					int colNum = Math.min(readColNum, writeColNum);
					CellFormat cf1 = null;
					CellFormat cf2 = null;
					if(readRowNum+2<=writeRowNum){
						for(int r=4;r<rowNum;r++){
							
							Cell wc = ws.getCell(1,r+1);
							Cell rc = read.getCell(0,r);
							String content = rc.getContents();
							if(r==4){
								cf1 = wc.getCellFormat();
							}
							
							Label l = new Label(1, r+1, content, cf1);
							ws.addCell(l);
							Cell wc1 = ws.getCell(8,r);
							Cell rc1 = read.getCell(7,r);
							String content1 = rc1.getContents();
							
							Label l1 = new Label(8, r+1, content1, cf1);
							ws.addCell(l1);
						}
							
						for(int c = 1;c<colNum;c++){
							if(c==7){
								continue;
							}
							for(int r=4;r<rowNum;r++){
								Cell wc = ws.getCell(c+1,r+1);
								Cell rc = read.getCell(c,r);
								String content = rc.getContents();
								if(content.equals("")){
									content="0.00";
								}
								if(r==4){
									cf2 = wc.getCellFormat();
								}
								Number nb = new Number(c+1, r+1, Double.valueOf(content).doubleValue(), cf2);
								//Label l = new Label(1, r, content, cf);
								ws.addCell(nb);
							}
						}
						System.out.println(ws.getName());
					}
					
					
					else if(readRowNum+2>writeRowNum){
						for(int r=4;r<readRowNum;r++){
							
							Cell wc = ws.getCell(1,r+1);
							Cell rc = read.getCell(0,r);
							String content = rc.getContents();
							if(r==4){
								cf1 = wc.getCellFormat();
							}
						
						
							
							Label l = new Label(1, r+1, content, cf1);
							ws.addCell(l);
							Cell wc1 = ws.getCell(8,r);
							Cell rc1 = read.getCell(7,r);
							String content1 = rc1.getContents();
							Label l1 = new Label(8, r+1, content1, cf1);
							ws.addCell(l1);
						}
							
						for(int c = 1;c<readColNum;c++){
							if(c==7){
								continue;
							}
							for(int r=4;r<readRowNum;r++){
								Cell wc = ws.getCell(c+1,r+1);
								Cell rc = read.getCell(c,r);
								String content = rc.getContents();
								if(content.equals("")){
									content="0.00";
								}
								if(r==4){
									 cf2 = wc.getCellFormat();
								}
								
								Number nb = new Number(c+1, r+1, Double.valueOf(content).doubleValue(), cf2);
								//Label l = new Label(1, r, content, cf);
								ws.addCell(nb);
							}
						}
						System.out.println(ws.getName());
					}
					
					
				}
					
			}
			wwbMoban.write();
			wwbMoban.close();
		
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}

package com.web;

import java.io.File;
import java.util.Scanner;

public class GetAll {

	public static void main (String arges[]){
		String htmlurl="http://www.eshow365.com/";
		WebContent1 wc = new WebContent1(null, htmlurl);
		try {
			Scanner cin = new Scanner(System.in);
			System.out.print("�װ��ģ�������չ�����ƣ����籱��չ�ᣬ�Ϻ�չ�ᣩ��");
		
			String province =cin.nextLine();
			System.out.print("�װ��ģ��������·ݣ�����8��չ�ᣬ9��չ�ᣬ������Ϻ��������Ϻ�8��չ�ᣬ�Ϻ�9��չ�ᣩ��");
			String month=cin.nextLine();
			File file = new File("D:/file/text.xls");
			wc.getContent(province, month,file);
			
			System.out.print("�Ѿ�������ɣ��뿴d��file�ļ����¡�/n�������text.xls�ļ��������ǣ����������");
			String YorN = cin.nextLine();
			if(YorN.equals("��")){
				System.out.println("���������Գɹ����װ��ģ�������ʱ��������������٣�ôô��");
			}
			else{
				System.out.println("�����ǲ���ʧ���ˣ���Ҫ���������ٸĸİɣ�");
			}
			//Write write = new Write();
			//write.update();
			
			//String url = "http://www.eshow365.com/zhanhui/0-0-1-20130901/20130930/";
			//wc.getContentByOneUrl(url);
			
			
			//String html = wc.getOneHtml("http://www.eshow365.com/zhanhui/html/63051_0.html");
			//String place = wc.getPlace(html);
			//System.out.println(place);
			/* HashMap<String,String> hm = wc.getFormSina(htmlurl);
			 String html = hm.get("html");
			 String title = hm.get("title");
			 String h1 = wc.getH1(html);
			 String time =wc.getTime(html);
			 String place = wc.getPlace(html);
			// String link = "";
			 //List<String> list = wc.getLink("<a href=\"http://www.baicu.com\">�ٶ�</a>");
			// System.out.println(list.get(0));
			 System.out.println(title);
			 System.out.println(h1);
			 System.out.println(time);
			 System.out.println(place);
			 System.out.println(html);
			// String title = wc.getTitle("<title>�й���  �����</title>");
			 
			 String link = hm.get("link");
			 System.out.println(link);*/
			/*HashMap<String,String > hm = wc.getProvinces(htmlurl);
			String url1 = hm.get("����չ��");
			String url2 = hm.get("�Ϻ�չ��");
			String url3 = hm.get("����չ��");
			String url4 = hm.get("����չ��");
			
			System.out.println(url1);*/
			//System.out.println(url2);
			//System.out.println(url3);
			//System.out.println(url4);
			
			//List <String > hrefs = wc.getMeets(url1);
			/*HashMap<String,String > hrefsMonth = wc.getMonth(url1);
			
			String url8 = hrefsMonth.get("8��չ��");
			List <String > hrefs = wc.getMeetsForMonth(url8);
			for(int i=0;i<hrefs.size();i++){
				 System.out.println(hrefs.get(i));
				 String html = wc.getOneHtml(hrefs.get(i));
				 String h1 = wc.getH1(html);
				 String time =wc.getTime(html);
				 String place = wc.getPlace(html);
				 System.out.println(h1);
				 System.out.println(time);
				 System.out.println(place);
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

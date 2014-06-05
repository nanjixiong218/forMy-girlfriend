package com.web;

import java.io.File;
import java.util.Scanner;

public class GetAll {

	public static void main (String arges[]){
		String htmlurl="http://www.eshow365.com/";
		WebContent1 wc = new WebContent1(null, htmlurl);
		try {
			Scanner cin = new Scanner(System.in);
			System.out.print("亲爱的，请输入展会名称（例如北京展会，上海展会）：");
		
			String province =cin.nextLine();
			System.out.print("亲爱的，请输入月份（例如8月展会，9月展会，如果是上海请输入上海8月展会，上海9月展会）：");
			String month=cin.nextLine();
			File file = new File("D:/file/text.xls");
			wc.getContent(province, month,file);
			
			System.out.print("已经导出完成，请看d盘file文件夹下。/n如果看到text.xls文件请输入是，否则输入否：");
			String YorN = cin.nextLine();
			if(YorN.equals("是")){
				System.out.println("哈哈，测试成功，亲爱的，等我有时间给你做个界面再！么么！");
			}
			else{
				System.out.println("看来是测试失败了，不要紧，等我再改改吧！");
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
			 //List<String> list = wc.getLink("<a href=\"http://www.baicu.com\">百度</a>");
			// System.out.println(list.get(0));
			 System.out.println(title);
			 System.out.println(h1);
			 System.out.println(time);
			 System.out.println(place);
			 System.out.println(html);
			// String title = wc.getTitle("<title>中国人  徐慧燕</title>");
			 
			 String link = hm.get("link");
			 System.out.println(link);*/
			/*HashMap<String,String > hm = wc.getProvinces(htmlurl);
			String url1 = hm.get("北京展会");
			String url2 = hm.get("上海展会");
			String url3 = hm.get("广州展会");
			String url4 = hm.get("深圳展会");
			
			System.out.println(url1);*/
			//System.out.println(url2);
			//System.out.println(url3);
			//System.out.println(url4);
			
			//List <String > hrefs = wc.getMeets(url1);
			/*HashMap<String,String > hrefsMonth = wc.getMonth(url1);
			
			String url8 = hrefsMonth.get("8月展会");
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

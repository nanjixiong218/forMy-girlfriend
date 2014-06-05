package com.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JList;

import com.excel.util.Write;
import com.gui.WebGui;

public class WebContent1 {
	private JList contentPanel;
	private String url;
	private HashMap<String,String> hm;
	
	public WebContent1(JList contentArea,String weburl){
		this.contentPanel = contentArea;
		this.url = weburl;
		hm = new HashMap<String, String>();
	}
	public String  getOneHtml(String htmlurl) throws Exception{
		URL url;
		String temp;
		StringBuffer sb = new StringBuffer();
		url = new URL(htmlurl);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		while((temp = in.readLine())!=null){
			sb.append(temp);
		}
		in.close();
		return sb.toString();
	}
	public String getTitle(String s){
		String regex = "<title>(.*?)</title>";
		String title="";
		List<String> list = new ArrayList<String>();
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);//?
		Matcher ma  = pa.matcher(s);
		while(ma.find()){
			list.add(ma.group());
		}
		for(int i=0;i<list.size();i++){
			title=title+list.get(i);
		}
		return outTag(title);
	}
	public String getH1(String s){
		String regex = "<h1>.*?</h1>";
		String h1 = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			h1= ma.group();
		}
		return outTag(h1).trim();
		
	}
	public String getTime(String s){
		String regex = "<div class=\"zhxxcontent\">\\s*<p>.*?</p>";
		String time = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			time = ma.group();
		}
		return getTimeF1(time);
	}
	public String getPlace(String s){
		String regex = "(举办展馆.*?<a href=\"/zhanguan/html/.*?\\.html\" target=\"_blank\">.*?</a>|<p>\\s*?举办展馆[^<>]*?</p>)";
		String place = "";
		
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			place = ma.group();
		}
		return getPlaceF1(place);
	}
	public List<String> getLinkProvince(String s){
		String regex ;
		List<String> list = new ArrayList<String>();
		regex="<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*class=\"amenuread\".*?>(.*?)</a>";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		while(ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public List<String> getLinkMeet(String s){
		String regex ;
		List<String> list = new ArrayList<String>();
		regex="<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*class=\"zhtitle\".*?>(.*?)</a>";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		while(ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	public List<String> getLinkMeetForMonth(String s){
		String regex ;
		List<String> list = new ArrayList<String>();
		regex="</em><a[^>]*href=\"/zhanhui/[^>]*?\\.html\".*?>(.*?)</a>";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		while(ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	
	
	/**
	 * 辅助方法
	 * @param s
	 * @return
	 */
	public String outTag(String s){
		return s.replaceAll("<.*?>", "");
	}
	public String getTimeF1(String s){
		String regex = "[2].*(?=</p>)";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		return result;
	}
	public String getPlaceF1(String s){
		String regex = "(>.*(?=</a>))|(：.*(?=&nbsp))";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		result = result.substring(1);
		return result;
	}
	/**
	 * 得到所有月份的url
	 * @return
	 */
	public HashMap<String,String> getMonth(String url)throws Exception{
		HashMap<String ,String> hm = new HashMap<String, String>();
//		StringBuffer sb = new StringBuffer();
		String html = getOneHtml(url);
		//String title = getTitle(html);
		
		List <String > links = getLinkMonth(html);
		for(int i = 0;i<links.size();i++){
			String str = links.get(i);
			String name = outTag(str);
			String href = getHrefForMonth(str);
			hm.put(name, href);
		}
		return hm;
		
		
	}
	public List<String> getLinkMonth(String s){
		String regex ;
		List<String> list = new ArrayList<String>();
		regex="<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)月展会</a>";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		while(ma.find()){
			list.add(ma.group());
		}
		return list;
	}
	/*public HashMap<String,String> getFormSina(String url) throws Exception {
		HashMap<String ,String> hm = new HashMap<String, String>();
//		StringBuffer sb = new StringBuffer();
		String html = getOneHtml(url);
		String title = getTitle(html);
		List <String > links = getLink(html);
		String link  = links.get(0);
		hm.put("html", html);
		hm.put("title", title);
		hm.put("link", link);
		return hm;
		
	}*/
	public HashMap<String,String> getProvinces(String url) throws Exception {
		HashMap<String ,String> hm = new HashMap<String, String>();
//		StringBuffer sb = new StringBuffer();
		String html = getOneHtml(url);
		//String title = getTitle(html);
		
		List <String > links = getLinkProvince(html);
		for(int i = 0;i<links.size();i++){
			String str = links.get(i);
			String name = outTag(str);
			if(name.equals("上海展会")||name.equals("北京展会")||name.equals("广州展会")||name.equals("深圳展会")){
				String href = getHrefForProvince(str);
				hm.put(name, href);
			}
			
		}
		return hm;
	}
	public List<String> getMeets(String url) throws Exception {
		List<String> links = new ArrayList<String>();
		List<String> hrefs = new ArrayList<String>();
	
//		StringBuffer sb = new StringBuffer();
		String html = getOneHtml(url);
		//String title = getTitle(html);
		
		links = getLinkMeet(html);
		for(int i=0;i<links.size();i++){
			String str = links.get(i);
			String href = getHrefForMeet(str);
			hrefs.add(href);
		}
		return hrefs;
	}
	public List<String> getMeetsForMonth(String url) throws Exception {
		List<String> links = new ArrayList<String>();
		List<String> hrefs = new ArrayList<String>();
		
//		StringBuffer sb = new StringBuffer();
		String html = getOneHtml(url);
		//String title = getTitle(html);
		
		links = getLinkMeetForMonth(html);
		for(int i=0;i<links.size();i++){
			String str = links.get(i);
			String href = getHrefForMeetMonth(str);
			hrefs.add(href);
		}
		return hrefs;
	}
	public String getHrefForProvince(String s){
		String regex = "http.*\\.com";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		return result;
	}	
	public String getHrefForMeet(String s){
		String regex = "http.*\\.html";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		return result;
	}	
	public String getHrefForMonth(String s){
		String regex = "http.*[0-9]/";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		return result;
	}	
	public String getHrefForMeetMonth(String s){
		String regex = "\"/zhanhui/.*\\.html";
		String result = "";
		Pattern pa = Pattern.compile(regex,Pattern.CANON_EQ);
		Matcher ma = pa.matcher(s);
		if(ma.find()){
			result = ma.group();
		}
		result= result.substring(1);
		String pre = "http://www.eshow365.com";
		result = pre+result;
		return result;
	}
	
	public void getContent(String province,String month,File file)throws Exception{
		System.out.println("正在处理，老婆，请耐心等待……不要离开哦，乖！");
		Write write = new Write();
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		List<String> titles = new ArrayList<String>();
		List<String> places = new ArrayList<String>();
		List<String> times = new ArrayList<String>();
		HashMap<String, String> hmProvinceHrefs = getProvinces(url);
		String provinceUrl = hmProvinceHrefs.get(province);
		HashMap<String, String> hmMonthHrefs = getMonth(provinceUrl);
		String monthUrl = hmMonthHrefs.get(month);
		List<String> meetHrefs = getMeetsForMonth(monthUrl);
		for(int i=0;i<meetHrefs.size();i++){
			 String meetNow = meetHrefs.get(i);
			 System.out.println(meetNow);
			 String html = getOneHtml(meetNow);
			 String h1 = getH1(html);
			 String time =getTime(html);
			 String place = getPlace(html);
			 titles.add(h1);
			 places.add(place);
			 times.add(time);
			 //System.out.println(h1);
			 //System.out.println(time);
			 //System.out.println(place);
		}
		hm.put("title", titles);
		hm.put("place", places);
		hm.put("time", times);
		
		
		write.create(hm,province,month,file);
		System.out.println("success!");
		
		
	}
	public void getContentGui(String province,String month,File file) throws Exception{
		String tip1="可能失败了，这个月份不行……";
	//	wg.getTextAreaDisplay().setText(tip1);
	//	Thread.sleep(1000);
	//	String s = wg.getTextAreaDisplay().getText();
	//	System.out.println(s);
	//	wg.setVisible(true);
		Write write = new Write();
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		List<String> titles = new ArrayList<String>();
		List<String> places = new ArrayList<String>();
		List<String> times = new ArrayList<String>();
		HashMap<String, String> hmProvinceHrefs = getProvinces(url);
		String provinceUrl = hmProvinceHrefs.get(province);
		HashMap<String, String> hmMonthHrefs = getMonth(provinceUrl);
		String monthUrl = hmMonthHrefs.get(month);
		List<String> meetHrefs = getMeetsForMonth(monthUrl);
		for(int i=0;i<meetHrefs.size();i++){
			 String meetNow = meetHrefs.get(i);
			 System.out.println(meetNow);
			 String html = getOneHtml(meetNow);
			 String h1 = getH1(html);
			 String time =getTime(html);
			 String place = getPlace(html);
			 titles.add(h1);
			 places.add(place);
			 times.add(time);
			 //System.out.println(h1);
			 //System.out.println(time);
			 //System.out.println(place);
		}
		hm.put("title", titles);
		hm.put("place", places);
		hm.put("time", times);
		
		write.create(hm,province,month,file);
	//	wg.getTextAreaDisplay().setText("完成一个了");
	//	Thread.sleep(1000);
	//	wg.setVisible(true);
		
	}
	public void getContentByOneUrl (String url) throws Exception{
		
		List<String> meetHrefs = getMeetsForMonth(url);
		for(int i=0;i<meetHrefs.size();i++){
			 String meetNow = meetHrefs.get(i);
			 System.out.println(meetNow);
			 String html = getOneHtml(meetNow);
			 String h1 = getH1(html);
			 String time =getTime(html);
			 String place = getPlace(html);
			 System.out.println(h1);
			 System.out.println(time);
			 System.out.println(place);
		}
	}
		
		

}

package mihich;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Souyou  {

    private Elements select2;

    public void sate(String u) throws IOException {


       // private String u = "https://www.51job.com/";
       Document document = Jsoup.connect(u).timeout(100000).get();
       Elements select = document.select("body > div.hm.container > div.cn.hlist > div.e>a");//获取网址
       for (Element s : select
       ) {
           String href = s.attr("href");
           String text = s.select("span.at").text();
           Url url = new Url(href, text);//将网址和首页中选项的内容放入类
           //#resultList > div:nth-child(4) > p > span > a
           //#hidTotalPage   #hidTotalPage   #resultList > div.dw_page > div > div > div > ul > li:nth-child(3) > a
           Document document1 = Jsoup.connect(url.getUrl()).timeout(100000).get();//获取首页中选项的网页
            //#resultList > div.dw_page > div > div > div > ul > li:nth-child(6) > a
            //#resultList > div.dw_page > div > div > div > ul > li:nth-child(5) > a
           //#resultList > div.dw_page > div > div > div > ul > li.on
               Elements select1 = document1.select("#resultList>div.el");//获取第一页信息
           for (Element e : select1
           ) {
               String t1 = e.select("p.t1").text();
               String t2 = e.select("span.t2").text();
               String t3 = e.select("span.t3").text();
               String t4 = e.select("span.t4").text();
               String t5 = e.select("span.t5").text();

               Job job = new Job(t1, t2, t3, t4, t5);
              // System.out.println(job);
           }


           Elements select2 = document1.select("#resultList > div.dw_page > div > div > div > ul > li > a");//获取网页中下一页的网址

           for (Element q : select2
       ) {
           String href1 = q.attr("href");
           String text1 = q.text();//获取下一页的页数
//           url.setUrl(href1);//放入类中

//           url.setTitle(text1);//放入类中
           Next next = new Next(href1, text1);
           //因为第二页和下一页网址都在a里，所以会打印出俩个第二页，暂时没处理
           Document document11 = Jsoup.connect(next.getUrl()).timeout(100000).get();//获取首页中选项的网页
           Elements select3 = document11.select("#resultList>div.el");//获取第2页信息

           for (Element a:select3
           ) {

               String t1 = a.select("p.t1").text();
               String t2 = a.select("span.t2").text();
               String t3 = a.select("span.t3").text();
               String t4 = a.select("span.t4").text();
               String t5 = a.select("span.t5").text();

               Job job = new Job(t1, t2, t3, t4, t5);
             //  System.out.println(job);
           }
       }


       }


   }
}


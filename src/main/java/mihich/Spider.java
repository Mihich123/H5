package mihich;

import mihich.Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Spider {

    public static void main(String[] args) throws IOException, PropertyVetoException, SQLException, ClassNotFoundException {

        String a = "https://search.51job.com/list/150000,000000,0000,00,9,99,Java%25E5%25BC%2580%25E5%258F%2591%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,"+1+".html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        Shujuk sju = new Shujuk();

        for (int i = 1; i <100000; i++) {


        //String u = "https://search.51job.com/list/150000,000000,0000,00,9,99,Java%25E5%25BC%2580%25E5%258F%2591%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,3.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        Document document = Jsoup.connect(a).timeout(100000).get();
        Elements select = document.select("#resultList>div.el");

         for (Element s : select
          ) {
             String t1 = s.select("p.t1").text();
             String t2 = s.select("span.t2").text();
             String t3 = s.select("span.t3").text();
             String t4 = s.select("span.t4").text();
             String t5 = s.select("span.t5").text();


             Job job = new Job(t1,t2,t3,t4,t5);

             sju.Shu(t1,t2,t3,t4,t5);

       }


    }
    }
}













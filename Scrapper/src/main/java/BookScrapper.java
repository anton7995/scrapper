import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BookScrapper {
    public static void main(String[] args){
        String url = "https://books.toscrape.com/";
        try {
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");//точку используем для получения класса продукта, для идентификатора хэштег
            for (Element bk : books) {
                String title = bk.select("h3 > a").text();
                String price = bk.select(".price_color").text();
//                System.out.println("Название книги: " + title + " цена книги: " + price);

                Double actual_price = Double.parseDouble(price.substring(1));


                if (actual_price<20.0){
                    System.out.println("Название книги: " + title + " цена книги: " + price);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

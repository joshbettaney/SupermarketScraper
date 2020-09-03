package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Class that holds the logic for scraping product information from the Tesco website.
 * @author Joshua Bettaney
 */
public class TescoScraper implements Scraper {

    private ArrayList<String> URLS;

    /**
     * Method to initialize the URL array list.
     * @throws IOException - Failure to parse HTML document.
     */
    private void initialiseUrls() throws IOException {

        URLS = new ArrayList<>();

        //Retrieve grocery index page, parse into DOM tree and select all <a> elements that have
        //a parent with the 'list-item' class.
        Document doc = Jsoup.connect("https://www.tesco.com/groceries/en-GB/shop/").get();
        Elements links = doc.select(".list-item > a");

        //Process each of those elements and extract their URL links, filtering them.
        for (Element link : links) {

            String linkURL = link.absUrl("href");

            if (linkURL.contains("shop/") && !(linkURL.contains("/?"))) URLS.add(linkURL);
        }
    }

    /**
     * Method to retrieve the amount of pages the items are displayed on.
     * @param url - The url of the respective page.
     * @return The number of pages.
     */
    private int getPageCount(String url){

        double itemCount = 0;

        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select(".pagination__items-displayed > strong");

            for(Element element : elements){

                String elementText = element.text();

                if(!elementText.contains("-")){
                    elementText = elementText.replaceAll("\\D+","");
                    itemCount = Integer.parseInt(elementText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (int) Math.ceil(itemCount/48.0);
    }

    /**
     * Method to initialize the scraping process.
     */
    @Override
    public void scrape() {

    }
}

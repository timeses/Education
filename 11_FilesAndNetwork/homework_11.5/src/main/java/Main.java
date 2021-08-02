import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import core.Line;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("src\\main\\resources\\MMParse.json");
        List<StationIndex> finalJSON = new ArrayList<>();
        Document metroTable = Jsoup.connect("https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена").maxBodySize(0).get();
        Element table = metroTable.select("table[class=standard sortable]").get(0);
        Elements rows = table.select("tr");

        StationIndex stationIndex = new StationIndex();
        LinkedHashMap<String, List<String>> station = new LinkedHashMap<>();
        List<Line> lines = new LinkedList<>();
        List<String> linesList = new ArrayList<>();
        List<String> numberLinesList = new ArrayList<>();
        List<String> colorList = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Elements numberLine = cols.select("span");
            Elements nameLine = numberLine.select("span[title]");
            String strLine = String.valueOf(nameLine);
            String[] arrSplit = strLine.split("\"");
            Elements transfer = cols.select("td");
            String strTransfer = String.valueOf(transfer);
            String[] tfrSplit = strTransfer.split("\"");
//            System.out.println(numberLine.get(0).text() + " - " + arrSplit[1]); // номер линии + название
 //           System.out.println("Цвет линии - " + tfrSplit[3].replaceAll("[^#A-Z0-9]", "")); // цвет линии
  //          System.out.println("Станция - " + cols.get(1).text()); // название станции
            try {
                Elements perehodi = cols.get(3).select("span[title]");
                String perehodiki = String.valueOf(perehodi);
                String[] perepere = perehodiki.split("\"");

/*                System.out.println(perepere[1]);
                System.out.println(perepere[23]);
                System.out.println(perepere[45]);
                System.out.println(perepere[67]);*/

            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
//            System.out.println();

            linesList.add(arrSplit[1]);
            colorList.add(tfrSplit[3].replaceAll("[^#A-Z0-9]", ""));
            numberLinesList.add(numberLine.get(0).text());
            String[] stationNames = {cols.get(1).text()};
            for (int w = 0; w < stationNames.length; w++) {
                station.computeIfAbsent(numberLine.get(0).text(), key -> new ArrayList<>()).add(String.valueOf(stationNames[w]));
            }
        }

        StationIndex stationIndex2 = new StationIndex();
        Map<String, List<String>> station2 = new HashMap<>();
        List<Line> lines2 = new LinkedList<>();
        List<String> linesList2 = new ArrayList<>();
        List<String> numberLinesList2 = new ArrayList<>();
        List<String> colorList2 = new ArrayList<>();
        Element table2 = metroTable.select("table[class=standard sortable]").get(1);
        Elements rows2 = table2.select("tr");
        for (int j = 2; j < rows2.size(); j++) {
            Element row2 = rows2.get(j);
            Elements cols2 = row2.getElementsByIndexEquals(j).select("td");
            Elements numberLine2 = cols2.select("span");
            Elements nameLine2 = numberLine2.select("span[title]");
            String strLine2 = String.valueOf(nameLine2);
            String[] arrSplit2 = strLine2.split("\"");
            Elements transfer2 = cols2.select("td");
            String strTransfer2 = String.valueOf(transfer2);
            String[] tfrSplit2 = strTransfer2.split("\"");
 //           System.out.println(numberLine2.get(0).text() + " - " + arrSplit2[1]); // номер линии
 //           System.out.println("Цвет линии - " + tfrSplit2[1].replaceAll("[^#A-Z0-9]", "")); // цвет линии
 //           System.out.println("Станция - " + cols2.get(1).text()); // название станции
            try {
                Elements perehodi = cols2.get(3).select("span[title]");
                String perehodiki = String.valueOf(perehodi);
                String[] perepere = perehodiki.split("\"");
/*                System.out.println(perepere[1]);
                System.out.println(perepere[23]);
                System.out.println(perepere[45]);
                System.out.println(perepere[67]);*/
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
//            System.out.println();

            linesList2.add(arrSplit2[1]);
            colorList2.add(tfrSplit2[1].replaceAll("[^#A-Z0-9]", ""));
            numberLinesList2.add(numberLine2.get(0).text());
            String[] stationNames2 = {cols2.get(1).text()};
            for (int i = 0; i < stationNames2.length; i++) {
                station2.computeIfAbsent(numberLine2.get(0).text(), key -> new ArrayList<>()).add(String.valueOf(stationNames2[i]));
            }
        }
        Element table3 = metroTable.select("table[class=standard sortable]").get(2);
        Elements rows3 = table3.select("tr");

        StationIndex stationIndex3 = new StationIndex();
        Map<String, List<String>> station3 = new HashMap<>();
        List<Line> lines3 = new LinkedList<>();
        List<String> linesList3 = new ArrayList<>();
        List<String> numberLinesList3 = new ArrayList<>();
        List<String> colorList3 = new ArrayList<>();

        for (int k = 2; k < rows3.size(); k++) {
            Element row3 = rows3.get(k);
            Elements cols3 = row3.select("td");
            Elements numberLine3 = cols3.select("span");
            Elements nameLine3 = numberLine3.select("span[title]");
            String strLine3 = String.valueOf(nameLine3);
            String[] arrSplit3 = strLine3.split("\"");
            Elements transfer3 = cols3.select("td");
            String strTransfer3 = String.valueOf(transfer3);
            String[] tfrSplit3 = strTransfer3.split("\"");
 //           System.out.println(numberLine3.get(0).text() + " - " + arrSplit3[1]); // номер линии
 //           System.out.println("Цвет линии - " + tfrSplit3[1].replaceAll("[^#A-Z0-9]", "")); // цвет линии
//            System.out.println("Станция - " + cols3.get(1).text()); // название станции
            try {
                Elements perehodi = cols3.get(3).select("span[title]");
                String perehodiki = String.valueOf(perehodi);
                String[] perepere = perehodiki.split("\"");
/*                System.out.println(perepere[1]);
                System.out.println(perepere[23]);
                System.out.println(perepere[45]);
                System.out.println(perepere[67]);*/
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
 //           System.out.println();

            linesList3.add(arrSplit3[1]);
            colorList3.add(tfrSplit3[1].replaceAll("[^#A-Z0-9]", ""));
            numberLinesList3.add(numberLine3.get(0).text());
            String[] stationNames3 = {cols3.get(1).text()};
            for (int i = 0; i < stationNames3.length; i++) {
                station3.computeIfAbsent(numberLine3.get(0).text(), key -> new ArrayList<>()).add(String.valueOf(stationNames3[i]));
            }
        }
        LinkedHashSet<String> set2 = new LinkedHashSet<>(numberLinesList);
        numberLinesList.clear();
        numberLinesList.addAll(set2);
        numberLinesList.remove(4);
        numberLinesList.remove(12);
        LinkedHashSet<String> set3 = new LinkedHashSet<>(colorList);
        colorList.clear();
        colorList.addAll(set3);
        LinkedHashSet<String> set = new LinkedHashSet<>(linesList);
        linesList.clear();
        linesList.addAll(set);

        for (int q = 0; q < set.size(); q++) {
            lines.add(new Line(numberLinesList.get(q), linesList.get(q), colorList.get(q)));
        }
        for (int y = 0; y < 1; y++) {
            lines2.add(new Line(numberLinesList2.get(y), linesList2.get(y), colorList2.get(y)));
        }
        for (int c = 0; c < 1; c++) {
            lines3.add(new Line(numberLinesList3.get(c), linesList3.get(c), colorList3.get(c)));
        }
        stationIndex.setStations(station);
        stationIndex2.setStations(station2);
        stationIndex3.setStations(station3);
        stationIndex.setLines(lines);
        stationIndex2.setLines(lines2);
        stationIndex3.setLines(lines3);
        finalJSON.add(stationIndex);
        finalJSON.add(stationIndex2);
        finalJSON.add(stationIndex3);

        String json =
                new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                        create().toJson(stationIndex);
        writer.write(json);
        writer.flush();

        try {
            JsonReader reader = new JsonReader(new FileReader("src\\main\\resources\\MMParse.json"));
            reader.beginObject();
            while (reader.hasNext()){
                if(reader.nextName().equals("stations")){
                    reader.beginObject();
                    while (reader.hasNext()){
                        String lineNumber = reader.nextName();
                        int count = 0;
                        reader.beginArray();
                        while (reader.hasNext()){
                            reader.nextString();
                            count++;
                        }
                        System.out.println("На линии " + lineNumber + " : " + count + " станций.");
                        reader.endArray();
                    }
                    reader.endObject();
                }
                else break;
            }
            reader.endObject();
            reader.close();
    } catch (Exception ignored) {
        }
    }
}
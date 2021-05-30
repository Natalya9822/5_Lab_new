package lab;

import java.util.*;

public class   Main {

    public static void main(String[] args) {
        List<Author> authors = List.of(
            new Author("Khalid M.", 170, "Scientific Reports", "Arabian Journal of Chemictry", "Chemosphere"),
            new Author("Wang G.", 50, "Journal of Hydrology", "Nature Communications", "Water Research"),
            new Author("Karri R.R.", 56, "Scientific Reports", "Renewable Energy", "Journal of Molecular Liquids"),
            new Author("Pakalapati H.", 9, "Bioresource Technology", "Scientific Reports"),
            new Author("Yuan M.M.", 26, "Nature Climate Change", "Nature Comminications"),
            new Author("Zhou J.", 620, "Microblome", "Environmental Pollution", "Geoderma", "Nature Climat Change"),
            new Author("Lin L.", 16, "Environmental Pollution", "Communications Biology"),
            new Author("Elbashir N.O.", 94, "Scientific Reports", "Energy", "Processes", "Catalysts"),
            new Author("Challiwala M.", 10, "Scientific Reports", "Catalysis Today", "AlChE Journal"),
            new Author("Ghouri M.M.", 19, "Computer Aided Chemical Engineering", "Journal of Physical Chemistry C.")
        );
        //Вывод в консоль авторов, опубликовавших свои статьи менее, чем в трех журналах
        authors.forEach(author -> {
            if (author.getJournals().size() < 3) {
                System.out.println(author);
            }
        });

        System.out.println();

        //Вывод в консоль авторов, опубликовавших свои стать в журнале...
        Iterator<Author> iterator = authors.iterator();
        while (iterator.hasNext()) {
            Author next = iterator.next();
            if (next.getJournals().contains("Scientific Reports")) {
                System.out.println(next);
            }
        }
        System.out.println();

        //Определяем журнал, в котором опубликовали свои статьи наибольшее количество авторов
        Map<String, Integer> journalsMap = new HashMap<>();

        authors.forEach(author -> author.getJournals().forEach(journal ->
            journalsMap.put(journal, journalsMap.getOrDefault(journal, 0) + 1)));

        String s = journalsMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        System.out.println(s);

        System.out.println();

        //Вывод в консоль авторов, опубликовавших более 50 статей
        authors.forEach(author -> {
            if (author.getNumberOfArticles() > 50) {
                System.out.println(author);
            }
        });
    }
}

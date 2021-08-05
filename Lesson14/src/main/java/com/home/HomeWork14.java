package com.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.model.Car;
import com.home.model.Engine;
import com.home.model.FuelTank;
import com.home.model.SimpleCar;
import com.home.service.TextFormatter;
import com.home.service.TextFormatterImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.home.service.ObjectSerializer.fromFile;
import static com.home.service.ObjectSerializer.toFile;
import static com.home.util.Constants.*;

@Slf4j
public class HomeWork14 {

    /**
     * 1)В исходном файле hw1/input.txt находятся слова, каждое слово на новой строке.
     * После запуска программы должен создать файл output.txt, который будет содержать в себе только палиндромы.
     * 2)Текстовый файл hw2/input.txt содержит текст.
     * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до 5-ти слов.
     * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении, оно попадает в output.txt файл.
     * Пишем все в ООП стиле. Создаем класс TextFormatter
     * в котором два статических метода:
     * 1. Метод принимает строку и возвращает кол-во слов в строке.
     * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
     * В main считываем файл.
     * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
     * Если подходит добавляем его в output.txt файл
     * 3) Проверка на цензуру:
     * Создаете 2 файла.
     * 1 - й. Содержит исходный текст.
     * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите каждое слово на новой строке, хотите через запятую разделяйте.
     * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
     * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
     * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
     * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
     * 5) Задача со *
     * Скопировать объект Car из пакета hw5, добавить библиотеки
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.3
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.12.3
     * в через maven в проект. Далее вычитать данные в json формате из файла (hw5/car.json), руками файл изменять нельзя!
     * Преобразовать прочитанные данные в объект hw5.Car (название полей редактировать нельзя, добавлять поля также нельзя) и вывести на консоль объект через System.out.println();
     */
    static TextFormatter textFormatter;

    public static void main(String[] args) {
        textFormatter = new TextFormatterImpl();
//        point1(); //Копирование слов-палиндромов в новый файл
//        point2(); //Раздление текста на предложения. Сортировка предложений по числу слов и наличию слов-палиндромов
//        point3(); //Цензура
//        point4(); //Сериализация - десериализация
        point5(); //JSON
    }

    public static void point1() {
        System.out.println("1) Копирование слов-палиндромов в новый файл - \"resources/hw1/output.txt\"");
        try {
            List<String> stringList = textFormatter.readFileAsStringList(INPUT_FILE_1);
            textFormatter.createFile(OUTPUT_FILE_1);
            for (String word : stringList) {
                if (textFormatter.isPalindrome(word)) {
                    textFormatter.addToFile(word + "\n", OUTPUT_FILE_1);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void point2() {
        System.out.println("2) Раздление текста на предложения. \nСортировка предложений по числу слов и наличию слов-палиндромов \nрезультат - \"resources/hw2/output.txt\"");
        try {
            String text = textFormatter.readFileAsString(INPUT_FILE_2);
            List<String> sentences = textFormatter.getSplitedSentences(text);
            textFormatter.createFile(OUTPUT_FILE_2);
            for (String sentence : sentences) {
                int wordCount = textFormatter.getWordsCount(sentence);
                if ((wordCount >= MIN_SIZE && wordCount <= MAX_SIZE) || textFormatter.isPalindromeExists(sentence)) {
                    textFormatter.addToFile(sentence + "\n", OUTPUT_FILE_2);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void point3() {
        System.out.println("3) Цензура");
        try {
            String text = textFormatter.readFileAsString(INPUT_FILE_3_TEXT);
            List<String> words = textFormatter.readFileAsStringList(INPUT_FILE_3_WORDS);
            List<String> matchingWords = getMatchingWordsList(words, text);
            if (matchingWords.size() > 0) {
                analyzeAndShowSentencesForEditing(text, matchingWords);
            } else {
                System.out.println("Текст цензуру прошел");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private static void analyzeAndShowSentencesForEditing(String text, List<String> matchingWords) {
        List<String> sentences = textFormatter.getSplitedSentences(text);
        Set<String> sentencesForEditing = getSentencesForEditing(matchingWords, sentences);
        printSentencesForEditing(sentencesForEditing);
    }

    private static List<String> getMatchingWordsList(List<String> words, String text) {
        String textLowerCase = text.toLowerCase();
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (textLowerCase.contains(word.toLowerCase())) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    private static Set<String> getSentencesForEditing(List<String> matchingWords, List<String> sentences) {
        Set<String> sentencesForEditing = new HashSet<>();
        for (String word : matchingWords) {
            sentencesForEditing.addAll(getSentencesForEditingByWord(sentences, word));
        }
        return sentencesForEditing;
    }

    private static Set<String> getSentencesForEditingByWord(List<String> sentences, String word) {
        return sentences.stream()
                .filter(x -> x.toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toSet());
    }

    private static void printSentencesForEditing(Set<String> sentences) {
        System.out.println("Предложения содержащие запрещенные слова:");
        for (String s : sentences) {
            System.out.println("  " + s);
        }
    }

    public static void point4() {
        System.out.println("4) Сериализация объекта");
        FuelTank tank = new FuelTank(65);
        tank.setFuelLevel(35);
        Engine engine = new Engine(2000, "diesel");
        SimpleCar carMazda = new SimpleCar("Mazda", engine);
        carMazda.setMaxSpeed(200);
        carMazda.setFuelTank(tank);
        carMazda.setPrice(10000);
        System.out.println("Исходный объект: " + carMazda);

        try {
            toFile(carMazda, FILE_4);
            fromFile(FILE_4);
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    public static void point5() {
        System.out.println("5) Работа с JSON");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String stringJSON = textFormatter.readFileAsString(FILE_5);
            Car myMappingClass = objectMapper.readValue(stringJSON, Car.class);
            System.out.println(myMappingClass);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}

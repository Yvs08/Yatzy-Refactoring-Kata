package com.example.Yatzy.rules;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Yatzy {

    public static void main (String... args) throws Exception {

        Yatzy tester = new Yatzy() ;
        //void test = () -> System.out.println("hello");
        Runnable monTraitement = () -> System.out.println("traitement");
        monTraitement.run() ;
        List<Integer> dices = Arrays.asList(3,3,3,4,4);
        System.out.println("score_pair "+tester.score_pair(3,3,3,4,4));
        System.out.println("two_pair "+tester.two_pair(3,3,3,4,4));
        System.out.println(tester.three_of_a_kind(3,3,3,4,4));
        System.out.println("three_pair "+tester.three_of_a_kind(3,3,3,4,4));
        System.out.println("full_house "+tester.fullHouse(3,3,3,4,4));

        System.out.println("four " +tester.four_Of_AKind(3,3,3,4,4));
        Consumer<String> afficher = (param) -> System.out.println(param);

    }


    /** Sequence reference small straight */
    public static final List<Integer> SMALL_STRAIGHT_SEQUENCE_REFERENCE = List.of(1, 2, 3, 4, 5);
    /** Sequence reference large straight */
    public static final List<Integer> LARGE_STRAIGHT_SEQUENCE_REFERENCE = List.of(2, 3, 4, 5, 6);



    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(1,dices);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(2, dices);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(3, dices);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(4, dices);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(5, dices);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1,d2,d3,d4,d5).collect(Collectors.toList());
        return getScoreByNumber(6, dices);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.toList());
        if (dices.equals(SMALL_STRAIGHT_SEQUENCE_REFERENCE)) {
            return 15;
        }
        return 0;

    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.toList());
        if (dices.equals(LARGE_STRAIGHT_SEQUENCE_REFERENCE)) {
            return 20;
        }
        return 0;
    }

    /**
     * getScoreByNumber the dice corresponding to a number
     * @param number the number
     * @param dices the dices
     * @return scoreByNumber
     */
    private static int getScoreByNumber(int number, List<Integer> dices) {

        return  dices
                .stream()
                .filter(diceValue -> number == diceValue)
                .reduce(0, Integer::sum);
    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return score_pair
     */
    public static int score_pair (int d1, int d2, int d3, int d4, int d5) {

        int  score_pair = Stream.of(d1,d2,d3,d4,d5)
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue() >= 2)
                .max(Map.Entry.comparingByKey())
                .map(integerLongEntry -> integerLongEntry.getKey() * 2)
                .stream()
                .findFirst()
                .orElse(0);

        return score_pair ;
    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return two_pair
     */

    public static int two_pair(int d1, int d2, int d3, int d4, int d5){
        int score_two_pair = 0;
        List<Integer>  score_two_pair_List = Stream.of(d1,d2,d3,d4,d5)
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue() >= 2)
                .map(integerLongEntry -> integerLongEntry.getKey() * 2)
                .collect(Collectors.toList());


        if(score_two_pair_List.size() == 2) {
            score_two_pair = score_two_pair_List.stream().reduce(0,Integer::sum);
        }

        return score_two_pair ;
    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return three_of_a_kind
     */
    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5){
        int  score_three_of_a_kind = Stream.of(d1,d2,d3,d4,d5)
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue() >= 3)
                .map(integerLongEntry -> integerLongEntry.getKey() * 3)
                .mapToInt(value -> value.intValue())
                .sum();

        return score_three_of_a_kind ;

    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return four_Of_AKind
     */
    public static int four_Of_AKind(int d1, int d2, int d3, int d4, int d5){
        int  score_four_Of_AKind = Stream.of(d1,d2,d3,d4,d5)
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue() >= 4)
                .map(integerLongEntry -> integerLongEntry.getKey() * 4)
                .mapToInt(value -> value.intValue())
                .sum();

        return score_four_Of_AKind ;

    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return fullHouse
     */
    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int score_two_pair = 0;
        Map<Integer, Long> full_house_list =
                         Stream.of(d1,d2,d3,d4,d5)
                        .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        if (full_house_list.containsValue(2L) && full_house_list.containsValue(3L)) {
            score_two_pair = Stream.of(d1,d2,d3,d4,d5).reduce(0, Integer::sum);
        }

        return score_two_pair;
    }
    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return yatzy
     */
    public static int  yatzy (int d1, int d2, int d3, int d4, int d5){
        int score_tatzy = 0;
        Map<Integer, Long> full_house_list =
                        Stream.of(d1,d2,d3,d4,d5)
                        .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        if (full_house_list.containsValue(5L)){
            score_tatzy = 50;
        }
        return score_tatzy ;
    }

    /**
     * @param d1,d2,d3,d4,d5 the dices
     * @return chance
     */
    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return Stream.of(d1,d2,d3,d4,d5)
                .reduce(0,Integer::sum);
    }


}

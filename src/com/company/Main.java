package com.company;

import java.util.List;

public class Main {
    /*
     * Data Analysis (Time taken):
     * file_read
     *   data_big    : 239ms
     *   data_small  : 30ms
     *   data_test   : 18ms
     *
     * sum_calculation_time
     *   data_big    : 152ms
     *   data_small  : 19ms
     *   data_test   : 15ms
     *                                  Old methods
     * top_down_sum                         top_down_traversal_old
     *   data_big    : 2ms                    data_big    : 20ms
     *   data_small  : 0ms                    data_small  : 0ms
     *   data_test   : 0ms                    data_test   : 0ms
     *
     * tree_print                           array_print
     *   data_big    : 1544ms                 data_big    : 3434ms
     *   data_small  : 6ms                    data_small  : 18ms
     *   data_test   : 1ms                    data_test   : 9ms
     */
    private static Sum_of_path sum_of_path = new Sum_of_path();
    private static File_read file_read = new File_read();


    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<Integer>> content = file_read.file_read("data_test.txt");
        //List<List<Integer>> content = file_read.file_read("data_small.txt");
        //List<List<Integer>> content = file_read.file_read("data_big.txt");
        long endTime = System.nanoTime();
        long read_duration = (endTime - startTime);
        if(content != null) {
            startTime = System.nanoTime();
            sum_of_path.bottom_up_calc_top_down_traverse(content);
            endTime = System.nanoTime();
            long path_duration = (endTime - startTime) - (sum_of_path.traverse_time + sum_of_path.print_time);

            //Testing timings on different text files
            System.out.println("File Read   - Duration: "+read_duration/1000000+"ms");
            System.out.println("Sum Calc    - Duration: "+path_duration/1000000+"ms");
            System.out.println("Traverse    - Duration: "+sum_of_path.traverse_time/1000000+"ms");
            System.out.println("Print       - Duration: "+sum_of_path.print_time/1000000+"ms");

        }
    }
}

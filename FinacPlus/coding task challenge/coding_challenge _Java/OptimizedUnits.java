import java.util.*;

public class OptimizedUnits {
    
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the size of Units : ");
        int n = sc.nextInt();
        int[] units = new int[n];
        System.out.print("Enter the values of Units : ");
        for(int i=0;i<n;i++)
            units[i] = sc.nextInt();
        System.out.print("Enter the max_value : ");
        int maxValue = sc.nextInt();
        int totalUnitsUsed = 0;
        int[] unitCounts = new int[maxValue + 1];

        // Dynamic programming approach to find the minimum number of units for each value
        for (int value = 1; value <= maxValue; value++) {
            int minUnits = Integer.MAX_VALUE;
            for (int unit : units) {
                if (value >= unit) {
                    minUnits = Math.min(minUnits, unitCounts[value - unit] + 1);
                }
            }
            unitCounts[value] = minUnits;
            totalUnitsUsed += minUnits;
        }

        // Calculate average units used
        double averageUnits = (double) totalUnitsUsed / maxValue;

        // Print results
        System.out.println("Units used: " + Arrays.toString(units));
        System.out.println("Average units used: " + averageUnits);
    }
}
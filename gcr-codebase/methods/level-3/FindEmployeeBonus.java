public class FindEmployeeBonus{

    static int[][] generateData(){
        int[][] data = new int[10][2];
        for(int i = 0; i < 10; i++){
            data[i][0] = (int)(Math.random() * 90000) + 10000;
            data[i][1] = (int)(Math.random() * 10) + 1;
         }
        return data;
    }

    static double[][] calculateBonus(int[][] data){
        double[][] result = new double[10][3];

        for(int i = 0; i < 10; i++){
            double bonusRate = (data[i][1] > 5) ? 0.05 : 0.02;
            double bonus = data[i][0] * bonusRate;

            result[i][0] = data[i][0];
            result[i][1] = bonus;
            result[i][2] = data[i][0] + bonus;
        }
        return result;
    }

    public static void display(double[][] result){
        double totalOld = 0, totalBonus = 0, totalNew = 0;

        for(int i = 0; i < 10; i++){
            System.out.println((i + 1) + " " + result[i][0] + " " + result[i][1] + " " + result[i][2]);

            totalOld += result[i][0];
            totalBonus += result[i][1];
            totalNew += result[i][2];
        }

	System.out.println();
        System.out.println("Total old Salary: " + totalOld);
        System.out.println("Total bonus: " + totalBonus);
        System.out.println("Total new Salary: " + totalNew);
    }

    public static void main(String[] args){
        int[][] data = generateData();
        double[][] result = calculateBonus(data);
        display(result);
    }
}
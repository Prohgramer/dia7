package com.roshka.bootcamp;

public class SumaSubarrayMasGrande {
    public static int maximoSubArray(int[] nums){
        int suma;
        int max;

        int cantidad_positivo=0;
        if(nums.length!=0) {
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i]>0){
                    cantidad_positivo+=1;
                }
            }
            if(nums.length==1)return nums[0];
            if(cantidad_positivo == 0){
                return 0;
            }
            suma = nums[0];
            max = suma;
            for(int i = 1; i < nums.length; i++) {

                suma = suma <= 0 ? nums[i] : suma + nums[i];
                if (suma > max) {
                    max = suma;
                }
            }
        }else return 0;
        return max;
    }
    public static void main(String[] as){
        System.out.println(SumaSubarrayMasGrande.maximoSubArray(new int[] {-3,-4,5,-4,10,-4}));
    }
}

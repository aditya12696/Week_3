package stacksandqueues.circulartour;
class CircularTour {

    static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, deficit = 0, surplus = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];

            // If surplus is negative, we cannot start from this pump
            if (surplus < 0) {
                start = i + 1;  // Move to the next pump
                deficit += surplus;
                surplus = 0;
            }
        }

        return (surplus + deficit >= 0) ? start : -1; // If total petrol >= total distance, return start index
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPump(petrol, distance);
        System.out.println("Starting Pump Index: " + startIndex);
    }
}


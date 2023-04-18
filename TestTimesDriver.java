
public class TestTimesDriver {
    public static void main(String[] args) {
        TestTimesInterface testTimes = new TestTimes();
    
        
        // Add some test times
        testTimes.addTestTime(123456789);
        testTimes.addTestTime(987654321);
        testTimes.addTestTime(456789012);
       
        System.out.println("Error 1" + testTimes.getMemoryUsages());
        System.out.println("Error 2"+ testTimes.getLastMemoryUsage());
        System.out.println("Error 3"+ testTimes.getAverageMemoryUsage());

       
       
        
    }
}
